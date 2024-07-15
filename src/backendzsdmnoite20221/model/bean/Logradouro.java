/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendzsdmnoite20221.model.bean;

/**
 *
 * @author ProfAlexandre
 */
public class Logradouro {
    
    private int id;
    private String Endereco;
    private String cep;
    private String num;
    private String compl;

    public Logradouro(int id) {
        this.id = id;
    }

    public Logradouro(String Endereco) {
        this.Endereco = Endereco;
    }

    public Logradouro(int id, String Endereco, String cep, String num, String compl) {
        this.id = id;
        this.cep = cep;
        this.Endereco = Endereco;
        this.num = num;
        this.compl = compl;
    }
    
    public Logradouro(String Endereco, String cep, String num, String compl) {
        this.cep = cep;
        this.Endereco = Endereco;
        this.num = num;
        this.compl = compl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getCompl() {
        return compl;
    }

    public void setCompl(String compl) {
        this.compl = compl;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Logradouro{" + "id=" + id + ", cep=" + cep + ", Endereco=" + Endereco + ", num=" + num + ", compl=" + compl + '}';
    }

    
    
    
}
