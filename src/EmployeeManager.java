import employeeType.employee.Employee;
import employeeType.subTypes.CommissionEmployee;
import employeeType.subTypes.HourlyEmployee;
import employeeType.subTypes.SalaryEmployee;
import exceptions.InvalidCharacterException;

/*  Name        : Daniel O'Connell
 *  Class       : 1620-001
 *  Program #   : 3
 *  Due Date    : October 15, 2015
 *  
 *  Honor Pledge:  On my honor as a student of the University
 *                of Nebraska at Omaha, I have neither given nor received
 *                unauthorized help on this homework assignment.
 *
 * NAME: Daniel O'Connell
 * NUID: 12992765
 * EMAIL: danwoc@gmail.com  
 * Partners:  none
 *
 * Description:
 * This program creates a simple class hierarchy using abstract methods and inheritance
 * building upon the Employee program from assignments 1 and 2. This program simulates an 
 * employee management system that might be used by restaurants or similarly structured 
 * organizations. This assignment adds a search function to find an employee by name.
 */

public class EmployeeManager {
    private Employee[] employees;
    private final int employeeMax = 100;
    private int currentEmployees;
    
    /*  Method Name   : <<EmployeeManager>>
     *  Parameters    : None.
     *  Return Values : None.
     *  Partners      : None.
     *  Description   : Constructor method for the EmployeeManager class.
     *                  Creates a new array of employees using the maximum
     *                  size of employeeMax. Sets currentEmployees to 0.
     */
    public EmployeeManager(){
        employees = new Employee[employeeMax];
        currentEmployees = 0;
    }
    
    /*  Method Name   : addEmployee
     *  Parameters    : Integer for type of employee to be created
     *                  Strings for first name and last name
     *                  Characters for gender and middle initial
     *                  Integer for employee number
     *                  Boolean for full time or part time
     *                  Double for rate
     *  Return Values : None.
     *  Partners      : None.
     *  Description   : Creates a new employee object of the given type at the next available
     *                  opening in the array.
     */
    public void addEmployee(int type, String fn, String ln, char m, char g, int en, boolean ft, double amount){
        boolean exists;
        if (currentEmployees != employeeMax){
            switch(type){
                case 1:  //This is an hourly employee
                    exists = false;
                    if(currentEmployees != 0){
                        for(int i = 0; i < currentEmployees; i++){
                            if(employees[i].getEmployeeNumber() == en){
                                exists = true;
                            }
                        }
                    }
                    
                    if(exists == true){
                        System.out.println("\nDuplicate Not Added\n");
                    }
                    else{
                        employees[currentEmployees] = new HourlyEmployee(fn, ln, m, g, en, ft, amount);
                        currentEmployees++;    
                    }
                    break; //end case 1
                    
                case 2:  //This is a salary employee
                    exists = false;
                    if(currentEmployees != 0){
                        for(int i = 0; i < currentEmployees; i++){
                            if(employees[i].getEmployeeNumber() == en){
                                exists = true;
                            }
                        }
                    }
                    
                    if(exists == true){
                        System.out.println("\nDuplicate Not Added\n");
                    }
                    else{
                        employees[currentEmployees] = new SalaryEmployee(fn, ln, m, g, en, ft, amount);
                        currentEmployees++;    
                    }
                    break; //end case 2
                    
                case 3:  //This is a commission employee
                    exists = false;
                    if(currentEmployees != 0){
                        for(int i = 0; i < currentEmployees; i++){
                            if(employees[i].getEmployeeNumber() == en){
                                exists = true;
                            }
                        }
                    }
                    
                    if(exists == true){
                        System.out.println("\nDuplicate Not Added\n");
                    }
                    else{
                        employees[currentEmployees] = new CommissionEmployee(fn, ln, m, g, en, ft, amount);
                        currentEmployees++;    
                    }
                    break; //end case 3
                    
                default: //This will happen if the employee type is invalid
                    System.out.println("\nInvalid Employee Type, None Added!\n");
                    break; //end default case
            }//end switch
        }//end if
    }//end method addEmployee
    
    /*  Method Name   : removeEmployee
     *  Parameters    : integer for index of employee to remove
     *  Return Values : None.
     *  Partners      : None.
     *  Description   : Finds and removes an employee at the given index.
     */
    public void removeEmployee(int index){
        if(index != -1){
            employees[index] = employees[currentEmployees - 1];
            --currentEmployees;
        }
        else{
            System.out.println("Employee not found!");
        }
    }
    
    /*  Method Name   : listAll
     *  Parameters    : None.
     *  Return Values : None.
     *  Partners      : None.
     *  Description   : Prints a formatted string for all employees.
     */
    public void listAll(){
        boolean exists = false;
        for(int i = 0; i < currentEmployees; i++){
            if(employees[i] != null){
                exists = true; 
                System.out.println(employees[i].toString());
            }
        }
        if(exists == false){
            System.out.println("No Employees.\n");
        }
    }
    
