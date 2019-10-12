public class SingeltonPattern {
    public static void main(String[] args) {
        Singelton singelton = Singelton.getInstance();
        singelton.counter = 5;

        Singelton singelton1 = Singelton.getInstance();

        System.out.println(singelton1.counter);
    }
}

class Singelton {

    int counter = 0;
    private static Singelton instance = new Singelton();
    private Singelton() {

    }

    static Singelton getInstance() {
        return instance;
    }
}