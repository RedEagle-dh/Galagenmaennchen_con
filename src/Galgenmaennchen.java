public class Galgenmaennchen {

    private static final String[] WOERTER = {
            "PROGRAMMIERSPRACHE",
            "TEST",
            "JAVA",
            "GALGEN",
            "KRYPTIK"
    };

    String zuErraten;
    String aktuellerString = "";
    int versuche = 0;

    /**
     * constructor for unit tests
     */
    public Galgenmaennchen(String zuErraten, int bisherigeVersuche) {
        this();
        this.zuErraten = zuErraten;

        aktuellerString = "";
        for (int i = 0; i < this.zuErraten.length(); i++)
            aktuellerString += '_';

        versuche = bisherigeVersuche;
    }

    public Galgenmaennchen() {
        int index = (int) (Math.random() * WOERTER.length);
        zuErraten = WOERTER[index];

        for (int i = 0; i < zuErraten.length(); i++)
            aktuellerString += '_';
    }

    public boolean rate(char rateversuch) {
        versuche++;
        boolean treffer = false;
        char[] aktuell = aktuellerString.toCharArray();
        char[] erraten = zuErraten.toCharArray();
        for (int i = 0; i < erraten.length; i++) {
            if (erraten[i] == rateversuch) {
                aktuell[i] = rateversuch;
                treffer = true;
            }
        }
        aktuellerString = new String(aktuell);
        return treffer;
    }

    public boolean gewonnen() {
        return aktuellerString.indexOf('_') == -1;
    }

    public boolean verloren() {
        return versuche == 15 && !gewonnen();
    }

    public String getAktuellerStringMitLeerzeichen() {
        String s = "";
        for (int i = 0; i < aktuellerString.length(); i++) {
            s = s + aktuellerString.charAt(i) + " ";
        }
        return s;
    }

    public int getVersuche() {
        return versuche;
    }

    public String getZuErraten() {
        return zuErraten;
    }
}
