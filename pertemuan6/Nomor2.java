import java.util.Scanner;

public class Nomor2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan bilangan pertama: ");
        String inputan1 = scanner.nextLine();
        System.out.print("Masukkan bilangan kedua: ");
        String inputan2 = scanner.nextLine();
        System.out.print("Masukkan operator aritmatika [* / + -]: ");
        String operator = scanner.nextLine();

        scanner.close();

        try{
            //cek apakah bilangan yang diinputkan adalah angka
            //jika bukan maka akan menghasilkan error
            KalkulatorException.isNumber(inputan1);
            KalkulatorException.isNumber(inputan2);

            //konversi inputan ke double
            double bil1 = Double.parseDouble(inputan1);
            double bil2 = Double.parseDouble(inputan2);
            //untuk menampung hasil kalkulasi
            double hasil = 0;

            switch(operator) {
                case "*":
                    hasil = bil1*bil2;
                    break;
                case "/":
                    //cek apakah penyebut nol
                    //jika penyebut nol maka akan menghasilkan error
                    KalkulatorException.isDividedByZero(bil2);
                    hasil = bil1/bil2;
                    break;
                case "+":
                    hasil = bil1+bil2;
                    break;
                case "-":
                    hasil = bil1-bil2;
                    break;
                default://jika operator yang diinputkan bukan operator aritmatika
                    //hasilkan error
                    throw new KalkulatorException("Inputan operator salah!");
            }
            //print hasil kalkulasi
            System.out.println(bil1+" "+operator+" "+bil2+" = "+hasil);
        } catch(KalkulatorException error){
            //jika terjadi error maka print errornya
            System.out.println(error);
        }
    }
}
