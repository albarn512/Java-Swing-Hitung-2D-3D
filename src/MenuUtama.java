import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

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
        frame.setSize(450,550);
        frame.setDefaultCloseOperation(3);

        //menambahkan koponen kedalam frame
        frame.add(ljudul);
        ljudul.setFont(new Font("Serif",Font.BOLD,20));
        frame.add(bInput);
        frame.add(bProses);
        frame.add(bOutput);

        //mengatur letak komponen
        ljudul.setBounds(150,20,200,20);
        bInput.setBounds(170,150,100,40);
        bProses.setBounds(170,210,100,40);
        bOutput.setBounds(170,270,100,40);

        aksiBInput();
        aksiBtnProcess();
        aksiBOutput();
    }

    void aksiBInput(){
        bInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MenuInput menuInput = new MenuInput();
                frame.setVisible(false);

                File file = new File("tabel.txt");

                try {
                    if(file.createNewFile()) {
                        System.out.println("File created : " + file.getName());
                    } else {
                        System.out.println("File already exists");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                if(menuInput.getBanyakData() != 0) {
                    String dataTable[][] = menuInput.tampilTabel();
                    menuInput.table.setModel(new JTable(dataTable, menuInput.kolom).getModel());
                }
            }
        });
    }

    void aksiBtnProcess() {
        bProses.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuProses menuProses = new MenuProses();
                frame.setVisible(false);
            }
        });
    }

    void aksiBOutput(){
        bOutput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MenuOutput menuOutput = new MenuOutput();
                frame.setVisible(false);
            }
        });
    }

}
