import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class LendReg extends OIS {
	
	private String codeItem;
	private String nameItem;
	private String cat;
	private String dateReg;
	private String loc;
	private int qty;
		
	/**
	 * default constructor or no-arg constructor are use to set variable
	 * to the default value.
	 */
    public LendReg()
    {
    	super();
    	codeItem= "";
    	nameItem= "";
    	cat= "";
    	dateReg= "";
    	loc= "";
    	qty= 0;
    }
	
    /**
	 * normal constructor use to set the value of the variable from the parameter receive from the user input
	 */
    public LendReg(String staffID, String nameLend, String contact ,String dpt,String codeItem, String nameItem, String cat, String dateReg, String loc, int qty)
    {
    	 super(staffID,nameLend,contact,dpt);
         this.codeItem=codeItem;
         this.nameItem=nameItem;
         this.cat=cat;
         this.dateReg=dateReg;
         this.loc=loc;
         this.qty=qty;
    }
	
	
	// process save data
    public void lendReg()
    {
    	PrintWriter userDB = null; 
 
        try{
        	 File file = new File("db/lend.txt");
			 // check if file dont exits, automatically create
	       	  if(!file.exists()){
	       		file.createNewFile();
	       	  }
	       	  
	         this.codeItem=codeItem;
	         this.nameItem=nameItem;
	         this.cat=cat;
	         this.dateReg=dateReg;
	         this.loc=loc;
	         this.qty=qty;
	       	  
	           String empStaffID = getStaffID();
	           String empStaffName = getStaffName();
	           String empPhone = getStaffContactNo();
	           String empDepartment = getStaffDepartment();
	           String lendCodeItem=codeItem;
	           String lendItemName=nameItem;
	           String lendCategory=cat;
	           String lendDateReg=dateReg;
	           String lendLocation=loc;
	           int lendQty=qty;
				
			   userDB = new PrintWriter (new BufferedWriter(new FileWriter("db/lend.txt", true))); 
			   userDB.print(empStaffID+";");
			   userDB.print(empStaffName+";"); 
			   userDB.print(empPhone+";"); 
			   userDB.print(empDepartment+";"); 
			   userDB.print(lendCodeItem+";");
			   userDB.print(lendItemName+";");
			   userDB.print(lendCategory+";");
			   userDB.print(lendDateReg+";");
			   userDB.print(lendLocation+";");
			   userDB.print(lendQty);
			   userDB.println();
		 	   userDB.close();
		 	   

	        	JOptionPane.showMessageDialog(null, "Request Successfully Added!");
		 	   
        }
        catch(IOException ioe){
     	   System.out.println("Exception occurred:");
     	   ioe.printStackTrace();
       }
    }
    
	 @Override
	    public String toString() {
	        String data = null;
	        return data;
	    }
	
 // process update data stationary
    public void updateQtyStationary() throws FileNotFoundException
    {
        try{
        	
        	File inputFile = new File("db/stationary.txt");
	        File tempFile = new File("db/tempFile.txt");

	        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	        // Construct the new file that will later be renamed to the original
	        // filename.
	        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
	        
		        String currentLine = null;
		        while((currentLine = reader.readLine()) != null) {
		        	String[] tokens = currentLine.split(";");
		        	
		        	String productID = tokens[0];
		        	String itemName = tokens[1];
		        	String category = tokens[2];
		        	String datePurchase = tokens[3];
		        	String quantity = tokens[4];
		        	String price = tokens[5];
		        	String status = tokens[6];
		        	
	        	 if(productID.contains(codeItem)){
	        		 
	        		 int newQty = qty;
	        		 int oldQty = Integer.parseInt(quantity);
	        		 int minus = oldQty - newQty;
	        		 String newquantity = new Integer(minus).toString(); 
	        		 
	        		 if(minus == 0){
	        			 status = "In Use";
	        		 }
	        		 
	        		 pw.print(productID+";");
					 pw.print(itemName+";"); 
					 pw.print(category+";"); 
					 pw.print(datePurchase+";"); 
					 pw.print(newquantity+";");
					 pw.print(price+";");
					 pw.print(status);
					 pw.println();
	            }else{
	            	pw.print(productID+";");
					 pw.print(itemName+";"); 
					 pw.print(category+";"); 
					 pw.print(datePurchase+";"); 
					 pw.print(quantity+";");
					 pw.print(price+";");
					 pw.print(status);
					 pw.println();
	            }
	        	 pw.flush();
	        }
	        
	        // rewrite from tempfile to original file
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
        	
	        }catch(FileNotFoundException fe)  {   System.out.println(fe.getMessage());  } 
	        catch(IOException ioe){ System.out.println("Exception occurred:");
	     	   ioe.printStackTrace();
       } 
    }   
    
 // process update data furniture
    public void updateQtyFurniture() throws FileNotFoundException
    {
        try{
        	
        	File inputFile = new File("db/furniture.txt");
	        File tempFile = new File("db/tempFile.txt");

	        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	        // Construct the new file that will later be renamed to the original
	        // filename.
	        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
	        
		        String currentLine = null;
		        while((currentLine = reader.readLine()) != null) {
		        	String[] tokens = currentLine.split(";");
		        	
		        	String productID = tokens[0];
		        	String itemName = tokens[1];
		        	String category = tokens[2];
		        	String datePurchase = tokens[3];
		        	String quantity = tokens[4];
		        	String price = tokens[5];
		        	String status = tokens[6];
		        	
	        	 if(productID.contains(codeItem)){
	        		 
	        		 int newQty = qty;
	        		 int oldQty = Integer.parseInt(quantity);
	        		 int minus = oldQty - newQty;
	        		 String newquantity = new Integer(minus).toString(); 
	        		 
	        		 if(minus == 0){
	        			 status = "In Use";
	        		 }
	        		 
	        		 pw.print(productID+";");
					 pw.print(itemName+";"); 
					 pw.print(category+";"); 
					 pw.print(datePurchase+";"); 
					 pw.print(newquantity+";");
					 pw.print(price+";");
					 pw.print(status);
					 pw.println();
	            }else{
	            	pw.print(productID+";");
					 pw.print(itemName+";"); 
					 pw.print(category+";"); 
					 pw.print(datePurchase+";"); 
					 pw.print(quantity+";");
					 pw.print(price+";");
					 pw.print(status);
					 pw.println();
	            }
	        	 pw.flush();
	        }
	        
	        // rewrite from tempfile to original file
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
        	
	        }catch(FileNotFoundException fe)  {   System.out.println(fe.getMessage());  } 
	        catch(IOException ioe){ System.out.println("Exception occurred:");
	     	   ioe.printStackTrace();
       } 
    }   
    
 // process update data devices
    public void updateQtyDevices() throws FileNotFoundException
    {
        try{
        	
        	File inputFile = new File("db/devices.txt");
	        File tempFile = new File("db/tempFile.txt");

	        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	        // Construct the new file that will later be renamed to the original
	        // filename.
	        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
	        
		        String currentLine = null;
		        while((currentLine = reader.readLine()) != null) {
		        	String[] tokens = currentLine.split(";");
		        	
		        	String productID = tokens[0];
		        	String itemName = tokens[1];
		        	String category = tokens[2];
		        	String datePurchase = tokens[3];
		        	String quantity = tokens[4];
		        	String price = tokens[5];
		        	String status = tokens[6];
		        	
	        	 if(productID.contains(codeItem)){
	        		 
	        		 int newQty = qty;
	        		 int oldQty = Integer.parseInt(quantity);
	        		 int minus = oldQty - newQty;
	        		 String newquantity = new Integer(minus).toString(); 
	        		 
	        		 if(minus == 0){
	        			 status = "In Use";
	        		 }
	        		 
	        		 pw.print(productID+";");
					 pw.print(itemName+";"); 
					 pw.print(category+";"); 
					 pw.print(datePurchase+";"); 
					 pw.print(newquantity+";");
					 pw.print(price+";");
					 pw.print(status);
					 pw.println();
	            }else{
	            	pw.print(productID+";");
					 pw.print(itemName+";"); 
					 pw.print(category+";"); 
					 pw.print(datePurchase+";"); 
					 pw.print(quantity+";");
					 pw.print(price+";");
					 pw.print(status);
					 pw.println();
	            }
	        	 pw.flush();
	        }
	        
	        // rewrite from tempfile to original file
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
        	
	        }catch(FileNotFoundException fe)  {   System.out.println(fe.getMessage());  } 
	        catch(IOException ioe){ System.out.println("Exception occurred:");
	     	   ioe.printStackTrace();
       } 
    }   

}
