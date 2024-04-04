public class GaKetemuException extends Exception {
    public GaKetemuException(String pesanError){
        super(pesanError);
    }

    //untuk mencari angka dalam sebuah array
    public static int isFound(int[] arrayTarget, String yangDicari) throws GaKetemuException{
        //status sudah ketemu atau belum
        //jika sudah maka true
        boolean ketemu = false;
        //si angka ketemunya di indeks mana
        int indexKetemu = 0;

        //baca setiap angka yang ada di dalam array
        for(int i=0; i<arrayTarget.length; i++){
            //jika angka yang sedang dibaca sama dengan angka yang dicari
            if(Integer.toString(arrayTarget[i]).equals(yangDicari)){
                //maka ubah status ketemu menjadi true
                ketemu = true;
                //simpan indeks ketemunya si angka
                indexKetemu = i;
            }
        }

        //jika angka yang dicari tidak ketemu
        if(!ketemu){
            //hasilkan error
            throw new GaKetemuException("Elemen tidak ditemukan dalam array.");
        } else{//jika angka yang dicari ketemu
            //return posisi indeks ketemunya angka tersebut
            return indexKetemu;
        }
    }
}
