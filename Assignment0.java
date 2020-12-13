/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * 
 * Here, We have data of Used Car from CarDekho.com in csv file format. Now we have sort data according to the query listed below
 *  1 --> SELECT * FROM cardetails WHERE year = entered year
 *  2 --> SELECT * FROM cardetails WHERE year = entered year AND km_driven < entered km  
 *  3 --> SELECT * FROM cardetails WHERE transmission = entered transmissiontype AND selling_price < entered price
 * 
 * 
 * 	NOTE:- In case code do not run try changing the path of csv file according to your PC. 
 */
import java.io.*;
import java.util.Scanner;
public class Assignment0 
{
   public static final String delimiter = ",";
   public static void csvread(String csvFile) 
   {
	   
         String[] rowdata;
         int ch = 0;
         
     
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
         
         do
         {
			System.out.println("************************************************************************************************************************************************");
			System.out.println("PRESS 1 for SELECT * FROM cardetails WHERE year = entered year");
			System.out.println("PRESS 2 for SELECT * FROM cardetails WHERE year = entered year AND km_driven < entered km");
			System.out.println("PRESS 3 for SELECT * FROM cardetails WHERE transmission = entered transmissiontype AND selling_price < entered price");
			System.out.println("PRESS 4 for EXIT");
        	System.out.println("************************************************************************************************************************************************");
        	System.out.print("Enter your choice: ");
        	ch = sc.nextInt();
        	 
        	 switch(ch)
        	 {
        	 	case 1: 
        	 	{
					try 
					{
						File file = new File(csvFile);//opening the car details csv file
						FileReader fr = new FileReader(file);
						BufferedReader br = new BufferedReader(fr);
						String line = ""; 
						sc.nextLine();
						System.out.print("Enter year : ");// enter the year by which you want to sort
						String year = sc.nextLine(); 
						System.out.println("************************************************************************************************************************************************");
						System.out.println("Your query is SELECT * FROM cardetails WHERE year = " + year); //ths is the select query format
						System.out.println("************************************************************************************************************************************************");
						System.out.printf("%50s %7s %10s %10s %7s %17s %13s %10s", "NAME", "YEAR", "SELL PRICE", "KM DRIVEN", "FUEL","SELLER TYPE","TRANSMISSION","OWNER");
						System.out.println();
						System.out.println("************************************************************************************************************************************************");
    
						while((line = br.readLine()) != null) // it reads line by line
						{
							rowdata = line.split(delimiter);// it separate the line using delimiter
							
							String tempData1 = rowdata[1]; // it checks each tuple with the year entered
					
							if (tempData1.equals(year)) // print tuple if year is same 
							{
								System.out.format("%50s %7s %10s %10s %7s %17s %13s %10s", rowdata[0], rowdata[1], rowdata[2], rowdata[3], rowdata[4], rowdata[5], rowdata[6], rowdata[7]);
								System.out.println();
							}
						}
						
						br.close();
					}
				   catch(IOException ioe) 
				   {
					   ioe.printStackTrace();
				   }
					
        	 	}//End of case 1
				break;
				 
				
				 
				case 2: 
        	 	{
					try 
					{
						File file = new File(csvFile);
						FileReader fr = new FileReader(file);
						BufferedReader br = new BufferedReader(fr);
						String line = ""; 
						sc.nextLine();
						System.out.print("Enter year : ");
						String year = sc.nextLine(); 
						System.out.print("Enter km : ");
						int km = sc.nextInt(); 
						System.out.println("************************************************************************************************************************************************");
						System.out.println("Your query is SELECT * FROM cardetails WHERE year = "+ year + " AND km_driven < " + km);
						System.out.println("************************************************************************************************************************************************");
						System.out.printf("%50s %7s %10s %10s %7s %17s %13s %10s", "NAME", "YEAR", "SELL PRICE", "KM DRIVEN", "FUEL","SELLER TYPE","TRANSMISSION","OWNER");
						System.out.println();
						System.out.println("************************************************************************************************************************************************");
    
						while((line = br.readLine()) != null) 
						{
							rowdata = line.split(delimiter);
							
							String tempData1 = rowdata[1];
							
							if (tempData1.equals(year))
							{
								int tempkm = Integer.parseInt(rowdata[3]);
								if (tempkm<km) 
								{
									System.out.format("%50s %7s %10s %10s %7s %17s %13s %10s", rowdata[0], rowdata[1], rowdata[2], rowdata[3], rowdata[4], rowdata[5], rowdata[6], rowdata[7]);
									System.out.println();
								}
							}
						}
						br.close();
					}
				   catch(IOException ioe) 
				   {
					   ioe.printStackTrace();
				   }
        	 	}//End of case 2
        	 	break; 
				 
				case 3: 
        	 	{
					try 
					{
						File file = new File(csvFile);
						FileReader fr = new FileReader(file);
						BufferedReader br = new BufferedReader(fr);
						String line = ""; 
						sc.nextLine();
						String transmission = " ";
						System.out.print("1. Automatic \n2. Manual \nSelect transmission : ");
						int n = sc.nextInt(); 
						if (n==1) {
							transmission = "Automatic";
						}
						else if(n==2){
							transmission = "Manual";
						}
						System.out.print("Enter price : ");
						int price = sc.nextInt(); 
						System.out.println("************************************************************************************************************************************************");
						System.out.println("Your query is SELECT * FROM cardetails WHERE transmission = " + transmission + " AND selling_price < " + price);
						System.out.println("************************************************************************************************************************************************");
						System.out.printf("%50s %7s %10s %10s %7s %17s %13s %10s", "NAME", "YEAR", "SELL PRICE", "KM DRIVEN", "FUEL","SELLER TYPE","TRANSMISSION","OWNER");
						System.out.println();
						System.out.println("************************************************************************************************************************************************");
    
						while((line = br.readLine()) != null) 
						{
							rowdata = line.split(delimiter);
							
							String tempData1 = rowdata[6];
							
							if (tempData1.equals(transmission))
							{
								int tempprice = Integer.parseInt(rowdata[2]);
								if (tempprice<price) 
								{
									System.out.format("%50s %7s %10s %10s %7s %17s %13s %10s", rowdata[0], rowdata[1], rowdata[2], rowdata[3], rowdata[4], rowdata[5], rowdata[6], rowdata[7]);
									System.out.println();
								}
							}
						}
						br.close();
					}
				   catch(IOException ioe) 
				   {
					   ioe.printStackTrace();
				   }
					
        	 	}//End of case 3
				 break;
			 }	 
		 }while(ch != 4);
		 
   }
   
 
   
   public static void main(String[] args) 
   {
      // csv file to read
      String csvFile = "cardetails.csv";
      Assignment0.csvread(csvFile);
      System.out.println("");
   }
}