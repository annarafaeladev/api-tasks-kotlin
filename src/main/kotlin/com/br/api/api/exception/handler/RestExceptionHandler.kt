package com.br.api.api.exception.handler

import com.br.api.api.domain.dtos.response.Response
import com.br.api.api.domain.dtos.response.ResponseError
import com.br.api.api.enumeration.TaskExceptionType
import com.br.api.api.exception.BindingResultException
import com.br.api.api.exception.TaskNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class RestExceptionHandler {

    fun buildResponseError(error: String): Response<ResponseError> {
        val response: Response<ResponseError> = Response()
        response.addErrorMsgToResponse(error)

        return response
    }

    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ResponseEntity<Any> {
        val buildResponseError = buildResponseError(TaskExceptionType.INTERNAL_SERVER_ERROR.message)
        return ResponseEntity(buildResponseError, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleHttpMessageNotReadableException(e: HttpMessageNotReadableException): ResponseEntity<Any> {
        val buildResponseError = buildResponseError(TaskExceptionType.HTTP_MESSAGE_NOT_READABLE.message)
        return ResponseEntity(buildResponseError, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(BindingResultException::class)
    fun handleBindingResultException(e: BindingResultException): ResponseEntity<Any> {
        val buildResponseError = buildResponseError(e.handleErrors())
        return ResponseEntity(buildResponseError, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(TaskNotFoundException::class)
    fun handleTaskNotFoundException(e: TaskNotFoundException): ResponseEntity<Any> {
        val buildResponseError = buildResponseError(TaskExceptionType.TASK_NOT_FOUND.message)
        return ResponseEntity(buildResponseError, HttpStatus.NOT_FOUND)
    }


}