/* Deck.java
   Kenton Duprey
   Java Graphics II G
   Mr. Blondin
   12/14/2016
*/

import javax.swing.*;
import java.util.ArrayList;

public class Deck
	{
	
	private ArrayList<String> deck = new ArrayList<String>();
	private ArrayList<String> shuffledDeck = new ArrayList<String>();
	
	private ArrayList<String> value = new ArrayList<String>();
	private ArrayList<String> suit = new ArrayList<String>();
	
	private ArrayList<Integer> cardValues = new ArrayList<Integer>();
	
	private ArrayList<ImageIcon> imageDeck = new ArrayList<ImageIcon>();
	
	private ArrayList<ImageIcon> removedCards = new ArrayList<ImageIcon>();
	
	public void setDeck()
		{
			value.add("a");
			value.add("j");
			value.add("k");
			value.add("q");
			value.add("t");
		for (int i = 2; i <= 9; i++)
			{
				value.add(i + "");
			}
		
			suit.add("c");
			suit.add("d");
			suit.add("h");
			suit.add("s");
			
		for (int a = 0; a < suit.size(); a++)
			{
			for (int b = 0; b < value.size(); b++)
				{
					deck.add(value.get(b) + suit.get(a));
				}
			
			}
			
		}
	public void setShuffledDeck()
		{
		for (int i = 0; i < deck.size(); i++)
			{
			int index = (int) (Math.random() * deck.size());
			shuffledDeck.add(deck.remove(index));
			i--;
			}
		}
		
	public void setImageDeck()
		{
		for (int i = 0; i < shuffledDeck.size(); i++)
			{
				imageDeck.add(new ImageIcon(shuffledDeck.get(i)));
			}
		}
	public void setCardValues()
		{
			for (int i = 0; i < deck.size(); i++) {
				for (int j = 2; j < 9; j++) {
					if (deck.get(i).substring(0,1).equals(j + "")) {
						cardValues.add(j);
					}
				}
			}
		
		}

		public static void main(String[] args) {

			Deck deck1 = new Deck();
			deck1.setDeck();
			deck1.setCardValues();
			System.out.print(deck1.deck);

				System.out.println(deck1.cardValues);
		}// end main method
	}
