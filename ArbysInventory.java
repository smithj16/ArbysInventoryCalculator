import java.util.*;
import java.io.*;

public class ArbysInventory implements Cloneable {


     FileWriter file = new FileWriter("ArbysInventory.txt", true);
     PrintWriter outFile = new PrintWriter(file);
     private static Scanner input = new Scanner(System.in);

    public ArbysInventory() throws IOException {

    }

    public ArbysInventory clone() {
        ArbysInventory a1;

        try {
            a1 = (ArbysInventory) super.clone();
            return a1;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Object not cloneable.");
        }
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

        if (answer == 1) {

            f1.collect();
            f1.calculate();
           // f1.print();
            f1.storeInventory();

            c1.Collect();
            c1.calculate();
            //c1.print();
            c1.storeInventory();

            d1.collect();
            d1.calculate();
           /// d1.print();
            d1.storeInventory();

            m1.collect();
            m1.calculate();
           // m1.print();
            m1.storeInventory();




        } else if (answer == 2) {
            Queue<ArbysInventory> que = new LinkedList<ArbysInventory>();

            System.out.println("What would you like to change? ");
            System.out.println("Enter any other number when finished.");
            System.out.println("1.Freezer items");
            System.out.println("2.Cooler items");
            System.out.println("3.Dry items");
            System.out.println("4.Meat items");

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


        } else if (answer == 3) {
            System.out.println("Program is now ending");
        } else {
            System.out.println("You did not enter an option. Program is now ending.");
        }

    }

}



class Freezer extends ArbysInventory {

    private String [] product = new String []{"ChickenBreast", "Subroll", "MiniBuns", "StarBuns", "JalapenoPoppers", "MozzarellaSticks", "CherryTurnover", "AppleTurnover", "HoneywheatBread", "TripleChocolateCookie",
            "SaltyChocolateCookie", "MarbleRye", "ChickenFingers", "GreekGyro", "CurlyFries"};

    private final double [] a1 = new double []{160, 72, 216, 96, 549, 351, 180, 180, 128, 105, 105, 128, 30, 30, 30};
    private final double [] a2 = new double []{20, 6, 12, 24, 61, 39, 60, 60, 16, 35, 35, 16, 5, 5, 5};
    private double [] individual = new double [15];
    private double [] Case = new double [15];
    private double [] Bag = new double [15];
    private double [] result = new double [15];

    public Freezer() throws IOException {
        super();
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
         outFile.close();
    }



}

class Cooler extends ArbysInventory {

    private String [] product = new String []{"Bacon", "Swisscheese", "Milk", "Aquafina", "Shakebase", "TurkeyPortion",
            "CornbeefPortion","BrisketPortion" };
    private final int [] c1 = new int[]{2000, 240, 48, 35, 5, 0, 0, 0};
    private final double [] c2 = new double[]{400, 20, 0, 0, 2.5, 0 , 0, 0};
    private double [] Case = new double [8];
    private double [] bag = new double [8];
    private double [] individual = new double [8];
    private double [] result = new double [8];

    public Cooler() throws IOException {
        super();
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
        outFile.close();
    }
}

class Dry extends ArbysInventory {

    private String [] product = new String[]{"Regularbuns", "Onionbuns", "twentyOzcups", "thirtyOzcups"};
    private final int [] d1 = new int []{0, 0, 1200, 860};
    private final int [] d2 = new int []{30, 20, 50, 43};
    private int [] Case = new int[4];
    private int [] bag = new int [4];
    private int [] individual = new int [4];
    private double [] result = new double [4];

    public Dry() throws IOException {
        super();

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
        outFile.close();
    }
}

class Meat extends ArbysInventory {
    private String [] product = new String []{"Beef", "Turkey", "Ham", "Brisket", "CornBeef"};
    private double [] Case = new double[5];
    private double [] individual = new double[5];
    private double [] result = new double [5];

    public Meat() throws IOException {
        super();

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
        outFile.close();
    }
}


