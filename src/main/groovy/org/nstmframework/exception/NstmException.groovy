package org.nstmframework.exception

/**
 * User: Naoyuki Yoshinori
 */
class NstmException extends Exception {

    def NstmException() {
        super()
    }

    def NstmException(String message) {
        super(message)
    }

    def NstmException(String message, Throwable cause) {
        super(message, cause)
    }

    def NstmException(Throwable cause) {
        super(cause)
    }
}
