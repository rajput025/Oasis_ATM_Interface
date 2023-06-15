import java.util.Scanner;

class BankAccount {
    String name;
    String userName;
    String password;
    String AccountNO;
    float balance = 100000f;
    int transcation = 0;
    String transcationHistory = "" ;

///    USER REGISTRATION
    public void register(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter your name - ");
        this.name = sc.nextLine();
        System.out.println("\nEnter your username - ");
        this.userName = sc.nextLine();
        System.out.println("\nEnter your password - ");
        this.password = sc.nextLine();
        System.out.println("\nEnter your Account Number - ");
        this.AccountNO=sc.nextLine();
        System.out.println("\nRegistration completed.. kindly login");

    }
    /// USER Login
    public boolean login(){
        boolean isLogin =false;
        Scanner sc = new Scanner(System.in);
        while(!isLogin){
            System.out.println("\nEnter your Username - ");
            String Username = sc.nextLine();
            if(Username.equals(userName)){
                while(!isLogin){
                    System.out.println("\nEnter your Password - ");
                    String password = sc.nextLine();
                    if(password.equals(password)){
                        System.out.println("\nLogin Successfull");
                        isLogin = true;
                    }
                    else {
                        System.out.println("\nIncorrect Password");
                    }
                }
            }
            else {
                System.out.println("\nUsername not Found");
            }
        }

        return isLogin;
    }
    ///Withdrawal Money
    public void withdraw(){
        System.out.println("\n Enter amount to withdraw -");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try {
            if(balance >= amount){
                transcation++;
                balance -= amount;
                System.out.println("\nwithdraw Successfully");
                String str = amount + "RS Withdraw \n";
                transcationHistory = transcationHistory.concat(str);
            }
            else
                System.out.println("\nInsufficent Balance");
        }
        catch(Exception e){
        }
    }
    //Deposit
    public void deposit(){
        System.out.println("\nEnter amount to deposit -");
        Scanner sc= new Scanner(System.in);
        float amount = sc.nextFloat();
        try {
            if(amount <=100000f ){
                transcation++;
                balance += amount;
                System.out.println("\nSuccessfully Deposited");
                String str = amount + "RS Deposited \n";
                transcationHistory = transcationHistory.concat(str);
            }
            else
                System.out.println("\nSorry ... limit is 100000.00");
        }
        catch (Exception e){
        }
    }
    //Transfer
    public void transfer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Recepient's Name -");
        String recepient = sc.nextLine();
        System.out.println("/nEnter amount to transfer -");
        float amount = sc.nextFloat();
        try {
            if(balance >= amount){
                if(amount <= 50000f){
                    transcation++;
                    balance -= amount;
                    System.out.println("\nSuccessfully transfered to " + recepient );
                    String str = amount + "RS transfered to "+recepient+"\n";
                    transcationHistory = transcationHistory.concat(str);
                }
                else{
                    System.out.println("\nSorry ... limit is 50000.00");
                }
            }
            else
                System.out.println("\n Insufficeint Balance");
        }
        catch (Exception e){
        }
    }
    //Check Balance
    public void checkBalance() {

        System.out.println("\n"+balance + " Rs ");
    }
    public void TransHistory(){
        if(transcation == 0 ){
            System.out.println("\n Empty");
        }
        else{
            System.out.println("\n"+transcationHistory);
        }
    }
}
// Interface of ATM
public class The_ATM_Interface {

    public static int takeIntegerInput(int limit) {
        int input = 0;
        boolean flag = false;
        while (!flag) {
            try {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;
                if (flag && input > limit || input < 1) {
                    System.out.println("Choose the number between 1 to " + limit);
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("Enter only integer value");
                flag = false;
            }
        }
        return input;
    }

    public static void main(String[] args) {
        // write your code here
        System.out.println("\n*******WELCOME To The HDFC ATM SYSTEM*******");
        System.out.println("1.Register \n2.Exit");
        System.out.println("Enter Your  choice -");
        int choice = takeIntegerInput(2);

        if (choice == 1) {
            BankAccount b = new BankAccount();
            b.register();
            while (true) {
                System.out.println("\n1.Login \n2.Exit");
                System.out.println("Enter your Choice - ");
                int ch = takeIntegerInput(2);
                if (ch == 1) {
                    if (b.login()) {
                        System.out.println("\n\n**********WLECOME BACK " + b.name + "**********");
                        boolean isFinished = false;
                        while (!isFinished) {
                            System.out.println("\n1.Withdrawal \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
                            System.out.println("\nEnter your Choice - ");
                            int c = takeIntegerInput(6);
                            switch (c) {
                                case 1:
                                    b.withdraw();
                                    break;
                                case 2:
                                    b.deposit();
                                    break;
                                case 3:
                                    b.transfer();
                                    break;
                                case 4:
                                    b.checkBalance();
                                    break;
                                case 5:
                                    b.TransHistory();
                                    break;
                                case 6:
                                    isFinished = true;
                                    break;
                                default:
                                    System.out.println("/nWrong choice!");
                            }
                        }
                    }
                } else {
                    System.exit(0);
                }
            }
        } else {
            System.exit(0);
        }
    }
}
