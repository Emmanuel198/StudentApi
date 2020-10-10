package Api.StudentApi.service;

import Api.StudentApi.entities.StudentEntity;
import Api.StudentApi.entities.SubjectEntity;
import Api.StudentApi.mappers.StudentMapper;
import Api.StudentApi.mappers.SubjectMapper;
import Api.StudentApi.models.Student;
import Api.StudentApi.models.Subject;
import Api.StudentApi.repository.StudentRepository;
import Api.StudentApi.repository.SubjectRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class InscriptionServiceTest {

    @Mock
    SubjectMapper subjectMapper;
    @Mock
    StudentMapper studentMapper;
    @Mock
    StudentRepository studentRepository;
    @Mock
    SubjectRepository subjectRepository;
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

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(studentId);
        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setId(subjectId);

        when(subjectMapper.map(any(Subject.class))).thenReturn(subjectEntity);
        when(subjectRepository.save(any())).thenReturn(subjectEntity);
        when(studentMapper.map(any(Student.class))).thenReturn(studentEntity);
        when(studentRepository.save(any())).thenReturn(studentEntity);

        inscriptionService.createInscription(studentId, subjectId);

        Assertions.assertEquals(studentId, subjectId);


    }
}
