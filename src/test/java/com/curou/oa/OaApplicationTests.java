package com.curou.oa;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OaApplicationTests {

    @Autowired
    ProcessEngine processEngine;

    @Test
    public void contextLoads() {
        Deployment deployment = processEngine.getRepositoryService().createDeployment().addClasspathResource("processes/myProcess.bpmn").addClasspathResource("processes/myProcess.png").deploy();
        System.out.println("部署ID："+deployment.getId());//1
        System.out.println("部署时间："+deployment.getDeploymentTime());
    }

}
