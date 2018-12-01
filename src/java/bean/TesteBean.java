/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;


/**
 *
 * @author gusta
 */
@Named(value = "testeBean")
@SessionScoped
public class TesteBean implements Serializable{

     private Integer titEleitor;
    private String senha;
    public void oi(){
        System.out.println("Oiii");
    }
    public TesteBean() {
    }

    public Integer getTitEleitor() {
        return titEleitor;
    }

    public void setTitEleitor(Integer titEleitor) {
        this.titEleitor = titEleitor;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
