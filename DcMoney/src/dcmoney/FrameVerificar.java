package dcmoney;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrameVerificar extends JFrame{
    public FrameVerificar(){
        this.setLayout(new FlowLayout());
        this.setSize(300, 170);
        this.setVisible(true);

        ManipuladorArquivo arquivo = new ManipuladorArquivo("CadastroDados.txt");
        
    }
}
