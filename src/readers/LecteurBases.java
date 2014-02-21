package readers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import projetOptimisationCombinatoire.Base;

public class LecteurBases {

	private String cheminListeBases;
	private String prefixCheminBases;
	
	public LecteurBases(String cheminListeBases, String prefixCheminBases) {
		this.cheminListeBases = cheminListeBases;
		this.prefixCheminBases = prefixCheminBases;
	}
	
	public ArrayList<Base> lire() {
		int compteurLignes = 0;
		int nombreBases = 0;
		ArrayList<Base> bases = new ArrayList<Base>();
		
		try{
			InputStream ips = new FileInputStream(cheminListeBases); 
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			while ((ligne = br.readLine()) != null){
				if (compteurLignes == 0) {
					nombreBases = Integer.valueOf(ligne);
					compteurLignes++;
				} else {
					bases.add(lireBase(ligne));
					compteurLignes++;
				}
			}
			br.close();
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
		
		// On vérifie que le nombre de bases
		// correspond à celui du fichier.
		System.out.println("BASES.SIZE = " + bases.size());
		System.out.println("NOMBREBASES = " + nombreBases);
		if (bases.size() != nombreBases) {
			System.err.println("LE NOMBRE DE BASES NE CORRESPOND PAS !!!");
		}
		
		return bases;
	}
	
	private Base lireBase(String cheminFichierBase) {
		int compteurLignes = 0;
		int nombreEntreprises = 0;
		
		String nomBase = cheminFichierBase;
		int coutBase = 0;
		ArrayList<String> entreprises = new ArrayList<String>();
		try{
			InputStream ips = new FileInputStream(prefixCheminBases + cheminFichierBase); 
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			while ((ligne = br.readLine()) != null){
				if (compteurLignes == 0) {
					coutBase = Integer.valueOf(ligne);
					compteurLignes++;
				} else if (compteurLignes == 1) {
					nombreEntreprises = Integer.valueOf(ligne);
					compteurLignes++;
				} else {
					entreprises.add(ligne);
					compteurLignes++;
				}
			}
			br.close();
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
		
		Base base = new Base(nomBase, coutBase, entreprises);
		
		// On vérifie que le nombre d'entreprises
		// correspond à celui du fichier.
		if (entreprises.size() != nombreEntreprises) {
			System.err.println("LE NOMBRE D'ENTREPRISES NE CORRESPOND PAS !!!");
		}
		
		return base;
	}
	
}