/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendzsdmnoite20221.model.dao;

import backendzsdmnoite20221.model.bean.PessoaLogradouro;
import backendzsdmnoite20221.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ProfAlexandre
 */
public class DaoPessoaLogradouro {
    
    private final Connection c;
    
    public DaoPessoaLogradouro() throws SQLException, ClassNotFoundException{
        this.c = new Conexao().getConnection();
    }

    public PessoaLogradouro excluir(PessoaLogradouro plEntrada) throws SQLException {
        String sql = "delete from pessoas_logradouros WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,plEntrada.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return plEntrada;
    }

    public PessoaLogradouro alterar(PessoaLogradouro plEntrada) throws SQLException {
        String sql = "UPDATE pessoas_logradouros SET idPes = ?, idLog = ?, observacao = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,plEntrada.getIdP());
        stmt.setInt(2,plEntrada.getIdL());
        stmt.setString(3,plEntrada.getObs());
        stmt.setInt(4,plEntrada.getId());

        // executa
        stmt.execute();
        stmt.close();
        return plEntrada;

    }

    public List<PessoaLogradouro> listar(PessoaLogradouro plEntrada) throws SQLException {
            // usus: array armazena a lista de registros

        List<PessoaLogradouro> listapl = new ArrayList<>();
        
        String sql = "select * from pessoas_logradouros where observacao like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + plEntrada.getObs() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            PessoaLogradouro pl = new PessoaLogradouro(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getString(4)
            );
            // adiciona o usu à lista de usus
            listapl.add(pl);
        }
        
        rs.close();
        stmt.close();
        
        return listapl;

        
    
    
    
    
    }

    public PessoaLogradouro buscar(PessoaLogradouro plEntrada) throws SQLException {
        String sql = "select * from pessoas_logradouros WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,plEntrada.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            PessoaLogradouro retorno = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                retorno = new PessoaLogradouro(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3));
            // adiciona o usu à lista de usus
            }
            stmt.close();
            return retorno;

    }

    public PessoaLogradouro inserir(PessoaLogradouro plEntrada) throws SQLException {
        String sql = "insert into pessoas_logradouros" + " (idPes, idLog, observacao)" + " values (?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1,plEntrada.getIdP());
        stmt.setInt(2,plEntrada.getIdL());
        stmt.setString(3,plEntrada.getObs());
 
        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            plEntrada.setId(id);
        }
        stmt.close();
        return plEntrada;



    }
    
}
