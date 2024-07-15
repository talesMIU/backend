/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendzsdmnoite20221.view;

import backendzsdmnoite20221.controller.ControllerLogradouro;
import backendzsdmnoite20221.model.bean.Logradouro;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ProfAlexandre
 */
public class ManterLogradouro {
    
    public static void inserir() throws SQLException, ClassNotFoundException {
        
        String cep = JOptionPane.showInputDialog("Cep");
        String End = JOptionPane.showInputDialog("End");
        String Num = JOptionPane.showInputDialog("Num");
        String Comp = JOptionPane.showInputDialog("Comp");
        Logradouro logEntrada = new Logradouro(End,cep, Num, Comp);
        ControllerLogradouro contLog = new ControllerLogradouro();
        Logradouro logSaida = contLog.inserir(logEntrada);
        JOptionPane.showMessageDialog(null, logSaida.toString());
    }
    
    public static void listar() throws SQLException, ClassNotFoundException {
        
        String End = JOptionPane.showInputDialog("End");
        Logradouro logEntrada = new Logradouro(End);
        ControllerLogradouro contLog = new ControllerLogradouro();
        List<Logradouro> listalogSaida = contLog.listar(logEntrada);
        for(Logradouro log : listalogSaida) {
            JOptionPane.showMessageDialog(null, log.toString());
        }
   }

    public static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String cep = JOptionPane.showInputDialog("Cep");
        String End = JOptionPane.showInputDialog("End");
        String Num = JOptionPane.showInputDialog("Num");
        String Comp = JOptionPane.showInputDialog("Comp");
        Logradouro logEntrada = new Logradouro(id,End,cep , Num, Comp);
        ControllerLogradouro contLog = new ControllerLogradouro();
        Logradouro logSaida = contLog.alterar(logEntrada);
        JOptionPane.showMessageDialog(null, logSaida.toString());
    }

    public static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Logradouro logEntrada = new Logradouro(id);
        ControllerLogradouro contLog = new ControllerLogradouro();
        Logradouro logSaida = contLog.buscar(logEntrada);
        JOptionPane.showMessageDialog(null, logSaida.toString());
    }

    public static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Logradouro logEntrada = new Logradouro(id);
        ControllerLogradouro contLog = new ControllerLogradouro();
        Logradouro logSaida = contLog.excluir(logEntrada);
        JOptionPane.showMessageDialog(null, logSaida.toString());
    }
 
    public static void menu() throws SQLException, ClassNotFoundException {
        int operacao = Integer.parseInt(JOptionPane.showInputDialog("0 - Sair \n 1 - Inserir \n 2 - Alterar \n 3 - Excluir \n 4 - Buscar \n 5 - Listar"));
        switch (operacao) {
            case 0:
               int sair = JOptionPane.showConfirmDialog(null,"Deseja Sair");
               System.out.println("Valor de Sair = " + sair);
               if(sair > 0) menu();
               break;
            case 1:
               inserir();
               break;
           case 2:
               alterar();
               break;
           case 3:
               excluir();
               break;
           case 4:
               buscar();
               break;
           case 5:
               listar();
               break;
           default:
               JOptionPane.showMessageDialog(null,"Erro opcao invalida");
               menu();
               break;
        }
    }


}
