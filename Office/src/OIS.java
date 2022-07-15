public abstract class OIS {
    
    private String StaffID;
    private String StaffName;
	private String StaffContactNo;
	private String StaffDepartment;
  
    // default constructor
    public  OIS () 
    { 
    	StaffID = "Not Set Yet";
    	StaffName = "Not Set Yet";
    	StaffContactNo= "Not Set Yet";
        StaffDepartment= "Not Set Yet";
    }
    
    // normal constructor
    public  OIS (String StaffID, String StaffName, String StaffContactNo, String StaffDepartment) 
    {
    	this.StaffID = StaffID;
        this.StaffName = StaffName;
        this.StaffContactNo=StaffContactNo;
        this.StaffDepartment=StaffDepartment;
    }
    
    // setter / mutator
    public void setStaffID(String StaffID){ this.StaffID = StaffID; }
    public void setStaffIC(String StaffName){ this.StaffName = StaffName; }
    public void setStaffContactNo(String StaffContactNo){ this.StaffName = StaffContactNo; }
    public void setStaffDepartment(String StaffDepartment){ this.StaffName = StaffDepartment; }
    
    // getter / accessor /retrieval
    public String getStaffID() { return StaffID; } 
    public String getStaffName() { return StaffName; }
    public String getStaffContactNo() { return StaffContactNo; }
    public String getStaffDepartment() { return StaffDepartment; }
    
    @Override
    public abstract String toString();
    
}
