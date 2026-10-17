package com.example.spinarena.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
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
fun MissionsScreen() {
    val missions by SpinRepository.missions.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackground)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(8.dp))
            Text("Daily Missions & Rewards", color = TextPrimary, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text("Complete challenges to earn virtual coins and XP", color = TextSecondary, fontSize = 13.sp)
        }

        items(missions) { mission ->
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
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(if (mission.isCompleted) SuccessGreen.copy(alpha = 0.2f) else NeonGold.copy(alpha = 0.2f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = if (mission.isCompleted) Icons.Default.CheckCircle else Icons.Default.EmojiEvents,
                                contentDescription = null,
                                tint = if (mission.isCompleted) SuccessGreen else NeonGold
                            )
                        }
                        Column {
                            Text(mission.title, color = TextPrimary, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                            Spacer(modifier = Modifier.height(4.dp))
                            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(2.dp)) {
                                    Icon(Icons.Default.MonetizationOn, contentDescription = null, tint = NeonGold, modifier = Modifier.size(14.dp))
                                    Text("+${mission.rewardCoins}", color = NeonGold, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                                }
                                Text("+${mission.rewardXp} XP", color = CyberCyan, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                            }
                        }
                    }

                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = if (mission.isCompleted) SuccessGreen.copy(alpha = 0.2f) else DarkSurfaceElevated
                    ) {
                        Text(
                            text = if (mission.isCompleted) "CLAIMED" else "IN PROGRESS",
                            color = if (mission.isCompleted) SuccessGreen else TextSecondary,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                        )
                    }
                }
            }
        }
    }
}
