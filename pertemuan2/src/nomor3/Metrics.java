package nomor3;

public class Metrics {
	private double panjang;

	public Metrics(double panjang){
		// TODO Auto-generated constructor stub
		this.panjang = panjang;
	}

	public double getMiles(){
		final double oneMile = 1609.34;
		
		return Double.parseDouble(String.format("%.5f", getMeter()/oneMile));
	}
	
	public double getMeter(){
		return panjang*1000;
	}
	
	public double getCentimeter() {
		return getMeter()*100;
	}
}
