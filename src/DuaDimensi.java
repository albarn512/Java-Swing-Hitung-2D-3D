import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DuaDimensi {

    protected double[] sisi, panjang, lebar, tinggi, jariJari,diagonal1, diagonal2;
    private File file = new File("tabel.txt");
    public DuaDimensi(){
        getBanyakData();
        getData();
        hitungLuas();
    }
    void hitungLuas(){
        for (int i=0;i<sisi.length;i++) {
            luasLayang(diagonal1[i], diagonal2[i]);
            luasPersegi(sisi[i]);
            luasBelahKetupat(diagonal1[i], diagonal2[i]);
            luasJajarGenjang(panjang[i], tinggi[i]);
            luasPersegiPanjang(panjang[i], lebar[i]);
            luasLingkaran(jariJari[i]);
            luasTrapesium(panjang[i], tinggi[i], lebar[i]);
            luasSegitiga(panjang[i], tinggi[i]);
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

    public double luasLayang(double diagonal1, double diagonal2){
        double luas = diagonal1 * diagonal2;
        return luas;
    }
    public double luasPersegi(double sisi){
        double luas = sisi*sisi;
        System.out.println(luas);
        return  luas;
    }
    public double luasBelahKetupat(double diagonal1, double diagonal2){
        double luas = diagonal1 * diagonal2/2;
        return luas;
    }
    public double luasJajarGenjang(double panjang, double tinggi){
        double luas = panjang * tinggi;
        return luas;
    }
    public double luasPersegiPanjang(double panjang, double lebar){
        double luas = panjang*lebar;
        return  luas;
    }
    public double luasLingkaran(double jariJari){
        double luas = jariJari*jariJari*3.14/2;
        return luas;
    }
    public double luasTrapesium(double alas, double tinggi, double atap){
        double luas =(alas+atap)*tinggi/2;
        return luas;
    }
    public double luasSegitiga(double alas, double tinggi){
        double luas = alas*tinggi/2;
        return luas;
    }

}
