/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author scotpfleghaar
 */
import java.util.Random;
import java.util.Scanner;

public class main {
  public static void main(String[] args){
    //Objects
    Scanner in = new Scanner(System.in);
    Random rand = new Random();
    
    // Overall Variables
    String[] enemies = {"Skeleton", "Zombie", "Warrior", "Assassins"};
    int maxEnemyHealth = 75;
    int enemyAttackDamage = 25;
    
    // Individual Variables
    int health = 100;
    int attackDamage = 50;
    int numHealthPotions = 3;
    int healthPotionsHealAmount = 30;
    int healthPotionDropChance = 50; // Percent
    
    boolean running = true;
    
    System.out.println("Welcome to the Dungeon!");
    
    GAME:
    while(running) {
      System.out.println("____________________________");
      int enemyHealth = rand.nextInt(maxEnemyHealth);
      String enemy = enemies[rand.nextInt(enemies.length)];
      System.out.println(enemy + " appeared!");
      while(enemyHealth > 0) {
        System.out.println("\tYour HP: " + health);
        System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
        System.out.println("\\n\\What would you like to do?");
        System.out.println("\t1.Attack!");
        System.out.println("\t2. Drink health potion");
        System.out.println("\t3. Run!");
        
        String input = in.nextLine();
        if(input.equals("1")){
          int damageDealt = rand.nextInt(attackDamage);
          int damageTaken = rand.nextInt(enemyAttackDamage);
          enemyHealth -= damageDealt;
          health -= damageTaken;
          
          System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
          System.out.println("\t> You Recieve " + damageTaken + " in retaliation!");
          
          if(health < 1){
            System.out.println("\t> You have taken too much damage, you are too weak to go on");
            break;
          }
        }
        else if(input.equals("2")){
          if(numHealthPotions > 0){
            health += healthPotionsHealAmount;
            numHealthPotions--;
            System.out.println("\t> You drink a health potion, healing yourself for " + healthPotionsHealAmount + "." + "\n\t> You now have " + health + " HP."
            + "\n\t> You have " + numHealthPotions + " potions.\n");
            } else {
              System.out.println("\t You have no health potions left! Defeat more enemies");
            }
        }
        else if(input.equals("3")){
          System.out.println("\tYou run away from the " + enemy+ "!");
          continue GAME;
        } 
        else {
          System.out.println("\tInvalid Command");
        }
      }
      if(health < 1) {
        System.out.println("You limp out of Dungeon");
        break;
        
      }
      System.out.println("____________________________");
      System.out.println(" # " + enemy + " was defeated! # ");
      System.out.println(" # You have " + health + " HP left. #");
      if(rand.nextInt(100) < healthPotionDropChance) {
        numHealthPotions++;
        System.out.println("The " + enemy + " dropped a health potion!");
        System.out.println("You now have " + numHealthPotions + " potions");
        System.out.println("What would you like to do now?");
        System.out.println("1. Continue Fighting");
        System.out.println("2. Exit Dungeon");
        
        String input = in.nextLine();
        while(!input.equals("1") && !input.equals("2")){
          System.out.println("Invalid Command");
          input = in.nextLine();
        }
        if(input.equals("1")){
          System.out.println("You contiue on your adventure");
        }
        else if(input.equals("2"))
        System.out.println("You exit the dungeon and win!");
        break;
      }
    }
    
  }

    private static class enemyHealth {
        Random rand = new Random();
        int attackDamage = 50;
        public enemyHealth() {
            int damageDealt = rand.nextInt(attackDamage);
        }
    }

    private static class health {
    Random rand = new Random();
    int enemyAttackDamage = 25;

        public health() {
            int damageTaken = rand.nextInt(enemyAttackDamage);
        }
        }
    }
