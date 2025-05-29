class Course {
    String courseName;
    int marks;

    Course(String courseName, int marks) {
        this.courseName = courseName;
        this.marks = marks;
    }
}

class Student {
    String name;
    String program;
    int semester;
    Course[] courses;
    int courseCount;

    Student(String name, String program, int semester) {
        this.name = name;
        this.program = program;
        this.semester = semester;
        this.courses = new Course[10]; // Max 10 courses
        this.courseCount = 0;
    }

    void registerCourse(Course course) {
        if (courseCount < courses.length) {
            courses[courseCount] = course;
            courseCount++;
        }
    }

    void printStudentInfo() {
        System.out.println("Name: " + name);
        System.out.println("Program: " + program);
        System.out.println("Semester: " + semester);
        System.out.println("Courses Registered:");
        for (int i = 0; i < courseCount; i++) {
            System.out.println(" - " + courses[i].courseName);
        }
    }

    void printFailedCourses() {
        System.out.println("Courses with marks < 40:");
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].marks < 40) {
                System.out.println(" - " + courses[i].courseName + ": " + courses[i].marks);
            }
        }
    }
}

public class StudentCourseApp {
    public static void main(String[] args) {
        Student s1 = new Student("Alice", "BSc Computer Science", 2);
        s1.registerCourse(new Course("Math", 35));
        s1.registerCourse(new Course("Python", 75));
        s1.registerCourse(new Course("Data Structures", 38));

        Student s2 = new Student("Bob", "BSc Mathematics", 1);
        s2.registerCourse(new Course("Algebra", 90));
        s2.registerCourse(new Course("Statistics", 25));

        System.out.println("=== Student 1 Information ===");
        s1.printStudentInfo();
        s1.printFailedCourses();

        System.out.println("\n=== Student 2 Information ===");
        s2.printStudentInfo();
        s2.printFailedCourses();
    }
}