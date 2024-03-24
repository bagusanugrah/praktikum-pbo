public class Database {
    public static void inisialisasiObjek(){
        //buat objek kios
        Kafetaria.addKios(new Kios("k0001", "Warteg Bahari"));
        Kafetaria.addKios(new Kios("k0002", "Padang Gobah"));
        Kafetaria.addKios(new Kios("k0003", "Aneka Cemilan"));

        //buat objek pelanggan
        Kafetaria.addMahasiswa(new Pembeli("152022029", "Bagus Anugrah", "Informatika", true));
        Kafetaria.addMahasiswa(new Pembeli("152022182", "Deden Fahrul", "Informatika", false));
        Kafetaria.addMahasiswa(new Pembeli("152022192", "Muhammad Yazid", "Informatika", false));

        //inisialisasi poin awal untuk objek pelanggan bernama Muhammad Yazid
        Kafetaria.getMahasiswa().get(2).tambahPoin(15);

        //tambah barang untuk kios Warteg Bahari
        Kafetaria.getKios().get(0).penambahanBarang("f0001", "Nasi Telor Dadar", true, 10000, 50);
        Kafetaria.getKios().get(0).penambahanBarang("f0002", "Nasi Ayam Gorang", true, 15000, 25);
        Kafetaria.getKios().get(0).penambahanBarang("m0001", "Es Teh Manis", false, 3000, 150);

        //tambah barang untuk kios Padang Gobah
        Kafetaria.getKios().get(1).penambahanBarang("f0001", "Nasi Gulai Kikil", true, 25000, 10);
        Kafetaria.getKios().get(1).penambahanBarang("f0002", "Nasi Rendang", true, 18000, 150);
        Kafetaria.getKios().get(1).penambahanBarang("f0003", "Kerupuk Kulit", true, 5000, 100);
        Kafetaria.getKios().get(1).penambahanBarang("m0001", "Es Teh Manis", false, 3000, 120);
        Kafetaria.getKios().get(1).penambahanBarang("m0002", "Jus Alpukat", false, 10000, 50);


        //tambah barang untuk kios Aneka Cemilan
        Kafetaria.getKios().get(2).penambahanBarang("f0001", "Roti Aoka", true, 4000, 200);
        Kafetaria.getKios().get(2).penambahanBarang("f0002", "Blastos", true, 3000, 1000);
        Kafetaria.getKios().get(2).penambahanBarang("f0003", "Beng beng", true, 2500, 150);
        Kafetaria.getKios().get(2).penambahanBarang("m0001", "Air Mineral", false, 3000, 2500);
        Kafetaria.getKios().get(2).penambahanBarang("m0002", "Coca Cola", false, 5000, 100);
    }
}
