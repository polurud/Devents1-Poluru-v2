package com.dartmouth.kd.devents;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class SignUpActivity extends AppCompatActivity implements Button.OnClickListener{
    private EditText passwordEditText;
    private EditText emailEditText;
    private Button signUpButton;
    private FirebaseAuth firebaseAuth;
    private Task<AuthResult> task;
    private Button  Button_cancel, Button_save;

    private FirebaseUser firebaseUser;
    private DatabaseReference databaseReference;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        passwordEditText = (EditText)findViewById(R.id.passwordField);
        emailEditText = (EditText)findViewById(R.id.emailField);
        signUpButton = (Button)findViewById(R.id.signupButton);
        signUpButton.setOnClickListener(this);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void onClick(View view){
        firebaseAuth = FirebaseAuth.getInstance();
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        if(email.isEmpty() || password.isEmpty())
            Utils.showDialog(this, "Error!",
                    "Please make sure you enter an email address and password");
        else{
            task = firebaseAuth.createUserWithEmailAndPassword(email, password);
            task.addOnCompleteListener(new AuthOnCompleteListener(this));


             //create user profile

            setContentView(R.layout.activity_profile);


            Log.d("poluru", "onClick: ");
            Button_save = (Button) findViewById(R.id.bSave);
            Button_save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    saveProfile();
                    Toast.makeText(getApplicationContext(),
                            getString(R.string.ui_profile_toast_save_text),
                            Toast.LENGTH_SHORT).show();
                    // Close the activity
                    finish();
                }
            });
            Button_cancel = (Button) findViewById(R.id.bCancel);
            Button_cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onCancelClick();
                }
            });

            loadProfile();

        }



        }
    public void onCancelClick(){
        finish();
    }

    public void saveProfile() {
        String key, str2;
        int val2;
        boolean bol;

        key = getString(R.string.preference_name);
        SharedPreferences prefs = getSharedPreferences(key, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        // Write screen contents into corresponding editor fields.
        key = getString(R.string.enter_user_name1);
        str2 = ((EditText) findViewById(R.id.userName)).getText().toString();
        editor.putString(key, str2);


        key = getString(R.string.ui_profile_gender);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radiogroup_Gender);
        val2 = radioGroup.indexOfChild(findViewById(radioGroup
                .getCheckedRadioButtonId()));
        editor.putInt(key, val2);


        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        val2 = spinner.getSelectedItemPosition();
        key = spinner.getSelectedItem().toString();
        editor.putInt(key, val2);


        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        key = spinner2.getSelectedItem().toString();
        val2 = spinner.getSelectedItemPosition();
        editor.putInt(key, val2);

        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        key = spinner3.getSelectedItem().toString();
        val2 = spinner.getSelectedItemPosition();
        editor.putInt(key, val2);

        Spinner spinner4 = (Spinner) findViewById(R.id.spinner4);
        key = spinner4.getSelectedItem().toString();
        val2 = spinner.getSelectedItemPosition();
        editor.putInt(key, val2);

        CheckBox checkBox6 = (CheckBox)  findViewById(R.id.checkBox6);
        bol = checkBox6.isChecked();
        if (bol == true)
            key = checkBox6.toString();
            editor.putString(key, key);

        CheckBox checkBox2 = (CheckBox)  findViewById(R.id.checkBox2);
        bol = checkBox2.isChecked();
        if (bol == true)
            key = checkBox2.toString();
        editor.putString(key, key);


        CheckBox checkBox5 = (CheckBox)  findViewById(R.id.checkBox5);
        bol = checkBox5.isChecked();
        if (bol == true)
            key = checkBox5.toString();
        editor.putString(key, key);


        CheckBox checkBox7 = (CheckBox)  findViewById(R.id.checkBox7);
        bol = checkBox7.isChecked();
        if (bol == true)
            key = checkBox7.toString();
        editor.putString(key, key);


        CheckBox checkBox3 = (CheckBox)  findViewById(R.id.checkBox3);
        bol = checkBox3.isChecked();
        if (bol == true)
            key = checkBox3.toString();
        editor.putString(key, key);

        editor.apply();

    }


    public void loadProfile() {
        String key, str;
        int val;
        boolean bol;



        key = getString(R.string.preference_name);
        SharedPreferences prefs = getSharedPreferences(key, MODE_PRIVATE);

        key = getString(R.string.ui_profile_name);
        str = prefs.getString(key, "");
        ((EditText) findViewById(R.id.userName)).setText(str);


        key = getString(R.string.ui_profile_gender);
        val = prefs.getInt(key, -1);

        if (val >= 0) {
            RadioButton radioBtn = (RadioButton) ((RadioGroup) findViewById(R.id.radiogroup_Gender))
                    .getChildAt(val);
            radioBtn.setChecked(true);
        }

        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        key = spinner.getSelectedItem().toString();
        val = spinner.getSelectedItemPosition();
        if (val>=1) {

            Spinner spinner_s  = (Spinner) ((Spinner) findViewById(R.id.spinner)).getChildAt(val);
            spinner_s.setActivated(true);
        }


    }




}



