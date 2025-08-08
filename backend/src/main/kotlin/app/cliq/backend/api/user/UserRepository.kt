package app.cliq.backend.api.user

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.time.OffsetDateTime

interface UserRepository : JpaRepository<User, Long> {
    fun existsUserByEmail(email: String): Boolean

    fun findUserByEmail(email: String): User?

    fun findUserByEmailVerificationToken(token: String): User?

    @Modifying
    @Query("DELETE FROM User u WHERE u.emailVerifiedAt IS NULL AND u.emailVerificationSentAt < :cutoffTime")
    fun deleteUnverifiedUsersOlderThan(
        @Param("cutoffTime") cutoffTime: OffsetDateTime,
    ): Int
}
