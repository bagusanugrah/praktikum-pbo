import java.util.ArrayList;

public class Kios implements SisiPenjual, SisiPembeli {
    private String id;
    private String nama;
    //arraylist untuk menampung objek-objek barang
    private ArrayList<Barang> daftarBarang = new ArrayList<Barang>();

    Kios(String id, String nama){
        this.id = id;
        this.nama = nama;
    }

    //untuk melakukan pembelian barang
    @Override
    public boolean pembelianBarang(String idBarang, int jumlahBarang, Pembeli pembeli) {
        float totalHarga;
        float hargaFinal;

        //cari id barang
        for (Barang barang : daftarBarang) {
            //jika id barang ketemu
            if (barang.getId().equalsIgnoreCase(idBarang)) {
                //jika stok barang masih tersedia
                if (barang.getStok() >= jumlahBarang) {
                    //kurangi jumlah stok barang dengan jumlah barang yang dibeli
                    barang.setStok(barang.getStok() - jumlahBarang);
                    System.out.println();
                    System.out.println("Rincian Pesanan");
                    System.out.println("Nama: " + barang.getNama());
                    System.out.println("Harga: " + barang.getHarga());
                    System.out.println("Jumlah: " + jumlahBarang);
                    totalHarga = (float) (jumlahBarang * barang.getHarga());
                    System.out.println("Total Harga: Rp" + totalHarga);
                    hargaFinal = totalHarga;

                    //jika yang dibeli adalah minuman dan harganya di atas Rp100rb
                    if(totalHarga>100000 && barang.getJenis().equals("Minuman")){
                        //dapat diskon 15%
                        System.out.println("Diskon 15%: -Rp" + (totalHarga * (15f/100)));
                        hargaFinal = totalHarga - (totalHarga * (15f/100));
                    }

                    //jika status pelanggan adalah membership
                    if(pembeli.getStatusPelanggan().equals("Membership")){
                        //dapat diskon 25%
                        System.out.println("Diskon membership 20%: -Rp" + (totalHarga * (20f/100)));
                        hargaFinal = totalHarga - (totalHarga * (20f/100));
                    } else{//jika status pelanggan adalah tidak tetap
                        //jika yang dibeli harganya di atas Rp300rb
                        if(totalHarga>300000){
                            //dapat diskon 15%
                            System.out.println("Diskon 15%: -Rp" + (totalHarga * (15f/100)));
                            hargaFinal = totalHarga - (totalHarga * (15f/100));
                        }
                        
                        //Jika yang dibeli harganya di atas Rp50rb
                        if(totalHarga>=50000){
                            //setiap Rp50rb dapat 5 poin
                            pembeli.tambahPoin(((int) totalHarga/50000) * 5);
                            System.out.println("Anda mendapatkan " + ((int) totalHarga/50000)*5 + " poin, poin yang anda miliki sekarang sebanyak " + pembeli.getPoin() + " poin");
                        }
                    }
                    //anehnya pelanggan tidak tetap lebih banyak diskonnya daripada membership ????

                    //pembeli membayar apa yang dia beli
                    pembeli.bayar((int) hargaFinal);
                    System.out.println("Pembelian berhasil.");
                    return true;
                } else {
                    System.out.println("Stok barang tidak mencukupi.");
                    System.out.println();
                    return false;
                }
            }
        }
        //jika id barang tidak ditemukan
        System.out.println("Barang tidak ditemukan.");
        System.out.println();
        return false;
    }

    //untuk menambahkan objek barang baru atau update stok barang
    @Override
    public void penambahanBarang(String idBarang, String namaBarang, boolean isMakanan, int hargaBarang, int stokBarang) {
        //cari nama barang
        for (Barang barang : daftarBarang) {
            //jika nama barang sudah terdaftar
            if (barang.getNama().equalsIgnoreCase(namaBarang)) {
                //tambah stok barang
                barang.setStok(barang.getStok() + stokBarang);
                //System.out.println("Penambahan stok barang berhasil.");
                return;
            }
        }
        // Jika barang belum ada di daftar
        //buat objek barang baru
        daftarBarang.add(new Barang(idBarang, namaBarang, isMakanan, hargaBarang, stokBarang));
        //System.out.println("Penambahan barang berhasil.");
    }

    public String getId(){
        return id;
    }

    public String getNama(){
        return nama;
    }

    //untuk menampilkan barang apa saja yang ada di objek kios
    public void showDaftarBarang(){
        int i = 0;
        for(Barang barang: daftarBarang){
            System.out.println(i + ". " + barang.getNama() + " - Rp" + barang.getHarga() + " - Stok: " + barang.getStok() + " | id: " + barang.getId());
            i++;
        }
    }
}
