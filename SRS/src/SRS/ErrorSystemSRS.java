package SRS;

import java.util.ArrayList;

public class ErrorSystemSRS extends Exception {
    private final int SIZE_COURSE = 3;
    public ErrorSystemSRS() {

    }
    public ErrorSystemSRS (String msg){super("Error :"+ msg);}




    public int getSIZE_COURSE() {

        return SIZE_COURSE;
    }
    @Override
    public String toString(){return "This Error based by UNI System and the cause of the error is above this massage";}
}
