package dcmoney;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrameMenuPrincipal extends JFrame {

    public FrameMenuPrincipal() {
        this.setLayout(new FlowLayout());
        this.setSize(300, 150);

        JPanel panLogin = new JPanel();
        panLogin.setLayout(new FlowLayout());
        panLogin.add(new JLabel("Login:"));

        final JTextField txtLogin = new JTextField(20);
        panLogin.add(txtLogin);

        JPanel panSenha = new JPanel();
        panSenha.setLayout(new FlowLayout());
        panSenha.add(new JLabel("Senha:"));

        final JTextField txtSenha = new JTextField(20);
        panSenha.add(txtSenha);

        this.add(panLogin);
        this.add(panSenha);

        this.setVisible(true);

        JButton buttonEntrar = new JButton("Entrar");
        JButton buttonCadastrar = new JButton("Cadastrar");
        JButton buttonFechar = new JButton("Fechar");

        this.add(buttonEntrar);
        this.add(buttonCadastrar);
        this.add(buttonFechar);

        buttonEntrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                FileReader arquivoLeitura = null;
                try {
                    arquivoLeitura = new FileReader("C:\\Users\\Duarte\\Documents\\Exercicios Programação\\DcMoneyAtualizado\\DcMoney\\" + txtLogin.getText() + ".txt");
                    BufferedReader lerArquivo = new BufferedReader(arquivoLeitura);
                    String linha = lerArquivo.readLine();
                    //String palavra = ("" + linha.split(";"));
                    while (linha != null) {
                        for (int i = 0; i < linha.length(); i++) {
                            if (linha.equals(txtSenha.getText())) {
                                setVisible(false);
                                FrameSegundoMenu opcao = new FrameSegundoMenu();
                                opcao.setVisible(true);;
                            } else {
                                JOptionPane.showMessageDialog(null, "Senha Incorreta");
                                break;
                            }
                            linha = lerArquivo.readLine();
                        }
                        lerArquivo.close();
                        break;
                    }
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null,"Usuario não Encontrado");
                } catch (IOException ex) {
                    Logger.getLogger(FrameMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        arquivoLeitura.close();
                    } catch (IOException ex) {
                        Logger.getLogger(FrameMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }                
            }
        });

        buttonCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                setVisible(false);
                FrameCadastroUsuario cadastro = new FrameCadastroUsuario();
                cadastro.setVisible(true);
            }
        });

        buttonFechar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                setVisible(false);
                System.exit(0);
            }
        });
    }
}
