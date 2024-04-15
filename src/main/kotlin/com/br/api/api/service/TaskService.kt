package com.br.api.api.service

import com.br.api.api.domain.dtos.TaskDto
import com.br.api.api.domain.dtos.TaskUpdateDto
import com.br.api.api.domain.entity.TaskEntity
import com.br.api.api.enumeration.TaskExceptionType
import com.br.api.api.exception.RetrievalTaskListException
import com.br.api.api.exception.TaskException
import com.br.api.api.exception.TaskNotFoundException
import com.br.api.api.repository.TaskRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class TaskService(private val taskRepository: TaskRepository) {
    fun createTask(taskDto: TaskDto): TaskEntity {
        try {
            val newTask = TaskEntity(taskDto.title, taskDto.description, taskDto.priority)

            return savedTask(newTask)
        } catch (ex: Exception) {
            throw TaskException(TaskExceptionType.UNABLE_TO_CREATE_TASK)
        }
    }


    fun getTaskById(id: UUID): TaskEntity {
        val taskEntityOptional = taskRepository.findById(id)

        if (taskEntityOptional.isEmpty) {
            throw TaskNotFoundException(id)
        }

        return taskEntityOptional.get()
    }

    fun getAllTasks(): List<TaskEntity> {
        try {
            return taskRepository.findAll()
        } catch (ex: Exception) {
            throw RetrievalTaskListException(TaskExceptionType.UNABLE_TO_RETRIEVAL_TASK_LIST)
        }
    }

    fun updateTask(id: UUID, updatedTask: TaskUpdateDto): TaskEntity {
        try {
            val taskEntity = getTaskById(id)

            updateFields(taskEntity, updatedTask)
            return savedTask(taskEntity)

        } catch (ex: Exception) {
            throw TaskException(TaskExceptionType.UNABLE_TO_UPDATE_TASK)
        }
    }

    private fun updateFields(entity: TaskEntity, updatedTask: TaskUpdateDto) {
        updatedTask.title?.let { entity.title = it }
        updatedTask.description?.let { entity.description = it }
        updatedTask.priority?.let { entity.priority = it }
    }


    fun deleteTask(id: UUID) {
        val taskEntity = getTaskById(id)

        taskRepository.deleteById(taskEntity.id)
    }

    @Transactional
    private fun savedTask(task: TaskEntity): TaskEntity {
        return taskRepository.save(task)
    }
}
