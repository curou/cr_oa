package com.curou.oa.controller;

import com.curou.oa.entity.ReimburseSearch;
import com.curou.oa.entity.TableBase;
import com.curou.oa.enums.ReimburseType;
import com.curou.oa.models.Reimburse;
import com.curou.oa.models.User;
import com.curou.oa.service.ReimburseService;
import com.curou.oa.utils.ListUtils;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

@Controller
public class ReimburseController {

    @Autowired
    ReimburseService service;

    @Autowired
    TaskService taskService;

    @Autowired
    RuntimeService runtimeService;

    @Autowired
    RepositoryService repositoryService;

    @Autowired
    HistoryService historyService;


    @RequestMapping("addReimburse")
    @ResponseBody
    public Map<String,Object> add(@RequestBody Reimburse reimburse){
        //根据bpmn文件部署流程
        Map<String, Object> map = new HashMap<>();
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
//        String userId = user.getUserId();
//        String userName = user.getUserName();
        String id = UUID.randomUUID().toString();
        reimburse.setUserId(user.getId());
        reimburse.setUserName(user.getName());
        reimburse.setId(id);
        reimburse.setCreateTimeUtc(new Date());
        reimburse.setModifyTimeUtc(new Date());
        reimburse.setStatus(ReimburseType.IN_TRANSIT.getType());


        ProcessInstance pi = runtimeService.startProcessInstanceByKey("myProcess", id);
        Task task = taskService.createTaskQuery().processInstanceBusinessKey(id).singleResult();
        taskService.claim(task.getId(),reimburse.getUserId());
        taskService.complete(task.getId());
        Task task2 = taskService.createTaskQuery().processInstanceBusinessKey(id).singleResult();
        taskService.claim(task2.getId(),"2");
        reimburse.setTaskId(task2.getId());
        service.add(reimburse);
        map.put("result", "success");
        return map;
    }

    @RequestMapping("submitReimburseAgain")
    @ResponseBody
    public Map<String,Object> submitReimburseAgain(@RequestBody Reimburse reimburse){
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");

        //根据bpmn文件部署流程
        Map<String, Object> map = new HashMap<>();
        reimburse.setStatus(ReimburseType.IN_TRANSIT.getType());

        Task task = taskService.createTaskQuery().processInstanceBusinessKey(reimburse.getId()).singleResult();
        taskService.complete(task.getId());
        Task task2 = taskService.createTaskQuery().processInstanceBusinessKey(reimburse.getId()).singleResult();
        taskService.claim(task2.getId(),"2");
        reimburse.setTaskId(task2.getId());
        List<Reimburse> list = new ArrayList<>();
        list.add(reimburse);
        service.update(list);
        map.put("result", "success");
        return map;
    }


    //删除流程实例
    @RequestMapping("deleteProcessInstance")
    @ResponseBody
    public Map<String,Object> deleteProcessInstance(String reimburseId) throws IOException {
        Task task = taskService.createTaskQuery()
                .processInstanceBusinessKey(reimburseId).singleResult();
        String taskId = task.getProcessInstanceId();
        runtimeService.deleteProcessInstance(taskId, reimburseId);
        Map<String, Object> map = new HashMap<>();
        map.put("result", "success");
        return map;
    }

    //根据用户ID获得审批完成列表
    @RequestMapping("getReimburse")
    @ResponseBody
    public TableBase<Reimburse> getReimburse(ReimburseSearch reimburseSearch) throws IOException {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        String userId = user.getId();
        List<Reimburse> resultList = new ArrayList<>();
        List<HistoricProcessInstance> list = null;
        Long total  = null;
        if(reimburseSearch.getStatus().equals(ReimburseType.COMPLETE.getType())){
            list = historyService.createHistoricProcessInstanceQuery().orderByProcessInstanceStartTime().desc().finished().involvedUser(userId).listPage((reimburseSearch.getPage()-1)*reimburseSearch.getLimit(),reimburseSearch.getLimit());
            total = historyService.createHistoricProcessInstanceQuery().finished().count();
        }else{
            list = historyService.createHistoricProcessInstanceQuery().orderByProcessInstanceStartTime().desc().unfinished().involvedUser(userId).listPage((reimburseSearch.getPage()-1)*reimburseSearch.getLimit(),reimburseSearch.getLimit());
            total = historyService.createHistoricProcessInstanceQuery().unfinished().count();
        }
        for (HistoricProcessInstance historicProcessInstance : list) {
            String reimburseId = historicProcessInstance.getBusinessKey();
            Reimburse reimburse = service.getById(reimburseId);
            resultList.add(reimburse);

        }
        TableBase<Reimburse> table = new TableBase<>();
        table.setCode(0);
        table.setData(resultList);
        table.setMsg("");
        table.setCount(total);
        return table;
    }


