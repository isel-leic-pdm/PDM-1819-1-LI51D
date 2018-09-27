package pdm1819.li51d.movies.parser

import pdm1819.li51d.movies.command.Command

object CommandParser {

    private val commands: MutableMap<String, ()-> Command> = mutableMapOf();

    operator fun set(cmdStr: String, cmdFactory: () -> Command) {
        commands[cmdStr] = cmdFactory
    }


    fun getCommand(cmdString: String) : Command =
        commands[commands.keys.first { cmdString.isCommandOf(it) }]!!.invoke()


    private fun String.isCommandOf(commandTemplate: String): Boolean {
        val commandParts: List<String> = this.split("/");
        val commandTemplateParts = commandTemplate.split("/");
        if(commandParts.size != commandTemplateParts.size)
            return false;

        val regex = Regex("\\{\\w*\\}")
        for (i in commandParts.indices) {
            if(commandParts[i] != commandTemplateParts[i] && !commandTemplateParts[i].matches(regex))
                return false
        }

        return true;
    }
}