package com.example.firstapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ExamFormActivity extends Activity {

    Button btnSubmit;
    TextView txtPRNumber,txtFirstName, txtLastName,txtSubject1, txtSubject2, txtSubject3, txtExamFees;
    ImageView imgStudentPhoto;
    RadioButton rdBtnMale, rdBtnFemale;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_exam_form);

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
}
