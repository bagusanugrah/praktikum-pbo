import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //inisialisasi objek-objek yang diperlukan
        Database.inisialisasiObjek();
        Scanner scanner = new Scanner(System.in);
        Pembeli mahasiswa = null;
        Kios kios = null;
        String nrp = "";
        String idKios = "";
        String idBarang = "";
        String jumlahBarang = "1";
        boolean berhasilBeliBarang = false;

        //selagi objek mahasiswa belum didapat
        while(mahasiswa == null){
            System.out.println("Masukkan NRP untuk login");
            System.out.print("NRP: ");
            nrp = scanner.nextLine();
            
            //cari objek mahasiswa berdasarkan nrp
            mahasiswa = Kafetaria.cariMahasiswa(nrp);

            //jika objek mahasiswa berhasil didapatkan
            if(mahasiswa != null){
                System.out.println();
                System.out.println("Login berhasil!");
                System.out.println("NRP: " + nrp);
                System.out.println("Nama: " + mahasiswa.getNama());
                System.out.println("Jurusan: " + mahasiswa.getJurusan());
                System.out.println("Status pelanggan: " + mahasiswa.getStatusPelanggan());
                System.out.println("Poin: " + mahasiswa.getPoin());
            }

            System.out.println();
        }

        //selagi objek kios belum didapat
        while(kios == null){
            System.out.println("Silahkan pilih kios");
            Kafetaria.showDaftarKios();
            System.out.print("Masukkan id kios: ");
            idKios = scanner.nextLine();

            //cari objek kios berdasarkan id kios
            kios = Kafetaria.cariKios(idKios);

            //jika objek kios berhasil didapatkan
            if(kios != null){
                System.out.println();
                System.out.println("Kios berhasil dipilih!");
                System.out.println("Id kios: " + idKios);
                System.out.println("Nama kios: " + kios.getNama());
            }

            System.out.println();
        }

        //jika belum terjadi pembelian barang
        while(!berhasilBeliBarang){
            System.out.println("Silahkan pilih barang");
            kios.showDaftarBarang();
            System.out.print("Masukkan id barang: ");
            idBarang = scanner.next();
            System.out.print("Masukkan jumlah barang yang mau dibeli: ");
            jumlahBarang = scanner.next();

            //proses pembelian barang
            berhasilBeliBarang = kios.pembelianBarang(idBarang, Integer.parseInt(jumlahBarang), mahasiswa);
        }
        
        scanner.close();

    }
}
