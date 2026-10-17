package com.example.spinarena.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SportsEsports
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spinarena.data.GameItem
import com.example.spinarena.data.SpinRepository
import com.example.spinarena.ui.theme.*

@Composable
fun GamesScreen(
    onPlayGame: (GameItem) -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("All") }

    val categories = listOf("All", "Arcade", "Racing", "Sports", "Puzzle", "Adventure")
    val allGames = SpinRepository.gamesList

    val filteredGames = allGames.filter { game ->
        val matchesSearch = game.title.contains(searchQuery, ignoreCase = true) ||
                game.description.contains(searchQuery, ignoreCase = true)
        val matchesCat = selectedCategory == "All" || game.category.equals(selectedCategory, ignoreCase = true)
        matchesSearch && matchesCat
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackground)
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Text("30 3D Game Library", color = TextPrimary, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text("Immersive 3D webgl simulations", color = TextSecondary, fontSize = 13.sp)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("Search all 30 games...", color = TextSecondary) },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = TextSecondary) },
            modifier = Modifier
                .fillMaxWidth()
                .testTag("games_search"),
            shape = RoundedCornerShape(14.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = NeonGold,
                unfocusedBorderColor = DarkSurfaceElevated,
                focusedContainerColor = DarkSurface,
                unfocusedContainerColor = DarkSurface,
                cursorColor = NeonGold,
                focusedTextColor = TextPrimary,
                unfocusedTextColor = TextPrimary
            ),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(12.dp))

        ScrollableTabRow(
            selectedTabIndex = categories.indexOf(selectedCategory),
            containerColor = DarkBackground,
            edgePadding = 0.dp,
            indicator = {},
            divider = {}
        ) {
            categories.forEach { cat ->
                val isSelected = selectedCategory == cat
                Surface(
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .clickable { selectedCategory = cat },
                    shape = RoundedCornerShape(20.dp),
                    color = if (isSelected) NeonGold else DarkSurfaceElevated
                ) {
                    Text(
                        text = cat,
                        color = if (isSelected) DarkBackground else TextPrimary,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(filteredGames) { game ->
                Card(
                    modifier = Modifier
                        .height(190.dp)
                        .clickable { onPlayGame(game) }
                        .testTag("game_item_${game.id}"),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = DarkSurface)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(12.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(36.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(NeonGold.copy(alpha = 0.2f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(Icons.Default.SportsEsports, contentDescription = null, tint = NeonGold, modifier = Modifier.size(20.dp))
                            }
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = CyberCyan.copy(alpha = 0.15f)
                            ) {
                                Text(
                                    text = game.category,
                                    color = CyberCyan,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                )
                            }
                        }

                        Column {
                            Text(game.title, color = TextPrimary, fontWeight = FontWeight.Bold, fontSize = 14.sp, maxLines = 1)
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(game.description, color = TextSecondary, fontSize = 11.sp, maxLines = 2)
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                                Icon(Icons.Default.MonetizationOn, contentDescription = null, tint = NeonGold, modifier = Modifier.size(14.dp))
                                Text("+${game.coinReward}", color = NeonGold, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                            }
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = NeonGold
                            ) {
                                Text(
                                    text = "PLAY",
                                    color = DarkBackground,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
