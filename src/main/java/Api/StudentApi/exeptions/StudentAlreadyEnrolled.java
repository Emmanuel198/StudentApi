package Api.StudentApi.exeptions;

public class StudentAlreadyEnrolled extends Exception {

    public StudentAlreadyEnrolled() {
        super("Student already enrolled");
    }
}

