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
import javax.swing.Timer;

public class Blackjack extends JFrame implements ActionListener {
	JPanel mainPnl = new JPanel();
	JPanel centerPnl = new JPanel();
	JPanel southPnl = new JPanel();
	JPanel eastPnl = new JPanel();
	JPanel westPnl = new JPanel();


	GridLayout playerInfoLayout = new GridLayout(2, 1, 1, 1);
	GridLayout eastLayout = new GridLayout(1, 2, 1, 1);
	GridLayout southLayout = new GridLayout(1, 5, 1, 1);
	BorderLayout border = new BorderLayout();


	JButton hit = new JButton("Hit");
	JButton stand = new JButton("Stand");


	boolean[] playersWon = new boolean[4];
	boolean[] playersBust = new boolean[4];

	int aces = 0;
	int count = 0;
	int subtract = 0;
	int cardVal;
	String numPlayers;
	int playerNum = 1;
	int dealerVal;
	int player1Val;
	int player2Val;
	int player3Val;
	int player4Val;
	JLabel playerTurn = new JLabel("Player " + playerNum + "'s Cards");
	JLabel dealer = new JLabel("Dealer");
	JLabel pCardValue = new JLabel("Total Value: " + cardVal);

	Font dealerFont = new Font(Font.SANS_SERIF, Font.PLAIN, 28);

	ArrayList<JButton> dealerCards = new ArrayList<JButton>();
	ArrayList<JButton> playerCards = new ArrayList<JButton>();

	ImageIcon cardBack = new ImageIcon("b.gif");

	int delay = 5000;

