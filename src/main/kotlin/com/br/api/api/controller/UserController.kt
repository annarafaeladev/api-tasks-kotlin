package com.br.api.api.controller

import com.br.api.api.domain.dtos.UserRequest
import com.br.api.api.domain.dtos.response.Response
import com.br.api.api.domain.entity.UserEntity
import com.br.api.api.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/api/user")
class UserController(private  val userService: UserService) {

    @PostMapping
    fun createUser(@RequestBody user: UserRequest) : ResponseEntity<Response<UserEntity>> {
        val response: Response<UserEntity> = Response(userService.save(user))

        return ResponseEntity.ok(response)
    }
}