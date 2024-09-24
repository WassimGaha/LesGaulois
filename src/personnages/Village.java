package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public void ajouterHabitant(Gaulois habitant) {
		villageois[nbVillageois] = habitant;
		nbVillageois++;
	}

	public Gaulois trouverHabitant(int nbHabitant) {
		return villageois[nbHabitant];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public String getNom() {
		return nom;
	}
	public void afficherVillageois() {
		System.out.println("Dans village du chef " + chef.getNom() + " vivent les légendaires gaulois :");
		for (int i=0;i<nbVillageois;i++) {
			System.out.println("- "+villageois[i].getNom());
		}
	}
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
//		 Gaulois gaulois = village.trouverHabitant(30); //INDEX 30 OUT OF BOUNDS FOR LENGTH 30
		Chef abraracourcix = new Chef("Abraracourcix", 6, village);
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterHabitant(asterix);
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois); //NULL
		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
	}
}
