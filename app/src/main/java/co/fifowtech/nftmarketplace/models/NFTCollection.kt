package co.fifowtech.nftmarketplace.models

import co.fifowtech.nftmarketplace.R

class NFTCollection (
    val title : String,
    val image : Int,
    var likes : Int)

var collections = listOf<NFTCollection>(
    NFTCollection("3D Art", R.drawable.card_3d, 123),
    NFTCollection("Abstract Art", R.drawable.card_abstract, 200),
    NFTCollection("Portrait Art", R.drawable.card_pink, 123),
    NFTCollection("Metavers", R.drawable.card_metaverse, 123),
)