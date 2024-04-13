package com.br.api.api.controller

import com.br.api.api.dtos.TaskDto
import com.br.api.api.dtos.response.Response
import com.br.api.api.entity.Task
import com.br.api.api.service.TaskService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/tasks")
class TaskController(private val taskService: TaskService) {

    @PostMapping
    fun createTask(@Valid @RequestBody taskDto: TaskDto, result: BindingResult): ResponseEntity<Response<Task>> {
        val response: Response<Task> = Response();

        if (result.hasErrors()) {
            result.allErrors.forEach { error ->
                response.addErrorMsgToResponse(error.defaultMessage ?: "Erro de validação")
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response)
        }

        response.data = taskService.createTask(taskDto)

        return ResponseEntity.status(HttpStatus.CREATED).body(response)
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
