package com.curou.oa.controller;

import com.curou.oa.entity.TableBase;
import com.curou.oa.entity.UserSearch;
import com.curou.oa.models.User;
import com.curou.oa.service.RoleService;
import com.curou.oa.service.UserService;
import com.curou.oa.utils.Exception.AjaxException;
import com.curou.oa.vo.request.UserDataReq;
import com.curou.oa.vo.response.UserDataRes;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Value("${password.default}")
    private String defaultPassword;

    @Value("${password.algorithm}")
    private String defaultAlgorithm;

    @Value("${password.count}")
    private int defaultCount;


    /**
     * 添加用户
     *
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public Map<String,String> add(@RequestBody UserDataReq userDataReq) {
        Map<String, String> map = new HashMap<>();
        if (StringUtils.isBlank(userDataReq.getAccount())) {
            throw new AjaxException("请输入用户名");
        } else {
            Boolean check = userService.checkAccount(userDataReq);
            if (!check) {
                throw new AjaxException("该用户名已存在");
            }
        }
        //新增没填密码 默认密码
        if (StringUtils.isBlank(userDataReq.getPassword())) {
            //加密
            Object obj = new SimpleHash(defaultAlgorithm, defaultPassword, null, defaultCount);
            userDataReq.setPassword(obj.toString());
        } else {
            Object obj = new SimpleHash(defaultAlgorithm, userDataReq.getPassword(), null, defaultCount);
            userDataReq.setPassword(obj.toString());
        }
        if (StringUtils.isBlank(userDataReq.getMobilePhone())) {
            throw new AjaxException("请输入手机号");
        }
        try {
            userService.add(userDataReq);
        } catch (Exception e) {
            map.put("result", "error");
            return map;
        }
        map.put("result", "success");
        return map;
    }


    @PostMapping("/eidtUser")
    @ResponseBody
    public Map<String,String> eidtUser(@RequestBody UserDataReq userDataReq) {
        Map<String, String> map = new HashMap<>();
        Boolean check = userService.checkAccount(userDataReq);
        if (!check) {
            throw new AjaxException("该用户名已存在");
        }
        userService.update(userDataReq);
        map.put("result", "success");
        return map;
    }



    @PostMapping("/delete")
    @ResponseBody
    public Map<String,String> edit(@RequestBody List<String> ids) {
        Map<String, String> map = new HashMap<>();
        for (String id: ids) {
            if (id.equals("0")){
                throw new AjaxException("超级管理员不能被删除");
            }
        }
        userService.del(ids);
        map.put("success", "1");
        return map;
    }

    /**
     * 获取用户列表数据
     *
     * @return
     */
    @GetMapping("/list")
    @ResponseBody
    public TableBase list(UserSearch search) {
        PageHelper.startPage(search.getPage(), search.getLimit());
        List<UserDataRes> list = userService.list(search);
        PageInfo pageInfo = new PageInfo<>(list, search.getLimit());
        TableBase tableBase = new TableBase();
        tableBase.setData(list);
        tableBase.setCode(0);
        tableBase.setMsg("");
        tableBase.setCount(pageInfo.getTotal());
        return tableBase;
    }


    /**
     * 用户修改资料
     *
     * @return
     */
    @GetMapping("/userEdit")
    public String userEditButton(ModelMap modelAndView) {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        if (user == null) {
            return "login";
        }
        modelAndView.put("info", userService.getById(user.getId()));
        modelAndView.put("isUser", "true");
        return "view/user/add";
    }
}
