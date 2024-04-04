public class NonPositiveIntegerException extends Exception {
    public NonPositiveIntegerException(String pesanError){
        super(pesanError);
    }

    //untuk mengecek apakah inputan adalah bilangan bulat positif
    public static void isPositiveInteger(String inputan) throws NonPositiveIntegerException{
        try{
            //jika bilangan tidak bisa dikonversi ke bilangan bulat maka akan menghasilkan error
            Integer.parseInt(inputan);

            //jika bilangan adalah negatif
            if(Integer.parseInt(inputan) <= 0){
                //hasilkan error
                throw new NonPositiveIntegerException("Bukan bilangan bulat positif!");
            }
        } catch(NumberFormatException e){
            //error dari gagalnya konversi ke bilangan bulat
            throw new NonPositiveIntegerException("Bukan bilangan bulat positif!");
        }
    }
}