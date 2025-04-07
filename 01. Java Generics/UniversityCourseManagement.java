import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    public abstract String getType();
}

class ExamCourse extends CourseType {
    public String getType() { return "Exam-Based"; }
}

class AssignmentCourse extends CourseType {
    public String getType() { return "Assignment-Based"; }
}

class ResearchCourse extends CourseType {
    public String getType() { return "Research-Based"; }
}

class Course<T extends CourseType> {
    private String courseName;
    private T courseType;
    public Course(String courseName, T courseType) {
        this.courseName = courseName;
        this.courseType = courseType;
    }
    public String getCourseName() { return courseName; }
    public T getCourseType() { return courseType; }
    public String toString() { return courseName + " [" + courseType.getType() + "]"; }
}

class UniversityUtils {
    public static void displayCourses(List<? extends Course<? extends CourseType>> courses) {
        for (Course<? extends CourseType> course : courses) {
            System.out.println(course);
        }
    }
}

public class UniversityCourseManagement {
    public static void main(String[] args) {
        List<Course<? extends CourseType>> courseCatalog = new ArrayList<>();
        Course<ExamCourse> math = new Course<>("Mathematics", new ExamCourse());
        Course<AssignmentCourse> literature = new Course<>("English Literature", new AssignmentCourse());
        Course<ResearchCourse> thesis = new Course<>("Computer Science Research", new ResearchCourse());
        courseCatalog.add(math);
        courseCatalog.add(literature);
        courseCatalog.add(thesis);
        UniversityUtils.displayCourses(courseCatalog);
    }
}