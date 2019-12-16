import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
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
    private JScrollPane jSP;

    private String sisi, panjang, lebar, tinggi, jariJari;
    private File file = new File("tabel.txt");


    DefaultTableModel model;
    JTable table;

    //Set Column
    String[] kolom = {"Sisi","Panjang","Lebar","Tinggi","Jari-jari"};

    public MenuInput(){
        initComponent();
    }

    void initComponent(){
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(450,550);
        frame.setDefaultCloseOperation(3);

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
        bBack.setBounds(300,450,90,20);
        jSP.setBounds(20,90,400,350);

        jSP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        aksibBack();
        aksiBInput();
    }

    void aksiBInput(){
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

    void  aksibBack(){
        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuUtama menuUtama = new MenuUtama();
                frame.setVisible(false);
            }
        });
    }

    public synchronized void tambahData() {
        int max = 100;
        int min = 1;
        int range = max - min + 1;


        sisi = String.valueOf((Math.random() * range) + min);
        panjang = String.valueOf((Math.random() * range) + min);
        lebar = String.valueOf((Math.random() * range) + min);
        tinggi = String.valueOf((Math.random() * range) + min);
        jariJari = String.valueOf((Math.random() * range) + min);
        writeFile(sisi, panjang, lebar, tinggi, jariJari);

        String dataTable[][] = tampilTabel();
        table.setModel(new JTable(dataTable, kolom).getModel());
    }

    public void writeFile(String sisi, String panjang, String lebar, String tinggi, String jariJari) {
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(sisi + " " + panjang + " " + lebar + " " + tinggi + " " + jariJari + "\n");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getBanyakData() {
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

    public String[][] tampilTabel() {
        int i = 0;
        String data[][] = new String[getBanyakData()][5];
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                data[i][0] = String.valueOf(scanner.next());
                data[i][1] = String.valueOf(scanner.next());
                data[i][2] = String.valueOf(scanner.next());
                data[i][3] = String.valueOf(scanner.next());
                data[i][4] = String.valueOf(scanner.next());
                i++;
            }
            scanner.close();
            return data;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public DefaultTableModel getModel() {
        return model;
    }
}
