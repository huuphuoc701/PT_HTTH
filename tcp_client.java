import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;

public class tcp_client {
    public static void main(String[] args) throws Exception {

        Socket s= null ;
        try {
            s = new Socket("127.0.0.1", 123);
            System.out.println("Client duoc tao.");
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            for(int i='0'; i<= '9'; i++){
                os.write(i);
                int ch = is.read();
                System.out.println((char)ch);
                Thread.sleep(500);
            }
        } catch (Exception e) {
            System.out.println("Lỗi client.");
        }finally{
            if (s!= null){
                s.close();
            }
        }

        
    }
}
    
