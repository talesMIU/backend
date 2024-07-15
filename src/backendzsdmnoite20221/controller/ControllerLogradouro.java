/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendzsdmnoite20221.controller;

import backendzsdmnoite20221.model.bean.Logradouro;
import backendzsdmnoite20221.model.dao.DaoLogradouro;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ProfAlexandre
 */
public class ControllerLogradouro {
    
    DaoLogradouro daoLog;
    
    public Logradouro inserir(Logradouro l) throws SQLException, ClassNotFoundException {
        daoLog = new DaoLogradouro();
        return daoLog.inserir(l);
    }

    public List<Logradouro> listar(Logradouro l) throws SQLException, ClassNotFoundException {
        daoLog = new DaoLogradouro();
        return daoLog.listar(l);
    }

    public Logradouro alterar(Logradouro l) throws SQLException, ClassNotFoundException {
        daoLog = new DaoLogradouro();
        return daoLog.alterar(l);
    }

    public Logradouro buscar(Logradouro l) throws SQLException, ClassNotFoundException {
        daoLog = new DaoLogradouro();
        return daoLog.buscar(l);
    }

    public Logradouro excluir(Logradouro l) throws SQLException, ClassNotFoundException {
        daoLog = new DaoLogradouro();
        return daoLog.excluir(l);
    }
    
}
