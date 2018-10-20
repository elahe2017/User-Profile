package com.example.elihsm.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.example.elihsm.test.R;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    private View fullNameContainer;
    private EditText firstNameEt;
    private EditText lastNameEt;
    private Button editProfileBtn;
    private TextView fullNameTextView;
    private CheckBox androidCheckBox;
    private CheckBox cssCheckBox;
    private CheckBox deepLearningCheckBox;
    private RadioGroup cityRadioGroup;
    private Button saveInformationBtn;
    private boolean isInEditMode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstNameEt=findViewById(R.id.et_profile_firsName);
        fullNameContainer=findViewById(R.id.linearLayout_profile_fullNameContainer);
        fullNameTextView=findViewById(R.id.tv_profile_fullName);
        lastNameEt=findViewById(R.id.et_profile_lastName);
        editProfileBtn=findViewById(R.id.btn_profile_editProfile);


        editProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isInEditMode){
                    editProfileBtn.setText(getString(R.string.profile_editProfile));
                    fullNameContainer.setVisibility(View.GONE);

                    fullNameTextView.setText(firstNameEt.getText()+
                            "" +
                            lastNameEt.getText());
                }
                else {
                    editProfileBtn.setText(getString(R.string.profile_done));
                    fullNameContainer.setVisibility(view.VISIBLE);
                }
                isInEditMode=!isInEditMode;
            }
        });
        androidCheckBox=findViewById(R.id.checkbox_profile_Android);
        androidCheckBox.setOnCheckedChangeListener(this);
        cssCheckBox=findViewById(R.id.checkbox_profile_css);
        cssCheckBox.setOnCheckedChangeListener(this);
        deepLearningCheckBox=findViewById(R.id.checkbox_profile_deep);
        deepLearningCheckBox.setOnCheckedChangeListener(this);

        cityRadioGroup=findViewById(R.id.radioGroup_profile);
        cityRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                Toast.makeText(MainActivity.this,getString(R.string.profile_isCheckedMessage,
                        ((RadioButton) findViewById(checkedId)).getText().toString()),Toast.LENGTH_LONG).show();


            }
        });
        saveInformationBtn=findViewById(R.id.button_profile_saveInformation);
        saveInformationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
    private static final String TAG="MainActivity";
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if (isChecked){
            Toast.makeText(this,getString(R.string.profile_isCheckedMessage,compoundButton.getText()),
                    Toast.LENGTH_LONG).show();

        }

    }
}
