package com.br.api.api.repository

import com.br.api.api.entity.Task
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface TaskRepository : JpaRepository<Task, UUID> {
}