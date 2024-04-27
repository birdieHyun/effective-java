package item8.autocloseable;

public class App {

    public static void main(String[] args) {

        String a = "";
        try (AutoCloseableIsGood good = new AutoCloseableIsGood()) {
            System.out.println("try with resource");
            a = good.getBr().nextLine();
            good.close();
        }

        System.out.println(a);
    }

}
