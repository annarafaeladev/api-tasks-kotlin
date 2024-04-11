package com.br.api.api.controller

import com.br.api.api.entity.Task
import com.br.api.api.service.TaskService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/tasks")
class TaskController(private val taskService: TaskService) {

    @PostMapping
    fun createTask(@RequestBody task: Task): Task {
        return taskService.saveTask(task)
    }

    @GetMapping("/{id}")
    fun getTaskById(@PathVariable id: UUID): Task? {
        return taskService.getTaskById(id)
    }

    @GetMapping
    fun getAllTasks(): List<Task> {
        return taskService.getAllTasks()
    }

    @PutMapping("/{id}")
    fun updateTask(@PathVariable id: UUID, @RequestBody updatedTask: Task): Task? {
        return taskService.updateTask(id, updatedTask)
    }

    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable id: UUID) {
        taskService.deleteTask(id)
    }
}
