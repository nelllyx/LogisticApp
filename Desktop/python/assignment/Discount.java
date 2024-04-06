import java.util.Scanner;

public class Discount{

public static void main(String [] args){


Scanner input = new Scanner(System.in);

System.out.println("Enter price");

int price = input.nextInt();

System.out.println("Enter discount percentage ");

int discount = input.nextInt();

float discountPrice = (price / 100) * discount;

float newPrice = price - discountPrice;

System.out.println("The price after discount is " + newPrice);

}



}