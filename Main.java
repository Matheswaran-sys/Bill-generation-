import java.util.*;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;  
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer,Integer> map =new HashMap<>();
        map.put(1,200);
        map.put(2,300);
        map.put(3,100);
        map.put(4,100);
        
        System.out.println("----Welcome the Sathyam Cinemas! Enjoy your Snacks!-----\n");
        System.out.println("Menu Card");
        System.out.println("1. Chicken Briyani -- Rs200");
        System.out.println("2. Mutton Briyani -- Rs300");
        System.out.println("3. Orange Juice -- Rs100");
        System.out.println("4. Grape Juice -- Rs100\n");
        
        System.out.println("Press Y to place the order or Press N to quit");
        String status_check = sc.nextLine().toLowerCase();
        
        if(status_check.equals("y")){
            System.out.println("==> Please enter just the serial number of the dish to place your order");
            System.out.println("==> End your order  by pressing 0 anytime to get your  bill");
            int flag = -1;
            int total = 0;
            
            while(flag != 0){
                flag = sc.nextInt();
                if (flag != 0){
                    if (map.get(flag) !=null) {
                        int dish_cost = map.get(flag);
                        total = total+dish_cost;
                    }
                    else{
                        System.out.println("Enter a vaild dish number");
                    }
                }
            }
            // System.out.println(total);
            Discount_Check obj =new Discount_Check(total);
            obj.final_bill_coupon_check();
        }
        
        else{
            System.out.println("Thank you! Meet you next time!");
        }
    }
}

class Discount_Check{
    Scanner sc =new Scanner(System.in);
    int total_bef_dis;
    String[] coupon_arr = {"WELCOME50", "HELLO10", "ENJOY50"};
    Discount_Check(int total){
        this.total_bef_dis = total;
    }
    
    void final_bill_coupon_check(){
        System.out.println("Do you have any coupons? Enter y if you have or press n");
        String coupon_check = sc.nextLine().toLowerCase();
        if(coupon_check.equals("y")){
            System.out.println("Yaay Awesome!! Please enter the coupon code");
            String coupon_code = sc.nextLine().toUpperCase();
            boolean coupon_status = Arrays.asList(coupon_arr).contains(coupon_code);
            if(coupon_status){
                System.out.println("Wowww! Congrats you have got buy 1 get 1 offer!! Go grab our your food from the counter and enjoy you meal!!");
            }
            else{
                System.out.println("Sorry :/ your coupon is not valid...please enter another coupon code if you have...Else print n");
                coupon_code = sc.nextLine().toLowerCase();

                if(!coupon_code.equals("n")){
                     coupon_status =Arrays.asList(coupon_code).contains(coupon_code);
                if(coupon_status){
                System.out.println("Wowww! Congrats you have got buy 1 get 1 offer!! Go grab our your food from the counter and enjoy you meal!!");
                }
                }
                if(coupon_code.equals("n")){
                    System.out.println("Cool we will check for other offers");
                    discount_check();
                }
                else{
                System.out.println("Not valid, Try again next time");
                System.exit(0);
            }
            }
        }
        else{
            System.out.println("Cool we will check for other offers\n");
            discount_check();
        }
    }
    
    void discount_check(){
        Date date = new Date();
        String dateFormatString = "d";
        DateFormat dateFormat = new SimpleDateFormat(dateFormatString);
        String currentDate = dateFormat.format(date);
        int dd=Integer.parseInt(currentDate); 
        if(dd >=10 && dd%2 == 0){
            even_day_discount();
        }
        else{
            System.out.println("Sorry you don't have any discount ,your bill is"+ total_bef_dis);
        }
    }

    void even_day_discount(){
        int discount_amount = (total_bef_dis *10)/100;
        System.out.println("Bill amount before discount Rs" +total_bef_dis);
        System.out.println("Yehhh! Todays offer...You have Saved Rs" +discount_amount+ "\n");
        int total_after_dis = total_bef_dis-discount_amount;
        System.out.println("Total Amount "+total_after_dis+"\n");
        System.out.println("Thank you! collect your food from the counter");
    }
}