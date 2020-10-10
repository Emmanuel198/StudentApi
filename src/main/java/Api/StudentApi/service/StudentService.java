package Api.StudentApi.service;

import Api.StudentApi.entities.StudentEntity;
import Api.StudentApi.exeptions.StudentNotFound;
import Api.StudentApi.mappers.StudentMapper;
import Api.StudentApi.models.Student;
import Api.StudentApi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentRepository repository;

    public Student getStudentById(Long id) throws StudentNotFound {
        Optional<StudentEntity> student = repository.findById(id);
        if (student.isEmpty()) {
            throw new StudentNotFound();
        }
        return studentMapper.map(student.get());
    }

    public Long createStudent(Student student) {
        StudentEntity createdStudentEntity = repository.save(studentMapper.map(student));
        return createdStudentEntity.getId();
    }

    public List<Student> findAllStudents() {
        return studentMapper.map((List<StudentEntity>) repository.findAll());
    }

    public void deleteStudentById(Long id) throws StudentNotFound {
        Optional<StudentEntity> student = repository.findById(id);
        if (student.isEmpty()) {
            throw new StudentNotFound();
        }
        repository.deleteById(id);
    }

}

