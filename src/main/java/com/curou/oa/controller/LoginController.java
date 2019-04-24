package com.curou.oa.controller;

import com.curou.oa.entity.SearchBase;
import com.curou.oa.models.Menu;
import com.curou.oa.models.ProductUnit;
import com.curou.oa.models.Stock;
import com.curou.oa.models.User;
import com.curou.oa.service.LoginService;
import com.curou.oa.service.ProductUnitService;
import com.curou.oa.service.StockService;
import com.curou.oa.utils.Exception.AjaxException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author lxr
 * @version v0.01
 * @date 2019/3/18
 * @email 200890949@qq.com
 */

@SuppressWarnings("ALL")
@Controller
public class LoginController {

    @Autowired
    private LoginService service;

    @Autowired
    private MenuController menuController;

    @Autowired
    private StockService stockService;

    @Autowired
    private ProductUnitService productUnitService;

    /**
     * 跳转登陆页面
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "/login";
    }

    /**
     * 跳转注册页面
     * @return
     */
    @RequestMapping("/register")
    public String register(){
        return "/register";
    }

    /**
     * 跳转主页
     * @return
     */
    @RequestMapping("/")
    public String index(ModelMap modelMap){
        User user = (User)SecurityUtils.getSubject().getSession().getAttribute("user");
        SearchBase searchBase = new SearchBase();
        List<List<Menu>> lists = menuController.initMenu();
        List<Stock> stocks = stockService.getAllStock();
        List<ProductUnit> units = productUnitService.getAll(searchBase);
        modelMap.addAttribute("stocks",stocks);
        modelMap.addAttribute("lists", lists);
        modelMap.addAttribute("userInfo",user);
        modelMap.addAttribute("units",units);
        return "/index";
    }

    /**
     * 跳转主页
     * @return
     */
    @RequestMapping("/test")
    public String test(){
        return "/view/index";
    }

    /**
     * 检查用户名密码
     * @return
     */
    @GetMapping("/checkLogin")
    @ResponseBody
    public String checkLogin(Model model,
                             @RequestParam(value = "account",required = true) String userName,
                             @RequestParam(value = "password",required = true) String passWord){
        try {
            //组装用户名和密码对象
            UsernamePasswordToken token = new UsernamePasswordToken(userName, passWord);
            //获取主体  通过Security创建Subject
            Subject sub = SecurityUtils.getSubject();
            //发起请求(通过配置的shiroRelm来与service验证)
            sub.login(token);
            //请求成功
            return "success";
        }catch (Exception e){
            //错误会抛异常
            if (e.getCause()!=null && e.getCause().getMessage()!=null) {
                throw new AjaxException(e.getCause().getMessage());
            }
            return "error";
        }
    }

    /**
     * 检查用户名密码
     * @return
     */
    @RequestMapping("/loginOut")
    public String loginOut(){
            //获取主体  通过Security创建Subject
            Subject sub = SecurityUtils.getSubject();
            //发起请求(通过配置的shiroRelm来与service验证)
            sub.logout();
            //请求成功
            return "login";
    }
}
