package co.fifowtech.nftmarketplace.models

import co.fifowtech.nftmarketplace.R
import java.util.UUID

data  class NFTCategory (
  var title: String,
  var image : Int,
  val id : UUID = UUID.randomUUID()
)

var categories = listOf<NFTCategory>(
  NFTCategory("Music", R.drawable.card_music),
  NFTCategory("Art", R.drawable.card_art),
  NFTCategory("Virtual Worlds", R.drawable.card_vw),
)