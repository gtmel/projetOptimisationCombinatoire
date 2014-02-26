package branchAndBound;

import model.Model;

public class AlgorithmeBranchAndBound {

	private Model model;
	private SacADos sacADos;
	
	public AlgorithmeBranchAndBound(Model model) {
		this.model = model;
		sacADos = new SacADos();
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public SacADos getSacADos() {
		return sacADos;
	}

	public void setSacADos(SacADos sacADos) {
		this.sacADos = sacADos;
	}
	
}
