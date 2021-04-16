package Api.StudentApi.service;

import Api.StudentApi.entities.StudentEntity;
import Api.StudentApi.exceptions.StudentNotFound;
import Api.StudentApi.mappers.StudentMapper;
import Api.StudentApi.models.Student;
import Api.StudentApi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentMapper studentMapper;
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentMapper studentMapper){
        this.studentMapper = studentMapper;
    }

    @Autowired
    public StudentService(StudentMapper studentMapper, StudentRepository studentRepository) {
        this.studentMapper = studentMapper;
        this.studentRepository = studentRepository;
    }

    public Student getStudentById(Long id) throws StudentNotFound {
        Optional<StudentEntity> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            throw new StudentNotFound();
        }
        return studentMapper.map(student.get());
    }

    public Long createStudent(Student student) {
        StudentEntity createdStudentEntity = studentRepository.save(studentMapper.map(student));
        return createdStudentEntity.getId();
    }

    public List<Student> findAllStudents() {
        return studentMapper.map((List<StudentEntity>) studentRepository.findAll());
    }

    public void deleteStudentById(Long id) throws StudentNotFound {
        Optional<StudentEntity> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            throw new StudentNotFound();
        }
        studentRepository.deleteById(id);
    }

    public void updateStudent(Student student) {
        studentRepository.save(studentMapper.map(student));
    }

}

