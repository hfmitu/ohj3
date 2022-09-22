public class Student {
    
    private String nimi;
    private String numero;

    public Student(String nimi, String numero){
        this.nimi=nimi;
        this.numero=numero;
    }

    public String getName(){
        return this.nimi;
    }

    public String getStudentNumber(){
        return this.numero;
    }



}
