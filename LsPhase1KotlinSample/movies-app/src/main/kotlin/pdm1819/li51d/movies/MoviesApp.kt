package pdm1819.li51d.movies

import pdm1819.li51d.movies.command.Command
import pdm1819.li51d.movies.command.CreateCinema
import pdm1819.li51d.movies.command.CreateMovie
import pdm1819.li51d.movies.parser.CommandParser

fun main(args: Array<String>) {
    CommandExecutor(registerCommands()).executeCommand(args)


}

private fun registerCommands(): Map<String, () -> Command> =
        mapOf(
                "POST /movies" to { CreateMovie() },
                "POST /cinemas" to { CreateCinema() }
        )


