import java.rmi.Naming;

public class Client {

    public static void main(String[] args) {
        try {
           MyInterface service = (MyInterface) Naming.lookup("rmi://127.0.0.1:1250/server");
           Scanner s = new Scanner(System.in);
           String s1 = s.nextLine();
           System.out.println(service.reverse(s1));
           s1= s.nextLine();
           System.out.println(service.minChar(s1));
           s1= s.nextLine();
           System.out.println(service.upperLower(s1));
           scanner.close();
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