    //根据用户ID获得受委托的流程
    @RequestMapping("getReimburseByAssignee")
    @ResponseBody
    public TableBase<Reimburse> getReimburseByAssignee(ReimburseSearch reimburseSearch) throws IOException {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        String userId = user.getId();
        List<Reimburse> resultList = new ArrayList<>();
        List<Task> list = null;
        Long count = null;
        if(reimburseSearch.getKeyword()!=null){
            list = taskService.createTaskQuery().orderByTaskCreateTime().desc().taskAssignee(userId).list();
            List<Reimburse> temp = new ArrayList<>();
            for (Task task : list) {
                String pid = task.getProcessInstanceId();
                ProcessInstance p = runtimeService.createProcessInstanceQuery().processInstanceId(pid).singleResult();
                String reimburseId = p.getBusinessKey();
                Reimburse reimburse = service.getById(reimburseId);
                if(reimburse.getUserName().equals(reimburseSearch.getKeyword())){
                    reimburse.setTaskId(task.getId());
                    temp.add(reimburse);
                }
            }
            count = Long.valueOf(temp.size());
            int index = (reimburseSearch.getPage() - 1) * reimburseSearch.getLimit();
            if(count>=reimburseSearch.getLimit()){
                for (int i = 0; i < reimburseSearch.getLimit(); i++) {
                    resultList.add(temp.get(index+i));
                }
            }
            if(count<reimburseSearch.getLimit()){
                for (int i = 0; i < count; i++) {
                    resultList.add(temp.get(index+i));
                }
            }

        }else {
            list = taskService.createTaskQuery().orderByTaskCreateTime().desc().taskAssignee(userId).listPage((reimburseSearch.getPage()-1)*reimburseSearch.getLimit(),reimburseSearch.getLimit());
            count = taskService.createTaskQuery().taskAssignee(userId).count();
            for (Task task : list) {
                String pid = task.getProcessInstanceId();
                ProcessInstance p = runtimeService.createProcessInstanceQuery().processInstanceId(pid).singleResult();
                String reimburseId = p.getBusinessKey();
                Reimburse reimburse = service.getById(reimburseId);
                reimburse.setTaskId(task.getId());
                resultList.add(reimburse);
            }
        }

        TableBase<Reimburse> table = new TableBase<>();
        table.setCode(0);
        table.setData(resultList);
        table.setMsg("");
        table.setCount(count);
        return table;
    }

    //通过审批
    @RequestMapping("completeReimburse")
    @ResponseBody
    public Map<String,Object> completeReimburse(@RequestBody Reimburse reimburse){
        reimburse.setStatus(ReimburseType.COMPLETE.getType());
        List<Reimburse> list = new ArrayList<>();
        list.add(reimburse);
        service.update(list);
        Map<String, Object> map = new HashMap<>();
        map.put("agree", true);
        taskService.complete(reimburse.getTaskId(), map);
        map.put("result", "success");
        return map;
    }
    //驳回
    @RequestMapping("overruledReimburse")
    @ResponseBody
    public Map<String,Object> overruledReimburse(@RequestBody Reimburse reimburse){
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        Map<String, Object> map = new HashMap<>();
        map.put("agree", false);

        //设置审批信息
//        Authentication.setAuthenticatedUserId(user.getUserName());
        String processInstanceId = taskService.createTaskQuery().taskId(reimburse.getTaskId()).singleResult().getProcessInstanceId();
        taskService.addComment(reimburse.getTaskId(), processInstanceId, reimburse.getRemark());
        //完成当前任务并将审批信息传入
        taskService.complete(reimburse.getTaskId(), map);
        //开启一个新的任务并让创建人领取
        Task task = taskService.createTaskQuery().processInstanceBusinessKey(reimburse.getId()).singleResult();
        taskService.claim(task.getId(),reimburse.getUserId());
        //报销单状态改为驳回
        reimburse.setStatus(ReimburseType.OVERRULED.getType());
        //更新报销单的taskId
        reimburse.setTaskId(task.getId());
        List<Reimburse> list = new ArrayList<>();
        list.add(reimburse);
        service.update(list);
        map.put("result", "success");
        return map;
    }


