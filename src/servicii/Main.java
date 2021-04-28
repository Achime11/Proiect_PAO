package servicii;

import persoana.Client;
import echipament.Echipament;
import persoana.Medic;
import persoana.Programare;
import medicament.Reteta;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
        Servicii.citireDataBase(Clienti,Medici,Programari,Retete,Echipamente);
        //main
        Scanner scan = new Scanner(System.in);
        int opt;
        do {
            initiziarizareMeniu();
            System.out.println();
            System.out.println();
            System.out.println("Optiunea aleasa: ");
            opt = scan.nextInt();
            switch (opt) {
                case 1:
                    Client client = Servicii.adaugareClient();
                    Clienti.put(client.getCnp(), client);
                    System.out.println("Client adaugat!");
                    break;
                case 2:
                    System.out.println("Afisare Clienti");
                    for (Map.Entry x : Clienti.entrySet())
                        Servicii.afisareClient((Client) x.getValue());
                    break;
                case 3:
                    System.out.println("Modificare Client(Introduceti datele clientului)");

                    System.out.println("Nume: ");
                    String Nume = scan.next();
                    System.out.println("Prenume: ");
                    String Prenume = scan.next();
                    for (Map.Entry x : Clienti.entrySet())
                        if(Nume.equals(((Client)x.getValue()).getNume()) && Prenume.equals(((Client)x.getValue()).getPrenume()))
                        {
                            Client a = Servicii.modificareClient();
                            Clienti.replace((String) x.getKey(),a);
                        }
                    break;
                case 4:
                    System.out.println("Stergere Client(Introduceti datele clientului)");
                    System.out.println("Nume: ");
                    String Nume_stergere = scan.next();
                    System.out.println("Prenume: ");
                    String Prenume_stergere = scan.next();
                    for (Map.Entry x : Clienti.entrySet())
                        if(Nume_stergere.equals(((Client)x.getValue()).getNume()) && Prenume_stergere.equals(((Client)x.getValue()).getPrenume()))
                        {
                            Clienti.remove(x.getKey());
                            break;
                        }
                    break;
                case 5:
                    System.out.println("Statistica COVID!");
                    Servicii.statisticaCOVID(Clienti);
                    break;
                case 6:
                    System.out.println("Afisare Media de experienta a Medicilor");
                    Servicii.afisareMedieExperienta(Medici);
                    break;
                case 7:
                    System.out.println("Afisare celui mai vechi medic!");
                    Servicii.afisareCelMaiVechiMedic(Medici);
                    break;
                case 8:
                    System.out.println("Date medici");
                    for(Map.Entry x: Medici.entrySet())
                        System.out.println(((Medic)x.getValue()).toString());
                    System.out.println("Adaugare programare");
                    System.out.println("CNP Client: ");
                    String cnp_client=scan.next();
                    System.out.println("CNP Medic: ");
                    String cnp_medic=scan.next();
                    Programare aux = Servicii.adaugareProgramare(cnp_client,cnp_medic);
                    Programari.add(aux);
                    break;
                case 9:
                    System.out.println("Afisare Programari");
                    for (Programare it:Programari)
                        Servicii.afisareProgramare(it);
                    break;
                case 10:
                    System.out.println("Afisare Valoarea medie a echipamentelor!");
                    Servicii.afisareValoareaMediaEchipamente(Echipamente);
                    break;
                case 0:
                    Servicii.scriereDataBase(Clienti,Medici,Programari,Retete,Echipamente);
                    System.exit(0);
                    break;
                default:
                    System.out.println("OPTIUNEA ALEASA ESTE INVALIDA!");
                    System.out.println("ALEGETI O OPTIUNE VALIDA!");
            }
        } while (opt != -1);

    }
}
