package cn.com.mvc.controller;

import cn.com.mvc.model.Fruits;
import cn.com.mvc.service.FruitsService;
import cn.com.mvc.service.FruitsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created By xiaoweiping 2019/9/23 17:28
 **/
@Controller
@RequestMapping("query")
public class FindControllerTest {

    private FruitsService fruitsService = new FruitsServiceImpl();

    @RequestMapping("                                                                                                            ")
    public String queryFruitsByCondition(Model model, Fruits fruits) throws UnsupportedEncodingException {
        List<Fruits> findList = null;

        if(fruits == null || (fruits.getName() == null && fruits.getProducing_area() == null)){
            //如果fruits或查询条件为空，默认查询所有数据
            findList = fruitsService.queryFruitsList();
        }else{
            //如果fruits查询条件不为空，按条件查询
            findList = fruitsService.queryFruitsByCondition(fruits);
        }
        //将model数据传到页面
        model.addAttribute("fruitsList",findList);
        return "/fruits/findFruits";
    }
}
