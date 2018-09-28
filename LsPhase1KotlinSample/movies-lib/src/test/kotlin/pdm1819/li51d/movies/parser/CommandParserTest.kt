package pdm1819.li51d.movies.parser

import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.Before
import pdm1819.li51d.movies.command.CreateCinema
import pdm1819.li51d.movies.command.CreateMovie
import pdm1819.li51d.movies.command.GetTheatreList
import kotlin.reflect.KClass

class CommandParserTest : BaseCommandTests() {

    @Test
    fun shouldReturnCreateMovieCommand() {
        shouldReturnCommandForString("POST /movies", CreateMovie::class)
    }

    @Test
    fun shouldReturnCreateCinemaCommand() {
        shouldReturnCommandForString("POST /cinemas", CreateCinema::class)
    }

    @Test
    fun shouldReturnGetTheatersListCommand() {
        shouldReturnCommandForString("GET /cinemas/5/theaters", GetTheatreList::class)
    }

    private fun shouldReturnCommandForString(cmdStr: String, klass: KClass<*>) {
        //val command = CommandParser.getCommand(cmdStr)
        val command = CommandParser[cmdStr]
        assertTrue(command::class == klass)
    }




}