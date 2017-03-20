package it.polito.tdp.model;

import java.time.LocalDate;

public class Esame {

	//oggetto semplice che contiene i dati relativi ad un singolo esame
	//POJO-plain old java object
	//contiene dati privati, costruttore, metodi getter e setter, pi� i metodi di servizio--> equals, toString, hashcode, [compareTo]
	
	
	private String codice;
	private String titolo;
	private String docente;
	private boolean superato;
	private int voto;
	private LocalDate dataSuperamento;
	
	/**
	 * NUOVO ESAME, non ancora superato
	 * @param codice codice dell'esame
	 * @param titolo denominazione del corso
	 * @param docente cognome e nome docente titolare
	 */
	public Esame(String codice, String titolo, String docente) {
		
		this.codice = codice;
		this.titolo = titolo;
		this.docente = docente;
		this.superato=false;
	}

	/**
	 * @return the codice
	 */
	public String getCodice() {
		return codice;
	}

	/**
	 * @param codice the codice to set
	 */
	public void setCodice(String codice) {
		this.codice = codice;
	}

	/**
	 * @return the titolo
	 */
	public String getTitolo() {
		return titolo;
	}

	/**
	 * @param titolo the titolo to set
	 */
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	/**
	 * @return the docente
	 */
	public String getDocente() {
		return docente;
	}

	/**
	 * @param docente the docente to set
	 */
	public void setDocente(String docente) {
		this.docente = docente;
	}

	/**
	 * @return the superato
	 */
	public boolean isSuperato() {
		return superato;
	}

	/**
	 * @param superato the superato to set
	 */
	private void setSuperato(boolean superato) {
		this.superato = superato;
	}

	/**Restituisce voto solo se l'esame � stato superato--> altrimenti eccezione
	 * @return the voto
	 */
	public int getVoto() {
		if(this.superato){
		return voto;
		}else
			throw new IllegalStateException("Esame "+this.codice+ " non ancora superato!");
	       
	}

	/**
	 * @param voto the voto to set
	 */
	private void setVoto(int voto) {
		this.voto = voto;
	}

	/**
	 * @return the dataSuperamento
	 */
	public LocalDate getDataSuperamento() {
		if(this.superato){
			return dataSuperamento;
			}else{
				throw new IllegalStateException("Esame "+this.codice+ " non ancora superato!");
			}
	}

	/**
	 * @param dataSuperamento the dataSuperamento to set
	 */
	private void setDataSuperamento(LocalDate dataSuperamento) {
		this.dataSuperamento = dataSuperamento;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Esame [codice=" + codice + ", titolo=" + titolo + ", docente=" + docente + ", superato=" + superato
				+ ", voto=" + voto + ", dataSuperamento=" + dataSuperamento + "]";
	}

		/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) { //definisco io il metodo equals--> basta confrontare solo il codice per vedere se due esami sono uguali
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Esame other = (Esame) obj;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		return true;
	}
	
	/**
	 * Se l'esame non � ancora superato, lo considera superato con la data e il voto specificati
	 * Se incece l'esame era gi� stato superato generiamo l'eccezione
	 * @param voto
	 * @param data
	 */
	public void supera(int voto, LocalDate data){
		if(!this.superato){
			this.superato=true;
			this.voto=voto;
			this.dataSuperamento= data;
		}else{
			throw new IllegalStateException("Esame "+this.codice+ " gi� superato!");
			                                 //eccezioni a runtime, � stato chiamato un metodo quando non si deve
			                                   //illegal argument--> quando viene passato un dato non lecito
		}
	}
	
	
}
