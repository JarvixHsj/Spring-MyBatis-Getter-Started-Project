package cn.com.mvc.service;

import cn.com.mvc.model.Fruits;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created By xiaoweiping 2019/9/23 17:41
 **/
public class FruitsServiceImpl implements FruitsService {
    public List<Fruits> fruitsList = null;
    public List<Fruits> init(){
        if (fruitsList == null){
            //初始化数据
            fruitsList = new ArrayList<Fruits>();
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
        }else{
            return fruitsList;
        }
    }

    @Override
    public List<Fruits> queryFruitsList() {
        init();
        return  fruitsList;
    }

    @Override
    public Fruits queryFruitById(Integer id) {
        return null;
    }

    @Override
    public List<Fruits> queryFruitsByCondition(Fruits fruits) throws UnsupportedEncodingException {
        init();
        String name = fruits.getName();
        String area = fruits.getProducing_area();
//        String name = new String(((String) fruits.getName()).trim().getBytes("ISO-8859-1"), "UTF-8");
//        String area = new String(((String) fruits.getProducing_area()).trim().getBytes("ISO-8859-1"), "UTF-8");
        List<Fruits> queryList = new ArrayList<Fruits>();
        Fruits f;
        for (int i = 0; i < fruitsList.size(); i++) {
            f = fruitsList.get(i);
            //有一项符合条件就返回
            if ((!name.equals("") && f.getName().contains(name)) ||
                    (!area.equals("") && f.getProducing_area().contains(area))){
                queryList.add(f);
            }
        }
        return queryList.size()>0 ? queryList : null;
    }
}
