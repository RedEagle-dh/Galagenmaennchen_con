import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class AufgabeAClient {

    Socket s;
    PrintWriter pw;
    BufferedReader br;
    Scanner scan;

    public AufgabeAClient() {
        try {
            s = new Socket("localhost", 1234);
            pw = new PrintWriter(s.getOutputStream(), true);
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            scan = new Scanner(System.in);

            while (s.isConnected()) {
                System.out.println(br.readLine());
                pw.println(scan.nextLine());
                System.out.println(br.readLine());

            }
            System.out.println("Disconnected...");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        new AufgabeAClient();
    }
}
