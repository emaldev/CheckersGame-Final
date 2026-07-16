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
        setupPieces();


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

    // قرار دادان مهره ها در صفحه 
    private void setupPieces(){
        // مهره بازیکن اول 
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 8; col++){
                // شرط فقط روی خانه هاب تیره 
                if(board[row][col].isDark()){
                    board[row][col].setStatus(1);
                }
            }
        }
        // قرار دادن مهره های بازیکن دوم 
        for(int row = 5; row < 8; row++){
            for(int col = 0; col < 8; col++){
                // روی خانه های تیره قرار بده 
                if(board[row][col].isDark()){
                    board[row][col].setStatus(2);
                }
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
