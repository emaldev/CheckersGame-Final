import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

// این کلاس مسول رسم مهره ها و نمایش آن ها است 
public class GamePanel extends JPanel {
    
    private Game game;
    
    // سازنده 
    public GamePanel(Game game){
        this.game = game;
    }

    // رسم صفحه بازی 
    @Override 
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
    }
         // اندازه پنل بازی 
    @Override 
    public java.awt.Dimension getPreferredSize(){
        return new java.awt.Dimension(640, 640);
    }

  
}
