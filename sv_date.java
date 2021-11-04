import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Scanner;

public class sv_date {
    public static void main(String[] args) throws Exception {
        // tao server
        ServerSocket sv3 = new ServerSocket(333);
        System.out.println("Server được tạo.");
        Scanner sc = new Scanner(System.in);
        Socket cl3 = sv3.accept();
        System.out.println("Da ket noi client.");
        
        while (true) {
            try {
            //Tạo input stream, nối tới Socket
            BufferedReader inClient =
                new BufferedReader(new
                    InputStreamReader(cl3.getInputStream())); 
            //Tạo outputStream, nối tới socket
            DataOutputStream outClient = new DataOutputStream(cl3.getOutputStream());
            DataOutputStream outClient1 = new DataOutputStream(cl3.getOutputStream());
            
            int client_in;
                            // outClient.writeBytes(s); 
                do {
                    outClient1.writeUTF("1. Xem ngày | 2. Xem giờ | 3. Thoát -----"+"\n");
                    outClient1.flush();
                    client_in= inClient.read();
                        switch (client_in) {
                            case 1:
                             String s1 = "Hom nay: " + java.time.LocalDate.now() + "          ";
                             outClient.writeBytes(s1);
                             outClient.flush();
                             break;
                            case 2:
                             String s2 = "Gio hien tai: " + java.time.LocalTime.now() + "         " ;
                             outClient.writeBytes(s2);
                             outClient.flush();
                             break;
                            case 3:
                             String s3 = "Tạm biệt!";
                            outClient1.writeUTF("3. Thoát -----"+"\n");
                            // outClient.writeBytes(s3+'\n');
                             System.exit(0); // thoát chương trình
                             break;
                        }
                } while ((client_in < 1) || (client_in >= 3));
            } catch (Exception e) {
                System.out.println("Server lỗi!");
                sv3.close();
            }
            
        }
    }
}
