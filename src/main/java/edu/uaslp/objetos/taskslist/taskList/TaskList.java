package edu.uaslp.objetos.taskslist.taskList;

import edu.uaslp.objetos.taskslist.exceptions.TaskNotFoundException;

import java.util.*;

public class TaskList {

    LinkedList<Task> taskList = new LinkedList<>();

    public void add(Task task){
        taskList.add(task);
    }

    public void remove(Task task){
        taskList.remove(task);
    }

    public int getSize() {
        return taskList.size();
    }
    public Task find(String Title){
        int i=0;
        int size=taskList.size();
        for (i=0; size>i; i++) {
            if (Title == taskList.get(i).getTitle()) {
                return taskList.get(i);
            }
        }
        throw new TaskNotFoundException("Task with title 'Hacer ejercicio' not found");

        //Task task;
        //int i;
        //int size=taskList.size();

        //for(i=0;Title != taskList.get(i).getTitle() && size>i;i++);

        //return taskList.get(i);
        /*while (Title != taskList.get(i).getTitle() && size>i){
            i++;
        }*/
        /*if(Title == taskList.get(i).getTitle()){
            return taskList.get(i);
        }else {
            throw new TaskNotFoundException("Task with title "+Title+" not found");
        }*/
    }

    public void markAsDone(String Title){
        Task task=find(Title);

        task.isDone=true;
    }

    public void markAsNotDone(String Title){
        Task task=find(Title);

        task.isDone=false;
    }

    public Task getNextTask(){

        String title = taskList.element().getTitle();
        int i;
        int size=taskList.size();

        for(i=0;title != taskList.get(i).getTitle() && size>i;i++);

        return taskList.get(i+1);
        /*while (title != taskList.get(i).getTitle() && size>i){
            i++;
        }if(title == taskList.get(i).getTitle()){
            return taskList.get(i+1);
        }else {
            return null;
        }*/
    }

    public List<Task> getNextTasks(){
        List<Task> tasks = new LinkedList<>();

        for (Task task : taskList) {
            if (!task.isDone()) {
                tasks.add(task);
            }
        }

        tasks.sort(Comparator.comparing(Task::getDueDate));

        return tasks;
    }
}
