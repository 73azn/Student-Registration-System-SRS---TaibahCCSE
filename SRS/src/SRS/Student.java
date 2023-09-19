package SRS;

import java.util.ArrayList;

public class Student implements SRS
{
    private ArrayList<Integer> studentID = new ArrayList<>();
    private ArrayList<String> studentName = new ArrayList<>();
    private ArrayList<String> studentEmail = new ArrayList<>();
    private ArrayList<String> studentContact = new ArrayList<>();
    private ArrayList<ArrayList<String>> courses = new ArrayList<>();
    private ArrayList<String> password = new ArrayList<>();

    public Student()
    {

        this.studentID.add(null);
        this.studentName.add(null);
        this.studentEmail.add(null);
        this.studentContact.add(null);
        this.courses.add(null);
        this.password.add(null);

    }



    public Student(int studentID, String studentName, String studentEmail, String studentContact,String password)
    {
        this.studentID.add(studentID);
        this.studentName.add(studentName);
        this.studentEmail.add(studentEmail);
        this.studentContact.add(studentContact);
        this.courses.add(null);
        this.password.add(password);
    }
    //START OF GETTER STUDENT
    public int getStudentID(int index)
    {
        return this.studentID.get(index);
    }

    public String getStudentName(int index)
    {
        return this.studentName.get(index);
    }

    public String getStudentEmail(int index)
    {
        return this.studentEmail.get(index);
    }

    public String getStudentContact(int index)
    {
        return this.studentContact.get(index);
    }
    public ArrayList<Integer> getStudentID() {
        return this.studentID;
    }

    public ArrayList<String> getStudentName() {
        return this.studentName;
    }

    public ArrayList<String> getStudentEmail() {
        return this.studentEmail;
    }

    public ArrayList<String> getStudentContact() {
        return this.studentContact;
    }
    public String getPassword (int index)
    {
        return this.password.get(index);
    }
    public ArrayList<String> getPasswrod()
    {
        return this.password;
    }
    //END OF GETTER STUDENT

    //START OF SETTER STUDENT
    public void setStudentID(int index , int studentID)
    {
        this.studentID.set(index , studentID);
    }

    public void setStudentName(int index , String studentName)
    {
        this.studentName.set(index , studentName);
    }

    public void setStudentEmail(int index ,String studentEmail)
    {
        this.studentEmail.set(index , studentEmail);
    }

    public void setStudentContact(int index , String studentContact)
    {
        this.studentContact.set(index , studentContact);
    }


    public void addStudentID(int studentID) {
        this.studentID.add(studentID);
    }

    public void setStudentName(String studentName) {
        this.studentName.add(studentName);
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail.add(studentEmail);
    }

    public void setStudentContact(String studentContact) {
        this.studentContact.add(studentContact);
    }
    //END OF SETTER STUDENT



    @Override
    public String role() {
        return "Student";
    }
    @Override
    public String welcome() {
        return "Welcome Student";
    }

  public void setCourses(int index ,  ArrayList<String> course){
      this.courses.add(index,course);}

    public ArrayList<String> getCourses(int index) {
        return this.courses.get(index);
    }
}
