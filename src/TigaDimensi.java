import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TigaDimensi {
    protected double[] sisi, panjang, lebar, tinggi, jariJari,diagonal1, diagonal2;
    private File file = new File("tabel.txt");
    public TigaDimensi(){
        getBanyakData();
        getData();
        hitungVolume();
    }

    void hitungVolume(){
        for (int i=0;i<sisi.length;i++) {
            volumeBalok(panjang[i],tinggi[i],lebar[i]);
            volumeTabung(sisi[i],tinggi[i]);
            volumeKerucut(jariJari[i],tinggi[i]);
            volumeKubus(sisi[i]);
            volumeLimasSegi4(panjang[i],lebar[i],tinggi[i]);
            volumeLimasSegi3(panjang[i],lebar[i],tinggi[i]);
            volumePrismaSegitiga(panjang[i],lebar[i],tinggi[i]);
            volumeBola(jariJari[i]);
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

    void getData(){
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

                panjang[i] = Double.parseDouble(data[i][0]);
                sisi[i] = Double.parseDouble(data[i][1]);
                lebar[i] = Double.parseDouble(data[i][2]);
                tinggi[i] = Double.parseDouble(data[i][3]);
                jariJari[i] = Double.parseDouble(data[i][4]);
                diagonal1[i] = Double.parseDouble(data[i][5]);
                diagonal2[i] = Double.parseDouble(data[i][6]);

                i++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public double volumeBalok(double panjang, double tinggi, double lebar){
        double volume =panjang*tinggi*lebar;
        return volume;
    }
    public double volumeTabung(double sisi, double tinggi){
        double volume = sisi*tinggi*3.14;
        return volume;
    }
    public double volumeKerucut(double jariJari, double tinggi){
        double volume = 3.14*jariJari*jariJari*tinggi/3;
        return volume;
    }
    public double volumeKubus (double sisi) {
        double volume = sisi*sisi*sisi;
        return volume;
    }
    public double volumeLimasSegi4(double panjang, double lebar, double tinggi){
        double volume = panjang*lebar*tinggi;
        return volume;
    }

    public double volumeLimasSegi3(double panjang, double lebar, double tinggi){
        double volume = panjang*lebar*tinggi/3;
        return volume;
    }
    public double volumePrismaSegitiga(double panjang, double lebar, double tinggi){
        double volume = panjang*lebar*tinggi/2;
        return volume;
    }
    public double volumeBola(double jariJari){
        double volume = 3.14*jariJari*jariJari*jariJari*4/3;
        return volume;
    }
}
