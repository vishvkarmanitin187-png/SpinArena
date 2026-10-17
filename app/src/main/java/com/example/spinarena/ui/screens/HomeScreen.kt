package com.example.spinarena.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spinarena.data.GameItem
import com.example.spinarena.data.SpinRepository
import com.example.spinarena.ui.theme.*

@Composable
fun HomeScreen(
    onNavigateToGames: () -> Unit,
    onPlayGame: (GameItem) -> Unit
) {
    val profile by SpinRepository.userProfile.collectAsState()
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

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackground)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Top Profile Section
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    Box(
                        modifier = Modifier
                            .size(44.dp)
                            .clip(CircleShape)
                            .background(NeonGold),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(profile.username.take(1), color = DarkBackground, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    }
                    Column {
                        Text(profile.username, color = TextPrimary, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                        Text("Level ${profile.xpLevel} • XP ${profile.currentXp}/${profile.maxXp}", color = TextSecondary, fontSize = 11.sp)
                    }
                }
                Surface(
                    shape = RoundedCornerShape(20.dp),
                    color = DarkSurfaceElevated,
                    border = BorderStroke(1.dp, NeonGold.copy(alpha = 0.5f))
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Icon(Icons.Default.MonetizationOn, contentDescription = null, tint = NeonGold, modifier = Modifier.size(16.dp))
                        Text("%,d".format(profile.virtualCoins), color = NeonGold, fontSize = 13.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }

        // Search Bar
        item {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text("Search 30 3D games...", color = TextSecondary) },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = TextSecondary) },
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("gamezone_search"),
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
        }

        // Featured Banner
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(
                        Brush.linearGradient(
                            colors = listOf(ElectricViolet, CyberCyan, DarkSurface)
                        )
                    )
                    .clickable { onPlayGame(allGames.first()) }
                    .padding(20.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Column {
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = NeonGold
                    ) {
                        Text(
                            text = "FEATURED 3D",
                            color = DarkBackground,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("3D Car Racing Championship", color = TextPrimary, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text("High-speed 3D formula racing with realistic physics", color = TextPrimary.copy(alpha = 0.8f), fontSize = 12.sp)
                }
            }
        }

        // Categories Filter
        item {
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
        }

        // Section Header
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Popular 3D Games (${filteredGames.size})", color = TextPrimary, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                TextButton(onClick = onNavigateToGames) {
                    Text("View All", color = CyberCyan, fontWeight = FontWeight.Bold)
                }
            }
        }

        // 3-Column Responsive Game-Card Grid (using chunks of 2 for card row layout)
        item {
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                filteredGames.chunked(2).forEach { rowGames ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        rowGames.forEach { game ->
                            Card(
                                modifier = Modifier
                                    .weight(1f)
                                    .height(180.dp)
                                    .clickable { onPlayGame(game) }
                                    .testTag("game_card_${game.id}"),
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
                                                .clip(RoundedCornerShape(10.dp)),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Icon(Icons.Default.SportsEsports, contentDescription = null, tint = NeonGold, modifier = Modifier.size(24.dp))
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
                                        Text(game.title, color = TextPrimary, fontWeight = FontWeight.Bold, fontSize = 13.sp, maxLines = 1)
                                        Spacer(modifier = Modifier.height(2.dp))
                                        Text(game.description, color = TextSecondary, fontSize = 10.sp, maxLines = 2)
                                    }

                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                                            Icon(Icons.Default.MonetizationOn, contentDescription = null, tint = NeonGold, modifier = Modifier.size(12.dp))
                                            Text("+${game.coinReward}", color = NeonGold, fontSize = 11.sp, fontWeight = FontWeight.Bold)
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
                                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                        if (rowGames.size == 1) {
                            Spacer(modifier = Modifier.weight(1f))
                        }
                    }
                }
            }
        }
        item { Spacer(modifier = Modifier.height(24.dp)) }
    }
}
