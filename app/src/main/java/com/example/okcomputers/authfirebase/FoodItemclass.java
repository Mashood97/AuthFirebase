package com.example.okcomputers.authfirebase;

/**
 * Created by OK Computers on 8/3/2018.
 */

public class FoodItemclass {

    private String Email;
    private String password;

    public FoodItemclass()
    {}
    public FoodItemclass(String email, String pasw)
    {
        Email = email;
        password =pasw;
    }

    public String getmItemName() {
        return Email;
    }

    public void setmItemName(String mItemName) {
        this.Email = mItemName;
    }

    public String getmItemPrice() {
        return password;
    }

    public void setmItemPrice(String mItemPrice) {
        this.password = mItemPrice;
    }
}
