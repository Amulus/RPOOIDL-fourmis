package outils;

public class Aleatoire {

	private static double GenererUnPoidDeLarveAleatoire(){
		//Genere un nombre entre 3 et 4, correspond(max-min)+1+min
	   int multiplicateurDePoid =(int) Math.floor(Math.random() * 2 + 3);
	   double poidDuneFourmi = GenererUnPoidDeFourmiAleatoire();
	   return poidDuneFourmi*multiplicateurDePoid;
	}
	private static double GenererUnPoidDeFourmiAleatoire(){
		//Genere un nombre entre 1.5 et 2
		return (double)Math.floor(Math.random() * 6 + 15)*0.1;

	}
}