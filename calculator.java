import java.util.Scanner;

public class Main {

	public static double Calculate(double com) {
		double pay = 0;
		
		if (com < 15000) {
			pay = com *= .02;
		} else if (com >= 15000 && com < 30000) {
			com -= 15000;
			pay = com *= .06;
			pay += 300;
		} else if (com >= 30000 && com < 45000) {
			com -= 30000;
			pay = com *= .08;
			pay += 1200;
		} else {
			com -= 45000;
			pay = com *= .1;
			pay += 2400;
		}
		return pay;
	}

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		boolean check = true;
		double pay = 0;
		while (check) {
			System.out.print("Please enter amount of spread (press enter to terminate): ");
			String read = reader.nextLine();
			if (!read.isBlank()) {
				double com = Double.parseDouble(read);
				pay = Calculate(com);
				System.out.printf("Weekly pay: $%.2f", pay);
				System.out.println();
				pay *= 52;
				System.out.printf("Yearly pay: $%.2f", pay);
				System.out.println();
				System.out.println();
			} else {
				check = false;
			}
		}
		reader.close();
	}
}
