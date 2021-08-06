

import java.io.IOException;
import java.util.Scanner;

public class Dry extends ArbysInventory{
    private final String [] product = new String[]{"Regularbuns", "Onionbuns", "twentyOzcups", "thirtyOzcups"};
    private final int [] d1 = new int []{0, 0, 1200, 860};
    private final int [] d2 = new int []{30, 20, 50, 43};
    private final int [] Case = new int[4];
    private final int [] bag = new int [4];
    private final int [] individual = new int [4];
    private final double [] result = new double [4];

    public Dry() throws IOException{
       // nothing here
    }

    public void collect(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the product by the case, the bag, then the individual item.(enter 0 where need be.)");
        for (int i = 0; i < d1.length; i++){
            System.out.print((i + 1) + ": " + product[i] + ": ");
            Case[i] = input.nextInt();
            bag[i] = input.nextInt();
            individual[i] = input.nextInt();
        }

    }

    public void calculate(){
        for (int i = 0; i < result.length; i++){
            result[i] = (Case[i] * d1[i]) + (bag[i] * d2[i]) + individual[i];
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
        System.out.println("Dry inventory stored....");
        outFile.close();
    }
}