    //更新表单
    @RequestMapping("updateReimburse")
    @ResponseBody
    public Map<String,Object> update(@RequestBody List<Reimburse> list){
        Map<String, Object> map = new HashMap<>();
        service.update(list);
        map.put("result", "success");
        return map;
    }

    //获得审批信息
    @RequestMapping("getComment")
    @ResponseBody
    public List<Comment> getComment(String taskId){
        List<Comment> commentList = new ArrayList<>();
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        //获得流程实例ID
        String processInstanceId = task.getProcessInstanceId();
        //根据流程实例ID获得历史任务
        List<HistoricTaskInstance> list = historyService.createHistoricTaskInstanceQuery().processInstanceId(processInstanceId).orderByHistoricTaskInstanceEndTime().desc().list();
        //遍历历史任务的ID取得历史审批信息

        if(ListUtils.isNotNullOrEmpty(list)){
            for (HistoricTaskInstance historicTaskInstance : list) {
                String id = historicTaskInstance.getId();
                List<Comment> temp = taskService.getTaskComments(id);
                commentList.addAll(temp);
            }
        }
        //另一种方法获得审批信息
        //commentList = taskService.getProcessInstanceComments(processInstanceId);
        return commentList;
    }

    //查看当前流程图
    @RequestMapping("getImg")
    public String getImg(String taskId, HttpServletResponse response)throws Exception{
        String processDefinitionId = historyService.createHistoricTaskInstanceQuery().taskId(taskId).singleResult().getProcessDefinitionId();
        String deploymentId = repositoryService.createProcessDefinitionQuery().processDefinitionId(processDefinitionId).singleResult().getDeploymentId();
        List<String> list = repositoryService.getDeploymentResourceNames(deploymentId);

        //定义图片资源的名称
        String resourceName = "";
        if(list!=null && list.size()>0){
            for(String name:list){
                if(name.indexOf(".png")>=0){
                    resourceName = name;
                }
            }
        }

        //获取图片的输入流
        InputStream in = repositoryService.getResourceAsStream(deploymentId, resourceName);
        OutputStream out = response.getOutputStream();
        //4：将输入流中的数据读取出来，写到输出流中
        for(int b=-1;(b=in.read())!=-1;){
            out.write(b);
        }
        out.close();
        in.close();
        return null;
    }

    //查看当前流程图
    @RequestMapping("viewCurrentImage")
    public String viewCurrentImage(String taskId, Model model) throws Exception{
        //存放坐标
		Map<String, Object> map = new HashMap<String,Object>();
		//使用任务ID，查询任务对象
		Task task = taskService.createTaskQuery()//
					.taskId(taskId)//使用任务ID查询
					.singleResult();
		//获取流程定义的ID
		String processDefinitionId = task.getProcessDefinitionId();
		//获取流程定义的实体对象（对应.bpmn文件中的数据）
		ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity)repositoryService.getProcessDefinition(processDefinitionId);
		//流程实例ID
		String processInstanceId = task.getProcessInstanceId();
		//使用流程实例ID，查询正在执行的执行对象表，获取当前活动对应的流程实例对象
		ProcessInstance pi = runtimeService.createProcessInstanceQuery()//创建流程实例查询
					.processInstanceId(processInstanceId)//使用流程实例ID查询
					.singleResult();
		//获取当前活动的ID
		String activityId = pi.getActivityId();
		//获取当前活动对象
		ActivityImpl activityImpl = processDefinitionEntity.findActivity(activityId);//活动ID
		//获取坐标
		map.put("x", activityImpl.getX());
		map.put("y", activityImpl.getY());
		map.put("width", activityImpl.getWidth());
		map.put("height", activityImpl.getHeight());
        model.addAttribute("info", map);
        return "img";
    }

    @RequestMapping("deleteReimburse")
    @ResponseBody
    public Map<String,Object> delete(@RequestBody List<String> list){
        Map<String, Object> map = new HashMap<>();
        service.delete(list);
        map.put("result", "success");
        return map;
    }
}
