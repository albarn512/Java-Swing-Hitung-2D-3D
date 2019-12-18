import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuProses {
    DuaDimensi duaDimensi;
    //membuat frame
    private JFrame frame = new JFrame("Menu Proses");

    //membuat komponen
    private JButton bProcess = new JButton("PROCESS");
    private JButton bBack = new JButton("BACK");
    private JLabel ljudul = new JLabel("MENU OUTPUT");
    private JTextField tfData = new JTextField();

    public MenuProses(){
        initComponent();
    }

    void initComponent(){
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(550,600);
        frame.setDefaultCloseOperation(3);



        //menambahkan koponen kedalam frame
        frame.add(ljudul);
        frame.add(bProcess);
        frame.add(bBack);
        frame.add(tfData);


        //mengatur letak komponen
        ljudul.setBounds(220,10,100,20);
        bProcess.setBounds(160,220,200,90);
        bBack.setBounds(440,530,90,20);

        aksiBBack();
        aksiBProcess();
    }

    void  aksiBBack(){
        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuUtama menuUtama = new MenuUtama();
                frame.setVisible(false);
            }
        });
    }

    void  aksiBProcess(){
        bProcess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //tanpa tabel. cuma munculin pop up. tau multi threading nya dari sout aja.
                //System.out.println("blablabla");

                DuaDimensi duaDimensi = new DuaDimensi();
                TigaDimensi tigaDimensi = new TigaDimensi();

                JOptionPane.showMessageDialog(null, "DATA SUDAH TERPROSES");
            }
        });
    }


}
