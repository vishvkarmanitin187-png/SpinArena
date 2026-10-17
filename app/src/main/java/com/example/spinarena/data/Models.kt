package com.example.spinarena.data

data class UserProfile(
    val userId: String = "usr_948291",
    val username: String = "CyberGamer99",
    val email: String = "gamer@gamezone3d.io",
    val avatarUrl: String = "",
    val virtualCoins: Int = 2500,
    val xpLevel: Int = 14,
    val currentXp: Int = 340,
    val maxXp: Int = 500,
    val dailyStreak: Int = 5
)

data class GameItem(
    val id: String,
    val title: String,
    val category: String, // Arcade, Racing, Sports, Puzzle, Adventure
    val description: String,
    val iconName: String,
    val rating: Double,
    val playCount: Int,
    val coinReward: Int
)

data class MissionItem(
    val id: String,
    val title: String,
    val rewardCoins: Int,
    val rewardXp: Int,
    val isCompleted: Boolean
)

data class LeaderboardEntry(
    val rank: Int,
    val username: String,
    val coins: Int,
    val xp: Int
)
