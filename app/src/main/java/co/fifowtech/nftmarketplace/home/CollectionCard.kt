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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.fifowtech.nftmarketplace.models.collections
import co.fifowtech.nftmarketplace.ui.theme.NFTMarketplaceTheme

@Composable
fun CollectionCard(title : String, image: Painter, likes:Int) {
    var isLiked by remember {
        mutableStateOf(false)
    }
    Column( modifier = Modifier
        .width(216.dp)
        .height(216.dp)
        .background(color = Color.White.copy(0.1f), shape = RoundedCornerShape(30.dp))
        .border(
            width = 1.dp,
            color = Color.White.copy(0.5f),
            shape = RoundedCornerShape(30.dp)
        )
    ) {
        Image(
            image,
            contentDescription = title,
            modifier = Modifier
                .height(155.dp)
                .width(155.dp)
                .padding(10.dp)
                .border(
                    width = 1.dp,
                    color = Color.Transparent,
                    shape = RoundedCornerShape(22.dp)
                )
                .fillMaxSize()
                .clip(RoundedCornerShape(22.dp))

        )
        Row(
            modifier = Modifier.padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                color = Color.White
            )
            Spacer(modifier = Modifier.weight(1f))
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconToggleButton(checked = isLiked, onCheckedChange = {
                    // change value of checke
                    isLiked = !isLiked
                    }
                     ) {
                    Icon(
                        tint = if (isLiked)  Color.Red else Color(235,235,245).copy(0.6f),
                        imageVector = if(isLiked) Icons.Filled.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "Favorite button"
                    )

                }
                Text(
                    text = likes.toString(),
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp,
                    textAlign = TextAlign.Right,
                    color = Color(235,235,245).copy(0.6f)
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewCollectionCard() {
    NFTMarketplaceTheme {
        CollectionCard(
            collections[0].title,
            painterResource(id = collections[0].image),
            collections[0].likes
        )
    }
}