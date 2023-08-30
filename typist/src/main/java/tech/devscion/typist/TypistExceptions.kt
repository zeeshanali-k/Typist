package tech.devscion.typist

internal class InvalidTextListException : Exception() {

    override fun initCause(cause: Throwable?): Throwable {
        return Throwable("Text list must contain at least one element")
    }


}