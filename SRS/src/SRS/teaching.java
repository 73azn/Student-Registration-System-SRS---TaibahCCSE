package SRS;
import java.util.ArrayList;

class teaching extends FacultyMember
{

    static ErrorSystemSRS Errors = new ErrorSystemSRS();
    private ArrayList<String> courses = new ArrayList<>(3)  ;

    private ArrayList<Integer> lecture;

    public teaching()

    {

        // empty constroutor

    }





    public teaching(int staffID, String staffFirstName, String staffLastName, String contactNumber, String staffAddress, char academicRank, String emailID, String academicSpecialty, String courses, int lecture , String Password)

    {
        super(staffID, staffFirstName, staffLastName, contactNumber, staffAddress, academicRank, emailID, academicSpecialty , Password);
        this.courses.add(courses);
        this.lecture.add(lecture);
    }

    //START OF GETTER TEACHING
    public String getCourses(int IndexCourse)
    {
        return this.courses.get(IndexCourse);
    }

    public boolean isCourseFilled (int IndexCourse) throws java.lang.IndexOutOfBoundsException
    {
        try {
            if (this.courses.get(IndexCourse) == null){ return false;}
            else {return true;}
        }
        catch (java.lang.IndexOutOfBoundsException ex)
        {
            System.out.println("Error : the index out of range or not set any value yet"); return false;
        }
    }

    public ArrayList<Integer> getLecture()
    {
        return this.lecture;
    }


    //END OF GETTER TEACHING

    //START OF SETTER TEACHING
    public void addCourses(String courses)
    {
        this.courses.add(courses) ;
    }



    public void setLecture(int index, int value)
    {
        this.lecture.set(index,value);
    }

    public void addLecture(int value){this.lecture.add(value);}
    public void drobCourse(int index) throws java.lang.IndexOutOfBoundsException

    {
        try {

            this.courses.set(index, null);

        } catch (java.lang.IndexOutOfBoundsException ex) {System.out.println("Error : can't edit higher than 3 courses");}
    }


    //END OF SETTER TEACHING

    public void maxCourses() throws ErrorSystemSRS
    {



        try {
            if (courses.size() > Errors.getSIZE_COURSE())
            {

                throw new  ErrorSystemSRS();

            }
        } catch (ErrorSystemSRS ex){
            System.out.println("Error : can't get more than 3 courses\n"+ex.toString());
        }




    }
}
