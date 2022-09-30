public class Sudoku {
    
    private char[][] ruudukko;
    private char[] merkit = {' ','1','2','3','4','5','6','7','8','9'};


    public Sudoku(){
        ruudukko = new char[9][9];
        for (char[] s : this.ruudukko){
            for (char k : s) {
                k = ' ';
            }
        }
    }

    public void set(int i, int j, char c){
        if (i < 0 ||i > 8 || j < 0 || j > 8) {
            System.out.println("Trying to access illegal cell (i, j)!");
            return;
        }

        boolean oikea = false;
        for (char p : merkit){
            if (c == p){
                oikea = true;
                break;
            }
        }
        if (oikea) ruudukko[i][j] = c;
        else System.out.println("Trying to set illegal character" + c + " to (" + i + ", "  + j + ")!");
    }

    public boolean check(){

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
