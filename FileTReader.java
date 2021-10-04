import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileTReader extends Thread {
    public void run() {
        String url1 = "D:\\TH-Phat_Trien_HTTH\\Tuan3\\test_1.txt";
        String url2 = "D:\\TH-Phat_Trien_HTTH\\Tuan3\\test_2.txt";
        String url3 = "D:\\TH-Phat_Trien_HTTH\\Tuan3\\test_3.txt";
            
        String line;
        BufferedReader reader;
                int n;
                Scanner scanner = new Scanner(System.in);
            do {
                System.out.println("\nNhập vào tên file (số int) cần mở (1; 2; 3): ");
                n = scanner.nextInt();
            } while (n < 0 || n>3);
                if(n == 1){
                    System.out.println("File test_1.txt :");
                        try {
                            reader = new BufferedReader(new FileReader(url1));
                                line = reader.readLine();
                            System.out.println(line);
                                line = reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }                 
                }
                    else if(n==2){
                        System.out.println("File test_2.txt :");
                        try {
                            reader = new BufferedReader(new FileReader(url2));
                            line = reader.readLine();
                            System.out.println(line);
                                line = reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    else if(n==3){
                        System.out.println("File test_3.txt :");
                            try {
                                reader = new BufferedReader(new FileReader(url3));
                                line = reader.readLine();
                                System.out.println(line);
                                    line = reader.readLine();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }  
                    }
                
    }
    public static void main(String args[]) throws InterruptedException {
        FileTReader thread1 = new FileTReader();
        FileTReader thread2 = new FileTReader();
        FileTReader thread3 = new FileTReader();
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();

    }
}
