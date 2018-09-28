package pdm1819.li51d.movies

import pdm1819.li51d.movies.command.Command
import pdm1819.li51d.movies.parser.CommandParser

class CommandExecutor(commands: Map<String, ()-> Command>) {

    init {
        commands.forEach({ CommandParser[it.key] = it.value })
    }



    fun executeCommand(args: Array<String>) {


        val command = CommandParser.getCommand("${args[0]} ${args[1]}")

        val arguments = if(args.size == 3) args[2] else "";
        command.execute(CommandParser.parseArguments(arguments))

    }
}