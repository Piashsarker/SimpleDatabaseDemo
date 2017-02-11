package com.ptlearnpoint.www.problem_2_piash_sarker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListEmployeeActivity extends AppCompatActivity {

    private List<Employee> instructorList =new ArrayList();
    private InstructorAdapter adapter ;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_employee);

        DatabaseHelper db = new DatabaseHelper(getApplicationContext());
        instructorList = db.getAllEmployee();
        adapter = new InstructorAdapter(ListEmployeeActivity.this, instructorList);
        recyclerView = (RecyclerView)findViewById(R.id.instructor_list);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
