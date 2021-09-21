package adventureGame;

public class Weapon {
	
	private String weaponName;
	private int weaponDamage;
	
	public Weapon(String weaponName, int weaponDamage) {
		this.weaponName = weaponName;
		this.weaponDamage = weaponDamage;
	}

	public String getWeaponName() {
		return weaponName;
	}

	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}

	public int getWeaponDamage() {
		return weaponDamage;
	}

	public void setWeaponDamage(int weaponDamage) {
		this.weaponDamage = weaponDamage;
	}

}
