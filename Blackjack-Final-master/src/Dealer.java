/* Dealer.java
   Kenton Duprey
   Java Graphics II G
   Mr. Blondin
   12/14/2016
*/

import javax.swing.*;
import java.util.ArrayList;

public class Dealer
	{
		
		int cardValue;
		
		ArrayList<String> cards = new ArrayList<String>();
		ArrayList<ImageIcon> imageCards = new ArrayList<ImageIcon>();

		public void addDealerCard(String card) {cards.add(card);}

		public String getCards(int index) {return cards.get(index);}
		public ImageIcon getImageCards(int index){return imageCards.get(index);}
		


	}
