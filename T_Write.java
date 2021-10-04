import java.util.Scanner;

public class T_Write extends Thread {
    public void run() {
        int n;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\nNhập vào số phần tử của mảng: ");
            n = scanner.nextInt();
        } while (n < 0);
            
        int array[] = new int[n];
            
        System.out.println("Nhập các phần tử cho mảng: ");
            for (int i = 0; i < n; i++) {
                System.out.print("Nhập phần tử thứ " + i + ": ");
                array[i] = scanner.nextInt();
            }
            
        // Hiển thị 
        System.out.println("\n Hiển thị: ");
            for (int i = 0; i < n; i++) {
                System.out.print(array[i] + "\t");
            }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public static void main(String args[]) throws InterruptedException {
        T_Write thread1 = new T_Write();
        thread1.start();
        thread1.join();

        T_Write thread2 = new T_Write();
        thread2.start();
        thread2.join();
        T_Write thread3 = new T_Write();
        thread3.start();

    }
}
