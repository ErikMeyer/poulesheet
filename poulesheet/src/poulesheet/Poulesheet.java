package poulesheet;

import java.util.ArrayList;

public class Poulesheet {
	public ArrayList<Equipe> equipes = new ArrayList<Equipe>();
	public int numbPistes = 1;

	public Poulesheet() {
		myInit();
	}
	
	private void myInit() {
	    addEquipe("no equipe", "");   
	}
	
	public ArrayList<Equipe> getEquipes() {
		return equipes;
	}
	
	public void addEquipe(String equipeName, String equipeClub) {
		Equipe equipe = new Equipe(equipeName, equipeClub);
		equipes.add(equipe);
	}
	
	/* Returns the number of equipes registered.
	 * This number includes the default 'no equipe'
	 * container for solo fencers. */
	public int countEquipes() {
		return equipes.size();
	}
	
	public void setPistes(int numbPistes) {
		this.numbPistes = numbPistes;
	}
	
	public int getPistes() {
		return numbPistes;
	}

}
