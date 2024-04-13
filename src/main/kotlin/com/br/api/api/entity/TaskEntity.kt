package com.br.api.api.entity

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "tasks")
class TaskEntity(
    private var title: String,
    private var description: String? = null,
    private var priority: Int = 1
) {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "uuid")
    var id: UUID = UUID.randomUUID();

}