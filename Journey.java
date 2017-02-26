/*
Author adeen-s
github.com/adeen-s
Twitter @AdeenShukla
Initial draft
*/
import java.util.*;
import java.io.*;
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
       System.out.println("Press Enter key to continue...");
       try
       {
           System.in.read();
       }
       catch(Exception e)
       {}
  }
  void reachedTown(int town) {
    for (int i = 0; i < 50; ++i) System.out.println();
    Scanner sc = new Scanner (System.in);
    System.out.println("You are in town "+town+"\nChoose an option\n\n1.Go to next town\n2.Go to Shop\n3.View Status\n4.Quit");
    int choice = sc.nextInt();
    if(choice == 1) {
      if(hunger<80)
        travel();
      else {
        System.out.println("You are hungry. You cannot travel right now.");
        System.exit(0);
      }
    }
    else if(choice == 2)
      shop();
    else if(choice == 3)
      displayStatus();
    else if(choice == 4)
      System.exit(0);
    else {
      System.out.println("Invalid input. Try again.");
      reachedTown(town);
    }
  }

  void travel()  {
    for (int i = 0; i < 50; ++i) System.out.println();
    pressEnterToContinue();
    Scanner sc = new Scanner(System.in);
    int chance = (int) Math.ceil(Math.random() * 100);
    if(chance<=30) {
      hunger+=20;
      System.out.println("You encountered bandits...\nWhat do yu want to do?\n\n1.Fight\n2.Run");
      int choice = sc.nextInt();
      if(choice == 1) {
        System.out.println("You chose to fight...\n\nYou killed the bandits but suffered some injuries.\n You also received some gold.");
        hp-=15;
        gold+=10;
      }
      else {
        System.out.println("You chose to run away...\n\nYou got away safely but lost some gold");
        gold-=10;
      }
    }
    else if(chance>30 && chance<=60) {
      hunger+=30;
      System.out.println("You encountered a dragon...\nWhat do yu want to do?\n\n1.Fight\n2.Run");
      int choice = sc.nextInt();
      if(choice == 1) {
        System.out.println("You chose to fight...\n\nYou killed the Dragon but suffered many injuries.\n You also received gold.");
        hp-=20;
        gold+=20;
      }
      else {
        System.out.println("You chose to run away...\n\nYou got away safely but lost some gold");
        gold-=15;
      }
    }
    else {
      hunger+=10;
      System.out.println("You reached the next town safely");
    }
  }

  void displayStatus()  {
     for (int i = 0; i < 50; ++i) System.out.println();
    System.out.println("Your stats are -->\nHealth Points - "+hp+"\nGold - "+gold+"\nArmor - "+ap+"\nYou are "+hunger+"% hungry\nYou are in town #"+town);
    reachedTown(town);
  }

  void shop()  {
     for (int i = 0; i < 50; ++i) System.out.println();
    Scanner sc = new Scanner (System.in);
    System.out.println("Choose an option\n\n1.Eat food (5 gold)\n2.Buy Armor (15 gold)\n3.Heal yourself(10 gold)");
    int choice = sc.nextInt();
    switch(choice) {
      case 1:if(gold>=5) {
          gold-=5;
          if(hunger>=10)
            hunger-=10;
        }
        break;
      case 2:if(ap<=40 && gold>=15){
            ap+=10;
            gold-=15;
        }
        break;
      case 3:if(hp<100 && gold>=10) {
          hp+=20;
          gold-=10;
          if(hp>100)
            hp=100;
        }
        break;
      default:System.out.println("Invalid input. Try again");
    }
    reachedTown(town);
  }

  public static void main(String args[])  {
    Journey game = new Journey();
     for (int i = 0; i < 50; ++i) System.out.println();
    System.out.println("Welcome to Journey...\nA text based adventure of your hero\nYou have an antidote that needs to be transported from your town Xikorgh to Casgwer City.\nThere are 20 towns that you must through\nYou will have to face monsters and bandits throughout the way\n");
    System.out.println("\n\n");
    game.pressEnterToContinue();
    System.out.println("Your Journey begins now..");
    for(game.town=1;game.town<=20;game.town++) {
      if(game.hp>0)
        game.reachedTown(game.town);
      else{
        System.out.println("Game Over.Your hero is dead.");
        System.exit(0);
      }
    }
  }
}
