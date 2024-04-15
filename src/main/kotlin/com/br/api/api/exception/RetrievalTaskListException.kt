package com.br.api.api.exception

import com.br.api.api.enumeration.TaskExceptionType

class RetrievalTaskListException(private val type: TaskExceptionType) : Exception(type.message)