package Pizzakurier;

import java.util.ArrayList;
import java.util.List;

// Dies ist die zweite Klasse, diese Klasse holt Informationen, also die Zutaten
// aus der Klasse Zutaten, enthält aber auch Informationen
public class Pizza {
	
	// GRUNDPREIS ist eine Konstante, jede Pizza kostet so viel, dies ist fix
	// und kann nur hier in diesem Programm korrigiert werden
	private static final double GRUNDPREIS = 11.50;
	
	// Es wird ein neues Objekt, eine Arrayliste erstellt. Die Zutatenliste
	// genau dieser Pizza. Dies ist eine Instanzvariable. Für jede Pizza ist
	// diese Variable, also die Zutatenliste wieder anders.
	private List<String> zutatenliste = new ArrayList<>();

	// Dies ist der Konstruktor
	public Pizza() {
	}

	
	// Das ist der getter für den Grundpreis dieser Pizza
	public double getPreis() {
		double preis = GRUNDPREIS;
		
		// Aus der Zutatenliste wird die Zutat abgeholt
		// Genauer: Es wird über eine Liste von Zutaten iteriert
		for (String zutat : this.zutatenliste) {
			
			// Bei jeder Zutat ist der Preis der Zutat hinterlegt hier wird der
			// Grundpreis und der Preis der Zutat addiert
			// Genauer: Es wird über eine Liste von Zutaten iteriert (sprich
			// nach und nachjede Zutat aus der Liste durchgearbeitet
			// (= Pizzapreis entsprechend erhöht)
			preis += Zutaten.getPreis(zutat);
		}
		
		// Gibt den Totalpreis für die Pizza mit Zutaten zurück
		return preis;
	}

	// Gibt die Zutatenliste dieser Pizza aus. Nicht zu verwechseln mit der
	// Zutatenliste der ganzen Auswahl!
	public List<String> getZutaten() {
		return this.zutatenliste;
	}

	// es wird eine Zutat hinzugefügt, auf diese Pizza aus der Zutatenliste
	public void addZutat(String zutat) {
		this.zutatenliste.add(zutat);
	}
}
