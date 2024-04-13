package com.br.api.api.service
import com.br.api.api.dtos.TaskDto
import com.br.api.api.entity.Task
import com.br.api.api.enumeration.TaskExceptionType
import com.br.api.api.exception.TaskException
import com.br.api.api.repository.TaskRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class TaskService(private val taskRepository: TaskRepository) {
    fun createTask(taskDto: TaskDto): Task {
        try {
            return savedTask(taskDto)
        } catch (ex: Exception) {
            throw TaskException(TaskExceptionType.UNABLE_TO_CREATE_TASK, ex)
        }
    }

    @Transactional
    private fun savedTask(taskDto: TaskDto) : Task {
        val newTask = Task(taskDto.title, taskDto.description, taskDto.priority)
        return taskRepository.save(newTask)
    }

    fun getTaskById(id: UUID): Task? {
        return taskRepository.findById(id).orElse(null)
    }

    fun getAllTasks(): List<Task> {
        return taskRepository.findAll()
    }

    fun updateTask(id: UUID, updatedTask: Task): Task? {
        val existingTask = getTaskById(id)
        if (existingTask != null) {
            updatedTask.id = existingTask.id
            return taskRepository.save(updatedTask)
        }
        return null
    }

    fun deleteTask(id: UUID) {
        taskRepository.deleteById(id)
    }
}
