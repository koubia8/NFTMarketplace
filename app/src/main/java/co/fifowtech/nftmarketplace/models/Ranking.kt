package co.fifowtech.nftmarketplace.models

import co.fifowtech.nftmarketplace.R
import java.util.UUID

data class Ranking (
    val title : String,
    val image : Int,
    var percentChange : Double = 0.0,
    var eth : Double = 0.0,
    val id : UUID = UUID.randomUUID()

        )

var rankings = listOf<Ranking>(
    Ranking("Azumi", R.drawable.ranking01,3.99,200055.05),
    Ranking("Hape prime",R.drawable.ranking02,33.79,180055.45),
    Ranking("Cryoto",R.drawable.ranking03,-6.56,90055.62),
    Ranking("Ape Club",R.drawable.ranking04,3.99,88055.12),
    Ranking("Mutant ",R.drawable.ranking05,3.99,10055.0),
    Ranking("Metaverse ",R.drawable.ranking06,-3.99,2342.4),
    Ranking("Mountain ",R.drawable.ranking07,5.53,2449024.53),
    Ranking("Mutant Ape ",R.drawable.ranking08,-23.49,93492.3),
    Ranking("The Mountain ",R.drawable.ranking10,-23.49,239802.3),
)