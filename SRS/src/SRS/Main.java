package SRS;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.HashSet;
import  java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.control.Alert;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Main extends Application {
    
    static Student student = new Student(1001,"Amer Nawab","email@email.email","+96600000000","1111"); // public Student(int studentID, String studentName, String studentEmail, String studentContact)
    static FacultyMember facultyMember = new FacultyMember(2001,"Omar","Mula","+9660000000","Medinah",'S',"email@emil.email","Teacher" , "1111"); //public FacultyMember(int staffID, String staffFirstName, String staffLastName, String contactNumber, String staffAddress, char academicRank, String emailID, String academicSpecialty)
    static adminSpecialization admin = new adminSpecialization(3001,"Hamza","Ghandora","+966000000000","Medinah","email@email.email","Admin","1111"); //public adminSpecialization(int staffID, String staffFirstName, String staffLastName, String contactNumber, String staffAddress, String emailID, String adminSpecialization)
    static Course course = new Course(001,"programing(1)",3);//public Course (int courseCode, String courseName, int creditHours)    
    private Stage mainStage;
    private Stage newStage;
    private Scene mainScene;
    private Scene stScene;
    private Scene adminScene;
    private Scene facScene;
    private int ID;
    private int StudentIndex = student.getStudentID().indexOf(ID);
    private int CsInt;
    private int CsIndex = course.getCourseCode().indexOf(CsInt)+1;

    @Override
    public void start(Stage ps) {
      
       mainPage(ps);
        
    }


private void showMessage(String message) {
        // Create an Alert dialog with the specified message
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Message");
        alert.setHeaderText(null);
        alert.setContentText(message);
        

        // Display the dialog and wait for user acknowledgement
        alert.showAndWait();
    }

private void mainPage (Stage mainStage){
    System.out.println(StudentIndex);
    this.mainStage = mainStage;
    
    //nodes
    Label idLabel = new Label("Collage ID");
    Label passLabel = new Label("Password");
    TextField idField = new TextField();
    TextField passField = new TextField();
    Button btLogin = new Button("login");
    
    //images
    
    Image uniLogo = new Image("taibah.png");
    Image icon = uniLogo;
    ImageView viewLogo = new ImageView(uniLogo);
    
    
    
    //btHandle
    btLogin.setOnAction(event ->
    
    {
        
        String text = idField.getText();
        String text1 = passField.getText();
        
        
        
        if(text.isEmpty()){showMessage("Empty Field please Fill it");}
        
        else {
            
        int ID = Integer.parseInt(text);
        this.ID = ID;
        int stindex = student.getStudentID().indexOf(ID);
        System.out.println(text1);
        
        if (student.getStudentID().contains(ID) && student.getPasswrod().contains(text1) ){showMessage(student.welcome());
        studentPage();
        }
        else if (facultyMember.getStaffID().contains(ID) && facultyMember.getPassword().contains(text1) )
                {showMessage(facultyMember.welcome()); facPage();}
        else if (admin.getStaffID().contains(ID)  && admin.getPassword().contains(text1) ){showMessage(admin.welcome()); adminPage();}
        else{showMessage("Not Registerd in the System");}
        }
   
    
    });

    //pane
    
    GridPane mainPane = new GridPane();
    
    mainPane.setPadding(new Insets(1));
    mainPane.setAlignment(Pos.CENTER);
    mainPane.setHgap(10);
    mainPane.setVgap(10);
    
    
    mainPane.getChildren().add(viewLogo);
    mainPane.getChildren().add(idField);
    mainPane.getChildren().add(passField);
    mainPane.getChildren().add(idLabel);
    mainPane.getChildren().add(passLabel);
    mainPane.getChildren().add(btLogin);
    
    
    
    GridPane.setConstraints(viewLogo, 0, 0);
    GridPane.setConstraints(idLabel, 0, 1);
    GridPane.setConstraints(passLabel, 0, 2);
    GridPane.setConstraints(idField, 0,1);
    GridPane.setConstraints(passField, 0,2);
    GridPane.setConstraints(btLogin,  0, 3);
   
    
    
    //Styles
    mainPane.getStyleClass().add("Mainbg");
    
    idLabel.getStyleClass().add("idLabel");
    passLabel.getStyleClass().add("idLabel");
    
    btLogin.getStyleClass().add("btLogin");
    btLogin.getStyleClass().add("btHover");
    btLogin.getStyleClass().add("size");
    
    viewLogo.getStyleClass().add("Taibah");
  
    
    
    idField.getStyleClass().add("textField");
    passField.getStyleClass().add("textField");
    
    
    
    
    //stage and scene
    Scene mainScene = new Scene(mainPane,720,680);
    this.mainScene = mainScene;
    
    mainStage.setScene(mainScene);
    mainScene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
    mainStage.getIcons().add(icon);
    mainStage.setTitle("SRS System");
    mainStage.show();
    
    
    
}

private void studentPage(){
        //nodes
        Button btLogout = new Button("logout");
        Button btInfo = new Button("Student Info");
        Button btShow = new Button("Show Courses");
        Button btAdd = new Button("Add Courses");
        Label welcome = new Label(getWelcome(student,ID));
       
        
        //btHandler
        btLogout.setOnAction(event -> {goBack(mainScene);});
        
        btInfo.setOnAction(event -> {stInfo();});
        
        btAdd.setOnAction(event -> {stAdd();});
        
        btShow.setOnAction(event -> {stShow();});
        
        
        //Pane
        GridPane stPane = new GridPane();
        stPane.getChildren().add(btLogout);
        stPane.getChildren().add(welcome);
        stPane.getChildren().add(btInfo);
        stPane.getChildren().add(btShow);
        stPane.getChildren().add(btAdd);
        
        
        stPane.setAlignment(Pos.CENTER);
        GridPane.setConstraints(btLogout, 0, 0);
        GridPane.setConstraints(btInfo, 0, 1);
        GridPane.setConstraints(btShow, 0, 3);
        GridPane.setConstraints(btAdd, 0, 5);
        GridPane.setConstraints(welcome, 0, 0);
        
        //Style
        stPane.getStyleClass().add("Mainbg");
        
        btLogout.getStyleClass().add("btLogout");
        btLogout.getStyleClass().add("size");
        btLogout.getStyleClass().add("btHover");
        
        btInfo.getStyleClass().add("btGen");
        btInfo.getStyleClass().add("size");
        btInfo.getStyleClass().add("btHover");
       
        btShow.getStyleClass().add("btGen");
        btShow.getStyleClass().add("size");
        btShow.getStyleClass().add("btHover");
       
        btAdd.getStyleClass().add("btGen");
        btAdd.getStyleClass().add("size");
        btAdd.getStyleClass().add("btHover");
        
        btInfo.getStyleClass().add("bt1");
        btShow.getStyleClass().add("bt2");
        btAdd.getStyleClass().add("bt3");
        
        welcome.getStyleClass().add("Header");
        
        //Stage and Scenes
        Scene stScene = new Scene(stPane, 720, 680);
        this.stScene = stScene;
        stScene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        mainStage.setScene(stScene);
        
        
        
}

private void stInfo(){
int StudentIndex = student.getStudentID().indexOf(ID);

    




//Pane
GridPane infoPane = new GridPane();
infoPane.setAlignment(Pos.CENTER);


//rectangels
Rectangle id1 = new Rectangle();
id1.setArcWidth(20);
id1.setArcHeight(20);
id1.setWidth(150);
id1.setHeight(30);
id1.setFill(Color.rgb(220, 220, 220));
id1.setStroke(Color.BLACK);
id1.setStrokeWidth(2);

Rectangle id2 = new Rectangle();
id2.setArcWidth(20);
id2.setArcHeight(20);
id2.setWidth(260);
id2.setHeight(30);
id2.setFill(Color.rgb(220, 220, 220));
id2.setStroke(Color.BLACK);
id2.setStrokeWidth(2);

Rectangle em1 = new Rectangle();
em1.setArcWidth(20);
em1.setArcHeight(20);
em1.setWidth(150);
em1.setHeight(30);
em1.setFill(Color.rgb(220, 220, 220));
em1.setStroke(Color.BLACK);
em1.setStrokeWidth(2);

Rectangle em2 = new Rectangle();
em2.setArcWidth(20);
em2.setArcHeight(20);
em2.setWidth(260);
em2.setHeight(30);
em2.setFill(Color.rgb(220, 220, 220));
em2.setStroke(Color.BLACK);
em2.setStrokeWidth(2);

Rectangle na1 = new Rectangle();
na1.setArcWidth(20);
na1.setArcHeight(20);
na1.setWidth(150);
na1.setHeight(30);
na1.setFill(Color.rgb(220, 220, 220));
na1.setStroke(Color.BLACK);
na1.setStrokeWidth(2);

Rectangle na2 = new Rectangle();
na2.setArcWidth(20);
na2.setArcHeight(20);
na2.setWidth(260);
na2.setHeight(30);
na2.setFill(Color.rgb(220, 220, 220));
na2.setStroke(Color.BLACK);
na2.setStrokeWidth(2);

Rectangle num1 = new Rectangle();
num1.setArcWidth(20);
num1.setArcHeight(20);
num1.setWidth(150);
num1.setHeight(30);
num1.setFill(Color.rgb(220, 220, 220));
num1.setStroke(Color.BLACK);
num1.setStrokeWidth(2);

Rectangle num2 = new Rectangle();
num2.setArcWidth(20);
num2.setArcHeight(20);
num2.setWidth(260);
num2.setHeight(30);
num2.setFill(Color.rgb(220, 220, 220));
num2.setStroke(Color.BLACK);
num2.setStrokeWidth(2);

infoPane.getChildren().add(id1);
infoPane.getChildren().add(id2);
infoPane.getChildren().add(em1);
infoPane.getChildren().add(em2);
infoPane.getChildren().add(na1);
infoPane.getChildren().add(na2);
infoPane.getChildren().add(num1);
infoPane.getChildren().add(num2);


//nodes    

Button btBack = new Button("Back");
Label laId = new Label("Student ID");
Label laName = new Label("Student Name");
Label laEmail = new Label("Student Email");
Label laNumber = new Label("Student Number");
Label stId = new Label(String.valueOf(student.getStudentID(StudentIndex)));
Label stName = new Label(student.getStudentName(StudentIndex));
Label stEmail = new Label(student.getStudentEmail(StudentIndex));
Label stNumber = new Label(student.getStudentContact(StudentIndex));



//btHandler
btBack.setOnAction(event -> {goBack(stScene);});



//pane
infoPane.getChildren().add(btBack);
infoPane.getChildren().add(laId);
infoPane.getChildren().add(laEmail);
infoPane.getChildren().add(laName);
infoPane.getChildren().add(laNumber);
infoPane.getChildren().add(stId);
infoPane.getChildren().add(stName);
infoPane.getChildren().add(stEmail);
infoPane.getChildren().add(stNumber);

//Style
 infoPane.getStyleClass().add("Mainbg");
    
    btBack.getStyleClass().add("btLogout");
    btBack.getStyleClass().add("btHover");
    btBack.getStyleClass().add("size");
    btBack.getStyleClass().add("x-pos");
    
    
    laId.getStyleClass().add("idH");
    laId.getStyleClass().add("size");
    laName.getStyleClass().add("NH");
    laName.getStyleClass().add("size");
    laEmail.getStyleClass().add("EH");
    laEmail.getStyleClass().add("size");
    laNumber.getStyleClass().add("NumH");
    
    
    stId.getStyleClass().add("idL");
    stId.getStyleClass().add("size");
    stName.getStyleClass().add("NL");
    stName.getStyleClass().add("size");
    stEmail.getStyleClass().add("EL");
    stEmail.getStyleClass().add("size");
    stNumber.getStyleClass().add("NumL");
    stNumber.getStyleClass().add("size");
    
    num1.getStyleClass().add("NumrH");
    na1.getStyleClass().add("NrH");
    em1.getStyleClass().add("ErH");
    id1.getStyleClass().add("idrH");
    
    num2.getStyleClass().add("NumrL");
    na2.getStyleClass().add("NrL");
    em2.getStyleClass().add("ErL");
    id2.getStyleClass().add("idrL");
    
    
    
    


//Stage and Scene
Scene infoScene = new Scene(infoPane,720,680);
infoScene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
mainStage.setScene(infoScene);
}

private void stAdd() {
    int StudentIndex = student.getStudentID().indexOf(ID);
    
    ArrayList<String> Courses = new ArrayList<>();
    ArrayList<String> temp = new ArrayList<>();
    Set<String> set = new HashSet<>(Courses);
    ArrayList<String> a = course.getCourseName();
   
    


    
    // Pane
    GridPane addpane = new GridPane();
   
    
    //dynaimc 
     Rectangle nameH = new Rectangle();
       nameH.setArcWidth(20);  
        nameH.setArcHeight(20);
        nameH.setWidth(200);
        nameH.setHeight(30);
        GridPane.setRowIndex(nameH,0);
        addpane.getChildren().add(nameH);
        nameH.setFill(Color.rgb(220, 220, 220));
        nameH.setStroke(Color.BLACK);
        nameH.setStrokeWidth(2);
    int r =0 ;
    //dyinamic data
    for (int i = 1 ; i <= a.size();i++){
        Rectangle name = new Rectangle();
        name.setArcWidth(20);  
        name.setArcHeight(20);
        name.setWidth(200);
        name.setHeight(30);
        name.setLayoutY(r); 
        name.setLayoutX(0);
        name.setFill(Color.rgb(220, 220, 220));
        name.setStroke(Color.BLACK);
        name.setStrokeWidth(2);
        
        Rectangle code = new Rectangle();
        code.setArcWidth(20);  
        code.setArcHeight(20);
        code.setWidth(50);
        code.setHeight(30);
        code.setFill(Color.rgb(220, 220, 220));
        code.setStroke(Color.BLACK);
        code.setStrokeWidth(2);
        
        StackPane stackPane = new StackPane(name);
        StackPane stackPane1 = new StackPane(code);
        stackPane.setStyle("-fx-translate-y:"+r+";");
        stackPane1.setStyle("-fx-translate-y:"+r+";");
//        stackPane1.setStyle("-fx-translate-x:250;");
        GridPane.setRowIndex(stackPane,80);
        GridPane.setRowIndex(stackPane1,80);
        GridPane.setColumnIndex(stackPane1, 80);

        addpane.getChildren().add(stackPane);
        addpane.getChildren().add(stackPane1);
        
        
        r-=30;
    }
    r=0;
    
     //Nodes
    Button btAdd = new Button("Add");
    Button btBack = new Button("Back");
    TextField CsCode = new TextField();
    Label CourseCode = new Label("Course Code");
    Label CoursesCode = new Label(listToStringI(course.getCourseCode()));
    Label CourseName = new Label("Course Name");
    Label CoursesName = new Label(listToStringS(course.getCourseName()));
    


    // BtHandler
    btBack.setOnAction(event -> { Courses.clear(); temp.addAll(set); student.setCourses(StudentIndex, temp);goBack(stScene);});
    
    btAdd.setOnAction(event -> {
        String Text = CsCode.getText();
        int CsInt = Integer.parseInt(Text);
        this.CsInt = CsInt;
       int CsIndex = course.getCourseCode().indexOf(CsInt);
        System.out.println(CsIndex);
       
            
            Courses.add(course.getCourseName(CsIndex));
            if(set.contains(course.getCourseName(CsIndex))){showMessage("already been added");}
            else{
            set.addAll(Courses);
            }
            
    });
    
    //pane
     addpane.getChildren().add(btBack);
    addpane.getChildren().add(btAdd);
    addpane.getChildren().add(CourseCode);
    addpane.getChildren().add(CoursesCode);
    addpane.getChildren().add(CourseName);
    addpane.getChildren().add(CoursesName);
    addpane.getChildren().add(CsCode);
    addpane.setAlignment(Pos.CENTER);
    GridPane.setConstraints(CourseName, 0, 0);
    GridPane.setConstraints(CourseCode, 0, 0);
    
    
    GridPane.setConstraints(CoursesName, 0, 1);
    GridPane.setConstraints(CoursesCode, 0, 1);
    GridPane.setConstraints(CsCode, 0, 2);
    GridPane.setConstraints(btAdd, 0, 3);
    GridPane.setConstraints(btBack, 0, 4);
// 


    
    // Style 
    addpane.getStyleClass().add("Mainbg");
    
    
    btBack.getStyleClass().add("btLogout");
    btBack.getStyleClass().add("x-pos2");
    btBack.getStyleClass().add("btHover");
    btBack.getStyleClass().add("size");
    
    btAdd.getStyleClass().add("btHover");
    btAdd.getStyleClass().add("btAdd");
    btAdd.getStyleClass().add("size");
    btAdd.getStyleClass().add("btGen");
    
    CsCode.getStyleClass().add("add-field");
    CourseCode.getStyleClass().add("dynamic-header2");
    CoursesCode.getStyleClass().add("dynamic-element2");
    CoursesName.getStyleClass().add("dynamic-element");
    CourseName.getStyleClass().add("dynamic-header");


    // Stage and Scene
  
    Scene addscene = new Scene(addpane,720,680);
    addscene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
    mainStage.setScene(addscene);
    

    
    
}

private void stShow(){
    
    int StudentIndex = student.getStudentID().indexOf(ID);
    try{
    ArrayList<String> a = student.getCourses(StudentIndex);
    String coursesname = listToStringS(student.getCourses(StudentIndex));

    //Pane
    GridPane showPane = new GridPane();
    
    Rectangle Header = new Rectangle();
        Header.setArcWidth(20);  
        Header.setArcHeight(20);
        Header.setWidth(200);
        Header.setHeight(30);
        GridPane.setRowIndex(Header,0);
        showPane.getChildren().add(Header);
        Header.setFill(Color.rgb(220, 220, 220));
        Header.setStroke(Color.BLACK);
        Header.setStrokeWidth(2);
    
    
    int r =0 ;
    //dyinamic data
    for (int i = 1 ; i <= a.size();i++){
        Rectangle name = new Rectangle();
        name.setArcWidth(20);  
        name.setArcHeight(20);
        name.setWidth(200);
        name.setHeight(30);
        name.setLayoutY(r); 
        name.setLayoutX(0);
        name.setFill(Color.rgb(220, 220, 220));
        name.setStroke(Color.BLACK);
        name.setStrokeWidth(2);
        
        
        StackPane stackPane = new StackPane(name);
        stackPane.setStyle("-fx-translate-y:"+r+";");
         GridPane.setRowIndex(stackPane,80);
        showPane.getChildren().add(stackPane);
        
        
        r-=30;
    }
    r=0;

    //nodes
    Button btBack = new Button("Back");
    Label courseName = new Label("Course Name");
    Label coursesName = new Label (coursesname);

    //btHandler
    btBack.setOnAction(event -> {goBack(stScene);});

    
    //style
    showPane.getStyleClass().add("Mainbg");
    
    btBack.getStyleClass().add("btLogout");
    btBack.getStyleClass().add("btHover");
    btBack.getStyleClass().add("size");
    btBack.getStyleClass().add("x-pos");
    
    courseName.getStyleClass().add("dynamic-header");
    coursesName.getStyleClass().add("dynamic-element1");
    //pane con
    showPane.getChildren().add(btBack);
 
    showPane.getChildren().add(courseName);
    showPane.getChildren().add(coursesName);
    showPane.setAlignment(Pos.CENTER);
    GridPane.setConstraints(courseName, 0, 0);
    GridPane.setConstraints(coursesName, 0, 1);
   
        GridPane.setConstraints(btBack, 0, 4);
//    GridPane.setConstraints(coursesName, 0, 5);

    //Stage and Scene
    Scene showScene = new Scene(showPane,720,680);
    mainStage.setScene(showScene);
    showScene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());



} catch(java.lang.IndexOutOfBoundsException ex){ 
    showMessage("There is No Course Applied");
   }
    catch(java.lang.NullPointerException ex){
        showMessage("There is No Course Applied");}

}
        

