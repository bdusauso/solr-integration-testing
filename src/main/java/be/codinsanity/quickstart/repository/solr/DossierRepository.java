package be.codinsanity.quickstart.repository.solr;

import org.springframework.data.solr.repository.SolrCrudRepository;

/**
 * Created by Bruno Dusausoy
 */
public interface DossierRepository extends SolrCrudRepository<Dossier, String> {
}
