
import java.io.IOException;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.io.FileWriter;
import java.io.PrintWriter;

/*
    This program calculates Arby's inventory. Each class calculates a part of the inventory and stores the result in a text file "ArbysInventory".
    Each class stores the name of the product, amount of product per case and bag according to the distributor.
    The inventory is calculated by multiplying two arrays. The first array stores the amount of product per case and bag.
    The second array will be filled by the user of the software, collecting the amount of each product by the case, bag and individual item in the restuarant.
    The total amount of product is stored in an array named "result".
    Each class contains a result array.
*/


public class ArbysInventory {


    FileWriter file = new FileWriter("ArbysInventory.txt", true);
    PrintWriter outFile = new PrintWriter(file);
    private static Scanner input = new Scanner(System.in);

    public ArbysInventory() throws IOException {
        // nothing here
    }


    public static void changeInventory(ArbysInventory obj){
        int item;
        double amount;
        if (obj instanceof Freezer){

            System.out.println("Which Item/s would you like to change?");
            ((Freezer) obj).print();
            double[] items = ((Freezer)obj).getResult();

            do{
                System.out.println("Please make a selection.\n" + "Note: Enter any other number when finished");
                item = input.nextInt() - 1;

                if (item < 0 || item >= items.length ){
                    break;
                }

                System.out.println("Please enter the correct amount.");
                amount = input.nextDouble();
                items[item] = amount;
            }while (true);

        }
        else if(obj instanceof Cooler){

            System.out.println("Which Item/s would you like to change?");
            ((Cooler)obj).print();
            double[] items = ((Cooler)obj).getResult();

            do{
                System.out.println("Please make a selection.\n" + "Note: Enter any other number when finished");
                item = input.nextInt() - 1;

                if (item < 0 || item >= items.length ){
                    break;
                }

                System.out.println("Please enter the correct amount.");
                amount = input.nextDouble();
                items[item] = amount;
            }while (true);
        }
        else if(obj instanceof Dry){

            System.out.println("Which Item/s would you like to change?");
            ((Dry)obj).print();
            double[] items = ((Dry)obj).getResult();

            do{
                System.out.println("Please make a selection.\n" + "Note: Enter any other number when finished");
                item = input.nextInt() - 1;

                if (item < 0 || item >= items.length ){
                    System.out.println("Ending selection..."); 
                    break;
                }

                System.out.println("Please enter the correct amount.");
                amount = input.nextDouble();
                items[item] = amount;
            }while (true);
        }
        else if(obj instanceof Meat){

            System.out.println("Which Item/s would you like to change?");
            ((Meat)obj).print();
            double[] items =((Meat)obj).getResult();

            do{
                System.out.println("Please make a selection. \n" + "Note: Enter any other number when finished");
                item = input.nextInt() - 1;

                if (item < 0 || item >= items.length ){
                    break;
                }

                System.out.println("Please enter the correct amount.");
                amount = input.nextDouble();
                items[item] = amount;
            }while (true);
        }

    }


    public static int showMenu() {
        System.out.println("What would you like to do today? \n" + "1. Calculate inventory \n" + "2. Change inventory \n" + "3. End program \n");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }


    public static void main(String[] args) throws IOException {


        int answer = ArbysInventory.showMenu();
        Freezer f1 = new Freezer();
        Cooler c1 = new Cooler();
        Dry d1 = new Dry();
        Meat m1 = new Meat();
        
        // collect inventory
        if (answer == 1) {

            f1.collect();
            f1.calculate();
            f1.storeInventory();

            c1.Collect();
            c1.calculate();
            c1.storeInventory();

            d1.collect();
            d1.calculate();
            d1.storeInventory();

            m1.collect();
            m1.calculate();
            m1.storeInventory();

            System.out.println("Inventory Saved...");



        }
        // change inventory
        else if (answer == 2) {
            Queue<ArbysInventory> que = new LinkedList<>();

            System.out.println("What would you like to change? ");
            System.out.println("Enter 0 when finished.");
            System.out.println("1.Freezer items");
            System.out.println("2.Cooler items");
            System.out.println("3.Dry items");
            System.out.println("4.Meat items");
            System.out.println("Ex: 1240  Note: Program will edit freezer, cooler and then the meat section of the inventory. 0 will end the list of inventory changes.");

            Scanner input = new Scanner(System.in);
            int temp;
            ArbysInventory temp2;

            do {
                temp = input.nextInt();
                switch (temp){
                    case 1:
                        que.add(f1);
                        break;
                    case 2:
                        que.add(c1);
                        break;
                    case 3:
                        que.add(d1);
                        break;
                    case 4:
                        que.add(m1);
                        break;
                    default:
                        temp = 0;

                }

            }while(temp != 0);

            do {

                temp2 = que.poll();
                changeInventory(temp2);

            }while(temp2 != null);

            // End Program
        }
        else if (answer == 3) {
            System.out.println("Program is now ending");
        }
        else {
            System.out.println("You did not enter an option. Program is now ending.");
        }

    }

}
