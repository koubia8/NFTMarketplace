package co.fifowtech.nftmarketplace


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.fifowtech.nftmarketplace.home.HomeScreen
import co.fifowtech.nftmarketplace.ui.theme.NFTMarketplaceTheme


@Composable
fun RootScreen() {
    Scaffold (
        bottomBar = {
            BottomBar()
        }
            ){
        HomeScreen();
    }
}
sealed class NavigationItem(var route: String, var icon : ImageVector, var title: String) {
    object Login : NavigationItem("login", Icons.Filled.Home, "Home")
    object Home : NavigationItem("home", Icons.Filled.Home, "Home")
    object Stats : NavigationItem("stats", Icons.Filled.Analytics, "Stats")
    object Add : NavigationItem("add", Icons.Filled.Add, "Add")
    object Search : NavigationItem("search", Icons.Filled.Search, "Search")
    object Profile : NavigationItem("profile", Icons.Filled.Person, "Profile")
}

@Preview
@Composable
fun RootScreenPreview() {
    NFTMarketplaceTheme {
        RootScreen()
    }
}


@Composable
fun BottomBar() {
  var items = listOf(
      NavigationItem.Home,
      NavigationItem.Stats,
      NavigationItem.Add,
      NavigationItem.Search,
      NavigationItem.Profile,
  )
    BottomNavigation(
        backgroundColor = Color(33,17,52),
        contentColor = Color.White
    ) {
        items.forEach {
            item -> BottomNavigationItem(
            icon = { Image(imageVector =
                item.icon ,
                contentDescription =item.title,
                modifier = Modifier.size(30.dp),
                colorFilter = ColorFilter.tint(Color.White)
            )},
            selectedContentColor = Color.White,
            unselectedContentColor = Color.White.copy(0.4f),
            alwaysShowLabel = false,
            selected = false,
            onClick = { /*TODO*/ })
        }
    }
}

