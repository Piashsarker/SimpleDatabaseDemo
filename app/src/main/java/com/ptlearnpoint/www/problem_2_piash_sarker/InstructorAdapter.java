package com.ptlearnpoint.www.problem_2_piash_sarker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by pt on 5/4/16.
 */
public class InstructorAdapter extends RecyclerView.Adapter<InstructorAdapter.MyViewHolder> {

    private List<Employee> instructorList;

    private Context context ;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, email, salary,dept ,id;
        public Button edit;
        RelativeLayout row ;


        public MyViewHolder(View view) {
            super(view);
            row = (RelativeLayout) view.findViewById(R.id.row);
            id = (TextView) view.findViewById(R.id.id);
            name = (TextView) view.findViewById(R.id.name);
            email = (TextView) view.findViewById(R.id.email);
            salary = (TextView) view.findViewById(R.id.salary);
            dept = (TextView) view.findViewById(R.id.dept);

            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context , AddEmployeeActivity.class);
                    intent.putExtra("id",instructorList.get(getAdapterPosition()).getId());
                    intent.putExtra("first_name",instructorList.get(getAdapterPosition()).getFirstName());
                    intent.putExtra("last_name",instructorList.get(getAdapterPosition()).getLastName());
                    intent.putExtra("phone",instructorList.get(getAdapterPosition()).getPhone());
                    intent.putExtra("country",instructorList.get(getAdapterPosition()).getCountry());
                    context.startActivity(intent);
                }
            });

            row.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    new AlertDialog.Builder(context)
                            .setTitle("Delete entry")
                            .setMessage("Are you sure you want to delete this entry?")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // continue with delete
                                    DatabaseHelper databaseHelper = new DatabaseHelper(context);
                                    databaseHelper.deleteContact(instructorList.get(getAdapterPosition()));
                                    instructorList.remove(getAdapterPosition());
                                    notifyDataSetChanged();

                                }
                            })
                            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // do nothing
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();



                    return false;
                }
            });


        }
    }


    public InstructorAdapter(Context context , List<Employee> instructorList) {
        this.instructorList = instructorList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_of_instructor, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Employee instructor = instructorList.get(position);
        holder.id.setText(instructor.getId());
        holder.name.setText(instructor.getFirstName());
        holder.email.setText(instructor.getLastName());
        holder.dept.setText(instructor.getPhone());
        holder.salary.setText(instructor.getCountry());

    }


    @Override
    public int getItemCount() {
        return instructorList.size();
    }
}