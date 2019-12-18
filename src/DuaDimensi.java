import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DuaDimensi {

    private File file = new File("tabel.txt");

    public DuaDimensi(){
        getBanyakData();
        getData();
        hitungLuas();
    }

    void hitungLuas(){

        String data[][] = getData();
//                panjang = Double.parseDouble(data[i][0]);
//                sisi = Double.parseDouble(data[i][1]);
//                lebar = Double.parseDouble(data[i][2]);
//                tinggi = Double.parseDouble(data[i][3]);
//                jariJari = Double.parseDouble(data[i][4]);
//                diagonal1 = Double.parseDouble(data[i][5]);
//                diagonal2 = Double.parseDouble(data[i][6]);

            Thread threadPersegi = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0;i<getBanyakData();i++) {
                        luasPersegi(Double.parseDouble(data[i][1]));
                    }
                }
            });

            Thread threadPersegiPanjang = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0; i<getBanyakData(); i++) {
                        luasPersegiPanjang(Double.parseDouble(data[i][0]), Double.parseDouble(data[i][2]));
                    }
                }
            });

            Thread threadSegitiga = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0; i<getBanyakData(); i++) {
                        luasSegitiga(Double.parseDouble(data[i][0]), Double.parseDouble(data[i][3]));
                    }
                }
            });

            Thread threadLayang = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0; i<getBanyakData(); i++) {
                        luasLayang(Double.parseDouble(data[i][5]), Double.parseDouble(data[i][6]));
                    }
                }
            });

            Thread threadBelahKetupat = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0; i<getBanyakData(); i++) {
                        luasBelahKetupat(Double.parseDouble(data[i][5]), Double.parseDouble(data[i][6]));
                    }
                }
            });

            Thread threadJajarGenjang = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0; i<getBanyakData(); i++) {
                        luasJajarGenjang(Double.parseDouble(data[i][0]), Double.parseDouble(data[i][3]));
                    }
                }
            });

            Thread threadLingkaran = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0; i<getBanyakData(); i++) {
                        luasLingkaran(Double.parseDouble(data[i][4]));
                    }
                }
            });

            Thread threadTrapesium = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0; i<getBanyakData(); i++) {
                        luasTrapesium(Double.parseDouble(data[i][0]), Double.parseDouble(data[i][3]), Double.parseDouble(data[i][2]));
                    }
                }
            });

        threadPersegi.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadPersegiPanjang.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadSegitiga.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadBelahKetupat.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadJajarGenjang.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadLayang.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadLingkaran.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadTrapesium.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
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

    public String[][] getData(){
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

    public synchronized void luasLayang(double diagonal1, double diagonal2){
        double luas = diagonal1 * diagonal2;
        System.out.println("Luas Layang Layang : " + luas);
    }

    public synchronized void luasPersegi(double sisi){
        double luas = sisi*sisi;
        System.out.println("Luas Peregi : " + luas);
    }

    public synchronized void luasBelahKetupat(double diagonal1, double diagonal2){
        double luas = diagonal1 * diagonal2/2;
        System.out.println("Luas Belah Ketupat : " + luas);
    }

    public synchronized void luasJajarGenjang(double panjang, double tinggi){
        double luas = panjang * tinggi;
        System.out.println("Luas Jajar Genjang : " + luas);
    }

    public synchronized void luasPersegiPanjang(double panjang, double lebar){
        double luas = panjang*lebar;
        System.out.println("Luas Persegi Panjang : " + luas);
    }

    public synchronized void luasLingkaran(double jariJari){
        double luas = jariJari*jariJari*3.14/2;
        System.out.println("Luas Lingkaran : " + luas);
    }

    public synchronized void luasTrapesium(double alas, double tinggi, double atap){
        double luas =(alas+atap)*tinggi/2;
        System.out.println("Luas Trapesium : " + luas);
    }

    public synchronized void luasSegitiga(double alas, double tinggi){
        double luas = alas*tinggi/2;
        System.out.println("Luas Segitiga : " + luas);
    }

}
