package com.example.spinarena.ui.games

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spinarena.ui.theme.*
import kotlinx.coroutines.delay

// 1. 3D Car Racing Simulation
@Composable
fun CarRacingGame(onFinish: (Double) -> Unit) {
    var score by remember { mutableIntStateOf(0) }
    var carLane by remember { mutableIntStateOf(1) } // 0: Left, 1: Center, 2: Right
    var gameOver by remember { mutableStateOf(false) }

    LaunchedEffect(gameOver) {
        while (!gameOver) {
            delay(100)
            score += 10
            if (score >= 500) {
                gameOver = true
                onFinish(100.0)
            }
        }
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("3D Car Racing Arena", color = TextPrimary, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text("Score: $score", color = NeonGold, fontSize = 16.sp)
        Spacer(modifier = Modifier.height(12.dp))
        Box(modifier = Modifier.fillMaxWidth().weight(1f).background(DarkSurface).pointerInput(Unit) {
            detectDragGestures { _, dragAmount ->
                if (dragAmount.x < -20 && carLane > 0) carLane--
                if (dragAmount.x > 20 && carLane < 2) carLane++
            }
        }, contentAlignment = Alignment.BottomCenter) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val laneWidth = size.width / 3f
                val carX = laneWidth * carLane + laneWidth / 2f
                drawRect(color = CyberCyan, topLeft = Offset(carX - 25f, size.height - 100f), size = androidx.compose.ui.geometry.Size(50f, 90f))
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = { if (carLane > 0) carLane-- }, colors = ButtonDefaults.buttonColors(containerColor = CyberCyan)) { Text("LEFT", color = DarkBackground) }
            Button(onClick = { if (carLane < 2) carLane++ }, colors = ButtonDefaults.buttonColors(containerColor = CyberCyan)) { Text("RIGHT", color = DarkBackground) }
        }
    }
}

// 2. 3D Bike Racing
@Composable
fun BikeRacingGame(onFinish: (Double) -> Unit) {
    var distance by remember { mutableIntStateOf(0) }
    var finished by remember { mutableStateOf(false) }

    LaunchedEffect(finished) {
        while (!finished) {
            delay(80)
            distance += 15
            if (distance >= 600) {
                finished = true
                onFinish(120.0)
            }
        }
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Bike Stunt Racing", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Text("Distance: ${distance}m / 600m", color = NeonGold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { distance += 30 }, colors = ButtonDefaults.buttonColors(containerColor = NeonGold)) {
            Text("BOOST SPEED", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}

// 3. 3D Endless Runner
@Composable
fun EndlessRunnerGame(onFinish: (Double) -> Unit) {
    var coinsCollected by remember { mutableIntStateOf(0) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Endless Cyber Runner", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Text("Coins: $coinsCollected", color = SuccessGreen, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {
            coinsCollected += 5
            if (coinsCollected >= 25) onFinish(80.0)
        }, colors = ButtonDefaults.buttonColors(containerColor = SuccessGreen)) {
            Text("JUMP OVER OBSTACLE", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}

// 4. 3D Maze
@Composable
fun Maze3DGame(onFinish: (Double) -> Unit) {
    var escaped by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Labyrinth Maze", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { escaped = true; onFinish(90.0) }, enabled = !escaped, colors = ButtonDefaults.buttonColors(containerColor = CyberCyan)) {
            Text("Find Exit", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}

// 5. 3D Football
@Composable
fun Football3DGame(onFinish: (Double) -> Unit) {
    var goals by remember { mutableIntStateOf(0) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Penalty Shootout", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Text("Goals: $goals / 3", color = NeonGold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {
            goals++
            if (goals >= 3) onFinish(150.0)
        }, colors = ButtonDefaults.buttonColors(containerColor = NeonGold)) {
            Text("KICK BALL", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}

// 6. 3D Truck Driving
@Composable
fun TruckDrivingGame(onFinish: (Double) -> Unit) {
    var cargoDelivered by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Heavy Truck Transport", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { cargoDelivered = true; onFinish(110.0) }, enabled = !cargoDelivered, colors = ButtonDefaults.buttonColors(containerColor = SuccessGreen)) {
            Text("Deliver Cargo", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}

// 7. 3D City Driving
@Composable
fun CityDrivingGame(onFinish: (Double) -> Unit) {
    var arrived by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D City Traffic Cruiser", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { arrived = true; onFinish(95.0) }, enabled = !arrived, colors = ButtonDefaults.buttonColors(containerColor = CyberCyan)) {
            Text("Reach Destination", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}

// 8. 3D Obstacle Run
@Composable
fun ObstacleRunGame(onFinish: (Double) -> Unit) {
    var cleared by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Obstacle Course", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { cleared = true; onFinish(85.0) }, enabled = !cleared, colors = ButtonDefaults.buttonColors(containerColor = NeonGold)) {
            Text("Clear Obstacle", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}

// 9. 3D Basketball
@Composable
fun Basketball3DGame(onFinish: (Double) -> Unit) {
    var score by remember { mutableIntStateOf(0) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Hoop Shot", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Text("Score: $score", color = SuccessGreen, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            score += 2
            if (score >= 6) onFinish(100.0)
        }, colors = ButtonDefaults.buttonColors(containerColor = SuccessGreen)) {
            Text("SHOOT HOOP", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}

// 10. 3D Bowling
@Composable
fun Bowling3DGame(onFinish: (Double) -> Unit) {
    var strike by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Strike Bowling", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { strike = true; onFinish(130.0) }, enabled = !strike, colors = ButtonDefaults.buttonColors(containerColor = NeonGold)) {
            Text("ROLL BOWLING BALL", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}
