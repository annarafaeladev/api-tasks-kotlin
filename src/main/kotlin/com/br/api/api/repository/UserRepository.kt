package com.br.api.api.repository

import com.br.api.api.domain.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : JpaRepository<UserEntity, UUID> {
    fun findByUsername(email: String) : Optional<UserEntity>;
}