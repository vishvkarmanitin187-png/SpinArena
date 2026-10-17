package com.example.spinarena.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spinarena.data.GameItem
import com.example.spinarena.data.SpinRepository
import com.example.spinarena.ui.games.*
import com.example.spinarena.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GamePlayScreen(
    game: GameItem,
    onBack: () -> Unit
) {
    var sessionCompleted by remember { mutableStateOf(false) }
    var coinsEarned by remember { mutableIntStateOf(game.coinReward) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(game.title, color = TextPrimary, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = TextPrimary)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = DarkSurface)
            )
        },
        containerColor = DarkBackground
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(DarkBackground)
        ) {
            if (sessionCompleted) {
                Column(
                    modifier = Modifier.fillMaxSize().padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text("Victory! Game Complete", color = TextPrimary, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Icon(Icons.Default.MonetizationOn, contentDescription = null, tint = NeonGold, modifier = Modifier.size(28.dp))
                        Text("+${coinsEarned} Virtual Coins", color = NeonGold, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Text("+50 XP Added to Profile", color = CyberCyan, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(28.dp))
                    Button(onClick = onBack, colors = ButtonDefaults.buttonColors(containerColor = NeonGold)) {
                        Text("Return to Lobby", color = DarkBackground, fontWeight = FontWeight.Bold)
                    }
                }
            } else {
                val onFinishHandler: (Double) -> Unit = { prize ->
                    coinsEarned = prize.toInt()
                    sessionCompleted = true
                    SpinRepository.recordGameScore(game.title, coinsEarned, 50)
                }

                when (game.id) {
                    "game_1" -> CarRacingGame(onFinishHandler)
                    "game_2" -> BikeRacingGame(onFinishHandler)
                    "game_3" -> TruckDrivingGame(onFinishHandler)
                    "game_4" -> Football3DGame(onFinishHandler)
                    "game_5" -> Basketball3DGame(onFinishHandler)
                    "game_6" -> Bowling3DGame(onFinishHandler)
                    "game_7" -> Archery3DGame(onFinishHandler)
                    "game_8" -> ShootingGalleryGame(onFinishHandler)
                    "game_9" -> Maze3DGame(onFinishHandler)
                    "game_10" -> EndlessRunnerGame(onFinishHandler)
                    "game_11" -> PlatformAdventureGame(onFinishHandler)
                    "game_12" -> SpaceAdventureGame(onFinishHandler)
                    "game_13" -> BoatRacingGame(onFinishHandler)
                    "game_14" -> SkiingGame(onFinishHandler)
                    "game_15" -> Golf3DGame(onFinishHandler)
                    "game_16" -> TennisGame(onFinishHandler)
                    "game_17" -> BoxingGame(onFinishHandler)
                    "game_18" -> PuzzleGame(onFinishHandler)
                    "game_19" -> MemoryGame(onFinishHandler)
                    "game_20" -> TowerDefenseGame(onFinishHandler)
                    "game_21" -> ObstacleRunGame(onFinishHandler)
                    "game_22" -> TreasureHuntGame(onFinishHandler)
                    "game_23" -> RobotArenaGame(onFinishHandler)
                    "game_24" -> DinosaurGame(onFinishHandler)
                    "game_25" -> CityDrivingGame(onFinishHandler)
                    "game_26" -> FootballPenaltyGame(onFinishHandler)
                    "game_27" -> BasketballChallengeGame(onFinishHandler)
                    "game_28" -> FruitCatchGame(onFinishHandler)
                    "game_29" -> ColorMatchGame(onFinishHandler)
                    else -> EndlessRunnerGame(onFinishHandler)
                }
            }
        }
    }
}

