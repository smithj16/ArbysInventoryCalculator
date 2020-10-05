

import java.io.IOException;
import java.util.Scanner;

public class Freezer extends ArbysInventory {
    // stores the names of the product that belong to the ArbysInventoryCalculator.src.Freezer class
    private final String [] product = new String []{"ChickenBreast", "Subroll", "MiniBuns", "StarBuns", "JalapenoPoppers", "MozzarellaSticks", "CherryTurnover", "AppleTurnover", "HoneywheatBread", "TripleChocolateCookie",
            "SaltyChocolateCookie", "MarbleRye", "ChickenFingers", "GreekGyro", "CurlyFries"};

    private final double [] a1 = new double []{160, 72, 216, 96, 549, 351, 180, 180, 128, 105, 105, 128, 30, 30, 30};
    private final double [] a2 = new double []{20, 6, 12, 24, 61, 39, 60, 60, 16, 35, 35, 16, 5, 5, 5};
    private final double [] individual = new double [15];
    private final double [] Case = new double [15];
    private final double [] Bag = new double [15];
    private final double [] result = new double [15];

    public Freezer() throws IOException {
        // nothing here
    }

    public void collect(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the product by the case, the bag, then the individual item.(enter 0 where need be.)");
        for(int i = 0; i < a1.length; i++){
            System.out.print(product[i] + ": ");
            Case[i] = input.nextDouble();
            Bag[i] = input.nextDouble();
            individual[i] = input.nextDouble();
        }
    }



    public void calculate() {
        for (int i = 0; i < 15; i++){
            result[i] = (Case[i] * a1[i]) + (Bag[i] * a2[i]) + individual[i];
        }
    }


    public void print() {
        for (int i = 0; i < result.length; i++){
            System.out.println((i + 1) + ": " + product[i] + ": " + result[i]);
        }
        System.out.println("\n");
    }

    public double [] getResult(){
        return result;
    }

    public void storeInventory(){
        for(int i = 0; i < result.length; i++){
            outFile.println(product[i] + ": " + result[i]);
        }
        outFile.println("\n");
        System.out.println("Inventory stored....");
        outFile.close();
    }

}
