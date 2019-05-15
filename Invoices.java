// Jorell Socorro
import java.util.*;
import java.text.*;
public class Invoices {
    public static void main(String args[]) {
    // the variables
    int invNum = 0;
    int numItems = 0;
    double itemPrice = 0.0, shipCharge = 0.0, totAmt = 0.0;
    double discount = 0.02, subTotal = 0.0;
    char shipMethod = '\0';
    String invDate = "";
    boolean check = false;
    Scanner sc = new Scanner(System.in);
    //Declared a decimal format to make sure the decimal place stays where it is.
    DecimalFormat df = new DecimalFormat("#.###");
    // obtain today's date
    Date date = new Date();
    
    // display time and date using toString()
    System.out.println(date.toString());
    
    // the program header
    System.out.println("[ Invoice Processing ]");
    System.out.println("----------------------\n");
    System.out.println("Today's Date is: " + date + "\n");
 // prompt user for data and receive data
    System.out.println("please enter the invoice number");
    invNum = sc.nextInt();
    System.out.println("the invoice number is: " + invNum);
    System.out.println("please enter the invoice date");
    invDate = sc.next();
    System.out.println("the invoice date is: " + invDate);
    System.out.println("please enter the number of items purchased");
    numItems = sc.nextInt();
    System.out.println("the number of items is: " + numItems);
    
    // determine the per item price
    if (numItems > 0 && numItems <= 10)
      itemPrice = 0.75;
    else if (numItems > 10 && numItems <= 50)
      itemPrice = 0.65;
    else
      itemPrice = 0.62;
    System.out.printf("the per item price is: $%.2f\n", itemPrice);
    
    // determine the shipping method
    //Gave each letter a shipping service
    System.out.println("enter shipping method (A(Federal Express) ,"
    		+ " B(United Parcel Service),"
    		+ " C(DHL),"
    		+ " or D(United States Postal Service)");
    shipMethod = sc.next().charAt(0);
    
    // determine the shipping charge
    switch(shipMethod) {
    //Added D which is the free shipping
      case 'A': case 'a': shipCharge = 5.00; break;
      case 'B': case 'b': shipCharge = 7.20; break;
      case 'C': case 'c': shipCharge = 10.00; break;
      case 'D': case 'd': shipCharge = 0.00; break;
      default:  shipCharge = 20.00;
    }
    System.out.printf("the shipping charge is: $%.2f\n" , shipCharge);
    
    // determine the days from invoice date to today's date
    System.out.println("is discount period valid? true or false");
    check = sc.nextBoolean();
    if (check == true) 
    {
      check = true;
    }
    else
    {
      check = false;
    }
    System.out.println("discount valid? " + check);
 // determine and display the total invoice amount
    subTotal = numItems * itemPrice;
    if(check == true) {
    	//Gave a simpler variable that gives discount
      double save = 1 - discount;
      totAmt = subTotal * (save) + shipCharge;
      //made a variable that gives the total amount save from original price
      double totSave = subTotal - totAmt;
      //made a variable that gives the realistic amount total
      double realAmt = subTotal*save;
      //prints out the amount saved and the amount you are paying in total without the shipping fee
      System.out.println("You saved:$"+df.format(totSave));
      System.out.println("How much you pay without shipping:$"+df.format(realAmt));
    }
    else {
      totAmt = subTotal + shipCharge;
      double realAmt = subTotal;
      //similar to the if statement
      System.out.println("How much you pay without shipping:$"+realAmt);
    }
    System.out.printf("(total invoice amount due) $%.2f\n",totAmt);
    
    // the program footer
    System.out.println(" ");
    System.out.println("thank you!");
    System.out.println("---------------------");
    }
}

