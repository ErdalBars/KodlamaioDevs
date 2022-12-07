package kodlama.io.KodlamaioDevs.dataAccess.abstracts;

import kodlama.io.KodlamaioDevs.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {
}
