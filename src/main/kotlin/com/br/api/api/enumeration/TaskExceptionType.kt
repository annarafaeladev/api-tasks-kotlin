package com.br.api.api.enumeration

enum class TaskExceptionType(val message: String) {
    UNABLE_TO_CREATE_TASK("Não foi possível criar uma nova tarefa"),
    HTTP_MESSAGE_NOT_READABLE("Erro ao processar a solicitação, verifique o formato e se todos os campos obrigatórios foram fornecidos"),
    TASK_NOT_FOUND("Tarefa não encontrada para o ID informado."),
    UNABLE_TO_UPDATE_TASK("Não foi possível criar uma nova tarefa"),
    UNABLE_TO_RETRIEVAL_TASK_LIST("Ocorreu um arro ao buscar a lista de tarefas"),
    INTERNAL_SERVER_ERROR("Internal server error"),
}