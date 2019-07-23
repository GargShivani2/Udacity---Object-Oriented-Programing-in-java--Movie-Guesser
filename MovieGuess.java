import java.util.Scanner;
import java.lang.*;
import java.io.File;

class MovieGuess
{
	public static void main(String[] args) throws Exception
	{	 
	
		File fileName = new File ("Movie.txt");
		Scanner scanner = new Scanner(fileName);

		String[] myArray = new String[100];
		int index = 0;

		while(scanner.hasNextLine())
		{
			String line = scanner.nextLine();
			myArray[index] = line;
			index++;
			//System.out.println(line);
		}

		int randomNumber = (int) ((Math.random()*50) + 1);
		//System.out.println("Random Number : " + randomNumber);

		String st = myArray[randomNumber];
		st = st.replaceAll("\\s", "");
		System.out.println("Movie Name : " + st);
		String [] movie = {st};
		String [] guessedWord = new String[st.length()];


		int flag = 0;;
		while(flag<st.length())
		{
			guessedWord[flag] = "_";
			flag++;
		}
		//System.out.println("length of movie: " + flag);
		
		int wrongeLetter = 0;
		String wrongeGuess = "";
		int win = 0;

		
		while(win==0)
		{
			int j = 0;
			String display = "";
			while(j<flag)
			{
				//System.out.print(guessedWord[j]);
				display+= guessedWord[j];
				j++;
			}
			//System.out.println(display + "1" + "--------" + st + "2");
			if(display.equals(st))
			{
				win = 1;
				System.out.println("You Win");
				break;
			}
			//System.out.println("win : " + win);
			System.out.println("You are guessing :"+ display);
			System.out.println("You have guessed()" + wrongeLetter + ") wronge letters :" + wrongeGuess);
			Scanner input = new Scanner(System.in);
			String guessedLetter = input.nextLine();
			System.out.println("Guess a letter :"+ guessedLetter);
			
			int k  = 0;
			int matchingletters =0;
			int i  = 0; int p = 0;
			while(k<flag)
			{
				
				//System.out.println("alok --->" + guessedLetter.charAt(p) + st.charAt(i) + "123 ");
				if(st.charAt(i)==guessedLetter.charAt(p))
				{
					guessedWord[i] = guessedLetter;
					//System.out.println(guessedWord[i] + "     "+ guessedLetter);
					matchingletters+=1;
					
				}
				i++;
				k++;
			}
			//System.out.println("match : " + matchingletters);


			if(matchingletters ==0)
			{
				wrongeGuess += (" " + guessedLetter);
				wrongeLetter++;
			}

			
			
		}

		
	}
}