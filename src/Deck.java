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
			for (String str: deck)
				System.out.println(str);
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
		for (String str: shuffledDeck)
			System.out.println(str);
		}
	public void setImageDeck()
		{
		for (int i = 0; i < shuffledDeck.size(); i++)
			{
				imageDeck.add(new ImageIcon(shuffledDeck.get(i)));
			}
		}
	public static void main(String[] args)
		{
			Deck deck1 = new Deck();
			deck1.setDeck();
			deck1.setShuffledDeck();
			System.out.println(deck1.shuffledDeck.size());
		}// end main method
	}
