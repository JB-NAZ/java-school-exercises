package word_ladder;

import java.util.Scanner;

public class WordLadder {

	public static void main(String[] args) {

		String player1 = "Player 1";
		String player2 = "Player 2";

		/*ladderPlayers(player1);
		ladderPlayers(player2);*/
		int score1 = ladderPlayers(player1);
		int score2 = ladderPlayers(player2);

		if (score1 > score2) {
			System.out.println("Player 1 Wins");
		} else if (score1 < score2) {
			System.out.println("Player 2 Wins");
		} else {
			System.out.println("DRAW");
		}

	}

	static int ladderPlayers(String playerName) {

		String word = "しりとり";
		Scanner sin = new Scanner(System.in);
		System.out.println("\t\t\t\t\t\t---しりとりルールとは---\n\t\t\t\t***最後の文字で始まる言葉を作っています***");
		System.out.println();
		System.out.println("\t\t\t\t\t\t---How many rounds---\n\t\t\t\t\t***何回の数字入力してください***");

		int rounds = sin.nextInt();

		int finalScore = 1;
		System.out.println("\t\t\t\tIt is the turn of " + playerName);
		System.out.println();

		//loop for the amount of times the game will be played which is chosen at the start of the game/何回プレイして欲しいというループ
		for (int i = 1; i <= rounds; i++) {

			char tail = ShowCharacter(word);
			char tail2 = EndsWith(word);

			String newWord = InputWord();
			char newTail = ShowCharacter(newWord);
			char newTail2 = EndsWith(newWord);
			char head = newWord.charAt(0);

			if (CheckCharacter(tail, head) == true) {
				word = newWord;
				System.out.println("\nScore: " + finalScore);
				System.out.println("\t\t\t\tCorrect now write a new word\n\n\t\t\t\t正しいです。次のこと入力してください\n");
				finalScore++;
				//System.out.println(newWord);

			} //Condition in the case that the players word does not match the last or first word of the word
			else if (CheckCharacter(newTail, head) == false) {
				System.out.println("\n\nWrong || 間違える");
				finalScore--;

				System.out.println("Score: " + finalScore);
				System.out.println();
			}

		}

		System.out.println("Congrats, your score is " + (finalScore - 1));
		return finalScore;
	}

	static char ShowCharacter(String str) {
		int i = str.length() - 1;
		char tail = str.charAt(i);

		if (tail == 'ー') {
			i = str.length() - 2;
			tail = str.charAt(i);

			System.out.println("いっこ前の文字");
		}

		System.out.print("最後の文字は: 「" + tail + "」");

		return tail;

	}

	static String InputWord() {
		Scanner scan = new Scanner(System.in);
		System.out.println("言葉を入力してください： ");
		//String message = 
		return scan.nextLine();

	}

	static boolean CheckCharacter(char h, char t) {

		if (h == t) {

			return true;
			//System.out.println("Ok");
		} else {
			return false;
			//System.out.println("Try again");
		}
	}

	
	static char EndsWith(String str) {
		int i = str.length() - 1;
		char tail = str.charAt(i);

		System.out.print("最後の文字は: " + tail);
		while (true) {
			if (tail == 'ん' || tail == 'ゃ' || tail == 'ゅ' || tail == 'ょ') {
				System.out.println("\tはダメです");
				break;
			}

			else {
				return tail;
			}
		}
		return tail;
	}
}
