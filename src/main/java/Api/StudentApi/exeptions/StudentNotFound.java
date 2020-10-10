package Api.StudentApi.exeptions;

public class StudentNotFound extends Exception {

    public StudentNotFound() {
        super("Student not found");
    }
}

