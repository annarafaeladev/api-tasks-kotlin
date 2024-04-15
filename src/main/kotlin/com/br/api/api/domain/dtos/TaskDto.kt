package com.br.api.api.domain.dtos

import jakarta.validation.constraints.NotBlank

data class TaskDto(
    @field:NotBlank(message = "Campo title não pode estar em branco")
    val title: String,
    val description: String?,
    val priority: Int = 1
)