package pdm1819.li51d.movies

import pdm1819.li51d.movies.command.CreateCinema
import pdm1819.li51d.movies.command.CreateMovie
import pdm1819.li51d.movies.parser.CommandParser
import pdm1819.li51d.movies.parser.CommandParser.getCommand

fun main(args: Array<String>) {
    registerCommands()
    val command = getCommand("$args[0] $args[1]")

    command.execute(if(args.size == 3) args[2] else "")


}

fun registerCommands() {
    CommandParser["POST /movies"] = { CreateMovie() }
    CommandParser["POST /cinemas"] = { CreateCinema() }
}
