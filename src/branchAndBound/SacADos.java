package branchAndBound;

import java.util.ArrayList;

public class SacADos {
	
	private ArrayList<String> listeResultats;
	private int coutOptimal;
	
	public SacADos() {
		this.listeResultats = new ArrayList<String>();
		this.coutOptimal = 0;
	}

	public ArrayList<String> getListeResultats() {
		return listeResultats;
	}

	public void setListeResultats(ArrayList<String> listeResultats) {
		this.listeResultats = listeResultats;
	}

	public int getCoutOptimal() {
		return coutOptimal;
	}

	public void setCoutOptimal(int coutOptimal) {
		this.coutOptimal = coutOptimal;
	}

}