import java.util.Random;
import java.util.Scanner;

public class SafariAdventure
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int totalPoints = 0;
        boolean survived = true;

        System.out.println("Welcome to Safari Adventure!");

        // for loop - represents the 5 days of the safari
        for (int day = 1; day <= 5; day++)
        {
            System.out.println();
            System.out.println("Day " + day + ":");

            String area;
            boolean validArea;

            // do...while loop - keep asking until a valid area is entered
            do
            {
                System.out.print(
                    "Where would you like to explore? " +
                    "(Jungle, River, Desert, Mountains): "
                );

                area = input.nextLine();

                validArea =
                    area.equalsIgnoreCase("Jungle") ||
                    area.equalsIgnoreCase("River") ||
                    area.equalsIgnoreCase("Desert") ||
                    area.equalsIgnoreCase("Mountains");

                if (!validArea)
                {
                    System.out.println("Invalid area. Please choose again.");
                }

            } while (!validArea);

            System.out.println();
            System.out.println("You chose: " + area);
            System.out.println("Exploring " + area + "...");

            int eventNumber = 1;
            int dayPoints = 0;

            // while loop - allows up to 3 events each day
            while (eventNumber <= 3)
            {
                int event = random.nextInt(5) + 1;

                System.out.println();
                System.out.print("Event " + eventNumber + ": ");

                if (event == 1)
                {
                    System.out.println("You spotted a harmless bird.");
                    System.out.println("(Too small to track. Moving on.)");

                    eventNumber++;

                    // continue skips the rest of this event
                    continue;
                }
                else if (event == 2)
                {
                    System.out.println("You found edible berries! (+15 points)");
                    dayPoints += 15;
                    totalPoints += 15;
                }
                else if (event == 3)
                {
                    System.out.println("You found valuable supplies! (+25 points)");
                    dayPoints += 25;
                    totalPoints += 25;
                }
                else if (event == 4)
                {
                    System.out.println("A severe storm slows you down! (-5 points)");
                    dayPoints -= 5;
                    totalPoints -= 5;
                }
                else
                {
                    String animal;

                    if (area.equalsIgnoreCase("River"))
                    {
                        animal = "crocodile";
                    }
                    else
                    {
                        animal = "lion";
                    }

                    System.out.println("A " + animal + " appears!");
                    System.out.print("Type 'run' to escape: ");

                    String choice = input.nextLine();

                    if (choice.equalsIgnoreCase("run"))
                    {
                        System.out.println(
                            "You escaped safely, ending the day early."
                        );

                        // break exits the event loop for the current day
                        break;
                    }
                    else
                    {
                        System.out.println(
                            "You did not run and were forced to end the safari."
                        );

                        survived = false;
                        break;
                    }
                }

                // Stop the day's events after enough resources are collected
                if (dayPoints >= 30)
                {
                    System.out.println(
                        "You collected enough resources for today!"
                    );
                    break;
                }

                eventNumber++;
            }

            System.out.println();
            System.out.println(
                "Day Summary: " + dayPoints + " points earned."
            );
            System.out.println("-----------------------------------");

            // End the safari early if the player did not survive
            if (!survived)
            {
                break;
            }
        }

        System.out.println();
        System.out.println("Safari Adventure Summary");
        System.out.println("Total points collected: " + totalPoints);

        if (survived && totalPoints >= 100)
        {
            System.out.println(
                "You survived and completed the adventure!"
            );
        }
        else if (survived)
        {
            System.out.println(
                "You survived, but did not collect the required 100 points."
            );
        }
        else
        {
            System.out.println(
                "You did not survive the safari adventure."
            );
        }

        input.close();
    }
}
