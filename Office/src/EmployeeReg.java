import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class EmployeeReg extends OIS  {
	
	private String username;
	private String password;
	private String role;
	
	/**
	 * default constructor or no-arg constructor are use to set variable
	 * to the default value
	 */
    public EmployeeReg()
    {
         super();
         username= "Not Set Yet";
         password= "Not Set Yet";
         role= "Not Set Yet";
    }
	
    /**
	 * normal constructor use to set the value of the variable from the parameter receive from the user input
	 */
    public EmployeeReg(String StaffID, String StaffName, String StaffContactNo,String StaffDepartment,String username,String password,String role)
    {
         super(StaffID,StaffName,StaffContactNo,StaffDepartment);
         this.username=username;
         this.password=password;
         this.role=role;
    }
	
	//username
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	//password
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	//password
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	 @Override
	    public String toString() {
	        String data = null;
	        return data;
	    }
		
	
	 /**
	 * this function are use to generate new employee/staff id using the auto increment from data
	 * in the text file and return it into string.
	 */
	public String generateID() throws IOException{
		
		String idStaff = "";
		int id = 1000;
		
		String inData = null; 
		BufferedReader in = null; 
		try {
			in = new BufferedReader (new FileReader("db/userdb.txt"));
			while((inData = in.readLine()) != null)   
			{    
				id++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		idStaff = "A"+id;
		return idStaff;
	}
	
	/**
	 * this function are use to register or create new employee as a user
	 *  into userDB.txt
	 */
    public void regEmployee()
    {
    	PrintWriter userDB = null; 
 
        try{
        	
        	 File file = new File("db/userdb.txt");
			 // check if file dont exits, automatically create
	       	  if(!file.exists()){
	       		file.createNewFile();
	       	  }
	       	  
	           String empStaffID = getStaffID();
	           String empStaffName = getStaffName();
	           String empPhone = getStaffContactNo();
	           String empDepartment = getStaffDepartment();
	           String empUsername = username;
	           String empPassword = password;
	           String empRole = role;
				
			   userDB = new PrintWriter (new BufferedWriter(new FileWriter("db/userdb.txt", true))); 
			   userDB.print(empStaffID+";");
			   userDB.print(empStaffName+";"); 
			   userDB.print(empPhone+";"); 
			   userDB.print(empDepartment+";"); 
			   userDB.print(empUsername+";");
			   userDB.print(empPassword+";");
			   userDB.print(empRole);
			   userDB.println();
		 	   userDB.close();
			
        }
        catch(IOException ioe){
     	   System.out.println("Exception occurred:");
     	   ioe.printStackTrace();
       }
    }
    
    /**
	 * this function are use to update the selected employee from userdb.txt
	 */
    public void UpdateDB() throws FileNotFoundException
    {
        try{
        	
        	File inputFile = new File("db/userdb.txt");
	        File tempFile = new File("db/tempFile.txt");

	        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	        // Construct the new file that will later be renamed to the original
	        // filename.
	        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
	        
	       String empStaffID = getStaffID();
           String empStaffName = getStaffName();
           String empPhone = getStaffContactNo();
           String empDepartment = getStaffDepartment();
           String empUsername = username;
           String empPassword = password;
           String empRole = role;
	        
	        String currentLine = null;
	        while((currentLine = reader.readLine()) != null) {
	        	String[] tokens = currentLine.split(";");
	        	 if(currentLine.contains(empStaffID)){
	        		
					 pw.print(empStaffID+";");
					 pw.print(empStaffName+";"); 
					 pw.print(empPhone+";"); 
					 pw.print(empDepartment+";"); 
					 pw.print(empUsername+";");
					 pw.print(empPassword+";");
					 pw.print(empRole);
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
            
	        }catch(FileNotFoundException fe)  {   System.out.println(fe.getMessage());  } 
	        catch(NullPointerException npe) {  
				 JOptionPane.showMessageDialog(null,
		                "All field are required, Please enter all information",
		                "Incorrect",
		                JOptionPane.ERROR_MESSAGE); }
	        catch(IOException ioe){ System.out.println("Exception occurred:");
	     	   ioe.printStackTrace();
       } 
    }
    
    /**
	 * this function are use to delete the selected employee from userdb.txt
	 */
    public void deleteEmployee() throws FileNotFoundException
    {
    	try {
    		File inputFile = new File("db/userdb.txt");
	        File tempFile = new File("db/tempFile.txt");
        
	        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
	        String currentLine;
	        
	        String empStaffID = getStaffID();
	        
	        while((currentLine = reader.readLine()) != null) {
	        	String[] tokens = currentLine.split(";");
	        	String code = tokens[0];
	        	
	        if(!empStaffID.equalsIgnoreCase(code)){
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
	
	        /**
	    	 * this function use to delete temporary file after finish update and save the data into textfile
	    	 */
	        boolean successfulDelete = tempFile.delete();
	    	JOptionPane.showMessageDialog(null, "Delete Successfully!");
	        
		    }catch(FileNotFoundException fe)  {   System.out.println(fe.getMessage());  } 
		    catch(IOException ioe){ System.out.println("Exception occurred:");
		 	   ioe.printStackTrace();
		} 
    }
	
}
