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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrameCadastroUsuario extends JFrame {

    public FrameCadastroUsuario() {
        this.setLayout(new FlowLayout());
        this.setSize(300, 250);
        this.setVisible(true);

        JPanel panNome = new JPanel();
        panNome.setLayout(new FlowLayout());
        panNome.add(new JLabel("Nome:"));

        final JTextField txtNome = new JTextField(20);
        panNome.add(txtNome);

        JPanel panConta = new JPanel();
        panConta.setLayout(new FlowLayout());
        panConta.add(new JLabel("Conta:"));

        final JTextField txtConta = new JTextField(20);
        panConta.add(txtConta);

        JPanel panAgencia = new JPanel();
        panAgencia.setLayout(new FlowLayout());
        panAgencia.add(new JLabel("Agencia:"));

        final JTextField txtAgencia = new JTextField(20);
        panAgencia.add(txtAgencia);

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

        this.add(panNome);
        this.add(panConta);
        this.add(panAgencia);
        this.add(panLogin);
        this.add(panSenha);

        JButton buttonCadastro = new JButton("Cadastrar");
        JButton buttonVoltar = new JButton("Voltar");

        this.add(buttonCadastro);
        this.add(buttonVoltar);

        buttonCadastro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {
                    Cadastro cadastro = new Cadastro();
                    ArrayList<Cadastro> c = new ArrayList();
                    
                    cadastro.setNome(txtNome.getText());
                    
                    cadastro.setLogin(txtLogin.getText());
                    ManipuladorArquivo arquivo = new ManipuladorArquivo("C:\\Users\\Duarte\\Documents\\Exercicios Programação\\DcMoneyAtualizado\\DcMoney\\"+cadastro.getLogin()+ ".txt");
                    
                    cadastro.setSenha(txtSenha.getText());
                    arquivo.escreverArquivo(cadastro.getSenha());
                    
                    cadastro.setConta(Double.parseDouble(txtConta.getText()));
                                        
                    cadastro.setAgencia(Double.parseDouble(txtAgencia.getText()));

                    c.add(cadastro);
                } catch (IOException ex) {
                    Logger.getLogger(FrameCadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        buttonVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                setVisible(false);
                FrameMenuPrincipal menu = new FrameMenuPrincipal();
                menu.setVisible(true);
            }
        });
    }
}
