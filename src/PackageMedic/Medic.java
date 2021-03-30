package PackageMedic;

import PackagePersoana.Persoana;
import java.util.Date;

public class Medic extends Persoana {
    String Specializare;
    int Ani_Experienta;
    Date Data_Angajarii;

    public Medic(String specializare) {
    }

    public Medic(String CNP, String nume, String prenume, String adresa, String telefon, String specializare, int ani_Experienta, Date data_Angajarii) {
        super(CNP, nume, prenume, adresa, telefon);
        Specializare = specializare;
        Ani_Experienta = ani_Experienta;
        Data_Angajarii = data_Angajarii;
    }

    public String getSpecializare() {
        return Specializare;
    }

    public void setSpecializare(String specializare) {
        Specializare = specializare;
    }

    public int getAni_Experienta() {
        return Ani_Experienta;
    }

    public void setAni_Experienta(int ani_Experienta) {
        Ani_Experienta = ani_Experienta;
    }

    public Date getData_Angajarii() {
        return Data_Angajarii;
    }

    public void setData_Angajarii(Date data_Angajarii) {
        Data_Angajarii = data_Angajarii;
    }

    @Override
    public String toString(){
        return super.toString() + " " + Specializare;
    }
}