import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame{

    // سازنده 
    public GameFrame(Game game){
        this.setTitle("Checkers Game");
        // اضافه کردن صفحه بازی 
        this.add(new GamePanel());// اتصال به گیم پنل 
         // تنظیم اندازه پنجره 
        this.pack();
        // مکان قرار گرفتن پنجره 
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
    
}
