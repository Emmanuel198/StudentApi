package Api.StudentApi.service;

import Api.StudentApi.exceptions.StudentAlreadyEnrolled;
import Api.StudentApi.exceptions.StudentNotFound;
import Api.StudentApi.exceptions.SubjectNotFound;
import Api.StudentApi.models.Student;
import Api.StudentApi.models.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class InscriptionService {

    @Autowired
    private StudentService studentService;
    @Autowired
    private SubjectService subjectService;

    public void createInscription(Long subjectId, Long studentId)
            throws StudentAlreadyEnrolled, StudentNotFound, SubjectNotFound {

        Subject subject = subjectService.getSubjectById(subjectId);
        Student student = studentService.getStudentById(studentId);

        if (student.getSubjects() == null) {
            student.setSubjects(new ArrayList<>());
        }

        for (Subject subjectItem : student.getSubjects()) {
            if (subjectItem.getId().equals(subjectId)) {
                throw new StudentAlreadyEnrolled();
            }
        }

        student.getSubjects().add(subject);
        studentService.updateStudent(student);
    }
}
