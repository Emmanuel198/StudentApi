package Api.StudentApi.mappers;

import Api.StudentApi.controller.request.StudentRequest;
import Api.StudentApi.controller.response.StudentResponse;
import Api.StudentApi.entities.StudentEntity;
import Api.StudentApi.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Student map(StudentEntity studentEntity) {
        return modelMapper.map(studentEntity, Student.class);
    }

    public StudentResponse mapToStudentResponse(Student student) {
        return modelMapper.map(student, StudentResponse.class);
    }

    public StudentEntity map(Student student) {
        return modelMapper.map(student, StudentEntity.class);
    }

    public Student map(StudentRequest studentRequest) {
        return modelMapper.map(studentRequest, Student.class);
    }

    public List<Student> map(List<StudentEntity> studentEntities) {
        List<Student> students = new ArrayList<>();
        for (StudentEntity studentEntity : studentEntities) {
            students.add(map(studentEntity));
        }
        return students;
    }

    public List<StudentResponse> mapToStudentResponse(List<Student> students) {
        List<StudentResponse> studentResponseList = new ArrayList<>();
        for (Student student : students) {
            studentResponseList.add(mapToStudentResponse(student));
        }
        return studentResponseList;
    }
}
