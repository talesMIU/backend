/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendzsdmnoite20221.model.dao;

import backendzsdmnoite20221.model.bean.Logradouro;
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
public class DaoLogradouro {
    
     private final Connection c;


    public DaoLogradouro() throws SQLException, ClassNotFoundException {
         this.c = new Conexao().getConnection();
    }
    
    public Logradouro inserir(Logradouro log) throws SQLException{
        String sql = "insert into logradouros" + " (endereco, cep, numero, complemento)" + " values (?,?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,log.getEndereco());
        stmt.setString(2,log.getCep());
        stmt.setInt(3,Integer.parseInt(log.getNum()));
        stmt.setString(4,log.getCompl());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            log.setId(id);
        }
        stmt.close();
        return log;
    }

    public Logradouro alterar(Logradouro log) throws SQLException{
        String sql = "UPDATE logradouros SET endereco = ?, cep = ?, numero = ?, complemento = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,log.getEndereco());
        stmt.setString(2,log.getCep());
        stmt.setInt(3,Integer.parseInt(log.getNum()));
        stmt.setString(4,log.getCompl());
        stmt.setInt(5,log.getId());

        // executa
        stmt.execute();
        stmt.close();
        return log;
    }

    public Logradouro excluir(Logradouro log) throws SQLException{
        String sql = "delete from logradouros WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,log.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return log;
    }
    
    public Logradouro buscar(Logradouro log) throws SQLException{
        String sql = "select * from logradouros WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,log.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            Logradouro logSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                logSaida = new Logradouro(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    "" + rs.getInt(4),
                    rs.getString(5));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return logSaida;
   }

   public List<Logradouro> listar(Logradouro logEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<Logradouro> logs = new ArrayList<>();
        
        String sql = "select * from logradouros where endereco like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + logEnt.getEndereco() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Logradouro log = new Logradouro(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                "" + rs.getInt(4),
                rs.getString(5)
            );
            // adiciona o usu à lista de usus
            logs.add(log);
        }
        
        rs.close();
        stmt.close();
        return logs;
   
   }
    
}
