package Animals;

import Animals.PackAnimals.*;
import Animals.Pets.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class AnimalsRegistry {
    private static ArrayList<Animals> animalList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        boolean exitMenu = false;

        while (!exitMenu) {
            System.out.println("\nMenu");
            System.out.println("1. Add animal");
            System.out.println("2. Open animal actions list");
            System.out.println("3. Train animal new actions");
            System.out.println("4. Show all animals in the list");
            System.out.println("5. Exit");
            System.out.println("Enter the number: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addAnimal();
                    break;
                case 2:
                    listAnimalActions();
                    break;
                case 3:
                    trainAnimal();
                    break;
                case 4:
                    showAllAnimals();
                    break;
                case 5:
                    System.out.println("You have successfully exited the program");
                    exitMenu = true;
                    break;
                default:
                    System.out.println("Wrong option. Please try again.");
            }
        }
    }

    public static void addAnimal() {
        System.out.println("Enter animal name: ");
        String name = scanner.nextLine();

        LocalDate birthday = null;
        boolean validDate = false;
        while (!validDate) {
            System.out.println("Enter animal birthday (YYYY-MM-DD): ");
        String birthdayInput = scanner.nextLine();
        try {
            birthday = LocalDate.parse(birthdayInput, DateTimeFormatter.ISO_LOCAL_DATE);
            validDate = true;
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format or impossible date. Please try again.");
        }
    }
        System.out.println("Enter animal type (Dog/Cat/Hamster/Chicken/Horse/Donkey/Camel/Goat): ");
        String type = scanner.nextLine().toLowerCase();

        System.out.println("Enter actions (separated by commas or spaces): ");
        String actionsInput = scanner.nextLine();
        String[] actions = actionsInput.split("\\s*,\\s*|\\s+"); // I use regular expression to avoid error in the input, before i tried String[] actions = actionsInput.split(" ") but it wasn't good

        Animals newAnimal = null;

        if (type.equals("dog") || type.equals("cat") || type.equals("hamster") || type.equals("chicken")) {
            newAnimal = switch (type) {
                case "dog" -> new Dog(name, birthday.toString(), actions);
                case "cat" -> new Cat(name, birthday.toString(), actions);
                case "hamster" -> new Hamster(name, birthday.toString(), actions);
                case "chicken" -> new Chicken(name, birthday.toString(), actions);
                default -> null;
            };
        } else if (type.equals("horse") || type.equals("donkey") || type.equals("camel") || type.equals("goat")) {
            newAnimal = switch (type) {
                case "horse" -> new Horse(name, birthday.toString(), actions);
                case "donkey" -> new Donkey(name, birthday.toString(), actions);
                case "camel" -> new Camel(name, birthday.toString(), actions);
                case "goat" -> new Goat(name, birthday.toString(), actions);
                default -> null;
            };
        }

        if (newAnimal != null) {
            animalList.add(newAnimal);
            System.out.println("New animal added: ");
            newAnimal.showInfo();
        } else {
            System.out.println("Error adding animal.");
        }
    }

    public static void listAnimalActions() {
        System.out.println("Enter animal name to see actions: ");
        String name = scanner.nextLine();

        for (Animals animal : animalList) {
            if (animal.getName().equalsIgnoreCase(name)) {
                animal.showActions();
                return;
            }
        }
        System.out.println("Animal is not in the list.");
    }

    public static void trainAnimal() {
        System.out.print("Enter animal's name to train: ");
        String name = scanner.nextLine();

        for (Animals animal : animalList) {
            if (animal.getName().equalsIgnoreCase(name)) {
                System.out.print("Enter new action to teach: ");
                String newAction = scanner.nextLine();

                if (animal instanceof Pets pet) {
                    pet.setActions(addAction(pet.getActions(), newAction));
                } else if (animal instanceof PackAnimals packAnimal) {
                    packAnimal.setActions(addAction(packAnimal.getActions(), newAction));
                }

                System.out.println("Animal trained successfully.");
                return;
            }
        }
        System.out.println("Animal is not found.");
    }

    public static void showAllAnimals() {
        if (animalList.isEmpty()) {
            System.out.println("No animals here yet.");
        } else {
            System.out.println("List of all animals: ");
            for (Animals animal : animalList) {
                animal.showInfo();
                System.out.println();
            }
        }
    }


    private static String[] addAction(String[] actions, String newAction) {
        String[] newActions = new String[actions.length + 1];
        System.arraycopy(actions, 0, newActions, 0, actions.length);
        newActions[actions.length] = newAction;
        return newActions;
    }
}