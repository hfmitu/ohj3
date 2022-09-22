public class Attainment {
    

    private String code;
    private String numero;
    private int grade;

    public Attainment(String code, String numero, int grade){
        this.code=code;
        this.numero=numero;
        this.grade=grade;
    }

    public String getCourseCode(){
        return this.code;
    }

    public String getStudentNumber(){
        return this.numero;
    }

    public int getGrade(){
        return this.grade;
    }

    
}
