package com.example.rickandmortycompose.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.rickandmortycompose.data.dtos.ItemDto


@Composable
fun Item(title: String, imageUrl: String, modifier: Modifier = Modifier, text: String) {
    Card(modifier = Modifier.padding(10.dp)) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = imageUrl,
                contentDescription = "",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(100.dp)
                    .align(Alignment.CenterVertically)
                    .scale(1.4f)
            )
            Column(modifier = Modifier.padding(20.dp)) {
                Text(text = title, fontSize = 15.sp, color = Color.Black)
                Text(text = text, fontSize = 12.sp, color = Color.Gray)
            }
        }
    }
}

@Composable
fun ListItem(listItems: List<ItemDto>) {
    LazyColumn {
        items(listItems) {
            Item(title = it.title, imageUrl = it.image, text = it.text)
        }
    }
}
