package poulesheet;

import java.util.ArrayList;

import poulesheet.Fencer.Weapon;

public class Equipe {
	public ArrayList<Fencer> fencers = new ArrayList<Fencer>();
	private String equipeName = null;
	private String equipeClub = null;
	
	public Equipe(String equipeName, String equipeClub) {
		this.equipeName = equipeName;
		this.equipeClub = equipeClub;
	}
	
	public ArrayList<Fencer> getFencers() {
		return fencers;
	}
	
	public String getEquipeName() {
		return equipeName;
	}
	
	public String getEquipeClub() {
		return equipeClub;
	}
	
	public void addFencerToEquipe(String firstName, String lastName, Weapon weapon, String country, String clubName) {
		Fencer fencer = new Fencer(firstName, lastName, weapon, country, clubName);
		fencers.add(fencer);
	}
	

}
