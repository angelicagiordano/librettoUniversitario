package it.polito.tdp.model;

public class TestModel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LibrettoModel m=new LibrettoModel();
		System.out.println(m.addEsame(new Esame("03FYZ", "Tecniche di programmazione", "Fulvio Corno")));
		
		System.out.println(m.addEsame( new Esame("01QZP", "Ambient intelligence", "Fulvio Corno")));
		System.out.println(m.addEsame(new Esame("03FYZ", "Tecniche di programmazione", "Fulvio Corno")));
		
		System.out.println(m.trovaEsame("03FYZ"));

		System.out.println(m.trovaEsame("01QZP"));
		System.out.println(m.trovaEsame("8998h"));
		
	}

}
