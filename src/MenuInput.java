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

    private String sisi, panjang, lebar, tinggi, jariJari,diagonal1, diagonal2;
    private File file = new File("tabel.txt");


    DefaultTableModel model;
    JTable table;

    //Set Column
    String[] kolom = {"Sisi","Panjang","Lebar","Tinggi","Jari-jari","Diagonal 1","Diagonal 2"};

    public MenuInput(){
        initComponent();
    }

    void initComponent(){
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(550,600);
        frame.setDefaultCloseOperation(3);

        //Initializing JTable
        model = new DefaultTableModel(kolom,0);
        table = new JTable(model);

        jSP = new JScrollPane(table);

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
        float max = 100;
        float min = 50;
        float range = max - min + 1;

        panjang = String.valueOf((Math.random() * range) + min);

        max = Float.parseFloat(panjang);
        min = 1;
        range = max - min + 1;

        sisi = String.valueOf((Math.random() * range) + min);
        lebar = String.valueOf((Math.random() * range) + min);
        tinggi = String.valueOf((Math.random() * range) + min);
        jariJari = String.valueOf((Math.random() * range) + min);
        diagonal1 = String.valueOf((Math.random() * range) + min);
        diagonal2 = String.valueOf((Math.random() * range) + min);
        writeFile(sisi, panjang, lebar, tinggi, jariJari,diagonal1,diagonal2);

        String dataTable[][] = tampilTabel();
        table.setModel(new JTable(dataTable, kolom).getModel());
    }

    public void writeFile(String sisi, String panjang, String lebar, String tinggi, String jariJari, String diagonal1, String diagonal2) {
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(sisi + " " + panjang + " " + lebar + " " + tinggi + " " + jariJari + " " + diagonal1 + " " + diagonal2 + "\n");
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
        String data[][] = new String[getBanyakData()][7];
        Scanner scanner = null;
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

    public DefaultTableModel getModel() {
        return model;
    }
}
