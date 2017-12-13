package bootup.dao;


import bootup.entity.Candidate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by anoop on 29/11/17.
 */
@Repository
public interface CandidateDao extends MongoRepository<Candidate, String> {


}
