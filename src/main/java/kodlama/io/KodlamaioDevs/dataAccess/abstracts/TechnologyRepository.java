package kodlama.io.KodlamaioDevs.dataAccess.abstracts;

import kodlama.io.KodlamaioDevs.entities.concretes.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Integer> {
}
