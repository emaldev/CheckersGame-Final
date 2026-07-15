public class Tile {
    // رنگ خانه اگر تیره بود = ture 
    // اگر رنگ خانه روشن بود = false
    private boolean dark;
    private int row;// سطر
    private int col;// ستون 

    // وضعیت خانه 
    private int status;


    public Tile(boolean dark, int row, int col){
        this.dark = dark;
        this.row = row;
        this.col = col;
             // در ابتدا خانه خالی می باشد 
        this.status = 0;
    }

    // Getter.
    public boolean isDark(){
        return dark;
    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;

    }
    public int getStatus(){
        return status;
    }

    // Setter
    public void setStatus(int status){
      this.status = status;
    }
}
