package Api.StudentApi.controller;

import Api.StudentApi.controller.request.StudentRequest;
import Api.StudentApi.controller.response.StudentResponse;
import Api.StudentApi.exceptions.StudentNotFound;
import Api.StudentApi.mappers.StudentMapper;
import Api.StudentApi.models.Student;
import Api.StudentApi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;
    private StudentMapper studentMapper;
    @Autowired
    public StudentController(StudentMapper studentMapper, StudentService studentService){
        this.studentMapper = studentMapper;
        this.studentService = studentService;
    }
    @Autowired
    private HttpServletRequest request;

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getStudentById(@PathVariable("id") Long id) throws StudentNotFound {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(studentMapper.mapToStudentResponse(student));
    }

    @PostMapping
    public ResponseEntity<StudentResponse> createStudent(@RequestBody StudentRequest studentRequest) {
        Long studentId = studentService.createStudent(studentMapper.map(studentRequest));
        return ResponseEntity.created(URI.create(request.getRequestURL().toString() + "/" + studentId)).build();
    }

    @GetMapping
    public ResponseEntity<List<StudentResponse>> findAllStudents() {
        return ResponseEntity.ok(studentMapper.mapToStudentResponse(studentService.findAllStudents()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudentById(@PathVariable("id") Long id) throws StudentNotFound {
        studentService.deleteStudentById(id);
        return ResponseEntity.ok().build();
    }

}