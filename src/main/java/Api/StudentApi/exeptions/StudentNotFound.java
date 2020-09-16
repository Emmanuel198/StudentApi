package Api.StudentApi.exeptions;

public class StudentNotFound extends RuntimeException {

    public StudentNotFound(){
        super("Student not found");
    }
}

