package org.nstmframework.exception

/**
 * User: Naoyuki Yoshinori
 */
class NstmErrorException extends Exception {

    def NstmErrorException() {
        super()
    }

    def NstmErrorException(String message) {
        super(message)
    }

    def NstmErrorException(String message, Throwable cause) {
        super(message, cause)
    }

    def NstmErrorException(Throwable cause) {
        super(cause)
    }
}
