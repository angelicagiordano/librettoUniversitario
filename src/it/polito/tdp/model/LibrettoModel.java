package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.List;

public class LibrettoModel {
	//gestisce i dati
	private List<Esame> esami;
	
	public LibrettoModel(){
		this.esami = new ArrayList<Esame>(); //creato il modello, si inizializza con una lista vuota
	}

	/**
	 * Aggiunge un nuovo esame all'elenco degli esami presenti verificando che non ci sia già
	 * @param e
	 * @ return true se l ha inserito, false se esisteva già
	 */
			 
	public boolean addEsame(Esame e){
		if(!esami.contains(e)){
		esami.add(e); //la lista rimane conosciuta solo dal modello, il controllore potra fare su di esssa solo determinate operazione
		return true;
		}else{
			return false;
		}
	}
    /**
     * Ricerca se esiste un esame con il codice specificato, se esiste lo restituisce
     * altrimenti return null
     * @param codice
     * @return
     */
	public Esame trovaEsame(String codice){
		int pos=this.esami.indexOf(new Esame(codice, null, null)); //creo un oggetto dello stesso tipo che sto cercando, risponde all'equals
		//indexOf fa un ciclo for interno--> restituisce la posizione dell'oggetto cercato--> poi faccio restituire l esaame con get(pos)
		if(pos==-1){
			return null;
		}else{
			return esami.get(pos);
		}
	}
}
