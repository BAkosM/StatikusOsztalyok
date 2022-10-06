import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
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
    private static List<String> sportag = feltolt("files/sportag.txt");  
    private static List<String> egyesulet = feltolt("files/egyesulet.txt");

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
    public static char velKarakter(char min, char max){
        return (char)velEgesz(min, max);
    }
    public static String velVezetekNev(){
        return vezNevek.get(rnd.nextInt(vezNevek.size()));
    }
    public static String velKeresztNev(boolean nem){
        String keresztNev = null;
        if (nem){
            keresztNev = velFerfiKeresztNev();
        } else {
            keresztNev = velNoiKeresztNev();
        }
        return keresztNev;
    }
    private static String velFerfiKeresztNev(){
        return ferfiKerNevek.get(rnd.nextInt(ferfiKerNevek.size()));
    }
    private static String velNoiKeresztNev(){
        return noiKerNevek.get(rnd.nextInt(noiKerNevek.size()));   
    }
    public static String velTeljesNev(boolean nem){
        return velVezetekNev() + " " + velKeresztNev(nem);
    }
    public static String velDatum(int min, int max){
        int ev = velEgesz(min, max);
        int ho = velEgesz(1, 12);
        int maxnap = 1;
        if (ho == 1||ho==3||ho==5||ho==7||ho==8||ho==10||ho==12){
            maxnap = 31;
        }else if(ho ==11||ho==9||ho==6||ho==4){
            maxnap = 30;
        }else if(ev%4==0){
            maxnap = 29;
        }else{
            maxnap = 28;
        }
        return ev+"-"+ho+"-"+velEgesz(1, maxnap);
    }
    public static String velEmail(boolean nem){
        return (velVezetekNev().toLowerCase() + velKeresztNev(nem).toLowerCase() + velEgesz(01, 99) + "@gmail.com");
    }
    public static String velMobil(){
        return "+36 (30) "+velEgesz(0, 9)+velEgesz(0, 9)+velEgesz(0, 9)+"-"+velEgesz(0, 9)+velEgesz(0, 9)+"-"+velEgesz(0, 9)+velEgesz(0, 9);
    }
    public static String velSportag(){
        return sportag.get(rnd.nextInt(sportag.size()));
    }
    public static String velEgyesulet(){
        return egyesulet.get(rnd.nextInt(egyesulet.size()));
    }
}