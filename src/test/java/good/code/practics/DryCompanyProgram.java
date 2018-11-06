package good.code.practics;

import java.util.ArrayList;
import java.util.List;

import static good.code.practics.Position.*;

public class DryCompanyProgram {

    private static final String CITY_WROCLAW = "Wrocław";

    public static void main(String[] args) {
        System.out.println("Tester in the company are: ");
        List<Tester> listOfTestersInCompany = new ArrayList<>();

        Tester testerKazimierz = new Tester("Kazimierz", JUNIOR_MANUAL_TESTER.getPositionName(), CITY_WROCLAW, 31);
        Tester testerZygmunt = new Tester("Zygmunt", JUNIOR_MANUAL_TESTER.getPositionName(), CITY_WROCLAW, 21);
        Tester testerAnna = new Tester("Anna", LEAD_MANUAL_TESTER.getPositionName(), CITY_WROCLAW, 44);
        Tester testerStefan = new Tester("Stefan", SENIOR_MANUAL_TESTER.getPositionName(), CITY_WROCLAW, 28);

        listOfTestersInCompany.add(testerKazimierz);
        listOfTestersInCompany.add(testerZygmunt);
        listOfTestersInCompany.add(testerAnna);
        listOfTestersInCompany.add(testerStefan);

        for (Tester tester : listOfTestersInCompany) {
            System.out.println(tester.toString());
        }

    }

}

/* This class needed to be refactored with DRY principles:

public class NotDryCompanyProgram {

    public static String standardFormat = "%s is %s, works in %s, age %s";

    public static void main(String[] args) {
        System.out.println("Tester in the company are: ");
        introduceTester();
        introduceTester2();
        introduceTester3();
        introduceTester5();
    }

    private static void introduceTester() {
        String message = String.format(standardFormat, "Kazimierz", "Junior Manual Tester",  "Wrocław", 31);
        System.out.println(message);
    }

    private static void introduceTester5() {
        String message = String.format(standardFormat, "Zygmunt", "Junior Manual Tester",  "Wrocław", 21);
        System.out.println(message);
    }

    private static void introduceTester3() {
        String message = String.format(standardFormat, "Anna", "Lead Manual Tester",  "Wrocław", 44);
        System.out.println(message);
    }

    private static void introduceTester2() {
        String message = String.format(standardFormat, "Stefan", "Senior manual tester",  "Wrocław", 28);
        System.out.println(message);
    }

}*/
