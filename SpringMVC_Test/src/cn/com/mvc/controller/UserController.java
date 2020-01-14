package cn.com.mvc.controller;

import cn.com.mvc.exception.UserException;
import cn.com.mvc.model.User;
import cn.com.mvc.validator.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

/**
 * Created By xiaoweiping 2020/1/14 14:54
 **/
@Controller
@RequestMapping("user")
public class UserController {
    @InitBinder
    public void initBinder(DataBinder binder) {
        binder.setValidator(new UserValidator());
    }

    @RequestMapping("login")
    public String login(Model model, @Valid User user, BindingResult bindingResult) throws UserException {
        //查询用户是否黑名单用户
//        boolean isBlackUser = checkBlackList(user);
//        //如果用户是黑名单，抛出异常，结束程序
//        if (isBlackUser) {
//            throw new UserException("无权限访问!");
//        }
//        //登录检测
//        List<ObjectError> allErrors = null;
//        if (bindingResult.hasErrors()) {
//            allErrors = bindingResult.getAllErrors();
//            for (ObjectError objectError:allErrors) {
//                //输出错误信息
//                System.out.println("code=" + objectError.getCode() + " DefaultMessage= " + objectError.getDefaultMessage());
//                //或将错误传到页面
//                model.addAttribute("allErrors", allErrors);
//            }
            return "/user/login";
//        }else{
//            return "/user/loginSuccess";
//        }
    }
    @RequestMapping("loginHandle")
    public String loginHandle(Model model, @Valid User user, BindingResult bindingResult) throws UserException {
        //查询用户是否黑名单用户
        boolean isBlackUser = checkBlackList(user);
        //如果用户是黑名单，抛出异常，结束程序
        if (isBlackUser) {
            throw new UserException("user.not.have.power");
        }
        //登录检测
        List<ObjectError> allErrors = null;
        if (bindingResult.hasErrors()) {
            allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError:allErrors) {
                //输出错误信息
                System.out.println("code=" + objectError.getCode() + " DefaultMessage= " + objectError.getDefaultMessage());
                //或将错误传到页面
                model.addAttribute("allErrors", allErrors);
            }
            return "/user/login";
        }else{
            return "/user/loginSuccess";
        }
    }


    private boolean checkBlackList(User user) {
        String blackArray[] = {"jack", "tom","jean"};
        for (int i = 0; i<blackArray.length; i++) {
            if (user.getUsername().equals(blackArray[i])) {
                return true;
            }
        }
        return false;
    }
}
