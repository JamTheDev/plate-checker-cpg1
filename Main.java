//Program Name and Description

import java.util.Scanner;

public class Main {

	static boolean test;
	
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		char confirmation = 'n';

		do {
			
			System.out.print("Plate No: ");
			String plateNo = sc.nextLine();

			System.out.print("Day: ");
			String day = sc.nextLine();

			System.out.print("Place: ");
			String place = sc.nextLine();

			System.out.print("Time: ");
			int time = sc.nextInt();
			
			CarInformation carInformation = new CarInformation(plateNo, day, place, time);

			carInformation.printCarInformation();

			System.out.println("=========================");

			System.out.print("Try Again? [Y/N]: ");
			confirmation = sc.next().toLowerCase().charAt(0);
		} while (confirmation == 'y');

		sc.close();

	}

}
