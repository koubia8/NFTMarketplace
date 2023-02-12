package co.fifowtech.nftmarketplace.stats

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Assessment
import androidx.compose.material.icons.filled.TrackChanges
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.fifowtech.nftmarketplace.models.rankings
import co.fifowtech.nftmarketplace.ui.theme.NFTMarketplaceTheme

@Composable
fun StatsScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                content = {
                    Column {
                        Text(
                            text = "Stats",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White,
                            modifier = Modifier.fillMaxSize(),
                            textAlign = TextAlign.Center
                        )
                    }
                },
                backgroundColor = Color.Transparent,
                elevation = 0.dp
            )
        },
        backgroundColor = Color(33,17,52)
    ) {
        Column ( Modifier.padding(bottom = 30.dp)){
            CustomeTabComponent()
        /* Card(
             backgroundColor = Color.White.copy(0.15f),
             elevation = 0.dp,
             border = BorderStroke(1.5.dp,Color.White.copy(0.5f)),
             shape = RoundedCornerShape(20.dp),
             modifier = Modifier.padding(16.dp, 20.dp)
         ) {
             RankingTable(rankings = rankings)
         }*/
            RankingTable(rankings = rankings)
        }
    }
}

@Composable
fun CustomeTabComponent() {
    var tabIndex by remember { mutableStateOf(0) }
    var tabData = listOf(
        "Ranking" to Icons.Default.Assessment,
        "Activity" to Icons.Default.TrackChanges,
    )
    TabRow(
        selectedTabIndex = tabIndex, 
        backgroundColor = Color.Transparent,
        contentColor = Color.White,
        divider = {
            TabRowDefaults.Divider(
                thickness = 1.dp,
                color = Color(66,34,104)
            )
        },
        indicator = {tabPositions -> TabRowDefaults.Indicator(
            modifier = Modifier.customTabOffset(tabPositions[tabIndex]),
            height = 4.dp,
            color = Color(148,103,255)
        )  }
    ) {
        tabData.forEachIndexed {
            index, pair ->  
            Tab(selected = tabIndex == index, 
                onClick = { 
                tabIndex = index
            }, content = {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(bottom = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                   Icon(imageVector = pair.second, contentDescription = null )
                   Text(
                       pair.first,
                       fontWeight = FontWeight.SemiBold,
                       fontSize = 17.sp,
                       color = Color.White
                   )
                }
                } ) 
        }
        
    }
}
fun Modifier.customTabOffset(tabPosition: TabPosition) : Modifier = composed {

    val indicatorWith = 118.dp
    val currentTabWidht = tabPosition.width
    val indicatorOffset  by animateDpAsState(
        targetValue = tabPosition.left + currentTabWidht / 2 - indicatorWith/2,
        animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing)
    )
    fillMaxSize()
        .wrapContentSize(Alignment.BottomStart)
        .offset(x = indicatorOffset)
        .width(indicatorWith)
}

@Preview
@Composable
fun StatsScreenPreview() {


    NFTMarketplaceTheme {
        StatsScreen()
    }
}