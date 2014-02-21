package readers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import projetOptimisationCombinatoire.Entreprise;

public class LecteurEntreprises {

	private String cheminListeEntreprises;
	
	public LecteurEntreprises(String cheminListeEntreprises) {
		this.cheminListeEntreprises = cheminListeEntreprises;
	}
	
	public ArrayList<Entreprise> lire() {
		int compteurLignes = 0;
		int nombreLignesSupposees = 0;
		ArrayList<Entreprise> entreprises = new ArrayList<Entreprise>();
		
		try{
			InputStream ips = new FileInputStream(cheminListeEntreprises); 
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			while ((ligne = br.readLine()) != null){
				if (compteurLignes == 0) {
					nombreLignesSupposees = Integer.valueOf(ligne);
					compteurLignes++;
				} else {
					Entreprise entreprise = new Entreprise(ligne);
					entreprises.add(entreprise);
					compteurLignes++;
				}
			}
			br.close();
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
		
		// On vérifie que le nombre d'entreprises
		// correspond à celui du fichier.
		if (entreprises.size() != nombreLignesSupposees) {
			System.err.println("LE NOMBRE D'ENTREPRISES NE CORRESPOND PAS !!!");
		}
		
		return entreprises;
	}
	
}
