import java.util.Arrays;
import java.util.Scanner;

public class test {


	public static void helloWorld(){

		System.out.println("Hello World!");

	}

	public static void tp1_2(){

		int a=5, b=2, c;
		c = a;
		a = b;
		b = c;
		System.out.println("a vaut "+a+ ", b vaut "+b+" et c vaut "+c);

	}

	public static void tp1_3(){

		int a=1, b=2, c=3, d;
		d = c;
		c = b;
		b = a;
		a = d;

		System.out.println("a vaut "+a+ ", b vaut "+b+" et c vaut "+c);

	}

	public static void tp2_1(){

		int choix, choixCarre;

		Scanner sc= new Scanner(System.in);
		System.out.println("Entre un nombre");
		choix = sc.nextInt();
		choixCarre = choix * choix;

		System.out.println("Le carré de "+choix+" est "+choixCarre);

	}

	public static void tp2_2(){

		int nombre;
		double prixHT, tauxTVA, prixTTC, taxe;

		Scanner sc1= new Scanner(System.in);
		Scanner sc2= new Scanner(System.in);


		System.out.println("Prix HT ?");
		prixHT = sc1.nextDouble();


		System.out.println("Nombre d'articles ?");
		nombre = sc2.nextInt();

		System.out.println("TVA en pourcentage ?");
		tauxTVA = sc1.nextDouble();

		taxe = prixHT * tauxTVA / 100;
		prixTTC = (prixHT + taxe) * nombre;


		System.out.println("Pour acheter "+ nombre + " article(s) à "+prixHT+ "€ pièce, avec une TVA de "+tauxTVA+ " %, il faut payer "+ prixTTC +"€");

	}

	public static void tp3_1(){

		int choix;

		System.out.println("Choisissez un nombre :");
		Scanner sc= new Scanner(System.in);

		choix = sc.nextInt();

		if (choix < 0) {

			System.out.println(choix + " est un nombre négatif !");

		}

		else {

			System.out.println(choix + " est un nombre positif !");
		}

	}

	public static void tp3_2(){

		int choix1, choix2, resultat;
		Scanner sc= new Scanner(System.in);

		System.out.println("Choisissez un premier nombre :");
		choix1 = sc.nextInt();

		System.out.println("Choisissez un deuxième nombre :");
		choix2 = sc.nextInt();

		resultat = choix1 * choix2;

		if ((choix1 < 0 && choix2 > 0) || (choix1 > 0 && choix2 < 0)) {

			System.out.println("Le produit de "+choix1+" et "+choix2+ " est négatif et vaut "+resultat+ " !");

		}

		else {

			System.out.println("Le produit de "+choix1+" et "+choix2+ " est positif et vaut "+resultat+ " !");
		}

	}

	public static void tp3_3(){

		int choix;

		System.out.println("Choisissez un nombre :");
		Scanner sc= new Scanner(System.in);

		choix = sc.nextInt();

		if (choix < 0) {	
			System.out.println(choix + " est un nombre négatif !");	
		}

		else if (choix == 0) {		
			System.out.println(choix + " est égal à 0 !");
		}

		else {
			System.out.println(choix + " est un nombre positif !");
		}

	}

	public static void tp3_4(){

		int choix1, choix2, resultat;
		Scanner sc= new Scanner(System.in);

		System.out.println("Choisissez un premier nombre :");
		choix1 = sc.nextInt();

		System.out.println("Choisissez un deuxième nombre :");
		choix2 = sc.nextInt();

		resultat = choix1 * choix2;

		if ((choix1 < 0 && choix2 > 0) || (choix1 > 0 && choix2 < 0)) {

			System.out.println("Le produit de "+choix1+" et "+choix2+ " est négatif et vaut "+resultat+ " !");

		}

		else if (choix1 == 0 || choix2 == 0){

			System.out.println("Le produit de "+choix1+" et "+choix2+ " est nul !");
		}

		else {
			System.out.println("Le produit de "+choix1+" et "+choix2+ " est positif et vaut "+resultat+ " !");


		}
	}

	public static void tp3_5(){

		int age;
		Scanner sc= new Scanner(System.in);

		System.out.println("Quel âge a l'enfant ?");
		age = sc.nextInt();


		if (age >= 12) {

			System.out.println("Cadet");

		}

		else if (age >= 10 ){

			System.out.println("Minime");
		}
		else if (age >= 8){

			System.out.println("Pupille");
		}

		else if (age >= 6){
			System.out.println("Poussin");

		}
		else {

			System.out.println("Nouveau né");

		}
	}


