package com.ptlearnpoint.www.problem_2_piash_sarker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnAddEmployee(View view) {

        Intent intent = new Intent(MainActivity.this, AddEmployeeActivity.class);
        startActivity(intent);
    }

    public void btnEmployeeList(View view) {

        Intent intent = new Intent(MainActivity.this, ListEmployeeActivity.class);
        startActivity(intent);
    }
}
