package cn.com.mvc.service;

import cn.com.mvc.model.Fruits;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface FruitsService {
    public List<Fruits> queryFruitsList();

    public Fruits queryFruitById(Integer id);

    public List<Fruits> queryFruitsByCondition(Fruits fruits) throws UnsupportedEncodingException;
}
