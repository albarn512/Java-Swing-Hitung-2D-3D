package bangun;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.logging.Logger;

public class DuaDimensi {

    private File file = new File("tabel.txt");
    private File fileTableDuaD = new File("tabelDuaDimensi.txt");

    private DecimalFormat df = new DecimalFormat("#.##");

    private int kolom = 8;
    private String[][] luas = new String[getBanyakData()][kolom];

    private double luasPersegi;
    private double luasPersegiPanjang;
    private double luasSegitiga;
    private double luasTrapesium;
    private double luasLayangLayang;
    private double luasBelahKetupat;
    private double luasJajarGenjang;
    private double luasLingkaran;

    public DuaDimensi(){
        getBanyakData();
        getData();
        hitungLuas();
        System.out.println();
        hitungKeliling();
        writeToFileDuaD();
    }

    private void hitungLuas(){

        String[][] data = getData(); // mengambil data

            Thread threadLuasPersegi = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0;i<getBanyakData();i++) {
                        setLuasPersegi(Double.parseDouble(data[i][1]));
                        //kode diatas untuk memasukkan nilai sisi
                        luas[i][0] = String.valueOf(df.format(getLuasPersegi()));
                    }
                }
            });

            Thread threadLuasPersegiPanjang = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0; i<getBanyakData(); i++) {
                        setLuasPersegiPanjang(Double.parseDouble(data[i][0]), Double.parseDouble(data[i][2]));
                        //kode diatas untuk memasukkan nilai panjang dan lebar
                        luas[i][1] = String.valueOf(df.format(getLuasPersegiPanjang()));
                    }
                }
            });

            Thread threadLuasSegitiga = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0; i<getBanyakData(); i++) {
                        setLuasSegitiga(Double.parseDouble(data[i][0]), Double.parseDouble(data[i][3]));
                        //kode diatas untuk memasukkan nilai panjang(sebagai alas) dan tinggi
                        luas[i][2] = String.valueOf(df.format(getLuasSegitiga()));
                    }
                }
            });

            Thread threadTrapesium = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0; i<getBanyakData(); i++) {
                        setLuasTrapesium(Double.parseDouble(data[i][0]), Double.parseDouble(data[i][3]), Double.parseDouble(data[i][2]));
                        //kode diatas untuk memasukkan nilai panjang(alas),lebar(atap) dan tinggi
                        luas[i][3] = String.valueOf(df.format(getLuasTrapesium()));
                    }
                }
            });

            Thread threadLayang = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0; i<getBanyakData(); i++) {
                        setLuasLayangLayang(Double.parseDouble(data[i][5]), Double.parseDouble(data[i][6]));
                        //kode diatas untuk memasukkan nilai diagonal 1 dan diagonal 2
                        luas[i][4] = String.valueOf(df.format(getLuasLayangLayang()));
                    }
                }
            });

            Thread threadBelahKetupat = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0; i<getBanyakData(); i++) {
                        setLuasBelahKetupat(Double.parseDouble(data[i][5]), Double.parseDouble(data[i][6]));
                        //kode diatas untuk memasukkan nilai diagonal 1 dan diagonal 2
                        luas[i][5] = String.valueOf(df.format(getLuasBelahKetupat()));
                    }
                }
            });

            Thread threadJajarGenjang = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0; i<getBanyakData(); i++) {
                        setLuasJajarGenjang(Double.parseDouble(data[i][0]), Double.parseDouble(data[i][3]));
                        //kode diatas untuk memasukkan nilai panjang dan tinggi
                        luas[i][6] = String.valueOf(df.format(getLuasJajarGenjang()));
                    }
                }
            });

            Thread threadLingkaran = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0; i<getBanyakData(); i++) {
                        setLuasLingkaran(Double.parseDouble(data[i][4]));
                        //kode diatas untuk memasukkan nilai jari jari
                        luas[i][7] = String.valueOf(df.format(getLuasLingkaran()));
                    }
                }
            });


//======== MEMULAI THREAD ==============
        threadLuasPersegi.start();
        threadLuasPersegiPanjang.start();
        threadLuasSegitiga.start();
        threadTrapesium.start();
        threadLayang.start();
        threadBelahKetupat.start();
        threadJajarGenjang.start();
        threadLingkaran.start();
