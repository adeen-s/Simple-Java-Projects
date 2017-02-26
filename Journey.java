/*
Author adeen-s
github.com/adeen-s
Twitter @AdeenShukla
Initial draft
*/
import java.util.*;
public class Journey {
  int hp,gold,ap,hunger,town;
  Journey() {
    hp=100;
    gold=50;
    ap=0;
    hunger=0;
    town=0;
  }
  private void pressEnterToContinue() {
       System.out.println("Press any key to continue...");
       try
       {
           System.in.read();
       }
       catch(Exception e)
       {}
}
  void reachedTown(int town){
    Scanner sc = new Scanner (System.in);
    System.out.println("You are in town "+town+"Choose an option\n\n1.Go to next town\n2.Go to Shop\n3.View Status");
    int choice = sc.nextInt();
    
  }

  public static void main(String args[]) {
    Journey game = new Journey();
    Runtime.getRuntime().exec("clear || cls");
    System.out.println("Welcome to Journey...\nA text based adventure of your hero\nYou have an antidote that needs to be transported from your town Xikorgh to Casgwer City.\nThere are 20 towns that you must through\nYou will have to face monsters and bandits throughout the way\n");
    System.out.println("\n\nPress Enter to continue...");
    game.pressEnterToContinue();
    System.out.println("Your Journey begins now..");
    for(town=1;town<=20;town++) {
      game.reachedTown(town);
    }
  }
}
