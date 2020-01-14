package cn.com.mvc.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created By xiaoweiping 2019/9/4 15:45
 **/
public class Fruits {
    private int id;
    @Length(min = 1,max = 2,message = "fruits.name.length.error")
    private String name;
    private double price;
    @NotNull(message = "fruits.producing_area.isEmpty")
    private String producing_area;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProducing_area() {
        return producing_area;
    }

    public void setProducing_area(String producing_area) {
        this.producing_area = producing_area;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
