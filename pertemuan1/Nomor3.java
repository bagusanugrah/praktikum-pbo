import java.util.Scanner; // Mengimpor kelas Scanner dari paket java.util

public class Nomor3 { // Mendefinisikan kelas Nomor3
    public static void main(String[] args) { // Metode utama untuk menjalankan program
        int tinggi; // Mendeklarasikan variabel tinggi segitiga
        int spasi; // Mendeklarasikan variabel jumlah spasi
        int i = 1; // Mendeklarasikan variabel untuk baris
        int bintang = i; // Mendeklarasikan variabel untuk jumlah bintang pada setiap baris
        Scanner scanner = new Scanner(System.in); // Membuat objek scanner untuk menerima input dari pengguna

        System.out.print("Masukkan tinggi segitiga: "); // Menampilkan pesan untuk meminta input tinggi segitiga
        tinggi = scanner.nextInt(); // Membaca input tinggi segitiga dari pengguna

        spasi = tinggi - 1; // Menghitung jumlah spasi pada baris pertama

        // Looping untuk menggambar segitiga
        while (i <= tinggi) { // Selama nilai i kurang dari atau sama dengan tinggi segitiga
            // Looping untuk menambahkan spasi sebelum bintang
            for (int j = 1; j <= spasi; j++) { // Selama nilai j kurang dari atau sama dengan jumlah spasi
                System.out.print(" "); // Mencetak spasi
            }

            // Looping untuk menambahkan bintang pada setiap baris
            for (int k = 1; k <= bintang; k++) { // Selama nilai k kurang dari atau sama dengan jumlah bintang pada baris saat ini
                System.out.print("*"); // Mencetak bintang
            }

            System.out.println(); // Pindah ke baris baru setelah satu baris segitiga selesai

            spasi--; // Mengurangi jumlah spasi untuk baris berikutnya
            bintang += 2; // Menambah jumlah bintang untuk baris berikutnya
            i++; // Menambah nilai i untuk mengontrol loop
        }

        scanner.close(); // Menutup objek scanner untuk menghindari leak memory
    }
}
