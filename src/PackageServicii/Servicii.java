package PackageServicii;

import PackageClient.Client;
import PackageEchipament.Echipament;
import PackageMedic.Medic;
import PackageProgramare.Programare;

import java.util.*;

public class Servicii {
    /*
    ("1. Adaugare Client in cadrul cabinetului medical.");
    ("2. Afisare Clienti in cadrul cabinetului medical.");
    ("3. Modificare Client in cadrul cabinetului medical.");
    ("4. Stergere Client in cadrul cabinetului medical.");
    ("5. Afisare Numar de Clienti cu COVID/Numar de Clienti (Statistica)");
    ("6. Afisare Media anilor de experienta a Medicilor");
    ("7. Afisarea celui mai vechi angajat (Medic)");
    ("8. Adaugare programare in cadrul cabinetului medical.");
    ("9. Afisarea programarilor in cadrul cabinetului medical.");
    ("10. Afisare valoare medie a echipamentelor.");
    ("0. Iesire.");
     */

    //1) Adaugare Client in cadrul cabinetului medical.
    public static Client adaugare_Client() {
        Client x = new Client();

        Scanner scan = new Scanner(System.in);

        System.out.println("CNP:");
        x.setCNP(scan.nextLine());

        System.out.println("Nume:");
        x.setNume(scan.nextLine());

        System.out.println("Prenume:");
        x.setPrenume(scan.nextLine());

        System.out.println("Adresa:");
        x.setAdresa(scan.nextLine());

        System.out.println("Telefon:");
        x.setTelefon(scan.nextLine());

        System.out.println("Clientul este asigurat?(da/nu)");
        String asigurat = scan.nextLine().toLowerCase(Locale.ROOT);
        x.setAsigurat(asigurat.equals("da"));

        System.out.println("Rezultatul testului COVID al clientului?(Pozitiv/Negativ)");
        String TestCovid = scan.nextLine().toLowerCase(Locale.ROOT);
        x.setRezultat_Test_COVID(TestCovid.equals("pozitiv"));

        System.out.println("Clientul este Salariat?(da/nu)");
        String Salariat = scan.nextLine().toLowerCase(Locale.ROOT);
        x.setSalariat(Salariat.equals("da"));

        System.out.println("Boli:");
        x.setBoli(scan.nextLine());

        System.out.println("Alergeri:");
        x.setAlergeni(scan.nextLine());

        System.out.println("Grupa sange:");
        x.setGrupa_Sange(scan.nextLine());


        return x;
    }

    //2) Afisare Clienti in cadrul cabinetului medical.
    public static void afisare_Client(Client x) {
        System.out.println();
        System.out.println("-------------------------------------------------");
        System.out.println("CNP: " + " " + x.getCNP());
        System.out.println("Nume Prenume: " + x.getNume() + " " + x.getPrenume());
        System.out.println("Adresa: " + " " + x.getAdresa());
        System.out.println("Telefon: " + " " + x.getTelefon());

        if (x.isAsigurat())
            System.out.println("Asigurat: Da");
        else
            System.out.println("Asigurat: Nu");

        if (x.isRezultat_Test_COVID())
            System.out.println("Rezultat Test COVID: POZITIV");
        else
            System.out.println("Rezultat Test COVID: NEGATIV");

        if (x.isSalariat())
            System.out.println("Salariat: Da");
        else
            System.out.println("Salariat: Nu");

        System.out.println("Boli: " + x.getBoli());
        System.out.println("Alergeni: " + " " + x.getAlergeni());
        System.out.println("Grupa Sange: " + " " + x.getGrupa_Sange());
    }

    //3) Modificare Client in cadrul cabinetului medical.
    public static Client modificare_Client() {

        Client x = new Client();

        Scanner scan = new Scanner(System.in);

        System.out.println("CNP:");
        x.setCNP(scan.nextLine());

        System.out.println("Nume:");
        x.setNume(scan.nextLine());

        System.out.println("Prenume:");
        x.setPrenume(scan.nextLine());

        System.out.println("Adresa:");
        x.setAdresa(scan.nextLine());

        System.out.println("Telefon:");
        x.setTelefon(scan.nextLine());

        System.out.println("Clientul este asigurat?(da/nu)");
        String asigurat = scan.nextLine().toLowerCase(Locale.ROOT);
        x.setAsigurat(asigurat.equals("da"));

        System.out.println("Rezultatul testului COVID al clientului?(Pozitiv/Negativ)");
        String TestCovid = scan.nextLine().toLowerCase(Locale.ROOT);
        x.setRezultat_Test_COVID(TestCovid.equals("pozitiv"));

        System.out.println("Clientul este Salariat?(da/nu)");
        String Salariat = scan.nextLine().toLowerCase(Locale.ROOT);
        x.setSalariat(Salariat.equals("da"));

        System.out.println("Boli:");
        x.setBoli(scan.nextLine());

        System.out.println("Alergeri:");
        x.setAlergeni(scan.nextLine());

        System.out.println("Grupa sange:");
        x.setGrupa_Sange(scan.nextLine());

        return x;

    }

