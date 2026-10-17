package com.example.spinarena.data

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

object SpinRepository {
    private val _userProfile = MutableStateFlow(UserProfile())
    val userProfile: StateFlow<UserProfile> = _userProfile.asStateFlow()

    private val _missions = MutableStateFlow<List<MissionItem>>(
        listOf(
            MissionItem("m_1", "Play 3 different 3D games", 150, 50, false),
            MissionItem("m_2", "Win a Racing match", 200, 80, true),
            MissionItem("m_3", "Reach Level 15", 500, 200, false),
            MissionItem("m_4", "Complete daily check-in", 100, 30, true)
        )
    )
    val missions: StateFlow<List<MissionItem>> = _missions.asStateFlow()

    private val _leaderboard = MutableStateFlow<List<LeaderboardEntry>>(
        listOf(
            LeaderboardEntry(1, "CyberKingX", 45200, 1420),
            LeaderboardEntry(2, "PixelMaster", 38900, 1280),
            LeaderboardEntry(3, "NeonRacer", 34500, 1150),
            LeaderboardEntry(4, "CyberGamer99", 25000, 840),
            LeaderboardEntry(5, "SpeedDemon", 21800, 720)
        )
    )
    val leaderboard: StateFlow<List<LeaderboardEntry>> = _leaderboard.asStateFlow()

    // Exactly 30 Genuinely Different 3D Games
    val gamesList: List<GameItem> = listOf(
        GameItem("game_1", "3D Car Racing", "Racing", "High-speed 3D formula racing simulation", "SportsEsports", 4.8, 1420, 150),
        GameItem("game_2", "3D Bike Racing", "Racing", "Extreme motocross dirt bike stunts", "SportsEsports", 4.7, 1120, 140),
        GameItem("game_3", "3D Truck Driving", "Racing", "Heavy cargo rig highway transport", "LocalShipping", 4.5, 980, 130),
        GameItem("game_4", "3D Football", "Sports", "Stadium championship penalty & free kick", "Sports", 4.9, 2100, 180),
        GameItem("game_5", "3D Basketball", "Sports", "Hoop dunk and 3-point shootout", "SportsBasketball", 4.8, 1850, 160),
        GameItem("game_6", "3D Bowling", "Sports", "Alley strike bowling challenge", "SportsCricket", 4.6, 940, 120),
        GameItem("game_7", "3D Archery", "Sports", "Bullseye precision target shooting", "TrackChanges", 4.7, 1250, 140),
        GameItem("game_8", "3D Shooting Gallery", "Arcade", "Target gallery with harmless laser blasters", "GpsFixed", 4.5, 1600, 130),
        GameItem("game_9", "3D Maze", "Puzzle", "Escape complex 3D cyberpunk labyrinths", "Grid", 4.4, 870, 110),
        GameItem("game_10", "3D Runner", "Arcade", "Endless neon skyline obstacle dash", "Run", 4.9, 3200, 200),
        GameItem("game_11", "3D Platformer", "Adventure", "Platform jumping and crystal collection", "Landscape", 4.8, 1750, 160),
        GameItem("game_12", "3D Space Adventure", "Adventure", "Asteroid dodging in deep cosmos", "RocketLaunch", 4.9, 2400, 190),
        GameItem("game_13", "3D Boat Racing", "Racing", "Speedboat regatta water championship", "DirectionsBoat", 4.6, 990, 130),
        GameItem("game_14", "3D Skiing", "Sports", "Snowy mountain downhill slalom", "Snowboarding", 4.7, 1100, 140),
        GameItem("game_15", "3D Golf", "Sports", "Mini golf putting green adventure", "GolfCourse", 4.5, 850, 120),
        GameItem("game_16", "3D Tennis", "Sports", "Court tennis rally championship", "SportsTennis", 4.7, 1340, 150),
        GameItem("game_17", "3D Boxing training", "Sports", "Punching bag reflex training", "FitnessCenter", 4.6, 920, 120),
        GameItem("game_18", "3D Puzzle", "Puzzle", "Rotate and assemble 3D geometric blocks", "Extension", 4.5, 780, 110),
        GameItem("game_19", "3D Memory Game", "Puzzle", "Recall glowing 3D tile sequences", "Memory", 4.7, 1050, 130),
        GameItem("game_20", "3D Tower Defense", "Puzzle", "Place defense turrets against drone waves", "Security", 4.9, 2800, 210),
        GameItem("game_21", "3D Obstacle Course", "Adventure", "Wipeout style hazard obstacle run", "FlashOn", 4.7, 1620, 150),
        GameItem("game_22", "3D Treasure Adventure", "Adventure", "Unearth ancient temple artifacts", "CardGift", 4.8, 1900, 170),
        GameItem("game_23", "3D Robot Arena", "Arcade", "Mecha battle combat simulator", "SmartToy", 4.9, 2500, 190),
        GameItem("game_24", "3D Dinosaur Adventure", "Adventure", "Jurassic survival exploration", "Pets", 4.6, 1150, 140),
        GameItem("game_25", "3D City Driving", "Racing", "Urban traffic open-world cruising", "Drive", 4.7, 1890, 160),
        GameItem("game_26", "3D Football Penalty", "Sports", "Striker vs goalkeeper shootout", "Sports", 4.8, 2200, 170),
        GameItem("game_27", "3D Basketball Challenge", "Sports", "Timed buzzer-beater hoop challenge", "SportsBasketball", 4.7, 1650, 150),
        GameItem("game_28", "3D Fruit Catch", "Arcade", "Catch falling neon fruits in 3D basket", "LocalGroceryStore", 4.5, 1400, 130),
        GameItem("game_29", "3D Color Match", "Puzzle", "Match falling 3D shapes by color", "Palette", 4.6, 960, 120),
        GameItem("game_30", "3D Endless Runner", "Arcade", "Cyberpunk rail runner score attack", "DirectionsRun", 4.9, 3500, 220)
    )

    fun recordGameScore(gameTitle: String, coinsEarned: Int, xpEarned: Int) {
        val profile = _userProfile.value
        val newCoins = profile.virtualCoins + coinsEarned
        val newXp = profile.currentXp + xpEarned
        val newLevel = if (newXp >= profile.maxXp) profile.xpLevel + 1 else profile.xpLevel
        val adjustedXp = if (newXp >= profile.maxXp) newXp - profile.maxXp else newXp

        _userProfile.value = profile.copy(
            virtualCoins = newCoins,
            xpLevel = newLevel,
            currentXp = adjustedXp
        )
    }
}
