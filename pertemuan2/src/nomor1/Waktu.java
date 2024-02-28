package nomor1;

import java.util.ArrayList;

public class Waktu {
	private int jam;
	private int menit;
	private int detik;

	public Waktu(int jam, int menit, int detik){
		// TODO Auto-generated constructor stub
		this.jam = jam;
		this.menit = menit;
		this.detik = detik;
	}

	public int getJam() {
		return jam;
	}
	
	public int getMenit() {
		return menit;
	}

	public int getDetik(){
		return detik;
	}

	public int konversiWaktuKeDetik(){
		return getJam()*3600 + getMenit()*60 + getDetik();
	}
	
	public static int penguranganDetik(int detik1, int detik2){
		return detik1-detik2;
	}
	
	public static ArrayList<Integer> konversiDetikKeWaktu(int targetDetik){
		ArrayList<Integer> arrayWaktu = new ArrayList<Integer>();
		int jam;
		int menit;
		int detik;
		
		jam = targetDetik/3600;
		menit = (targetDetik%3600)/60;
		detik = (targetDetik%3600)%60;
		
		arrayWaktu.add(jam);
		arrayWaktu.add(menit);
		arrayWaktu.add(detik);
		
		return arrayWaktu;
	}
}
