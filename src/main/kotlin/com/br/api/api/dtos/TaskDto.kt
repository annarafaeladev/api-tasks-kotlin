package com.br.api.api.dtos

import jakarta.validation.constraints.NotBlank

data class TaskDto(
    @field:NotBlank(message = "O título não pode estar em branco")
    val title: String,
    val description: String?,
    val priority: Int = 1
)