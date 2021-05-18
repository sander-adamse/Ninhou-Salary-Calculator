import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Uitrekenen {
    private Date date1, date2;
    private SimpleDateFormat sDF = new SimpleDateFormat("HH:mm");
    private static File bestand = new File("2021.csv");
    private int aantalKm;
    private static int uurLoon = 9;
    private static double minuutLoon = 0.15, kilometerVergoeding = 0.2;

    // Constructor
    public Uitrekenen(String beginTijd, String eindTijd, int aantalKm) {
        try {
            this.date1 = sDF.parse(beginTijd);
            this.date2 = sDF.parse(eindTijd);
            this.aantalKm = aantalKm;
        } catch (Exception e) {
        }
    }

    // Calculates MilliSeconds between two times
    public double calculateMilliSeconds() {
        long differenceInMilliSeconds = Math.abs(date2.getTime() - date1.getTime());
        return differenceInMilliSeconds;
    }

    // Calculates Hours between two times
    public double calculateHours() {
        long differenceInHours = (long) ((calculateMilliSeconds() / (60 * 60 * 1000)) % 24);
        return differenceInHours;
    }

    // Calculates Minutes between two times
    public double calculateMinutes() {
        long differenceInMinutes = (long) ((calculateMilliSeconds() / (60 * 1000)) % 60);
        return differenceInMinutes;
    }

    // Calculates Total
    public double calculateTotal() {
        double d = (calculateHours() * uurLoon) + (calculateMinutes() * minuutLoon) + (aantalKm * kilometerVergoeding);
        double roundDbl = Math.round(d * 100.0) / 100.0;
        return roundDbl;
    }

    // Returns Kilometers
    public int getAantalKm() {
        return aantalKm;
    }

    // Creates File
    public void CreateFile() {
        try {
            if (!bestand.exists()) {
                bestand.createNewFile();
                FileWriter fW = new FileWriter(bestand, true);
                BufferedWriter bW = new BufferedWriter(fW);
                bW.write("Hoeveelheid;Datum\n");
                bW.close();
            } else {
                System.out.println("File: 2021.csv exists!");
            }
        } catch (Exception e) {
            System.out.println("An error has ocurred!");
        }
    }

    // Writes File
    public void WriteFile(double bedrag) {
        try {
            if (!bestand.exists()) {
                this.CreateFile();
            }
            FileWriter fW = new FileWriter(bestand, true);
            BufferedWriter bW = new BufferedWriter(fW);
            bW.write(bedrag + ";" + java.time.LocalDate.now() + "\n");
            bW.close();
        } catch (Exception e) {
            System.out.println("An error has ocurred!");
        }
    }
}
