
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;


public class serverUDP2 {
    public static void main(String []args) throws IOException
    {
        // tao ket noi
        DatagramSocket serverSocket = new DatagramSocket(1024);
        while (true) {
             //thong bao server da san sang ket noi
        System.out.println("Server ready");
        //tao mang byte de chua du lieu gui len tu client
        byte inFromClient1[];
        inFromClient1 = new byte[256];
        byte inFromClient2[];
        inFromClient2 = new byte[256];
        // lay kich thuoc mang
        int leng1 = inFromClient1.length;
        int leng2 = inFromClient2.length;
        // tao goi de nhan du lieu gui len tu client
        DatagramPacket fromClient1 = new DatagramPacket(inFromClient1, leng1);
        DatagramPacket fromClient2 = new DatagramPacket(inFromClient2, leng2);
        // nhan goi ve server
        serverSocket.receive(fromClient1);
        serverSocket.receive(fromClient2);
        // tao bien data kieu string de lay du lieu trong goi ra
        String data1,data2;
        // lay du lieu vao bien data
        data1 = (new String(fromClient1.getData(),0,inFromClient1.length)).trim();
        data2 = (new String(fromClient2.getData(),0,inFromClient2.length)).trim();
        // chuyen du lieu tu kieu String -> integer
        int a,b,tong;
        a = Integer.parseInt(data1);
        // b = Integer.parseInt(data2);

        

        // xu ly yeu cau
        //  tong = a + b;

//----------------------------------------------------------------------------------
        do {
            // outClient1.writeUTF("1. Xem ngày | 2. Xem giờ | 3. Thoát -----"+"\n");
            // outClient1.flush();
            // client_in= inClient.read();
                switch (a) {
                    case 1:
                    // int sum=0;
                    String url1 = "/Users/huuphuoc/OneDrive/HOC_ky5/TH_PTHTTH/Tuan3/src//test_1.txt";
                    //------------------------
                    System.out.println("File test_1.txt :");
                        try(Stream<String> stream = Files.lines(Paths.get(url1),StandardCharsets.UTF_8)){//đưa về dạng chuẩn utf8
                            stream.forEach(lines->{
                                //line là từng dòng trong file, tại đây có thể tương tác với nội dung của file. in ra nội dung của từng dòng
                            //System.out.println(lines +" is number line "+ (a[0]++));//in ra cả nội dung file và dòng thứ mấy ta vừa in, bắt đầu từ 0
                               System.out.println(lines );
                                int [] Element;
                                //int sum=0;

                                String [] item = lines.split(" "); //tach chuoi thanh cac phan tu chuoi
                                Element = new int[item.length];
                    int sum=0;

                                for(int i=0; i<item.length; i++){//doi kieu string sang int cua cac phan tu
                                    Element[i] = Integer.parseInt(item[i]);
                                    sum += Element[i];
                                }
                                System.out.println("Tổng = " + sum);
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    //------------------------
                     // String s1 = "Hom nay: " + java.time.LocalDate.now() + "          ";
                    //  // chuyen du lieu tu kieu int -> String va truyen vao bien data
                    data1 = String.valueOf(sum);
                    // data1 = sum;
                    // dong goi ket qua
                    byte outToClient[];
                    outToClient = data1.getBytes();
                    //lay kich thuoc mang
                    leng1 = outToClient.length;
                    //lay dia chi cua may khach, no nam luon trong goi ma da gui len server
                    InetAddress address = fromClient1.getAddress();
                    // lay so port
                    int port = fromClient1.getPort();
                    // tao goi de gui ve client
                    DatagramPacket toClient = new DatagramPacket(outToClient, leng1, address, port);
                    //gui goi ve client
                    serverSocket.send(toClient);
                     break;
                    case 2:
                     String s2 = "Gio hien tai: " + java.time.LocalTime.now() + "         " ;
                    //  outClient.writeBytes(s2);
                    //  outClient.flush();
                     break;
                    case 3:
                     String s3 = "Tạm biệt!";
                   // outClient1.writeUTF("3. Thoát -----"+"\n");
                    // outClient.writeBytes(s3+'\n');
                     System.exit(0); // thoát chương trình
                     break;
                }
        } while ((a < 1) || (a >= 3));
        serverSocket.close();

//----------------------------------------------------------------------------------
        }
        
        //dong socket
    }

    public static int readFile(int a){
        String url1 = "/Users/huuphuoc/OneDrive/HOC_ky5/TH_PTHTTH/Tuan3/src//test_1.txt";
                    //------------------------
                    // int a;
                    System.out.println("File test_1.txt :");
                        try(Stream<String> stream = Files.lines(Paths.get(url1),StandardCharsets.UTF_8)){//đưa về dạng chuẩn utf8
                            stream.forEach(lines->{
                                //line là từng dòng trong file, tại đây có thể tương tác với nội dung của file. in ra nội dung của từng dòng
                            //System.out.println(lines +" is number line "+ (a[0]++));//in ra cả nội dung file và dòng thứ mấy ta vừa in, bắt đầu từ 0
                               System.out.println(lines );
                                int [] Element;
                                //int sum=0;

                                String [] item = lines.split(" "); //tach chuoi thanh cac phan tu chuoi
                                Element = new int[item.length];
                                int sum=0;
                                for(int i=0; i<item.length; i++){//doi kieu string sang int cua cac phan tu
                                    Element[i] = Integer.parseInt(item[i]);
                                    sum += Element[i];
                                }
                                System.out.println("Tổng = " + sum);
                                a = Integer.valueOf(sum);
                                // return a;
                                
                            });
                            return a;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    //------------------------
    }

}