// این کلاس نماینده اصلی بازی است که شامل سطر و ستون ها است 
// در این کلاس 64 خانه از tile ساخته می شود 
public class Board {

    // آرایه دو بعدی 
    private Tile[][] board;

    // سازنده 
    public Board(){
        // ایجاد صفحه با ابعاد 8 در 8 
        board = new Tile[8][8];
        // مقدار دهی کردن تمام خانه ها 
        createBoard();


    }

    // ساخت صفحه بازی رنگ و موقیعت خانه 
    private void createBoard(){
        
        for(int row = 0; row < 8; row++){
            for(int col = 0; col < 8; col++){
                // اگر جمع سطرو ستون فرد باشد خانه تیره است 
                boolean dark = (row + col) % 2 != 0;
                 // ساخت خانه  
                board[row][col] = new Tile(dark, row, col);
            }
        }
    }

    //برگرداندن کل صفحه بازی 
    public Tile[][] getBoard(){
        return board;
    }
    //برگرداندن یک خانه مشحض 
    public Tile getTile(int row, int col){
        return board[row][col];
    }
    
    
}
