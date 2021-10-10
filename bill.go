package main

import (
	"fmt";
	"time";
	"strconv"
)

func main() {
	m := make(map[int]int)
	
	m[1] = 100
    m[2] = 200
	m[3] = 300
	
	fmt.Println("---Welcome---")
	fmt.Println("Menu Card")
	fmt.Println("1. Burger - Rs100")
	fmt.Println("2. Noodles - Rs100")
	fmt.Println("3. Briyani - Rs300\n")
	
	fmt.Println("Press y to place the order or Press n to quit")
	var status_check string
	fmt.Scanln(&status_check)
	
	if(status_check == "y"){
	    fmt.Println("==> Please enter just the serial number of the dish to place your order")
        fmt.Println("==> End your order  by pressing -1 anytime to get your  bill")
        
        var flag int
	    flag = -2
	    var total int
	    total = 0
	    
	    for flag!= -1{
			fmt.Scanln(&flag)
			if (flag != -1){
                    if (m[flag] != 0) {
                        total = total+m[flag];
                    } else{
                        fmt.Println("Enter a vaild dish number")
                }
			}
	    }
	    var available_coupon string
	    available_coupon = "WELCOME50"
	    
	    fmt.Println("Do you have any coupons? Enter y if you have or press n")
	    var coupon_status string
	    fmt.Scanln(&coupon_status)
	    
	    if(coupon_status == "y"){
	        fmt.Println("Yaay Awesome!! Please enter the coupon code")
	        var coupon_code_from_user string
	        fmt.Scanln(&coupon_code_from_user)
	        
	        if(coupon_code_from_user == available_coupon){
	            fmt.Println("Wowww! Congrats you have got buy 1 get 1 offer!! Go grab our your food from the counter and enjoy you meal!!\n")
	            fmt.Printf("Your bill total is Rs")
                fmt.Println(total)
	        }else{
	            fmt.Println("Sorry :/ your coupon is not valid...please enter another coupon code if you have...Else print n")
	            fmt.Scanln(&coupon_code_from_user)
	            
	            if(coupon_code_from_user != "n"){
	                if(coupon_code_from_user == available_coupon){
	                    fmt.Println("Wowww! Congrats you have got buy 1 get 1 offer!! Go grab our your food from the counter and enjoy you meal!!\n")
	                    fmt.Printf("Your bill total is Rs")
                        fmt.Println(total)
	                }
	            }
	            if(coupon_code_from_user == "n"){
	                fmt.Println("Cool we will look for other offers")
	                dt := time.Now()
	                var dd string
	                dd = dt.Format("01")
                    var number int
                    number, error := strconv.Atoi(dd)
            
                if(number>=10 && number%2 ==0 && error == nil){
                    fmt.Println("TODAYS OFFER!! You have got 10% off on your bill enjoy!!")
                    var discount_amount int
                    discount_amount = (total * 10)/100
                    fmt.Printf("Bill amount before discount Rs")
                    fmt.Println(total)
                    fmt.Printf("Saved amount Rs")
                    fmt.Println(discount_amount)
                    fmt.Printf("Total Amount after Discount Rs")
                    fmt.Println(total-discount_amount)
                }else{
                    fmt.Printf("Sorry we don't have any discounts today ,your bill is")
                    fmt.Println(total)
                }
	            }
	        }
	    }else{
	        fmt.Println("Cool we will look for other offers")
	        dt := time.Now()
	        var dd string
	        dd = dt.Format("01")
            var number int
            number, error := strconv.Atoi(dd)
            
            if(number>=10 && number%2 ==0 && error == nil){
                fmt.Println("TODAYS OFFER!! You have got 10% off on your bill enjoy!!")
                var discount_amount int
                discount_amount = (total * 10)/100
                fmt.Printf("Bill amount before discount Rs")
                fmt.Println(total)
                fmt.Printf("Saved amount Rs")
                fmt.Println(discount_amount)
                fmt.Printf("Total Amount after Discount Rs")
                fmt.Println(total-discount_amount)
            }else{
                fmt.Printf("Sorry we don't have any discounts today ,your bill is")
                fmt.Println(total)
            }
	    }
	}else{
	    fmt.Println("Thank you! Meet you next time!")
	}
	
	
	
}