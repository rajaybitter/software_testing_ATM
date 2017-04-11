package atm.transaction;
import atm.ATM;
import atm.Session;
import atm.physical.*;
import banking.AccountInformation;
import banking.Card;
import banking.Message;
import banking.Money;
import banking.PhoneNumber;
import banking.Status;
import banking.Receipt;
//customer console
//made Number class

public class Mobile extends Transaction
{
    /** Constructor
     *
     *  @param atm the ATM used to communicate with customer
     *  @param session the session in which the transaction is being performed
     *  @param card the customer's card
     *  @param pin the PIN entered by the customer
     */
    public Mobile(ATM atm, Session session, Card card, int pin)
    {
        super(atm, session, card, pin);
    }
    
    /** Get specifics for the transaction from the customer
     *
     *  @return message to bank for initiating this transaction
     *  @exception CustomerConsole.Cancelled if customer cancelled this transaction
     */
    protected Message getSpecificsFromCustomer() throws CustomerConsole.Cancelled
    {
        from = atm.getCustomerConsole().readMenuChoice(
            "Account to transfer from",
            AccountInformation.ACCOUNT_NAMES);
        String amountMessage = "";
        boolean validAmount = false;
        boolean validNumber = false;
        
        while(!validNumber){
         to = atm.getCustomerConsole().readNumber("Phone number to top up");
         
         validNumber = to.isValid();
        
        }
        
        while(!validAmount){
            credits = atm.getCustomerConsole().readValue("Credits for top-up");
            amount = new Money(credits * 100);
                            
            validAmount = atm.getCashDispenser().checkCashOnHand(amount);

            if (! validAmount)
                amountMessage = "Insufficient cash available\n";
        }
        return new Message(Message.TRANSFER, 
                        card, pin, serialNumber, from, to.getFullNumber(), amount);

    }
    
    /** Complete an approved transaction
     *
     *  @return receipt to be printed for this transaction
     */
    protected Receipt completeTransaction()
    {
        return new Receipt(this.atm, this.card, this, this.balances) {
            {
                detailsPortion = new String[2];
                detailsPortion[0] = "TRANSFER FROM: " + 
                                    AccountInformation.ACCOUNT_ABBREVIATIONS[from] +
                                    " TO: " + 
                                    AccountInformation.ACCOUNT_ABBREVIATIONS[to.getFullNumber()] ;
                detailsPortion[1] = "AMOUNT: " + amount.toString();
            }
        };
    }
    
    /** Account to withdraw from
     */ 
    private int from;
    
    /**Phone nmber to transfer to
     */
    private PhoneNumber to;
    
    /** Amount of money to withdraw
     */
    private Money amount;
    
    /** Amount of credit to be bought
     */
    private int credits;
}