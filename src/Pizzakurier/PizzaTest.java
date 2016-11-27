package Pizzakurier;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

@SuppressWarnings("nls")
public class PizzaTest {
	
	@Test
	public void test() {
		Pizza pizza = new Pizza();
		pizza.addZutat("Knoblauch");
		pizza.addZutat("Gorgonzola");
		pizza.addZutat("Salami");
		
		assertEquals("Knoblauch,Gorgonzola,Salami", String.join(",", pizza.getZutaten()));
		assertEquals(15.5, pizza.getPreis(), 0);
	}

}
