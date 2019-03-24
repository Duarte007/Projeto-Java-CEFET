package dcmoney;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrameGastosDia extends JFrame {

    public FrameGastosDia() {
        this.setLayout(new FlowLayout());
        this.setSize(350, 200);
        this.setVisible(true);

        JPanel panGastoDia = new JPanel();
        panGastoDia.setLayout(new FlowLayout());
        panGastoDia.add(new JLabel("Gasto do Dia:"));

        final JTextField txtGastoDia = new JTextField(20);
        panGastoDia.add(txtGastoDia);

        this.add(panGastoDia);

        JButton buttonOk = new JButton("OK");
        JButton buttonVoltar = new JButton("Voltar");

        this.add(buttonOk);
        this.add(buttonVoltar);

        buttonOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {
                    GastosDia gastos = new GastosDia();
                    gastos.setGasto(Double.parseDouble(txtGastoDia.getText()));
                    gastos.verificarGastoDiario();
                } catch (GastoInvalidoException ex) {
                   JOptionPane.showMessageDialog(null, "ERRO:"+ex.getMessage());
                }
            }
        });
        
        buttonVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                setVisible(false);
                FrameSegundoMenu opcao = new FrameSegundoMenu();
                opcao.setVisible(true);
            }
        });
    }
}
