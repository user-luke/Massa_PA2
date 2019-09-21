import java.util.Scanner;

public class issueTable {

	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		
		String topics[] = new String[]{"Videogames", "School", "Politics", "Global Warming", "Athletics"};
		int [][] responses = new int[5][10];
		int userInput = 0;
		int rows = 0;
		int countRows = 0;
		int countColumns = 0;
		int highest = 0;
		int lowest = 0;
		int highestTopicRow = 0;
		int lowestTopicRow = 0;
		
		double [] topicAvg = new double[5];
		
		//keep track of the total averages for each topic
		int [] topicPointTot = new int[5];
		
		//keep track of the total number of responses for each row to be able to calculate average later
		int [] numResponses = new int [5];
		
		//initialize all spaces in the table to be 0
		while (countRows < topics.length) {
			while (countColumns < 10) {
				responses[countRows][countColumns] = 0;
				countColumns++;
			}
			countRows++;
		}
		
		//initialize the numResponses array to 0 in all places
		for ( int i = 0; i < numResponses.length; i++) {
			numResponses[i] = 0;
		}
		
		//initialize the total points array to 0 in all places
			for ( int i = 0 ; i < topicPointTot.length; i++) {
				topicPointTot[i] = 0;
			}
		
		
		while (rows < topics.length) {
			//reset the userInput variable so that the loop below starts again
			userInput = 0;
			while ( userInput != -1) {
				System.out.println("How important would you rate " + topics[rows] +" on a scale of 0-9? Type -1 when participant(s) are finished with this topic");
				userInput = scnr.nextInt();
				if (userInput <= 9 && userInput >= 0) {
					responses[rows][userInput] = responses[rows][userInput] + 1;
					numResponses[rows] = numResponses[rows] + 1;
					//topicPointTot[rows] = topicPointTot[rows] + (responses[rows][userInput] * userInput);
				}
				else if ( userInput > 9 || userInput < -1) {
					System.out.println("Unrecognized value. Please input 1-9 or -1 to advance to the next topic");
				}
			}
			rows = rows+ 1;
		}
		
		//calculate the average for each topic and highest and lowest and store the rows that those values are in
		for (int i = 0; i < topics.length; i++) {
			for(int column = 0; column < 10; column++) {
				topicPointTot[i] = topicPointTot[i] + (responses[i][column] * column);
				}
			if ( i == 0) {
				highest = topicPointTot[i];
				highestTopicRow = i;
			}
			else if (i == 1) {
				if (topicPointTot[i] > highest) {
					lowest = highest;
					highest = topicPointTot[i];
					lowestTopicRow = 0;
					highestTopicRow = i;
				}
				else {
					lowest = topicPointTot[i];
					lowestTopicRow = i;
				}
			}
			else {
				if (topicPointTot[i] > highest) {
					highest = topicPointTot[i];
					highestTopicRow = i;
				}
				else if (topicPointTot[i] < lowest) {
					lowest = topicPointTot[i];
					lowestTopicRow = i;
				}
			}
			//System.out.println(" on row " + i + " lowest is " + lowest);
			if(numResponses[i] != 0)
			topicAvg[i] = topicPointTot[i] / numResponses[i];
		}
		
		System.out.printf("%18d%4d%4d%4d%4d%4d%4d%4d%4d%4d%10s\n", 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, "Average");
		System.out.printf("%-14s%4d%4d%4d%4d%4d%4d%4d%4d%4d%4d   %4.2f\n", topics[0], responses[0][0], responses[0][1], responses[0][2], responses[0][3], responses[0][4], responses[0][5], responses[0][6], responses[0][7], responses[0][8], responses[0][9], topicAvg[0]);
		System.out.printf("%-14s%4d%4d%4d%4d%4d%4d%4d%4d%4d%4d   %4.2f\n", topics[1], responses[1][0], responses[1][1], responses[1][2], responses[1][3], responses[1][4], responses[1][5], responses[1][6], responses[1][7], responses[1][8], responses[1][9], topicAvg[1]);
		System.out.printf("%-14s%4d%4d%4d%4d%4d%4d%4d%4d%4d%4d   %4.2f\n", topics[2], responses[2][0], responses[2][1], responses[2][2], responses[2][3], responses[2][4], responses[2][5], responses[2][6], responses[2][7], responses[2][8], responses[2][9], topicAvg[2]);
		System.out.printf("%-14s%4d%4d%4d%4d%4d%4d%4d%4d%4d%4d   %4.2f\n", topics[3], responses[3][0], responses[3][1], responses[3][2], responses[3][3], responses[3][4], responses[3][5], responses[3][6], responses[3][7], responses[3][8], responses[3][9], topicAvg[3]);
		System.out.printf("%-14s%4d%4d%4d%4d%4d%4d%4d%4d%4d%4d   %4.2f\n", topics[4], responses[4][0], responses[4][1], responses[4][2], responses[4][3], responses[4][4], responses[4][5], responses[4][6], responses[4][7], responses[4][8], responses[4][9], topicAvg[4]);
		System.out.printf("\n%s recieved the most points at %d points.", topics[highestTopicRow], highest);
		System.out.printf("\n%s recieved the least points at %d points.", topics[lowestTopicRow], lowest);
		//System.out.println("highest is: " + highest + " on row: " + highestTopicRow + "  And lowest is: " + lowest + " on row: " + lowestTopicRow);
	}
	
}
