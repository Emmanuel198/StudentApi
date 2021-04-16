package Api.StudentApi.service;

import Api.StudentApi.exceptions.StudentAlreadyEnrolled;
import Api.StudentApi.exceptions.StudentNotFound;
import Api.StudentApi.exceptions.SubjectNotFound;
import Api.StudentApi.models.Student;
import Api.StudentApi.models.Subject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class InscriptionServiceTest {

    @Mock
    StudentService studentService;
    @Mock
    SubjectService subjectService;
    @InjectMocks
    InscriptionService inscriptionService;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateInscription() throws Exception {

        Long subjectId = 1L;
        Long studentId = 2L;
        Student student = new Student();
        student.setId(studentId);
        Subject subject = new Subject();
        subject.setId(subjectId);
        when(subjectService.getSubjectById(subjectId)).thenReturn(subject);
        when(studentService.getStudentById(studentId)).thenReturn(student);

        inscriptionService.createInscription(subjectId, studentId);


        verify(subjectService, times(1)).getSubjectById(subjectId);
        verify(studentService, times(1)).getStudentById(studentId);
        verify(studentService, times(1)).updateStudent(any());
    }

    @Test
    public void testCreateInscriptionStudentAlreadyEnrolled() throws SubjectNotFound, StudentNotFound {

        Long subjectId = 1L;
        Long studentId = 2L;
        Student student = new Student();
        student.setId(studentId);

        Subject subject = new Subject();
        subject.setId(subjectId);

        List<Subject> subjects = new ArrayList<>();
        subjects.add(subject);
        student.setSubjects(subjects);

        when(subjectService.getSubjectById(subjectId)).thenReturn(subject);
        when(studentService.getStudentById(studentId)).thenReturn(student);

        try {
            inscriptionService.createInscription(subjectId, studentId);
        } catch (StudentAlreadyEnrolled studentAlreadyEnrolled) {
            Assert.assertTrue(true);
            return;
        }
        fail("StudentAlreadyEnrolled exception should be thrown");
    }
}
