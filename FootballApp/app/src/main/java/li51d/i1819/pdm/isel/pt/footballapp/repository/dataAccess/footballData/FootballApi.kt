package li51d.i1819.pdm.isel.pt.footballapp.repository.dataAccess.footballData

interface FootballApi {
    fun getCompetitions(cb: (Array<CompetitionDto>) -> Unit): Unit
}
