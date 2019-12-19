package bangun;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class TigaDimensi {
    private File file = new File("tabel.txt");
    private File fileTableTigaD = new File("tabelTigaDimensi.txt");

//    Mengatur format desimal (Maksimal 2 angka dibelakan koma ",")
    private DecimalFormat df = new DecimalFormat("#.##");

    private int kolom = 8;
    private String[][] volume = new String[getBanyakData()][kolom];

    private double volumeKubus;
    private double volumeBalok;
    private double volumeTabung;
    private double volumeKerucut;
    private double volumeBola;
    private double volumePrimasSegiTiga;
    private double volumeLimasSegiTiga;
    private double volumeLimasSegiEmpat;

    public TigaDimensi(){
        getBanyakData();
        getData();
        hitungVolume();
        System.out.println();
        hitungLuasPermukaan();
        writeToFileTigaD();
    }

    private void hitungVolume(){

        String[][] data = getData();

        Thread threadKubus = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<getBanyakData(); i++) {
                    setVolumeKubus(Double.parseDouble(data[i][1]));
                    //kode di atas untuk mengirim data sisi
                    volume[i][0] = String.valueOf(df.format(getVolumeKubus()));
                }
            }
        });

        Thread threadBalok = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<getBanyakData(); i++) {
                    setVolumeBalok(Double.parseDouble(data[i][0]), Double.parseDouble(data[i][3]), Double.parseDouble(data[i][2]));
                    //kode di atas untuk mengirim data panjang, tinggi, lebar
                    volume[i][1] = String.valueOf(df.format(getVolumeBalok()));
                }
            }
        });

        Thread threadTabung = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<getBanyakData(); i++) {
                    setVolumeTabung(Double.parseDouble(data[i][4]), Double.parseDouble(data[i][3]));
                    //kode di atas untuk mengirim data jari jari dan tinggi
                    volume[i][2] = String.valueOf(df.format(getVolumeTabung()));
                }
            }
        });

        Thread threadKerucut = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<getBanyakData(); i++) {
                    setVolumeKerucut(Double.parseDouble(data[i][4]), Double.parseDouble(data[i][3]));
                    //kode di atas untuk mengirim data jari jari dan tinggi
                    volume[i][3] = String.valueOf(df.format(getVolumeKerucut()));
                }
            }
        });

        Thread threadBola = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<getBanyakData(); i++) {
                    setVolumeBola(Double.parseDouble(data[i][4]));
                    //kode di atas untuk mengirim data jari jari
                    volume[i][4] = String.valueOf(df.format(getVolumeBola()));
                }
            }
        });

        Thread threadPrismaSegitiga = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<getBanyakData(); i++) {
                    setVolumePrimasSegiTiga(Double.parseDouble(data[i][0]), Double.parseDouble(data[i][2]), Double.parseDouble(data[i][3]));
                    //kode di atas untuk mengirim data panjang, lebar(digunakan sebagai tinggi alas segitia), tinggi
                    volume[i][5] = String.valueOf(df.format(getVolumePrimasSegiTiga()));
                }
            }
        });

        Thread threadLimasSegiTiga = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<getBanyakData(); i++) {
                    setVolumeLimasSegiTiga(Double.parseDouble(data[i][0]), Double.parseDouble(data[i][2]), Double.parseDouble(data[i][3]));
                    //kode di atas untuk mengirim data panjang, lebar(digunakan sebagai tinggi alas segitia),tinggi
                    volume[i][6] = String.valueOf(df.format(getVolumeLimasSegiTiga()));
                }
            }
        });

        Thread threadLimasSegiEmpat = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<getBanyakData(); i++) {
                    setVolumeLimasSegiEmpat(Double.parseDouble(data[i][0]), Double.parseDouble(data[i][2]), Double.parseDouble(data[i][3]));
                    //kode di atas untuk mengirim data panjang, lebar, tinggi
                    volume[i][7] = String.valueOf(df.format(getVolumeLimasSegiEmpat()));
                }
            }
        });

//==========MEMULAI THREAD=================
        threadKubus.start();
        threadBalok.start();
        threadTabung.start();
        threadKerucut.start();
        threadBola.start();
        threadPrismaSegitiga.start();
        threadLimasSegiTiga.start();
        threadLimasSegiEmpat.start();
