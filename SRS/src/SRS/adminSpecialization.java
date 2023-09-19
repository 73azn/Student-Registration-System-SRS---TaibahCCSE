package SRS;
import java.util.ArrayList;

// START OF ADMIN CLASS
class adminSpecialization extends Staff implements SRS

{

    private ArrayList<String> emailID = new ArrayList<>();
    private ArrayList<String> adminSpecialization = new ArrayList<>();


    public adminSpecialization()

    {
        //empty constructor
    }

    @Override
    public String role() {
        return "The Admin of The University";
    }
    
    @Override 
    public String welcome ()
    {
    return "Welcome Admin";
    }



    public adminSpecialization(int staffID, String staffFirstName, String staffLastName, String contactNumber, String staffAddress, String emailID, String adminSpecialization , String Password)

    {
        super(staffID, staffFirstName, staffLastName, contactNumber, staffAddress,Password);
        this.emailID.add(emailID);
        this.adminSpecialization.add(adminSpecialization);
    }

    // START GETTER


    public ArrayList<String> getEmailID() {
        return emailID;
    }

    public ArrayList<String> getAdminSpecialization() {
        return adminSpecialization;
    }

    public String getemailID(int index)

    {
        return emailID.get(index);
    }

    public String getAdminSpecialization(int index)

    {
        return adminSpecialization.get(index);
    }

    // END GETTER

    // START SETTER


    public void setemailID(String emailID)

    {
        this.emailID.add(emailID);
    }

    public void setAdminSpecialization(String adminSpecialization)

    {
        this.adminSpecialization.add(adminSpecialization);
    }


    //END OF SETTER
}

// END OF ADMIN CLASS
