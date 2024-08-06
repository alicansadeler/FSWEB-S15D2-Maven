package org.example.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String worker){
        switch (worker.toLowerCase()) {
            case "ann":
                return this.annsTasks;
            case "bob":
                return this.bobsTasks;
            case "carol":
                return this.carolsTasks;
            case "all":
                Set<Task> allTasks = new HashSet<>(annsTasks);
                allTasks.addAll(bobsTasks);
                allTasks.addAll(carolsTasks);
                return allTasks;
            default:
                throw new IllegalArgumentException("Çalışan mevcut değil: " + worker);
        }
    }

    public Set<Task> getUnassignedTasks() {
        return this.unassignedTasks;
    }

    public Set<Task> getIntersection(Set<Task> worker1, Set<Task> worker2) {
        Set<Task> worker1Copy = new HashSet<>(worker1);
        worker1Copy.retainAll(worker2);
        return worker1Copy;
    }

    public Set<Task> getDifferences(Set<Task> worker1, Set<Task> worker2) {
        Set<Task> worker1Copy = new HashSet<>(worker1);
        worker1Copy.removeAll(worker2);
        return worker1Copy;
    }

    public Set<Task> getUnion(Set<Task> taskList1, Set<Task> taskList2) {
        Set<Task> result = new HashSet<>(taskList1);
        result.addAll(taskList2);
        return result;
    }

}
