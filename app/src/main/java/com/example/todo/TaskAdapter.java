package com.example.todo;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.CustomViewHolder> {
    DatabaseHelper dBHelper;
    Context mContext;
    List<Task> taskslist;

    public TaskAdapter(Context context, List<Task> taskslist) {
        this.taskslist = taskslist;
        this.mContext = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_item, parent, false);
        CustomViewHolder viewHolder = new CustomViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        final Task taskData = taskslist.get(position);
        holder.txtTask.setText(taskData.getmTask());
        holder.btRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dBHelper = new DatabaseHelper(mContext);
                dBHelper.deleteTask(taskData);
            }
        });

    }

    @Override
    public int getItemCount() {
        return taskslist.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView txtTask;
        Button btRemove;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTask = (TextView) itemView.findViewById(R.id.tv_tasks);
            btRemove = (Button) itemView.findViewById(R.id.bt_remove);


        }
    }
}
