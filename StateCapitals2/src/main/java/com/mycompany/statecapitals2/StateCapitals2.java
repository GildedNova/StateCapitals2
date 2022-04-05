/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.statecapitals2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 *
 * @author Austin
 */
public class StateCapitals2 {

    //Data unmarshalling - Take state/capitals from txt file and load data into hashmap to work on.
    public static void main(String[] args) throws Exception {

        //Initialize Random and two scanners. One for file reading, one for user input.
        Random rnd = new Random();
        Scanner sc = new Scanner(new BufferedReader(new FileReader("C:\\Users\\Austin\\Documents\\"
                + "NetBeansProjects\\StateCapitals2\\src\\main\\java\\com\\mycompany\\statecapital"
                + "s2\\StateCapitals.txt")));
        Scanner input = new Scanner(System.in);
        HashMap<String, String> locationPairs = new HashMap<>();

        //Creates a string array. Array uses a scanner to read one line at a time and
        //insert the data(state :: capital) into the array. State and Capital are then
        //pushed into a hashmap
        String[] stringPairs = new String[2];
        while (sc.hasNextLine()) {
            String currentLine = sc.nextLine();
            stringPairs = currentLine.split("::");
            locationPairs.put(stringPairs[0], stringPairs[1]);
        }

        //Print the size of hashmap and the states
        System.out.println(locationPairs.size());
        System.out.println(locationPairs.keySet());

        //Pushes map into a list to print a random state for the user to guess its capital
        List<String> keys = new ArrayList<>(locationPairs.keySet());

        //Ask the user how many times to guess and then gives a point for each correct guess
        //Decreases array size each time so user cannot guess the same state during game
        System.out.println("How many state capitals would you like to guess?: ");
        int guessAmount = input.nextInt();

        int correct = 0;
        String capital = "";
        String state = "";

        //Loop to ask the user the specific state, then see if capital matches. +1 for each correct guess
        while (guessAmount > 0) {
            state = keys.get(rnd.nextInt(keys.size()));

            //Gets user guess and sees if it matches the value of the state key
            System.out.println("What is the capital of '" + state + "'?");
            capital = input.next();
            if (locationPairs.get(state).equals(capital)) {
                System.out.println("Correct!");
                correct += 1;
            } else {
                System.out.println("Not Correct!");
                correct -= 1;
            }

            keys.remove(state);
            guessAmount -= 1;
        }

        System.out.println("Your total score was " + correct);
    }
}
