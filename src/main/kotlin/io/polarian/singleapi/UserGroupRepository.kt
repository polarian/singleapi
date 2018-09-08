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
interface UserGroupRepository : CrudRepository<UserGroup, Long>

@Entity
@Table
data class UserGroup(
        @Id
        @GeneratedValue
        val id: Long,

        @NotBlank
        val name: String,

        @NotBlank
        val location: String,

        @NotNull
        val private: Boolean,

        @field:CreationTimestamp
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        val regDate: LocalDateTime = LocalDateTime.now()
)