    /*  Method Name   : listHourly
     *  Parameters    : None.
     *  Return Values : None.
     *  Partners      : None.
     *  Description   : Prints a formatted string for each 
     *                  hourly employee.
     */
    public void listHourly(){
        for(int i = 0; i < currentEmployees; i++){
            if(employees[i] != null && employees[i] instanceof HourlyEmployee){
                System.out.println(employees[i].toString());
            }
        }
    }
    
    /*  Method Name   : listSalary
     *  Parameters    : None.
     *  Return Values : None.
     *  Partners      : None.
     *  Description   : Prints a formatted string for each 
     *                  salary employee.
     */
    public void listSalary(){
        for(int i = 0; i < currentEmployees; i++){
            if(employees[i] != null && employees[i] instanceof SalaryEmployee){
                System.out.println(employees[i].toString());
            }
        }
    }
    
    /*  Method Name   : listCommission
     *  Parameters    : None.
     *  Return Values : None.
     *  Partners      : None.
     *  Description   : Prints a formatted string for each 
     *                  commission employee.
     */
    public void listCommission(){
        for(int i = 0; i < currentEmployees; i++){
            if(employees[i] != null && employees[i] instanceof CommissionEmployee){
                System.out.println(employees[i].toString());
            }
        }
    }
    
    /*  Method Name   : resetWeek
     *  Parameters    : None.
     *  Return Values : None.
     *  Partners      : None.
     *  Description   : Resets the week for all employees. 
     */
    public void resetWeek(){
        for(int i = 0; i < currentEmployees; i++){
            if(employees[i] != null){
                employees[i].resetWeek();
            }
        }
    }
    
    /*  Method Name   : calculatePayout
     *  Parameters    : None.
     *  Return Values : double for total payout
     *  Partners      : None.
     *  Description   : Calculates total weekly pay 
     *                  of all employees 
     */
    public double calculatePayout(){
        double payout = 0;
        for(int i = 0; i < currentEmployees; i++){
            if(employees[i] != null){
                payout += employees[i].calculateWeeklyPay();
            }
        }
        return payout;
    }
    
    /*  Method Name   : getIndex
     *  Parameters    : integer for employee number
     *  Return Values : integer for matching array index
     *  Partners      : None.
     *  Description   : Finds and returns the index of an 
     *                  employee with the given employee number
     */
    public int getIndex(int empNum){
        int match = -1;
        for(int i = 0; i < currentEmployees; i++){
            if(employees[i] != null){
                if(employees[i].getEmployeeNumber() == empNum){
                    match = i;   
                }
            }
        }
        return match;
    }
    
    /*  Method Name   : annualRaises
     *  Parameters    : None.
     *  Return Values : None.
     *  Partners      : None.
     *  Description   : Applies an annual raise to each
     *                  employee. 
     */
    public void annualRaises(){
        for(int i = 0; i < currentEmployees; i++){
            employees[i].annualRaise();
        }
    }
    
    /*  Method Name   : holidayBonuses
     *  Parameters    : None
     *  Return Values : Double for total holiday bonuses.
     *  Partners      : None.
     *  Description   : calculates holiday bonus for all employees
     */
    public double holidayBonuses(){
        double totalBonus = 0;
        for(int i = 0; i < currentEmployees; i++){
            if(employees[i] != null){
                totalBonus += employees[i].holidayBonus();
            }
        }
        return totalBonus;
    }
    
    /*  Method Name   : increaseHours
     *  Parameters    : Double for amount to increase hours, 
     *                  index of employee
     *  Return Values : None.
     *  Partners      : None.
     *  Description   : Applies an increase to the number of hours for an 
     *                  employee at given index. 
     */
    public void increaseHours(int index, double amount){
        if(employees[index] instanceof HourlyEmployee){
            ((HourlyEmployee)employees[index]).increaseHours(amount);
        }
    }
    
    /*  Method Name   : increaseSales
     *  Parameters    : Double for amount to increase sales, 
     *                  index of employee
     *  Return Values : None.
     *  Partners      : None.
     *  Description   : Applies an increase to the number of sales for an 
     *                  employee at given index. 
     */
    public void increaseSales(int index, double amount){
        if(employees[index] instanceof CommissionEmployee){
            ((CommissionEmployee)employees[index]).increaseSales(amount);
        }
    }
    
    /*  Method Name   : findAllBySubstring
     *  Parameters    : String of the substring to be found
     *  Return Values : Array of employees whose names contain
     *                  the passed substring.
     *  Partners      : None.
     *  Description   : Checks all existing employees to see if thier 
     *                  name contains a passed substring by comparing
     *                  the hash values of the substring to each possible 
     *                  substrings hash value in the employees name.
     */
    public Employee[] findAllBySubstring(String find){ 
        Employee[] matchedEmployees = new Employee[currentEmployees]; 
        int counter = 0; 
        
        for(int i = 0; i < currentEmployees; i++){ 
            String thisString = employees[i].getFirstName().trim() + employees[i].getLastName().trim();
            
            if(RabinKarp(thisString, find) != -1){
                matchedEmployees[counter] = employees[i]; 
                counter++; 
            }
        }

        return matchedEmployees;
    }
    
