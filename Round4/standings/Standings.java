import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Standings {
    
    List<Team> teams = new ArrayList<Team>();

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
        Collections.sort(teams, (d1,d2) ->{
            if ((d1.wins*3+d1.ties) != (d2.wins*3+d2.ties)) return (d1.wins*3+d1.ties) - (d2.wins*3+d2.ties);
            else if ( d1.scored-d1.allowed != d2.scored-d2.allowed) return (d1.scored-d1.allowed) - (d2.scored - d2.allowed);
            else if (d1.scored > d2.scored) return d1.scored-d2.scored;
            else return d1.name.compareTo(d2.name);
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

                boolean flag = false;

                for (Team t : teams){
                    if (t.name == line[0]) flag=true;
                }
                if (flag == false) teams.add(new Team(line[0]));
                flag = false;

                for (Team t: teams){
                    if (t.name == line[2]) flag=true;
                }
                if(flag == false) teams.add(new Team(line[2]));

                int a = Integer.parseInt(pnts[0]);
                int b = Integer.parseInt(pnts[1]);

                for (Team t : teams){
                    if (t.name == line[0]){
                        t.scored+= a;
                        t.allowed+= b;
                        if (a > b) t.wins++;
                        if (a==b) t.ties++;
                        if (a<b) t.losses++;
                    }
                    if (t.name== line[2]){
                        t.scored+= b;
                        t.allowed+= a;
                        if (a < b) t.wins++;
                        if (a==b) t.ties++;
                        if (a>b) t.losses++;
                    }
                }
            }
            sort();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }

    public void addMatchResult(String teamNameA, int goalsA, int goalsB, String teamNameB){
        
        boolean flag = false;

                for (Team t : teams){
                    if (t.name == teamNameA) flag=true;
                }
                if (flag == false) teams.add(new Team(teamNameA));
                flag = false;

                for (Team t: teams){
                    if (t.name == teamNameB) flag=true;
                }
                if(flag == false) teams.add(new Team(teamNameB));

                

                for (Team t : teams){
                    if (t.name == teamNameA){
                        t.scored+= goalsA;
                        t.allowed+= goalsB;
                        if (goalsA > goalsB) t.wins++;
                        if (goalsA==goalsB) t.ties++;
                        if (goalsA<goalsB) t.losses++;
                    }
                    if (t.name== teamNameB){
                        t.scored+= goalsB;
                        t.allowed+= goalsA;
                        if (goalsA < goalsB) t.wins++;
                        if (goalsA==goalsB) t.ties++;
                        if (goalsA>goalsB) t.losses++;
                    }
                }
                sort();
    }

    public void printStandings(){
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

            if (t.wins*3 + t.ties <10) System.out.println("  " + (t.wins*3 + t.ties));
            if (t.wins*3 + t.ties >=10) System.out.println(" " + (t.wins*3+t.ties));
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
