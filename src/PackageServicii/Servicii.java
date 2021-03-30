package PackageServicii;
import PackageMedicament.Medicament;
import PackageReteta.Reteta;

import java.util.*; // random,scanner,arraylist,etc.
import java.lang.*;

public class Servicii {
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
            med.setProstect(Prospect);

            list_med.put(den , med);
        }
        b.setLista_medicamente(list_med);
        System.out.println(b.toString());
    }
}
