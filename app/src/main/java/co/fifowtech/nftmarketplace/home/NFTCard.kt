package co.fifowtech.nftmarketplace.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.fifowtech.nftmarketplace.R
import co.fifowtech.nftmarketplace.models.nfts
import co.fifowtech.nftmarketplace.ui.theme.NFTMarketplaceTheme

@Composable
fun NFTCard(title : String, subtitle : String,  image: Painter, likes:Int, eth:Double) {
    var isLiked by remember {
        mutableStateOf(false)
    }
    Column(   modifier = Modifier
        .height(262.dp)
        .width(175.dp)
        .background(color = Color.White.copy(0.1f), shape = RoundedCornerShape(30.dp))
        .border(
            1.dp,
            Color.White.copy(0.5f),
            RoundedCornerShape(30.dp)
        )
        .clip(RoundedCornerShape(30.dp))) {
        Image(
            painter = image,
            contentDescription = "",
            modifier = Modifier
                .width(175.dp)
                .height(155.dp)
                .padding(10.dp)
                .border(
                    1.dp,
                    color = Color.Transparent,
                    shape = RoundedCornerShape(22.dp)
                )
                .fillMaxSize()
                .clip(RoundedCornerShape(22.dp)),
            contentScale = ContentScale.Crop
        )
        Column(
            Modifier
                .padding(horizontal = 10.dp)
                .padding(bottom = 10.dp)) {

            Text(
                text = title,
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontSize = 13.sp,
                textAlign = TextAlign.Left
            )
            Text(
                text = subtitle,
                color = Color(235,235,245).copy(0.6f),
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                textAlign = TextAlign.Left
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 10.dp).padding(bottom = 10.dp)
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically) {
               Image(
                   modifier = Modifier.size(13.dp),
                   painter = painterResource(id = R.drawable.icon_eth),
                   contentDescription = "Ethereum Icon"
               )
                Text(
                    text = eth.toString(),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White,
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically,
                ) {
                 IconToggleButton(checked = isLiked, onCheckedChange = {
                     isLiked = !isLiked
                 },modifier = Modifier.size(13.dp) ) {
                     Icon(
                         tint = if (isLiked) Color.Red else Color(235,235,245).copy(0.6f),
                         imageVector = if (isLiked) Icons.Filled.Favorite else Icons.Default.FavoriteBorder,
                         contentDescription = "",
                     )
                 }
                Text(
                    text = likes.toString(),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color(235,235,245).copy(0.6f)
                )
            }
        }
    }

}

@Preview
@Composable
fun PreviewNFTCard() {
    NFTMarketplaceTheme {
        NFTCard(
            nfts[0].title,
            nfts[0].subtitle,
            painterResource(id = nfts[0].image),
            nfts[0].likes,
            nfts[0].eth,
        )
    }
}