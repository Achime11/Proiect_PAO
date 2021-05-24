package servicii;

import echipament.Echipament;
import medicament.Reteta;
import persoana.Client;
import persoana.Medic;
import persoana.Programare;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void initiziarizareMeniu() {
        System.out.println("-------- Achimescu Ionut-Valentin || Grupa 244 || Proiect PAO --------");
        System.out.println("-------- Programari Cabinet Medical --------");
        System.out.println("---- Pentru a folosi o optiune a meniului, tastati numarul corespunzator optiunii alese --------");
        System.out.println("-------- Meniul cu optiuni --------");

        System.out.println();
        System.out.println("1. Adaugare Client in cadrul cabinetului medical.");
        System.out.println("2. Afisare Clienti in cadrul cabinetului medical.");
        System.out.println("3. Modificare Client in cadrul cabinetului medical.");
        System.out.println("4. Stergere Client in cadrul cabinetului medical.");
        System.out.println("5. Afisare Numar de Clienti cu COVID/Numar de Clienti (Statistica)");
        System.out.println("6. Afisare Media anilor de experienta a Medicilor");
        System.out.println("7. Afisarea celui mai vechi angajat (Medic)");
        System.out.println("8. Adaugare programare in cadrul cabinetului medical.");
        System.out.println("9. Afisarea programarilor in cadrul cabinetului medical.");
        System.out.println("10. Afisare valoare medie a echipamentelor.");
        System.out.println("0. Iesire.");

    }

    public static void main(String[] args) throws IOException {

        //Initializarea datelor
        HashMap<String, Client> Clienti = new HashMap<>();
        HashMap<String, Medic> Medici = new HashMap<>();
        ArrayList<Programare> Programari = new ArrayList<>();
        ArrayList<Reteta> Retete = new ArrayList<>();
        ArrayList<Echipament> Echipamente = new ArrayList<>();
        Servicii.citireCSVDataBase(Clienti, Medici, Programari, Retete, Echipamente);
        Servicii.citireMYSQLDB(Clienti,Medici,Programari,Echipamente);
        //Sorting
        Programari.sort(Programare::compareTo);
        Echipamente.sort(Echipament::compareTo);
        //Testare JDBC SERVICIES
        Medic medic = new Medic();


        //main
        Scanner scan = new Scanner(System.in);
        int opt;
        do {
            Date data = new Date();
            SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String timestamp = formater.format(data);
            initiziarizareMeniu();
            System.out.println();
            System.out.println();
            System.out.println("Optiunea aleasa: ");
            opt = scan.nextInt();
            switch (opt) {
                case 1:
                    Client client = Servicii.adaugareClient();
                    data = new Date();
                    timestamp = formater.format(data);
                    Servicii.adaugareAudit("Adaugare client",timestamp);
                    Servicii.insertClient(client);
                    Clienti.put(client.getCnp(), client);
                    System.out.println("Client adaugat!");
                    break;
                case 2:
                    System.out.println("Afisare Clienti");
                    for (Map.Entry x : Clienti.entrySet())
                        Servicii.afisareClient((Client) x.getValue());
                    data = new Date();
                    timestamp = formater.format(data);
                    Servicii.adaugareAudit("Afisare clienti",timestamp);
                    break;
                case 3:
                    System.out.println("Modificare Client(Introduceti datele clientului)");

                    System.out.println("CNP: ");
                    String cnp = scan.next();

                    if(Clienti.containsKey(cnp)){
                        Client a = Servicii.modificareClient();
                        Clienti.remove(cnp);
                        Clienti.put(a.getCnp(), a);
                        Servicii.updateClient(cnp,a);

                        data = new Date();
                        timestamp = formater.format(data);
                        Servicii.adaugareAudit("Modificare client",timestamp);
                    }
                    else System.out.println("Nu exista un client cu acest CNP!!!");

                    break;
                case 4:
                    System.out.println("Stergere Client(Introduceti datele clientului)");
                    System.out.println("CNP: ");
                    String cnp_stergere = scan.next();

                    if(Clienti.containsKey(cnp_stergere)){
                        Clienti.remove(cnp_stergere);
                        Servicii.deletePersoana(cnp_stergere);

                        data = new Date();
                        timestamp = formater.format(data);
                        Servicii.adaugareAudit("Stergere client",timestamp);
                    }
                    else System.out.println("Nu exista un client cu acest CNP!!!");


                    break;
                case 5:
                    System.out.println("Statistica COVID!");
                    Servicii.statisticaCOVID(Clienti);
                    data = new Date();
                    timestamp = formater.format(data);
                    Servicii.adaugareAudit("Statistica COVID",timestamp);
                    break;
                case 6:
                    System.out.println("Afisarea mediei de experienta a Medicilor");
                    Servicii.afisareMedieExperienta(Medici);
                    data = new Date();
                    timestamp = formater.format(data);
                    Servicii.adaugareAudit("Afisarea mediei de experienta a Medicilor",timestamp);
                    break;
                case 7:
                    System.out.println("Afisarea celui mai vechi medic!");
                    Servicii.afisareCelMaiVechiMedic(Medici);
                    data = new Date();
                    timestamp = formater.format(data);
                    Servicii.adaugareAudit("Afisarea celui mai vechi medic",timestamp);
                    break;
                case 8:
                    System.out.println("Date medici");
                    for (Map.Entry x : Medici.entrySet())
                        System.out.println(x.getValue().toString());
                    System.out.println("Adaugare programare");
                    System.out.println("CNP Client: ");
                    String cnp_client = scan.next();
                    System.out.println("CNP Medic: ");
                    String cnp_medic = scan.next();
                    Programare aux = Servicii.adaugareProgramare(cnp_client, cnp_medic);
                    Servicii.insertProgramare(aux);
                    Programari.add(aux);
                    data = new Date();
                    timestamp = formater.format(data);
                    Servicii.adaugareAudit("Adaugare programare",timestamp);
                    break;
                case 9:
                    System.out.println("Afisarea programarilor");
                    for (Programare it : Programari)
                        Servicii.afisareProgramare(it);
                    data = new Date();
                    timestamp = formater.format(data);
                    Servicii.adaugareAudit("Afisarea programarilor",timestamp);
                    break;
                case 10:
                    System.out.println("Afisarea valori medii a echipamentelor!");
                    Servicii.afisareValoareaMediaEchipamente(Echipamente);
                    data = new Date();
                    timestamp = formater.format(data);
                    Servicii.adaugareAudit("Afisarea valori medii a echipamentelor",timestamp);
                    break;
                case 0:
                    Servicii.scriereDataBase(Clienti, Medici, Programari, Retete, Echipamente);
                    System.exit(0);
                    break;
                default:
                    System.out.println("OPTIUNEA ALEASA ESTE INVALIDA!");
                    System.out.println("ALEGETI O OPTIUNE VALIDA!");
            }
        } while (opt != -1);

    }
}
