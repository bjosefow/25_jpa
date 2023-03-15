package com.example.springDataJpa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TaskController {

    private TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/to-do-list")
    public String showToDoList(Model model) {
        List<Task> toDoTaskList = taskRepository.findByDoneIsFalse();
        model.addAttribute("toDoList", toDoTaskList);
        return "toDoList";
    }

    @GetMapping("/add-new-task")
    public String addNewTask(Model model) {
        model.addAttribute("newTask", new Task());
        return "addNewTask";
    }

    @PostMapping("/add")
    public String addTask(Task task) {
        taskRepository.save(task);
        return "redirect:/to-do-list";
    }

    @GetMapping("/archives")
    public String archiwum(Model model) {
        List<Task> doneTasks = taskRepository.findByDoneIsTrue();
        model.addAttribute("doneTasks", doneTasks);
        return "archives";
    }

    @GetMapping("/update/{id}")
    public String updateStatus(@PathVariable Long id) {
        taskRepository.checkTaskAsDone(id);
        return "redirect:/to-do-list";
    }

}
