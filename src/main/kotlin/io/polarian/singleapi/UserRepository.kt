package io.polarian.singleapi

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.annotations.CreationTimestamp
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@RepositoryRestResource
interface UserRepository : CrudRepository<User, Long>

@Entity
@Table
data class User(
        @Id
        @GeneratedValue
        val id: Long,

        @NotBlank
        val email: String,

        @NotBlank
        val password: String,

        @NotNull
        val enabled: Boolean,

        @field:CreationTimestamp
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        val regDate: LocalDateTime = LocalDateTime.now()
)