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
		private ArrayList<ImageIcon> p1Cards = new ArrayList<ImageIcon>();
		private ArrayList<ImageIcon> p2Cards = new ArrayList<ImageIcon>();
		private ArrayList<ImageIcon> p3Cards = new ArrayList<ImageIcon>();
		private ArrayList<ImageIcon> p4Cards = new ArrayList<ImageIcon>();
	
	public void addP1Card(ImageIcon card)
		{
			p1Cards.add(card);
		}
	public void addP2Card(ImageIcon card)
		{
			p2Cards.add(card);
		}
	public void addP3Card(ImageIcon card)
		{
			p3Cards.add(card);
		}
	public void addP4Card(ImageIcon card)
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
