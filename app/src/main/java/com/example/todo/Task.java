package com.example.todo;

public class Task {
    int id;
    String mTask;

    public Task() {
    }

    public Task(int id, String name){
        this.id = id;
        this.mTask = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getmTask() {
        return mTask;
    }

    public void setmTask(String mTask) {
        this.mTask = mTask;
    }
}
