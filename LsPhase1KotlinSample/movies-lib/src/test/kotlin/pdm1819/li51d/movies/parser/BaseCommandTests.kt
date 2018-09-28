package pdm1819.li51d.movies.parser

import org.junit.Before
import pdm1819.li51d.movies.CommandExecutor
import pdm1819.li51d.movies.command.Command
import pdm1819.li51d.movies.command.CreateCinema
import pdm1819.li51d.movies.command.CreateMovie
import pdm1819.li51d.movies.command.GetTheatreList

open class BaseCommandTests {
    protected lateinit var commandExecutor: CommandExecutor

    @Before
    public fun setUp() {
        commandExecutor = CommandExecutor(registerCommands())
    }

    private fun registerCommands(): Map<String, () -> Command> =
            mapOf(
                    "POST /movies" to { CreateMovie() },
                    "POST /cinemas" to { CreateCinema() },
                    "GET /cinemas/{cid}/theaters" to { GetTheatreList() }
            )

}
