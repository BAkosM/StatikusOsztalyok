public class Main {
    public static void main(String[] args) {
        for(int i = 0; i <100; i++){
            System.out.println(Veletlen.velEgesz(5, 10));
        }
        for (int i = 0; i < 50; i++){
            System.out.println(Veletlen.velKarakter((char)65,(char) 90));
            System.out.println(Veletlen.velKarakter('A','Z'));
        }
        for (int i = 0; i < 5; i++){
            System.out.println(Veletlen.velTeljesNev(true));
        }
        for (int i = 0; i < 5; i++){
            System.out.println(Veletlen.velTeljesNev(false));
        }
    }
}