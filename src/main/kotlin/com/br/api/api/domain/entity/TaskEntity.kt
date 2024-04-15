package com.br.api.api.domain.entity

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "tasks")
class TaskEntity(
    var title: String,
    var description: String? = null,
    var priority: Int = 1
) {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "uuid")
    var id: UUID = UUID.randomUUID();

}