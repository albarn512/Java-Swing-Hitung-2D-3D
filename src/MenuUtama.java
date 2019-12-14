import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuUtama {
    //membuat frame
    JFrame frame = new JFrame("Menu Utama");

    //membuat komponen
    JLabel ljudul = new JLabel("MENU UTAMA");
    JButton bInput = new JButton("INPUT");
    JButton bProses = new JButton("PROCESS");
    JButton bOutput = new JButton("OUTPUT");

    public MenuUtama(){
        initComponent();
    }

    void initComponent(){
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(300,450);
        frame.setDefaultCloseOperation(3);

        //menambahkan koponen kedalam frame
        frame.add(ljudul);
        frame.add(bInput);
        frame.add(bProses);
        frame.add(bOutput);

        //mengatur letak komponen
        ljudul.setBounds(100,10,100,20);
        bInput.setBounds(100,120,100,40);
        bProses.setBounds(100,170,100,40);
        bOutput.setBounds(100,220,100,40);

        aksiBInput();
        aksiBtnProcess();

    }

    void aksiBInput(){
        bInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MenuInput menuInput = new MenuInput();
                frame.setVisible(false);
            }
        });
    }

    void aksiBtnProcess() {
        bProses.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
