package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.spinarena.data.GameItem
import com.example.spinarena.ui.screens.*
import com.example.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                GameZoneApp()
            }
        }
    }
}

@Composable
fun GameZoneApp() {
    var currentTab by remember { mutableStateOf("home") } // home, games, missions, leaderboard, profile
    var inGamePlay by remember { mutableStateOf(false) }
    var selectedGame by remember { mutableStateOf<GameItem?>(null) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (!inGamePlay) {
                NavigationBar(
                    containerColor = MaterialTheme.colorScheme.surface,
                    tonalElevation = 8.dp
                ) {
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                        label = { Text("Home") },
                        selected = currentTab == "home",
                        onClick = { currentTab = "home" },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.primary,
                            selectedTextColor = MaterialTheme.colorScheme.primary,
                            unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                            unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.SportsEsports, contentDescription = "Games") },
                        label = { Text("Games") },
                        selected = currentTab == "games",
                        onClick = { currentTab = "games" },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.primary,
                            selectedTextColor = MaterialTheme.colorScheme.primary,
                            unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                            unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.EmojiEvents, contentDescription = "Missions") },
                        label = { Text("Missions") },
                        selected = currentTab == "missions",
                        onClick = { currentTab = "missions" },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.primary,
                            selectedTextColor = MaterialTheme.colorScheme.primary,
                            unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                            unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Leaderboard, contentDescription = "Leaderboard") },
                        label = { Text("Leaderboard") },
                        selected = currentTab == "leaderboard",
                        onClick = { currentTab = "leaderboard" },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.primary,
                            selectedTextColor = MaterialTheme.colorScheme.primary,
                            unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                            unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                        label = { Text("Profile") },
                        selected = currentTab == "profile",
                        onClick = { currentTab = "profile" },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.primary,
                            selectedTextColor = MaterialTheme.colorScheme.primary,
                            unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                            unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            if (inGamePlay && selectedGame != null) {
                GamePlayScreen(
                    game = selectedGame!!,
                    onBack = {
                        inGamePlay = false
                        selectedGame = null
                    }
                )
            } else {
                when (currentTab) {
                    "home" -> HomeScreen(
                        onNavigateToGames = { currentTab = "games" },
                        onPlayGame = { game ->
                            selectedGame = game
                            inGamePlay = true
                        }
                    )
                    "games" -> GamesScreen(
                        onPlayGame = { game ->
                            selectedGame = game
                            inGamePlay = true
                        }
                    )
                    "missions" -> MissionsScreen()
                    "leaderboard" -> LeaderboardScreen()
                    "profile" -> ProfileScreen()
                }
            }
        }
    }
}
