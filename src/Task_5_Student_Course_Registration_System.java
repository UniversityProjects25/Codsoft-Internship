import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private int enrolled;

    public Course(String code, String title, String description, int capacity) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.enrolled = 0;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getEnrolled() {
        return enrolled;
    }

    public void enrollStudent() {
        enrolled++;
    }

    public void dropStudent() {
        enrolled--;
    }

    public boolean isFull() {
        return enrolled >= capacity;
    }

    @Override
    public String toString() {
        return "Course Code: " + code + "\nTitle: " + title + "\nDescription: " + description + "\nEnrolled/Total Capacity: " + enrolled + "/" + capacity;
    }
}

class Student {
    private String studentID;
    private String name;
    private List<Course> registeredCourses;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        if (!registeredCourses.contains(course)) {
            registeredCourses.add(course);
            course.enrollStudent();
            System.out.println("Successfully registered for course: " + course.getTitle());
        } else {
            System.out.println("Already registered for this course.");
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            registeredCourses.remove(course);
            course.dropStudent();
            System.out.println("Successfully dropped course: " + course.getTitle());
        } else {
            System.out.println("Not registered for this course.");
        }
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID + "\nName: " + name;
    }
}

public class Task_5_Student_Course_Registration_System {
    private List<Course> courses;
    private List<Student> students;

    public Task_5_Student_Course_Registration_System() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayAvailableCourses() {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            if (!course.isFull()) {
                System.out.println(course);
            }
        }
    }

    public static void main(String[] args) {
        Task_5_Student_Course_Registration_System system = new Task_5_Student_Course_Registration_System();

        // Sample Courses
        Course c1 = new Course("CSE101", "Introduction to Computer Science", "An introduction to the basics of computer science", 50);
        Course c2 = new Course("ENG201", "English Literature", "Study of classic literature", 40);

        // Adding Courses to the system
        system.addCourse(c1);
        system.addCourse(c2);

        // Sample Students
        Student s1 = new Student("1001", "Indra");
        Student s2 = new Student("1002", "Jeet");

        // Adding Students to the system
        system.addStudent(s1);
        system.addStudent(s2);

        // Displaying available courses
        system.displayAvailableCourses();

        // Registering courses for students
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter student ID to register for course:");
        String studentID = scanner.nextLine();

        System.out.println("Enter course code to register:");
        String courseCode = scanner.nextLine();

        Student student = system.findStudentByID(studentID);
        Course selectedCourse = system.findCourseByCode(courseCode);

        if (student != null && selectedCourse != null) {
            student.registerCourse(selectedCourse);
        } else {
            System.out.println("Invalid student ID or course code.");
        }

        // Displaying registered courses for students
        System.out.println("Registered courses for " + s1.getName() + ":");
        for (Course course : s1.getRegisteredCourses()) {
            System.out.println(course.getTitle());
        }

        System.out.println("Registered courses for " + s2.getName() + ":");
        for (Course course : s2.getRegisteredCourses()) {
            System.out.println(course.getTitle());
        }

        // Dropping a course
        System.out.println("Enter student ID to drop course:");
        studentID = scanner.nextLine();

        System.out.println("Enter course code to drop:");
        courseCode = scanner.nextLine();

        student = system.findStudentByID(studentID);
        selectedCourse = system.findCourseByCode(courseCode);

        if (student != null && selectedCourse != null) {
            student.dropCourse(selectedCourse);
        } else {
            System.out.println("Invalid student ID or course code.");
        }
    }

    private Student findStudentByID(String studentID) {
        for (Student student : students) {
            if (student.getStudentID().equals(studentID)) {
                return student;
            }
        }
        return null;
    }

    private Course findCourseByCode(String courseCode) {
        for (Course course : courses) {
            if (course.getCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }
}
