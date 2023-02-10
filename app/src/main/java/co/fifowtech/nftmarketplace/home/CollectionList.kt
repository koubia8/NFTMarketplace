package co.fifowtech.nftmarketplace.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.fifowtech.nftmarketplace.models.categories
import co.fifowtech.nftmarketplace.models.collections
import co.fifowtech.nftmarketplace.ui.theme.NFTMarketplaceTheme

@Composable
fun CollectionList() {
    LazyRow(
        modifier = Modifier.padding(vertical = 30.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(collections) {
                collection ->   CollectionCard(
            title = collection.title,
            image = painterResource(id = collection.image),
            likes = collection.likes
        )
        }
    }
}

@Preview
@Composable
fun PreviewCollectionList() {
    NFTMarketplaceTheme {
        CollectionList()
    }
}