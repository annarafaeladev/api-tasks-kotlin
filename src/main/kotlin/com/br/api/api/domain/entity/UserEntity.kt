package com.br.api.api.domain.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import java.util.*


@Entity
@Table(name = "users")
class UserEntity(
    @Column(nullable = false, name = "full_name") var fullName: String,
    @Column(unique = true, length = 100, nullable = false, name = "email") var username: String,
    @Column(nullable = false) var password: String
)  {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "uuid")
    var id: UUID = UUID.randomUUID()

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    var createdAt: LocalDateTime = LocalDateTime.now()

    @UpdateTimestamp
    @Column(name = "updated_at")
    var updatedAt: LocalDateTime = LocalDateTime.now()


    @Column(name = "is_admin")
    var isAdmin: Boolean = false

}