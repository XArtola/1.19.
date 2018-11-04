
/**
 * @author Xabier
 *
 */
import java.util.Arrays;

public class Ex_1_19 {

	/**
	 * @param args
	 */
	//This function will take the string with the word the user have entered and return two strings.
	//The first with the words ordered alphabetically and the second with the dismissed words
	public static String[] toOrder(String words) {
		//Make sure that the string with the words hasnt go any blank space at the beginning or ending
		words = words.trim();
		//separate each word in a cell of an array of strings
		String separatedWords[] = words.split(" ");
		//Use a counter to know the number of dismissed words
		int dismissedCnt = 0;
		//Initialize a string to store the dismissed words
		String dismissed = " ";
		// Create a loop to move word by word in the array, considering we dont want to use the dismissed words
		for (int a = 0; separatedWords.length - 1 - dismissedCnt >= a; a++) {
			//While there is a dismissed word in this position...
			filter: while (!(separatedWords[a].matches("^[a-zA-Z]+"))) {
				//Take the word to the dismissed string 
				dismissed += separatedWords[a] + " ";
				//Count one more dismissed word
				dismissedCnt++;
				//Move the words in the array to the left to put the blank spaces on the right
				for (int b = a; separatedWords.length - 1 > b; b++) {

					separatedWords[b] = separatedWords[b + 1];
					separatedWords[b + 1] = " ";
				}
				
				if (dismissedCnt + a > separatedWords.length - 1) {
					break filter;
				}

			}
		}
		// Quit blank spaces at the beginning and ending of the dismissed string
		dismissed = dismissed.trim();
		//Calculate the length of the array that has useful words (not dismissed)
		int usefullArray = separatedWords.length - 1 - dismissedCnt;
		//Initialize a string to store the correct order of the words
		String correctOrder = " ";
		//This variable will store where is positioned the smallest word
		int smallestWordIndex = 0;
		//Do this while there are "gutxienez" 2 words to order
		while (usefullArray > 0) {
			// Do the loop and go word by word
			for (int c = 0; usefullArray >= c; c++) {
				//If the word in the first cell of the array[0] is bigger than the other...
				if (separatedWords[smallestWordIndex].compareTo(separatedWords[c]) > 0) {
					//Take the position of the other as the smallest one
					smallestWordIndex = c;
				}

			}
			//When the loop is finished take the smallest word and store it on the string
			correctOrder += " " + separatedWords[smallestWordIndex];
			correctOrder = correctOrder.trim();
			//Ten move the other words to the left
			for (int d = smallestWordIndex; usefullArray > d; d++) {

				separatedWords[d] = separatedWords[d + 1];
				separatedWords[d + 1] = "/";

			}
			// As the program has taken a word the useful array is smaller in one cell
			usefullArray--;
			
			smallestWordIndex = 0;
		}
		//In the case that there is only one word left (the last alphabetically) put it in the string
		correctOrder += " " + separatedWords[0];
		separatedWords[0] = "/";
		//Create an array of strings to return from the function
		String result[] = new String[2];
		
		result[0] = correctOrder;
		result[1] = dismissed;

		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//If the strings taken from args are two..
		if (args.length == 2) {
			//Put them into a string separated by a space
			String sentence = args[0]+ " " +args[1];
			//Make sure that all the letters are in lowercase
			sentence = sentence.toLowerCase().trim();
			//Create a string array
			String toPrint[] = new String[2];
			// Use the function to get the ordered and dismissed words from the string
			toPrint = toOrder(sentence);
			//Print the results
			System.out.println("The correct order of the words you have entered is:\n" + toPrint[0]);
			System.out.println("The dismissed words are:\n" + toPrint[1]);

		}
		// If the strings are more or less than two (!=2)...
		else {
			
			System.out.println("You have not entered two words");
		}
	}

}