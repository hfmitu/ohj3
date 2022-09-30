package datetime;

public class DateTime extends Date {

    private int hour;
    private int minute;
    private int second;
    

    public DateTime(int year, int month, int day, int hour, int minute, int second) throws DateException{
        super(year,month,day);
        if (hour < 0 || hour > 23 || minute < 0 || minute > 59 || second < 0 || second > 59) throw new DateException("Illegal time " + hour + ":" + minute + ":" + second);
        else {this.hour=hour;
        this.minute=minute;
        this.second=second;
        }
        
    }

    public String toString(){
        return super.toString()+ " " + this.hour + ":" + this.minute + ":" + this.second;
    }
}