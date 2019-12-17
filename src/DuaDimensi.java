import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DuaDimensi {

    protected Float[] sisi, panjang, lebar, tinggi, jariJari,diagonal1, diagonal2;
    private File file = new File("tabel.txt");
    public DuaDimensi(){
        getBanyakData();
        getData();
        
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

                panjang[i] = Float.parseFloat(data[i][0]);
                sisi[i] = Float.parseFloat(data[i][1]);
                lebar[i] = Float.parseFloat(data[i][2]);
                tinggi[i] = Float.parseFloat(data[i][3]);
                jariJari[i] = Float.parseFloat(data[i][4]);
                diagonal1[i] = Float.parseFloat(data[i][5]);
                diagonal2[i] = Float.parseFloat(data[i][6]);

                i++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



}
