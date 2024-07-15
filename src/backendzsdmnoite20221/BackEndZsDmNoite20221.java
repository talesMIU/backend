/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendzsdmnoite20221;

import backendzsdmnoite20221.view.ManterLogradouro;
import backendzsdmnoite20221.view.ManterPessoaFisica;
import backendzsdmnoite20221.view.ManterPessoaLogradouro;
import backendzsdmnoite20221.view.ManterUsuario;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author ProfAlexandre
 */
public class BackEndZsDmNoite20221 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        if(ManterUsuario.validar()) {
            menu();
        } else {
            JOptionPane.showMessageDialog(null,"Usuario Invalido");
        }
    }

    public static void menu() throws SQLException, ClassNotFoundException {
            int operacao = Integer.parseInt(JOptionPane.showInputDialog("0 - Sair \n 1 - Usuario \n 2 - Pessoa \n 3 - Logradouro \n 4 - UsuarioPessoa \n 5 - PessoaEndereco"));
            switch (operacao) {
                case 0:
                    int sair = JOptionPane.showConfirmDialog(null,"Deseja Sair");
                    if(sair > 0) menu();
                    System.out.println("Valor de Sair = " + sair);
                    break;
                case 1:
                    ManterUsuario.menu();
                    break;
                case 2:
                    ManterPessoaFisica.menu();
                    break;
                case 3:
                    ManterLogradouro.menu();
                    break;
                case 4:
                    //ManterUsuarioPessoa.menu();
                    break;
                case 5:
                    ManterPessoaLogradouro.menu();
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Erro opcao invalida");
                    menu();
                    break;
            }
    }

}
