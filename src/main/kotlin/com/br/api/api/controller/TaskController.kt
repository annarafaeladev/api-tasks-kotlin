package com.br.api.api.controller

import com.br.api.api.domain.dtos.TaskDto
import com.br.api.api.domain.dtos.TaskUpdateDto
import com.br.api.api.domain.dtos.response.Response
import com.br.api.api.domain.entity.TaskEntity
import com.br.api.api.exception.BindingResultException
import com.br.api.api.service.CacheService
import com.br.api.api.service.TaskService
import jakarta.validation.Valid
import org.springframework.cache.annotation.Cacheable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/tasks")
class TaskController(private val taskService: TaskService, private val cacheService: CacheService) {

    @PostMapping
    fun createTask(@Valid @RequestBody taskDto: TaskDto, result: BindingResult): ResponseEntity<Response<TaskEntity>> {

        if (result.hasErrors()) {
            throw BindingResultException(result)
        }

        cacheService.clearTaskCache()
        val response: Response<TaskEntity> = Response(taskService.createTask(taskDto))

        return ResponseEntity.status(HttpStatus.CREATED).body(response)
    }

    @GetMapping("/{id}")
    fun getTaskById(@PathVariable id: UUID): ResponseEntity<TaskEntity?> {
        return ResponseEntity.ok(taskService.getTaskById(id))
    }

    @GetMapping
    @Cacheable("allTasks")
    fun getAllTasks(): ResponseEntity<List<TaskEntity>> {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @PutMapping("/{id}")
    fun updateTask(@PathVariable(name = "id") id: UUID, @RequestBody updatedTask: TaskUpdateDto): ResponseEntity<Any> {
        val task = taskService.updateTask(id, updatedTask)
        cacheService.clearTaskCache()

        return ResponseEntity.ok(task)
    }

    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable id: UUID): ResponseEntity<Any> {
        taskService.deleteTask(id)
        cacheService.clearTaskCache()

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null)
    }
}