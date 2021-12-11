import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements MyInterface {

    public Server() throws RemoteException {}
    
    // Reverse
    public String reverse(String s) {
        Character c; 
        String s1 ="";
        for (int i=0; i<s1.length(); i++)
        {
          c= s1.charAt(i); 
          s1=c+s1; 
        }
        return s1 ;
    }
    
    
    // MinChar
    public Character minChar(String s){
        char c = 'z';
        for (int i=0; i<s.length()-1; i++)   
            if (s.charAt(i) < c)
                c = s.charAt(i);
        return c;         
    }
    
    
    // CaseChanger
    public String caseChanger(String s){
        StringBuffer b =new StringBuffer(s); 
        for (int i=0; i<s.length(); i++)
            if (Character.isLowerCase(s.charAt(i)))
            b.setCharAt(i, Character.toUpperCase(s.charAt(i)));
            else   b.setCharAt(i, Character.toLowerCase(s.charAt(i)));
        return b.toString();
    }
    
    
    

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        Server server = new Server();

        java.rmi.registry.LocateRegistry.createRegistry(1250);

        Naming.rebind("rmi://127.0.0.1:1250/server", server);
    }
}
