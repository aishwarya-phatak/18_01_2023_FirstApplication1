package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnSubmit;
    EditText edtUsername;
    ImageView studentImage;
    TextView welcomeTextView,studentName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout mainContainer = new LinearLayout(this);
        mainContainer.setOrientation(LinearLayout.VERTICAL);
        mainContainer.setPadding(20, 20, 20, 20);
        mainContainer.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);

        ViewGroup.LayoutParams layoutParamsForMainContainer = new
                ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );

        mainContainer.setLayoutParams(layoutParamsForMainContainer);

        welcomeTextView = new TextView(this);
        welcomeTextView.setPadding(10, 10, 10, 10);
        welcomeTextView.setTextColor(Color.MAGENTA);
        welcomeTextView.setTextSize(24.0F);
        welcomeTextView.setText("Welcome To Bitcode");
        welcomeTextView.setBackgroundColor(Color.GRAY);

        ViewGroup.LayoutParams layoutParamsForViews = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        welcomeTextView.setLayoutParams(layoutParamsForViews);

        mainContainer.addView(welcomeTextView);


        studentName = new TextView(this);
        studentName.setText("Gauri");
        studentName.setTextSize(16.0F);
        studentName.setTextColor(Color.BLUE);
        studentName.setBackgroundColor(Color.GRAY);
        studentName.setPadding(10, 10, 10, 10);

        studentName.setLayoutParams(layoutParamsForViews);

        mainContainer.addView(studentName);

        edtUsername = new EditText(this);
        edtUsername.setHint("Enter edtUsername");

        edtUsername.setLayoutParams(layoutParamsForViews);

        mainContainer.addView(edtUsername);


        ViewGroup.LayoutParams layoutParamsForImageView = new ViewGroup.LayoutParams(
                100,
                100
        );

        studentImage = new ImageView(this);
        studentImage.setImageResource(R.drawable.ic_launcher_background);
        studentImage.setLayoutParams(layoutParamsForImageView);

        mainContainer.addView(studentImage);

        btnSubmit = new Button(this);
        btnSubmit.setText("Submit");
        btnSubmit.setBackgroundColor(Color.BLUE);
        btnSubmit.setTextColor(Color.WHITE);
        btnSubmit.setTextSize(16.0F);
        btnSubmit.setLayoutParams(layoutParamsForViews);

        mainContainer.addView(btnSubmit);

        setContentView(mainContainer);


        //way 1 - passing an instance of such class that implements View.OnClickListener
        //btnSubmit.setOnClickListener(new BtnSubmitClickListener());

        //way 2 - creating listener reference
        /*View.OnClickListener listener = new MyOnCLickListener();
        btnSubmit.setOnClickListener(listener);
         */

        //way 3 - implementing listener at class level
        //btnSubmit.setOnClickListener(this);

        //way 4 - passing an object of anonymous class
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtUsername.getText().toString().equals("Bitcode")){
                    welcomeTextView.setText("Welcome"+edtUsername.getText().toString());
                }
            }
        });

    }

    //way 3
    @Override
    public void onClick(View view) {

            if (edtUsername.getText().toString().equals("Gauri")) {
                if(view == btnSubmit){
                welcomeTextView.setText("Welcome " + edtUsername.getText().toString());
                Toast.makeText(this, "Gauri's Form Submit", Toast.LENGTH_SHORT).show();
            }
        }
    }

    //way 2
    class MyOnCLickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "Form Submitted", Toast.LENGTH_SHORT).show();
            Log.e("tag","Form Submitted");
        }
    }


    //way 1
    class BtnSubmitClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {

            Toast.makeText(MainActivity.this, "Form Submitted Successfully", Toast.LENGTH_SHORT).show();
            Log.e("tag","Form Submitted Successfully");
        }
    }

}