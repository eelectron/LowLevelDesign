package todoList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TodoList {
    /*
    * User -> Task map
    * */
    private Map<Integer, List<Task>> userTasks;
    private int taskIdCounter = 1;

    public TodoList() {
        userTasks = new HashMap<>();
    }

    public int addTask(int userId, String taskDescription, int dueDate, List<String> tags) {
        // create task
        int taskId = taskIdCounter++;
        Task newTask = new Task(taskId, taskDescription, dueDate, tags);

        // add task to user's task list
        userTasks.putIfAbsent(userId, new ArrayList<>());
        userTasks.get(userId).add(newTask);

        return taskId;
    }

    public List<String> getAllTasks(int userId) {
        // get all tasks for user
        List<String> taskDescriptions = new ArrayList<>();
        List<Task> tasks = userTasks.getOrDefault(userId, new ArrayList<>());

        // sort the tasks by due date
        tasks.sort((a, b) -> Integer.compare(a.dueDate, b.dueDate));

        // add uncompleted tasks to the result
        for (Task task : tasks) {
            if (!task.isCompleted) {
                taskDescriptions.add(task.taskDescription);
            }
        }
        return taskDescriptions;
    }

    public List<String> getTasksForTag(int userId, String tag) {
        // get tasks for user with specific tag
        List<String> taskDescriptions = new ArrayList<>();
        List<Task> tasks = userTasks.getOrDefault(userId, new ArrayList<>());

        // sort the tasks by due date
        tasks.sort((a, b) -> Integer.compare(a.dueDate, b.dueDate));

        // add uncompleted tasks with the specific tag to the result
        for (Task task : tasks) {
            if (!task.isCompleted && task.tags.contains(tag)) {
                taskDescriptions.add(task.taskDescription);
            }
        }
        return taskDescriptions;
    }

    public void completeTask(int userId, int taskId) {
        // get users tasks
        List<Task> tasks = userTasks.getOrDefault(userId, new ArrayList<>());
        for (Task task : tasks) {
            if (task.taskId == taskId) {
                task.isCompleted = true;
                break;
            }
        }
    }
}

class Task {
    int taskId;
    String taskDescription;
    int dueDate;
    List<String> tags;
    boolean isCompleted;

    public Task(int taskId, String taskDescription, int dueDate, List<String> tags) {
        this.taskId = taskId;
        this.taskDescription = taskDescription;
        this.dueDate = dueDate;
        this.tags = tags;
        this.isCompleted = false;
    }
}
/**
 * Your TodoList object will be instantiated and called as such:
 * TodoList obj = new TodoList();
 * int param_1 = obj.addTask(userId,taskDescription,dueDate,tags);
 * List<String> param_2 = obj.getAllTasks(userId);
 * List<String> param_3 = obj.getTasksForTag(userId,tag);
 * obj.completeTask(userId,taskId);
 */