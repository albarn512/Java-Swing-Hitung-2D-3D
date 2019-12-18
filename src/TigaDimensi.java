import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TigaDimensi {
    private File file = new File("tabel.txt");

    public TigaDimensi(){
        getBanyakData();
        getData();
        hitungVolume();
    }

    void hitungVolume(){

        String data[][] = getData();

        /*
        panjang = Double.parseDouble(data[i][0]);
        sisi = Double.parseDouble(data[i][1]);
        lebar = Double.parseDouble(data[i][2]);
        tinggi = Double.parseDouble(data[i][3]);
        jariJari = Double.parseDouble(data[i][4]);
        diagonal1 = Double.parseDouble(data[i][5]);
        diagonal2 = Double.parseDouble(data[i][6]);
        */

        Thread threadTabung = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<getBanyakData(); i++) {
                    volumeTabung(Double.parseDouble(data[i][1]), Double.parseDouble(data[i][3]));
                }
            }
        });

        Thread threadBalok = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<getBanyakData(); i++) {
                    volumeBalok(Double.parseDouble(data[i][0]), Double.parseDouble(data[i][3]), Double.parseDouble(data[i][2]));
                }
            }
        });

        Thread threadKubus = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<getBanyakData(); i++) {
                    volumeKubus(Double.parseDouble(data[i][1]));
                }
            }
        });

        Thread threadKerucut = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<getBanyakData(); i++) {
                    volumeKerucut(Double.parseDouble(data[i][4]), Double.parseDouble(data[i][3]));
                }
            }
        });

        Thread threadLimasSegiEmpat = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<getBanyakData(); i++) {
                    volumeLimasSegi4(Double.parseDouble(data[i][0]), Double.parseDouble(data[i][2]), Double.parseDouble(data[i][3]));
                }
            }
        });

        Thread threadLimasSegiTiga = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<getBanyakData(); i++) {
                    volumeLimasSegi3(Double.parseDouble(data[i][0]), Double.parseDouble(data[i][2]), Double.parseDouble(data[i][3]));
                }
            }
        });

        Thread threadPrismaSegitiga = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<getBanyakData(); i++) {
                    volumePrismaSegitiga(Double.parseDouble(data[i][0]), Double.parseDouble(data[i][2]), Double.parseDouble(data[i][3]));
                }
            }
        });

        Thread threadBola = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<getBanyakData(); i++) {
                    volumeBola(Double.parseDouble(data[i][4]));
                }
            }
        });

        threadBalok.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadBola.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadKerucut.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadKubus.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadLimasSegiEmpat.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadLimasSegiTiga.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadPrismaSegitiga.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadTabung.start();
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

    public synchronized void volumeBalok(double panjang, double tinggi, double lebar){
        double volume =panjang*tinggi*lebar;
        System.out.println("Volume Balok : " + volume);
    }

    public synchronized void volumeTabung(double sisi, double tinggi){
        double volume = sisi*tinggi*Math.PI;
        System.out.println("Volume Tabung : " + volume);
    }

    public synchronized void volumeKerucut(double jariJari, double tinggi){
        double volume = 3.14*jariJari*jariJari*tinggi/3;
        System.out.println("Volume Kerucut : " + volume);
    }

    public synchronized void volumeKubus (double sisi) {
        double volume = sisi*sisi*sisi;
        System.out.println("Volume Kubus : " + volume);
    }

    public synchronized void volumeLimasSegi4(double panjang, double lebar, double tinggi){
        double volume = panjang*lebar*tinggi;
        System.out.println("Volume Limas Segi Empat : " + volume);
    }

    public synchronized void volumeLimasSegi3(double panjang, double lebar, double tinggi){
        double volume = panjang*lebar*tinggi/3;
        System.out.println("Volume Limas Segi Tiga : " + volume);
    }

    public synchronized void volumePrismaSegitiga(double panjang, double lebar, double tinggi){
        double volume = panjang*lebar*tinggi/2;
        System.out.println("Volume Prisma Segitiga : " + volume);
    }

    public synchronized void volumeBola(double jariJari){
        double volume = Math.PI*jariJari*jariJari*jariJari*4/3;
        System.out.println("Volume Bola : " + volume);
    }
}
