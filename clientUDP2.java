import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/*
    * Tính tổng 2 số
*/
public class clientUDP2 {
    public static void main(String []args) throws IOException
    {
        //tao moi socket client
        int port = 1024;
        DatagramSocket ClientSocket = new DatagramSocket();
        System.out.println("Đã tạo client. ");

        //nhap yeu cau tu nguoi dung
        DataInputStream inFromUser = new DataInputStream(System.in);
        int a,b,tong;
        while (true) {
            try{
                System.out.println("Nhap vao so a :");
                a = Integer.parseInt(inFromUser.readLine());
                // System.out.println("Nhap vao so b :");
                // b = Integer.parseInt(inFromUser.readLine());
                //Khai bao mang byte de chua du lieu gui di server
                byte outToServer1[];
                byte outToServer2[];
                //chuyen kieu du lieu : int -> String
                String s1 = String.valueOf(a);
                // String s2 = String.valueOf(b);
                //chuyen kieu du lieu : String -> byte va dua vao mang byte da khai bao o tren
                outToServer1 = s1.getBytes();
                // outToServer2 = s2.getBytes();
                //lay kich thuoc cua mang
                int leng1 = outToServer1.length;
                // int leng2 = outToServer2.length;
                //dia chi may chu
                InetAddress address = InetAddress.getByName("Localhost");
                // kết nối server số port: 
                System.out.println("Đã tìm thấy máy chủ port: "+port);
                // tao goi de gui di
                DatagramPacket toServer1 = new DatagramPacket(outToServer1, leng1, address, port);
                // DatagramPacket toServer2 = new DatagramPacket(outToServer2, leng2, address, port);
                // gui goi len server
                ClientSocket.send(toServer1);
                // ClientSocket.send(toServer2);
                System.out.println("Đã gửi đến máy chủ port: "+port);
                //tao goi de nhan du lieu ve
                byte inFromServer[];
                inFromServer = new byte[256];
                //kich thuoc mang nhan du lieu ve
                leng1 = inFromServer.length;     
                // tao goi nhan du lieu ve
                DatagramPacket fromServer = new DatagramPacket(inFromServer, leng1);       
                // nhan goi tra ve tu server
                System.out.println("Máy chủ trả về: ");
                ClientSocket.receive(fromServer);           
                //khai bao bien de chuyen tu kieu byte sang kieu String
                String data;
                // dua du lieu tu mang byte vao bien data, lay tu vi tri so 0.
                data = (new String(fromServer.getData(),0,fromServer.getLength())).trim();
                //in ket qua ra man hinh
                System.out.println("Ket Qua :"+data);
                // ClientSocket.close();
                
            }catch (UnknownHostException e)
            {
                System.out.println("Server Not Found");
                System.exit(1);
            }catch (IOException e)
            {
                System.out.println("Cannot connect to server");
                System.exit(1);
            }
        }
        

    }

}