package be.codinsanity.quickstart.repository.jpa;

import be.codinsanity.quickstart.domain.Dossier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Bruno Dusausoy
 */
@Repository
public interface DossierRepository extends JpaRepository<Dossier, Long> {
}
