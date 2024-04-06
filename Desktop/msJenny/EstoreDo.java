import java.util.Scanner; 

public class EstoreDo{

      public static void main(String [] args){

	 Scanner input = new Scanner(System.in);

	 System.out.println("Welcome to E-Store: ");

	 System.out.print("Please enter your name:");

	 String name = input.next();

	int items = 0;

	System.out.println("Please Enter percentage: ");

	double pod = input.nextInt();
		
	 int total = 0;

	 int count = 1;

	

	do{

	System.out.println("Please enter cost for item "+count + " or -1 to quit");

	items = input.nextInt();

	if(items == -1)	break;

	total += items;

	count++;
		
         }

	while(items != -1);	

	if(total >= 200){

	double discountAmount = (pod /100) * total ;

	double discountedCost = total - discountAmount;

	System.out.printf("Customer Name: %s%n Number of item bought : %d%n 	percentage discount: %f%n Original cost: %d%n 	Discounted Cost: %.2f%n 	Thanks for your patronage!",name,count,pod,total,discountedCost);

	}
	else{

	System.out.printf("Customer Name: %s%n Original cost: %d%n 	Discounted Cost: 0(no discount added)%n Thanks for your 	patronage!", name,total);


	}



}


}