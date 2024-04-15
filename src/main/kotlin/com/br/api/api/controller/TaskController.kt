package com.br.api.api.controller

import com.br.api.api.domain.dtos.TaskDto
import com.br.api.api.domain.dtos.response.Response
import com.br.api.api.domain.entity.TaskEntity
import com.br.api.api.exception.BindingResultException
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
    fun createTask(@Valid @RequestBody taskDto: TaskDto, result: BindingResult): ResponseEntity<Response<TaskEntity>> {

        if (result.hasErrors()) {
            throw BindingResultException(result)
        }

        val response: Response<TaskEntity> = Response(taskService.createTask(taskDto))

        return ResponseEntity.status(HttpStatus.CREATED).body(response)
    }

    @GetMapping("/{id}")
    fun getTaskById(@PathVariable id: UUID): TaskEntity? {
        return taskService.getTaskById(id)
    }

    @GetMapping
    fun getAllTasks(): List<TaskEntity> {
        return taskService.getAllTasks()
    }

    @PutMapping("/{id}")
    fun updateTask(@PathVariable id: UUID, @RequestBody updatedTask: TaskEntity): TaskEntity? {
        return taskService.updateTask(id, updatedTask)
    }

    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable id: UUID) {
        taskService.deleteTask(id)
    }
}
