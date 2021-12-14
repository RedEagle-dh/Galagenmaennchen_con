import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class AufgabeAServer {
    // Schreiben Sie einen TCP Server, der wiederholt Textzeilen von einem Client empfangen kann.
    // Der Server sendet dem Client nach jeder empfangenen Zeile ein OK zurück.

    ServerSocket ss;
    PrintWriter pw;
    BufferedReader br;
    Socket s;

    public AufgabeAServer() {
        try {
            Galgenmaennchen game = new Galgenmaennchen();
            ss = new ServerSocket(1234);
            s = ss.accept();
            pw = new PrintWriter(s.getOutputStream(), true);
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));

            while (!game.gewonnen() && !game.verloren()) {
                pw.println(game.getAktuellerStringMitLeerzeichen());
                String newline = br.readLine();
                if (!newline.isEmpty() && game.rate(newline.charAt(0))) {
                    pw.println("OK");
                    //pw.println(game.getAktuellerStringMitLeerzeichen());
                } else {
                    pw.println("Leider falsch!");
                    //pw.println(game.getAktuellerStringMitLeerzeichen());
                }
            }

            if (game.gewonnen()) {
                pw.println("Glückwunsch, du hast gewonnen! Du hast nur " + game.getVersuche() + " Versuche gebraucht!");

            } else
                pw.println("Du hast verloren. Schade, vielleicht nächstes Mal! Das gesuchte Wort war " + game.getZuErraten());
            s.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new AufgabeAServer();
    }
}
