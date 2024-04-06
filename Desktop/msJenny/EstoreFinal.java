import java.util.Scanner;
	

	public class EstoreFinal{


public static void main(String [] args){

String prompt = """

	<>>>>>>>>>>>>>>>>>>>>>>>>>>

	<   WELCOME TO E-STORE  >

	<>>>>>>>>>>>>>>>>>>>>>>>>>>

""";

System.out.println(prompt);


System.out.print("Please enter your name: ");

Scanner input = new Scanner(System.in);

String name = input.nextLine();

String itemName[] = new String[3];

int itemCost[] = new int[3];

int total = 0;

for(int i = 0; i < 3; i++){

System.out.println("What is the name of item " + (i + 1));

itemName[i] = input.next();

System.out.println("How much is it: ");

itemCost[i] = input.nextInt();

total+= itemCost[i];

}

if(total >= 200){

double discounted = total * 0.1;

double discountAmount = total - discounted;

System.out.println("Customer Name: " + name);

System.out.printf("%s%8s%n", "Total item", "Cost");

for(int i = 0; i < 3; i++){

System.out.printf("%3s%14d%n", itemName[i], itemCost[i]);
}

System.out.println("Total Cost: " + total);

System.out.println("Discounted Cost: " + discountAmount);

System.out.println("Thanks for your patronage!!");


}else{

System.out.println("Customer Name: " + name);

System.out.printf("%s%8s%n", "Total item", "Cost");

for(int i = 0; i < 3; i++){

System.out.printf("%3s%14d%n", itemName[i], itemCost[i]);
}

System.out.println("Total Cost: " + total);

System.out.println("Discounted Cost: No discount applied");

System.out.println("Thanks for your patronage!!");





}












}



}
