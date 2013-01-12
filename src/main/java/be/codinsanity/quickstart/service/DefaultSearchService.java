package be.codinsanity.quickstart.service;

import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;
import javax.xml.ws.Response;

/**
 * Created by Bruno Dusausoy
 */
@Service
@Path("/service")
public class DefaultSearchService implements SearchService {

    @Override
    @GET
    @Path("/search")
    @Produces("application/json")
    public Response search(@Context UriInfo ui) {
        SearchRequest request = createSearchRequest(ui);
        return null;
    }

    private SearchRequest createSearchRequest(UriInfo ui) {
        MultivaluedMap<String, String> params = ui.getQueryParameters();
        return SearchRequest.Builder
                .instance()
                .dossierReference(params.getFirst(SearchField.DOSSIER_REFERENCE.getSolrName()))
                .dossierTitle(params.getFirst(SearchField.DOSSIER_TITLE.getSolrName()))
                .build();
    }
}
