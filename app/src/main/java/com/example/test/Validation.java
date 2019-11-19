package com.example.test;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.util.regex.Pattern;
// This is upgraded version of validation class, Adil didn't implemented this class, it is just to check how it is going to work
/*
public class Validation {
    private Context c;
    public Validation(Context c){this.c=c;}

//  Verify the email inside the EditText and set the error if the email is not ok, or blank

    public boolean isInputEditTextFilled(TextInputEditText textInputEditText, TextInputLayout textInputLayout, String message){
        String value= textInputEditText.getText().toString().trim();
        if (value.isEmpty()){
            textInputLayout.setError(message);
            hideKeyboardFrom(textInputEditText);
            return false;
        }else {
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }

    public boolean isInputEditTextEmail(TextInputEditText textInputEditText, TextInputLayout textInputLayout, String message){
            String value=textInputEditText.getText().toString().trim();
            if (value.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(value).matches()){
                textInputLayout.setError(message);
                hideKeyboardFrom(textInputEditText);
                return false;
            }else {
                textInputLayout.setErrorEnabled(false);
            }
            return true;
    }

    public boolean isEditTextMatches(TextInputEditText textInputEditText,TextInputEditText textInputEditText2, TextInputLayout textInputLayout, String message){
            String value1=textInputEditText.getText().toString().trim();
            String value2=textInputEditText2.getText().toString().trim();
            if (!value1.contentEquals(value2)){
                textInputLayout.setError(message);
                hideKeyboardFrom(textInputEditText);
                return false;
            }else {
                textInputLayout.setErrorEnabled(false);
            }
            return true;

    }

    private void hideKeyboardFrom(View view){
        InputMethodManager imm=(InputMethodManager) c.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

    }
}
*/