package lektion3;

import java.util.Locale;
import java.util.Scanner;

public class Uebung2 {
	public static void main (String[] args) {
		Locale.setDefault(Locale.ENGLISH);
		Scanner scanner = new Scanner(System.in);
		
		// Eingabe
		try {
			System.out.println("Bitte geben Sie den Durchmesser der ersten Pizza. ");
			float DurchmesserPizza1 = scanner.nextFloat();
			System.out.println("Bitte geben Sie den Durchmesser der zweiten Pizza. ");
			float DurchmesserPizza2 = scanner.nextFloat();
			System.out.println("Bitte geben Sie den Preis der ersten Pizza. ");
			float PreisPizza1 = scanner.nextFloat();
			System.out.println("Bitte geben Sie den Preis der zweiten Pizza. ");
			float PreisPizza2 = scanner.nextFloat();
			scanner.close();
			
			// Verarbeitung
			float FlaechePizza1 = (float) (Math.PI * DurchmesserPizza1 * DurchmesserPizza1 / 4);
			float FlaechePizza2 = (float) (Math.PI * DurchmesserPizza2 * DurchmesserPizza2 / 4);
			float PreisProFlaechePizza1 = PreisPizza1 / FlaechePizza1;
			float PreisProFlaechePizza2 = PreisPizza2 / FlaechePizza2;
			
			// Ausgabe
			System.out.println("Flaeche der ersten Pizza: " + FlaechePizza1 +
					"\nFlaeche der zweiten Pizza: " + FlaechePizza2 +
					"\nPreis pro Flaeche der ersten Pizza: " + PreisProFlaechePizza1 +
					"\nPreis pro Flaeche der zweiten Pizza: " + PreisProFlaechePizza2);
			if (PreisProFlaechePizza1 < PreisProFlaechePizza2) {
				System.out.println("Die erste Pizza hat besseres Groessen-/Preisverhaeltnis.");
			} else if (PreisProFlaechePizza1 == PreisProFlaechePizza2) {
				System.out.println("Die beiden Pizzas haben gleiches Groessen-/Preisverhaeltnis.");
			} else {
				System.out.println("Die zweite Pizza hat besseres Groessen-/Preisverhaeltnis.");
			}
		} catch (Exception e) {
			System.out.println("Fehlermeldung, Sie haben keine Zahl eingegeben.");
		}
	}
}
