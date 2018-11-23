package li51d.i1819.pdm.isel.pt.footballapp.repository.dataAccess.footballData

class FootballDataApiMock : FootballApi {
    val competitionDtos = arrayOf(
        CompetitionDto(1, "Competition1", "CP1", AreaDto("Area1")),
        CompetitionDto(1, "Competition2", "CP2", AreaDto("Area2"))
    )
    override fun getCompetitions(cb: (Array<CompetitionDto>) -> Unit) {
        cb(competitionDtos)
    }


}
