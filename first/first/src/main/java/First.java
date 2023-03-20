public class First {
    public static void main(String[] args) {
        Student student = new Student(123,"manu");
        student.printinfo();

    }
}
class Student{
    private int sid;
    private String sname;

    Student(int sid, String sname){
        this.sid=sid;
        this.sname=sname;
    }

    public void printinfo(){
        System.out.println(this.sid+this.sname);
    }

}