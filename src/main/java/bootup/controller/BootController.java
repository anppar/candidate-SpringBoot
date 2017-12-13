package bootup.controller;

import bootup.entity.Candidate;
import bootup.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anoop on 29/11/17.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BootController {

    @Autowired
    CandidateService candidateService;

    @GetMapping("candidate/{id}")
    public ResponseEntity<Candidate> getCandidateById(@PathVariable("id") String id) {
        Candidate candidate = candidateService.getCandidateById(id);
        return new ResponseEntity<Candidate>(candidate, HttpStatus.OK);
    }


    @GetMapping("allCandidates")
    public ResponseEntity<List<Candidate>> getAllCandidates() {
        Candidate cand1 = new Candidate("1","Name1", "State1,Country", "tITLE1", 0,0);
        Candidate cand2= new Candidate("2","Name1", "State1,Country", "tITLE1", 0,0);
        List<Candidate> candidate = candidateService.getAllCandidates();
        List<Candidate> candidateList = new ArrayList<Candidate>();
        candidateList.add(cand1);
        candidateList.add(cand2);

        return new ResponseEntity<List<Candidate>>(candidate, HttpStatus.OK);
    }

    @PostMapping("candidate")
    public ResponseEntity<Void> createCandidate(@RequestBody Candidate candidate, UriComponentsBuilder builder) {
        candidateService.insertCandidate(candidate);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/candidate?id={id}").buildAndExpand(candidate.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("candidate")
    public ResponseEntity<Candidate> updateCandidate(@RequestBody Candidate candidate) {
        candidateService.updateCandidate(candidate);
        return new ResponseEntity<Candidate>(candidate, HttpStatus.OK);
    }

    @DeleteMapping("candidate")
    public ResponseEntity<Void> deleteCandidate(@RequestParam("id") String id) {
        candidateService.deleteCandidate(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
