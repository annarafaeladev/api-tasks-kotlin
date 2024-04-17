package com.br.api.api.interfaces

import com.br.api.api.domain.dtos.TaskDto
import com.br.api.api.domain.dtos.TaskUpdateDto
import com.br.api.api.domain.entity.TaskEntity
import java.util.*

interface TaskHandler {
    fun createTask(taskDto: TaskDto): TaskEntity
    fun getTaskById(id: UUID): TaskEntity
    fun getAllTasks(): List<TaskEntity>
    fun updateTask(id: UUID, updatedTask: TaskUpdateDto): TaskEntity
    fun deleteTask(id: UUID)
}