package Api.StudentApi.exceptions;

public class StudentAlreadyEnrolled extends Exception {

    public StudentAlreadyEnrolled() {
        super("Student already enrolled");
    }
}

