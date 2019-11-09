package com.example.test;

import android.content.Context;
import android.util.Patterns;
import android.widget.EditText;

import java.util.regex.Pattern;

public class Validation {
    private Context c;
    public final int PASSWORD_MIN_SIZE=5;
    public final int PASSWORD_MAX_SIZE=20;
    public final int NAME_MIN_SIZE = 2;
    public final int NAME_MAX_SIZE = 30;
    public final int PHONE_SIZE = 10;
    public final int ADDRESS_MIN_SIZE = 5;
    public final int ADDRESS_MAX_SIZE = 100;
    public final String TAG = "VALIDATION";

    public Validation(Context c){this.c=c;}

//  Verify the email inside the EditText and set the error if the email is not ok, or blank

    private boolean isValidEmail(EditText etEmail){
        String email = etEmail.getText().toString().trim();
        boolean result=false;

        if(email.length()==0){
            etEmail.setError("This field is required");
        }
        else {
            Pattern emailPattern = Patterns.EMAIL_ADDRESS;
            if (!emailPattern.matcher(email).matches()){
                etEmail.setError("This field is invalid");
            }
            else{
                etEmail.setError(null);
                result=true;
            }

        }
        return result;
    }



}
