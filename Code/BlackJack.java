import javax.swing.*;
/**
 * Write a description of class BlackJack here.
 * 
 * @author GivenName FamilyName
 * @version 1.0 yyyy-mm-dd
 */
public class BlackJack
{
    public static final int goalValue = 21;
    private static final int INITIAL_HANDS = 2;
    private static final int NUMBER_OF_PLAYERS = 2;
    public static Member[] players = new Member[NUMBER_OF_PLAYERS];
    private boolean play;
    private static boolean gameEnd = true;
    public Deck deck;
    private static JFrame frame = new JFrame("Rules");
    protected JFrame frame1 = new JFrame("Game");

    public BlackJack()
    {
        information();
        deck = new Deck();
        do
        {
            gameProcess();
            endOfRound();
            continuePlaying();
        } while (play);
        JOptionPane.showMessageDialog(frame1,
            "Thank you for playing", "information",
            JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    public static void information()
    {
        JOptionPane.showMessageDialog(frame,
            "Welcome to the game of Blackjack", "information",
            JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(frame,
            "Your goal is to get as close to 21 points as possible without going over", "information",
            JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(frame,
            "Ace can be counted as 11 points or 1 point", "information",
            JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(frame,
            "If both player and dealer went over 21 points, dealer wins", "information",
            JOptionPane.INFORMATION_MESSAGE);
    }

    private void gameProcess()
    {
        gameEnd = false;
        play = true;
        if(deck.getNumberOfCardsLeft() < 5)
        {
            deck = new Deck();
        }
        System.out.println("New Game: " + "\n");
        deck.displayCards();
        deck.shuffle();
        players[0] = new Player();
        players[1] = new Dealer();
        for (int i = 0; i< INITIAL_HANDS; i++)
        {
            players[0].takeACard(deck.dealCards());
            players[1].takeACard(deck.dealCards());
        }

        for (int i = 0; i< NUMBER_OF_PLAYERS; i++)
        {
            players[i].showHands();
            players[i].makeDecision(players[i].getScore());
            System.out.println();
        }
        
        while (!gameEnd){

            if (players[1].hit())
            {
                if (!players[0].go || !players[0].hit())
                {
                    players[1].takeACard(deck.dealCards());
                    players[1].showHands();  
                }
                else
                {
                    for (int i = 0; i< NUMBER_OF_PLAYERS; i++)
                    {
                        players[i].takeACard(deck.dealCards());
                        players[i].showHands();    
                    }  
                }
            }
            else
            {
                if (players[0].hit())   
                {
                    players[0].takeACard(deck.dealCards());
                    players[0].showHands();
                }
            }

            if(deck.getNumberOfCardsLeft() < 2)
                deck = new Deck();

            gameEnd = (!players[0].go && !players[1].go || players[0].getScore() > goalValue || players[1].getScore() > goalValue);
        }
    }

    private void endOfRound()
    {
        System.out.println("\n" + "Game Over" + "\n");
        for (int i = 0; i< NUMBER_OF_PLAYERS; i++)
        {
            players[i].showHands();
            System.out.println();
        }
        determineWinner();
        System.out.println ("The cards left are: " + "\n");
        deck.displayCards();
        System.out.println();
    }

    private void determineWinner()
    {
        if (players[1].getScore() > goalValue && players[0].getScore() > goalValue)
        {
            System.out.println("Dealer wins");
        }
        else if (players[1].getScore() > goalValue)
        {
            System.out.println("Player wins");
        }
        else if (players[0].getScore() > goalValue)
        {
            System.out.println("Dealer wins");
        }
        else
        {
            if(players[1].getScore() > players[0].getScore())
            {
                System.out.println("Dealer wins");
            }
            else if(players[1].getScore() == players[0].getScore())
            {
                System.out.println("Tie");
            }
            else 
            {
                System.out.println("Player wins");
            }
        }
        System.out.println();
    }

    private boolean continuePlaying()
    {
        int decision = JOptionPane.showConfirmDialog(frame1,
                "Click Yes to continue to next round", "information",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if(decision == 0)
        {
            return true;
        }
        else
        {
            play = false;
            return false;
        }
    }

    public static boolean gameEnd()
    {
        return gameEnd;
    }
}
