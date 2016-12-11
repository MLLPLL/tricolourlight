package com.myself.server.entity;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Alex.Chen on 2016/12/8.
 */
@Entity
public class Account implements Serializable {
    private static final long serialVersionUID = -5395094432321833202L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private String userName;

    private String password;

    private String token;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
