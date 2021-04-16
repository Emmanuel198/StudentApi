package Api.StudentApi.controller;

import Api.StudentApi.controller.request.SubjectRequest;
import Api.StudentApi.controller.response.SubjectResponse;
import Api.StudentApi.exceptions.SubjectNotFound;
import Api.StudentApi.mappers.SubjectMapper;
import Api.StudentApi.models.Subject;
import Api.StudentApi.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private SubjectMapper subjectMapper;

    @GetMapping("/{id}")
    public ResponseEntity<SubjectResponse> getSubjectById(@PathVariable("id") Long id) throws SubjectNotFound {
        Subject subject = subjectService.getSubjectById(id);
        return ResponseEntity.ok(subjectMapper.mapToSubjectResponse(subject));
    }

    @PostMapping
    public ResponseEntity<SubjectResponse> createSubject(@RequestBody SubjectRequest subjectRequest) {
        Long subjectId = subjectService.createSubject(subjectMapper.map(subjectRequest));
        return ResponseEntity.created(URI.create(request.getRequestURL().toString() + "/" + subjectId)).build();
    }

    @GetMapping
    public ResponseEntity<List<SubjectResponse>> findAllSubjects() {
        return ResponseEntity.ok(subjectMapper.mapToSubjectResponse(subjectService.findAllSubject()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSubjectById(@PathVariable("id") Long id) throws SubjectNotFound {
        subjectService.deleteSubjectById(id);
        return ResponseEntity.ok().build();
    }


}
