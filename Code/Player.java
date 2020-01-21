import javax.swing.*;
/**
 * Write a description of class Player here.
 * 
 * @author Susan Shi
 * @version 1.0 2018-10-29
 */
public class Player extends Member
{
    private JFrame frame = new JFrame("Decision");

    public Player()
    {
        super();
    }

    public void showHands()
    {
        System.out.println("Your score is: " + super.getScore());
        System.out.println("Your cards are: ");
        super.showHands();
    }

    public boolean hit()
    {
        if(go)
        {
            int decision = JOptionPane.showConfirmDialog(frame,
                    "Click Yes to hit and No to stand", "information",
                    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if(decision == 0)
            {
                return true;
            }
            else
            {
                super.makeDecision(false);
                return false;
            }
        }
        else
            return false;
    }

} // end of class Player