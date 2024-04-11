package com.br.api.api.dtos

data class TaskDto(
    val title: String,
    val description: String?,
    val priority: Int
)