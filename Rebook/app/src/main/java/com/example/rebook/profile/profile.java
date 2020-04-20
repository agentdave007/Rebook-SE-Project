package com.example.rebook.profile;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rebook.R;

import java.util.Calendar;

public class profile extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ImageView profilephoto;
    Spinner sex;
    TextView birthdate;
    Spinner relation;
    Button saveandnext;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profilephoto = (ImageView)findViewById(R.id.profilePic);
        sex=findViewById(R.id.gender);
        relation=findViewById(R.id.marriage);
        birthdate=findViewById(R.id.dob);
        saveandnext= findViewById(R.id.save);

        profilephoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(profile.this, "opening camera", Toast.LENGTH_SHORT).show();
                startActivityForResult(new Intent(getApplicationContext(),com.example.rebook.profile_pic.class),2);

            }
        });
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.genderchoose,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sex.setAdapter(adapter);
        sex.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> relationadapter= ArrayAdapter.createFromResource(this,R.array.relationship,android.R.layout.simple_spinner_item);
        relationadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        relation.setAdapter(relationadapter);
        relation.setOnItemSelectedListener(this);
        birthdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year= cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day= cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog= new DatePickerDialog(
                        profile.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,year,month,day
                );
                dialog.getDatePicker().setMaxDate(System.currentTimeMillis());
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month=month+1;
                String date= month + "/" +day+ "/"+ year;
                birthdate.setText(date);
            }
        };
        Toast.makeText(profile.this, "Welcome Prince", Toast.LENGTH_SHORT).show();
    }

    public void savenext(View view){
        startActivity(new Intent(getApplicationContext(),com.example.rebook.launch.MainActivity.class));
        finish();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if(requestCode==2)
        {
            String image_path=data.getStringExtra("user_profile");
            Uri fileUri = Uri.parse(image_path);
            profilephoto.setImageURI(fileUri);
            Toast.makeText(getApplicationContext()," "+ image_path,Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(parent.getId()==R.id.gender){
            String value= parent.getItemAtPosition(position).toString();
          //  Toast.makeText(getApplicationContext(),value+"okay",Toast.LENGTH_LONG).show();
        }

        if(parent.getId()==R.id.marriage){
            String value= parent.getItemAtPosition(position).toString();
            Toast.makeText(getApplicationContext(),"Happily "+value,Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
