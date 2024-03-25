public class Pembeli extends Pelanggan {
    private String nrp;
    private String nama;
    private String jurusan;
    private String statusPelanggan;
    private int poin;

    Pembeli(String nrp, String nama, String jurusan, boolean isMembership){
        this.nrp = nrp;
        this.nama = nama;
        this.jurusan = jurusan;
        //jika true maka statusPelanggan = "Membership"
        this.statusPelanggan = isMembership == true ? "Membership" : "Tidak Tetap";
        //poin pembeli yang baru terdaftar adalah 0
        this.poin = 0;
    }

    public String getNRP(){
        return nrp;
    }

    public String getNama(){
        return nama;
    }

    public String getJurusan(){
        return jurusan;
    }

    public String getStatusPelanggan(){
        return statusPelanggan;
    }

    public int getPoin(){
        return poin;
    }

    //untuk menambah poin
    public void tambahPoin(int tambahanPoin){
        this.poin += tambahanPoin;
    }

    //untuk konversikan poin ke rupiah
    public void konversikanPoin(int poinDikonversi){
        //kurangi jumlah poin yang dimiliki
        this.poin -= poinDikonversi;
        //pembeli mendapatkan uang dari poin yang dikonversikan
        System.out.println(poinDikonversi + " poin berhasil dikonversikan menjadi Rp" + poinDikonversi*5000);
    }

    //pembeli membayar apa yang dia beli
    public void bayar(int hargaFinal){
        System.out.println();
        System.out.println(this.nama + " membayar sebesar Rp" + hargaFinal);
    }
}
