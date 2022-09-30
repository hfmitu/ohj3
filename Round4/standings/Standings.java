import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Standings {
    
    private List<Team> teams = new ArrayList<Team>();

    static class Team {
        private String name;
        private int wins;
        private int ties;
        private int losses;
        private int scored;
        private int allowed;
        private int points;

        public Team(String name){
            this.name = name;
        }

        public String getName(){
            return this.name;
        }

        public int getWins(){
            return this.wins;
        }

        public int getTies(){
            return this.ties;
        }

        public int getLosses(){
            return this.losses;
        }

        public int getScored(){
            return this.scored;
        }

        public int getAllowed(){
            return this.allowed;
        }

        public int getPoints(){
            return this.points;
        }


    }

    public Standings(){

    }

    private void sort(){
        Collections.sort(teams, (Team o1, Team o2)->{
                if (o1.getPoints() == o2.getPoints() && (o1.getScored()-o1.getAllowed()) == (o2.getScored()-o2.getAllowed()) && o1.getScored() == o2.getScored()) return o2.getName().compareTo(o1.getName());
                if (o1.getPoints() == o2.getPoints() && (o1.getScored()-o1.getAllowed()) == (o2.getScored()-o2.getAllowed())) return o2.getScored()-o1.getScored();
                if (o1.getPoints() == o2.getPoints()) return (o2.getScored()-o2.getAllowed()) - (o1.getScored()-o1.getAllowed());
                return o2.getPoints()-o1.getPoints();
            });
    }

    public Standings(String filename){
        readMatchData(filename);
    }

    public void readMatchData(String filename){
        try {
            var file = new BufferedReader(new FileReader(filename));
            String Str;
            while((Str = file.readLine()) != null) {
                String[] line = Str.split("\\t");
                String[] pnts = line[1].split("-");
                int a = Integer.parseInt(pnts[0]);
                int b = Integer.parseInt(pnts[1]);

                addMatchResult(line[0], a, b, line[2]);

            }
            sort();
            file.close();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }

    public void addMatchResult(String teamNameA, int goalsA, int goalsB, String teamNameB){
        
        boolean flag = false;

                for (Team t : teams){
                    if (t.name.equals(teamNameA)) flag=true;
                }
                if (flag == false) teams.add(new Team(teamNameA));
                flag = false;

                for (Team t: teams){
                    if (t.name.equals(teamNameB)) flag=true;
                }
                if(flag == false) teams.add(new Team(teamNameB));

                

                for (Team t : teams){
                    if (t.name.equals(teamNameA)){
                        t.scored+= goalsA;
                        t.allowed+= goalsB;
                        if (goalsA > goalsB) {t.wins++;t.points+=3;}
                        if (goalsA==goalsB) {t.ties++;t.points+=1;}
                        if (goalsA<goalsB) t.losses++;
                    }
                    if (t.name.equals(teamNameB)){
                        t.scored+= goalsB;
                        t.allowed+= goalsA;
                        if (goalsA < goalsB) {t.wins++;t.points+=3;}
                        if (goalsA==goalsB) {t.ties++;t.points+=1;}
                        if (goalsA>goalsB) t.losses++;
                    }
                }
                sort();
    }

    public void printStandings(){
        sort();
        int length = 0;
        for (Team t : teams){
            if (t.name.length() > length) length = t.name.length();
        }

        for (Team t : teams ){
            System.out.print(t.name + " ".repeat(length-t.name.length()) + " ");
            if (t.wins + t.ties + t.losses < 10) System.out.print("  " + (t.wins+t.ties+t.losses) + " ");
            if (t.wins + t.ties + t.losses >= 10) System.out.print(" " + (t.wins+t.ties+t.losses) + " ");

            if (t.wins < 10) System.out.print("  " + t.wins + " ");
            if (t.wins >= 10) System.out.print(" " + t.wins + " ");

            if (t.ties < 10) System.out.print("  " + t.ties + " ");
            if (t.ties >= 10) System.out.print(" " + t.ties + " ");

            if (t.losses < 10) System.out.print("  " + t.losses + " ");
            if (t.losses >= 10) System.out.print(" " + t.losses + " ");

            if (t.allowed < 10 && t.scored < 10) System.out.print("   " + t.scored + "-" + t.allowed + " ");
            if ((t.allowed < 10 && t.scored >=10)|| (t.allowed >= 10 && t.scored < 10)) System.out.print("  " + t.scored + "-" + t.allowed + " ");
            if (t.allowed >=10 && t.scored >=10) System.out.print(" " + t.scored + "-" + t.allowed + " ");

            if (t.points <10) System.out.println("  " + t.points);
            if (t.points >=10) System.out.println(" " + t.points);
        }
    }
    
    public List<Team> getTeams(){
        return teams;
    }

    /** 
    public static void main(String[] args){
        Standings standings = new Standings();
    standings.addMatchResult("Tonga", 0, 3, "Cook Islands");
    standings.addMatchResult("Samoa", 3, 2, "American Samoa");
    standings.addMatchResult("Cook Islands", 1, 0, "Samoa");
    standings.addMatchResult("Tonga", 1, 2, "American Samoa");
    standings.addMatchResult("Tonga", 0, 3, "Samoa");
    standings.addMatchResult("American Samoa", 2, 0, "Cook Islands");
    standings.printStandings();
    }
    */
}
