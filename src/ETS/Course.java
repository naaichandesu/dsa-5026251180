class Course {
    private String courseCode, title, instructor;
    private int creditHours;

    Course(String code, String title, String instructor, int creditHours){
        this.courseCode = code;
        this.title = title;
        this.instructor = instructor;
        this.creditHours = creditHours;
    }
    

    void startClas(){
        System.out.println("The course " + title + "is now starting tasks.");
    }

    void endClass(){
        System.out.println("The course " + title + "is now ending taks.");
    }

    void assignTask(){
        System.out.println("The course " + title + "is now assigning tasks.");
    }

    void displayInfo(){
        System.out.println("Course code : " +courseCode);
        System.out.println("Title : " + title);
        System.out.println("Instructor: " + instructor);
        System.out.println("Credit hours : " + creditHours);
    }
}

class OnlineCourse extends Course{
    String platform;

    OnlineCourse(String code, String title, String instructor, int creditHours, String platform){
        super(code, title, instructor, creditHours);
        this.platform = platform;
    }

    void connectTopPlatform(){
        System.out.println("The online course " + title + "is connecting to " + platform);
    }

    void displayInfo(){
        super.displayInfo();
        System.out.println("Platform name: " + platform);
    }
}

class OfflineCourse extends Course{
    String roomNumber;
}


