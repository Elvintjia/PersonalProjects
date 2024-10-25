package lektion2;

import java.time.LocalTime;

public class Uebung3Weiterfuehrend {
	public static void main (String[] args) {
		// Uhrzeit
		LocalTime Uhrzeit = LocalTime.now();
		System.out.println("Zeit: " + Uhrzeit);
		
		// Sekunden seit Mitternacht
		int SekundenSeitMitternacht = Uhrzeit.getHour() * 3600 + Uhrzeit.getMinute() * 60 + Uhrzeit.getSecond();
		System.out.println("Sekunden seit Mitternacht: " + SekundenSeitMitternacht);
		
		// Verbleibenden Sekunden fuer diesen Tag
		final int SekundenDesGanzenTages = 24 * 3600;
		System.out.println("Verbleibenden Sekunden fuer diesen Tag: " + (SekundenDesGanzenTages - SekundenSeitMitternacht));
		
		// Prozent des Tages schon vergangen
		System.out.println("Prozent des Tages schon vergangen: " + ((float) SekundenSeitMitternacht/SekundenDesGanzenTages * 100) + "%");
	}
}
