package com.colddelight.base_example.util

import java.io.IOException

enum class ErrState {
    BEFORE,SUCCESS,ERROR_TOAST,ERROR_SNACK
}
sealed class NetworkException(errorMessage: String) : IOException(errorMessage) {
    class InternetNotConnected(message: String = "1") :
        NetworkException(message)

    class NotFound(message: String = "2") :
        NetworkException(message)

    class Unauthorized(message: String = "3") :
        NetworkException(message)

    class WorkUnauthorized(message: String = "4"):
        NetworkException(message)
//
//    //코드상에서 throw 던질 때 사용
//    class ErrorShowToast(message: String = Constants.ERROR_MESSAGE_UNHANDLED):
//        NetworkException(message)
//
//    class ErrorShowDialog(message: String = Constants.ERROR_MESSAGE_UNHANDLED):
//        NetworkException(message)
//
//    class ServerError(message: String = Constants.ERROR_MESSAGE_UNHANDLED) : NetworkException(message)
}

