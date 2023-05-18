package edu.eci.cvds.servlet.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@Component
@ManagedBean(name = "userBean")
@ApplicationScoped
public class UserBean {
    @Autowired
    ConfigurationService configurationService;
    @Autowired
    GuessBean guessBean;
    private String name;

    public UserBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String login(int prem, int erro){
        configurationService.addConfiguration(new Configuration("premio",prem));
        configurationService.addConfiguration(new Configuration("error",erro));
        guessBean.start();
        return "guess.xhtml";
    }
}
