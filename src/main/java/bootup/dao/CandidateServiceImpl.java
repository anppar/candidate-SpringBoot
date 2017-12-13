package bootup.dao;

import bootup.entity.Candidate;
import bootup.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by anoop on 29/11/17.
 */
@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    CandidateDao candidateDao;

    @Override
    public List<Candidate> getAllCandidates() {
      return candidateDao.findAll();
    }

    @Override
    public Candidate getCandidateById(String id) {
        return candidateDao.findOne(id);
    }

    @Override
    public void updateCandidate(Candidate candidate) {
        candidateDao.save(candidate);
    }

    @Override
    public void deleteCandidate(String id) {
        candidateDao.delete(id);
    }

    @Override
    public void insertCandidate( Candidate candidate) {
        long count = candidateDao.count();
        candidate.setId(String.valueOf(count));
        candidateDao.insert(candidate);
    }
}
