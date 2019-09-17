package cn.com.mvc.controller;

import cn.com.mvc.model.Fruits;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created By xiaoweiping 2019/9/6 15:27
 **/
public class FruitsControllerJsonTest2 implements HttpRequestHandler {

    private FruitsService fruitsService = new FruitsService();

    @Override
    public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        //模拟Service 获-取商品列表
        List<Fruits> fruitsList = fruitsService.queryFruitsList();
        //将fruitsList装换为Json串
        String jsonInfo = convertListToJson(fruitsList);
        //设置返回格式
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("application/json;charset=utf-8");
        //写出json串
        httpServletResponse.getWriter().write(jsonInfo);
    }

    private String convertListToJson(List<Fruits> fruitsList){
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        for (Fruits fruits:fruitsList){
            builder.append('{');
            builder.append("\"name\":\"").append(fruits.getName()).append("\",");
            builder.append("\"price\":\"").append(fruits.getPrice()).append("\",");
            builder.append("\"producing_area\":\"").append(fruits.getProducing_area()).append("\"");
            builder.append("},");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append(']');
        return builder.toString();
    }
}
