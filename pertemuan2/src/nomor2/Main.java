package nomor2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tahun;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Masukkan tahun: ");
		tahun = scanner.nextInt();
		scanner.close();
		
		TahunKabisat inputanTahun = new TahunKabisat(tahun);
		
		System.out.println(inputanTahun.penentuanKabisat());
	}

}
