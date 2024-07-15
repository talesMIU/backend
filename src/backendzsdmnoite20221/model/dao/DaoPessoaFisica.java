/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendzsdmnoite20221.model.dao;

import backendzsdmnoite20221.model.bean.PessoaFisica;
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
public class DaoPessoaFisica {
    
    private final Connection c;
    
    public DaoPessoaFisica() throws SQLException, ClassNotFoundException{
        this.c = new Conexao().getConnection();
    }

    public PessoaFisica excluir(PessoaFisica pfEntrada) throws SQLException {
        String sql = "delete from pessoas WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,pfEntrada.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return pfEntrada;
    }

    public PessoaFisica buscar(PessoaFisica pfEntrada) throws SQLException {
        String sql = "select * from pessoas WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,pfEntrada.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            PessoaFisica retorno = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                retorno = new PessoaFisica(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return retorno;

    }

    public PessoaFisica inserir(PessoaFisica pfEntrada) throws SQLException {
        String sql = "insert into pessoas" + " (nome, cpf, tipo, email)" + " values (?,?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,pfEntrada.getNome());
        stmt.setString(2,pfEntrada.getCpf());
        stmt.setString(3,pfEntrada.getTipo());
        stmt.setString(4,pfEntrada.getEmail());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            pfEntrada.setId(id);
        }
        stmt.close();
        return pfEntrada;
    }

    public PessoaFisica alterar(PessoaFisica pfEntrada) throws SQLException {
        String sql = "UPDATE pessoas SET nome = ?, cpf = ?, tipo = ?, email = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,pfEntrada.getNome());
        stmt.setString(2,pfEntrada.getCpf());
        stmt.setString(3,pfEntrada.getTipo());
        stmt.setString(4,pfEntrada.getEmail());
        stmt.setInt(5,pfEntrada.getId());

        // executa
        stmt.execute();
        stmt.close();
        return pfEntrada;

    }

    public List<PessoaFisica> listar(PessoaFisica pfEntrada) throws SQLException {
        // usus: array armazena a lista de registros

        List<PessoaFisica> listapf = new ArrayList<>();
        
        String sql = "select * from pessoas where nome like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + pfEntrada.getNome() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            PessoaFisica pf = new PessoaFisica(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5)
            );
            // adiciona o usu à lista de usus
            listapf.add(pf);
        }
        
        rs.close();
        stmt.close();
        
        return listapf;

    }
    
}
