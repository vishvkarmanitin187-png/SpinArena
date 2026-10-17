package com.example.spinarena.ui.games

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spinarena.ui.theme.*

// 11. 3D Golf
@Composable
fun Golf3DGame(onFinish: (Double) -> Unit) {
    var putted by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Mini Golf", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { putted = true; onFinish(90.0) }, enabled = !putted, colors = ButtonDefaults.buttonColors(containerColor = SuccessGreen)) {
            Text("PUTT GOLF BALL", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}

// 12. 3D Archery
@Composable
fun Archery3DGame(onFinish: (Double) -> Unit) {
    var shot by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Archery Bullseye", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { shot = true; onFinish(110.0) }, enabled = !shot, colors = ButtonDefaults.buttonColors(containerColor = NeonGold)) {
            Text("RELEASE ARROW", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}

// 13. 3D Platform Adventure
@Composable
fun PlatformAdventureGame(onFinish: (Double) -> Unit) {
    var completed by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Platform Adventure", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { completed = true; onFinish(125.0) }, enabled = !completed, colors = ButtonDefaults.buttonColors(containerColor = CyberCyan)) {
            Text("Complete Stage", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}

// 14. 3D Coin Collection
@Composable
fun CoinCollectionGame(onFinish: (Double) -> Unit) {
    var collected by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Coin Rush", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { collected = true; onFinish(75.0) }, enabled = !collected, colors = ButtonDefaults.buttonColors(containerColor = NeonGold)) {
            Text("Collect Gold Coins", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}

// 15. 3D Treasure Hunt
@Composable
fun TreasureHuntGame(onFinish: (Double) -> Unit) {
    var found by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Treasure Island", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { found = true; onFinish(150.0) }, enabled = !found, colors = ButtonDefaults.buttonColors(containerColor = SuccessGreen)) {
            Text("Unearth Chest", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}

// 16. 3D Parkour
@Composable
fun Parkour3DGame(onFinish: (Double) -> Unit) {
    var leaped by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Rooftop Parkour", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { leaped = true; onFinish(95.0) }, enabled = !leaped, colors = ButtonDefaults.buttonColors(containerColor = CyberCyan)) {
            Text("Rooftop Leap", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}

// 17. 3D Boat Racing
@Composable
fun BoatRacingGame(onFinish: (Double) -> Unit) {
    var raced by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Speedboat Regatta", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { raced = true; onFinish(130.0) }, enabled = !raced, colors = ButtonDefaults.buttonColors(containerColor = NeonGold)) {
            Text("Accelerate Boat", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}

// 18. 3D Airplane Flying
@Composable
fun AirplaneFlyingGame(onFinish: (Double) -> Unit) {
    var landed by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Flight Simulator", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { landed = true; onFinish(180.0) }, enabled = !landed, colors = ButtonDefaults.buttonColors(containerColor = SuccessGreen)) {
            Text("Land Aircraft", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}

// 19. 3D Space Runner
@Composable
fun SpaceRunnerGame(onFinish: (Double) -> Unit) {
    var warped by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Space Asteroid Runner", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { warped = true; onFinish(140.0) }, enabled = !warped, colors = ButtonDefaults.buttonColors(containerColor = CyberCyan)) {
            Text("Warp Speed", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}

// 20. 3D Island Adventure
@Composable
fun IslandAdventureGame(onFinish: (Double) -> Unit) {
    var explored by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Island Explorer", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { explored = true; onFinish(110.0) }, enabled = !explored, colors = ButtonDefaults.buttonColors(containerColor = NeonGold)) {
            Text("Explore Ruins", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}