	public static void tp4_1(){

		int heure, min;

		Scanner sc = new Scanner(System.in);

		System.out.println("Heure ?");
		heure = sc.nextInt();

		System.out.println("Minute ?");
		min = sc.nextInt();

		if (heure == 23) {

			if (min == 59) {

				heure = 0;
				min = 0;	
			}

			else {
				min++;
			}
		}

		else {

			if (min == 59) {

				heure++;
				min = 0;
			}

			else {
				min++;
			}
		}

		System.out.println("Dans une minute, il sera "+heure+"h"+min+".");
	}

	public static void tp4_2(){

		int heure, min, sec;

		Scanner sc = new Scanner(System.in);

		System.out.println("Heure ?");
		heure = sc.nextInt();

		System.out.println("Minute ?");
		min = sc.nextInt();

		System.out.println("Secondes ?");
		sec = sc.nextInt();

		sec++;

		if (sec == 60) {
			sec = 0;
			min++;
		}

		if (min == 60) {
			min = 0;
			heure++;
		}

		if (heure == 24) {
			heure = 0;
		}




		System.out.println("Dans une seconde, il sera "+heure+"h"+min+"min"+sec+"sec");
	}	


	public static void tp4_3(){

		double nombre, reste, prix;

		Scanner sc = new Scanner(System.in);

		System.out.println("Nombre de photocopies ?");
		nombre = sc.nextInt();

		if (nombre <= 10) {

			prix = 0.1 * nombre;

		}

		else if (nombre <= 30) {

			reste = nombre -10;
			prix = 1 + 0.09 * reste;
		}

		else {

			reste = nombre -30;
			prix = 2.8 + 0.08 * reste;
		}

		System.out.println("Pour faire "+nombre+" photocopies, il faut payer "+ prix +"€");
	}	


	public static void tp4_4(){

		int age, sexe;

		Scanner sc = new Scanner(System.in);

		System.out.println("Sexe (0 femme - 1 homme) ?");
		sexe = sc.nextInt();

		System.out.println("Age ?");
		age = sc.nextInt();

		if (sexe == 1 && age > 20) {

			System.out.println("Ce Zorglubien est imposable !");

		}

		else if (sexe == 0 && (age >= 18 && age <= 35)) {

			System.out.println("Ce Zorglubien est imposable !");

		}

		else {

			System.out.println("Ce Zorglubien n'est pas imposable !");

		}

	}


	public static void tp4_5(){

		int age, tempsPermis, nbAccidents, anciennete, score=0;

		Scanner sc = new Scanner(System.in);

		System.out.println("Age ?");
		age = sc.nextInt();

		System.out.println("Temps de permis ?");
		tempsPermis = sc.nextInt();

		System.out.println("Nombre d'accidents ?");
		nbAccidents = sc.nextInt();

		System.out.println("Ancienneté ?");
		anciennete = sc.nextInt();


		if (age >= 25) {score++;}
		if (tempsPermis >=2) {score++;}

		switch(nbAccidents) {
		case 0 : score++;break;
		case 2 : score--;break;
		case 3 : score -= 2;break;
		default : score -= 50; //Lol
		}

		if (score <= 0) {System.out.println("Vous ne serez pas assurés chez nous !");}
		else if (anciennete >=5){

			switch(score) {
			case 1 : System.out.println("Tarif ROUGE, mais comme vous êtes fidèle, vous passez en ORANGE !");break;
			case 2 : System.out.println("Tarif ORANGE, mais comme vous êtes fidèle, vous passez en VERT !");break;
			default : System.out.println("Tarif VERT, mais comme vous êtes fidèle, vous passez en BLEU !");break;
			}			
		}
		else {

			switch(score) {
			case 1 : System.out.println("Tarif ROUGE !");break;
			case 2 : System.out.println("Tarif ORANGE !");break;
			default : System.out.println("Tarif VERT !");break;
			}	
		}	
	}

