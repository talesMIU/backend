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
public class PessoaFisica extends Pessoa{
    
     private String cpf;
    private String tipo;
    private String email;

    public PessoaFisica(int id) {
        super(id);
    }

    public PessoaFisica(String nome) {
        super(nome);
    }

    public PessoaFisica(String nome, String cpf, String tipo, String email) {
        super(nome);
        this.cpf = cpf;
        this.tipo = tipo;
        this.email = email;
    }

    public PessoaFisica(int id, String nome, String cpf, String tipo, String email) {
        super(id, nome);
        this.cpf = cpf;
        this.tipo = tipo;
        this.email = email;
    }

    @Override
    public String toString() {
        String msgP = "Pessoa{" + "id=" + getId() + ", nome=" + getNome() + '}';
        String msgPf = "PessoaFisica{" + "cpf=" + cpf + ", tipo=" + tipo + ", email=" + email + '}';
        String msgReturn = msgP + msgPf;
        return msgReturn;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
} 
