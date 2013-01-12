package be.codinsanity.quickstart.repository.solr;

/**
 * Created by Bruno Dusausoy
 */
public class Dossier {
    private String dossierReference;
    private String dossierTitle;
    private String procedureReference;
    private String procedureTitle;

    public String getDossierReference() {
        return dossierReference;
    }

    public void setDossierReference(String dossierReference) {
        this.dossierReference = dossierReference;
    }

    public String getDossierTitle() {
        return dossierTitle;
    }

    public void setDossierTitle(String dossierTitle) {
        this.dossierTitle = dossierTitle;
    }

    public String getProcedureReference() {
        return procedureReference;
    }

    public void setProcedureReference(String procedureReference) {
        this.procedureReference = procedureReference;
    }

    public String getProcedureTitle() {
        return procedureTitle;
    }

    public void setProcedureTitle(String procedureTitle) {
        this.procedureTitle = procedureTitle;
    }
}
