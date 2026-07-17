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


    // اگر مهره قبلا انتخاب شده باشد
    if(selectedRow != -1 && selectedCol != -1){

        if(game.getBoard().isValidMove(selectedRow, selectedCol, row, col)){

            game.getBoard().movePiece(selectedRow, selectedCol, row, col);


            if(game.isGameOver()){

                javax.swing.JOptionPane.showMessageDialog(
    GamePanel.this,
    game.checkWinner()
);
            }else{

                game.changeTurn();
            }
        }

        selectedRow = -1;
        selectedCol = -1;
        repaint();
        return;
    }



    // انتخاب مهره جدید
    int piece = game.getBoard().getBoard()[row][col].getStatus();


    if(piece != 0){


        // نوبت بازیکن اول
        if((piece == 1 || piece == 3) &&
           !game.getCurrentPlayer().getId().equals("Player 1")){

            return;
        }


        // نوبت بازیکن دوم
        if((piece == 2 || piece == 4) &&
           !game.getCurrentPlayer().getId().equals("Player 2")){

            return;
        }

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
        if(board[row][col].getStatus() == 1){
    // مهره بازیکن اول
    g.setColor(Color.CYAN);
    g.fillOval(col * 80 + 8, row * 80 + 8, 64, 64);

}else if(board[row][col].getStatus() == 2){
    // مهره بازیکن دوم
    g.setColor(Color.ORANGE);
    g.fillOval(col * TILE_SIZE + 8, row * TILE_SIZE + 8, TILE_SIZE - 16, TILE_SIZE - 16);

}else if(board[row][col].getStatus() == 3){
    // شاه بازیکن اول
    g.setColor(Color.CYAN);
    g.fillOval(col * TILE_SIZE + 8, row * TILE_SIZE + 8, TILE_SIZE - 16, TILE_SIZE - 16);

    g.setColor(Color.BLACK);
    g.drawString("K", col * TILE_SIZE + 35, row * TILE_SIZE + 45);

}else if(board[row][col].getStatus() == 4){
    // شاه بازیکن دوم
    g.setColor(Color.ORANGE);
    g.fillOval(col * TILE_SIZE + 8, row * TILE_SIZE + 8, TILE_SIZE - 16, TILE_SIZE - 16);

    g.setColor(Color.BLACK);
    g.drawString("K", col * TILE_SIZE + 35, row * TILE_SIZE + 45);
}
            if(row == selectedRow && col == selectedCol){
                g.setColor(Color.GREEN);

                g.drawRect(col * TILE_SIZE, row * TILE_SIZE, TILE_SIZE, TILE_SIZE);
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
