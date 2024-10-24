package villagegaulois;

import personnages.Equipement;
import personnages.Gaulois;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee;
	
	public void donnerTrophee(Gaulois donnateur, Equipement don) {
		Trophee trophee = new Trophee(donnateur, don);
		trophees[nbTrophee] = trophee;
		nbTrophee++;
	}
	
	public String extraireInstructionsOCaml() {
		String texte = "let musee = [";
		for (int i = 0; i < nbTrophee; i++) {
			texte += "\n\t\"" + trophees[i].donnerNom() + "\", \"" + trophees[i].getEquipement() + "\"";
			if (i < (nbTrophee-1)) {
				texte += ";";
			} else {
				texte += "\n";
			}
		}
		texte += "]";
		return texte;
	}
}
