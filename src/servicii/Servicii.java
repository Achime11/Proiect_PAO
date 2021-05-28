package servicii;

import echipament.Echipament;
import medicament.Medicament;
import medicament.Reteta;
import persoana.Client;
import persoana.Medic;
import persoana.Programare;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.Date;

import static servicii.Queries.*;

public class Servicii {
    private static DbConnection dbConnection = DbConnection.getInstance();

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

    //Convert Timestamp to Calendar
    private static Calendar timestampToCalendar(Timestamp date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;

    }

    //Convert Calendar to Timestamp
    private static long calendarToTimestamp(Calendar calendar) {
        return  calendar.getTimeInMillis();
    }

    //Convert Date to Calendar
    private static Calendar dateToCalendar(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;

    }

    //Convert Calendar to Date
    private static long calendarToDate(Calendar calendar) {
        return calendar.getTimeInMillis();
    }


    public static void citireCSVDataBase(HashMap<String, Client> Clienti, HashMap<String, Medic> Medici, ArrayList<Programare> Programari, ArrayList<Reteta> Retete, ArrayList<Echipament> Echipamente) {

        /*try {
            File fisierClient = new File("csv.files/clientDataBase.csv");
            Scanner myReader = new Scanner(fisierClient);
            if (myReader.hasNextLine())
                myReader.nextLine();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] arg_of_Data = data.split(",");
                Client client = new Client();
                client.setCnp(arg_of_Data[0]);
                client.setNume(arg_of_Data[1]);
                client.setPrenume(arg_of_Data[2]);
                client.setAdresa(arg_of_Data[3]);
                client.setTelefon(arg_of_Data[4]);
                client.setAsigurat(Boolean.parseBoolean(arg_of_Data[5]));
                client.setRezultatTestCOVID(Boolean.parseBoolean(arg_of_Data[6]));
                client.setSalariat(Boolean.parseBoolean(arg_of_Data[7]));
                client.setBoli(arg_of_Data[8]);
                client.setAlergeni(arg_of_Data[9]);
                client.setGrupaSange(arg_of_Data[10]);
                Clienti.put(arg_of_Data[0], client);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul clientDataBase.csv nu a fost gasit!!!");
            e.printStackTrace();
        }

        try {
            File fisierMedic = new File("csv.files/medicDataBase.csv");
            Scanner myReader = new Scanner(fisierMedic);
            if (myReader.hasNextLine())
                myReader.nextLine();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] arg_of_Data = data.split(",");
                Medic medic = new Medic();
                medic.setCnp(arg_of_Data[0]);
                medic.setNume(arg_of_Data[1]);
                medic.setPrenume(arg_of_Data[2]);
                medic.setAdresa(arg_of_Data[3]);
                medic.setTelefon(arg_of_Data[4]);
                medic.setSpecializare(arg_of_Data[5]);
                medic.setAniExperienta(Integer.parseInt(arg_of_Data[6]));
                Calendar cal = Calendar.getInstance();
                cal.set(Integer.parseInt(arg_of_Data[9]), Integer.parseInt(arg_of_Data[8]), Integer.parseInt(arg_of_Data[7]));
                medic.setDataAngajarii(cal);
                Medici.put(arg_of_Data[0], medic);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul medicDataBase.csv nu a fost gasit!!!");
            e.printStackTrace();
        }

        try {
            File fisierProgramare = new File("csv.files/programareDataBase.csv");
            Scanner myReader = new Scanner(fisierProgramare);
            if (myReader.hasNextLine())
                myReader.nextLine();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] arg_of_Data = data.split(",");
                Programare programare = new Programare();
                Calendar cal = Calendar.getInstance();
                cal.set(Integer.parseInt(arg_of_Data[2]), Integer.parseInt(arg_of_Data[1]), Integer.parseInt(arg_of_Data[0]), Integer.parseInt(arg_of_Data[3]), Integer.parseInt(arg_of_Data[4]));
                programare.setData(cal);
                programare.setDetaliiProgramare(arg_of_Data[5]);
                programare.setRecomandari(arg_of_Data[6]);
                programare.setCnpClient(arg_of_Data[7]);
                programare.setCnpMedic(arg_of_Data[8]);
                Programari.add(programare);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul programareDataBase.csv nu a fost gasit!!!");
            e.printStackTrace();
        }

        try {
            File fisierEchipament = new File("csv.files/echipamentDataBase.csv");
            Scanner myReader = new Scanner(fisierEchipament);
            if (myReader.hasNextLine())
                myReader.nextLine();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] arg_of_Data = data.split(",");
                Echipament echipament = new Echipament();
                Producator producator = new Producator();
                producator.setNumeProducator(arg_of_Data[0]);
                producator.setTelefon(arg_of_Data[1]);
                echipament.setProducator(producator);
                echipament.setNumeEchipament(arg_of_Data[2]);
                echipament.setAnProductie(Integer.parseInt(arg_of_Data[3]));
                echipament.setPret(Float.parseFloat(arg_of_Data[4]));
                Echipamente.add(echipament);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul echipamentDataBase.csv nu a fost gasit!!!");
            e.printStackTrace();
        }*/

        try {
            File fisierReteta = new File("csv.files/retetaDataBase.csv");
            Scanner myReader = new Scanner(fisierReteta);
            if (myReader.hasNextLine())
                myReader.nextLine();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] arg_of_Data = data.split(",");
                Reteta reteta = new Reteta();
                HashMap<String, Medicament> listaMedicamente = new HashMap<>();
                reteta.setDurata(arg_of_Data[0]);
                String[] medicamente = arg_of_Data[1].split(";");
                for (int i = 0; i < medicamente.length / 3; ++i) {
                    Medicament medicament = new Medicament();
                    medicament.setDenumire(medicamente[3 * i]);
                    medicament.setModAdministrare(medicamente[3 * i + 1]);
                    medicament.setProspect(medicamente[3 * i + 2]);
                    listaMedicamente.put(medicament.getDenumire(), medicament);
                }
                reteta.setListaMedicamente(listaMedicamente);
                Retete.add(reteta);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul retetaDataBase.csv nu a fost gasit!!!");
            e.printStackTrace();
        }

    }

    //Scrierea in fisier
    public static void scriereDataBase(HashMap<String, Client> Clienti, HashMap<String, Medic> Medici, ArrayList<Programare> Programari, ArrayList<Reteta> Retete, ArrayList<Echipament> Echipamente) throws IOException {

        FileWriter scriereClient = new FileWriter("csv.files/clientDataBase.csv");
        scriereClient.write("cnp,nume,prenume,adresa,telefon,asigurat,rezultatTestCOVID,salariat,boli,alergeni,grupaSange\n");
        for (Map.Entry x : Clienti.entrySet()) {
            scriereClient.write(((Client) x.getValue()).getCnp()
                    + "," + ((Client) x.getValue()).getNume()
                    + "," + ((Client) x.getValue()).getPrenume()
                    + "," + ((Client) x.getValue()).getAdresa()
                    + "," + ((Client) x.getValue()).getTelefon()
                    + "," + ((Client) x.getValue()).isAsigurat()
                    + "," + ((Client) x.getValue()).isRezultatTestCOVID()
                    + "," + ((Client) x.getValue()).isSalariat()
                    + "," + ((Client) x.getValue()).getBoli()
                    + "," + ((Client) x.getValue()).getAlergeni()
                    + "," + ((Client) x.getValue()).getGrupaSange() + "\n");
        }
        scriereClient.close();


        FileWriter scriereMedic = new FileWriter("csv.files/medicDataBase.csv");
        scriereMedic.write("cnp,nume,prenume,adresa,telefon,specializare,aniExperienta,zi,luna,an\n");
        for (Map.Entry x : Medici.entrySet()) {
            scriereMedic.write(((Medic) x.getValue()).getCnp()
                    + "," + ((Medic) x.getValue()).getNume()
                    + "," + ((Medic) x.getValue()).getPrenume()
                    + "," + ((Medic) x.getValue()).getAdresa()
                    + "," + ((Medic) x.getValue()).getTelefon()
                    + "," + ((Medic) x.getValue()).getSpecializare()
                    + "," + ((Medic) x.getValue()).getAniExperienta()
                    + "," + ((Medic) x.getValue()).getDataAngajarii().get(Calendar.DATE)
                    + "," + (((Medic) x.getValue()).getDataAngajarii().get(Calendar.MONTH)+1)
                    + "," + ((Medic) x.getValue()).getDataAngajarii().get(Calendar.YEAR) + "\n");
        }
        scriereMedic.close();

        FileWriter scriereEchipament = new FileWriter("csv.files/echipamentDataBase.csv");
        scriereEchipament.write("numeProducator,telefon,numeEchipament,anProductie,pret\n");
        for (Echipament x : Echipamente) {
            scriereEchipament.write(x.getProducator().getNumeProducator()
                    + "," + x.getProducator().getTelefon()
                    + "," + x.getNumeEchipament()
                    + "," + x.getAnProductie()
                    + "," + x.getPret() + "\n");
        }
        scriereEchipament.close();

        FileWriter scriereProgramare = new FileWriter("csv.files/programareDataBase.csv");
        scriereProgramare.write("zi,luna,an,ora,minut,detaliiProgramare,recomandari,cnpClient,cnpMedic\n");
        for (Programare x : Programari)
            scriereProgramare.write(x.getData().get(Calendar.DATE) + ","
                    + (x.getData().get(Calendar.MONTH)+1)
                    + "," + x.getData().get(Calendar.YEAR)
                    + "," + x.getData().get(Calendar.HOUR_OF_DAY)
                    + "," + x.getData().get(Calendar.MINUTE)
                    + "," + x.getDetaliiProgramare()
                    + "," + x.getRecomandari()
                    + "," + x.getCnpClient()
                    + "," + x.getCnpMedic() + "\n");
        scriereProgramare.close();

        FileWriter scriereReteta = new FileWriter("csv.files/retetaDataBase.csv");
        scriereReteta.write("durata,listaMedicamente(denumire;modAdministrare;prospect)\n");
        for (Reteta x : Retete) {
            String str = "";
            HashMap<String, Medicament> listaMedicamente = x.getListaMedicamente();
            for (HashMap.Entry y : listaMedicamente.entrySet()) {
                str += ((Medicament) y.getValue()).getDenumire() + ";" +
                        ((Medicament) y.getValue()).getModAdministrare() + ";" +
                        ((Medicament) y.getValue()).getProspect() + ";";
            }
            str = str.substring(0, str.length() - 1);
            scriereReteta.write(x.getDurata() + "," + str + "\n");
        }
        scriereReteta.close();
    }

    // metoda de adaugare in audit.csv
    public static void adaugareAudit(String numeActiune,String timestamp) throws IOException {

        FileWriter scriereAudit = new FileWriter("csv.files/audit.csv", true);
        scriereAudit.write(numeActiune+"," + timestamp + "\n");
        scriereAudit.close();
    }

    //1) Adaugare Client in cadrul cabinetului medical.
    public static Client adaugareClient() {
        Client x = new Client();

        Scanner scan = new Scanner(System.in);

        System.out.println("CNP:");
        x.setCnp(scan.nextLine());

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
        x.setRezultatTestCOVID(TestCovid.equals("pozitiv"));

        System.out.println("Clientul este Salariat?(da/nu)");
        String Salariat = scan.nextLine().toLowerCase(Locale.ROOT);
        x.setSalariat(Salariat.equals("da"));

        System.out.println("Boli:");
        x.setBoli(scan.nextLine());

        System.out.println("Alergeni:");
        x.setAlergeni(scan.nextLine());

        System.out.println("Grupa sange:");
        x.setGrupaSange(scan.nextLine());


        return x;
    }

    //2) Afisare Clienti in cadrul cabinetului medical.
    public static void afisareClient(Client x) {
        System.out.println();
        System.out.println("-------------------------------------------------");
        System.out.println("CNP: " + " " + x.getCnp());
        System.out.println("Nume Prenume: " + x.getNume() + " " + x.getPrenume());
        System.out.println("Adresa: " + " " + x.getAdresa());
        System.out.println("Telefon: " + " " + x.getTelefon());

        if (x.isAsigurat())
            System.out.println("Asigurat: Da");
        else
            System.out.println("Asigurat: Nu");

        if (x.isRezultatTestCOVID())
            System.out.println("Rezultat Test COVID: POZITIV");
        else
            System.out.println("Rezultat Test COVID: NEGATIV");

        if (x.isSalariat())
            System.out.println("Salariat: Da");
        else
            System.out.println("Salariat: Nu");

        System.out.println("Boli: " + x.getBoli());
        System.out.println("Alergeni: " + " " + x.getAlergeni());
        System.out.println("Grupa Sange: " + " " + x.getGrupaSange());
    }

    //3) Modificare Client in cadrul cabinetului medical.
    public static Client modificareClient() {

        Client x = new Client();

        Scanner scan = new Scanner(System.in);

        System.out.println("CNP:");
        x.setCnp(scan.nextLine());

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
        x.setRezultatTestCOVID(TestCovid.equals("pozitiv"));

        System.out.println("Clientul este Salariat?(da/nu)");
        String Salariat = scan.nextLine().toLowerCase(Locale.ROOT);
        x.setSalariat(Salariat.equals("da"));

        System.out.println("Boli:");
        x.setBoli(scan.nextLine());

        System.out.println("Alergeni:");
        x.setAlergeni(scan.nextLine());

        System.out.println("Grupa sange:");
        x.setGrupaSange(scan.nextLine());

        return x;

    }

    //5 Afisare Numar de Clienti cu COVID/Numar de Clienti (Statistica)
    public static void statisticaCOVID(HashMap<String, Client> list) {
        int nrTotal = 0;
        int nrCovid = 0;

        for (Map.Entry x : list.entrySet()) {
            nrTotal++;
            if (((Client) x.getValue()).isRezultatTestCOVID())
                nrCovid++;
        }
        System.out.printf("Procentajul de clienti ce au COVID: %.2f",(float) nrCovid / nrTotal * 100);
        System.out.println("%");
    }

    //6) Afisare Media anilor de experienta a Medicilor
    public static void afisareMedieExperienta(HashMap<String, Medic> list) {
        int count = 0;
        int ani_experienta = 0;
        for (Map.Entry x : list.entrySet()) {
            ani_experienta += ((Medic) x.getValue()).getAniExperienta();
            ++count;
        }
        System.out.println("Media de experienta a medicilor: " + (float) ani_experienta / count + " ani");
    }

    //7) Afisarea celui mai vechi angajat (Medic)
    public static void afisareCelMaiVechiMedic(HashMap<String, Medic> list) {
        Calendar minDate = Calendar.getInstance();

        String Nume = "", Prenume = "", Specializare = "";

        for (Map.Entry x : list.entrySet()) {
            if (minDate.after(((Medic) x.getValue()).getDataAngajarii())) {
                minDate = ((Medic) x.getValue()).getDataAngajarii();
                Nume = ((Medic) x.getValue()).getNume();
                Prenume = ((Medic) x.getValue()).getPrenume();
                Specializare = ((Medic) x.getValue()).getSpecializare();
            }

        }
        if (Nume.equals("") && Prenume.equals("") && Specializare.equals(""))
            System.out.println("Nu exista cel mai vechi medic angajat:");
        else
            System.out.println("Cel mai vechi medic angajat este:" + Nume + " " + Prenume + " " + Specializare);
    }

    //8) Adaugare programare in cadrul cabinetului medical.
    public static Programare adaugareProgramare(String cnp_client, String cnp_medic) {
        Programare x = new Programare();
        Scanner scan = new Scanner(System.in);
        int zi, luna, an, ora, minut;

        x.setCnpClient(cnp_client);
        x.setCnpMedic(cnp_medic);

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
        x.setDetaliiProgramare(scan.nextLine());

        System.out.print("Recomandari: ");
        x.setRecomandari(scan.nextLine());

        return x;
    }

    //9) Afisarea programarilor in cadrul cabinetului medical.
    public static void afisareProgramare(Programare x) {

        System.out.println("Data Programarii este (Ziua/Luna/An Ora:Minutul): " + x.getData().get(Calendar.DATE) + "/" + (x.getData().get(Calendar.MONTH)+1) + "/" + x.getData().get(Calendar.YEAR) + " " + x.getData().get(Calendar.HOUR_OF_DAY) + ":" + x.getData().get(Calendar.MINUTE));
        System.out.println("Detalii Programare: " + x.getDetaliiProgramare());
        System.out.println("Recomandari: " + x.getRecomandari());
        System.out.println("CNP Client: " + x.getCnpClient());
        System.out.println("CNP Medic: " + x.getCnpMedic());

    }

    //10) Afisare valoare medie a echipamentelor.
    public static void afisareValoareaMediaEchipamente(ArrayList<Echipament> list) {
        int count = 0;
        float valoare = 0;
        for (Echipament it : list) {
            ++count;
            valoare += it.getPret();
        }

        System.out.println(valoare / (float) count);
    }

    // COMENZI APLICATE PE MY_SQL DATA_BASE
    public static void citireMYSQLDB(HashMap<String, Client> Clienti, HashMap<String, Medic> Medici, ArrayList<Programare> Programari, ArrayList<Echipament> Echipamente){

        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(READ_CLIENTI);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Client client = new Client(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getBoolean(6),resultSet.getBoolean(7),resultSet.getBoolean(8),resultSet.getString(9),resultSet.getString(10),resultSet.getString(11) );
                Clienti.put(resultSet.getString(1),client);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(READ_MEDICI);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Medic medic = new Medic(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),resultSet.getInt(7),dateToCalendar(resultSet.getDate(8)));
                Medici.put(resultSet.getString(1),medic);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(READ_PROGRAMARI);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Programare programari = new Programare(timestampToCalendar(resultSet.getTimestamp(2)), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
                Programari.add(programari);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(READ_ECHIPAMENTE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Echipament echipament = new Echipament(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5),resultSet.getFloat(6));
                Echipamente.add(echipament);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //INSERT ON TABEL CLIENT
    public static  void insertClient(Client client){

        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(INSERT_NEW_PERSOANA, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, client.getCnp());
            preparedStatement.setString(2, client.getNume());
            preparedStatement.setString(3, client.getPrenume());
            preparedStatement.setString(4, client.getAdresa());
            preparedStatement.setString(5, client.getTelefon());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("S-a detectat o problema la adaugarea unui client");
        }

        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(INSERT_NEW_CLIENT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, client.getCnp());
            preparedStatement.setBoolean(2, client.isAsigurat());
            preparedStatement.setBoolean(3, client.isRezultatTestCOVID());
            preparedStatement.setBoolean(4, client.isSalariat());
            preparedStatement.setString(5, client.getBoli());
            preparedStatement.setString(6, client.getAlergeni());
            preparedStatement.setString(7, client.getGrupaSange());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("S-a detectat o problema la adaugarea unui client");
        }

    }

    //INSERT ON TABEL MEDIC
    public static  void insertMedic(Medic medic){

        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(INSERT_NEW_PERSOANA, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, medic.getCnp());
            preparedStatement.setString(2, medic.getNume());
            preparedStatement.setString(3, medic.getPrenume());
            preparedStatement.setString(4, medic.getAdresa());
            preparedStatement.setString(5, medic.getTelefon());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("S-a detectat o problema la adaugarea unui medic");
        }

        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(INSERT_NEW_MEDIC, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, medic.getCnp());
            preparedStatement.setString(2, medic.getSpecializare());
            preparedStatement.setInt(3, medic.getAniExperienta());
            preparedStatement.setDate(4, new java.sql.Date(calendarToDate(medic.getDataAngajarii())));
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("S-a detectat o problema la adaugarea unui medic");
        }

    }

    //INSERT ON  TABEL PROGRAMARE
    public static void insertProgramare(Programare programare)
    {
        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(INSERT_NEW_PROGRAMARE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setTimestamp(1, new java.sql.Timestamp(calendarToTimestamp(programare.getData())));
            preparedStatement.setString(2, programare.getDetaliiProgramare());
            preparedStatement.setString(3, programare.getRecomandari());
            preparedStatement.setString(4, programare.getCnpClient());
            preparedStatement.setString(5, programare.getCnpMedic());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("S-a detectat o problema la adaugarea programarii");
        }
    }

    //INSERT ON  TABEL ECHIPAMENT
    public static void insertEchipament(Echipament echipament)
    {
        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(INSERT_NEW_ECHIPAMENT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, echipament.getProducator().getNumeProducator());
            preparedStatement.setString(2, echipament.getProducator().getTelefon());
            preparedStatement.setString(3, echipament.getNumeEchipament());
            preparedStatement.setInt(4, echipament.getAnProductie());
            preparedStatement.setFloat(5, echipament.getPret());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("S-a detectat o problema la adaugarea echipamentului");
        }
    }

    //UPDATE ON TABEL CLIENT
    public static void  updateClient(String cnp, Client client){

        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(UPDATE_PERSOANA, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, client.getCnp());
            preparedStatement.setString(2, client.getNume());
            preparedStatement.setString(3, client.getPrenume());
            preparedStatement.setString(4, client.getAdresa());
            preparedStatement.setString(5, client.getTelefon());
            preparedStatement.setString(6, cnp);
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("S-a detectat o problema la actualizarea unei persoane");
        }

        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(UPDATE_CLIENT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, client.getCnp());
            preparedStatement.setBoolean(2, client.isAsigurat());
            preparedStatement.setBoolean(3, client.isRezultatTestCOVID());
            preparedStatement.setBoolean(4, client.isSalariat());
            preparedStatement.setString(5, client.getBoli());
            preparedStatement.setString(6, client.getAlergeni());
            preparedStatement.setString(7, client.getGrupaSange());
            preparedStatement.setString(8, client.getCnp());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("S-a detectat o problema la actualizarea unui client");
        }
    }

    //UPDATE ON TABEL MEDIC
    public static void updateMedic(String cnp, Medic medic){

        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(UPDATE_PERSOANA, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, medic.getCnp());
            preparedStatement.setString(2, medic.getNume());
            preparedStatement.setString(3, medic.getPrenume());
            preparedStatement.setString(4, medic.getAdresa());
            preparedStatement.setString(5, medic.getTelefon());
            preparedStatement.setString(6, cnp);
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("S-a detectat o problema la actualizarea unei persoane");
        }

        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(UPDATE_MEDIC, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, medic.getCnp());
            preparedStatement.setString(2, medic.getSpecializare());
            preparedStatement.setInt(3, medic.getAniExperienta());
            preparedStatement.setDate(4, new java.sql.Date(calendarToDate(medic.getDataAngajarii())));
            preparedStatement.setString(5,medic.getCnp());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("S-a detectat o problema la actualizarea unui medic");
        }
    }

    //DELETE ON TABEL PERSOANA
    public static void deletePersoana(String cnp){
        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(DELETE_PERSOANA,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, cnp);
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("S-a detectat o problema la stergerea unei persoane");
        }
    }

    //DELETE ON TABEL PROGRAMARE
    public static void deleteProgramare(String cnp_c,String cnp_m){

        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(DELETE_PROGRAMARE,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, cnp_c);
            preparedStatement.setString(1, cnp_m);
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("S-a detectat o problema la stergerea unei programari");
        }
    }

}
