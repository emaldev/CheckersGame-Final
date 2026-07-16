import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

// این کلاس مسول رسم مهره ها و نمایش آن ها است 
public class GamePanel extends JPanel {
    
    private Game game;
     // اندازه هر خانه از صفحه 
    private final int TILE_SIZE = 80;
    // مهره سطر برای انتخاب 
    private int selectedRow = -1;
    // انتخاب مهره ستون 
    private int selectedCol = -1;
   
    
    // سازنده 
    public GamePanel(Game game){
        this.game = game;

        this.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mousePressed(java.awt.event.MouseEvent e){
                int col = e.getX() / TILE_SIZE;
                int row = e.getY() / TILE_SIZE;

                if(game.getBoard().getBoard()[row][col].getStatus() != 0){
                    selectedRow = row;
                    selectedCol = col;
                    repaint();
                }
            }
        });
    }

    // رسم صفحه بازی 
    @Override 
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        // گرفتن صفحه بازی از کلاس است 
        Tile[][] board = game.getBoard().getBoard();
        // پیمایش تمام خانه های صفحه 
        for(int row = 0; row < 8; row++){
            for(int col = 0; col < 8; col++){
                // اگر خانه تیره باشد 
                if(board[row][col].isDark()){
                    g.setColor(Color.DARK_GRAY);
                }else{ // اگر خانه روشن باشد 
                    g.setColor(Color.WHITE);
                }
                // رسم کردن خانه ها و اندازه آن ها 
                g.fillRect(col * 80, row * 80, 80, 80);
            }
        }
        // رسم مهره های بازی 
        // پیمایش تمام خانه های صفحه 
        for(int row = 0; row < 8; row++){
            for(int col = 0; col < 8; col++){
                // اگر این خانه مهره بازیکن اول باشد 
            if(board[row][col].getStatus() == 1){
                // رسم مهره 
                g.setColor(Color.CYAN);
                 // رسم  مهره 
                g.fillOval(col * 80 + 8, row * 80 + 8, 64, 64);
            }else if(board[row][col].getStatus() == 2){
                // رسم مهره 
                g.setColor(Color.ORANGE);
                     // رسم مهره 
                g.fillOval(col * TILE_SIZE + 8, row * TILE_SIZE + 8, TILE_SIZE - 16, TILE_SIZE - 16);
            }

        }
    }
    }
    
         // اندازه پنل بازی 
    @Override 
    public java.awt.Dimension getPreferredSize(){
        return new java.awt.Dimension(640, 640);
    }

  
}