	public static void tp4_6(){

		int jour, mois, annee;
		boolean valide = true;

		Scanner sc = new Scanner(System.in);

		System.out.println("Jour ?");
		jour = sc.nextInt();

		System.out.println("Mois ?");
		mois = sc.nextInt();

		System.out.println("Année ?");
		annee = sc.nextInt();

		if (jour < 1 || jour > 31 || mois < 1 || mois > 12 || annee < 1) {System.out.println("Année non valide"); valide = false;}
		else if (mois == 2 || mois == 4 || mois == 6 || mois == 9 || mois == 11) {
			if(jour == 31 ) {System.out.println("Année non valide"); valide = false;}
		}
		if (mois == 2 && jour == 29) {
			if ((annee%100 == 0 && annee%400 != 0) || annee%4 != 0) {System.out.println("Année non valide"); valide = false;}
		}
		if (mois == 2 && jour > 29) {System.out.println("Année non valide"); valide = false;}
		if (valide) {System.out.println("La date :"+jour+ "/"+mois+"/"+annee+" est valide !");}
	}

	public static void tp5_1(){

		int choix;

		Scanner sc= new Scanner(System.in);
		System.out.println("Choisissez un nombre entre 1 et 3");
		choix = sc.nextInt();

		while (choix < 1 || choix > 3) {

			System.out.println("On a dit entre 1 et 3 !");
			choix = sc.nextInt();
		}
		System.out.println("GG !");
	}

	public static void tp5_2(){

		int choix;

		Scanner sc= new Scanner(System.in);
		System.out.println("Choisissez un nombre entre 10 et 20");
		choix = sc.nextInt();

		while (choix < 10 || choix > 20) {

			if (choix < 10) {System.out.println("Il faut un nombre plus grand !");}
			else {System.out.println("Il faut un nombre plus petit !");}
			choix = sc.nextInt();
		}
		System.out.println("GG !");
	}

	public static void tp5_3(){

		int choixInitial, i;

		Scanner sc= new Scanner(System.in);

		System.out.println("Choisissez un nombre Et j'afficherai les 10 suivants");
		choixInitial = sc.nextInt();

		i = choixInitial;

		while (i < choixInitial +10) {
			i++;
			System.out.println(i);
		}
		System.out.println("Et voila !");
	}

	public static void tp5_4(){

		int choix;

		Scanner sc= new Scanner(System.in);

		System.out.println("Choisissez un nombre Et j'afficherai les 10 suivants");
		choix = sc.nextInt();


		for ( int i = 1; i <= 10; i++) {
			choix++;
			System.out.println(choix);
		}
		System.out.println("Et voila !");
	}

	public static void tp5_5(){

		int choix, result;

		Scanner sc= new Scanner(System.in);

		System.out.println("Choisissez un nombre Et j'afficherai sa table de multiplication");
		choix = sc.nextInt();

		System.out.println("Table de "+choix+" :");

		for ( int i = 1; i <= 10; i++) {
			result = choix * i;
			System.out.println(choix+" x "+i+" = "+result);
		}
		System.out.println("Et voila !");
	}

	public static void tp5_6(){

		int choix, plusGrand = 0, pos = 0;

		Scanner sc= new Scanner(System.in);

		for (int i = 1; i <= 5; i++) {
			System.out.println("Entrez le nombre "+i+" :");
			choix = sc.nextInt();
			if (i == 1) {plusGrand = choix;}
			if (choix > plusGrand) {plusGrand = choix;pos = i;}	
		}

		System.out.println("Le nombre le plus grand est : "+plusGrand);
		System.out.println("Il était en position "+pos);

	}

	public static long fact(int nb) 

	{
		long fact=1;
		for (int i = 1; i < nb; i++) 
		{
			fact*=i;
		}
		return fact;
	}

	public static void tp5_7(){

		int n, p;
		long  x, y;

		Scanner sc= new Scanner(System.in);

		System.out.println("Nombre de chevaux partant ?");
		n = sc.nextInt();

		System.out.println("Nombre de chevaux joués ?");
		p = sc.nextInt();


		x = fact(n)/fact(n-p);
		y = fact(n)/(fact(p)*fact(n-p));


		System.out.println("Dans l'ordre : une chance sur "+x+" de gagner !");
		System.out.println("Dans le désordre : une chance sur "+y+" de gagner !");
	}

	public static void tp5_8(){

		float Tab[]= new float [6];

		//Scanner sc = new Scanner(System.in);

		for (int i = 0; i <= Tab.length-1; i++) {

			Tab[i] = 0;
		}
		System.out.println(Arrays.toString(Tab));
	}



	public static void main(String[] args) {
		tp5_8();	
	}



}