	ActionListener timerAction = new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			dispose();
			BlackJackEnd gui = new BlackJackEnd(players);

		}
	};
	Player players = new Player();
	Deck deck1 = new Deck();
	Dealer dealer1 = new Dealer();

	public Blackjack(String numPlayers) {
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

		playerTurn.setFont(dealerFont);
		pCardValue.setFont(dealerFont);

		hit.addActionListener(this);
		stand.addActionListener(this);


		eastPnl.add(hit);
		eastPnl.add(stand);


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

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();


		if (source == stand) {
			// goes to next player
			count = 0;
			for (int i = 1; i < 5; i++) ;
			{
				playerNum++;
			}
			playerTurn.setText("Player " + playerNum + "'s Cards");
			if (playerNum == 5) {
				playerTurn.setText("Dealer's Turn");
			}
			for (int i = 0; i < playerCards.size(); i++) {
				southPnl.remove(playerCards.get(i));
				revalidate();
			}
			addCardButtons(playerCards, southPnl);
			if (playerNum == 2) {
				playerCards.get(0).setIcon(players.getP2ImageCards(0));
				playerCards.get(1).setIcon(players.getP2ImageCards(1));
				cardVal = deck1.getCardValue(players.getP2Cards(0)) + deck1.getCardValue(players.getP2Cards(1));
				if (cardVal == 21) {
					pCardValue.setText("BlackJack!");
					hit.setEnabled(false);
				} else if (cardVal > 21) {
					pCardValue.setText("You Busted: " + cardVal);
					hit.setEnabled(false);
				} else {
					pCardValue.setText("Total Value: " + cardVal);
					checkWin(cardVal, 2);
					hit.setEnabled(true);
				}
				// add end jframe
			} else if (playerNum == 3) {
				if (numPlayers.equals("2")) {
					hit.setEnabled(false);
					stand.setEnabled(false);
					playerTurn.setText("Dealer's turn");
					dealerCards.get(1).setIcon(dealer1.imageCards.get(1));
					cardVal = 0;

					cardVal += deck1.getCardValue(dealer1.getCards(0)) + deck1.getCardValue(dealer1.getCards(1));
					pCardValue.setText("Dealer's value: " + cardVal);
					if (cardVal < 17) {
						for (int i = 2; i < 10; i++) {
							dealer1.cards.add(deck1.shuffledDeck.remove(0));
							//cardVal += deck1.getCardValue(dealer1.getCards(i));
							if(deck1.getCardValue(dealer1.getCards(0)) == 11 || deck1.getCardValue(dealer1.getCards(1)) == 11 || deck1.getCardValue(dealer1.getCards(2)) == 11)
							{
								if(deck1.getCardValue(dealer1.getCards(i)) == 11)
								{
									cardVal += 1;
								}
								else if(cardVal + deck1.getCardValue(dealer1.getCards(i)) > 21 && count == 0)
								{
									cardVal -= 10;
									cardVal += deck1.getCardValue(dealer1.getCards(i));
									count++;
								}
								else
								{
									cardVal += deck1.getCardValue(dealer1.getCards(i));
								}
							}
							else if(deck1.getCardValue(dealer1.getCards(i)) == 11)
							{
								if(cardVal + 11 > 21)
								{
									cardVal += 1;
								}
								else
								{
									cardVal += 11;
								}
							}
							else
							{
								cardVal += deck1.getCardValue(dealer1.getCards(i));
							}
							//cardVal += deck1.getCardValue(dealer1.getCards(i));
							pCardValue.setText("Dealer's value: " + cardVal);
							if (cardVal > 17) {
								dealerVal = cardVal;
								break;
							}
						}
					}
					if(cardVal == 21)
					{
						pCardValue.setText("Dealer Gets BlackJack, You Lose");
					}
					if(cardVal > 21)
					{
						pCardValue.setText("Dealer Busts: " + cardVal);
					}

					Timer timer = new Timer(delay, timerAction);
					timer.setRepeats(false);
					timer.start();

				} else {
					playerCards.get(0).setIcon(players.getP3ImageCards(0));
					playerCards.get(1).setIcon(players.getP3ImageCards(1));
					cardVal = deck1.getCardValue(players.getP3Cards(0)) + deck1.getCardValue(players.getP3Cards(1));
					if (cardVal == 21) {
						pCardValue.setText("BlackJack!");
						hit.setEnabled(false);
					} else if (cardVal > 21) {
						pCardValue.setText("You Busted: " + cardVal);
						hit.setEnabled(false);
					} else {
						pCardValue.setText("Total Value: " + cardVal);
						checkWin(cardVal, 3);
						hit.setEnabled(true);
					}
				}

			} else if (playerNum == 4) {
				hit.setEnabled(true);
				if (numPlayers.equals("3")) {
					hit.setEnabled(false);
					stand.setEnabled(false);
					playerTurn.setText("Dealer's turn");
					dealerCards.get(1).setIcon(dealer1.imageCards.get(1));
					cardVal = 0;
					cardVal += deck1.getCardValue(dealer1.getCards(0)) + deck1.getCardValue(dealer1.getCards(1));
					pCardValue.setText("Dealer's value: " + cardVal);
					if (cardVal < 17) {
						for (int i = 2; i < 10; i++) {
							dealer1.cards.add(deck1.shuffledDeck.remove(0));
							//cardVal += deck1.getCardValue(dealer1.getCards(i));
							if(deck1.getCardValue(dealer1.getCards(0)) == 11 || deck1.getCardValue(dealer1.getCards(1)) == 11 || deck1.getCardValue(dealer1.getCards(2)) == 11)
							{
								if(deck1.getCardValue(dealer1.getCards(i)) == 11)
								{
									cardVal += 1;
								}
								else if(cardVal + deck1.getCardValue(dealer1.getCards(i)) > 21 && count == 0)
								{
									cardVal -= 10;
									cardVal += deck1.getCardValue(dealer1.getCards(i));
									count++;
								}
								else
								{
									cardVal += deck1.getCardValue(dealer1.getCards(i));
								}
							}
							else if(deck1.getCardValue(dealer1.getCards(i)) == 11)
							{
								if(cardVal + 11 > 21)
								{
									cardVal += 1;
								}
								else
								{
									cardVal += 11;
								}
							}
							else
							{
								cardVal += deck1.getCardValue(dealer1.getCards(i));
							}
							//cardVal += deck1.getCardValue(dealer1.getCards(i));
							pCardValue.setText("Dealer's value: " + cardVal);
							if (cardVal > 17) {
								dealerVal = cardVal;
								break;
							}
						}
					}
					if(cardVal == 21)
					{
						pCardValue.setText("Dealer Gets BlackJack, You Lose");
					}
					if(cardVal > 21)
					{
						pCardValue.setText("Dealer Busts: " + cardVal);
					}

					Timer timer = new Timer(delay, timerAction);
					timer.setRepeats(false);
					timer.start();

				} else {
					playerCards.get(0).setIcon(players.getP4ImageCards(0));
					playerCards.get(1).setIcon(players.getP4ImageCards(1));
					cardVal = deck1.getCardValue(players.getP4Cards(0)) + deck1.getCardValue(players.getP4Cards(1));
					if (cardVal == 21) {
						pCardValue.setText("BlackJack!");
						hit.setEnabled(false);
					} else if (cardVal > 21) {
						pCardValue.setText("You Busted: " + cardVal);
						hit.setEnabled(false);
					} else {
						pCardValue.setText("Total Value: " + cardVal);
						checkWin(cardVal, 4);
					}
				}
			} else if (playerNum == 5) {
				//player4Val = cardVal;
				hit.setEnabled(false);
				stand.setEnabled(false);
				playerTurn.setText("Dealer's turn");
				dealerCards.get(1).setIcon(dealer1.imageCards.get(1));
				cardVal = 0;
				cardVal += deck1.getCardValue(dealer1.getCards(0)) + deck1.getCardValue(dealer1.getCards(1));
				pCardValue.setText("Dealer's value: " + cardVal);
				if (cardVal < 17) {
					for (int i = 2; i < 10; i++) {
						dealer1.cards.add(deck1.shuffledDeck.remove(0));
						//cardVal += deck1.getCardValue(dealer1.getCards(i));
						if(deck1.getCardValue(dealer1.getCards(0)) == 11 || deck1.getCardValue(dealer1.getCards(1)) == 11 || deck1.getCardValue(dealer1.getCards(2)) == 11)
						{
							if(deck1.getCardValue(dealer1.getCards(i)) == 11)
							{
								cardVal += 1;
							}
							else if(cardVal + deck1.getCardValue(dealer1.getCards(i)) > 21 && count == 0)
							{
								cardVal -= 10;
								cardVal += deck1.getCardValue(dealer1.getCards(i));
								count++;
							}
							else
							{
								cardVal += deck1.getCardValue(dealer1.getCards(i));
							}
						}
						else if(deck1.getCardValue(dealer1.getCards(i)) == 11)
						{
							if(cardVal + 11 > 21)
							{
								cardVal += 1;
							}
							else
							{
								cardVal += 11;
							}
						}
						else
						{
							cardVal += deck1.getCardValue(dealer1.getCards(i));
						}
						//cardVal += deck1.getCardValue(dealer1.getCards(i));
						pCardValue.setText("Dealer's value: " + cardVal);
						if (cardVal > 17) {
							dealerVal = cardVal;
							break;
						}
					}
				}
				if(cardVal == 21)
				{
					pCardValue.setText("Dealer Gets BlackJack, You Lose");
				}
				if(cardVal > 21)
				{
					pCardValue.setText("Dealer Busts: " + cardVal);
				}

				Timer timer = new Timer(delay, timerAction);
				timer.setRepeats(false);
				timer.start();


			}
		}
		if (source == hit) {
			if (playerNum == 1) {
				players.addP1Card(deck1.shuffledDeck.remove(0));

				players.addP1ImageCard(deck1.imageDeck.remove(0));
				playerCards.add(new JButton(players.getP1ImageCards(players.p1Cards.size() - 1)));
				southPnl.add(playerCards.get(playerCards.size() - 1));
				revalidate();
				if(deck1.getCardValue(players.getP1Cards(0)) == 11 || deck1.getCardValue(players.getP1Cards(1)) == 11 || deck1.getCardValue(players.getP1Cards(2)) == 11)
				{
					if(deck1.getCardValue(players.getP1Cards(players.p1Cards.size() - 1)) == 11)
					{
						cardVal += 1;
					}
					else if(cardVal + deck1.getCardValue(players.getP1Cards(players.p1Cards.size() - 1)) > 21 && count == 0)
					{
						cardVal -= 10;
						cardVal += deck1.getCardValue(players.getP1Cards(players.p1Cards.size()-1));
						count++;
					}
					else
					{
						cardVal += deck1.getCardValue(players.getP1Cards(players.p1Cards.size() -1));
					}
				}
				else if(deck1.getCardValue(players.getP1Cards(players.p1Cards.size() - 1)) == 11)
				{
					if(cardVal + 11 > 21)
					{
						cardVal += 1;
					}
					else
					{
						cardVal += 11;
					}
				}
				else if(deck1.getCardValue(players.getP1Cards(players.p2Cards.size())) - 1 != 11 && deck1.getCardValue(players.getP1Cards(0)) != 11 && deck1.getCardValue(players.getP1Cards(1)) != 11)
				{
					cardVal += deck1.getCardValue(players.getP1Cards(players.p1Cards.size() - 1));
				}

				//cardVal+= deck1.getCardValue(players.getP1Cards(players.p1Cards.size() - 1));

				pCardValue.setText("Total Value: " + cardVal);
				if (checkWin(cardVal, playerNum)) {
					pCardValue.setText("BlackJack!");
					hit.setEnabled(false);
				}
				if (checkBust(cardVal, playerNum)) {
					pCardValue.setText("You Busted: " + cardVal);
					hit.setEnabled(false);
				}
			} else if (playerNum == 2) {
				players.addP2Card(deck1.shuffledDeck.remove(0));
				players.addP2ImageCard(deck1.imageDeck.remove(0));
				playerCards.add(new JButton(players.getP2ImageCards(players.p2Cards.size() - 1)));
				//cardVal += deck1.getCardValue(players.getP2Cards(players.p1Cards.size() - 1));
				southPnl.add(playerCards.get(playerCards.size() - 1));
				revalidate();
				if(deck1.getCardValue(players.getP2Cards(0)) == 11 || deck1.getCardValue(players.getP2Cards(1)) == 11 || deck1.getCardValue(players.getP2Cards(2)) == 11)
				{
					if(deck1.getCardValue(players.getP2Cards(players.p2Cards.size() - 1)) == 11)
					{
						cardVal += 1;
					}
					else if(cardVal + deck1.getCardValue(players.getP2Cards(players.p2Cards.size() - 1)) > 21 && count == 0)
					{
						cardVal -= 10;
						cardVal += deck1.getCardValue(players.getP2Cards(players.p2Cards.size()-1));
						count++;
					}
					else
					{
						cardVal += deck1.getCardValue(players.getP2Cards(players.p2Cards.size() -1));
					}
				}
				else if(deck1.getCardValue(players.getP2Cards(players.p2Cards.size() - 1)) == 11)
				{
					if(cardVal + 11 > 21)
					{
						cardVal += 1;
					}
					else
					{
						cardVal += 11;
					}
				}


				else
				{
					cardVal += deck1.getCardValue(players.getP2Cards(players.p2Cards.size() - 1));
				}

				pCardValue.setText("Total Value: " + cardVal);
				if (checkWin(cardVal, playerNum)) {
					pCardValue.setText("BlackJack!");
					hit.setEnabled(false);
				}
				if (checkBust(cardVal, playerNum)) {
					pCardValue.setText("You Busted: " + cardVal);
					hit.setEnabled(false);
				}
			} else if (playerNum == 3) {
				players.addP3Card(deck1.shuffledDeck.remove(0));
				players.addP3ImageCard(deck1.imageDeck.remove(0));
				playerCards.add(new JButton(players.getP3ImageCards(players.p3Cards.size() - 1)));
				//cardVal += deck1.getCardValue(players.getP3Cards(players.p1Cards.size() - 1));
				southPnl.add(playerCards.get(playerCards.size() - 1));
				revalidate();
				if(deck1.getCardValue(players.getP3Cards(0)) == 11 || deck1.getCardValue(players.getP3Cards(1)) == 11 || deck1.getCardValue(players.getP3Cards(2)) == 11)
				{
					if(deck1.getCardValue(players.getP3Cards(players.p3Cards.size() - 1)) == 11)
					{
						cardVal += 1;
					}
					else if(cardVal + deck1.getCardValue(players.getP3Cards(players.p3Cards.size() - 1)) > 21 && count == 0)
					{
						cardVal -= 10;
						cardVal += deck1.getCardValue(players.getP3Cards(players.p3Cards.size()-1));
						count++;
					}
					else
					{
						cardVal += deck1.getCardValue(players.getP3Cards(players.p3Cards.size() -1));
					}
				}
				else if(deck1.getCardValue(players.getP3Cards(players.p3Cards.size() - 1)) == 11)
				{
					if(cardVal + 11 > 21)
					{
						cardVal += 1;
					}
					else
					{
						cardVal += 11;
					}
				}


				else
				{
					cardVal += deck1.getCardValue(players.getP3Cards(players.p3Cards.size() - 1));
				}
				//cardVal+= deck1.getCardValue(players.getP3Cards(players.p3Cards.size() - 1));

				pCardValue.setText("Total Value: " + cardVal);
				if (checkWin(cardVal, playerNum)) {
					pCardValue.setText("BlackJack!");
					hit.setEnabled(false);
				}
				if (checkBust(cardVal, playerNum)) {
					pCardValue.setText("You Busted: " + cardVal);
					hit.setEnabled(false);
				}
			} else {
				players.addP4Card(deck1.shuffledDeck.remove(0));
				players.addP4ImageCard(deck1.imageDeck.remove(0));
				playerCards.add(new JButton(players.getP4ImageCards(players.p4Cards.size() - 1)));
				//cardVal += deck1.getCardValue(players.getP4Cards(players.p1Cards.size() - 1));
				southPnl.add(playerCards.get(playerCards.size() - 1));
				revalidate();
				if(deck1.getCardValue(players.getP4Cards(0)) == 11 || deck1.getCardValue(players.getP4Cards(1)) == 11 || deck1.getCardValue(players.getP4Cards(2)) == 11)
				{
					if(deck1.getCardValue(players.getP4Cards(players.p4Cards.size() - 1)) == 11)
					{
						cardVal += 1;
					}
					else if(cardVal + deck1.getCardValue(players.getP4Cards(players.p4Cards.size() - 1)) > 21 && count == 0)
					{
						cardVal -= 10;
						cardVal += deck1.getCardValue(players.getP4Cards(players.p4Cards.size()-1));
						count++;
					}
					else
					{
						cardVal += deck1.getCardValue(players.getP4Cards(players.p4Cards.size() -1));
					}
				}
				else if(deck1.getCardValue(players.getP4Cards(players.p4Cards.size() - 1)) == 11)
				{
					if(cardVal + 11 > 21)
					{
						cardVal += 1;
					}
					else
					{
						cardVal += 11;
					}
				}


				else
				{
					cardVal += deck1.getCardValue(players.getP4Cards(players.p4Cards.size() - 1));
				}

				//cardVal+= deck1.getCardValue(players.getP4Cards(players.p4Cards.size() - 1));

				pCardValue.setText("Total Value: " + cardVal);
				if (checkWin(cardVal, playerNum)) {
					pCardValue.setText("BlackJack!");
					hit.setEnabled(false);
				}
				if (checkBust(cardVal, playerNum)) {
					pCardValue.setText("You Busted: " + cardVal);
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

		//Object[] options = {"Yes!", "No"};
		//JOptionPane.showOptionDialog(null, playerWon + " Won!!\nWant to play again?", playerWon + " Won!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
	}

	public boolean checkWin(int cardValue, int playerNum) {
		if (cardValue == 21) {
			playersWon[playerNum - 1] = true;
			return true;
		} else
			return false;
	}

	public boolean checkBust(int cardValue, int playerNum) {
		if (cardValue > 21) {
			playersBust[playerNum - 1] = true;
			return true;
		} else
			return false;
	}

	public void addCardButtons(ArrayList<JButton> arr, JPanel pnl) {
		pnl.setLayout(southLayout);
		for (int i = 0; i < 2; i++) {
			arr.add(new JButton(cardBack));
			arr.get(i).addActionListener(this);
			pnl.add(arr.get(i));
		}

	}

	public void setStart() {
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
		dealer1.cards.add(deck1.shuffledDeck.remove(0));
		dealer1.imageCards.add(deck1.imageDeck.remove(0));

		dealer1.cards.add(deck1.shuffledDeck.remove(0));
		dealer1.imageCards.add(deck1.imageDeck.remove(0));

		dealerCards.get(0).setIcon(dealer1.imageCards.get(0));
		if (deck1.getCardValue(dealer1.getCards(0)) == 10 || deck1.getCardValue(dealer1.getCards(0)) == 11) {
			cardVal = deck1.getCardValue(dealer1.getCards(0)) + deck1.getCardValue(dealer1.getCards(1));
			if (cardVal == 21) {
				hit.setEnabled(false);
				stand.setEnabled(false);
				dealerCards.get(1).setIcon(dealer1.imageCards.get(1));
				Timer timer = new Timer(delay, timerAction);
				timer.setRepeats(false);
				timer.start();
			}
		}

		// each player is given two cards face up

		dealPlayerCards(deck1, players);

		// goes to player 1's turn
		playerCards.get(0).setIcon(players.getP1ImageCards(0));
		playerCards.get(1).setIcon(players.getP1ImageCards(1));
		cardVal = 0;
		for (int i = 0; i < 2; i++) {
			if (deck1.getCardValue(players.getP1Cards(i)) == 11) {
				if (cardVal + 11 <= 21)
					cardVal += 11;
				else
					cardVal += 1;
			} else
				cardVal += deck1.getCardValue(players.getP1Cards(i));
		}

		pCardValue.setText("Total Value: " + cardVal);
		if (checkWin(cardVal, playerNum) || checkBust(cardVal, playerNum)) {
			hit.setEnabled(false);
		}
	}

	public void dealPlayerCards(Deck deck1, Player players) {
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
}
