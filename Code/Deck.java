import java.util.*;
/**
 * Write a description of class Deck here.
 * 
 * @author GivenName FamilyName
 * @version 1.0 yyyy-mm-dd
 */
public class Deck
{
    private static final int TOTAL_CARDS = 52;
    private static ArrayList<Integer> cards = new ArrayList<Integer>(TOTAL_CARDS);
    private int totalCards;
    public Deck()
    {
        setCards();    
        totalCards = TOTAL_CARDS;
    }

    private static void setCards()
    {
        for(int i =0; i < TOTAL_CARDS; i++)
        {
            cards.add(i);
        }
    }

    public int getNumberOfCardsLeft()
    {
        return totalCards;
    }

    public void shuffle()
    {
        Collections.shuffle(cards);
        System.out.println("\n" +"Shuffled deck: " + "\n");
        displayCards();
    }

    public void displayCards()
    {
        for(int i =0; i < totalCards; i++)
        {
            System.out.print(cardToString(cards.get(i)) + " ");
        }
        System.out.println("\n");
    }

    public int dealCards()
    {
        totalCards = totalCards - 1;
        int card = cards.get(totalCards);
        cards.remove(totalCards);
        return card;
    }

    //Method to get String value of individual card
    public static String cardToString(int numInList){
        int cardType = numInList%13;
        char cardNum;
        String cardIs = "";
        //If card is A, K, J, or Q, sets it as such, otherwise card is equal to number%13
        if (cardType == 0){
            cardNum = 'K';
        }
        else if (cardType==1){
            cardNum='A';
        }
        else if (cardType==11){
            cardNum = 'J';
        }
        else if (cardType==12){
            cardNum='Q';
        }
        else {
            cardNum = (char)(cardType+'0');
        }
        //ASCII value of suit is equal to concatenated value of number/13+3 becuase (char)3 is heart icon, (char)4 is dimond //icon and so on
        char cardSuit = (char)(numInList/13 +3);
        if (cardType!=10){
            cardIs=""+cardNum+cardSuit;
        }
        else {
            cardIs="10"+cardSuit;
        }
        return cardIs;
    }

    //Returns value of card
    public static int cardToValue(int numOfList){
        int cardValue;
        //If card is K,J,Q, returns value of 10
        if (numOfList%13==0||(numOfList%13>=10&&numOfList%13<=12)){
            cardValue=10;
        }
        //If ace, return value of 11
        else if (numOfList%13==1){
            cardValue=11;
        }
        //All other cards values are their number%13
        else{
            cardValue=numOfList%13;
        }
        return cardValue;
    }

} // end of class Deck