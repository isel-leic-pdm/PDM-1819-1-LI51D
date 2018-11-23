package li51d.i1819.pdm.isel.pt.footballapp.repository.dataAccess.footballData

data class CompetitionsDto(val competitions: Array<CompetitionDto>)

data class CompetitionDto(val id: Int, val name: String, val code: String?, val area: AreaDto)

class AreaDto(val name: String)

