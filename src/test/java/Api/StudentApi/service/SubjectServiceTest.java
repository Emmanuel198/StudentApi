package Api.StudentApi.service;

import Api.StudentApi.entities.SubjectEntity;
import Api.StudentApi.exeptions.SubjectNotFound;
import Api.StudentApi.mappers.SubjectMapper;
import Api.StudentApi.models.Subject;
import Api.StudentApi.repository.SubjectRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class SubjectServiceTest {

    @Mock
    SubjectMapper subjectMapper;
    @Mock
    SubjectRepository repository;
    @InjectMocks
    SubjectService subjectService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    void testGetSubjectById() throws SubjectNotFound {
        Long id = 1L;
        String subject = "test-name";

        Subject subject1 = new Subject();
        subject1.setId(id);
        subject1.setSubject(subject);

        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setId(id);
        subjectEntity.setSubject(subject);


        when(subjectMapper.map(any(SubjectEntity.class))).thenReturn(subject1);
        when(repository.findById(id)).thenReturn(Optional.of(subjectEntity));

        Subject resultStudent = subjectService.getSubjectById(id);

        Assertions.assertEquals(id, resultStudent.getId());
        Assertions.assertEquals(subject, resultStudent.getSubject());
    }

    @Test
    void testGetSubjectByIdException() {
        Long id = 1L;

        when(repository.findById(id)).thenReturn(Optional.empty());

        try {
            subjectService.getSubjectById(id);
        } catch (SubjectNotFound e) {
            Assert.assertTrue(true);
            return;
        }
        Assert.fail();
    }

    @Test
    void testCreateSubject() {
        Long id = 1L;

        Subject subject = new Subject();
        subject.setId(id);

        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setId(id);

        when(subjectMapper.map(any(Subject.class))).thenReturn(subjectEntity);
        when(repository.save(any())).thenReturn(subjectEntity);

        Long resultId = subjectService.createSubject(subject);

        Assertions.assertEquals(id, resultId);
    }

    @Test
    void testFindAllSubjects() {

        Long id = 1L;
        String subject = "test-name";

        Subject subject1 = new Subject();
        subject1.setId(id);
        subject1.setSubject(subject);

        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setId(id);
        subjectEntity.setSubject(subject);

        List<SubjectEntity> subjectEntityList = new ArrayList<>();
        subjectEntityList.add(subjectEntity);

        List<Subject> subjectList = new ArrayList<>();
        subjectList.add(subject1);

        when(subjectMapper.map(any(ArrayList.class))).thenReturn(subjectList);
        when(repository.findAll()).thenReturn(subjectEntityList);

        List<Subject> result = subjectService.findAllSubject();

        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(subject1.getId(), result.get(0).getId());
        Assertions.assertEquals(subject1.getSubject(), result.get(0).getSubject());
    }


    @Test
    void testDeleteStudentById() throws SubjectNotFound {

        Long id = 1L;
        String subject = "test-name";

        Subject subject1 = new Subject();
        subject1.setId(id);
        subject1.setSubject(subject);

        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setId(id);
        subjectEntity.setSubject(subject);

        when(subjectMapper.map(any(SubjectEntity.class))).thenReturn(subject1);
        when(repository.findById(id)).thenReturn(Optional.of(subjectEntity));

        subjectService.deleteSubjectById(1L);
    }

    @Test
    void testDeleteStudentByIdException() {
        Long id = 1L;

        when(repository.findById(id)).thenReturn(Optional.empty());

        try {
            subjectService.deleteSubjectById(id);
        } catch (SubjectNotFound e) {
            Assert.assertTrue(true);
            return;
        }
        Assert.fail();
    }

}