package SRS;
import java.util.ArrayList;
public class Course extends Object
{
    private ArrayList<Integer> courseCode = new ArrayList<>();
    private ArrayList<String> courseName = new ArrayList<>();
    private ArrayList<Integer> creditHours= new ArrayList<>();

    public Course(){
      
    }
    public Course (int courseCode, String courseName, int creditHours)
    {

        this.courseCode.add(courseCode) ;
        this.courseName.add(courseName) ;
        this.creditHours.add(creditHours);

    }

    //start of getter
    public int getCourseCode(int index)
    {
        return courseCode.get(index);
    }

    public String getCourseName(int index)
    {
        return courseName.get(index);
    }

    public int getCreditHours(int index)
    {
        return creditHours.get(index);
    }


    public boolean isCourseFilled (int IndexCourse) throws java.lang.IndexOutOfBoundsException
    {
        try {
            if (this.courseName.get(IndexCourse) == null){ return false;}
            else {return true;}
        }
        catch (java.lang.IndexOutOfBoundsException ex)
        {
            System.out.println("Error : the index out of range or not set any value yet"); return false;
        }
    }
    public ArrayList<Integer> getCourseCode() {
        return courseCode;
    }

    public ArrayList<String> getCourseName() {
        return courseName;
    }

    public ArrayList<Integer> getCreditHours() {
        return creditHours;
    }

    //end of getter


    //start of setter
    public void setCourseCode(int index,int courseCode)
    {
        this.courseCode.set(index,courseCode);
    }

    public void setCourseName(int index,String courseName)
    {
        this.courseName.set(index,courseName);
    }

    public void setCreditHours(int index ,int creditHours)
    {
        this.creditHours.set(index,creditHours);
    }

    public void setCourseCode(int courseCode)
    {
        this.courseCode.add(courseCode);
    }

    public void setCourseName(String courseName)

    {
        this.courseName.add(courseName);
    }

    public void setCreditHours(int creditHours)
    {
        this.creditHours.add(creditHours);
    }



    //end of setter
}
