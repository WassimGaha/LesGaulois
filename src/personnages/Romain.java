package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		assert verifierForcePositive();
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
				ajouterEquipement(eq);
			}
			break;
		default:
			ajouterEquipement(eq);
			break;
		}
	}

	private void ajouterEquipement(Equipement eq) {
		System.out.println("Le soldat " + nom + " s'équipe avec un " + eq + ".");
		equipements[nbEquipement] = eq;
		nbEquipement++;
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert verifierForcePositive();
		int forceInit = force;
		force -= forceCoup;
		assert verifierForcePositive();
		assert verifierForceDiminue(forceInit);
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
	}

	private boolean verifierForceDiminue(int forceInit) {
		return forceInit < force;
	}

	private boolean verifierForcePositive() {
		return force >= 0;
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
	}
}
