package adrian.gavilan.dam.mp09.uf02.a02;

public class CronoThread extends Thread {

	@Override
	public void run() {

		proces();
	}

	public CronoThread(String nom, Integer limitSegons) {
		super();
		this.nom = nom;
		this.limitSegons = limitSegons;
	}

	private String nom;

	private Integer limitSegons;

	public String getnom() {
		return nom;
	}

	public void setnom(String nom) {
		this.nom = nom;
	}

	public Integer getlimitSegons() {
		return limitSegons;
	}

	public void setlimitSegons(Integer limitSegons) {
		this.limitSegons = limitSegons;
	}

	@Override
	public String toString() {
		return "CronoThread [nom=" + nom + ", limitSegons=" + limitSegons + "]";
	}

	private void proces() {
		int contadorSegundos = 0;

		System.out.println(this.getnom() + "  INICIAT");

		while (this.limitSegons == null || contadorSegundos < this.limitSegons) {

			try {
				Thread.sleep(1000);
				contadorSegundos++;
				System.out.println(this.getnom() + ": " + contadorSegundos);
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
				Thread.currentThread().interrupt();
				break;
			}
		}
		System.out.println(this.getnom() + "  FINALITZAT");

	}

}
