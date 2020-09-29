package Api.StudentApi.mappers;

import Api.StudentApi.controller.request.StudentRequest;
import Api.StudentApi.controller.request.SubjectRequest;
import Api.StudentApi.controller.response.StudentResponse;
import Api.StudentApi.controller.response.SubjectResponse;
import Api.StudentApi.entities.StudentEntity;
import Api.StudentApi.entities.SubjectEntity;
import Api.StudentApi.models.Student;
import Api.StudentApi.models.Subject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectMapper {
    @Autowired
    private ModelMapper modelMapper;

    public Subject map(SubjectEntity subjectEntity) {
        return modelMapper.map(subjectEntity, Subject.class);
    }

    public SubjectResponse mapToSubjectResponse(Subject subject) {
        return modelMapper.map(subject, SubjectResponse.class);
    }

    public SubjectEntity map(Subject subject) {
        return modelMapper.map(subject, SubjectEntity.class);
    }

    public Subject map(SubjectRequest subjectRequest) {
        return modelMapper.map(subjectRequest, Subject.class);
    }

    public List<Subject> map(List<SubjectEntity> subjectEntities) {
        List<Subject> subjects = new ArrayList<>();
        for (SubjectEntity subjectEntity : subjectEntities) {
            subjects.add(map(subjectEntity));
        }
        return subjects;
    }

    public List<SubjectResponse> mapToSubjectResponse(List<Subject> subjects) {
        List<SubjectResponse> subjectResponseList = new ArrayList<>();
        for (Subject subject : subjects) {
            subjectResponseList.add(mapToSubjectResponse(subject));
        }
        return subjectResponseList;
    }
}
