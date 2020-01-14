package cn.com.mvc.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created By xiaoweiping 2020/1/14 16:35
 **/
public class UserExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //1.解析出异常类型
        UserException userException = null;
        if (e instanceof UserException) {
            //2.如果该异常类型是系统自定义的异常，直接取出异常信息，在错误页面展示
            userException = (UserException) e;
        } else {
            //3.如果该异常类型不是系统自定义的异常，构造一个自定义的异常类型（信息为“未知错误”）
            userException = new UserException("未知异常");
        }
        //错误信息
        String message = userException.getMessage();
        ModelAndView modelAndView= new ModelAndView();
        //将错误信息传导页面
        modelAndView.addObject("message", message);
        //指向到错误界面
        modelAndView.setViewName("/errorPage/userError");

        return modelAndView;
    }
}
