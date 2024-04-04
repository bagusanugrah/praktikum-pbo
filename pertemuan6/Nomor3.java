import java.util.Scanner;

public class Nomor3 {
    public static void main(String[] args) {
        int[] sebuahArray = {10,9,12,13,14,15,29};
        Scanner scanner = new Scanner(System.in);

        //print arraynya
        System.out.print("Array = {");
        for(int i=0; i<sebuahArray.length; i++){
            System.out.print(sebuahArray[i]);
            if(i < sebuahArray.length-1){
                System.out.print(", ");
            }
        }
        System.out.println("}");

        //buat baris baru
        System.out.println();

        System.out.print("Masukkan angka yang ingin dicari: ");
        String inputan = scanner.nextLine();
        scanner.close();

        try{
            //print indeks ketemunya si angka
            //kalo terjadi error maka tidak akan keprint
            System.out.println("Angka ditemukan di indeks: "+GaKetemuException.isFound(sebuahArray, inputan));
        } catch(GaKetemuException error){
            //jika terjadi error maka print errornya
            System.out.println(error);
        }
    }
}
