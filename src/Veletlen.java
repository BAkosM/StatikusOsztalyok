import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Veletlen{
    private Veletlen(){
        
    }
    private static final Random rnd = new Random();
    private static List<String> vezNevek = feltolt("files/veznev.txt");
    private static List<String> ferfiKerNevek = feltolt("files/ferfikernev.txt");
    private static List<String> noiKerNevek = feltolt("files/noikernev");
    private static List<String> feltolt(String fajlnev){
        List<String> lista = new ArrayList<String>();
        try{
            Scanner file = new Scanner(new File(fajlnev));
            while(file.hasNext()){
                String sor = file.nextLine();
                lista.add(sor);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return lista;
    }
    public static int velEgesz(int min, int max){
        return rnd.nextInt(max - min + 1) + min;
    }
}