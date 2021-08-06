


import java.io.IOException;
import java.util.Scanner;

public class Meat extends ArbysInventory{
    private final String [] product = new String []{"Beef", "Turkey", "Ham", "Brisket", "CornBeef"};
    private final double [] Case = new double[5];
    private final double [] individual = new double[5];
    private final double [] result = new double [5];

    public Meat() throws IOException {
       // nothing here
    }

    public void collect(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the product by the case, the bag, then the individual item.(enter 0 where need be.)");
        for(int i = 0; i < product.length; i++){
            System.out.print(product[i] + ": ");
            Case[i] = input.nextDouble();
            individual[i] = input.nextDouble();
        }

    }

    public void calculate(){
        for (int i = 0; i < result.length; i++){
            result[i] = Case[i]  + individual[i];
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
