package bootup.service;

import bootup.entity.Candidate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by anoop on 29/11/17.
 */
public interface CandidateService {

    List<Candidate> getAllCandidates();

    Candidate getCandidateById(String id);

    void updateCandidate(Candidate candidate);

    void deleteCandidate(String id);

    void insertCandidate(Candidate candidate);
}