// Additional unique game simulation components for GameZone 3D
@Composable
fun ShootingGalleryGame(onFinish: (Double) -> Unit) {
    var hits by remember { mutableIntStateOf(0) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Shooting Gallery", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Text("Hits: $hits / 5", color = NeonGold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {
            hits++
            if (hits >= 5) onFinish(130.0)
        }, colors = ButtonDefaults.buttonColors(containerColor = NeonGold)) {
            Text("SHOOT TARGET", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun SpaceAdventureGame(onFinish: (Double) -> Unit) {
    var warped by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Space Adventure", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { warped = true; onFinish(160.0) }, enabled = !warped, colors = ButtonDefaults.buttonColors(containerColor = CyberCyan)) {
            Text("Warp Galaxy", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun SkiingGame(onFinish: (Double) -> Unit) {
    var downhill by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Mountain Skiing", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { downhill = true; onFinish(120.0) }, enabled = !downhill, colors = ButtonDefaults.buttonColors(containerColor = SuccessGreen)) {
            Text("Slalom Downhill", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun TennisGame(onFinish: (Double) -> Unit) {
    var rallied by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Court Tennis", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { rallied = true; onFinish(140.0) }, enabled = !rallied, colors = ButtonDefaults.buttonColors(containerColor = NeonGold)) {
            Text("Serve & Volley", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun BoxingGame(onFinish: (Double) -> Unit) {
    var trained by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Boxing Training", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { trained = true; onFinish(110.0) }, enabled = !trained, colors = ButtonDefaults.buttonColors(containerColor = ErrorRed)) {
            Text("Heavy Bag Combo", color = TextPrimary, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun PuzzleGame(onFinish: (Double) -> Unit) {
    var solved by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Geometric Puzzle", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { solved = true; onFinish(125.0) }, enabled = !solved, colors = ButtonDefaults.buttonColors(containerColor = CyberCyan)) {
            Text("Assemble Blocks", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun MemoryGame(onFinish: (Double) -> Unit) {
    var remembered by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Memory Grid", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { remembered = true; onFinish(115.0) }, enabled = !remembered, colors = ButtonDefaults.buttonColors(containerColor = SuccessGreen)) {
            Text("Recall Sequence", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun TowerDefenseGame(onFinish: (Double) -> Unit) {
    var defended by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Tower Defense", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { defended = true; onFinish(180.0) }, enabled = !defended, colors = ButtonDefaults.buttonColors(containerColor = NeonGold)) {
            Text("Deploy Turrets", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun RobotArenaGame(onFinish: (Double) -> Unit) {
    var victored by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Robot Mecha Arena", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { victored = true; onFinish(170.0) }, enabled = !victored, colors = ButtonDefaults.buttonColors(containerColor = CyberCyan)) {
            Text("Mecha Battle", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun DinosaurGame(onFinish: (Double) -> Unit) {
    var survived by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Dinosaur Jurassic Safari", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { survived = true; onFinish(150.0) }, enabled = !survived, colors = ButtonDefaults.buttonColors(containerColor = SuccessGreen)) {
            Text("Explore Jungle", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun FootballPenaltyGame(onFinish: (Double) -> Unit) {
    var scored by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Football Penalty Shootout", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { scored = true; onFinish(140.0) }, enabled = !scored, colors = ButtonDefaults.buttonColors(containerColor = NeonGold)) {
            Text("Score Penalty", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun BasketballChallengeGame(onFinish: (Double) -> Unit) {
    var dunked by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Basketball Buzzer Beater", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { dunked = true; onFinish(135.0) }, enabled = !dunked, colors = ButtonDefaults.buttonColors(containerColor = SuccessGreen)) {
            Text("Throw 3-Pointer", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun FruitCatchGame(onFinish: (Double) -> Unit) {
    var caught by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Fruit Catch Basket", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { caught = true; onFinish(110.0) }, enabled = !caught, colors = ButtonDefaults.buttonColors(containerColor = NeonGold)) {
            Text("Catch Fruits", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun ColorMatchGame(onFinish: (Double) -> Unit) {
    var matched by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Color Shape Match", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { matched = true; onFinish(100.0) }, enabled = !matched, colors = ButtonDefaults.buttonColors(containerColor = CyberCyan)) {
            Text("Match Colors", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}
