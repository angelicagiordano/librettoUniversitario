package it.polito.tdp.libretto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import it.polito.tdp.model.*;
public class LibrettoController {

	LibrettoModel model;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtCodice;

    @FXML
    private TextField txtDocente;

    @FXML
    private TextField txtTitolo;

    @FXML
    private Button btnCerca;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtMessage;

    @FXML
    void doCerca(ActionEvent event) {
    	String codice = txtCodice.getText();
    	if(codice.length()<5){
    		txtMessage.appendText("Dati esami insufficienti");
    		return;
    	
    	}else{
    		Esame e= model.trovaEsame(codice);
    		if(e==null){
    			txtMessage.appendText("Codice "+codice+" non trovato");
    		}else{
    			txtMessage.appendText("Codice "+codice+"  trovato");
    			
    			txtCodice.setText(e.getCodice());
    	    	txtTitolo.setText(e.getTitolo());
    	    	txtDocente.setText(e.getDocente());
    	    	
    		}
    	}
    	
    }


    

    @FXML
    void doInserisci(ActionEvent event) {
//recupera i dati della vista,
    	
    	String codice= txtCodice.getText();
    	String titolo=txtTitolo.getText();
    	String docente= txtDocente.getText();
    	
    	//verifica la validita dei dati
    	if(codice.length()<5 || titolo.length()==0 || docente.length()==0){
    		txtMessage.appendText("Dati esami insufficienti");
    		return;
    	}
    	
    	//chiedi al model di effettuare l'operazione
    	Esame e= new Esame(codice, titolo,docente);
    	boolean result = model.addEsame(e);
    	//aggiorna vista con il risulato dell'operazione
    	if(result){
    		txtMessage.appendText("Esame aggiunto correttamente");
    		
    		
    	}else{
    	
    		txtMessage.appendText("Esame non aggiunto correttamente (codice duplicato)\n");
        	
    	}
    	//il modello non deve essere inserito nel controllore
    	
    }
    


    
    /**
   	 * @param model the model to set
   	 */
   	public void setModel(LibrettoModel model) {
   		this.model = model;
   	}



    @FXML
    void initialize() {
        assert txtCodice != null : "fx:id=\"txtCodice\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtDocente != null : "fx:id=\"txtDocente\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtTitolo != null : "fx:id=\"txtTitolo\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtMessage != null : "fx:id=\"txtMessage\" was not injected: check your FXML file 'Libretto.fxml'.";

    }
}
