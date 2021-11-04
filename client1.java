import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
// import org.w3c.dom.Text;

// import org.w3c.dom.Text;

public class client1 {
  public static void main(String[] args) {
    Scanner nhap = new Scanner(System.in);
    while (true) {
      try {
        // Gọi server đang lắng nghe tại cổng 7777
        Registry reg = LocateRegistry.getRegistry("localhost", 7777);
        // Lấy đối tượng từ xa
        inter_remote1 cal = (inter_remote1) reg.lookup("RMICalSer");
        // Object txtNum;
        // Gọi phương thức từ xa
        // double result = cal.square(Double.parseDouble(setText(test.getText())));
        // Object lblResult;
        // Hiển thị kết quả
        // lblResult.setText(String.valueOf(result));
  
        try {
          System.out.println("nhap a: ");
        double a= nhap.nextDouble();
        System.out.println("nhap a: ");
        double b= nhap.nextDouble();
        double tong =cal.cong(a, b);
        double hieu =cal.tru(a, b);
        double tich =cal.nhan(a, b);
        double thuong =cal.chia(a, b);

        System.out.println("Tổng "+a+" + "+b+" = "+tong);
        System.out.println("Tổng "+a+" - "+b+" = "+hieu);
        System.out.println("Tổng "+a+" * "+b+" = "+tich);
        System.out.println("Tổng "+a+" / "+b+" = "+thuong);

        } catch (Exception e) {
          System.out.println("Loi nhap không phải số!");
          break;
        }
  
        
  
      } catch (Exception e) {
         e.printStackTrace();
         System.out.println("Lỗi kết nối sv.");
         break;
      }
    

    } //while
  }
    
    
}
