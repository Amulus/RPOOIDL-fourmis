package outils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LireParametres {
	private String CheminFichierParametres = "ressources/config.txt";
	private Scanner scanner = null;

	public LireParametres() {
	}

	public Object ChercherParametre(String NomParametre) {
		try {
			File file = new File(this.CheminFichierParametres);
			this.scanner = new Scanner(file);
			if (this.scanner == null)
				throw new FileNotFoundException("Le fichier n'as pas ete initialise");
			while (this.scanner.hasNextLine()) {
				String LigneDufichier = this.scanner.nextLine();
				if (LigneDufichier.contains(NomParametre)) {
					scanner.close();
					String StringValeurParametre = LigneDufichier.substring(LigneDufichier.indexOf("=") + 1);
					if (StringValeurParametre.contains("."))
						return Double.parseDouble(StringValeurParametre);
					if (EssaierDeParserEnInt(StringValeurParametre))
						return Integer.parseInt(StringValeurParametre);
					return StringValeurParametre;
				}
			}
			return null;
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return null;
	}

	boolean EssaierDeParserEnInt(String texte) {
		try {
			Integer.parseInt(texte);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
