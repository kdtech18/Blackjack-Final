/* Blackjack.java
   Kenton Duprey
   Java Graphics II G
   Mr. Blondin
   12/14/2016
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Blackjack extends JFrame implements ActionListener
	{
		JPanel mainPnl = new JPanel();
		JPanel centerPnl = new JPanel();
		JPanel southPnl = new JPanel();
		JPanel eastPnl = new JPanel();
		JPanel westPnl = new JPanel();
		
		
		GridLayout playerInfoLayout = new GridLayout(2, 1, 1, 1);
		GridLayout eastLayout = new GridLayout(1, 3, 1, 1);
		GridLayout southLayout = new GridLayout(1, 5, 1, 1);
		BorderLayout border = new BorderLayout();
		
		
		
		JButton hit = new JButton("Hit");
		JButton stand = new JButton("Stand");
		JButton start = new JButton("Start");

		boolean[] playersWon = new boolean[4];
		boolean[] playersBust = new boolean[4];

		int cardVal;
		String numPlayers;
		int playerNum = 1;
		JLabel playerTurn = new JLabel("Player " + playerNum + "'s Cards");
		JLabel dealer = new JLabel("Dealer");
		JLabel pCardValue = new JLabel("Total Value: " + cardVal);
		
		Font dealerFont = new Font(Font.SANS_SERIF, Font.PLAIN, 28);

		ArrayList<JButton> dealerCards = new ArrayList<JButton>();
		ArrayList<JButton> playerCards = new ArrayList<JButton>();

		ImageIcon cardBack = new ImageIcon("b.gif");

		Player players = new Player();
		Deck deck1 = new Deck();

	public Blackjack(String numPlayers)
		{
			super("BlackJack");
			add(mainPnl);
			setVisible(true);
			setSize(780, 349);
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			setLocationRelativeTo(null);

			this.numPlayers = numPlayers;
			
			eastPnl.setLayout(eastLayout);
			
			hit.setFont(dealerFont);
			stand.setFont(dealerFont);
			start.setFont(dealerFont);
			playerTurn.setFont(dealerFont);
			pCardValue.setFont(dealerFont);

			hit.addActionListener(this);
			stand.addActionListener(this);
			start.addActionListener(this);

			eastPnl.add(hit);
			eastPnl.add(stand);
			eastPnl.add(start);

			westPnl.setLayout(playerInfoLayout);
			westPnl.add(playerTurn);
			westPnl.add(pCardValue);

			addCardButtons(playerCards, southPnl);
			addCardButtons(dealerCards, centerPnl);

			centerPnl.add(dealer);
			dealer.setFont(dealerFont);
			
			mainPnl.add(centerPnl, BorderLayout.CENTER);
			mainPnl.add(eastPnl, BorderLayout.EAST);
			mainPnl.add(southPnl, BorderLayout.SOUTH);
			mainPnl.add(westPnl, BorderLayout.WEST);

			setStart();

			validate();
		}
		
	public void actionPerformed(ActionEvent e)
		{
			Object source = e.getSource();
			

			
			if(source == stand)
			{
				// goes to next player

			}
			if(source == hit)
				{
					if (playerNum == 1){
						players.addP1Card(deck1.shuffledDeck.remove(0));
						players.addP1ImageCard(deck1.imageDeck.remove(0));
						playerCards.add(new JButton(players.getP1ImageCards(players.p1Cards.size() - 1)));
						southPnl.add(playerCards.get(playerCards.size() - 1));
						revalidate();
						cardVal+= deck1.getCardValue(players.getP1Cards(players.p1Cards.size() - 1));
						pCardValue.setText("Total Value: " + cardVal);
						if (checkWin(cardVal, playerNum) || checkBust(cardVal, playerNum))
							{
								hit.setEnabled(false);
							}
					}
					// give them another card

					// then add that value to the existing player card value
					// check if win or bust
					// if bust move to next player
					// if win go to next play
					// while bust or win is not true
					
				}
			if (source == start)
				{

					
					
					
				}
			//Object[] options = {"Yes!", "No"};
			//JOptionPane.showOptionDialog(null, playerWon + " Won!!\nWant to play again?", playerWon + " Won!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
		}
	public boolean checkWin(int cardValue, int playerNum)
		{
			if(cardValue == 21 && !checkBust(cardValue, playerNum)) {
				playersWon[playerNum] = true;
				return true;
			}
			else
				return false;
		}
	public boolean checkBust(int cardValue, int playerNum)
		{
			if (cardValue > 21) {
				playersBust[playerNum] = true;
				return true;
			}
			else
				return false;
		}
		
	public void addCardButtons(ArrayList<JButton> arr, JPanel pnl)
	{
		pnl.setLayout(southLayout);
		for (int i = 0; i < 2; i++) {
			arr.add(new JButton(cardBack));
			arr.get(i).addActionListener(this);
			pnl.add(arr.get(i));
		}

	}

	public void setStart()
		{
			// reset winning player's boolean array
			for (int i = 0; i < playersWon.length; i++) {
				playersWon[i] = false;
			}
			// reset bust player's boolean array
			for (int i = 0; i < playersBust.length; i++) {
				playersBust[i] = false;
			}
			// make deck and shuffle deck

			deck1.setDeck();
			deck1.setShuffledDeck();
			deck1.setImageDeck();

			// dealer gets one card face up
			Dealer dealer1 = new Dealer();
			dealer1.cards.add(deck1.shuffledDeck.remove(0));
			dealer1.imageCards.add(deck1.imageDeck.remove(0));

			dealer1.cards.add(deck1.shuffledDeck.remove(0));
			dealer1.imageCards.add(deck1.imageDeck.remove(0));

			dealerCards.get(0).setIcon(dealer1.imageCards.get(0));

			// each player is given two cards face up

			dealPlayerCards(deck1, players);

			// goes to player 1's turn
			playerCards.get(0).setIcon(players.getP1ImageCards(0));
			playerCards.get(1).setIcon(players.getP1ImageCards(1));
			cardVal = deck1.getCardValue(players.getP1Cards(0)) + deck1.getCardValue(players.getP1Cards(1));
			pCardValue.setText("Total Value: " + cardVal);
			checkWin(cardVal, 1);
		}

	public void dealPlayerCards(Deck deck1, Player players)
		{
			if (numPlayers.equals("2")) {
				for (int i = 0; i < 2; i++) {
					players.addP1Card(deck1.shuffledDeck.remove(0));
					players.addP1ImageCard(deck1.imageDeck.remove(0));

					players.addP2Card(deck1.shuffledDeck.remove(0));
					players.addP2ImageCard(deck1.imageDeck.remove(0));
				}
			} else if (numPlayers.equals("3")) {
				for (int i = 0; i < 3; i++) {
					players.addP1Card(deck1.shuffledDeck.remove(0));
					players.addP1ImageCard(deck1.imageDeck.remove(0));

					players.addP2Card(deck1.shuffledDeck.remove(0));
					players.addP2ImageCard(deck1.imageDeck.remove(0));

					players.addP3Card(deck1.shuffledDeck.remove(0));
					players.addP3ImageCard(deck1.imageDeck.remove(0));
				}
			} else {
				for (int i = 0; i < 4; i++) {
					players.addP1Card(deck1.shuffledDeck.remove(0));
					players.addP1ImageCard(deck1.imageDeck.remove(0));

					players.addP2Card(deck1.shuffledDeck.remove(0));
					players.addP2ImageCard(deck1.imageDeck.remove(0));

					players.addP3Card(deck1.shuffledDeck.remove(0));
					players.addP3ImageCard(deck1.imageDeck.remove(0));

					players.addP4Card(deck1.shuffledDeck.remove(0));
					players.addP4ImageCard(deck1.imageDeck.remove(0));
				}
			}
		}
	public void BenAceMethod()
 		{
			/*
				if (card1 == ace && card2 == faceCard)
	 				Blackjack();
	 		if (card1 == faceCard && card2 == ace)
	 			Blackjack();
			if (card1 = ace && isWin == false)
	 			int sumCard1 = card2 + 1;
	 			int sumCard2 = card2 + 11;
	 			if (sumCard2 >= 21)
	 				trueValue == sumCard2;
	 			else
	 				trueValue = sumCard1;
	 			if (sumCard1 > 21)
	 				Bust();
	 		if(card2 == ace && isWin == false)
	 
	 		*/
		  	}

		
	}
