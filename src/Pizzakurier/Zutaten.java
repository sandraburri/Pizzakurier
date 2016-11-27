package Pizzakurier;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

@SuppressWarnings({ "nls", "boxing" })

// Dies ist die Grundklasse, diese Klasse enthält nur Informationen und macht 
// nichts weiter. Diese Klasse enthält keinen Konstruktor, sie ist abstrakt.
public class Zutaten {
	
	// Es wird eine Map erstellt der Key ist ein String und der Wert ein Double
	// Die Map heisst zutaten
	private static Map<String, Double> zutaten;

	static {
		
		// TreeMap, damit die Zutaten nach ABC geordnet werden
		zutaten = new TreeMap<>();
		createZutat("Knoblauch", 0.50);
		createZutat("Kräuterbutter", 0.50);
		createZutat("Ei", 1.00);
		createZutat("Oliven", 1.00);
		createZutat("Spinat", 1.00);
		createZutat("Zwiebeln", 1.00);
		createZutat("Ananas", 1.50);
		createZutat("Artischocken", 1.50);
		createZutat("Champignons", 1.50);
		createZutat("Gorgonzola", 1.50);
		createZutat("Kapern", 1.50);
		createZutat("Mais", 1.50);
		createZutat("Peperoncini", 1.50);
		createZutat("Peperoni", 1.50);
		createZutat("Sardellen", 1.50);
		createZutat("Thon", 1.50);
		createZutat("Tomatenscheiben", 1.50);
		createZutat("Mozzarella", 2.00);
		createZutat("Rucola", 2.00);
		createZutat("Salami", 2.00);
		createZutat("Schinken", 2.00);
		createZutat("Pouletfleisch", 2.00);
		createZutat("Meeresfrüchte", 2.00);
		createZutat("Speck", 2.00);
		createZutat("Rindshackfleisch", 2.00);
		createZutat("Mascarpone", 2.00);
		createZutat("Kalbfleisch", 3.00);
		createZutat("Rohschinken", 3.00);
		createZutat("Lachs", 3.00);
		createZutat("Kebabfleisch", 3.00);
		createZutat("Crevetten", 3.00);
	}

	// Gibt eine Liste mit allen Zutaten zurück (ohne Preis)
	// Dafür werden die keys der zutaten verwendet
	public static ArrayList<String> getNames() {
		return new ArrayList<>(zutaten.keySet());
	}

	// Der getter für die Ausgabe des Preises für eine Zutat
	// Geht in den Zutaten schauen, überprüft den Key (String), wenn der ent-
	// sprechende Key gefunden wurde, gibt es den entsprechenden Wert zurück.
	// Dies passiert mittels return zutaten.get(zutat);
	public static double getPreis(String zutat) {
		return zutaten.get(zutat);
	}

	// Diese Methode trägt eine Zutat in unsere Map ein. Somit kann man mit
	// createZutat("Name", Preis); einzfügen. Ist beliebig erweiter oder
	// veränderbar. Falls später andere Möglichkeiten implementiert werden
	// sollten um Zutaten hinzuzufügen (zB über ein Textfile) ist das ganz
	// einfach und es muss nicht in jeder Zeile das put mit add ersetzt werden.
	private static void createZutat(String key, double price) {
		zutaten.put(key, price);
	}
}
