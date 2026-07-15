// این کلاس نماینده بازی کنان در بازی است 
public class Player {
    
     // شناسه بازیکن 
    private String id;

    // سازنده 
    public Player(String id){
        this.id = id;
    }

    // دریافت شناسه بازیکن 
    public String getId(){
        return id;
    }

    // بغییر شناسه بازیکن 
    public void setId(String id){
        this.id = id;
    }

    
}
