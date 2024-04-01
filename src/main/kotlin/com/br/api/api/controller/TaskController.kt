package com.br.api.api.controller

import com.br.api.api.service.TaskService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tasks")
class TaskController(private val taskService: TaskService) {

    @GetMapping()
    fun list() : List<Int> {
        return listOf(1,2)
    }
}