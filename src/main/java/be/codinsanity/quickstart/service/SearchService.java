package be.codinsanity.quickstart.service;

import javax.ws.rs.core.UriInfo;
import javax.xml.ws.Response;

/**
 * Created by Bruno Dusausoy
 */
public interface SearchService {

    Response search(UriInfo ui);
}
