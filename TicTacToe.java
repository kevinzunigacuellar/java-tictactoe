import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

  private static void printBoard(char[][] board) {

    System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
    System.out.println("-+-+-");
    System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
    System.out.println("-+-+-");
    System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);

  }

  private static boolean isValidMove(char[][] board, int position) {
    switch (position) {
      case 1:
        return (board[0][0] == ' ');
      case 2:
        return (board[0][1] == ' ');
      case 3:
        return (board[0][2] == ' ');
      case 4:
        return (board[1][0] == ' ');
      case 5:
        return (board[1][1] == ' ');
      case 6:
        return (board[1][2] == ' ');
      case 7:
        return (board[2][0] == ' ');
      case 8:
        return (board[2][1] == ' ');
      case 9:
        return (board[2][2] == ' ');
      default:
        return false;
    }
  }

  private static void placeMove(char[][] board, String position, char symbol) {
    switch (position) {
      case "1":
        board[0][0] = symbol;
        break;
      case "2":
        board[0][1] = symbol;
        break;
      case "3":
        board[0][2] = symbol;
        break;
      case "4":
        board[1][0] = symbol;
        break;
      case "5":
        board[1][1] = symbol;
        break;
      case "6":
        board[1][2] = symbol;
        break;
      case "7":
        board[2][0] = symbol;
        break;
      case "8":
        board[2][1] = symbol;
        break;
      case "9":
        board[2][2] = symbol;
        break;

      default:
        System.out.println(":(");
        break;
    }
  }

  private static void playerTurn(char[][] board, Scanner scanner) {
    String userInput;
    while (true) {
      System.out.println("would you like to play (1 - 9)");
      userInput = scanner.nextLine();
      if (isValidMove(board, Integer.parseInt(userInput))) {
        break;
      } else {
        System.out.println(userInput + " is not a valid move");
      }
    }
    placeMove(board, userInput, 'X');
  }

  private static void computerTurn(char[][] board) {
    Random rand = new Random();
    int computerMove;
    while (true) {
      computerMove = rand.nextInt(9) + 1;
      if (isValidMove(board, computerMove)) {
        break;
      }
    }
    System.out.println("Computer chose: " + computerMove);
    placeMove(board, Integer.toString(computerMove), 'O');
  }

  public static void main(String[] args) {

    char[][] board = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
    printBoard(board);
    Scanner scanner = new Scanner(System.in);

    while (true) {
      playerTurn(board, scanner);
      printBoard(board);
      computerTurn(board);
      printBoard(board);
    }
    // scanner.close();
  }
}