package com.br.api.api.service

import com.br.api.api.domain.dtos.UserRequest
import com.br.api.api.domain.entity.UserEntity
import com.br.api.api.repository.UserRepository
import org.springframework.stereotype.Service

import java.util.*

@Service
class UserService(
    private val userRepository: UserRepository,
) {

    fun save(user: UserRequest) : UserEntity {
        val userEntity = UserEntity(user.fullName, user.email, user.password)
        return userRepository.saveAndFlush(userEntity)
    }

    fun getById(id: UUID): UserEntity {
        val user = userRepository.findById(id)

        if (user.isEmpty)
            throw Exception("User not found by uuid $id")

        return user.get()
    }


    fun getByEmail(email: String): UserEntity {
        val user = userRepository.findByUsername(email)

        if (user.isEmpty)
            throw Exception("User not found by email $email")

        return user.get()
    }
}