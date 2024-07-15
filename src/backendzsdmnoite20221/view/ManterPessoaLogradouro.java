/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendzsdmnoite20221.view;

import backendzsdmnoite20221.controller.ControllerPessoaLogradouro;
import backendzsdmnoite20221.model.bean.PessoaLogradouro;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *PessoaLogradouro
 * @author ProfAlexandre
 */
public class ManterPessoaLogradouro {
    
    static ControllerPessoaLogradouro contPl;
    
    public static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        PessoaLogradouro pfEntrada = new PessoaLogradouro(id);
        contPl = new ControllerPessoaLogradouro();
        PessoaLogradouro pfSaida = contPl.excluir(pfEntrada);
        JOptionPane.showMessageDialog(null, pfSaida.toString());
    }

    public static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idp = Integer.parseInt(JOptionPane.showInputDialog("idP"));
        int idl = Integer.parseInt(JOptionPane.showInputDialog("idL"));
        String obs = JOptionPane.showInputDialog("Obs");
        PessoaLogradouro plEntrada = new PessoaLogradouro(id,idp,idl,obs);
        contPl = new ControllerPessoaLogradouro();
        PessoaLogradouro plSaida = contPl.alterar(plEntrada);
        JOptionPane.showMessageDialog(null, plSaida.toString());
    }

    public static void listar() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("Obs");
        PessoaLogradouro pfEntrada = new PessoaLogradouro(nome);
        contPl = new ControllerPessoaLogradouro();
        List<PessoaLogradouro> listaPlSaida = contPl.listar(pfEntrada);
        for(PessoaLogradouro pl : listaPlSaida) {
            JOptionPane.showMessageDialog(null, pl.toString());
        }
    }

    public static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        PessoaLogradouro pfEntrada = new PessoaLogradouro(id);
        contPl = new ControllerPessoaLogradouro();
        PessoaLogradouro pfSaida = contPl.buscar(pfEntrada);
        JOptionPane.showMessageDialog(null, pfSaida.toString());
    }

    public static void inserir() throws SQLException, ClassNotFoundException {
        int idp = Integer.parseInt(JOptionPane.showInputDialog("idP"));
        int idl = Integer.parseInt(JOptionPane.showInputDialog("idL"));
        String obs = JOptionPane.showInputDialog("Obs");
        PessoaLogradouro plEntrada = new PessoaLogradouro(idp,idl,obs);
        contPl = new ControllerPessoaLogradouro();
        PessoaLogradouro plSaida = contPl.inserir(plEntrada);
        JOptionPane.showMessageDialog(null, plSaida.toString());

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
