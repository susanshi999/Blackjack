import java.util.*;
/**
 * Abstract class Member - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Member
{
    private static final int aceValue = 11;
    private static final int otherAceValue = 1;
    private int totalScore;
    protected ArrayList<Integer> hands;
    private int numberOfAce;
    public boolean go;

    public Member()
    {
        hands = new ArrayList<Integer>();
        go = true;
        numberOfAce = 0;
    } 

    public void takeACard(int c)
    {
        hands.add(c);
        if (Deck.cardToValue(c) == aceValue)
        {
            numberOfAce = numberOfAce + 1;
        }
    }

    public int getScore()
    {
        totalScore = 0;
        for (int i = 0; i < hands.size(); i++) 
        {
            if (Deck.cardToValue(hands.get(i)) != aceValue)
            {
                totalScore = totalScore + Deck.cardToValue(hands.get(i));
            }
        }

        for (int i = numberOfAce; i > 0; i -- )
        {
            if (totalScore + (i * aceValue) + (numberOfAce - i) * otherAceValue <= BlackJack.goalValue)
            {
                totalScore = totalScore + (i * aceValue) + (numberOfAce - i) * otherAceValue;
                break; 
            }
        }
        return totalScore;
    }

    public void showHands()
    {
        for(int i =0; i < hands.size(); i++)
        {
            System.out.print(Deck.cardToString(hands.get(i)) + " ");
        }
        System.out.println("" + "\n");
    }

    public void makeDecision(boolean d)
    {
        go = d;
    }
    
    public void makeDecision(int score)
    {
        if(score >= 21)
        go = false;
        else
        go = true;
    }

    abstract public boolean hit();
}
