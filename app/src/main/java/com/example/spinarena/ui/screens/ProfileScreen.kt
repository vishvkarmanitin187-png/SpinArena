package com.example.spinarena.ui.screens

import androidx.compose.foundation.background
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spinarena.data.SpinRepository
import com.example.spinarena.ui.theme.*

@Composable
fun ProfileScreen() {
    val profile by SpinRepository.userProfile.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackground)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(8.dp))
            Text("Gamer Profile", color = TextPrimary, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text("Virtual currency, stats and progress", color = TextSecondary, fontSize = 13.sp)
        }

        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = DarkSurface)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .size(70.dp)
                            .clip(CircleShape)
                            .background(NeonGold),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(profile.username.take(1), color = DarkBackground, fontWeight = FontWeight.Bold, fontSize = 32.sp)
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(profile.username, color = TextPrimary, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                        Text(profile.email, color = TextSecondary, fontSize = 12.sp)
                    }

                    Surface(
                        shape = RoundedCornerShape(14.dp),
                        color = DarkSurfaceElevated,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceAround,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text("Virtual Coins", color = TextSecondary, fontSize = 11.sp)
                                Spacer(modifier = Modifier.height(4.dp))
                                Text("%,d".format(profile.virtualCoins), color = NeonGold, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                            }
                            Divider(modifier = Modifier.height(30.dp).width(1.dp), color = DarkBackground)
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text("XP Level", color = TextSecondary, fontSize = 11.sp)
                                Spacer(modifier = Modifier.height(4.dp))
                                Text("Level ${profile.xpLevel}", color = CyberCyan, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                            }
                            Divider(modifier = Modifier.height(30.dp).width(1.dp), color = DarkBackground)
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text("Daily Streak", color = TextSecondary, fontSize = 11.sp)
                                Spacer(modifier = Modifier.height(4.dp))
                                Text("${profile.dailyStreak} Days", color = SuccessGreen, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                            }
                        }
                    }
                }
            }
        }

        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = DarkSurface)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text("Game Settings", color = TextPrimary, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Low-End Android Graphics Mode", color = TextSecondary, fontSize = 13.sp)
                        Switch(
                            checked = true,
                            onCheckedChange = {},
                            colors = SwitchDefaults.colors(checkedThumbColor = DarkBackground, checkedTrackColor = SuccessGreen)
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Sound & SFX", color = TextSecondary, fontSize = 13.sp)
                        Switch(
                            checked = true,
                            onCheckedChange = {},
                            colors = SwitchDefaults.colors(checkedThumbColor = DarkBackground, checkedTrackColor = SuccessGreen)
                        )
                    }
                }
            }
        }
    }
}
