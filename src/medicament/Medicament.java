package medicament;

public class Medicament {
    protected String denumire;
    protected String modAdministrare;
    protected String prospect;

    public Medicament() {
    }

    public Medicament(String denumire, String modAdministrare, String prospect) {
        this.denumire = denumire;
        this.modAdministrare = modAdministrare;
        this.prospect = prospect;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getModAdministrare() {
        return modAdministrare;
    }

    public void setModAdministrare(String modAdministrare) {
        this.modAdministrare = modAdministrare;
    }

    public String getProspect() {
        return prospect;
    }

    public void setProspect(String prospect) {
        this.prospect = prospect;
    }

    @Override
    public String toString() {
        return denumire + " " + modAdministrare + " " + prospect;
    }
}