package model;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "product entity", description = "Complete info of a entity product")
public class Product {

    @ApiModelProperty(value = "The id of the product")
    private int id;
    @ApiModelProperty(value = "The name of the product", required = true)
    private String name;
    @ApiModelProperty(value = "The description of the product", required = true)
    private String description;
    @ApiModelProperty(value = "The pridce of the product", required = true)
    private double price;

    public Product() {
    }

    public Product(int id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
