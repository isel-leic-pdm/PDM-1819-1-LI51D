package pdm1819.li51d.movies.parser

import pdm1819.li51d.movies.command.CreateCinema
import pdm1819.li51d.movies.command.CreateMovie
import pdm1819.li51d.movies.command.GetTheatreList

fun registerCommands() {
    CommandParser["POST /movies"] = { CreateMovie() }
    CommandParser["POST /cinemas"] = { CreateCinema() }
    CommandParser["GET /cinemas/{cid}/theaters"] = { GetTheatreList() }
}