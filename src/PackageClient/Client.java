package PackageClient;

import PackagePersoana.Persoana;

public class Client extends Persoana {
    boolean Asigurat;
    boolean Rezultat_Test_COVID;
    boolean Salariat;
    String Boli;
    String Alergeni;
    String Grupa_Stange;

    public Client() {
    }

    public Client(String CNP, String nume, String prenume, String adresa, String telefon, boolean asigurat, boolean rezultat_Test_COVID, boolean salariat, String boli, String alergeni, String grupa_Stange) {
        super(CNP, nume, prenume, adresa, telefon);
        Asigurat = asigurat;
        Rezultat_Test_COVID = rezultat_Test_COVID;
        Salariat = salariat;
        Boli = boli;
        Alergeni = alergeni;
        Grupa_Stange = grupa_Stange;
    }

    public boolean isAsigurat() {
        return Asigurat;
    }

    public void setAsigurat(boolean asigurat) {
        Asigurat = asigurat;
    }

    public boolean isRezultat_Test_COVID() {
        return Rezultat_Test_COVID;
    }

    public void setRezultat_Test_COVID(boolean rezultat_Test_COVID) {
        Rezultat_Test_COVID = rezultat_Test_COVID;
    }

    public boolean isSalariat() {
        return Salariat;
    }

    public void setSalariat(boolean salariat) {
        Salariat = salariat;
    }

    public String getBoli() {
        return Boli;
    }

    public void setBoli(String boli) {
        Boli = boli;
    }

    public String getAlergeni() {
        return Alergeni;
    }

    public void setAlergeni(String alergeni) {
        Alergeni = alergeni;
    }

    public String getGrupa_Stange() {
        return Grupa_Stange;
    }

    public void setGrupa_Stange(String grupa_Stange) {
        Grupa_Stange = grupa_Stange;
    }

    @Override
    public String toString(){
        return super.toString() + " " + Boli + " " + Alergeni + " " + Grupa_Stange;
    }
}