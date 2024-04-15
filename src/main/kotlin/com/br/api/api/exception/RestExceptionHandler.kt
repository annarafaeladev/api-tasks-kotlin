package com.br.api.api.exception

import com.br.api.api.domain.dtos.response.Response
import com.br.api.api.domain.dtos.response.ResponseError
import com.br.api.api.enumeration.TaskExceptionType
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class RestExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleHttpMessageNotReadableException(e: HttpMessageNotReadableException): ResponseEntity<Any> {
        val response: Response<ResponseError> = Response()
        response.addErrorMsgToResponse(TaskExceptionType.HTTP_MESSAGE_NOT_READABLE.message)
        return ResponseEntity(response, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(BindingResultException::class)
    fun handleHttpMessageNotReadableException(e: BindingResultException): ResponseEntity<Any> {
        val response: Response<ResponseError> = Response()
        response.addErrorMsgToResponse(e.handleErrors())
        return ResponseEntity(response, HttpStatus.BAD_REQUEST)
    }


}