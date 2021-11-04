
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


// 1952691 - Nguyễn Hửu Phước
public class serverDe4 {
    private static final String FILE_URL3 = "/Users/huuphuoc/OneDrive/HOC_ky5/TH_PTHTTH/GK/src/data6.txt";

    private static String x;
    public static void main(String[] args) {
        try {
            //Tạo socket phía server với số hiệu cổng 9876
            DatagramSocket serverSocket = new DatagramSocket(9876);   
            System.out.println("Server da duoc tao!");

            while (true) {
                //tạo biến receiveData để nhận dữ liệu từ gói tin đến 
                byte[] receiveData = new byte[1000];
                //tạo sendData để nhận dữ liệu gửi lên gói tin đi
                byte[] sendData  = new byte[20000];
  
                //----------------------------------------------------------------------
                //Lấy lựa chọn
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                String bString = new String(receivePacket.getData(),0,receivePacket.getLength());
                System.out.println("Client: "+bString);
                // //Lấy địa chỉ IP của bên gửi
                InetAddress IPAddress = receivePacket.getAddress();
                // //Lấy số hiệu cổng bên gửi
                int port = receivePacket.getPort(); 
                 
                DatagramPacket sendPacket;
                //---------------------------------------------------------------------
                if(bString.equals("0")==false ){
                    x= bString;
                    bString = "2";
                }else{
                    bString="0";
                }

                System.out.println("bString sau if: "+bString);
                System.out.println("x= "+x);

                switch (bString) {
                    case "0":
                        //đọc file
                        final String FILE_URL1 = "C:/Users/ADMIN/OneDrive/HOC_ky5/TH_PTHTTH/GK/src/data6.txt";
                        final String FILE_URL2 = "C:/Users/ADMIN/OneDrive/HOC_ky5/TH_PTHTTH/GK/src/data6.txt";
                        InputStream inputStream = new FileInputStream(FILE_URL3);
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader reader = new BufferedReader(inputStreamReader);
                        String line0="";
                        System.out.println("Chuỗi trong file:\n");
                        System.out.println("case0 chay");
                        while((line0 = reader.readLine())  != null){
                            System.out.println(line0);
                            sendData=line0.getBytes();
                            sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                            // //Gửi gói tin đi
                            serverSocket.send(sendPacket);
                        }
                        break;

                    case "2":               
                        inputStream = new FileInputStream(FILE_URL3);
                        
                        inputStreamReader = new InputStreamReader(inputStream);
                        reader = new BufferedReader(inputStreamReader);
                        String line3="";
                        int count=0;
                        System.out.println("x= "+x);

                        while((line3 = reader.readLine())  != null){
                            char[] arr = line3.toCharArray();
                            // boolean space=true;

                            for(int i=0;i<arr.length;i++){
                                if((arr[i])== x.charAt(0)){
                                    count++;
                                }
                            }

                            line3 = line3 + "         Số lần hiện: "+count;
                            sendData= line3.getBytes();
                            sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                            // //Gửi gói tin đi
                            serverSocket.send(sendPacket);
                        }
                        break;

                    case "3":
                        serverSocket.close();
                        System.exit(0);
                        break;
                }
            }
            
        } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }
    }  
}
