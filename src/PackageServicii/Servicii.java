package PackageServicii;
import PackageClient.Client;
import PackageMedic.Medic;
import PackageMedicament.Medicament;
import PackageProgramare.Programare;
import PackageReteta.Reteta;

import java.util.*; // random,scanner,arraylist,etc.
import java.lang.*;

public class Servicii {
    /*
    citire_fisiere();
    afisare_fisiere();

    1)Adaugare Client
    2)Afisare Client
    3)Client Modificare
    4)Client Stergere
    5)Afisare Numar de Clienti cu COVID/Numar de Clienti (Statistica)
    6)Afisare Medie ani experienta Medici
    7)Cel mai vechi angajat (Medic)
    8)Adaugare programare
    9)Afisare programare
    10)Valoarea medie a echipamentului
    */

    //1) Adaugare Client
    static Client adaugare_Client() {
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

    //2) Afisare Client
    static void afisare_Client(Client x){
        System.out.println("CNP: "+" "+x.getCNP());
        System.out.println("Nume Prenume: "+x.getNume()+" "+x.getPrenume());
        System.out.println("Adresa: "+ " "+x.getAdresa());
        System.out.println("Telefon: "+ " "+x.getTelefon());

        if(x.isAsigurat())
            System.out.println("Asigurat: Da");
        else
            System.out.println("Asigurat: Nu");

        if(x.isRezultat_Test_COVID())
            System.out.println("Rezultat Test COVID: POZITIV");
        else
            System.out.println("Rezultat Test COVID: NEGATIV");

        if(x.isSalariat())
            System.out.println("Salariat: Da");
        else
            System.out.println("Salariat: Nu");

        System.out.println("Boli: "+x.getBoli());
        System.out.println("Alergeni: "+ " "+x.getAlergeni());
        System.out.println("Grupa Sange: "+ " "+x.getGrupa_Sange());
    }

    //3) Modificare Client
    static Client modificare_Client(){

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

    //5 Afisare numar clienti COVID
    static void Statistica_COVID(ArrayList<Client>x) {
        int nrTotal=0;
        int nrCovid=0;

        for(Client it:x)
        {
            nrTotal++;
            if(it.isRezultat_Test_COVID())
                nrCovid++;
        }

        System.out.println("Procentajul de clienti ce au COVID:" + (float)nrCovid/nrTotal*100);
    }

    //6)Afisare Medie ani experienta Medici
    static void afisare_Medie_Experienta(ArrayList<Medic> x){
        int count=0;
        int ani_experienta=0;
        for(Medic it: x) {
            ani_experienta+=it.getAni_Experienta();
            ++count;
        }
        System.out.println("Media de experienta a medicilor: "+(float)ani_experienta/count+" ani");
    }

    //8)Adaugare programare
    static Programare adaugare_Programare(String cnp_client, String cnp_medic) {
        Programare x = new Programare();

        Scanner scan = new Scanner(System.in);
        int zi,luna,an,ora,minut;

        System.out.println("Data Programari:");
        System.out.println("Ziua:");
        zi=scan.nextInt();
        System.out.println("Luna:");
        luna=scan.nextInt();
        System.out.println("Anul:");
        an=scan.nextInt();
        System.out.println("Ora:");
        ora=scan.nextInt();
        System.out.println("Minutul:");
        minut=scan.nextInt();

        Calendar cal = Calendar.getInstance();
        cal.set(zi,luna,an,ora,minut);
        x.setData(cal);

        System.out.println("Detalii Programare:");
        x.setDetalii_Programare(scan.nextLine());

        System.out.println("Recomandari:");
        x.setRecomandari(scan.nextLine());

        System.out.println("CNP Client:");
        x.setCNP_Client(scan.nextLine());

        System.out.println("CNPMedic:");
        x.setCNP_Medic(scan.nextLine());

        return x;
    }

    public static void main(String[] args){
        System.out.println("Test afisare");
        Scanner scanner = new Scanner(System.in);
        String var = "String";
        String x = "String";
        String y = new String("String");

        if (x.equals(y))
            System.out.println("True");

        for(int i=0;i<=100;++i)
            System.out.println(i);
        System.out.println(var);

        Reteta b = new Reteta();

        b.setDurata(scanner.nextLine());
        HashMap<String,Medicament> list_med = new HashMap<>();
        for(int i=0;i<2;i++)
        {
            Medicament med = new Medicament();

            String den = scanner.nextLine();
            String Mod_Administrare = scanner.nextLine();
            String Prospect = scanner.nextLine();

            med.setDenumire(den);
            med.setMod_Administrare(Mod_Administrare);
            med.setProspect(Prospect);

            list_med.put(den , med);
        }
        b.setLista_medicamente(list_med);
        System.out.println(b.toString());
    }
}
