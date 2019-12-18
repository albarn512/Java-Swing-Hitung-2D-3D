import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DuaDimensi {

    private File file = new File("tabel.txt");

    public DuaDimensi(){
        getBanyakData();
        getData();
        hitungLuas();
        System.out.println();
        hitungKeliling();
    }

    void hitungLuas(){

        String data[][] = getData(); // mengambil data

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
        threadPersegiPanjang.start();
        threadSegitiga.start();
        threadBelahKetupat.start();
        threadJajarGenjang.start();
        threadLayang.start();
        threadLingkaran.start();
        threadTrapesium.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    void hitungKeliling(){
        String data[][] = getData(); // mengambil data

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
                    //kode diatas untuk memasukkan nilai panjang dan sisi samping
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
                    //kode diatas untuk memasukkan nilai alas, sisi miring dan atap
                }
            }
        });

        threadKPersegi.start();         //memulai thread Keliling Persegi
        threadKPersegiPanjang.start();  //memulai thread Keliling Persegi Panjang
        threadKSegitiga.start();        //memulai thread Keliling Segitiga
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
        } catch (FileNotFoundException e) {     //sebuah exception jika file tidak ada
            e.printStackTrace();
        }
        return 0;
    }

    public String[][] getData(){
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

    public synchronized void luasLayang(double diagonal1, double diagonal2){
        double luas = diagonal1 * diagonal2;
        System.out.println("Luas Layang Layang : " + luas);
    }

    public synchronized void luasPersegi(double sisi){
        double luas = sisi*sisi;
        System.out.println("Luas Persegi : " + luas);
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
        double luas = jariJari*jariJari*Math.PI/2;
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
//============== END OF MENGHITUNG LUAS BANGUN DATAR ===================

//============== START OF MENGHITUNG KELILING BANGUN DATAR ===============

    public synchronized void kelilingSegitiga(double alas, double tinggi){
        double sisi = Math.sqrt(Math.pow(alas,2)+Math.pow(tinggi,2));  //Rumus pitagoras untuk mencari sisi miring
        double keliling = alas+sisi+sisi;
        System.out.println("Keliling Segitiga : " + keliling);
    }

    public synchronized void kelilingLayang(double diagonal1, double diagonal2){
        double sisi = Math.sqrt(Math.pow(diagonal1/2,2)+Math.pow(diagonal2/2,2)); //Rumus pitagoras untuk mencari sisi miring
        double keliling = sisi*4;
        System.out.println("Keliling Layang Layang : " + keliling);
    }

    public synchronized void kelilingPersegi(double sisi){
        double keliling = sisi*4;
        System.out.println("Keliling Peregi : " + keliling);
    }

    public synchronized void kelilingBelahKetupat(double diagonal1, double diagonal2){
        double sisi = Math.sqrt(Math.pow(diagonal1/2,2)+Math.pow(diagonal2/2,2)); //Rumus pitagoras untuk mencari sisi miring
        double keliling = sisi*4;
        System.out.println("Keliling Belah Ketupat : " + keliling);
    }

    public synchronized void kelilingJajarGenjang(double panjang, double diagonal1){
        double keliling = 2*panjang + 2*diagonal1;
        System.out.println("Keliling Jajar Genjang : " + keliling);
    }

    public synchronized void kelilingPersegiPanjang(double panjang, double lebar){
        double keliling = 2*panjang + 2*lebar;
        System.out.println("Keliling Persegi Panjang : " + keliling);
    }

    public synchronized void kelilingLingkaran(double jariJari){
        double keliling = 2*jariJari*Math.PI;
        System.out.println("Keliling Lingkaran : " + keliling);
    }

    public synchronized void kelilingTrapesium(double alas, double diagonal1, double atap){
        double keliling =alas+atap+2*diagonal1;
        System.out.println("Luas Trapesium : " + keliling);
    }

//============== END OF MENGHITUNG KELILING BANGUN DATAR =======================
}
