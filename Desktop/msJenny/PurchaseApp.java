import java.util.Scanner; 

public class PurchaseApp{

      public static void main(String [] args){

	 Scanner input = new Scanner(System.in);

	 System.out.println("Welcome to E-Store: ");

	 System.out.print("Please enter your name:");

	 String name = input.next();

	System.out.println("Please enter number of item purchased :");

	int itemsNo = input.nextInt();

	System.out.println("Please Enter percentage: ");

	double pod = input.nextInt();

	//System.out.println(pod);
		
	 int total = 0;

	 int count = 1;

	

	while(count <= itemsNo){

	System.out.println("Please enter cost for item "+count);

	int items = input.nextInt();

	total += items;

	count++;
         }

	if(total >= 200){

	double discountAmount = (pod /100) * total ;

	double discountedCost = total - discountAmount;

	System.out.printf("Customer Name: %s%n Number of item bought : %d%n 	percentage discount: %f%n Original cost: %d%n 	Discounted Cost: %.2f%n 	Thanks for your patronage!",name,itemsNo,pod,total,discountedCost);

	}
	else{

	System.out.printf("Customer Name: %s%n Original cost: %d%n 	Discounted Cost: 0(no discount added)%n Thanks for your 	patronage!", name,total);


	}



}


}