//========================================

        try {
            Thread.sleep(500);          //membuat program berhenti sejenak agar multi threading terlihat
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(500);          //membuat program berhenti sejenak agar multi threading terlihat
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(500);          //membuat program berhenti sejenak agar multi threading terlihat
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(500);          //membuat program berhenti sejenak agar multi threading terlihat
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(500);          //membuat program berhenti sejenak agar multi threading terlihat
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(500);          //membuat program berhenti sejenak agar multi threading terlihat
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(500);          //membuat program berhenti sejenak agar multi threading terlihat
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(500);          //membuat program berhenti sejenak agar multi threading terlihat
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    
    private void hitungLuasPermukaan(){
        String[][] data = getData();  // mengambil data

        Thread threadLTabung = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<getBanyakData(); i++) {
                    luasTabung(Double.parseDouble(data[i][4]), Double.parseDouble(data[i][3]));
                    //kode di atas untuk mengirim data jari jari dan tinggi
                }
            }
        });

        Thread threadLBalok = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<getBanyakData(); i++) {
                    luasBalok(Double.parseDouble(data[i][0]), Double.parseDouble(data[i][3]), Double.parseDouble(data[i][2]));
                    //kode di atas untuk mengirim data panjang, tinggi, lebar
                }
            }
        });

        Thread threadLKubus = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<getBanyakData(); i++) {
                    assert data != null;
                    luasKubus(Double.parseDouble(data[i][1]));
                    //kode di atas untuk mengirim data sisi
                }
            }
        });

        Thread threadLKerucut = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<getBanyakData(); i++) {
                    luasKerucut(Double.parseDouble(data[i][4]), Double.parseDouble(data[i][1]));
                    //kode di atas untuk mengirim data jari jari dan tinggi
                }
            }
        });

        Thread threadLLimasSegiEmpat = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<getBanyakData(); i++) {
                    luasLimasSegi4(Double.parseDouble(data[i][0]), Double.parseDouble(data[i][2]), Double.parseDouble(data[i][3]));
                    //kode di atas untuk mengirim data panjang, lebar, tinggi
                }
            }
        });

        Thread threadLLimasSegiTiga = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<getBanyakData(); i++) {
                    luasLimasSegi3(Double.parseDouble(data[i][0]), Double.parseDouble(data[i][2]), Double.parseDouble(data[i][3]));
                    //kode di atas untuk mengirim data panjang, lebar(digunakan sebagai tinggi alas segitia), dan tinggi
                }
            }
        });

        Thread threadLPrismaSegitiga = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<getBanyakData(); i++) {
                    luasPrismaSegitiga(Double.parseDouble(data[i][0]), Double.parseDouble(data[i][2]), Double.parseDouble(data[i][3]));
                    //kode di atas untuk mengirim data panjang, lebar (digunakan sebagai tinggi alas segitia), dan tinggi
                }
            }
        });

        Thread threadLBola = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<getBanyakData(); i++) {
                    luasBola(Double.parseDouble(data[i][4]));
                    //kode di atas untuk mengirim data jari jari
                }
            }
        });
//==================MEMULAI THREAD=======
        threadLBalok.start();
        threadLBola.start();
        threadLKerucut.start();
        threadLKubus.start();
        threadLLimasSegiEmpat.start();
        threadLPrismaSegitiga.start();
        threadLTabung.start();
        threadLLimasSegiTiga.start();
//=========================================
        try {
            Thread.sleep(500);          //membuat program berhenti sejenak agar multi threading terlihat
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(500);          //membuat program berhenti sejenak agar multi threading terlihat
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(500);          //membuat program berhenti sejenak agar multi threading terlihat
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(500);          //membuat program berhenti sejenak agar multi threading terlihat
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(500);          //membuat program berhenti sejenak agar multi threading terlihat
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(500);          //membuat program berhenti sejenak agar multi threading terlihat
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(500);          //membuat program berhenti sejenak agar multi threading terlihat
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(500);          //membuat program berhenti sejenak agar multi threading terlihat
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private int getBanyakData() {
        int a = 0;

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {        // melakukan pengecekan pada file, jika ada baris baru maka
                String data = scanner.nextLine();  // data akan berisi scan dari file
                a++;                               // lalu nilai a akan bertambah
            }
            scanner.close();
            return a;
        } catch (FileNotFoundException e) {         //sebuah exception jika file tidak ada
            e.printStackTrace();
        }
        return 0;
    }

    private String[][] getData(){
        int i = 0;
        String data[][] = new String[getBanyakData()][7];
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                data[i][0] = String.valueOf(scanner.next());//Mengambil data dari file lalu memindahkan nya ke data
                data[i][1] = String.valueOf(scanner.next());//Mengambil data dari file lalu memindahkan nya ke data
                data[i][2] = String.valueOf(scanner.next());//Mengambil data dari file lalu memindahkan nya ke data
                data[i][3] = String.valueOf(scanner.next());//Mengambil data dari file lalu memindahkan nya ke data
                data[i][4] = String.valueOf(scanner.next());//Mengambil data dari file lalu memindahkan nya ke data
                data[i][5] = String.valueOf(scanner.next());//Mengambil data dari file lalu memindahkan nya ke data
                data[i][6] = String.valueOf(scanner.next());//Mengambil data dari file lalu memindahkan nya ke data

                i++;
            }
            scanner.close();
            return data;
        } catch (FileNotFoundException e) {         //sebuah exception jika file tidak ada
            e.printStackTrace();
        }
        return null;
    }

    //===================== START OF MENGHITUNG VOLUME BANGUN RUANG ======================

    private synchronized void setVolumeKubus(double sisi) {
        this.volumeKubus = sisi*sisi*sisi;
        System.out.println("Volume Kubus : " + df.format(getVolumeKubus()));
    }

    private synchronized void setVolumeBalok(double panjang, double tinggi, double lebar){
        this.volumeBalok =panjang*tinggi*lebar;
        System.out.println("Volume Balok : " + df.format(getVolumeBalok()));
    }

    private synchronized void setVolumeTabung(double jariJari, double tinggi){
        this.volumeTabung = jariJari*tinggi*Math.PI;
        System.out.println("Volume Tabung : " + df.format(getVolumeTabung()));
    }

    private synchronized void setVolumeKerucut(double jariJari, double tinggi){
        this.volumeKerucut = Math.PI*jariJari*jariJari*tinggi/3;
        System.out.println("Volume Kerucut : " + df.format(getVolumeKerucut()));
    }

    private synchronized void setVolumeBola(double jariJari){
        this.volumeBola = Math.PI*jariJari*jariJari*jariJari*4/3;
        System.out.println("Volume Bola : " + df.format(getVolumeBola()));
    }

    private synchronized void setVolumePrimasSegiTiga(double panjang, double lebar, double tinggi){
        this.volumePrimasSegiTiga = panjang*lebar*tinggi/2;
        System.out.println("Volume Prisma Segitiga : " + df.format(getVolumePrimasSegiTiga()));
    }

    private synchronized void setVolumeLimasSegiTiga(double panjang, double lebar, double tinggi){
        this.volumeLimasSegiTiga = panjang*lebar*tinggi/3;
        System.out.println("Volume Limas Segi Tiga : " + df.format(getVolumeLimasSegiTiga()));
    }

    private synchronized void setVolumeLimasSegiEmpat(double panjang, double lebar, double tinggi){
        this.volumeLimasSegiEmpat = panjang*lebar*tinggi;
        System.out.println("Volume Limas Segi Empat : " + df.format(getVolumeLimasSegiEmpat()));
    }
    //==================== END OF MENGHITUNG VOLUME BANGUN RUANG ============================

    private double getVolumeKubus() {
        return volumeKubus;
    }

    private double getVolumeBalok() {
        return volumeBalok;
    }

    private double getVolumeTabung() {
        return volumeTabung;
    }

    private double getVolumeKerucut() {
        return volumeKerucut;
    }

    private double getVolumeBola() {
        return volumeBola;
    }

    private double getVolumePrimasSegiTiga() {
        return volumePrimasSegiTiga;
    }

    private double getVolumeLimasSegiTiga() {
        return volumeLimasSegiTiga;
    }

    private double getVolumeLimasSegiEmpat() {
        return volumeLimasSegiEmpat;
    }

