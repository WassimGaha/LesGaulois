package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		assert force > 0;
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + " >> ");
	}

	public void sEquiper(Equipement eq) {
		switch (nbEquipement) {
		case 2:
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			break;
		case 1:
			if (equipements[0].equals(eq)) {
				System.out.println("Le soldat " + nom + " possède déjà un " + eq + ".");
			} else {
				System.out.println("Le soldat " + nom + " s'équipe avec un " + eq + ".");
				equipements[1] = eq;
				nbEquipement++;
			}
			break;
		default:
			System.out.println("Le soldat " + nom + " s'équipe avec un " + eq + ".");
			equipements[0] = eq;
			nbEquipement++;
			break;
		}
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert force >= 0;
		int forceInit = force;
		force -= forceCoup;
		assert forceInit < force;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}

	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
	}
}
