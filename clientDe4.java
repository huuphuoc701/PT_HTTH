import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

// 1952691 Nguyễn Hửu Phước
public class clientDe4 {
    private static final String FILE_URL1 = "C:/Users/ADMIN/OneDrive/HOC_ky5/TH_PTHTTH/GK/src/data6.txt";
    private static final String FILE_URL2 = "/Users/huuphuoc/OneDrive/HOC_ky5/TH_PTHTTH/GK/src/data6.txt";
    public static void main(String[] args) {
        try {
            //tao moi socket client
            DatagramSocket ClientSocket = new DatagramSocket();
            System.out.println("Đã tạo client. ");
            //-----------------------------------------------------------------------------
            //Đếm số lượng dòng trong file
            InputStream inputStream = new FileInputStream(FILE_URL2);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            LineNumberReader lnr=new LineNumberReader(inputStreamReader);

            int j=0;
            while(lnr.readLine() !=null){ // lấy số dòng lớn nhất trong file
                j++; 
            }
            //--------------------------------------------------------------------------
            while (true) {
                System.out.println("\nChon chuc nang: \n");
                System.out.println("Nhập lựa chọn cần mở:");
                System.out.println("0. Mở file || 2. Đếm từ");
                BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
                String bString = read.readLine();
                byte[] ghi = bString.getBytes();
                //lay lua chon nhap tu ban phim
                DatagramPacket in = new DatagramPacket(ghi, ghi.length,InetAddress.getByName("localhost"),9876);
                ClientSocket.send(in);
                // tạo goi nhan du lieu ve
                DatagramPacket os;
                byte[] nhan = new byte[2000];
                //-------------------------------
                int a=Integer.parseInt(bString);

                if(a ==3 ){
                    ClientSocket.close();
                    System.exit(0);
                }
                //-------------------------------------------------------------------------------------
                for (int i = 0; i < j; i++) {
                
                    os = new DatagramPacket(nhan, nhan.length);
                    ClientSocket.receive(os);

                    String aString = new String(os.getData(),0,os.getLength());
                    System.out.println(aString);
                }
                
                    //-------------------------------
                    // a=Integer.parseInt(bString1);

                    if(a ==2 ){
                        System.out.println("Nhap từ cần đếm số lượng: ");
                        BufferedReader read1 = new BufferedReader(new InputStreamReader(System.in));
                        String bString1 = read1.readLine();
                        byte[] ghi1 = bString1.getBytes();
                        //lay lua chon nhap tu ban phim
                        DatagramPacket in1 = new DatagramPacket(ghi1, ghi1.length,InetAddress.getByName("localhost"),9876);
                        ClientSocket.send(in1);
                        // tạo goi nhan du lieu ve
                        DatagramPacket os1;
                        byte[] nhan1 = new byte[2000];
                        for (int i = 0; i < j; i++) {
                            os1 = new DatagramPacket(nhan1, nhan1.length);
                            ClientSocket.receive(os1);
                            String aString1 = new String(os1.getData(),0,os1.getLength());
                            System.out.println(aString1);
                        }
                        
                    }
                    
                
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
}
