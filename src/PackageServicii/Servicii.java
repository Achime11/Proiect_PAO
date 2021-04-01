package PackageServicii;

import PackageClient.Client;
import PackageEchipament.Echipament;
import PackageMedic.Medic;
import PackageMedicament.Medicament;
import PackageProgramare.Programare;
import PackageReteta.Reteta;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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

    //Citirea din fisiere
    public static  void citire_DataBase(HashMap<String, Client> Clienti,HashMap<String, Medic> Medici,ArrayList<Programare> Programari,ArrayList<Reteta> Retete,ArrayList<Echipament> Echipamente){

        try {
            File fisier_client = new File("DataBase/Client_DataBase.txt");
            Scanner myReader = new Scanner(fisier_client);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] arg_of_Data=data.split(",");
                Client client = new Client();
                client.setCNP(arg_of_Data[0]);
                client.setNume(arg_of_Data[1]);
                client.setPrenume(arg_of_Data[2]);
                client.setAdresa(arg_of_Data[3]);
                client.setTelefon(arg_of_Data[4]);
                client.setAsigurat(Boolean.parseBoolean(arg_of_Data[5]));
                client.setRezultat_Test_COVID(Boolean.parseBoolean(arg_of_Data[6]));
                client.setSalariat(Boolean.parseBoolean(arg_of_Data[7]));
                client.setBoli(arg_of_Data[8]);
                client.setAlergeni(arg_of_Data[9]);
                client.setGrupa_Sange(arg_of_Data[10]);
                Clienti.put(arg_of_Data[0],client);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul Client_DataBase.txt nu a fost gasit!!!");
            e.printStackTrace();
        }

        try {
            File fisier_echipament = new File("DataBase/Echipament_DataBase.txt");
            Scanner myReader = new Scanner(fisier_echipament);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] arg_of_Data=data.split(",");
                Echipament echipament = new Echipament();
                echipament.setNume_Producator(arg_of_Data[0]);
                echipament.setTelefon(arg_of_Data[1]);
                echipament.setNume_Echipament(arg_of_Data[2]);
                echipament.setAn_Productie(Integer.parseInt(arg_of_Data[3]));
                echipament.setPret(Float.parseFloat(arg_of_Data[4]));
                Echipamente.add(echipament);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul Echipament_DataBase.txt nu a fost gasit!!!");
            e.printStackTrace();
        }

        try {
            File fisier_medic = new File("DataBase/Medic_DataBase.txt");
            Scanner myReader = new Scanner(fisier_medic);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] arg_of_Data=data.split(",");
                Medic medic = new Medic();
                medic.setCNP(arg_of_Data[0]);
                medic.setNume(arg_of_Data[1]);
                medic.setPrenume(arg_of_Data[2]);
                medic.setAdresa(arg_of_Data[3]);
                medic.setTelefon(arg_of_Data[4]);
                medic.setSpecializare(arg_of_Data[5]);
                medic.setAni_Experienta(Integer.parseInt(arg_of_Data[6]));
                Calendar cal = Calendar.getInstance();
                cal.set(Integer.parseInt(arg_of_Data[9]),Integer.parseInt(arg_of_Data[8]),Integer.parseInt(arg_of_Data[7]));
                medic.setData_Angajarii(cal);
                Medici.put(arg_of_Data[0],medic);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul Medic_DataBase.txt nu a fost gasit!!!");
            e.printStackTrace();
        }

        try {
            File fisier_programare = new File("DataBase/Programare_DataBase.txt");
            Scanner myReader = new Scanner(fisier_programare);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] arg_of_Data=data.split(",");
                Programare programare = new Programare();
                Calendar cal = Calendar.getInstance();
                cal.set(Integer.parseInt(arg_of_Data[2]),Integer.parseInt(arg_of_Data[1]),Integer.parseInt(arg_of_Data[0]),Integer.parseInt(arg_of_Data[3]),Integer.parseInt(arg_of_Data[4]));
                programare.setData(cal);
                programare.setDetalii_Programare(arg_of_Data[5]);
                programare.setRecomandari(arg_of_Data[6]);
                programare.setCNP_Client(arg_of_Data[7]);
                programare.setCNP_Medic(arg_of_Data[8]);
                Programari.add(programare);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul Programare_DataBase.txt nu a fost gasit!!!");
            e.printStackTrace();
        }

        try {
            File fisier_reteta = new File("DataBase/Reteta_DataBase.txt");
            Scanner myReader = new Scanner(fisier_reteta);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] arg_of_Data=data.split(",");
                Reteta reteta = new Reteta();
                reteta.setDurata(arg_of_Data[0]);
                int nr=Integer.parseInt(arg_of_Data[1]);
                int count=2;
                for( int i=0;i<nr;++i)
                {
                    Medicament medicament = new Medicament();
                    medicament.setDenumire(arg_of_Data[count]);
                    medicament.setMod_Administrare(arg_of_Data[count+1]);
                    medicament.setProspect(arg_of_Data[count+2]);
                    reteta.getLista_medicamente().put(medicament.getDenumire(),medicament);

                    count+=3;
                }
                Retete.add(reteta);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul Reteta_DataBase.txt nu a fost gasit!!!");
            e.printStackTrace();
        }

    }

    //Scrierea in fisier
    public static void scriere_DataBase(HashMap<String, Client> Clienti,HashMap<String, Medic> Medici,ArrayList<Programare> Programari,ArrayList<Reteta> Retete,ArrayList<Echipament> Echipamente) throws IOException {

        FileWriter scriereClient = new FileWriter("DataBase/Client_DataBase.txt");
        for(Map.Entry x: Clienti.entrySet())
        {
            scriereClient.write(((Client) x.getValue()).getCNP()
                    +","+((Client) x.getValue()).getNume()
                    +","+((Client) x.getValue()).getPrenume()
                    +","+ ((Client) x.getValue()).getAdresa()
                    +","+ ((Client) x.getValue()).getTelefon()
                    +","+((Client) x.getValue()).isAsigurat()
                    +","+((Client) x.getValue()).isRezultat_Test_COVID()
                    +","+ ((Client) x.getValue()).isSalariat()
                    +","+((Client) x.getValue()).getBoli()
                    +","+((Client) x.getValue()).getAlergeni()
                    +","+((Client) x.getValue()).getGrupa_Sange()+"\n");
        }
        scriereClient.close();


        FileWriter scriereMedic = new FileWriter("DataBase/Medic_DataBase.txt");
        for(Map.Entry x: Medici.entrySet())
        {
            scriereMedic.write(((Medic) x.getValue()).getCNP()
                    +","+((Medic) x.getValue()).getNume()
                    +","+((Medic) x.getValue()).getPrenume()
                    +","+((Medic) x.getValue()).getAdresa()
                    +","+((Medic) x.getValue()).getTelefon()
                    +","+((Medic) x.getValue()).getSpecializare()
                    +","+((Medic) x.getValue()).getAni_Experienta()
                    +","+((Medic) x.getValue()).getData_Angajarii().get(Calendar.DATE)
                    +","+((Medic) x.getValue()).getData_Angajarii().get(Calendar.MONTH)
                    +","+((Medic) x.getValue()).getData_Angajarii().get(Calendar.YEAR)+"\n");
        }
        scriereMedic.close();

        FileWriter scriereEchipament = new FileWriter("DataBase/Echipament_DataBase.txt");
        for(Echipament x:Echipamente)
        {
            scriereEchipament.write(x.getNume_Producator()
                    +","+x.getTelefon()
                    +","+x.getNume_Echipament()
                    +","+x.getAn_Productie()
                    +","+x.getPret()+"\n");
        }
        scriereEchipament.close();

        FileWriter scriereProgramare = new FileWriter("DataBase/Programare_DataBase.txt");
        for(Programare x:Programari)
            scriereProgramare.write(x.getData().get(Calendar.DATE) +","
                    + x.getData().get(Calendar.MONTH)
                    + "," + x.getData().get(Calendar.YEAR)
                    + ","  + x.getData().get(Calendar.HOUR)
                    + ","  + x.getData().get(Calendar.MINUTE)
                    + ","  + x.getDetalii_Programare()
                    + ","  + x.getRecomandari()
                    + ","  + x.getCNP_Client()
                    + ","  + x.getCNP_Medic()+"\n");
        scriereProgramare.close();

        FileWriter scriereReteta = new FileWriter("DataBase/Reteta_DataBase.txt");
        String str = "";
        for(Reteta x:Retete) {
            HashMap<String, Medicament> lista_medicamente = x.getLista_medicamente();
            int count = 0;
            for (Map.Entry y : lista_medicamente.entrySet()) {
                ++count;
                str.concat(((Medicament) y.getValue()).getDenumire() + "," +
                        ((Medicament) y.getValue()).getMod_Administrare() +
                        ((Medicament) y.getValue()).getProspect());
            }
            scriereReteta.write(x.getDurata() + "," + count + "," + str+"\n");
        }
        scriereReteta.close();
    }


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

        System.out.println("Alergeni:");
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

        System.out.println("Alergeni:");
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
        cal.set(an, luna, zi, ora, minut);
        x.setData(cal);

        System.out.print("Detalii Programare: ");
        scan.nextLine();
        x.setDetalii_Programare(scan.nextLine());

        System.out.print("Recomandari: ");
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
