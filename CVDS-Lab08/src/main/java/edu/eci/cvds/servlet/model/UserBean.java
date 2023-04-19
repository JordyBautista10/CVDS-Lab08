package edu.eci.cvds.servlet.model;

import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@Component
@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean {
    private String name;

    public UserBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
