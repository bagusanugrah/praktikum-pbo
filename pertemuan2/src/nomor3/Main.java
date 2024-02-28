package nomor3;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double kilometer;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Masukkan kilometer: ");
		kilometer = scanner.nextDouble();
		scanner.close();
		
		Metrics metrik = new Metrics(kilometer);
		
		System.out.println(kilometer+" kilometer");
		System.out.println(metrik.getMiles()+" miles");
		System.out.println(metrik.getMeter()+" meter");
		System.out.println(metrik.getCentimeter()+" centimeter");
	}

}
