import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    public abstract String getRoleName();
}

class SoftwareEngineer extends JobRole {
    public String getRoleName() { return "Software Engineer"; }
}

class DataScientist extends JobRole {
    public String getRoleName() { return "Data Scientist"; }
}

class ProductManager extends JobRole {
    public String getRoleName() { return "Product Manager"; }
}

class Resume<T extends JobRole> {
    private String applicantName;
    private T jobRole;
    public Resume(String applicantName, T jobRole) {
        this.applicantName = applicantName;
        this.jobRole = jobRole;
    }
    public String getApplicantName() { return applicantName; }
    public T getJobRole() { return jobRole; }
    public String toString() { return applicantName + " - " + jobRole.getRoleName(); }
}

class ResumeScreeningUtils {
    public static void screenResumes(List<? extends Resume<? extends JobRole>> resumes) {
        for (Resume<? extends JobRole> resume : resumes) {
            System.out.println("Screening Resume for: " + resume.getJobRole().getRoleName());
        }
    }
    public static <T extends JobRole> void processResume(Resume<T> resume) {
        System.out.println("Processing resume of " + resume.getApplicantName() + " for " + resume.getJobRole().getRoleName());
    }
}

public class ResumeScreeningSystem {
    public static void main(String[] args) {
        List<Resume<? extends JobRole>> resumes = new ArrayList<>();
        Resume<SoftwareEngineer> softwareEngineerResume = new Resume<>("John Doe", new SoftwareEngineer());
        Resume<DataScientist> dataScientistResume = new Resume<>("Jane Smith", new DataScientist());
        Resume<ProductManager> productManagerResume = new Resume<>("Mike Johnson", new ProductManager());
        resumes.add(softwareEngineerResume);
        resumes.add(dataScientistResume);
        resumes.add(productManagerResume);
        ResumeScreeningUtils.screenResumes(resumes);
        for (Resume<? extends JobRole> resume : resumes) {
            ResumeScreeningUtils.processResume(resume);
        }
    }
}