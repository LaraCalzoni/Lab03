package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.*;
import it.polito.tdp.spellchecker.model.Dictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {

	private Dictionary model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private TextArea txtInserito;

    @FXML
    private Button btnSpellCheck;

    @FXML
    private TextArea txtParoleSbagliate;

    @FXML
    private Label numErrori;

    @FXML
    private Button btnClear;

    @FXML
    private Label numSecondi;

    @FXML
    void doClearText(ActionEvent event) {
    	txtParoleSbagliate.clear();
    	numErrori.setText("");
    	numSecondi.setText("");
    	txtInserito.clear();
    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	 
    	//long start= System.nanoTime();
    	//gestione dell'interfaccia
    	this.txtParoleSbagliate.clear();
    	
    	model.setLinguaScelta(choiceBox.getValue());
    	model.loadDictionary(model.getLinguaScelta());
    	
    	
    	//lettura input dell'utente
    	List <String> testo =  new LinkedList <String>(); //txtInserito.getText();
    	
    	String [] paroleInserite;
    	paroleInserite= txtInserito.getText().split(" ");
    	for(String s: paroleInserite) {
    		s=s.replaceAll("[.,\\/#?!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "").toLowerCase();
    		testo.add(s);
    	}
    	
    	long start= System.nanoTime();
    	model.spellCheckTest(testo);
    	long end= System.nanoTime();
    	txtParoleSbagliate.setText(model.getParoleSbagliate().toString());
    	numErrori.setText(Integer.toString(model.getParoleSbagliate().size()));
    	numSecondi.setText(Integer.toString((int) (end-start)));
    	
    	
    }

    @FXML
    void initialize() {
        assert choiceBox != null : "fx:id=\"choiceBox\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInserito != null : "fx:id=\"txtInserito\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSpellCheck != null : "fx:id=\"btnSpellCheck\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParoleSbagliate != null : "fx:id=\"txtParoleSbagliate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert numErrori != null : "fx:id=\"numErrori\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert numSecondi != null : "fx:id=\"numSecondi\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Dictionary model) {
    	this.model= model;
    	choiceBox.getItems().addAll("English", "Italian");
    	
    	
    }
    
}

