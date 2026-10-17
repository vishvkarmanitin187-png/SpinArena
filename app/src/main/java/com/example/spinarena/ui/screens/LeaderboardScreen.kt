package com.example.spinarena.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spinarena.data.SpinRepository
import com.example.spinarena.ui.theme.*

@Composable
fun LeaderboardScreen() {
    val leaderboard by SpinRepository.leaderboard.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackground)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(8.dp))
            Text("Global Leaderboard", color = TextPrimary, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text("Top gamers ranked by virtual coins and XP", color = TextSecondary, fontSize = 13.sp)
        }

        items(leaderboard) { entry ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = DarkSurface)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(
                                    when (entry.rank) {
                                        1 -> NeonGold.copy(alpha = 0.2f)
                                        2 -> CyberCyan.copy(alpha = 0.2f)
                                        else -> DarkSurfaceElevated
                                    }
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "#${entry.rank}",
                                color = when (entry.rank) {
                                    1 -> NeonGold
                                    2 -> CyberCyan
                                    else -> TextPrimary
                                },
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp
                            )
                        }
                        Column {
                            Text(entry.username, color = TextPrimary, fontWeight = FontWeight.Bold, fontSize = 15.sp)
                            Text("Level ${entry.xp / 100}", color = TextSecondary, fontSize = 11.sp)
                        }
                    }

                    Column(horizontalAlignment = Alignment.End) {
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                            Icon(Icons.Default.MonetizationOn, contentDescription = null, tint = NeonGold, modifier = Modifier.size(16.dp))
                            Text("%,d".format(entry.coins), color = NeonGold, fontWeight = FontWeight.Bold, fontSize = 15.sp)
                        }
                        Text("${entry.xp} XP", color = CyberCyan, fontSize = 11.sp)
                    }
                }
            }
        }
    }
}
