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
		private ArrayList<ImageIcon> p1ImageCards = new ArrayList<ImageIcon>();
		private ArrayList<ImageIcon> p2ImageCards = new ArrayList<ImageIcon>();
		private ArrayList<ImageIcon> p3ImageCards = new ArrayList<ImageIcon>();
		private ArrayList<ImageIcon> p4ImageCards = new ArrayList<ImageIcon>();
	
		private ArrayList<String> p1Cards = new ArrayList<String>();
		private ArrayList<String> p2Cards = new ArrayList<String>();
		private ArrayList<String> p3Cards = new ArrayList<String>();
		private ArrayList<String> p4Cards = new ArrayList<String>();
		
		
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
	
	public void setNumPlayers(int numPlayers)
		{
		this.numPlayers = numPlayers;
		}
	
	public int getNumPlayers()
		{
		return numPlayers;
		}
	}
