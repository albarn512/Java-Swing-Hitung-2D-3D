import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuProses {
    //membuat frame
    private JFrame frame = new JFrame("Menu Proses");

    //membuat komponen
    private JButton bProcess = new JButton("PROCESS");
    private JButton bBack = new JButton("BACK");
    private JLabel ljudul = new JLabel("MENU INPUT");
    private JLabel lData = new JLabel("Banyak Data :");
    private JTextField tfData = new JTextField();
    private JScrollPane jSP;

    private String sisi, panjang, lebar, tinggi, jariJari;

    DefaultTableModel model;
    JTable table;

    public MenuProses(){
        initComponent();
    }

    void initComponent(){
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(450,550);
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
        frame.add(bProcess);
        frame.add(bBack);
        frame.add(tfData);
        frame.add(jSP);

        //mengatur letak komponen
        ljudul.setBounds(100,10,100,20);
        lData.setBounds(15,35,120,20);
        tfData.setBounds(130,35,120,20);
        bProcess.setBounds(140,60,90,20);
        bBack.setBounds(185,390,90,20);
        jSP.setBounds(5,90,280,300);

        jSP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

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
        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //tanpa tabel. cuma munculin pop up. tau multi threading nya dari sout aja.
                //System.out.println("blablabla");
                JOptionPane.showMessageDialog(null, "DATA SUDAH TERPROSES");
            }
        });
    }


}
