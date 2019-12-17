import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MenuOutput {
    //membuat frame
    private JFrame frame = new JFrame("Menu Output");

    //membuat komponen
    private JButton bBack = new JButton("BACK");
    private JLabel ljudul = new JLabel("MENU OUTPUT");
    private JLabel lKeliling = new JLabel("Data Keliling");
    private JLabel lLuas = new JLabel("Data Luas");
    private JLabel lVolume = new JLabel("Data Volume");
    private JScrollPane jSPKeliling,jSPLuas,jSPVolume;

    private String persegi, persegiPanjang, segiTiga,trapesium,layangLayang,belahKetupat,jajarGenjang;

    DefaultTableModel modelKeliling, modelLuas, modelVolume;
    JTable tableKeliling, tableLuas, tableVolume;

    public MenuOutput(){
        initComponent();
    }

    void initComponent(){
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(630,600);
        frame.setDefaultCloseOperation(3);

        //Set Column
        String[] kolomKeliling = {"Persegi","PersegiPanjang","Segitiga","Trapesium","Layang-layang","BelahKetupat","JajarGenjang","Lingkaran"};
        String[] kolomLuas = {"Persegi","PersegiPanjang","Segitiga","Trapesium","Layang-layang","BelahKetupat","JajarGenjang","Lingkaran"};
        String[] kolomVolume ={"Kubus","Balok","Tabung","Kerucut","Bola","PrismaSegi3","LimasSegi3","LimasSegi4"};
        //data table akan keluar hasil proses yaitu luas, keliling, volume dari bangun
        //Initializing JTable
        modelKeliling = new DefaultTableModel(kolomKeliling,0);
        tableKeliling = new JTable(modelKeliling);
        jSPKeliling = new JScrollPane(tableKeliling);

        modelLuas = new DefaultTableModel(kolomLuas,0);
        tableLuas = new JTable(modelLuas);
        jSPLuas = new JScrollPane(tableLuas);

        modelVolume = new DefaultTableModel(kolomVolume,0);
        tableVolume = new JTable(modelVolume);
        jSPVolume = new JScrollPane(tableVolume);

        //menambahkan koponen kedalam frame
        frame.add(ljudul);
        frame.add(lKeliling);
        frame.add(lLuas);
        frame.add(lVolume);
        frame.add(bBack);
        frame.add(jSPKeliling);
        frame.add(jSPLuas);
        frame.add(jSPVolume);

        //mengatur letak komponen
        ljudul.setBounds(220,10,100,20);
        bBack.setBounds(440,530,90,20);
        lKeliling.setBounds(20,60,100,15);
        jSPKeliling.setBounds(20,80,580,110);
        lLuas.setBounds(20,210,100,15);
        jSPLuas.setBounds(20,230,580,110);
        lVolume.setBounds(20,360,100,15);
        jSPVolume.setBounds(20,380,580,110);

        jSPKeliling.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jSPLuas.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jSPVolume.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        aksiBBack();
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

}
