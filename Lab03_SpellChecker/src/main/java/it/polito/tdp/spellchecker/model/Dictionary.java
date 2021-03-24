package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public class Dictionary {

	private List <String> parole;
    String linguaScelta;
    List <String> lista = new LinkedList <>();	
    
    
	
	public String getLinguaScelta() {
		return linguaScelta;
	}

	public void setLinguaScelta(String linguaScelta) {
		this.linguaScelta = linguaScelta;
	}

	public void loadDictionary(String language) {
		
		
		parole = new LinkedList<>();
		String s= this.getLinguaScelta()+".txt";
		
		
		try {
			FileReader fr = new FileReader("src/main/resources/"+s);
			BufferedReader br = new BufferedReader(fr);
			String word;
			while((word = br.readLine())!= null) {
				//Richword r = new Richword(word);
				parole.add(word);
			}
			br.close();
		}
		catch(IOException e) {
			System.out.println("Errore lettura del file!");
		}
		
	}
	
	
	public List <String> spellCheckTest (List <String> inputTextList){
	

		for(String sTemp: inputTextList) {
			
		if(!parole.contains(sTemp)) { //cioè parola non è presente nel dizionario --> errata
				
				lista.add(sTemp);
			}
			
		}
		
		
		
		return lista;
		
		
	}

	public List<String> getParoleSbagliate() {
		return lista;
	}

	@Override
	public String toString() {
		return "Dictionary lista=" + lista ;
	}

	


	
	
}
