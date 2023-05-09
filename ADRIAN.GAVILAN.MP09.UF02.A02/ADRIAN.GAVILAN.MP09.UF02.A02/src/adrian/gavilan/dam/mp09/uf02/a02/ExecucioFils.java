package adrian.gavilan.dam.mp09.uf02.a02;

public class ExecucioFils {

	public void executa() {

		//execucioSenseFils();
		//execucioAmbFils();
		execucioAmbFilsSincronitzats();
	}

	private CronoThread cronoA = null;
	private CronoThread cronoB = null;
	private CronoThread cronoC = null;
	private CronoThread cronoD = null;
	private CronoThread cronoE = null;
	private CronoThread cronoF = null;
	private CronoThread cronoG = null;



	private void inicialitzaFils() {
		cronoA = new CronoThread("cronoA", 10);
		cronoB = new CronoThread("cronoB", 7);
		cronoC = new CronoThread("cronoC", 6);
		cronoD = new CronoThread("cronoD", 8);
		cronoE = new CronoThread("cronoE", 9);
		cronoF = new CronoThread("cronoF", 3);
		cronoG = new CronoThread("cronoG", 4);
	}

	private void execucioSenseFils() {

		inicialitzaFils();

		cronoA.run();
		cronoB.run();
		cronoC.run();
		cronoD.run();
		cronoE.run();
		cronoF.run();
		cronoG.run();

		System.out.println("Final fil principal");
	}

	private void execucioAmbFils() {
		inicialitzaFils();

		cronoA.start();
		cronoB.start();
		cronoC.start();
		cronoD.start();
		cronoE.start();
		cronoF.start();
		cronoG.start();

		System.out.println("Final fil principal");
	}

	private void execucioAmbFilsSincronitzats() {
		inicialitzaFils();

		cronoA.start();
		cronoB.start();

		try {
			cronoB.join(2000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		
		cronoC.start();
		cronoD.start();
		
		try {
			cronoD.join();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		
		cronoE.start();
		
		try {
			cronoE.join(5000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		
		cronoF.start();
		cronoG.start();

		System.out.println("Final fil principal");
	}
}
