package pdm1819.li51d.movies.parser

import org.junit.Test

class CommandExecutorTest : BaseCommandTests() {

    @Test
    fun shouldExecuteCreateMovie() {
        commandExecutor.executeCommand(arrayOf("POST", "/cinemas", "title=titulo&releaseYear=1900&duration=327548327764782364236"))
    }

    @Test(expected= IllegalArgumentException::class)
    fun shouldExecuteCreateMovieAndRaiseErrorForInvalidArguments() {
        commandExecutor.executeCommand(arrayOf("POST", "/cinemas", "title=titulo&releaseYear=1900"))
    }
}