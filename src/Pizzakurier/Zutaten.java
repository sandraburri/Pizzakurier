package Pizzakurier;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

@SuppressWarnings({ "nls", "boxing" })

// Dies ist die Grundklasse, diese Klasse enth�lt nur Informationen und macht 
// nichts weiter. Diese Klasse enth�lt keinen Konstruktor, sie ist abstrakt.
public class Zutaten {
	
	// Es wird eine Map erstellt der Key ist ein String und der Wert ein Double
	// Die Map heisst zutaten
	private static Map<String, Double> zutaten;

	static {
		
		// TreeMap, damit die Zutaten nach ABC geordnet werden
		zutaten = new TreeMap<>();
		createZutat("Knoblauch", 0.50);
		createZutat("Kr�uterbutter", 0.50);
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
		createZutat("Meeresfr�chte", 2.00);
		createZutat("Speck", 2.00);
		createZutat("Rindshackfleisch", 2.00);
		createZutat("Mascarpone", 2.00);
		createZutat("Kalbfleisch", 3.00);
		createZutat("Rohschinken", 3.00);
		createZutat("Lachs", 3.00);
		createZutat("Kebabfleisch", 3.00);
		createZutat("Crevetten", 3.00);
	}

	// Gibt eine Liste mit allen Zutaten zur�ck (ohne Preis)
	// Daf�r werden die keys der zutaten verwendet
	public static ArrayList<String> getNames() {
		return new ArrayList<>(zutaten.keySet());
	}

	// Der getter f�r die Ausgabe des Preises f�r eine Zutat
	// Geht in den Zutaten schauen, �berpr�ft den Key (String), wenn der ent-
	// sprechende Key gefunden wurde, gibt es den entsprechenden Wert zur�ck.
	// Dies passiert mittels return zutaten.get(zutat);
	public static double getPreis(String zutat) {
		return zutaten.get(zutat);
	}

	// Diese Methode tr�gt eine Zutat in unsere Map ein. Somit kann man mit
	// createZutat("Name", Preis); einzf�gen. Ist beliebig erweiter oder
	// ver�nderbar. Falls sp�ter andere M�glichkeiten implementiert werden
	// sollten um Zutaten hinzuzuf�gen (zB �ber ein Textfile) ist das ganz
	// einfach und es muss nicht in jeder Zeile das put mit add ersetzt werden.
	private static void createZutat(String key, double price) {
		zutaten.put(key, price);
	}
}
