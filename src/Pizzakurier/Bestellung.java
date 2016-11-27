                      
package Pizzakurier;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Dies ist die dritte Klasse, diese Klasse holt Informationen, also die Zutaten
// aus der Klasse Zutaten und den Grundpreis aus der Klasse Pizza. Diese Klasse
// enthält Informationen und einen Scanner, welcher mit dem Kunden interagiert.
// Diesen Aufbau der drei Klassen nennt man Composition (Zusammenspiel) jede 
// Klasse hat eine klare Funktion es existiert keine Vererbung (extends)

@SuppressWarnings("nls")
public class Bestellung {

	// ein neues Objekt wird erzeugt mit = new ArrayList<>() ,
	// wird während der Erstellung des Bestellung Objekts automatisch
	// instanziert
	private List<Pizza> pizzas = new ArrayList<>();
	
	// ???? Text dazu siehe ATM Bank Repetition Sandra noch ergänzen!
	private Scanner scanner = new Scanner(System.in);

	// ???? Text dazu siehe ATM Bank Repetition Sandra noch ergänzen!
	public void run() {

		// Neue Bestellung wird genau 1x ausgegeben, ganz am Anfang der
		// Bestellung
		System.out.println("NEUE BESTELLUNG");

		// Es geht in den Loop Bestellung, beim ersten Durchgang ist der Zustand
		// false und es wird noch nichts ausgegeben
		boolean printBestellung = false;

		// Die while Schleife wird durchlaufen bis der Benutzer die Bestellung
		// abschliesst (Bestätigung) oder abbricht (Exit).
		while (true) {

			// Nach dem Durchlauf des Loops wird die aktuelle Bestellung mit
			// allen Positionen ausgegeben. Die Logik wird mit printBestellung
			// gesteuert dass es nur bei Durchlauf 1-n passiert.
			if (printBestellung) {
				printBestellung();
			}

			// Hiermit wird der Zustand der Variable auf true gesetzt.
			printBestellung = true;

			// Ausgabe Hauptmenu an den Kunden
			System.out.println("A  Neue Pizza");
			System.out.println("B  Bestätigung");
			System.out.println("X  Exit");
			System.out.println();

			// Das Programm wartet auf die Eingabe des Buchstabens UND Enter,
			// nextLine() verlangt das Enter, .toUpperCase() macht aus der
			// Eingabe automatisch Grossbuchstaben, damit das nicht noch
			// kontrolliert werden muss
			String choice = this.scanner.nextLine().toUpperCase();

			// switch prüft mehrere Zustände der choice Variable ab
			// Jedes case entspricht einem if
			switch (choice) {
			case "A":
				Pizza pizza = createPizza();

				// Überprüft ob etwas zurückgegeben wurde
				if (pizza != null) {

					// Falls ja, wird die Pizza in der Bestellung gespeichert
					// Die Bestellung ist eine Liste von Pizzen
					this.pizzas.add(pizza);
				}
				break;

			case "B":
				// Ausgabe, wenn der Kunde seine Bestellung bestätigt
				System.out.println("Danke für Ihre Bestellung");
				System.exit(0);
				break;

			case "X":
				// Wenn der Kunde sich gegen eine Bestellung entscheidet,
				// bricht das Programm ab
				System.exit(0);
				break;

			// default = alle nicht behandelten Fälle (nicht A,B,X)
			default:
								
				// Ausgabe bei einem Eingabe Fehler
				System.out.println("Error: Invalid input");
			}
		}
	}

	public Pizza createPizza() {
		Pizza pizza = new Pizza();
		System.out.println("NEUE PIZZA");
		System.out.println("Wählen Sie Ihre Zutaten mit der jeweiligen Nummer");
		System.out.println("Bestätigen Sie die Pizza mit A");

		// Liste mit Zutaten erscheint ohne Preise wird bei der Klasse Zutaten
		// abgeholt
		ArrayList<String> names = Zutaten.getNames();
		System.out.println();
		System.out.println("Zutaten:");

		// Ausgabe der Nummern (Position in der Liste) der Zutaten
		for (int j = 0; j < names.size(); j++) {
			System.out.println(j + " " + names.get(j));
		}
		System.out.println();

		while (true) {
			System.out.println("Aktuelle Pizza:");

			// jede gewählte Zutat wird aufgelistet
			System.out.println("Zutaten: " + pizza.getZutaten().toString());

			// jede Preisaktualisierung wird ausgegeben
			System.out.println("Preis: " + pizza.getPreis());
			System.out.println();
			System.out.println("A  Bestätigen");
			System.out.println("B  Abbrechen");
			System.out.println();

			String choice = this.scanner.nextLine().toUpperCase();
			switch (choice) {
			case "A":
				return pizza;

			case "B":
				return null;

			default:
				// default in diesem Fall, nicht A nicht B
				
				try {
					// Die Nummern der Zutaten werden überprüft, entspricht die
					// Nummer einer der Liste, wird die Zutat hinzugefügt
					int number = Integer.parseInt(choice);
					String name = names.get(number);
					pizza.addZutat(name);
				} catch (Exception ex) {
					// Rückmeldung bei irgend einer falschen Eingabe
					System.out.println("Ungültige Auswahl");
				}
				break;
			}
		}
	}

	private void printBestellung() {
		System.out.println();
		System.out.println("Aktuelle Bestellung:");
		if (this.pizzas.size() > 0) {
			double total = 0;

			// Pro Pizza werden Zutaten und Preis in einer Zeile ausgegeben
			for (Pizza pizza : this.pizzas) {
				System.out.print(" * ");
				System.out.print("Zutaten: " + pizza.getZutaten().toString());
				total += pizza.getPreis();
				System.out.println(" Preis: " + pizza.getPreis());
			}
			System.out.println(" * Total: " + total);
		} else {
			System.out.println(" * Keine Pizza gewählt");
		}
		System.out.println();
	}
}