package nomor1;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int jam;
		int menit;
		int detik;
		int konversiDetik1;
		int konversiDetik2;
		int selisihDetik;
		ArrayList<Integer> waktuBaru;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Jam pertama");
		System.out.print("Jam = ");
		jam = scanner.nextInt();
		System.out.print("Menit = ");
		menit = scanner.nextInt();
		System.out.print("Detik = ");
		detik = scanner.nextInt();
		
		Waktu waktuPertama = new Waktu(jam, menit, detik);
		
		System.out.println();
		System.out.println("Jam kedua");
		System.out.print("Jam = ");
		jam = scanner.nextInt();
		System.out.print("Menit = ");
		menit = scanner.nextInt();
		System.out.print("Detik = ");
		detik = scanner.nextInt();
		scanner.close();
		
		Waktu waktuKedua = new Waktu(jam, menit, detik);
		
		System.out.println();
		System.out.print("Jam pertama: ");
		System.out.println(waktuPertama.getJam()+" Jam "+waktuPertama.getMenit()+" Menit "+waktuPertama.getDetik()+" Detik");
		System.out.print("Jam kedua: ");
		System.out.println(waktuKedua.getJam()+" Jam "+waktuKedua.getMenit()+" Menit "+waktuKedua.getDetik()+" Detik");
		
		konversiDetik1 = waktuPertama.konversiWaktuKeDetik();
		konversiDetik2 = waktuKedua.konversiWaktuKeDetik();
		
		selisihDetik = Waktu.penguranganDetik(konversiDetik1, konversiDetik2);
		waktuBaru = Waktu.konversiDetikKeWaktu(selisihDetik);
		
		jam = waktuBaru.get(0);
		menit = waktuBaru.get(1);
		detik = waktuBaru.get(2);
		
		System.out.print("Selisih: ");
		System.out.println(jam+" Jam "+menit+" Menit "+detik+" Detik");
	}

}
