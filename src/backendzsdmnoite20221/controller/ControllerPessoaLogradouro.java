/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendzsdmnoite20221.controller;

import backendzsdmnoite20221.model.bean.Logradouro;
import backendzsdmnoite20221.model.bean.PessoaFisica;
import backendzsdmnoite20221.model.bean.PessoaLogradouro;
import backendzsdmnoite20221.model.dao.DaoPessoaLogradouro;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author ProfAlexandre
 */
public class ControllerPessoaLogradouro {
    
    DaoPessoaLogradouro daoPl = null;

    public PessoaLogradouro excluir(PessoaLogradouro plEntrada) throws SQLException, ClassNotFoundException {
        daoPl = new DaoPessoaLogradouro();
        return daoPl.excluir(plEntrada);
    }

    public PessoaLogradouro alterar(PessoaLogradouro plEntrada) throws SQLException, ClassNotFoundException {
        daoPl = new DaoPessoaLogradouro();
        return daoPl.alterar(plEntrada);
    }

    public List<PessoaLogradouro> listar(PessoaLogradouro plEntrada) throws SQLException, ClassNotFoundException {
        daoPl = new DaoPessoaLogradouro();
        List<PessoaLogradouro> listapl = daoPl.listar(plEntrada);
        List<PessoaLogradouro> listaplAux = new ArrayList<>();
        for (PessoaLogradouro pl : listapl) {
            listaplAux.add(buscar(pl));
        }
        return listaplAux;
    }

    public PessoaLogradouro buscar(PessoaLogradouro plEntrada) throws SQLException, ClassNotFoundException {
        daoPl = new DaoPessoaLogradouro();
        PessoaLogradouro pl = daoPl.buscar(plEntrada);

        ControllerPessoaFisica contP = new ControllerPessoaFisica();
        PessoaFisica pfEntrada = new PessoaFisica(pl.getIdP());
        pl.setPf(contP.buscar(pfEntrada));
        
        ControllerLogradouro contL = new ControllerLogradouro();
        Logradouro lEntrada = new Logradouro(pl.getIdL());
        pl.setLog(contL.buscar(lEntrada));
        
        return pl;
    }

    public PessoaLogradouro inserir(PessoaLogradouro plEntrada) throws SQLException, ClassNotFoundException {
        daoPl = new DaoPessoaLogradouro();
        return daoPl.inserir(plEntrada);
    }
    
}
