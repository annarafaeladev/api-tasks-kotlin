package com.br.api.api.exception

import org.springframework.validation.BindingResult

class BindingResultException(private val result: BindingResult) : Exception() {

    fun handleErrors(): String {
        return result.allErrors[0].defaultMessage ?: "";
    }
}