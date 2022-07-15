import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class StationariesReg {
	
	private String code;
	private String itemName;
	private String category;
	private String datePurchase;
	private int quantity;
	private double price;
	private String status;
	
	
	 // default constructor
    public StationariesReg()
    {
    	code= "";
    	itemName= "";
    	category= "";
    	datePurchase= "";
    	quantity= 0;
    	price= 0.0;
    	status= "";
    }
	
	// normal constructor
    public StationariesReg(String code, String itemName, String category,String datePurchase,int quantity, double price, String status)
    {
         this.code=code;
         this.itemName=itemName;
         this.category=category;
         this.datePurchase=datePurchase;
         this.quantity=quantity;
         this.price=price;
         this.status=status;
    }
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDatePurchase() {
		return datePurchase;
	}
	public void setDatePurchase(String datePurchase) {
		this.datePurchase = datePurchase;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	// process save data
    public void regStationary()
    {
    	PrintWriter userDB = null; 
 
        try{
        	 File file = new File("db/stationary.txt");
			 // check if file dont exits, automatically create
	       	  if(!file.exists()){
	       		file.createNewFile();
	       	  }
	       	  
	           String statcode=code;
	           String statitemName=itemName;
	           String statcategory=category;
	           String statdatePurchase=datePurchase;
	           int statquantity=quantity;
	           double statprice=price;
	           String statstatus=status;
				
			   userDB = new PrintWriter (new BufferedWriter(new FileWriter("db/stationary.txt", true))); 
			   userDB.print(statcode+";");
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
	
 // process update data
    public void UpdateStationary() throws FileNotFoundException
    {
        try{
        	
        	File inputFile = new File("db/stationary.txt");
	        File tempFile = new File("db/tempFile.txt");

	        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	        // Construct the new file that will later be renamed to the original
	        // filename.
	        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
	        
	           String statcode=code;
	           String statitemName=itemName;
	           String statcategory=category;
	           String statdatePurchase=datePurchase;
	           int statquantity=quantity;
	           double statprice=price;
	           String statstatus=status;
		        
		        String currentLine = null;
		        while((currentLine = reader.readLine()) != null) {
		        	String[] tokens = currentLine.split(";");
	        	 if(currentLine.contains(statcode)){
	        		
					 pw.print(statcode+";");
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
	        
	        // delete tempFile
            boolean success = tempFile.delete();
        	JOptionPane.showMessageDialog(null, "Update Successfully !");
        	
	        }catch(FileNotFoundException fe)  {   System.out.println(fe.getMessage());  } 
	        catch(IOException ioe){ System.out.println("Exception occurred:");
	     	   ioe.printStackTrace();
       } 
    }   
    
    
 // process delete data
    public void deleteStationary() throws FileNotFoundException
    {
    	try {
    		
    	String statcode=code;
    		
    	File inputFile = new File("db/stationary.txt");
        File tempFile = new File("db/tempFile.txt");
        
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        String currentLine;
        while((currentLine = reader.readLine()) != null) {
        	String[] tokens = currentLine.split(";");
        	String codeDB = tokens[0];
        	
        if(!statcode.equalsIgnoreCase(codeDB)){
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
