/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcmoney;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Aluno
 */
public class FrameCadastroSlario extends JFrame {

    public FrameCadastroSlario() {
        this.setLayout(new FlowLayout());
        this.setSize(300, 170);
        this.setVisible(true);

        JPanel panSalario = new JPanel();
        panSalario.setLayout(new FlowLayout());
        panSalario.add(new JLabel("Salario:"));

        final JTextField txtSalario = new JTextField(20);
        panSalario.add(txtSalario);

        JPanel panLimite = new JPanel();
        panLimite.setLayout(new FlowLayout());
        panLimite.add(new JLabel("Limite:"));

        final JTextField txtLimite = new JTextField(20);
        panLimite.add(txtLimite);

        this.add(panSalario);
        this.add(panLimite);

        JButton buttonCadastro = new JButton("Cadastrar");
        JButton buttonVoltar = new JButton("Voltar");

        this.add(buttonCadastro);
        this.add(buttonVoltar);

        buttonCadastro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {
                    Cadastro cadastro = new Cadastro();

                    ManipuladorArquivo arquivo = new ManipuladorArquivo("C:\\Users\\Duarte\\Documents\\Exercicios Programação\\DcMoneyAtualizado\\DcMoney\\CadastroDados.txt");
                    ArrayList<Cadastro> c = new ArrayList();
                    
                    cadastro.setSalario(Double.parseDouble(txtSalario.getText()));
                    cadastro.verificarSalario();
                    cadastro.setLimite(Double.parseDouble(txtLimite.getText()));
                    cadastro.verificarCadastroLimite();                    
                    
                    String linha =(""+cadastro.getSalario()+";"+cadastro.getLimite()+"\n");

                    arquivo.escreverArquivo(linha);
                    c.add(cadastro);

                } catch (SalarioInvalidoException ex) {
                    JOptionPane.showMessageDialog(null, "ERRO:"+ex.getMessage());
                } catch (LimiteInvalidoException ex) {
                    JOptionPane.showMessageDialog(null, "ERRO:"+ex.getMessage());
                } catch (IOException ex) {
                    Logger.getLogger(FrameCadastroSlario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        buttonVoltar.addActionListener ( new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                setVisible(false);
                FrameSegundoMenu opcao = new FrameSegundoMenu();
                opcao.setVisible(true);
            }
        });
    }
}
