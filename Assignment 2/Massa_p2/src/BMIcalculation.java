import java.util.Scanner;
import java.lang.Math;
import java.lang.String;

public class BMIcalculation {

	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		double weight;
		double height;
		double BMI;
		
		
		System.out.println("How do you want your BMI calculated? (lb or kg)");
		String calculationType = scnr.nextLine();
		
		//lb prompts and calculations
		if (calculationType.equals("lb") ) {
		   System.out.println("Please type your height in inches:");
		   height = scnr.nextDouble();
		   System.out.println("Please type your weight in pounds:");
		   weight = scnr.nextDouble();
		   
		   //BMI calculation
		   BMI = ( 703 * weight) / (Math.pow(height, 2));
		   
		   System.out.printf("Your BMI is: %.1f", BMI);
		}
		//kg prompts and calculations
		else if (calculationType.contentEquals("kg")) {
			System.out.println("Please type your height in meters:");
			height = scnr.nextDouble();
			System.out.println("Please type your weight in kilograms:");
			weight = scnr.nextDouble();
			   
			//BMI calculation
			BMI = weight / (Math.pow(height, 2));
			   
			System.out.printf("Your BMI is: %.1f\n\n", BMI);
		}
		
		System.out.println("BMI Categories:");
		System.out.println("Underweight = <18.5");
		System.out.println("Normal weight = 18.5-24.9");
		System.out.println("Overweight = 25-29.9");
		System.out.println("Obesity = BMI of 30 or greater");
		
		
	}

}
