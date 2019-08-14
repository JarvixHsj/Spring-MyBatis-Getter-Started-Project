package cn.com.mybatis.po;

import java.util.Date;

/**
 * Created By xiaoweiping 2019/8/14 11:38
 **/
public class FinacialProduct {
    private int product_id;
    private String name;
    private int price;
    private String detail;
    private String imgpath;

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public Date getInvattime() {
        return invattime;
    }

    public void setInvattime(Date invattime) {
        this.invattime = invattime;
    }

    private Date invattime;
}
