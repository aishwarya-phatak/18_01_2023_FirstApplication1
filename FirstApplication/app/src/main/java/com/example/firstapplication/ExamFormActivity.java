package com.example.firstapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class ExamFormActivity extends Activity {

    Button btnSubmit;
    TextView txtPRNumber,txtFirstName, txtLastName,txtSubject1, txtSubject2, txtSubject3, txtExamFees;
    ImageView imgStudentPhoto;
    RadioButton rdBtnMale, rdBtnFemale;

    private int currentIndex = 0;
    private int [] natureImages = {
            R.drawable.nature,
            R.drawable.nature_image2,
            R.drawable.nature_image3,
            R.drawable.nature_image4
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_exam_form);
        initializeViews();
        initializeListeners();
        imgStudentPhoto.setImageResource(R.drawable.nature);
    }

    private void initializeViews() {
        txtPRNumber = findViewById(R.id.txtPRNumber);
        imgStudentPhoto = findViewById(R.id.imgStudentPhoto);
        txtFirstName = findViewById(R.id.txtFirstName);
        txtLastName = findViewById(R.id.txtLastName);
        txtSubject1 = findViewById(R.id.txtSubject1);
        txtSubject2 = findViewById(R.id.txtSubject2);
        txtSubject3 = findViewById(R.id.txtSubject3);

        rdBtnMale = findViewById(R.id.rdBtnMale);
        rdBtnFemale = findViewById(R.id.rdBtnFemale);

        txtExamFees = findViewById(R.id.txtExamFees);

        btnSubmit = findViewById(R.id.btnSubmit);

    }

    private void initializeListeners(){
        btnSubmit.setOnClickListener(new BtnSubmitClickListener());
        imgStudentPhoto.setOnClickListener(new ImgClickListener());
    }

    class ImgClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            currentIndex = ++currentIndex % natureImages.length;
            imgStudentPhoto.setImageResource(natureImages[currentIndex]);
        }
    }

    class BtnSubmitClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            txtFirstName.setText(txtFirstName.getText().toString() + " " + txtLastName.getText().toString());
            Toast.makeText(ExamFormActivity.this, "Exam Form Submitted!", Toast.LENGTH_LONG).show();
            Log.e("t","BtnSubmit Clicked");
        }
    }
}
