import java.rmi.Remote;
import java.rmi.RemoteException;

public interface inter_remote1 extends Remote {

public double cong(double a, double b) throws RemoteException;
public double tru(double a, double b) throws RemoteException;
public double nhan(double a, double b) throws RemoteException;
public double chia(double a, double b) throws RemoteException;
 // Khai báo phương thức tính bình phương
 public double square(double a, double b) throws RemoteException;
}


