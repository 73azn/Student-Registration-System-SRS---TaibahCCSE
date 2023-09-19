package SRS;

import java.util.ArrayList;
// START OF FACULTY CLASS
class FacultyMember extends Staff implements SRS

{
    private ArrayList<Character> academicRank = new ArrayList<>();
    private ArrayList<String> emailID = new ArrayList<>();

    private ArrayList<String> academicSpecialty = new ArrayList<>();

    public FacultyMember()

    {

        //empty Constructor

    }

    @Override
    public String role() {
        return "Teach The Students";
    }
    @Override
    public String welcome(){
    return "Welcome Teacher";
    }



    public FacultyMember(int staffID, String staffFirstName, String staffLastName, String contactNumber, String staffAddress, char academicRank, String emailID, String academicSpecialty , String Password)

    {

        super(staffID, staffFirstName, staffLastName, contactNumber, staffAddress , Password);
        this.academicRank.add(academicRank);
        this.emailID.add(emailID);
        this.academicSpecialty.add(academicSpecialty);
    }
    // START GETTER
    public char getAcademicRank(int index)

    {
        return this.academicRank.get(index);
    }

    public String getEmailID(int index)

    {
        return this.emailID.get(index);
    }

    public String getAcademicSpecialty(int index)

    {
        return this.academicSpecialty.get(index);
    }

    public ArrayList<String> getEmailID() {
        return emailID;
    }

    public ArrayList<String> getAcademicSpecialty() {
        return academicSpecialty;
    }

    // END GETTER

    // START SETTER

    public void setAcademicRank(char academicRank)

    {
        this.academicRank.add(academicRank);
    }

    public void setEmailID(String emailID)

    {
        this.emailID.add(emailID);
    }

    public void setAcademicSpecialty(String academicSpecialty)

    {
        this.academicSpecialty.add(academicSpecialty);
    }

    public ArrayList<Character> getAcademicRank() {
        return academicRank;
    }



    // END SETTER
}

// END OF FACULTY CLASS