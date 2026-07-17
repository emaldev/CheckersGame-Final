// مدیریت کل بازی 
public class Game {

    // صفحه بازی 
    private Board board;
     // آرایه بازی کنان 
    private Player[] players;
    // بازی کنی که نوبت اول از او است 
    private Player currentPlayer;

    // سازنده 
    public Game(){
        // ساخت صفحه بازی 
    board = new Board();
    // ساخت دو بازیکن 
    players = new Player[2];
    players[0] = new Player("Player 1");
    players[1] = new Player("Player 2");

    // بازی با بازیکن اول شروع می شود 
    currentPlayer = players[0];

    
    }

    // برگرداندن صفحه بازی 
    public Board getBoard(){
        return board;
    }
    // برگداندن بازیکنی که نوبت از او است 
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    // تغییر نوبت بازیکنان 
    public void changeTurn(){
        if(currentPlayer == players[0] ) {
            currentPlayer = players[1]; 
        }else{
            currentPlayer = players[0];
        }
    }
}
