package menu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class MenuInput {
    //membuat frame
    private JFrame frame = new JFrame("Menu Input");

    //membuat komponen
    private JButton bInput = new JButton("INPUT");
    private JButton bBack = new JButton("BACK");
    private JLabel ljudul = new JLabel("MENU INPUT");
    private JLabel lData = new JLabel("Banyak Data :");
    private JTextField tfData = new JTextField();

    private File file = new File("tabel.txt");

    JTable table;

    //Set Column
    String[] kolom = {"Panjang","Sisi","Lebar","Tinggi","Jari-jari","Diagonal 1","Diagonal 2"};

    MenuInput(){
        initComponent();
    }

    private void initComponent(){
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(550,600);
        frame.setDefaultCloseOperation(3);

        //Initializing JTable
        DefaultTableModel model = new DefaultTableModel(kolom, 0);
        table = new JTable(model);

        JScrollPane jSP = new JScrollPane(table);

        //menambahkan koponen kedalam frame
        frame.add(ljudul);
        frame.add(lData);
        frame.add(bInput);
        frame.add(bBack);
        frame.add(tfData);
        frame.add(jSP);

        //mengatur letak komponen
        ljudul.setBounds(220,10,100,20);
        lData.setBounds(15,35,120,20);
        tfData.setBounds(130,35,120,20);
        bInput.setBounds(270,35,90,20);
        bBack.setBounds(440,530,90,20);
        jSP.setBounds(20,60,500,400);

        jSP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        aksibBack();
        aksiBInput();
    }

    private void aksiBInput(){
        bInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread threadOne = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i=0; i<Integer.parseInt(tfData.getText()); i++) {
                            tambahData();
                        }
                    }
                });

                threadOne.start();
            }
        });
    }

    private void  aksibBack(){
        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuUtama menuUtama = new MenuUtama();
                frame.setVisible(false);
            }
        });
    }

    private synchronized void tambahData() {

        int min = 1;
        int max = 10;
        Random random = new Random();

        String panjang = String.valueOf(random.nextInt(max - min) + min);
        String sisi = String.valueOf(random.nextInt(max - min) + min);
        String lebar = String.valueOf(random.nextInt(max - min) + min);
        String tinggi = String.valueOf(random.nextInt(max - min) + min);
        String jariJari = String.valueOf(random.nextInt(max - min) + min);
        String diagonal1 = String.valueOf(random.nextInt(max - min) + min);
        String diagonal2 = String.valueOf(random.nextInt(max - min) + min);
        writeFile(panjang, sisi, lebar, tinggi, jariJari, diagonal1, diagonal2);

        String[][] dataTable = tampilTabel();
        table.setModel(new JTable(dataTable, kolom).getModel());
    }

    private void writeFile(String panjang, String sisi, String lebar, String tinggi, String jariJari, String diagonal1, String diagonal2) {
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(panjang + " " + sisi + " " + lebar + " " + tinggi + " " + jariJari + " " + diagonal1 + " " + diagonal2 + "\n");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    int getBanyakData() {
        int a = 0;

        try {
            Scanner scanner = new Scanner(file);
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

    String[][] tampilTabel() {
        int i = 0;
        String data[][] = new String[getBanyakData()][7];
        Scanner scanner;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                data[i][0] = String.valueOf(scanner.next());
                data[i][1] = String.valueOf(scanner.next());
                data[i][2] = String.valueOf(scanner.next());
                data[i][3] = String.valueOf(scanner.next());
                data[i][4] = String.valueOf(scanner.next());
                data[i][5] = String.valueOf(scanner.next());
                data[i][6] = String.valueOf(scanner.next());

                i++;
            }
            scanner.close();
            return data;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
