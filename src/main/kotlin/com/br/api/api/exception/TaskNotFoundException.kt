package com.br.api.api.exception

import com.br.api.api.enumeration.TaskExceptionType
import java.util.*


class TaskNotFoundException(private val taskId: UUID) :
    Exception(TaskExceptionType.TASK_NOT_FOUND.message.format(taskId))
