package Api.StudentApi.controller;

import Api.StudentApi.controller.request.InscriptionRequest;
import Api.StudentApi.exceptions.StudentAlreadyEnrolled;
import Api.StudentApi.exceptions.StudentNotFound;
import Api.StudentApi.exceptions.SubjectNotFound;
import Api.StudentApi.service.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inscriptions")
public class InscriptionController {
    
    @Autowired
    InscriptionService inscriptionService;

    @PostMapping
    public ResponseEntity createInscription(@RequestBody InscriptionRequest inscriptionRequest)
            throws StudentNotFound, SubjectNotFound, StudentAlreadyEnrolled {
        inscriptionService.createInscription(inscriptionRequest.getSubjectId(), inscriptionRequest.getStudentId());
        return ResponseEntity.ok().build();
    }
}
