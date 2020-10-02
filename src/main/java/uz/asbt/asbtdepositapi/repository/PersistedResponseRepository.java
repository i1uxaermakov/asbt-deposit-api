package uz.asbt.asbtdepositapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.asbt.asbtdepositapi.model.PersistedResponse;

import java.util.Optional;

@Repository
public interface PersistedResponseRepository extends JpaRepository<PersistedResponse, Long> {
    Optional<PersistedResponse> findByRequestId(long requestId);

}