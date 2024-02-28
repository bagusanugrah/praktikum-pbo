package nomor2;

public class TahunKabisat {
	private int tahun;
	
	public TahunKabisat(int tahun){
		// TODO Auto-generated constructor stub
		this.tahun = tahun;
	}
	
	public boolean cekKabisat() {
		int tahun = this.tahun;
		boolean apakahKabisat;
		
		if(tahun%400 == 0) {
			apakahKabisat = true;
		} else if(tahun%100 == 0) {
			apakahKabisat = false;
		} else if(tahun%4 == 0) {
			apakahKabisat = true;
		} else {
			apakahKabisat = false;
		}
		
		return apakahKabisat;
	}
	
	public String penentuanKabisat() {
		String kesimpulan;
		
		if(cekKabisat()) {
			kesimpulan = this.tahun + " adalah tahun kabisat";
		} else {
			kesimpulan = this.tahun + " bukan tahun kabisat";
		}
		
		return kesimpulan;
	}
}
