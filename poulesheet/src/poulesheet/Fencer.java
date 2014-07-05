package poulesheet;

public class Fencer {
	private String firstName = null;
	private String lastName = null;
	public enum Weapon {FOIL, EPEE, SABRE};
	private Weapon weapon = null;
	private String country = null;
	private String clubName = null;
	
	public Fencer(String firstName, String lastName, Weapon weapon, String country, String clubName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.weapon = weapon;
		this.country = country;
		this.clubName = clubName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public Weapon getWeapon() {
		return weapon;
	}
	
	public String getCountry() {
		return country;
	}
	
	public String getClubName() {
		return clubName;
	}

}
