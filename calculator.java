import java.util.Scanner;

public class Main {

	public static double Calculate(double com) {
		double pay = 0;
		
		//Pay if making less than $15,000 in spread, you are given 2% of that weekly spread as take home pay
		if (com < 15000) {
			pay = com *= .02;
		} 
		//Pay if making more than $15,000 in weekly spread but less than $30,000, you are given 6% of that weekly spread as take home pay
		else if (com >= 15000 && com < 30000) {
			com -= 15000;
			pay = com *= .06;
			pay += 300;
		} 
		//Pay if making more than $30,000 in weekly spread but less than $45,000, you are given 8% of that weekly spread as take home pay
		else if (com >= 30000 && com < 45000) {
			com -= 30000;
			pay = com *= .08;
			pay += 1200;
		} 
		//Pay if making more than $45,000 in spread, you are given 10% of that weekly spread as take home pay
		else {
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
			read = read.replaceAll("[^\\d.]", "");
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
