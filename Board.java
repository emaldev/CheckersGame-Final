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
    // بررسی معتبر بودن حرکت
// بررسی معتبر بودن حرکت
// بررسی معتبر بودن حرکت
public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {

    // خارج از صفحه
    if (toRow < 0 || toRow > 7 || toCol < 0 || toCol > 7) {
        return false;
    }

    int piece = board[fromRow][fromCol].getStatus();

    // خانه مبدا باید مهره داشته باشد
    if(piece == 0){
        return false;
    }


    // حرکت معمولی فقط به خانه خالی
    if(board[toRow][toCol].getStatus() == 0){

        // حرکت بازیکن اول
        if(piece == 1){

            if(toRow == fromRow + 1 &&
               Math.abs(toCol - fromCol) == 1){
                return true;
            }
        }


        // حرکت بازیکن دوم
        if(piece == 2){

            if(toRow == fromRow - 1 &&
               Math.abs(toCol - fromCol) == 1){
                return true;
            }
        }
    }



    // خوردن مهره بازیکن اول
    if(piece == 1){

        if(toRow == fromRow + 2 &&
           Math.abs(toCol - fromCol) == 2){

            int middleRow = (fromRow + toRow) / 2;
            int middleCol = (fromCol + toCol) / 2;

            if(board[middleRow][middleCol].getStatus() == 2){
                return true;
            }
        }
    }



    // خوردن مهره بازیکن دوم
    if(piece == 2){

        if(toRow == fromRow - 2 &&
           Math.abs(toCol - fromCol) == 2){

            int middleRow = (fromRow + toRow) / 2;
            int middleCol = (fromCol + toCol) / 2;

            if(board[middleRow][middleCol].getStatus() == 1){
                return true;
            }
        }
    }
    // حرکت شاه بازیکن اول
if(piece == 3){

    if(Math.abs(toRow - fromRow) == 1 &&
       Math.abs(toCol - fromCol) == 1){

        return true;
    }
}


// حرکت شاه بازیکن دوم
if(piece == 4){

    if(Math.abs(toRow - fromRow) == 1 &&
       Math.abs(toCol - fromCol) == 1){

        return true;
    }
}
// خوردن با شاه بازیکن اول
if(piece == 3){

    if(Math.abs(toRow - fromRow) == 2 &&
       Math.abs(toCol - fromCol) == 2){

        int middleRow = (fromRow + toRow) / 2;
        int middleCol = (fromCol + toCol) / 2;

        if(board[middleRow][middleCol].getStatus() == 2){
            return true;
        }
    }
}


// خوردن با شاه بازیکن دوم
if(piece == 4){

    if(Math.abs(toRow - fromRow) == 2 &&
       Math.abs(toCol - fromCol) == 2){

        int middleRow = (fromRow + toRow) / 2;
        int middleCol = (fromCol + toCol) / 2;

        if(board[middleRow][middleCol].getStatus() == 1){
            return true;
        }
    }
}


    return false;
}

// انتقال مهره
public void movePiece(int fromRow, int fromCol, int toRow, int toCol) {

    int piece = board[fromRow][fromCol].getStatus();

    board[toRow][toCol].setStatus(piece);

    board[fromRow][fromCol].setStatus(0);


    // اگر حرکت دو خانه بود، مهره وسط حذف شود
    if(Math.abs(toRow - fromRow) == 2){

        int middleRow = (fromRow + toRow) / 2;
        int middleCol = (fromCol + toCol) / 2;

        board[middleRow][middleCol].setStatus(0);
    }
    // شاه شدن مهره بازیکن اول
if(piece == 1 && toRow == 7){
    board[toRow][toCol].setStatus(3);
}

// شاه شدن مهره بازیکن دوم
if(piece == 2 && toRow == 0){
    board[toRow][toCol].setStatus(4);
}

}
// بررسی وجود مهره های بازیکن
public boolean hasPieces(int player){

    for(int row = 0; row < 8; row++){
        for(int col = 0; col < 8; col++){

            int piece = board[row][col].getStatus();

            if(player == 1 && (piece == 1 || piece == 3)){
                return true;
            }

            if(player == 2 && (piece == 2 || piece == 4)){
                return true;
            }
        }
    }

    return false;
}
    
    
}
