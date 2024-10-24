package personnages;

import villagegaulois.Musee;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees;
	private int effetPotion = 1;
	private Equipement[] trophees = new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + " >>");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans lamâchoire de " + romain.getNom());
		Equipement[] tropheesLocal = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; tropheesLocal != null && i < tropheesLocal.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = tropheesLocal[i];
		}
	}

	public void boirePotion(int force) {
		effetPotion = force;
		parler("Merci Druide, je sens que ma force est " + force + " fois décuplée.");
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	public void faireUneDonnation(Musee musee) {
		String texte;
		if (nbTrophees > 0) {
			texte = "Je donne au musee tous mes trophees :";
			for (int i = 0; i < nbTrophees; i++) {
				musee.donnerTrophee(this, trophees[i]);
				texte += "\n- " + trophees[i].name();
			}
			parler(texte);
		}

	}
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Romain r = new Romain("r", 0);
		System.out.println(asterix);
		asterix.prendreParole();
		asterix.parler("Bonjour");
		asterix.frapper(r);
		asterix.boirePotion(6);
	}

}
