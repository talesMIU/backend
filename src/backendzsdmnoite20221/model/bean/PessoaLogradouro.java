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
public class PessoaLogradouro {
    
    private int id;
    private int idP;
    private int idL;
    private String obs;
    private PessoaFisica pf;
    private Logradouro log;

    public PessoaLogradouro(int id) {
        this.id = id;
    }

    public PessoaLogradouro(String obs) {
        this.obs = obs;
    }
    
    
    public PessoaLogradouro(int idP, int idL, String obs) {
        this.idP = idP;
        this.idL = idL;
        this.obs = obs;
    }

    public PessoaLogradouro(int id, int idP, int idL, String obs) {
        this.id = id;
        this.idP = idP;
        this.idL = idL;
        this.obs = obs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public int getIdL() {
        return idL;
    }

    public void setIdL(int idL) {
        this.idL = idL;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public PessoaFisica getPf() {
        return pf;
    }

    public void setPf(PessoaFisica pf) {
        this.pf = pf;
    }

    public Logradouro getLog() {
        return log;
    }

    public void setLog(Logradouro log) {
        this.log = log;
    }

    @Override
    public String toString() {
        String retorno = "";
        String msgP = "null" ;
        String msgL = "null" ;
        if(this.pf != null) {
            msgP = pf.toString() + "\n";
        }
        if(this.log != null) {
            msgL = log.toString() + "\n";
        }
        
        String msgPL = "PessoaLogradouro{" + "id=" + id + ", idP=" + idP + ", idL=" + idL + ", obs=" + obs + '}';
        retorno = msgP + " " + msgL + " " + msgPL;
                
        return retorno;
    }
        
}
