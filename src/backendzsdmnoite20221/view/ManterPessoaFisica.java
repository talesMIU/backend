/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendzsdmnoite20221.view;

import backendzsdmnoite20221.controller.ControllerPessoaFisica;
import backendzsdmnoite20221.model.bean.PessoaFisica;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ProfAlexandre
 */
public class ManterPessoaFisica {
    
    static ControllerPessoaFisica contPf;
    
    public static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        PessoaFisica pfEntrada = new PessoaFisica(id);
        contPf = new ControllerPessoaFisica();
        PessoaFisica pfSaida = contPf.excluir(pfEntrada);
        JOptionPane.showMessageDialog(null, pfSaida.toString());
    }

    public static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String nome = JOptionPane.showInputDialog("Nome");
        String cpf = JOptionPane.showInputDialog("Cpf");
        String tipo = JOptionPane.showInputDialog("Tipo");
        String email = JOptionPane.showInputDialog("Email");
        PessoaFisica pfEntrada = new PessoaFisica(id,nome,cpf, tipo,email );
        contPf = new ControllerPessoaFisica();
        PessoaFisica pfSaida = contPf.alterar(pfEntrada);
        JOptionPane.showMessageDialog(null, pfSaida.toString());
    }

    public static void listar() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("Nome");
        PessoaFisica pfEntrada = new PessoaFisica(nome);
        contPf = new ControllerPessoaFisica();
        List<PessoaFisica> listaPfSaida = contPf.listar(pfEntrada);
        for(PessoaFisica pf : listaPfSaida) {
            JOptionPane.showMessageDialog(null, pf.toString());
        }
    }

    public static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        PessoaFisica pfEntrada = new PessoaFisica(id);
        contPf = new ControllerPessoaFisica();
        PessoaFisica pfSaida = contPf.buscar(pfEntrada);
        JOptionPane.showMessageDialog(null, pfSaida.toString());
    }

    public static void inserir() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("Nome");
        String cpf = JOptionPane.showInputDialog("Cpf");
        String tipo = JOptionPane.showInputDialog("Tipo");
        String email = JOptionPane.showInputDialog("Email");
        PessoaFisica pfEntrada = new PessoaFisica(nome,cpf, tipo,email );
        contPf = new ControllerPessoaFisica();
        PessoaFisica pfSaida = contPf.inserir(pfEntrada);
        JOptionPane.showMessageDialog(null, pfSaida.toString());

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
