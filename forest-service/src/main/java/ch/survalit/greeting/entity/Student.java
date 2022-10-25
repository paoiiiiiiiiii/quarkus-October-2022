package ch.survalit.greeting.entity;

public class Student {
    public int id;
    public String fname;
    public String mname;
    public String lname;
    public int age;
    public String bday;
    public String inserted_date;
    public int student_no;

    public Student(int id, String fname, String mname, String lname, int age, String bday, String inserted_date,
    int student_no) {
        this.id = id;
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
        this.age = age;
        this.bday = bday;
        this.inserted_date = inserted_date;
        this.student_no = student_no;
    }
}
