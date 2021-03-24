package it.polito.tdp.spellchecker.model;

public class Richword {

	String input;
	boolean corretto;
	
	public Richword(String input) {
		
		this.input = input;
		corretto=false;
	}
	
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public boolean isCorretto() {
		return corretto;
	}
	public void setCorretto(boolean corretto) {
		this.corretto = corretto;
	}
	
	
	
	
}
