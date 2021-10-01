import java.util.Scanner;



public class bt1_2 {
    
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Scanner sc = new Scanner(System.in);
        String nhap;
        System.out.println("\n\nNhập vào chuỗi cần in hoa: ");
        nhap = sc.nextLine();

        String IN_HOA = nhap.toUpperCase();
        System.out.println("Chuoi da in: "+IN_HOA);

        
        System.out.println("\n\nNhập vào chuỗi cần đổi dạng chữ thường: ");
        String nhap2 = sc.nextLine();
        String  s2 = nhap2.toLowerCase();
        System.out.println("Đổi: "+s2);

        int n;
        System.out.println("\n\nNhập vào số cần kiểm tra: ");
        n = sc.nextInt();
        kiemtraSoNguyenTo(n);


        // giải phương trình bậc 2 java
    }

    public static boolean kiemtraSoNguyenTo(int n) {
        // so nguyen n < 2 khong phai la so nguyen to
        if (n < 2) {
            System.out.println("khong phai la so nguyen to");
            return false;
        }
        
        // check so nguyen to khi n >= 2
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                System.out.println("khong phai la so nguyen to");
                return false; 
            }
        }
        System.out.println(n+" la so nguyen to");
        return true;
    }
    
}
