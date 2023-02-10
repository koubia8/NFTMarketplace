package co.fifowtech.nftmarketplace.stats

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.fifowtech.nftmarketplace.models.rankings
import co.fifowtech.nftmarketplace.ui.theme.NFTMarketplaceTheme
import co.fifowtech.nftmarketplace.R

@Composable
fun RankingRow(
    index : Int,
    title: String,
    image: Int,
    change: Double,
    eth: Double
) {

      Row( horizontalArrangement = Arrangement.spacedBy(9.dp),
          verticalAlignment = Alignment.CenterVertically) {
          Text(
              text = (index+1).toString(),
              color = Color(235, 235, 245).copy(0.6f),
              fontSize = 15.sp,
              fontWeight = FontWeight.Normal
          )
          Image(
              painter = painterResource(id = image),
              contentDescription = "",
              modifier = Modifier
                  .height(60.dp)
                  .width(60.dp)
                  .padding(vertical = 11.dp)
                  .padding(end = 15.dp)
                  .fillMaxSize()
                  .clip(RoundedCornerShape(10.dp))
          )

          Column() {
              Text(
                  text = title,
                  color = Color.White,
                  fontSize = 17.sp,
                  fontWeight = FontWeight.SemiBold,
                  modifier = Modifier.padding(bottom = 8.dp)

              )
              Text(text = "view info",
                  color = Color(235, 235, 245).copy(0.6f),
                  fontSize = 13.sp,
                  fontWeight = FontWeight.Normal)
          }
          Spacer(Modifier.weight(1f))
          Column(horizontalAlignment = Alignment.End) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(bottom = 8.dp )
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_eth),
                        contentDescription = "",
                        modifier = Modifier.size(13.dp)
                    )
                    Text(
                        eth.toString(),
                        color = Color.White,
                        fontSize = 13.sp,
                        textAlign = TextAlign.Left
                    )
                }
              Text(
                  "$change%",
                  color = if( change > 0) Color.Green else Color.Red,
                  fontSize = 13.sp
              )
          }

  }
}

@Preview
@Composable
fun RankingRowPreview() {
    NFTMarketplaceTheme() {
        RankingRow(
            index = 0,
            title = rankings[0].title,
            image = rankings[0].image,
            change = rankings[0].percentChange,
            eth = rankings[0].eth
        )
    }

}