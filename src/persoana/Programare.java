package persoana;

import java.util.Calendar;

public class Programare implements Comparable<Programare> {
    private Calendar data;
    private String detaliiProgramare;
    private String recomandari;
    private String cnpClient;
    private String cnpMedic;

    public Programare() {
    }

    public Programare(Calendar data, String detaliiProgramare, String recomandari, String cnpClient, String cnpMedic) {
        this.data = data;
        this.detaliiProgramare = detaliiProgramare;
        this.recomandari = recomandari;
        this.cnpClient = cnpClient;
        this.cnpMedic = cnpMedic;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public String getDetaliiProgramare() {
        return detaliiProgramare;
    }

    public void setDetaliiProgramare(String detaliiProgramare) {
        this.detaliiProgramare = detaliiProgramare;
    }

    public String getRecomandari() {
        return recomandari;
    }

    public void setRecomandari(String recomandari) {
        this.recomandari = recomandari;
    }

    public String getCnpClient() {
        return cnpClient;
    }

    public void setCnpClient(String cnpClient) {
        this.cnpClient = cnpClient;
    }

    public String getCnpMedic() {
        return cnpMedic;
    }

    public void setCnpMedic(String cnpMedic) {
        this.cnpMedic = cnpMedic;
    }

    @Override
    public String toString() {
        return cnpClient + " " + cnpMedic + " " + data + " " + detaliiProgramare + " " + recomandari;
    }

    @Override
    public int compareTo(Programare o) {
        return this.getData().compareTo(o.getData());
    }
}