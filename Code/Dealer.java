/**
 * Write a description of class Dealer here.
 * 
 * @author GivenName FamilyName
 * @version 1.0 yyyy-mm-dd
 */
public class Dealer extends Member
{
    private static final int STOP = 16;

    public Dealer()
    {
        super();
    }

    public void showHands()
    {
        System.out.println("Dealer's hands are: ");
        if (BlackJack.gameEnd())
        { 
            super.showHands();
            System.out.println("Dealer's score is: " + super.getScore() + "\n");
        }
        else
        {
            System.out.print("? ");
            for(int i = 1; i < hands.size(); i++)
            {
                System.out.print(Deck.cardToString(hands.get(i)) + " ");
            }
            System.out.println("" + "\n");
        }
    }

    public boolean hit()
    {
        if (super.getScore() >= STOP)
        {
            super.makeDecision(false);
            return false;
        }
        else
            return true;
    }
} // end of class Dealer