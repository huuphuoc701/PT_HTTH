import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class server1 {
    public static void main(String[] args) {
        try {
            //Tạo đối tượng Registry
            Registry reg = LocateRegistry.createRegistry(7777);
            //Đăng ký Remote Object
            inter_remote1 ci = new remote1();
            reg.bind("RMICalSer", ci);
            
           } catch (Exception e) {
              e.printStackTrace();
           }
    }
}
