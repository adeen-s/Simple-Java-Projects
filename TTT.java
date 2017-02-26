import java.util.*;
public class TTT {
  int arr[][] = new int[3][3];
  // 0 for empty.
  // 1 for X.
  // 2 for O.
  public static void main(String args[]) {
    TTT game = new TTT();
    while(true) {
      game.check();
      game.display();
      game.input(1);
      game.check();
      game.display();
      game.input(2);
    }
  }

  public boolean gameNotOver() {
    for(int i=0;i<3;i++)
      for(int j=0;j<3;j++)
        if(arr[i][j]==0)
          return true;
    return false;
  }

  public TTT() {
    for(int i=0;i<3;i++)
      for(int j=0;j<3;j++)
        arr[i][j]=0;
  }

  public void display() {
    for(int i=0;i<3;i++) {
      for(int j=0;j<3;j++) {
        if(arr[i][j]==0)
          System.out.print("|   |");
        if(arr[i][j]==1)
          System.out.print("| X |");
        if(arr[i][j]==2)
          System.out.print("| O |");
      }
      if(i!=2)
        System.out.print("\n---------------\n");
      else
        System.out.println();
    }
  }

  public void input(int plyr_id) {
    Scanner sc = new Scanner (System.in);
    int i=-1,j=-1;
    System.out.println("\n Enter the coordinates Player "+plyr_id);
    try {
      i = sc.nextInt();
      j = sc.nextInt();
    }
    catch(InputMismatchException ex) {
      System.out.println("Invalid input, only integers allowed. Try Again");
    }
    if(isValid(i,j))
      arr[i][j]=plyr_id;
    else {
      System.out.println("Invalid input, try again");
      input(plyr_id);
    }
  }

  public boolean isValid(int i, int j) {
    return (i<3 && j<3 && i>=0 && j>=0 && arr[i][j]==0);
  }

  public void check() {
    for(int i=0;i<3;i++) {
      // Checking Horizontally
      if(arr[i][0]==arr[i][1] && arr[i][0]==arr[i][2]) {
        if(arr[i][0]==1) {
          System.out.println("X Wins");
          System.exit(0);
        }
        else if(arr[i][0]==2) {
          System.out.println("O Wins");
          System.exit(0);
        }
      }
      //Checking Vertically
      if(arr[0][i]==arr[1][i] && arr[0][i]==arr[2][i]) {
        if(arr[0][i]==1) {
          System.out.println("X Wins");
          System.exit(0);
        }
        else if(arr[0][i]==2) {
          System.out.println("O Wins");
          System.exit(0);
        }
      }
    }
    //Checking Diagonally 1
    if(arr[0][0]==arr[1][1] && arr[0][0]==arr[2][2]) {
      if(arr[0][0]==1) {
        System.out.println("X Wins");
        System.exit(0);
      }
      else if(arr[0][0]==2) {
        System.out.println("O Wins");
        System.exit(0);
      }
    }
    //Checking Diagonally 2
    if(arr[0][2]==arr[1][1] && arr[0][2]==arr[2][0]) {
      if(arr[0][2]==1) {
        System.out.println("X Wins");
        System.exit(0);
      }
      else if(arr[0][2]==2) {
        System.out.println("O Wins");
        System.exit(0);
      }
    }
    if(!gameNotOver()){
      System.out.println("Its a tie");
      System.exit(0);
    }
  }
}