    //5 Afisare Numar de Clienti cu COVID/Numar de Clienti (Statistica)
    public static void Statistica_COVID(HashMap<String,Client> list) {
        int nrTotal = 0;
        int nrCovid = 0;

        for (Map.Entry x: list.entrySet()) {
            nrTotal++;
            if (((Client)x.getValue()).isRezultat_Test_COVID())
                nrCovid++;
        }

        System.out.println("Procentajul de clienti ce au COVID:" + (float) nrCovid / nrTotal * 100);
    }

    //6) Afisare Media anilor de experienta a Medicilor
    public static void afisare_Medie_Experienta(HashMap<String,Medic> list) {
        int count = 0;
        int ani_experienta = 0;
        for (Map.Entry x: list.entrySet()) {
            ani_experienta += ((Medic)x.getValue()).getAni_Experienta();
            ++count;
        }
        System.out.println("Media de experienta a medicilor: " + (float) ani_experienta / count + " ani");
    }

    //7) Afisarea celui mai vechi angajat (Medic)
    public static void afisare_cel_mai_vechi_Medic(HashMap<String,Medic> list) {
        Calendar minDate = Calendar.getInstance();

        String Nume = "", Prenume = "", Specializare = "";

        for (Map.Entry x: list.entrySet()) {
            if (minDate.after(((Medic)x.getValue()).getData_Angajarii())) {
                minDate = ((Medic)x.getValue()).getData_Angajarii();
                Nume = ((Medic)x.getValue()).getNume();
                Prenume = ((Medic)x.getValue()).getPrenume();
                Specializare = ((Medic)x.getValue()).getSpecializare();
            }

        }
        if (Nume.equals("") && Prenume.equals("") && Specializare.equals(""))
            System.out.println("Nu exista cel mai vechi medic angajat:");
        else
            System.out.println("Cel mai vechi medic angajat este:" + Nume + " " + Prenume + " " + Specializare);
    }

    //8) Adaugare programare in cadrul cabinetului medical.
    public static Programare adaugare_Programare(String cnp_client, String cnp_medic) {
        Programare x = new Programare();
        Scanner scan = new Scanner(System.in);
        int zi, luna, an, ora, minut;

        x.setCNP_Client(cnp_client);
        x.setCNP_Medic(cnp_medic);

        System.out.println("Data Programari:");
        System.out.println("Ziua:");
        zi = scan.nextInt();
        System.out.println("Luna:");
        luna = scan.nextInt();
        System.out.println("Anul:");
        an = scan.nextInt();
        System.out.println("Ora:");
        ora = scan.nextInt();
        System.out.println("Minutul:");
        minut = scan.nextInt();

        Calendar cal = Calendar.getInstance();
        cal.set(zi, luna, an, ora, minut);
        x.setData(cal);

        System.out.println("Detalii Programare:");
        x.setDetalii_Programare(scan.nextLine());

        System.out.println("Recomandari:");
        x.setRecomandari(scan.nextLine());

        return x;
    }

    //9) Afisarea programarilor in cadrul cabinetului medical.
    public static void afisare_Programare(Programare x) {

        System.out.println("Data Programarii este: Ziua" + x.getData().get(Calendar.DATE) + " Luna " + x.getData().get(Calendar.MONTH) + " Anul " + x.getData().get(Calendar.YEAR) + " Ora " + x.getData().get(Calendar.HOUR) + " Minutul " + x.getData().get(Calendar.MINUTE));
        System.out.println("Detalii Programare: " + x.getDetalii_Programare());
        System.out.println("Recomandari: " + x.getRecomandari());
        System.out.println("CNP Client: " + x.getCNP_Client());
        System.out.println("CNP Medic: " + x.getCNP_Medic());

    }

    //10) Afisare valoare medie a echipamentelor.
    public static void afisare_Valoarea_media_echipamente(ArrayList<Echipament> list) {
        int count = 0;
        float valoare = 0;
        for (Echipament it : list) {
            ++count;
            valoare += it.getPret();
        }

        System.out.println(valoare/(float)count);
    }

}
