package SRS;
import java.util.ArrayList;

// START OF STAFF CLASS
public class Staff implements SRS

{

    private ArrayList<Integer> staffID = new ArrayList<>();
    private ArrayList<String> staffFirstName = new ArrayList<>();
    private ArrayList<String> staffLastName= new ArrayList<>();
    private ArrayList<String> contactNumber = new ArrayList<>();
    private ArrayList<String> staffAddress = new ArrayList<>();
    private ArrayList<String> Password = new ArrayList<>();

    public Staff()

    {

        this.staffID.add(null);
        this.staffFirstName.add(null);
        this.staffLastName.add(null);
        this.contactNumber.add(null);
        this.staffAddress.add(null);


    }

    public Staff(int staffID, String staffFirstName , String staffLastName , String contactNumber , String staffAddress,String Password)

    {

        this.staffID.add(staffID);

        this.staffFirstName.add(staffFirstName);

        this.staffLastName.add(staffLastName);

        this.contactNumber.add(contactNumber);

        this.staffAddress.add(staffAddress);
        
        this.Password.add(Password);
    }

    // START OF GETTER STAFF
    public int getStaffID(int index)

    {
        return staffID.get(index);
    }

    public String getStaffFirstName(int index)

    {
        return staffFirstName.get(index);
    }

    public String getStaffLastName(int index)

    {
        return staffLastName.get(index);
    }

    public String getContactNumber(int index)

    {
        return contactNumber.get(index);
    }

    public String getStaffAddress(int index)

    {
        return staffAddress.get(index);
    }

    public ArrayList<Integer> getStaffID() {
        return staffID;
    }

    public ArrayList<String> getStaffFirstName() {
        return staffFirstName;
    }

    public ArrayList<String> getStaffLastName() {
        return staffLastName;
    }

    public ArrayList<String> getContactNumber() {
        return contactNumber;
    }

    public ArrayList<String> getStaffAddress() {
        return staffAddress;
    }

    // THE END OF GETTER STAFF



    // START SETTER STAFF

    public void setStaffID(int staffID)

    {
        this.staffID.add(staffID);
    }

    public void setStaffFirstName(String staffFirstName)

    {
        this.staffFirstName.add(staffFirstName);
    }

    public void setStaffLastName(String staffLastName)

    {
        this.staffLastName.add(staffLastName);
    }

    public void setContactNumber(String contactNumber)

    {
        this.contactNumber.add(contactNumber);
    }

    public void setStaffAddress(String staffAddress)

    {
        this.staffAddress.add(staffAddress);
    }
    
    public ArrayList<String> getPassword(){
    return this.Password;
    }
    public String getPassword(int index){
    return this.Password.get(index);
    }

    @Override
    public String role() {
        return "Work in Taibah University";
    }

    @Override
    public String welcome() {
        return "Welcome Staff";
    }




    // THE END OF SETTER STAFF




}

// END OF STAFF CLASS








