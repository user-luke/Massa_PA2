import java.util.Scanner;

public class Decryption {

	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		
		int startDigit;
		int dig1;
		int dig2;
		int dig3;
		int dig4;
		int temp;
		
		//user input prompt & scan
		System.out.println("Enter 4-digit encrypted integer:");
		
		startDigit = scnr.nextInt();
		
		//math to get the correct place digits
		dig1 = startDigit / 1000;
		temp = startDigit / 100;
		dig2 = temp % 10;
		temp = startDigit / 10;
		dig3 = temp % 10;
		dig4 = startDigit % 10;
		
		//System.out.println(dig1 +"" +  dig2 + "" + dig3 + "" + dig4);
		
		//swap the digits to correct place first
		temp = dig1;
		dig1 = dig3;
		dig3 = temp;
		temp = dig2;
		dig2 = dig4;
		dig4 = temp;
		
		//subtract 7 and check if the number < 0
		dig1 = dig1 - 7;
		if (dig1 < 0 ) {
			dig1 = dig1 + 10;
		}
		dig2 = dig2 - 7;
		if (dig2 < 0 ) {
			dig2 = dig2 + 10;
		}
		dig3 = dig3 - 7;
		if (dig3 < 0 ) {
			dig3 = dig3 + 10;
		}
		dig4 = dig4 - 7;
		if (dig4 < 0 ) {
			dig4 = dig4 + 10;
		}
		
		//printing the decrypted value
		System.out.printf("%d%d%d%d", dig1, dig2, dig3, dig4 );
		
		
		

	}

}
