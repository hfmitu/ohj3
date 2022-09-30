package dates;

public class Dates{

    private DateDiff[] dateDiffs;

    

    public static class DateDiff{
        String start;
        String end;
        int diff;

        public String getStart(){
            return this.start;
        }
        
        public String getEnd(){
            return this.end;
        }

        public int getDiff(){
            return this.diff;
        }

        
    }
}