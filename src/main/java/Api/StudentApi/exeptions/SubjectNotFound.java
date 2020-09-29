package Api.StudentApi.exeptions;

public class SubjectNotFound extends RuntimeException {

    public SubjectNotFound() {
        super("Subject not found");
    }
}