    /*  Method Name   : RabinKarp
     *  Parameters    : String of the full name of the employee
     *                  String of the substring to be found
     *  Return Values : index of found employee via linearSearchRecursive
     *  Partners      : None.
     *  Description   : Processes the hash to be found and the hashes of each possible substring in the given 
     *                  string. Determines if passed substring exists in full string.
     */
    private int RabinKarp(String name, String find){
        int findHash = stringHash(find);
        int[] hashArray = null;
        int arrayLength = 0;
        String newFind = find;
        
        if (find.length() > name.length()){
            newFind = find.substring(0,name.length());
            System.out.println("\nInvalid substring length, shortening to: " + newFind + "\n");
        }
        
        arrayLength = (name.length() + 1) - newFind.length(); 
        hashArray = new int[arrayLength];

        
        RabinKarpHashes(name, hashArray, name.length() - newFind.length(), newFind.length()); 
        
        return linearSearchRecursive(hashArray, findHash, 0);
    }
      
    /*  Method Name   : RabinKarpHashes
     *  Parameters    : String of the full name of the employee
     *                  int[] of found hashes
     *  Return Values : int hash value of all substrings of size length
     *  Partners      : None.
     *  Description   : Finds the hash values of all substrings of size length 
     *                  in the String s, starting at index pos and down. 
     */
    private int RabinKarpHashes(String s, int[] hashes, int pos, int length){    
        if (pos == 0){
            hashes[pos] = stringHash(s.substring(0,length));
        }
        else{
            hashes[pos] = 26 * (RabinKarpHashes(s,hashes,pos-1,length) - (charNumericValue(s.charAt(pos-1)) * (int)Math.pow(26, length - 1))) 
                                + charNumericValue(s.charAt(pos + length -1));
        }
        return hashes[pos];
    }
    
    /*  Method Name   : linearSearchRecursive
     *  Parameters    : int[] of found hashes
     *                  int of the hash to find
     *                  int of the position being tested
     *  Return Values : int of the index of the found hash if found
     *                  -1 if hash is not found
     *  Partners      : None.
     *  Description   : Returns the position of key in the data array, or -1 if it is not present.  
     */    
    private int linearSearchRecursive(int[] data, int key, int pos){
        if (key == data[pos]){
            return pos;
        }
        if (pos + 1 < data.length){
            return linearSearchRecursive(data, key, pos + 1);
        }
        return -1;
    }
    
    /*  Method Name   : stringHash
     *  Parameters    : String representing the the whole string to be converted
     *  Return Values : Hash value of passed string
     *  Partners      : None.
     *  Description   : Returns the hash value of the passed string.  
     */  
    private int stringHash(String s){
        int hashValue = 0;
        for(int i = 0; i < s.length(); i++){
            hashValue += charNumericValue(s.charAt(i)) * Math.pow(26, s.length() - 1 - i);
        }
        return hashValue;
    }
    
    /*  Method Name   : charNumericValue
     *  Parameters    : char to find value of
     *  Return Values : int of the numeric value of the passed char
     *  Partners      : None.
     *  Description   : Returns a numerical value for a given character where
     *                  a = 0 and z = 25. Ignores case.  
     */  
    private int charNumericValue(char c){
        switch(c){
            case 'a': case 'A':
                return 0;
            case 'b': case 'B':
                return 1;
            case 'c': case 'C':
                return 2;
            case 'd': case 'D':
                return 3;
            case 'e': case 'E':
                return 4;
            case 'f': case 'F':
                return 5;
            case 'g': case 'G':
                return 6;
            case 'h': case 'H':
                return 7;
            case 'i': case 'I':
                return 8;
            case 'j': case 'J':
                return 9;
            case 'k': case 'K':
                return 10;
            case 'l': case 'L':
                return 11;
            case 'm': case 'M':
                return 12;
            case 'n': case 'N':
                return 13;
            case 'o': case 'O':
                return 14;
            case 'p': case 'P':
                return 15;
            case 'q': case 'Q':
                return 16;
            case 'r': case 'R':
                return 17;
            case 's': case 'S':
                return 18;
            case 't': case 'T':
                return 19;
            case 'u': case 'U':
                return 20;
            case 'v': case 'V':
                return 21;
            case 'w': case 'W':
                return 22;
            case 'x': case 'X':
                return 23;
            case 'y': case 'Y':
                return 24;
            case 'z': case 'Z':
                return 25;
            default:
                throw new InvalidCharacterException(c);
        }
    }
}