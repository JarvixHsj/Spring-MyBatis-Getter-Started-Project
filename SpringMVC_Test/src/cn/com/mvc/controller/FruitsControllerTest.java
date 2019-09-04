package cn.com.mvc.controller;

import cn.com.mvc.model.Fruits;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
/**
 * Created By xiaoweiping 2019/9/4 15:42
 **/
public class FruitsControllerTest implements Controller {
    private FruitsService fruitsService = new FruitsService();

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //模拟
        List<Fruits> fruitsList = fruitsService.queryFruitsList();
        //返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        //相当于request的setAttribut, 在JSP页面中通过fruitsList获取数据
        modelAndView.addObject("fruitsList", fruitsList);
        modelAndView.setViewName("/fruits/fruitsList");

        return modelAndView;
    }
}

class FruitsService{
    public List<Fruits> queryFruitsList() {
        List<Fruits> fruitsList = new ArrayList<>();
        Fruits apple = new Fruits();
        apple.setName("苹果");
        apple.setPrice(2.3);
        apple.setProducing_area("山东");

        Fruits Banana = new Fruits();
        Banana.setName("香蕉");
        Banana.setPrice(1.5);
        Banana.setProducing_area("上海");

        fruitsList.add(apple);
        fruitsList.add(Banana);
        return fruitsList;
    }
}