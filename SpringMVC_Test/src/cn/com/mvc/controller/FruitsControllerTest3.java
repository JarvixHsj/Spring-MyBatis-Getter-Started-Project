package cn.com.mvc.controller;

import cn.com.mvc.model.Fruits;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

/**
 * Created By xiaoweiping 2019/9/17 15:27
 **/
//注解的Handler类
//使用@Controller来标识他是一个控制器
@Controller
public class FruitsControllerTest3 {

    private FruitsService fruitsService = new FruitsService();

    @RequestMapping("/queryFruitsList")
    public ModelAndView queryFruitsList() throws Exception{
        //模拟Service 获-取商品列表
        List<Fruits> fruitsList = fruitsService.queryFruitsList();
        //返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        //相当于request的setAttribut，在JSP页面中通过fruitsList获取数据
        modelAndView.addObject("fruitsList",fruitsList);
        //指定视图
        modelAndView.setViewName("/fruits/fruitsList");
        return modelAndView;
    }
}
