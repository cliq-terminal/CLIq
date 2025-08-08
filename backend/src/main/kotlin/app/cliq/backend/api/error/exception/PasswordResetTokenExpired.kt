package app.cliq.backend.api.error.exception

import app.cliq.backend.api.error.ErrorCode
import org.springframework.http.HttpStatus

class PasswordResetTokenExpired : ApiException(HttpStatus.BAD_REQUEST, ErrorCode.PASSWORD_RESET_TOKEN_EXPIRED)
