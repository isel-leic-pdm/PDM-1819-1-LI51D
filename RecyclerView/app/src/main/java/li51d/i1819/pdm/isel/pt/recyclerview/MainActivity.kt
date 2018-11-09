package li51d.i1819.pdm.isel.pt.recyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var layoutMgr: RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cities = arrayOf(
            "Groot-Bijgaarden",
            "Jhansi",
            "Hénin-Beaumont",
            "Huntly",
            "Talgarth",
            "Bloxham",
            "Bouge",
            "Llangefni",
            "Gerpinnes",
            "Knokke-Heist",
            "Baasrode",
            "Reinbek",
            "Hohenems",
            "Panketal",
            "Overland Park",
            "GozŽe",
            "Copertino",
            "Coquimbo",
            "Calera",
            "Guápiles",
            "Curanilahue",
            "Dudley",
            "Kobbegem",
            "Charters Towers",
            "Gorakhpur",
            "Nieuwmunster",
            "Borgo Valsugana",
            "Reggio nell'Emilia",
            "Corbais",
            "Maracalagonis",
            "Guben",
            "Schepdaal",
            "Milwaukee",
            "Aberdeen",
            "Vucht",
            "Warwick",
            "Firenze",
            "Vollezele",
            "Drachten",
            "Waterbury",
            "Waasmunster",
            "Gravilias",
            "Rodì Milici",
            "Drumheller",
            "Santipur",
            "Coinco",
            "Meeuwen",
            "Vallentuna",
            "Curacaví",
            "Trieste",
            "Monte San Pietrangeli",
            "Okigwe",
            "Harrisburg",
            "Pettineo",
            "Ránquil",
            "Tredegar",
            "Tresigallo",
            "Henley-on-Thames",
            "São João de Meriti",
            "Bari",
            "Casper",
            "Chalon-sur-Saône",
            "Aalen",
            "Enna",
            "Napier",
            "Baulers",
            "La Cisterna",
            "Las Condes",
            "Jupille-sur-Meuse",
            "Fayetteville",
            "Gresham",
            "Bielefeld",
            "Val Rezzo",
            "Erlangen",
            "Maranguape",
            "Delta",
            "Bekegem",
            "Lolol",
            "Sant'Agata Bolognese",
            "Aalbeke",
            "Isle-aux-Coudres",
            "Rock Springs",
            "Sint-Denijs-Westrem",
            "Modinagar",
            "Independencia",
            "Sachs Harbour",
            "Giugliano in Campania",
            "Wilmont",
            "Warren",
            "Paignton",
            "Angoulême",
            "La Salle",
            "Kelkheim",
            "Robechies",
            "St. Andrä",
            "Warisoulx",
            "Bhuj",
            "Secunderabad",
            "Glendale",
            "Wanaka"
        )
        layoutMgr = LinearLayoutManager(this)
        viewAdapter = StringAdapter(cities)

        cities_recycler_view.apply {
            setHasFixedSize(true)
            layoutManager = layoutMgr
            adapter = viewAdapter
        }
    }
}
