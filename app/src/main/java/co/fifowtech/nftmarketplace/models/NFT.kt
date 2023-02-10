package co.fifowtech.nftmarketplace.models

import co.fifowtech.nftmarketplace.R
import java.util.UUID

data class NFT (
    val title : String,
    val subtitle : String,
    val image : Int,
    var likes: Int =0,
    var eth : Double = 0.0,
    val id : UUID = UUID.randomUUID()
        )

var nfts = listOf<NFT>(
    NFT(title = "Wave", subtitle = "nav #5672", R.drawable.card_wave2, likes = 5160, eth = 0.018),
    NFT(title = "Abstract", subtitle = "abstract #2538", R.drawable.card_pink, likes = 1800, eth = 0.906),
    NFT(title = "Wave", subtitle = "waveapi #5267", R.drawable.card_wave2, likes = 2030, eth = 0.26),
    NFT(title = "Abstract23", subtitle = "abastract #2038", R.drawable.card_wave2, likes = 2060, eth = 0.246),
    NFT(title = "Music", subtitle = "mali #7890", R.drawable.card_musicnft, likes = 690, eth = 0.03),
    NFT(title = "Ball", subtitle = "baali #4890", R.drawable.card_ball, likes = 1690, eth = 0.46),
    NFT(title = "Ring", subtitle = "Ring #7288", R.drawable.card_ring, likes = 400, eth = 0.106),
    NFT(title = "Beer", subtitle = "Beer #1238", R.drawable.card_ring, likes = 400, eth = 0.106),
)