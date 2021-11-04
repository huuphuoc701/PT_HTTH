import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
public class tcp_server {
    public final static int serverPort = 123;
    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(serverPort);
            System.out.println("Server chạy.");
            while (true) {
                try {
                    Socket s = ss.accept();
                    OutputStream os =s.getOutputStream();
                    InputStream is= s.getInputStream();
                    int ch = 0;
                    while (true) {
                        ch = is.read();
                        if(ch == -1){
                            break;
                        }
                        System.out.println("Client gui: "+(char)ch);
                        os.write(ch);
                    }
                    s.close();
                } catch (Exception e) {
                    System.out.println("Server lỗi: "+e);
                }           
            }
        }catch(IOException ie){
            System.out.println("Server lỗi: "+ie);
        }
    }
}
