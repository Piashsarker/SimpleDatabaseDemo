package com.ptlearnpoint.www.problem_2_piash_sarker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class AddEmployeeActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {

    String country ="";
    String id ;

    EditText lastName , firstName, phone ;
    Button update , submit ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee); // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        update = (Button) findViewById(R.id.btnUpdate);
         submit = (Button) findViewById(R.id.btn_add);

        lastName = (EditText) findViewById(R.id.last_name);
        firstName = (EditText) findViewById(R.id.first_name);
        phone = (EditText) findViewById(R.id.phone);
        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        ArrayList<String> categories = new ArrayList<>();
        categories.add("BD");
        categories.add("India");
        categories.add("Japan");
        categories.add("Nepal");
        categories.add("USA");
        categories.add("Mexico");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        Intent intent = getIntent();
        if(getIntent()!=null){
            update.setVisibility(View.VISIBLE);
            id = intent.getStringExtra("id");
            firstName.setText( intent.getStringExtra("first_name"));
            lastName.setText( intent.getStringExtra("last_name"));
            phone.setText( intent.getStringExtra("phone"));
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
         country = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void btnAdd(View view) {
        DatabaseHelper db = new DatabaseHelper(getApplicationContext());
        Employee employee = new Employee(firstName.getText().toString(),lastName.getText().toString(),phone.getText().toString(),country);
        db.addEmployee(employee);
        Toast.makeText(AddEmployeeActivity.this, "Data Added To Database ", Toast.LENGTH_SHORT).show();
    }

    public void btnUpdate(View view) {
        DatabaseHelper db = new DatabaseHelper(getApplicationContext());
        Employee employee = new Employee(id , firstName.getText().toString(),lastName.getText().toString(),phone.getText().toString(),country);
        db.updateEmployee(employee);
        Toast.makeText(AddEmployeeActivity.this, "Update Added To Database ", Toast.LENGTH_SHORT).show();

    }
}