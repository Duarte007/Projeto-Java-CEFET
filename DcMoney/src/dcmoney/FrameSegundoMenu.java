package dcmoney;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FrameSegundoMenu extends JFrame {

    public FrameSegundoMenu() {
        this.setLayout(new FlowLayout());
        this.setSize(150, 200);
        this.setVisible(true);

        JButton buttonCadastrar = new JButton("Cadastrar");
        JButton buttonGastosDia = new JButton("Gasto do Dia");
        JButton buttonVerificar = new JButton("verificar Limite");
        JButton buttonConsultar = new JButton("Consultar");
        JButton buttonSair = new JButton("Sair");

        this.add(buttonCadastrar);
        this.add(buttonConsultar);
        this.add(buttonSair);
        this.add(buttonGastosDia);
        this.add(buttonVerificar);

        buttonCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                setVisible(false);
                FrameCadastroSlario salario = new FrameCadastroSlario();
                salario.setVisible(true);
            }
        });
        
        buttonGastosDia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                FrameGastosDia gastoDia = new FrameGastosDia();
                gastoDia.setVisible(true);
            }
        });
        
        buttonVerificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                
            }
        });

        buttonConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                //ADD CODIGO
                //Não fizemos
            }
        });

        buttonSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                setVisible(false);
                FrameMenuPrincipal menu = new FrameMenuPrincipal();
                menu.setVisible(true);
            }
        });
    }
}
