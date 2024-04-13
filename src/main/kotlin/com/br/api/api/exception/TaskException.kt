package com.br.api.api.exception

import com.br.api.api.enumeration.TaskExceptionType

class TaskException(private val type: TaskExceptionType, cause: Throwable? = null) : RuntimeException(type.message, cause)