//========================= START OF MENGHITUNG LUAS PERMUKAAN ===============================
    private synchronized void luasBalok(double panjang, double tinggi, double lebar){
    double luas =2*(panjang*lebar + panjang*tinggi + lebar*tinggi);
    System.out.println("Luas Permukaan Balok : " + luas);
}

    private synchronized void luasTabung(double jariJari, double tinggi){
        double luas = 2*Math.PI*jariJari*(tinggi*jariJari);
        System.out.println("Luas Permukaan Tabung : " + luas);
    }

    private synchronized void luasKerucut(double jariJari, double sisi){
        double luas = Math.PI*jariJari*(jariJari*sisi);
        System.out.println("Volume Kerucut : " + luas);
    }

    private synchronized void luasKubus(double sisi) {
        double luas = 6*sisi*sisi;
        System.out.println("Volume Kubus : " + luas);
    }

    private synchronized void luasLimasSegi4(double panjang, double lebar, double tinggi){
        double tselimut =Math.sqrt(Math.pow(panjang,2)+Math.pow(tinggi,2));  //Rumus pitagoras untuk mencari sisi miring
        double luas = (panjang * lebar) + (2*0.5*panjang*tselimut) + (2*0.5*lebar*tselimut);
        System.out.println("Volume Limas Segi Empat : " + luas);
    }

    private synchronized void luasLimasSegi3(double panjang, double lebar, double tinggi){
        double luas = 0.5*panjang*tinggi+(3*0.5*panjang*tinggi);
        System.out.println("Volume Limas Segi Tiga : " + luas);
    }

    private synchronized void luasPrismaSegitiga(double panjang, double lebar, double tinggi){
        double luas = (2*panjang*lebar/2*tinggi) +(3*tinggi*Math.sqrt(Math.pow(panjang,2)+Math.pow(lebar,2)));
        System.out.println("Volume Prisma Segitiga : " + luas);
    }

    private synchronized void luasBola(double jariJari){
        double luas = Math.PI*Math.pow(jariJari,2)*4;
        System.out.println("Volume Bola : " + luas);
    }

//=============================== END OF MENGHITUNG LUAS PERMUKAAN ================================


//    MEMASUKAN DATA ARRAY KE FILE
    private void writeToFileTigaD() {
        if (fileTableTigaD.exists()){
            fileTableTigaD.delete();
        }

        for (String[] strings : volume) {
            for (int y = 0; y < kolom; y++) {
                try {
                    FileWriter fileWriter = new FileWriter(fileTableTigaD, true);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    bufferedWriter.write(strings[y] + " ");
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                FileWriter fileWriter = new FileWriter(fileTableTigaD, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write("\n");
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

