/* Player.java
   Kenton Duprey
   Java Graphics II G
   Mr. Blondin
   12/14/2016
*/

import javax.swing.*;
import java.util.ArrayList;

public class Player
	{
		private int numPlayers;
		ArrayList<ImageIcon> p1ImageCards = new ArrayList<ImageIcon>();
		ArrayList<ImageIcon> p2ImageCards = new ArrayList<ImageIcon>();
		ArrayList<ImageIcon> p3ImageCards = new ArrayList<ImageIcon>();
		ArrayList<ImageIcon> p4ImageCards = new ArrayList<ImageIcon>();
	
		ArrayList<String> p1Cards = new ArrayList<String>();
		ArrayList<String> p2Cards = new ArrayList<String>();
		ArrayList<String> p3Cards = new ArrayList<String>();
		ArrayList<String> p4Cards = new ArrayList<String>();
	int player1Val=0;
	int player2Val=0;
	int player3Val=0;
	int player4Val=0;
	int dealerVal=0;
		
		
	public void addP1ImageCard(ImageIcon card)
		{
			p1ImageCards.add(card);
		}
	public void addP2ImageCard(ImageIcon card)
		{
			p2ImageCards.add(card);
		}
	public void addP3ImageCard(ImageIcon card)
		{
			p3ImageCards.add(card);
		}
	public void addP4ImageCard(ImageIcon card)
		{
			p4ImageCards.add(card);
		}
	
	public void addP1Card(String card)
		{
			p1Cards.add(card);
		}
	public void addP2Card(String card)
		{
			p2Cards.add(card);
		}
	public void addP3Card(String card)
		{
			p3Cards.add(card);
		}
	public void addP4Card(String card)
		{
			p4Cards.add(card);
		}

		public ImageIcon getP1ImageCards(int index) {
			return p1ImageCards.get(index);
		}

		public ImageIcon getP2ImageCards(int index) {
			return p2ImageCards.get(index);
		}

		public ImageIcon getP3ImageCards(int index) {
			return p3ImageCards.get(index);
		}

		public ImageIcon getP4ImageCards(int index) {
			return p4ImageCards.get(index);
		}

		public String getP1Cards(int index) {
			return p1Cards.get(index);
		}

		public String getP2Cards(int index) {
			return p2Cards.get(index);
		}

		public String getP3Cards(int index) {
			return p3Cards.get(index);
		}

		public String getP4Cards(int index) {
			return p4Cards.get(index);
		}

		public void setNumPlayers(int numPlayers)
		{
		this.numPlayers = numPlayers;
		}
	
	public int getNumPlayers()
		{
		return numPlayers;
		}
	}
