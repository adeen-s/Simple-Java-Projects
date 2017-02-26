import java.util.Scanner;
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
      game.input1();
      game.check();
      game.display();
      game.input2();
    }
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

  public void input1() {
    Scanner sc = new Scanner (System.in);
    System.out.println("\n Enter the coordinates for X");
    int i = sc.nextInt();
    int j = sc.nextInt();
    if(isValid(i,j))
      arr[i][j]=1;
    else {
      System.out.println("Invalid input, try again");
      input1();
    }
  }

  public void input2() {
    Scanner sc = new Scanner (System.in);
    System.out.println("\n Enter the coordinates for O");
    int i = sc.nextInt();
    int j = sc.nextInt();
    if(isValid(i,j))
      arr[i][j]=2;
    else {
      System.out.println("Invalid input, try again");
      input2();
    }
  }

  public boolean isValid(int i, int j) {
    if(i<3 && j<3 && arr[i][j]==0)
      return true;
    return false;
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
  }
}
