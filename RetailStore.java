import java.util.Scanner;
import java.util.Random;
import javax.swing.JOptionPane;
// Jorell Socorro

public class RetailStore 
{
  Scanner scan = new Scanner(System.in);
  
  public static void main(String args[])
  {
	  //added one more row
	  int rows = 7;
	  int columns = 8;
	  int[ ][ ] table = new int[rows][columns];
	 
	  Random randomGen = new Random();
	  StringBuilder s = new StringBuilder();
	  int randomInt1 = 0;
	  int randomInt2 = 0;
	  //Used to get the total count
	  int x = 0;//grabs number
      int y = 0;//other lane total
      int v = 0;//express lane total
      int z = 0;//v + y total
	  
	  // generate column titles
	  for (int j = 0; j < columns; j++)
	  {
		  s.append("\thr " + (j + 1));
	  }
	  s.append("\n\n");
	  // populate data for each cashier lane
	  for (int i = 0; i < rows; i++)
	  {
		   s.append("lane " + (i + 1));
          	   s.append("\t");
		  for (int j = 0; j < columns; j++)
		  {
			  
			  // express checkout lane
			  randomInt1 = 1 + randomGen.nextInt(20);
			  // standard checkout lane
			  randomInt2 = 1 + randomGen.nextInt(10);
			  if(i == 0) {
				  table[i][j] = randomInt1;
				  //counts the express checkout lane while filling up the table
			  	  x = randomInt1;
			  	  v = v + x;
			  }
			  else {
				  table[i][j] = randomInt2;
				  //counts the other lanes while filling up the table
				  x = randomInt2;
				  y = y + x;
			  }
			  //sums up the total counts from the otherlanes with the express lane
			  z = y + v;
	          s.append(table[i][j]);
	          s.append(" ");
	          s.append("\t"); 
	      }
		  s.append("\n");
	  }
	  System.out.println("data simulation: \n\n" + s);
	  //outputs the total customers
	  System.out.println("Total Customers:" + z);
	  System.out.println("");	  
	  
	    
	  
	  // perform data analysis
	  // row analysis
	  String str = 
	  JOptionPane.showInputDialog(null, "enter a cashier lane number : ");
	  // subtract 1 to compensate for a zero indexed array
	  int laneNum = Integer.parseInt(str) - 1;
	  double average = 0.0, sum = 0.0;
	  
	  for (int j = 0; j < columns ; j++)  
	  {
		  sum += table[laneNum][j];
	  }
	  average = sum / columns;
	  System.out.println( "" );
	  
	  String outputMsg = "";
	  outputMsg += "\n for cashier lane " + (laneNum + 1);
	  outputMsg += "\n the data analysis is: ";
	  outputMsg += "\n customer count -> " + Math.round(sum);
	  outputMsg += "\n average -> " + Math.round(average);
	  
	  
	  JOptionPane.showMessageDialog(null, outputMsg,
	  "Data Row Analysis", JOptionPane.PLAIN_MESSAGE);
	  //Determines if the average was 10 or more
	  double roundAvg = Math.round(average);
	  if(roundAvg >= 10) {
		  JOptionPane.showMessageDialog(null, "We need another Cashier", "WARNING", JOptionPane.PLAIN_MESSAGE);
	  }
	  	  	  
	  // column analysis
	  str = JOptionPane.showInputDialog(null, "enter an hour number : ");
	  // subtract 1 to compensate for a zero indexed array
	  int hourNum = Integer.parseInt(str) - 1;
	// reset the accumulating variable
		  sum = 0;	  
		  for (int i = 0; i < rows ; i++) 
		  {
			  sum += table[i][hourNum];
			  System.out.println( table[i][hourNum] );
		  }
		  average = sum / rows;
		  System.out.println( "" );
		  
		  outputMsg = "";
		  outputMsg += "\n for hour number " + (hourNum + 1);
		  outputMsg += "\n the data analysis is: ";
		  outputMsg += "\n customer count -> " + Math.round(sum);
		  outputMsg += "\n average -> " + Math.round(average);
		  
		  JOptionPane.showMessageDialog(null, outputMsg,
		  "Data Column Analysis", JOptionPane.PLAIN_MESSAGE);
		  
		  //Determines if the average was 10 or more
		  roundAvg = average;
		  if(roundAvg >= 10) {
			  JOptionPane.showMessageDialog(null, "We need another Cashier", "WARNING", JOptionPane.PLAIN_MESSAGE);
		  }
		  
		  //outputs the total number of customers
		  JOptionPane.showMessageDialog(null, "Total:"+z, "Customer Count", JOptionPane.PLAIN_MESSAGE);
	  }
	}
