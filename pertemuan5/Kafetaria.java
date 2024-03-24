import java.util.ArrayList;

public class Kafetaria{
    //arraylist untuk menampung objek-objek kios
    private static ArrayList<Kios> daftarKios = new ArrayList<Kios>();
    //arraylist untuk menampung objek-objek mahasiswa
    private static ArrayList<Pembeli> daftarMahasiswa = new ArrayList<Pembeli>();

    //untuk menambahkan objek kios ke daftar kios
    public static void addKios(Kios kios){
        daftarKios.add(kios);
    }

    //untuk menambahkan objek mahasiswa ke daftar pembeli
    public static void addMahasiswa(Pembeli mahasiswa){
        daftarMahasiswa.add(mahasiswa);
    }

    //untuk mencari objek mahasiswa
    public static Pembeli cariMahasiswa(String nrp){
        //cari data mahasiswa
        for (Pembeli mahasiswa : daftarMahasiswa) {
            //jika data mahasiswa ketemu
            if (mahasiswa.getNRP().equalsIgnoreCase(nrp)) {
                //return objek mahasiswa
                return mahasiswa;
            }
        }
        //jika data mahasiswa tidak ketemu
        //return null
        System.out.println("Mahasiswa dengan NRP:" + nrp + " tidak terdaftar!");
        return null;
    }

    //untuk mencari objek kios
    public static Kios cariKios(String idKios){
        //cari kios
        for (Kios kios : daftarKios) {
            //jika kios ketemu
            if (kios.getId().equalsIgnoreCase(idKios)) {
                //return objek kios
                return kios;
            }
        }
        //jika kios tidak ketemu
        //return null
        System.out.println("Kios dengan id:" + idKios + " tidak terdaftar!");
        return null;
    }

    public static ArrayList<Kios> getKios(){
        return daftarKios;
    }

    public static ArrayList<Pembeli> getMahasiswa(){
        return daftarMahasiswa;
    }

    //untuk menampilkan kios-kios yang terdaftar
    public static void showDaftarKios(){
        int i = 0;
        for(Kios kios: daftarKios){
            System.out.println(i + ". " + kios.getNama() + " | id kios: " + kios.getId());
            i++;
        }
    }
}