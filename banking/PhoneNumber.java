package banking;


/**
 * Write a description of class PhoneNumber here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PhoneNumber
{
    // instance variables - replace the example below with your own
    private int areaCode;
    private long number;

    /**
     * Constructor for objects of class PhoneNumber
     */
    public PhoneNumber()
    {
        areaCode = 0;
        number = 0;
    }
    
    public PhoneNumber(int areaCode, int number){
        this.areaCode = areaCode;
        this.number = number;
    }

    public int getAreaCode(){
        return areaCode;
    }
    
    public long getNumber(){
        return number;
    }
    
    public long getFullNumber(){
        return Long.parseLong( String.valueOf(areaCode) + String.valueOf(number));
    }
    
    public boolean isValid(){
        String fullNumber = String.valueOf(areaCode) + String.valueOf(number);
        if( fullNumber.length() == 10 ){
            return true;
        }else{
            return false;
        }
    }
}   
