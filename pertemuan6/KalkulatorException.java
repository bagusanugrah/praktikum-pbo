public class KalkulatorException extends Exception {
    public KalkulatorException(String pesanError){
        super(pesanError);
    }

    //untuk mengecek apakah inputan adalah angka
    public static void isNumber(String inputan) throws KalkulatorException{
        //jika bukan angka
        if(!inputan.matches("-?\\d+(\\.\\d+)?")){
            //hasilkan error
            throw new KalkulatorException("Inputan bukan angka!");
        }
    }

    //untuk mengecek apakah penyebut adalah nol
    public static void isDividedByZero(double inputanKedua) throws KalkulatorException{
        //jika penyebut adalah nol
        if(inputanKedua == 0){
            //hasilkan error
            throw new KalkulatorException("Penyebut tidak boleh 0 (nol)!");
        }
    }
}
