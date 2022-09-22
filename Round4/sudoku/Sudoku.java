public class Sudoku {
    
    private char[][] ruudukko;
    private char[] merkit = {' ','1','2','3','4','5','6','7','8','9','0'};


    public Sudoku(){
        ruudukko = new char[9][9];
        for (char[] s : this.ruudukko){
            for (char k : s) {
                k = ' ';
            }
        }
    }

    public void set(int i, int j, char c){
        if (i < 0 || i > 8 || j < 0 || j > 8) {System.out.println("Trying to access illegal cell (" + i + ", " + j + ")!"); return;}
        boolean flag = false;
        for (char d : merkit){
            if (c == d) flag = true;
        }
        if (flag==false) {System.out.println("Trying to set illegal character " + c + " to (" + i + ", " + j + ")!"); return;}
        else ruudukko[i][j] = c;
    }

    public boolean check(){
        //Tarkistetaan rivit
        int[] check = {0,0,0,0,0,0,0,0,0,0};
        for (int i = 0; i < ruudukko.length; i++){
            for (char c : ruudukko[i]){
                if (c != ' ') check[Character.getNumericValue(c)]++;
            }
            for (int s = 1; s < check.length; s++){
                if (check[s] > 1) {System.out.println("Row " + i + " has multiple " + s + "'s!"); return false;}
                check[s] = 0;
            }
            
        }
        //tarkistetaan sarakkeet
        for (int s = 0; s < ruudukko[0].length;s++){
        for (int i = 0; i < ruudukko.length;i++){
            if (ruudukko[i][s] != ' ') check[Character.getNumericValue(ruudukko[i][s])]++;
        }
        for (int h = 1; h < check.length; h++){
            if (check[s] > 1) {System.out.println("Column " + s + " has multiple " + h + "'s!"); return false;}
            check[s] = 0;
        }

        }



        return true;
    }

    public void print(){
        System.out.println("#".repeat(37));
        int rivi = 1;
        for (char[] d : ruudukko) {
            System.out.print("# " + d[0] + " | " + d[1] + " | " + d[2] + " ");
            System.out.print("# " + d[3] + " | " + d[4] + " | " + d[5] + " ");
            System.out.println("# " + d[6] + " | " + d[7] + " | " + d[8] + " #");
            if (rivi!= 3 &&rivi!=6&& rivi!= 9){
                System.out.println("#---+---+---#---+---+---#---+---+---#");
            }
            else System.out.println("#".repeat(37));
            rivi++;

        }

        
    }

}
