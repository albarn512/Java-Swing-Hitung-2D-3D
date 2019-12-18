import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TigaDimensi {
    private File file = new File("tabel.txt");

    public TigaDimensi(){
        getBanyakData();
        getData();
        hitungVolume();
        System.out.println();
        hitungLuasPermukaan();
    }

    void hitungVolume(){

        String data[][] = getData();

        Thread threadTabung = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<getBanyakData(); i++) {
                    volumeTabung(Double.parseDouble(data[i][4]), Double.parseDouble(data[i][3]));
                    //kode di atas untuk mengirim data jari jari dan tinggi
                }
            }
        });

        Thread threadBalok = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<getBanyakData(); i++) {
                    volumeBalok(Double.parseDouble(data[i][0]), Double.parseDouble(data[i][3]), Double.parseDouble(data[i][2]));
                    //kode di atas untuk mengirim data panjang, tinggi, lebar
                }
            }
        });

        Thread threadKubus = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<getBanyakData(); i++) {
                    volumeKubus(Double.parseDouble(data[i][1]));
                    //kode di atas untuk mengirim data sisi
                }
            }
        });

        Thread threadKerucut = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<getBanyakData(); i++) {
                    volumeKerucut(Double.parseDouble(data[i][4]), Double.parseDouble(data[i][3]));
                    //kode di atas untuk mengirim data jari jari dan tinggi
                }
            }
        });

        Thread threadLimasSegiEmpat = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<getBanyakData(); i++) {
                    volumeLimasSegi4(Double.parseDouble(data[i][0]), Double.parseDouble(data[i][2]), Double.parseDouble(data[i][3]));
                    //kode di atas untuk mengirim data panjang, lebar, tinggi
                }
            }
        });

        Thread threadLimasSegiTiga = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<getBanyakData(); i++) {
                    volumeLimasSegi3(Double.parseDouble(data[i][0]), Double.parseDouble(data[i][2]), Double.parseDouble(data[i][3]));
                    //kode di atas untuk mengirim data panjang, lebar(digunakan sebagai tinggi alas segitia),tinggi
                }
            }
        });

        Thread threadPrismaSegitiga = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<getBanyakData(); i++) {
                    volumePrismaSegitiga(Double.parseDouble(data[i][0]), Double.parseDouble(data[i][2]), Double.parseDouble(data[i][3]));
                    //kode di atas untuk mengirim data panjang, lebar(digunakan sebagai tinggi alas segitia), tinggi
                }
            }
        });

        Thread threadBola = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<getBanyakData(); i++) {
                    volumeBola(Double.parseDouble(data[i][4]));
                    //kode di atas untuk mengirim data jari jari
                }
            }
        });

//==========MEMULAI THREAD=================
        threadBalok.start();
        threadBola.start();
        threadKerucut.start();
        threadKubus.start();
        threadLimasSegiEmpat.start();
        threadLimasSegiTiga.start();
        threadPrismaSegitiga.start();
        threadTabung.start();
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
    
    void hitungLuasPermukaan(){
        String data[][] = getData();  // mengambil data

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
    public int getBanyakData() {
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

    public String[][] getData(){
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
    public synchronized void volumeBalok(double panjang, double tinggi, double lebar){
        double volume =panjang*tinggi*lebar;
        System.out.println("Volume Balok : " + volume);
    }

    public synchronized void volumeTabung(double jariJari, double tinggi){
        double volume = jariJari*tinggi*Math.PI;
        System.out.println("Volume Tabung : " + volume);
    }

    public synchronized void volumeKerucut(double jariJari, double tinggi){
        double volume = Math.PI*jariJari*jariJari*tinggi/3;
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

//==================== END OF MENGHITUNG VOLUME BANGUN RUANG ============================

//========================= START OF MENGHITUNG LUAS PERMUKAAN ===============================
    public synchronized void luasBalok(double panjang, double tinggi, double lebar){
    double luas =2*(panjang*lebar + panjang*tinggi + lebar*tinggi);
    System.out.println("Luas Permukaan Balok : " + luas);
}

    public synchronized void luasTabung(double jariJari, double tinggi){
        double luas = 2*Math.PI*jariJari*(tinggi*jariJari);
        System.out.println("Luas Permukaan Tabung : " + luas);
    }

    public synchronized void luasKerucut(double jariJari, double sisi){
        double luas = Math.PI*jariJari*(jariJari*sisi);
        System.out.println("Volume Kerucut : " + luas);
    }

    public synchronized void luasKubus (double sisi) {
        double luas = 6*sisi*sisi;
        System.out.println("Volume Kubus : " + luas);
    }

    public synchronized void luasLimasSegi4(double panjang, double lebar, double tinggi){
        double tselimut =Math.sqrt(Math.pow(panjang,2)+Math.pow(tinggi,2));  //Rumus pitagoras untuk mencari sisi miring
        double luas = (panjang * lebar) + (2*0.5*panjang*tselimut) + (2*0.5*lebar*tselimut);
        System.out.println("Volume Limas Segi Empat : " + luas);
    }

    public synchronized void luasLimasSegi3(double panjang, double lebar, double tinggi){
        double luas = 0.5*panjang*tinggi+(3*0.5*panjang*tinggi);
        System.out.println("Volume Limas Segi Tiga : " + luas);
    }

    public synchronized void luasPrismaSegitiga(double panjang, double lebar, double tinggi){
        double luas = (2*panjang*lebar/2*tinggi) +(3*tinggi*Math.sqrt(Math.pow(panjang,2)+Math.pow(lebar,2)));
        System.out.println("Volume Prisma Segitiga : " + luas);
    }

    public synchronized void luasBola(double jariJari){
        double luas = Math.PI*Math.pow(jariJari,2)*4;
        System.out.println("Volume Bola : " + luas);
    }

//=============================== END OF MENGHITUNG LUAS PERMUKAAN ================================
}
