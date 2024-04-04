import java.util.Scanner;

public class Nomor1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan bilangan: ");
        String bilangan = scanner.nextLine();
        scanner.close();

        try{
            //cek apakah bilangan yang diinputkan adalah bilangan bulat positif
            //jika bukan maka akan menghasilkan error
            NonPositiveIntegerException.isPositiveInteger(bilangan);

            //bila pengecekan di atas tidak menghasilkan error
            //maka perintah print di bawah ini akan dijalankan
            System.out.println("Bilangan adalah bilangan bulat positif.");
        } catch(NonPositiveIntegerException error){
            //jika terjadi error maka print errornya
            System.out.println(error);
        }
    }
}