private void goBack(Scene prev) {
    mainStage.setScene(prev);
    }

private void adminPage(){
//pane
GridPane adminPane = new GridPane();
adminPane.setAlignment(Pos.CENTER);

//nodes
Button btStudent = new Button("Sign-Up Students");
Button btCourse = new Button("Sign Courses");
Button btFaculty = new Button("Sign-Up Faculty Member");
Button btLogout = new Button("Logout");
Label welcome = new Label("Welcome Admin");
//pane chileds
adminPane.getChildren().add(btCourse);
adminPane.getChildren().add(btStudent);
adminPane.getChildren().add(btFaculty);
adminPane.getChildren().add(btLogout);
adminPane.getChildren().add(welcome);

        GridPane.setConstraints(btLogout, 0, 0);
        GridPane.setConstraints(btStudent, 0, 1);
        GridPane.setConstraints(btCourse, 0, 3);
        GridPane.setConstraints(btFaculty, 0, 5);
        GridPane.setConstraints(welcome, 0, 0);
      
//btHandler
btLogout.setOnAction(event -> {goBack(mainScene);});
btStudent.setOnAction(event -> {adminStudent();});
btCourse.setOnAction(event -> {adminCourses();});
btFaculty.setOnAction(event -> {adminFaculty();});
//Styles
adminPane.getStyleClass().add("Mainbg");

btLogout.getStyleClass().addAll("btLogout","btHover","size","admin");


welcome.getStyleClass().add("Header");
welcome.getStyleClass().add("admin");

btStudent.getStyleClass().addAll("bt1","btGen","size","btHover","admin");
btCourse.getStyleClass().addAll("bt2","btGen","size","btHover","admin");
btFaculty.getStyleClass().addAll("bt3","btGen","size","btHover","admin");

//stage and Scenes
Scene adminScene = new Scene(adminPane,720,680);
adminScene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
this.adminScene=adminScene;
mainStage.setScene(adminScene);
}


