import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuInput {
    //membuat frame
    JFrame frame = new JFrame("Menu Input");

    //membuat komponen
    JButton bInput = new JButton("INPUT");
    JButton bBack = new JButton("BACK");
    JLabel ljudul = new JLabel("MENU INPUT");
    JLabel lData = new JLabel("Banyak Data :");
    JTextField tfData = new JTextField();
    JScrollPane jSP;

    DefaultTableModel model;
    JTable table;
    public MenuInput(){
        initComponent();
    }
    void initComponent(){
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(300,450);
        frame.setDefaultCloseOperation(3);

        //Set Column
        String[] kolom = {"Sisi","Panjang","Lebar","Tinggi","Jari-jari"};

        //Initializing JTable
        model = new DefaultTableModel(kolom,0);
        table = new JTable(model); //masih menggunakan data statis

        jSP = new JScrollPane(table);

        //menambahkan koponen kedalam frame
        frame.add(ljudul);
        frame.add(lData);
        frame.add(bInput);
        frame.add(bBack);
        frame.add(tfData);
        frame.add(jSP);

        //mengatur letak komponen
        ljudul.setBounds(100,10,100,20);
        lData.setBounds(15,35,120,20);
        tfData.setBounds(130,35,120,20);
        bInput.setBounds(140,60,90,20);
        bBack.setBounds(185,390,90,20);
        jSP.setBounds(5,90,280,300);

        jSP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        aksibBack();
        aksiBInput();
    }

    void aksiBInput(){
        bInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //input random data then import to file.
            }
        });
    }

    void  aksibBack(){
        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuUtama menuUtama = new MenuUtama();
                frame.setVisible(false);
            }
        });
    }
}
