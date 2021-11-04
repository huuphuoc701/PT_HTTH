
import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Scanner;

public class client_date {
    public static void main(String[] args) throws Exception {
        Socket cl3= null ;
        Scanner sc = new Scanner(System.in);
        try {
            cl3 = new Socket("127.0.0.1", 333);
            System.out.println("Client duoc tao.");
            InputStream is = cl3.getInputStream();
            OutputStream os = cl3.getOutputStream();
            int i;
            DataOutputStream outServer = new DataOutputStream(cl3.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(cl3.getInputStream()));
                String server_in = inFromServer.readLine();

                System.out.println("SERVER: " + server_in);
                System.out.println("1. Xem ngày | 2. Xem giờ | 3. Thoát");
                // System.out.println("\n");
            do{             
                System.out.println("nhap i: ");
                i = sc.nextInt();        
                    os.write(i);
                server_in = inFromServer.readLine();
                System.out.println("");
                System.out.printf("SERVER: " + server_in);
                System.out.println("\n");
                // server_in = inFromServer.readLine();    
                if(i ==3){
                    System.out.println("Client đóng.");
                    cl3.close();
                    break;
                }
            } while (i <= 3);
        } catch (Exception e) {
            // System.out.println("Lỗi client.");
        }finally{
            if (cl3 != null){
                cl3.close();
            }
        }        
    }
}
