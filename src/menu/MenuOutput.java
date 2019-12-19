package menu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MenuOutput {
    //membuat frame
    private JFrame frame = new JFrame("Menu Output");

    //membuat komponen
    private JButton bBack = new JButton("BACK");
    private JLabel ljudul = new JLabel("MENU OUTPUT");
    private JLabel lLuas = new JLabel("Data Luas");
    private JLabel lVolume = new JLabel("Data Volume");

    JTable tableLuas, tableVolume;

    private File fileDuaD = new File("tabelDuaDimensi.txt");
    private File fileTigaD = new File("tabelTigaDimensi.txt");

    //Set Column;
    String[] kolomLuas = {"Persegi","PersegiPanjang","Segitiga","Trapesium","Layang-layang","BelahKetupat","JajarGenjang","Lingkaran"};
    String[] kolomVolume ={"Kubus","Balok","Tabung","Kerucut","Bola","PrismaSegi3","LimasSegi3","LimasSegi4"};
    //data table akan keluar hasil proses yaitu luas, keliling, volume dari bangun
    //Initializing JTable

    MenuOutput(){
        initComponent();
    }

    private void initComponent(){
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(630,600);
        frame.setDefaultCloseOperation(3);

        DefaultTableModel modelLuas = new DefaultTableModel(kolomLuas, 0);
        tableLuas = new JTable(modelLuas);
        JScrollPane jSPLuas = new JScrollPane(tableLuas);

        DefaultTableModel modelVolume = new DefaultTableModel(kolomVolume, 0);
        tableVolume = new JTable(modelVolume);
        JScrollPane jSPVolume = new JScrollPane(tableVolume);

        //menambahkan koponen kedalam frame
        frame.add(ljudul);
        frame.add(lLuas);
        frame.add(lVolume);
        frame.add(bBack);
        frame.add(jSPLuas);
        frame.add(jSPVolume);

        //mengatur letak komponen
        ljudul.setBounds(220,10,100,20);
        bBack.setBounds(440,530,90,20);
        lLuas.setBounds(20,50,100,15);
        jSPLuas.setBounds(20,70,580,210);
        lVolume.setBounds(20,290,100,15);
        jSPVolume.setBounds(20,310,580,210);

        jSPLuas.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jSPVolume.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        aksiBBack();
    }

    //    Mendapatkan jumlah data dari file dua dimensi
    private int getDataLuas() {
        int a = 0;

        try {
            Scanner scanner = new Scanner(fileDuaD);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                a++;
            }
            scanner.close();
            return a;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    //    Mendapatkan data dari file dua dimensi
    String[][] tampilTabelLuas() {
        int i = 0;
        String data[][] = new String[getDataLuas()][8];
        Scanner scanner;
        try {
            scanner = new Scanner(fileDuaD);
            while (scanner.hasNext()) {
                data[i][0] = String.valueOf(scanner.next());
                data[i][1] = String.valueOf(scanner.next());
                data[i][2] = String.valueOf(scanner.next());
                data[i][3] = String.valueOf(scanner.next());
                data[i][4] = String.valueOf(scanner.next());
                data[i][5] = String.valueOf(scanner.next());
                data[i][6] = String.valueOf(scanner.next());
                data[i][7] = String.valueOf(scanner.next());

                i++;
            }
            scanner.close();
            return data;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    //    Mendapatkan jumlah dari file tiga dimensi
    public int getDataVolume() {
        int a = 0;

        try {
            Scanner scanner = new Scanner(fileTigaD);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                a++;
            }
            scanner.close();
            return a;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    //    Mendapatkan data dari file tiga dimensi
    String[][] tampilTabelVolume() {
        int i = 0;
        String data[][] = new String[getDataLuas()][8];
        Scanner scanner;
        try {
            scanner = new Scanner(fileTigaD);
            while (scanner.hasNext()) {
                data[i][0] = String.valueOf(scanner.next());
                data[i][1] = String.valueOf(scanner.next());
                data[i][2] = String.valueOf(scanner.next());
                data[i][3] = String.valueOf(scanner.next());
                data[i][4] = String.valueOf(scanner.next());
                data[i][5] = String.valueOf(scanner.next());
                data[i][6] = String.valueOf(scanner.next());
                data[i][7] = String.valueOf(scanner.next());

                i++;
            }
            scanner.close();
            return data;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    private void  aksiBBack(){
        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuUtama menuUtama = new MenuUtama();
                frame.setVisible(false);
            }
        });
    }

}
