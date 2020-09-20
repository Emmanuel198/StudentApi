package Api.StudentApi.service;

import Api.StudentApi.entities.StudentEntity;
import Api.StudentApi.exeptions.StudentNotFound;
import Api.StudentApi.mappers.StudentMapper;
import Api.StudentApi.models.Student;
import Api.StudentApi.repository.StudentRepository;
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

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class StudentServiceTest {
    @Mock
    StudentMapper studentMapper;
    @Mock
    StudentRepository repository;
    @InjectMocks
    StudentService studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetStudentById() {
        Long id = 1L;
        String name = "test-name";
        String surname = "test-surname";

        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setSurname(surname);

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(id);
        studentEntity.setName(name);
        studentEntity.setSurname(surname);

        when(studentMapper.map(any(StudentEntity.class))).thenReturn(student);
        when(repository.findById(id)).thenReturn(java.util.Optional.of(studentEntity));

        Student resultStudent = studentService.getStudentById(id);

        Assertions.assertEquals(id, resultStudent.getId());
        Assertions.assertEquals(name, resultStudent.getName());
        Assertions.assertEquals(surname, resultStudent.getSurname());
    }

    @Test
    void testGetStudentByIdException() {
        Long id = 1L;

        when(repository.findById(id)).thenReturn(Optional.empty());

        try {
            studentService.getStudentById(id);
        } catch (StudentNotFound e) {
            Assert.assertTrue(true);
            return;
        }
        Assert.fail();
    }

    @Test
    void testCreateStudent() {
        Long id = 1L;

        Student student = new Student();
        student.setId(id);

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(id);

        when(studentMapper.map(any(Student.class))).thenReturn(studentEntity);
        when(repository.save(any())).thenReturn(studentEntity);

        Long resultId = studentService.createStudent(student);

        Assertions.assertEquals(id, resultId);
    }

    @Test
    void testFindAllStudents() {

        Long id = 1L;
        String name = "test-name";
        String surname = "test-surname";

        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setSurname(surname);

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(id);
        studentEntity.setName(name);
        studentEntity.setSurname(surname);

        List<StudentEntity> studentEntityList = new ArrayList<>();
        studentEntityList.add(studentEntity);

        List<Student> studentList = new ArrayList<>();
        studentList.add(student);

        when(studentMapper.map(any(ArrayList.class))).thenReturn(studentList);
        when(repository.findAll()).thenReturn(studentEntityList);

        List<Student> result = studentService.findAllStudents();

        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(student.getId(), result.get(0).getId());
        Assertions.assertEquals(student.getName(), result.get(0).getName());
        Assertions.assertEquals(student.getSurname(), result.get(0).getSurname());
    }


    @Test
    void testDeleteStudentById() {
        Long id = 1L;
        String name = "test-name";
        String surname = "test-surname";

        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setSurname(surname);

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(id);
        studentEntity.setName(name);
        studentEntity.setSurname(surname);

        when(studentMapper.map(any(StudentEntity.class))).thenReturn(student);
        when(repository.findById(id)).thenReturn(java.util.Optional.of(studentEntity));

        studentService.deleteStudentById(1L);
    }

    @Test
    void testDeleteStudentByIdException() {
        Long id = 1L;

        when(repository.findById(id)).thenReturn(Optional.empty());

        try {
            studentService.deleteStudentById(id);
        } catch (StudentNotFound e) {
            Assert.assertTrue(true);
            return;
        }
        Assert.fail();
    }

}