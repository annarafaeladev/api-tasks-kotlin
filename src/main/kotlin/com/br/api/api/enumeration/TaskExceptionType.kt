package com.br.api.api.enumeration

enum class TaskExceptionType(val message: String) {
    UNABLE_TO_CREATE_TASK("Não foi possível criar uma nova tarefa"),
    HTTP_MESSAGE_NOT_READABLE("Erro ao processar a solicitação, verifique o formato e se todos os campos obrigatórios foram fornecidos")
}