private void facPage(){
//pane
GridPane facPane = new GridPane();
//nodes
Button btInfo = new Button("info");
Button btLogout = new Button("Logout");
//btHandler
btLogout.setOnAction(event -> {goBack(mainScene);});
btInfo.setOnAction(event -> {facInfo();});
//pane con
facPane.getChildren().addAll(btInfo,btLogout);
facPane.setAlignment(Pos.CENTER);
GridPane.setConstraints(btInfo, 0, 0);
GridPane.setConstraints(btLogout, 1, 0);
//styles
facPane.getStyleClass().addAll("Mainbg");

btInfo.getStyleClass().addAll("bt1","btHover","size","btGen","btInfo");
btLogout.getStyleClass().addAll("btLogout","btHover","size","facBack");
//stage and Sence
Scene facScene = new Scene(facPane,720,680);
facScene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
this.facScene =facScene;
mainStage.setScene(facScene);

}

private void facInfo(){
int facIndex = facultyMember.getStaffID().indexOf(ID);

    




//Pane
GridPane infoPane = new GridPane();
infoPane.setAlignment(Pos.CENTER);


//rectangels
Rectangle id1 = new Rectangle();
id1.setArcWidth(20);
id1.setArcHeight(20);
id1.setWidth(150);
id1.setHeight(30);
id1.setFill(Color.rgb(220, 220, 220));
id1.setStroke(Color.BLACK);
id1.setStrokeWidth(2);

Rectangle id2 = new Rectangle();
id2.setArcWidth(20);
id2.setArcHeight(20);
id2.setWidth(260);
id2.setHeight(30);
id2.setFill(Color.rgb(220, 220, 220));
id2.setStroke(Color.BLACK);
id2.setStrokeWidth(2);

Rectangle em1 = new Rectangle();
em1.setArcWidth(20);
em1.setArcHeight(20);
em1.setWidth(150);
em1.setHeight(30);
em1.setFill(Color.rgb(220, 220, 220));
em1.setStroke(Color.BLACK);
em1.setStrokeWidth(2);

Rectangle em2 = new Rectangle();
em2.setArcWidth(20);
em2.setArcHeight(20);
em2.setWidth(260);
em2.setHeight(30);
em2.setFill(Color.rgb(220, 220, 220));
em2.setStroke(Color.BLACK);
em2.setStrokeWidth(2);

Rectangle na1 = new Rectangle();
na1.setArcWidth(20);
na1.setArcHeight(20);
na1.setWidth(150);
na1.setHeight(30);
na1.setFill(Color.rgb(220, 220, 220));
na1.setStroke(Color.BLACK);
na1.setStrokeWidth(2);

Rectangle na2 = new Rectangle();
na2.setArcWidth(20);
na2.setArcHeight(20);
na2.setWidth(260);
na2.setHeight(30);
na2.setFill(Color.rgb(220, 220, 220));
na2.setStroke(Color.BLACK);
na2.setStrokeWidth(2);

Rectangle num1 = new Rectangle();
num1.setArcWidth(20);
num1.setArcHeight(20);
num1.setWidth(150);
num1.setHeight(30);
num1.setFill(Color.rgb(220, 220, 220));
num1.setStroke(Color.BLACK);
num1.setStrokeWidth(2);

Rectangle num2 = new Rectangle();
num2.setArcWidth(20);
num2.setArcHeight(20);
num2.setWidth(260);
num2.setHeight(30);
num2.setFill(Color.rgb(220, 220, 220));
num2.setStroke(Color.BLACK);
num2.setStrokeWidth(2);

infoPane.getChildren().add(id1);
infoPane.getChildren().add(id2);
infoPane.getChildren().add(em1);
infoPane.getChildren().add(em2);
infoPane.getChildren().add(na1);
infoPane.getChildren().add(na2);
infoPane.getChildren().add(num1);
infoPane.getChildren().add(num2);


//nodes    

Button btBack = new Button("Back");
Label laId = new Label("ID");
Label laName = new Label("First Name");
Label laEmail = new Label("Email");
Label laNumber = new Label("Number");
Label stId = new Label(String.valueOf(facultyMember.getStaffID(facIndex)));
Label stName = new Label(facultyMember.getStaffFirstName(facIndex));
Label stEmail = new Label(facultyMember.getEmailID(facIndex));
Label stNumber = new Label(facultyMember.getContactNumber(facIndex));



//btHandler
btBack.setOnAction(event -> {goBack(facScene);});



//pane
infoPane.getChildren().add(btBack);
infoPane.getChildren().add(laId);
infoPane.getChildren().add(laEmail);
infoPane.getChildren().add(laName);
infoPane.getChildren().add(laNumber);
infoPane.getChildren().add(stId);
infoPane.getChildren().add(stName);
infoPane.getChildren().add(stEmail);
infoPane.getChildren().add(stNumber);

//Style
 infoPane.getStyleClass().add("Mainbg");
    
    btBack.getStyleClass().add("btLogout");
    btBack.getStyleClass().add("btHover");
    btBack.getStyleClass().add("size");
    btBack.getStyleClass().add("x-pos");
    
    
    laId.getStyleClass().add("idH");
    laId.getStyleClass().add("size");
    laName.getStyleClass().add("NH");
    laName.getStyleClass().add("size");
    laEmail.getStyleClass().add("EH");
    laEmail.getStyleClass().add("size");
    laNumber.getStyleClass().add("NumH");
    
    
    stId.getStyleClass().add("idL");
    stId.getStyleClass().add("size");
    stName.getStyleClass().add("NL");
    stName.getStyleClass().add("size");
    stEmail.getStyleClass().add("EL");
    stEmail.getStyleClass().add("size");
    stNumber.getStyleClass().add("NumL");
    stNumber.getStyleClass().add("size");
    
    num1.getStyleClass().add("NumrH");
    na1.getStyleClass().add("NrH");
    em1.getStyleClass().add("ErH");
    id1.getStyleClass().add("idrH");
    
    num2.getStyleClass().add("NumrL");
    na2.getStyleClass().add("NrL");
    em2.getStyleClass().add("ErL");
    id2.getStyleClass().add("idrL");
    
    
    
    


//Stage and Scene
Scene infoScene = new Scene(infoPane,720,680);
infoScene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
mainStage.setScene(infoScene);
}

