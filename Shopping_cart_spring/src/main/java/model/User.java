package model;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "User entity", description = "Complete info of a entity user")
public class User {

    @ApiModelProperty(value = "The id of the user")
    private int id;
    @ApiModelProperty(value = "The name of the user", required = true)
    private String name;
    @ApiModelProperty(value = "The lastname of the user", required = true)
    private String lastname;
    @ApiModelProperty(value = "The address of the user", required = true)
    private String address;
    @ApiModelProperty(value = "The phone of the user", required = true)
    private String phone;
    @ApiModelProperty(value = "The nickname of the user", required = true)
    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public User() {
    }

    public User(int id, String name, String lastname, String address, String phone, String nickname) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.phone = phone;
        this.nickname = nickname;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
