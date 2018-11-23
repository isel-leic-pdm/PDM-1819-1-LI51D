package li51d.i1819.pdm.isel.pt.footballapp.repository.dataAccess.footballData

import li51d.i1819.pdm.isel.pt.footballapp.utils.HttpRequests

private const val URL_PREFIX = "http://api.football-data.org/v2/"
private const val AUTH_TOKEN_NAME = "X-Auth-Token"

class FootballDataApi : FootballApi{

    private val headers = mapOf<String, String>().toMutableMap()

    var authToken: String = ""
        get() = field
        set(value) {
            field = value
            headers[AUTH_TOKEN_NAME] = value
        }


    override fun getCompetitions(cb: (Array<CompetitionDto>) -> Unit) {
        HttpRequests.getJsonDto<CompetitionsDto>("${URL_PREFIX}competitions", headers) {
            cb(it.competitions)
        }
    }
}
