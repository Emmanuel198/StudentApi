package Api.StudentApi.service;

import Api.StudentApi.entities.SubjectEntity;
import Api.StudentApi.exeptions.StudentNotFound;
import Api.StudentApi.exeptions.SubjectNotFound;
import Api.StudentApi.mappers.SubjectMapper;
import Api.StudentApi.models.Subject;
import Api.StudentApi.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
    private SubjectRepository repository;


    public Subject getSubjectById(Long id) throws SubjectNotFound {
        Optional<SubjectEntity> subject = repository.findById(id);
        if (subject.isEmpty()) {
            throw new StudentNotFound();
        }
        return subjectMapper.map(subject.get());
    }
    public Long createSubject(Subject subject) {
        SubjectEntity createdSubjectEntity = repository.save(subjectMapper.map(subject));
        return createdSubjectEntity.getId();
    }
    public List<Subject> findAllSubject() {
        return subjectMapper.map((List<SubjectEntity>) repository.findAll());
    }
    public void deleteSubjectById(Long id) throws SubjectNotFound {
        Optional<SubjectEntity> subject = repository.findById(id);
        if (subject.isEmpty()) {
            throw new SubjectNotFound();
        }
        repository.deleteById(id);
    }


}
