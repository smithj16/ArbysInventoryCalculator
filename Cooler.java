

import java.io.IOException;
import java.util.Scanner;

public class Cooler extends ArbysInventory{
    private final String [] product = new String []{"Bacon", "Swisscheese", "Milk", "Aquafina", "Shakebase", "TurkeyPortion",
            "CornbeefPortion","BrisketPortion" };
    private final int [] c1 = new int[]{2000, 240, 48, 35, 5, 0, 0, 0};
    private final double [] c2 = new double[]{400, 20, 0, 0, 2.5, 0 , 0, 0};
    private final double [] Case = new double [8];
    private final double [] bag = new double [8];
    private final double [] individual = new double [8];
    private final double [] result = new double [8];

    public Cooler() throws IOException {
        // nothing here
    }

    public void Collect(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the product by the case, the bag, then the individual item.(enter 0 where need be.)");

        for(int i = 0; i < c1.length; i++){
            System.out.print(product[i] + ": ");
            Case[i] = input.nextDouble();
            bag[i] = input.nextDouble();
            individual[i] = input.nextDouble();
        }

    }
    public void calculate(){
        for (int i = 0; i < result.length; i++){
            result[i] = (Case[i] * c1[i]) + (bag[i] * c2[i]) + individual[i];
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
        System.out.println("Cooler inventory stored....");
        outFile.close();
    }
}
