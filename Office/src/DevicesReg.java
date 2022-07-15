import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class DevicesReg {
	
	private String productID;
	private String itemName;
	private String category;
	private String datePurchase;
	private int quantity;
	private double price;
	private String status;
	
	/**
	 * default constructor or no-arg constructor are use to set variable
	 * to the default value
	 */
    public DevicesReg()
    {
    	productID= "";
    	itemName= "";
    	category= "";
    	datePurchase= "";
    	quantity= 0;
    	price= 0.0;
    	status= "";
    }
	
    /**
	 * normal constructor use to set the value of the variable from the parameter receive from the user input
	 */
    public DevicesReg(String productID, String itemName, String category,String datePurchase,int quantity, double price, String status)
    {
         this.productID=productID;
         this.itemName=itemName;
         this.category=category;
         this.datePurchase=datePurchase;
         this.quantity=quantity;
         this.price=price;
         this.status=status;
    }
	
    /**
	 * getter or mutator that use to get the value from variable
	 */
	public String getproductID() {
		return productID;
	}
	
	 /**
	 * setter that use to set the value to variable
	 */
	public void setproductID(String productID) {
		this.productID = productID;
	}
	
	/**
	 * getter or mutator that use to get the value from variable
	 */
	public String getItemName() {
		return itemName;
	}
	
	 /**
	 * setter that use to set the value to variable
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	/**
	 * getter or mutator that use to get the value from variable
	 */
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	/**
	 * getter or mutator that use to get the value from variable
	 */
	public String getDatePurchase() {
		return datePurchase;
	}
	public void setDatePurchase(String datePurchase) {
		this.datePurchase = datePurchase;
	}
	
	/**
	 * getter or mutator that use to get the value from variable
	 */
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * getter or mutator that use to get the value from variable
	 */
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * getter or mutator that use to get the value from variable
	 */
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * this function are use to register new device into text files name devices.txt
	 */
    public void regDevices()
    {
    	PrintWriter userDB = null; 
 
        try{
        	 File file = new File("db/devices.txt");
			 // check if file dont exits, automatically create
	       	  if(!file.exists()){
	       		file.createNewFile();
	       	  }
	       	  
	           String statproductID=productID;
	           String statitemName=itemName;
	           String statcategory=category;
	           String statdatePurchase=datePurchase;
	           int statquantity=quantity;
	           double statprice=price;
	           String statstatus=status;
				
			   userDB = new PrintWriter (new BufferedWriter(new FileWriter("db/devices.txt", true))); 
			   userDB.print(statproductID+";");
			   userDB.print(statitemName+";"); 
			   userDB.print(statcategory+";"); 
			   userDB.print(statdatePurchase+";"); 
			   userDB.print(statquantity+";");
			   userDB.print(statprice+";");
			   userDB.print(statstatus);
			   userDB.println();
		 	   userDB.close();
		 	   
        }
        catch(IOException ioe){
     	   System.out.println("Exception occurred:");
     	   ioe.printStackTrace();
       }
    }
	
	/**
	 * this function are use to update the selected device from devices.txt
	 */
    public void UpdateDevices() throws FileNotFoundException
    {
        try{
        	
        	File inputFile = new File("db/devices.txt");
	        File tempFile = new File("db/tempFile.txt");

	        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	        // Construct the new file that will later be renamed to the original
	        // filename.
	        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
	        
	           String statproductID=productID;
	           String statitemName=itemName;
	           String statcategory=category;
	           String statdatePurchase=datePurchase;
	           int statquantity=quantity;
	           double statprice=price;
	           String statstatus=status;
		        
		        String currentLine = null;
		        while((currentLine = reader.readLine()) != null) {
		        	String[] tokens = currentLine.split(";");
	        	 if(currentLine.contains(statproductID)){
	        		
					 pw.print(statproductID+";");
					 pw.print(statitemName+";"); 
					 pw.print(statcategory+";"); 
					 pw.print(statdatePurchase+";"); 
					 pw.print(statquantity+";");
					 pw.print(statprice+";");
					 pw.print(statstatus);
					 pw.println();
	            }else{
	        	 pw.println(currentLine);
	            }
	        	 pw.flush();

	        }
	        

	    	/**
	    	 * read data from the tempFile.txt and write into original file
	    	 */
	        BufferedReader read = new BufferedReader(new FileReader(tempFile));
	        BufferedWriter write = new BufferedWriter(new FileWriter(inputFile));
	        String writeLine;
	        while((writeLine = read.readLine()) != null) {
	        	write.write(writeLine + System.getProperty("line.separator"));
	        	write.flush(); 
	        }
	        pw.close(); 
	        reader.close(); 
	        write.close();
	        read.close(); 
	        
	    	/**
	    	 * this function use to delete temporary file after finish update and save the data into textfile
	    	 */
            boolean success = tempFile.delete();
        	JOptionPane.showMessageDialog(null, "Update Successfully !");
        	
	        }catch(FileNotFoundException fe)  {   System.out.println(fe.getMessage());  } 
	        catch(IOException ioe){ System.out.println("Exception occurred:");
	     	   ioe.printStackTrace();
       } 
    }   
    
    
	/**
	 * this function are use to delete the selected device from devices.txt
	 */
    public void deleteDevices() throws FileNotFoundException
    {
    	try {
    		
    	String statproductID=productID;
    		
    	File inputFile = new File("db/devices.txt");
        File tempFile = new File("db/tempFile.txt");
        
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        String currentLine;
        while((currentLine = reader.readLine()) != null) {
        	String[] tokens = currentLine.split(";");
        	String staffID = tokens[0];
        	
        if(!statproductID.equalsIgnoreCase(staffID)){
                 writer.write(currentLine + System.getProperty("line.separator"));
            }
    	     writer.flush(); 
        }
        
        // rewrite from tempfile to original file
        BufferedReader read = new BufferedReader(new FileReader(tempFile));
        BufferedWriter write = new BufferedWriter(new FileWriter(inputFile));
        String writeLine;
        while((writeLine = read.readLine()) != null) {
        	write.write(writeLine + System.getProperty("line.separator"));
        	write.flush(); 
        }
        
        writer.close();
        reader.close(); 
        write.close();
        read.close(); 

        boolean successfulDelete = tempFile.delete();
    	JOptionPane.showMessageDialog(null, "Delete Successfully!");
        
	    }catch(FileNotFoundException fe)  {   System.out.println(fe.getMessage());  } 
	    catch(IOException ioe){ System.out.println("Exception occurred:");
	 	   ioe.printStackTrace();
	} 
    }


}
