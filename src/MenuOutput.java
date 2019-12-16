import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MenuOutput {
    //membuat frame
    private JFrame frame = new JFrame("Menu Output");

    //membuat komponen
    private JButton bOutput = new JButton("OUTPUT");
    private JButton bBack = new JButton("BACK");
    private JLabel ljudul = new JLabel("MENU OUTPUT");
    private JScrollPane jSP;

    private String sisi, panjang, lebar, tinggi, jariJari;

    DefaultTableModel model;
    JTable table;

    public MenuOutput(){
        initComponent();
    }

    void initComponent(){
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(450,550);
        frame.setDefaultCloseOperation(3);

        //Set Column
        String[] kolom = {"Sisi","Panjang","Lebar","Tinggi","Jari-jari"};

        //data table akan keluar hasil proses yaitu luas, keliling, volume dari bangun
        //Initializing JTable
        model = new DefaultTableModel(kolom,0);
        table = new JTable(model); //masih menggunakan data statis

        jSP = new JScrollPane(table);

        //menambahkan koponen kedalam frame
        frame.add(ljudul);
        frame.add(bOutput);
        frame.add(bBack);
        frame.add(jSP);

        //mengatur letak komponen
        ljudul.setBounds(100,10,100,20);
        bOutput.setBounds(140,60,90,20);
        bBack.setBounds(185,390,90,20);
        jSP.setBounds(5,90,280,300);

        jSP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        aksiBBack();
        aksiBOutput();
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

    void  aksiBOutput(){
        bOutput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuUtama menuUtama = new MenuUtama();
                frame.setVisible(false);
            }
        });
    }
}
