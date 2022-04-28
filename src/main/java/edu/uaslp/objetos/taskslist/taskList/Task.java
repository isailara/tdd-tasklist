package edu.uaslp.objetos.taskslist.taskList;

import edu.uaslp.objetos.taskslist.exceptions.TaskListException;

import java.time.LocalDateTime;
public class Task {
    String Title,Description;
    LocalDateTime DueDate;
    boolean isDone;

    public Task(String Title,String Description,LocalDateTime DueDate,boolean isDone){
        this.Title=Title;
        this.Description=Description;
        this.DueDate=DueDate;
        this.isDone=isDone;
    }

    public Task(){}

    public boolean isDone(){
        return isDone;
    }

    public void setDone(boolean isDone){
        this.isDone=isDone;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public LocalDateTime getDueDate() {
        return DueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        LocalDateTime now=LocalDateTime.now();
        DueDate = dueDate;
        if(dueDate.isBefore(now)){
            throw new TaskListException("Due date is set in the past");
        }
        DueDate = dueDate;
    }
}
