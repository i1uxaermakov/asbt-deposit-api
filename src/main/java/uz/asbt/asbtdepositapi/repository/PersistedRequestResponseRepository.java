package uz.asbt.asbtdepositapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.asbt.asbtdepositapi.model.PersistedRequestResponsePair;

import java.util.Optional;

@Repository
public interface PersistedRequestResponseRepository extends CrudRepository<PersistedRequestResponsePair, Integer> {
    Optional<PersistedRequestResponsePair> findByRequestIdInRequest(Long requestId);

}