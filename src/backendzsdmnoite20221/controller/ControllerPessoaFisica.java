/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendzsdmnoite20221.controller;

import backendzsdmnoite20221.model.bean.PessoaFisica;
import backendzsdmnoite20221.model.dao.DaoPessoaFisica;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ProfAlexandre
 */
public class ControllerPessoaFisica {
    
    DaoPessoaFisica daoPf = null;

    public PessoaFisica excluir(PessoaFisica pfEntrada) throws SQLException, ClassNotFoundException {
        daoPf = new DaoPessoaFisica();
        return daoPf.excluir(pfEntrada);
    }

    public PessoaFisica alterar(PessoaFisica pfEntrada) throws SQLException, ClassNotFoundException {
        daoPf = new DaoPessoaFisica();
        return daoPf.alterar(pfEntrada);
    }

    public PessoaFisica inserir(PessoaFisica pfEntrada) throws SQLException, ClassNotFoundException {
        daoPf = new DaoPessoaFisica();
        return daoPf.inserir(pfEntrada);
    }

    public PessoaFisica buscar(PessoaFisica pfEntrada) throws SQLException, ClassNotFoundException {
        daoPf = new DaoPessoaFisica();
        return daoPf.buscar(pfEntrada);
    }

    public List<PessoaFisica> listar(PessoaFisica pfEntrada) throws SQLException, ClassNotFoundException {
        daoPf = new DaoPessoaFisica();
        return daoPf.listar(pfEntrada);
    }
    
}
