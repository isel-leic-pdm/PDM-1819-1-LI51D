package pdm1819.li51d.movies.command

abstract class CommandBase(vararg val argumentNames: String) : Command {
    override fun execute(arguments: Map<String, String>) {
        validateArguments(arguments);
        internalExecute(arguments)
    }

    private fun validateArguments(arguments: Map<String, String>) {
        val keys = arguments.keys
        if(keys.intersect(argumentNames.toSet()).size != argumentNames.size)
            throw IllegalArgumentException("arguments keys ${arguments.keys} does not have the same keys as argumentNames ${argumentNames.asList()}")
    }

    protected abstract fun internalExecute(arguments: Map<String, String>);

}
