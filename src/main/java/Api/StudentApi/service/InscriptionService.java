package Api.StudentApi.service;

import Api.StudentApi.entities.StudentEntity;
import Api.StudentApi.entities.SubjectEntity;
import Api.StudentApi.exeptions.StudentAlreadyEnrolled;
import Api.StudentApi.exeptions.StudentNotFound;
import Api.StudentApi.exeptions.SubjectNotFound;
import Api.StudentApi.repository.StudentRepository;
import Api.StudentApi.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class InscriptionService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    public void createInscription(Long subjectId, Long studentId)
            throws StudentAlreadyEnrolled, StudentNotFound, SubjectNotFound {

        Optional<SubjectEntity> subject = subjectRepository.findById(subjectId);
        if (subject.isEmpty()) {
            throw new SubjectNotFound();
        }
        Optional<StudentEntity> student = studentRepository.findById(studentId);
        if (student.isEmpty()) {
            throw new StudentNotFound();
        }
        if (student.get().getSubjects() != null) {
            for (SubjectEntity subjectEntity : student.get().getSubjects()) {
                if (subjectEntity.getId().equals(subjectId)) {
                    throw new StudentAlreadyEnrolled();
                }
            }
        } else {
            student.get().setSubjects(new ArrayList<>());
        }
        student.get().getSubjects().add(subject.get());
        studentRepository.save(student.get());
    }
}
