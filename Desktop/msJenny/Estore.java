import java.util.Scanner; 

public class Estore{

      public static void main(String [] args){

	 System.out.println("Welcome to E-Store: ");

	 System.out.print("Please enter your name:");

	 Scanner input = new Scanner(System.in);

	 String name = input.next();

	 int total = 0;

	 int count = 1;

	 int items = 1;



	while(count <= 10){

	System.out.println("Please enter cost for item "+count);

	items = input.nextInt();

	total += items;

	count++;
         }

	if(total >= 200){

	double discount = total * 0.1;

	double discountedCost = total - discount;

	System.out.printf("Customer Name: %s%n Original cost: %d%n 	Discounted Cost: %.2f%n Thanks for your 	patronage!",name,total,discountedCost);

	}
	else{

	System.out.printf("Customer Name: %s%n Original cost: %d%n 	Discounted Cost: 0(no discount added)%n Thanks for your 	patronage!", name,total);


	}



}


}