private void adminStudent(){
    
    //Pane
    GridPane adstPane = new GridPane();
    
    //Nodes
    Button btAdd = new Button("Add");
    Button btBack = new Button("Back");
    TextField studentID = new TextField();
    TextField studentName = new TextField();
    TextField studentEmail = new TextField();
    TextField studentContact = new TextField();
    Label lbStudentID = new Label("Student ID");
    Label lbStudentName = new Label("Student Name");
    Label lbStudentEmail = new Label("Student Email");
    Label lbStudentContact = new Label("Student Contact");
    
    //btHandler
    btBack.setOnAction(event -> {goBack(adminScene);});
    btAdd.setOnAction(event -> {
        int text1 = Integer.parseInt(studentID.getText());
        String text2 = studentName.getText();
        String text3 = studentEmail.getText();
        String text4 = studentContact.getText();
        
        if(student.getStudentID().contains(text1)){showMessage("the ID is already in use");}
        else if(student.getStudentID().contains(text2)&&student.getStudentName().contains(text1)){showMessage("the ID and the name is already in use");}
        else
        {
        student.addStudentID(text1);
        student.setStudentName(text2);
        student.setStudentEmail(text3);
        student.setStudentContact(text4);
        }
    });
    
    //Styles
    adstPane.getStyleClass().add("Mainbg");
    
    btBack.getStyleClass().addAll("btLogout","btHover","x-pos","size");
    btAdd.getStyleClass().addAll("btAdd","btHover","size","btGen");
    
    //Pane continue
    adstPane.getChildren().addAll(btAdd, btBack, studentID, studentName, studentEmail, studentContact, lbStudentID, lbStudentName, lbStudentEmail, lbStudentContact);
    GridPane.setConstraints(studentID, 3, 0);
    GridPane.setConstraints(studentName, 3, 1);
    GridPane.setConstraints(studentEmail, 3, 2);
    GridPane.setConstraints(studentContact, 3, 3);
    GridPane.setConstraints(lbStudentID, 0, 0);
    GridPane.setConstraints(lbStudentName, 0, 1);
    GridPane.setConstraints(lbStudentEmail, 0, 2);
    GridPane.setConstraints(lbStudentContact, 0, 3);
    GridPane.setConstraints(btBack, 3,0);
    adstPane.setAlignment(Pos.CENTER);
    
    //Stage and Scenes
    Scene adstScene = new Scene(adstPane, 720, 680);
    adstScene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
    mainStage.setScene(adstScene);
}
private void adminCourses(){
    
    //Pane
    GridPane adcoPane = new GridPane();
    
    //Nodes
    Button btAdd = new Button("Add");
    Button btBack = new Button("Back");
    TextField courseName = new TextField();
    TextField courseCode = new TextField();
    TextField courseHours = new TextField();
    Label lbCourseName = new Label("Course Name");
    Label lbCourseCode = new Label("Course Code");
    Label lbCourseHours = new Label("Course Hours");
    
    //btHandler
        btBack.setOnAction(event -> {goBack(adminScene);});
        btAdd.setOnAction(event -> {
        String text1 = courseName.getText();
        int text2 = Integer.parseInt(courseCode.getText());
        int text3 = Integer.parseInt(courseHours.getText());
        if(course.getCourseName().contains(text1) ||course.getCourseCode().contains(text2) ){showMessage("the course name or the code are in use");}
        else{
        course.setCourseName(text1);
        course.setCourseCode(text2);
        course.setCreditHours(text3);
        }
        });
    
    //Styles
    adcoPane.getStyleClass().add("Mainbg");
    
    btBack.getStyleClass().addAll("btLogout","btHover","x-pos","size");
    btAdd.getStyleClass().addAll("btAdd","btHover","size","btGen");
    
    //Pane Continue
    adcoPane.getChildren().addAll(btAdd, btBack, courseName, courseCode, courseHours, lbCourseName, lbCourseCode, lbCourseHours);
    GridPane.setConstraints(courseName, 3, 0);
    GridPane.setConstraints(courseCode, 3, 1);
    GridPane.setConstraints(courseHours, 3, 2);
    GridPane.setConstraints(lbCourseName, 0, 0);
    GridPane.setConstraints(lbCourseCode, 0, 1);
    GridPane.setConstraints(lbCourseHours, 0, 2);
    GridPane.setConstraints(btBack, 3,0);
    adcoPane.setAlignment(Pos.CENTER);
    
    //Stage and Scenes
    Scene adstScene = new Scene(adcoPane, 720, 680);
    adstScene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
    mainStage.setScene(adstScene);
}