//======================================

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
    private void hitungKeliling(){
        String[][] data = getData(); // mengambil data

        Thread threadKPersegi = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<getBanyakData();i++) {
                    kelilingPersegi(Double.parseDouble(data[i][1]));
                    //kode diatas untuk memasukkan nilai sisi
                }
            }
        });

        Thread threadKPersegiPanjang = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<getBanyakData(); i++) {
                    kelilingPersegiPanjang(Double.parseDouble(data[i][0]), Double.parseDouble(data[i][2]));
                    //kode diatas untuk memasukkan nilai panjang dan lebar
                }
            }
        });

        Thread threadKSegitiga = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<getBanyakData(); i++) {
                    kelilingSegitiga(Double.parseDouble(data[i][0]), Double.parseDouble(data[i][3]));
                    //kode diatas untuk memasukkan nilai alas dan tinggi
                }
            }
        });

        Thread threadKLayang = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<getBanyakData(); i++) {
                    kelilingLayang(Double.parseDouble(data[i][5]), Double.parseDouble(data[i][6]));
                    //kode diatas untuk memasukkan nilai diagonal 1 dan diagonal 2
                }
            }
        });

        Thread threadKBelahKetupat = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<getBanyakData(); i++) {
                    kelilingBelahKetupat(Double.parseDouble(data[i][5]), Double.parseDouble(data[i][6]));
                    //kode diatas untuk memasukkan nilai diagonal 1 dan diagonal 2
                }
            }
        });

        Thread threadKJajarGenjang = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<getBanyakData(); i++) {
                    kelilingJajarGenjang(Double.parseDouble(data[i][0]), Double.parseDouble(data[i][5]));
                    //kode diatas untuk memasukkan nilai panjang dan sisi samping (menggunakan diagonal 1)
                }
            }
        });

        Thread threadKLingkaran = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<getBanyakData(); i++) {
                    kelilingLingkaran(Double.parseDouble(data[i][4]));
                    //kode diatas untuk memasukkan nilai jari jari
                }
            }
        });

        Thread threadKTrapesium = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<getBanyakData(); i++) {
                    kelilingTrapesium(Double.parseDouble(data[i][0]), Double.parseDouble(data[i][5]), Double.parseDouble(data[i][2]));
                    //kode diatas untuk memasukkan nilai panjang(alas),lebar(atap)dan sisi miring(menggunakan diagonal 1)
                }
            }
        });

        threadKPersegi.start();         //memulai thread Keliling Persegi
        threadKPersegiPanjang.start();  //memulai thread Keliling Persegi Panjang
        threadKSegitiga.start();        //memulai thread Keliling LuasSegitiga
        threadKBelahKetupat.start();    //memulai thread Keliling Belah Ketupat
        threadKJajarGenjang.start();    //memulai thread Keliling Jajar Genjang
        threadKLayang.start();          //memulai thread Keliling Layangan
        threadKLingkaran.start();       //memulai thread Keliling Lingkaran
        threadKTrapesium.start();       //memulai thread Keliling Trapesium

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
        } catch (FileNotFoundException e) {     //sebuah exception jika file tidak ada
            e.printStackTrace();
        }
        return 0;
    }

    private String[][] getData(){
        int i = 0;
        String data[][] = new String[getBanyakData()][7];
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);  //memindai file yang bernama table.txt
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
        } catch (FileNotFoundException e) {     //sebuah exception jika file tidak ada
            e.printStackTrace();
        }
        return null;
    }

