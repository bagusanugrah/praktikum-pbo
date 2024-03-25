public class Barang {
    private String id;
    private String nama;
    private String jenis;
    private int harga;
    private int stok;

    Barang(String id, String nama, boolean isMakanan, int harga, int stok) {
        this.id = id;
        this.nama = nama;
        this.jenis = isMakanan == true ? "makanan" : "minuman";
        this.harga = harga;
        this.stok = stok;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getJenis() {
        return jenis;
    }

    public int getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    //untuk perbarui stok barang
    public void setStok(int stokBaru) {
        this.stok = stokBaru;
    }
}
