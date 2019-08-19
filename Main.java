package com.tou;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        while (!quit) {
            System.out.println("Are you ready to play? Yes/No: ");
            String choice = scanner.nextLine();
            System.out.println(choice);
            if (choice.toLowerCase().equals("yes")){
                System.out.println("Starting Hangman...");
                System.out.println("Please enter a username: ");
                String username = scanner.nextLine();

                Player player = new Player(username);

                System.out.println("Welcome " + player.getName());
                System.out.println("You have " + player.getLives() + " lives");
                System.out.println();

                String randomWord = randomWord();

                for (int i=0; i<randomWord.length(); i++) {
                    System.out.print("_");
                    System.out.print(" ");

                }
                System.out.println(" ");
                ArrayList<String>  playersLetters = new ArrayList<>();
                while(!quit) {
                    System.out.println();
                    System.out.println("Choose a letter: ");
                    String playerLetter = scanner.nextLine();
                    String alphabet = "abcdefghijklmnopqrstuvwxyz";
                    int numberOfLettersFound = 0;
                    if (alphabet.contains(playerLetter)) {
                        if (chooseLetter(playerLetter, randomWord)) {
                            playersLetters.add(playerLetter);
                            for (int i=0; i<randomWord.length(); i++) {

                                String letterInRandomWord = String.valueOf(randomWord.charAt(i));
                                if (playersLetters.contains(letterInRandomWord)) {
                                    System.out.print(letterInRandomWord);
                                    numberOfLettersFound ++;
                                    if (numberOfLettersFound == randomWord.length()) {
                                        System.out.println();
                                        System.out.println("Congratulations you won!!");
                                        quit = true;
                                        break;
                                    }
                                } else {
                                    System.out.print("_");
                                }

                                System.out.print(" ");
                            }

                        } else {
                            loseALife(player);
                            int lifeNumber = player.getLives();
                            if (lifeNumber == 0) {
                                System.out.println("You have no more lives");
                                System.out.println("Exiting game...");
                                quit = true;
                                break;
                            }
                            System.out.println(playerLetter + " is not in this word");
                            System.out.println("You have " + player.getLives() + " lives left");

                            for (int i=0; i<randomWord.length(); i++) {

                                String letterInRandomWord = String.valueOf(randomWord.charAt(i));
                                if (playersLetters.contains(letterInRandomWord)) {

                                    System.out.print(letterInRandomWord);

                                } else {
                                    System.out.print("_");
                                }

                                System.out.print(" ");
                            }



                        }
                    } else {
                        System.out.println("Please enter a valid letter");
                    }

                    System.out.println();






                }

            } else {
                System.out.println("Exiting game...");
                quit = true;

            }
        }
    }

    public static String randomWord() {
        try {
            Scanner wordScanner = new Scanner(new File("C:\\Users\\itoul\\Desktop\\Java\\Hangman\\src\\com\\tou\\dictionary.txt"));
            Random random = new Random();
            int randomNumber = random.nextInt(10000);

            String randomWord = new String();
            if (wordScanner.hasNext()) {
                for (int i=0; i<randomNumber; i++){
                    randomWord = wordScanner.next();
                }
            }

            return randomWord;

        } catch (Exception exception){
            System.out.println("File not found");
            return null;
        }
    }

    public static boolean chooseLetter(String letter, String randomWord) {

            if (randomWord.contains(letter)) {
                return true;

            } else {
                return false;

            }

    }

    public static void loseALife(Player player) {
        int numberOfLives = player.getLives() - 1;
        player.setLives(numberOfLives);

    }


}