//===================== START OF MENGHITUNG LUAS BANGUN DATAR ===================

    private synchronized void setLuasPersegi(double sisi){
        this.luasPersegi = sisi*sisi;
        System.out.println("Luas Persegi : " + df.format(getLuasPersegi()));
    }

    private synchronized void setLuasPersegiPanjang(double panjang, double lebar){
        this.luasPersegiPanjang = panjang*lebar;
        System.out.println("Luas Persegi Panjang : " + df.format(getLuasPersegiPanjang()));
    }

    private synchronized void setLuasSegitiga(double alas, double tinggi){
        this.luasSegitiga = alas*tinggi/2;
        System.out.println("Luas Segitiga : " + df.format(getLuasSegitiga()));
    }

    private synchronized void setLuasTrapesium(double alas, double tinggi, double atap){
        this.luasTrapesium = (alas+atap)*tinggi/2;
        System.out.println("Luas Trapesium : " + df.format(getLuasTrapesium()));
    }

    private synchronized void setLuasLayangLayang(double diagonal1, double diagonal2){
        this.luasLayangLayang = diagonal1 * diagonal2;
        System.out.println("Luas Layang Layang : " + df.format(getLuasLayangLayang()));
    }

    private synchronized void setLuasBelahKetupat(double diagonal1, double diagonal2){
        this.luasBelahKetupat = diagonal1 * diagonal2/2;
        System.out.println("Luas Belah Ketupat : " + df.format(getLuasBelahKetupat()));
    }

    private synchronized void setLuasJajarGenjang(double panjang, double tinggi){
        this.luasJajarGenjang = panjang * tinggi;
        System.out.println("Luas Jajar Genjang : " + df.format(getLuasJajarGenjang()));
    }

    private synchronized void setLuasLingkaran(double jariJari){
        this.luasLingkaran = jariJari*jariJari*Math.PI/2;
        System.out.println("Luas Lingkaran : " + df.format(getLuasLingkaran()));
    }

//============== END OF MENGHITUNG LUAS BANGUN DATAR ===================

    private double getLuasPersegi() {
        return luasPersegi;
    }

    private double getLuasPersegiPanjang() {
        return luasPersegiPanjang;
    }

    private double getLuasSegitiga() {
        return luasSegitiga;
    }

    private double getLuasTrapesium() {
        return luasTrapesium;
    }

    private double getLuasLayangLayang() {
        return luasLayangLayang;
    }

    private double getLuasBelahKetupat() {
        return luasBelahKetupat;
    }

    private double getLuasJajarGenjang() {
        return luasJajarGenjang;
    }

    private double getLuasLingkaran() {
        return luasLingkaran;
    }

//============== START OF MENGHITUNG KELILING BANGUN DATAR ===============

    private synchronized void kelilingSegitiga(double alas, double tinggi){
        double sisi = Math.sqrt(Math.pow(alas,2)+Math.pow(tinggi,2));  //Rumus pitagoras untuk mencari sisi miring
        double keliling = alas+sisi+sisi;
        System.out.println("Keliling Segitiga : " + keliling);
    }

    private synchronized void kelilingLayang(double diagonal1, double diagonal2){
        double sisi = Math.sqrt(Math.pow(diagonal1/2,2)+Math.pow(diagonal2/2,2)); //Rumus pitagoras untuk mencari sisi miring
        double keliling = sisi*4;
        System.out.println("Keliling Layang Layang : " + keliling);
    }

    private synchronized void kelilingPersegi(double sisi){
        double keliling = sisi*4;
        System.out.println("Keliling Peregi : " + keliling);
    }

    private synchronized void kelilingBelahKetupat(double diagonal1, double diagonal2){
        double sisi = Math.sqrt(Math.pow(diagonal1/2,2)+Math.pow(diagonal2/2,2)); //Rumus pitagoras untuk mencari sisi miring
        double keliling = sisi*4;
        System.out.println("Keliling Belah Ketupat : " + keliling);
    }

    private synchronized void kelilingJajarGenjang(double panjang, double diagonal1){
        double keliling = 2*panjang + 2*diagonal1;
        System.out.println("Keliling Jajar Genjang : " + keliling);
    }

    private synchronized void kelilingPersegiPanjang(double panjang, double lebar){
        double keliling = 2*panjang + 2*lebar;
        System.out.println("Keliling Persegi Panjang : " + keliling);
    }

    private synchronized void kelilingLingkaran(double jariJari){
        double keliling = 2*jariJari*Math.PI;
        System.out.println("Keliling Lingkaran : " + keliling);
    }

    private synchronized void kelilingTrapesium(double alas, double diagonal1, double atap){
        double keliling =alas+atap+2*diagonal1;
        System.out.println("Luas Trapesium : " + keliling);
    }

//============== END OF MENGHITUNG KELILING BANGUN DATAR =======================


    private void writeToFileDuaD() {
        if (fileTableDuaD.exists()){
            fileTableDuaD.delete();
        }

        for (String[] lua : luas) {
            for (int y = 0; y < kolom; y++) {
                try {
                    FileWriter fileWriter = new FileWriter(fileTableDuaD, true);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    bufferedWriter.write(lua[y] + " ");
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                FileWriter fileWriter = new FileWriter(fileTableDuaD, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write("\n");
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