private void adminFaculty(){
    
    //Pane
    GridPane adfaPane = new GridPane();
    
    //Nodes
    Button btAdd = new Button("Add");
    Button btBack = new Button("Back");
    TextField staffID = new TextField();
    TextField staffFirstName = new TextField();
    TextField staffLastName = new TextField();
    TextField contactNumber = new TextField();
    TextField staffAdress = new TextField();
    TextField academicRank = new TextField();
    TextField emailID = new TextField();
    TextField academicSpecialty = new TextField();
    Label lbStaffID = new Label("Staff ID");
    Label lbStaffFirstName = new Label("Staff Name");
    Label lbStaffLastName = new Label("Staff Last Name");
    Label lbContactNumber = new Label("Contact Number");
    Label lbStaffAdress = new Label("Staff Adress");
    Label lbAcademicRank = new Label("Academic Rank");
    Label lbEmailID = new Label("Email ID");
    Label lbAcademicSpecialty = new Label("Academic Specialty");


    //abtHandler
    btBack.setOnAction(event -> {goBack(adminScene);});
    btAdd.setOnAction(event -> {
        int text1 = Integer.parseInt(staffID.getText());
        String text2 = staffFirstName.getText();
        String text3 = staffLastName.getText();
        String text4 = contactNumber.getText();
        String text5 = staffAdress.getText();
        char text6 = academicRank.getText().charAt(0);
        String text7 = emailID.getText();
        String text8 = academicSpecialty.getText();
        
        facultyMember.setStaffID(text1);
        facultyMember.setStaffFirstName(text2);
        facultyMember.setStaffLastName(text3);
        facultyMember.setContactNumber(text4);
        facultyMember.setStaffAddress(text5);
        facultyMember.setAcademicRank(text6);
        facultyMember.setEmailID(text7);
        facultyMember.setAcademicSpecialty(text8);
    });
    
    //Styles
    adfaPane.getStyleClass().add("Mainbg");
    
    btBack.getStyleClass().addAll("btLogout","btHover","x-pos","size","btadmin");
    btAdd.getStyleClass().addAll("btAdd","btHover","size","btGen","btadmin");
    
    //Pane Continue
    adfaPane.getChildren().addAll(btAdd, btBack, staffID, staffFirstName, staffLastName, contactNumber, staffAdress, academicRank, emailID, academicSpecialty, lbStaffID, lbStaffFirstName, 
    lbStaffLastName, lbContactNumber, lbStaffAdress, lbAcademicRank, lbEmailID, lbAcademicSpecialty);
    GridPane.setConstraints(staffID, 3, 0);
    GridPane.setConstraints(staffFirstName, 3, 1);
    GridPane.setConstraints(staffLastName, 3, 2);
    GridPane.setConstraints(contactNumber, 3, 3);
    GridPane.setConstraints(staffAdress, 3, 4);
    GridPane.setConstraints(academicRank, 3, 5);
    GridPane.setConstraints(emailID, 3, 6);
    GridPane.setConstraints(academicSpecialty, 3, 7);
    GridPane.setConstraints(lbStaffID, 0, 0);
    GridPane.setConstraints(lbStaffFirstName, 0, 1);
    GridPane.setConstraints(lbStaffLastName, 0, 2);
    GridPane.setConstraints(lbContactNumber, 0, 3);
    GridPane.setConstraints(lbStaffAdress, 0, 4);
    GridPane.setConstraints(lbAcademicRank, 0, 5);
    GridPane.setConstraints(lbEmailID, 0, 6);
    GridPane.setConstraints(lbAcademicSpecialty, 0, 7);
    GridPane.setConstraints(btBack, 3,0);
    adfaPane.setAlignment(Pos.CENTER);
    
    //Stage and Scenes
    Scene adfaScene = new Scene(adfaPane, 720, 680);
    adfaScene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
    mainStage.setScene(adfaScene);
    
}


private String getWelcome(Student ob , int id){
   int Index = ob.getStudentID().indexOf(id);
return "Hello "+ob.getStudentName(Index) +" Welcome !!";
}


private String listToStringS(ArrayList<String> list) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append("\n");
            }
        }
        
        return sb.toString();
    }

private String listToStringI(ArrayList<Integer> list) {
        StringBuilder sb = new StringBuilder();
       
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append("\n");
            }
        }
        
        return sb.toString();
    }


  

    public static void main(String[] args) {
        launch(args);
    }
        
        
    }


