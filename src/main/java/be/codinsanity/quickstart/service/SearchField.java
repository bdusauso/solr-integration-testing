package be.codinsanity.quickstart.service;

/**
 * Created by Bruno Dusausoy
 */
public enum SearchField {
    DOSSIER_TITLE("dossier_title"),
    DOSSIER_REFERENCE("dossier_reference");

    private final String solrName;

    private SearchField(String solrName) {
        this.solrName = solrName;
    }

    public String getSolrName() {
        return solrName;
    }
}
