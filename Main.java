import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import classes.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		char confirmation = 'n';

		do {
		
			System.out.println("=- PLATE CODING CHECKER -=");
			System.out.print("Plate No: ");
			String plateNo = sc.readLine();

			System.out.print("Day: ");
			String day = sc.readLine();

			System.out.print("Place: ");
			String place = sc.readLine();

			System.out.print("Time: ");
			int time = Integer.parseInt(sc.readLine());

			System.out.println("========    RESULTS    ========");

			CarInformation carInformation = new CarInformation(plateNo, day, place, time);
			carInformation.printCarInformation();

			System.out.println("====== END OF RESULTS ========");

			System.out.print("Try Again? [Y/N]: ");
			confirmation = sc.readLine().charAt(0);
		} while (confirmation == 'y');


	}

}
