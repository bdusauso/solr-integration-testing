package be.codinsanity.quickstart.service;

/**
 * Created by Bruno Dusausoy
 */
public class SearchRequest {
    private final String dossierReference;
    private final String dossierTitle;

    private SearchRequest(Builder builder) {
        dossierReference = builder.dossierReference;
        dossierTitle = builder.dossierTitle;
    }

    public static class Builder {
        private String dossierReference;
        private String dossierTitle;

        public static Builder instance() {
            return new Builder();
        }

        public Builder dossierReference(String reference) {
            dossierReference = reference;
            return this;
        }

        public Builder dossierTitle(String title) {
            dossierTitle = title;
            return this;
        }

        public SearchRequest build() {
            return new SearchRequest(this);
        }
    }
}
