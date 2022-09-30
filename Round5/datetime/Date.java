package datetime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Date {

    private int year;
    private int month;
    private int day;
    


    public Date(int year, int month, int day) throws DateException{
        boolean isValid = true;
        try {
          DateTimeFormatter f = DateTimeFormatter.ofPattern ( "dd.MM.uuuu" );
          LocalDate ld = LocalDate.parse ( day + "." + month + "." + year , f );
        } catch (Exception e) {
          isValid=false;
        }
        
        if (isValid = false) throw new DateException("Illegal date " + day + "." + month + "." + year);

        this.year=year;
        this.month=month;
        this.day=day;
    }

    public int getYear(){
        return this.year;
    }

    public int getMonth(){
        return this.month;
    }

    public int getDay(){
        return this.day;
    }

    public String toString(){
        return day + "." + month + "." + year;
    }

    
}