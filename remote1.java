import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class remote1 extends UnicastRemoteObject implements inter_remote1{
 // Khai báo phương thức khởi tạo
 public remote1() throws RemoteException{
 }

    public double cong(double a, double b) throws RemoteException{
        return a+b;
    }
    public double tru(double a, double b) throws RemoteException{
        return a-b;
    }
    public double nhan(double a, double b) throws RemoteException{
        return a*b;
    }
    public double chia(double a, double b) throws RemoteException{
        return a/b;
    }
    // Viết xử lý cho phương thức tính bình phương
    public double square(double a, double b) throws RemoteException {
        return a*a;
        
    }
}

// public class remote1 {
    
// }
