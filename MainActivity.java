package com.example.emow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.icu.text.RelativeDateTimeFormatter;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView signupTxt;
        signupTxt=findViewById(R.id.signup_txt);
        //creating a string variable with a text obj to assign it to our text view.
        String text="Or if you don't have an account,Signup here";
        //to change particular word (pass the string obj
        SpannableString ss=new SpannableString(text);

        //clickable span
        ClickableSpan signUpText= new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent HomeIntent=new Intent().setClass(MainActivity.this,Signup.class);
                startActivity(HomeIntent);

            }
//ctrl+o update draw state to change the color of the word ds.setColor.


            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.rgb(194,24,91));
                ds.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));

            }
        };
        //make the sigup word clickable (ob in clickaple span ,start index,last index
        ss.setSpan(signUpText,32,43, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

//pass our ss var to the text view obj so it can work
        signupTxt.setText(ss);
        //to clickable work
        signupTxt.setMovementMethod(LinkMovementMethod.getInstance());


        ImageButton skipBtn;

        skipBtn=findViewById(R.id.skip_btn);
    skipBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent HomeIntent=new Intent().setClass(MainActivity.this,Home.class);
            startActivity(HomeIntent);


        }
    });
    }
}