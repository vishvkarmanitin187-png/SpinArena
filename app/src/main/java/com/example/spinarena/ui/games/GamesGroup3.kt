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

// 21. 3D Farming Simulator
@Composable
fun Farming3DGame(onFinish: (Double) -> Unit) {
    var harvested by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Farm Tractor Harvest", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { harvested = true; onFinish(100.0) }, enabled = !harvested, colors = ButtonDefaults.buttonColors(containerColor = SuccessGreen)) {
            Text("Harvest Crops", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}

// 22. 3D Construction Simulator
@Composable
fun Construction3DGame(onFinish: (Double) -> Unit) {
    var built by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Crane Builder", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { built = true; onFinish(115.0) }, enabled = !built, colors = ButtonDefaults.buttonColors(containerColor = NeonGold)) {
            Text("Lift Steel Beam", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}

// 23. 3D Parking Challenge
@Composable
fun Parking3DGame(onFinish: (Double) -> Unit) {
    var parked by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Precision Parking", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { parked = true; onFinish(85.0) }, enabled = !parked, colors = ButtonDefaults.buttonColors(containerColor = CyberCyan)) {
            Text("Park Car", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}

// 24. 3D Traffic Challenge
@Composable
fun Traffic3DGame(onFinish: (Double) -> Unit) {
    var managed by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Junction Traffic Control", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { managed = true; onFinish(90.0) }, enabled = !managed, colors = ButtonDefaults.buttonColors(containerColor = NeonGold)) {
            Text("Manage Signals", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}

// 25. 3D Stack/Tower Challenge
@Composable
fun Stack3DGame(onFinish: (Double) -> Unit) {
    var stacked by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Tower Block Stack", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { stacked = true; onFinish(120.0) }, enabled = !stacked, colors = ButtonDefaults.buttonColors(containerColor = SuccessGreen)) {
            Text("Drop Block", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}

// 26. 3D Puzzle Adventure
@Composable
fun PuzzleAdventure3DGame(onFinish: (Double) -> Unit) {
    var solved by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Temple Relic Puzzle", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { solved = true; onFinish(135.0) }, enabled = !solved, colors = ButtonDefaults.buttonColors(containerColor = CyberCyan)) {
            Text("Unlock Relic", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}

// 27. 3D Motorcycle Stunt
@Composable
fun MotorcycleStunt3DGame(onFinish: (Double) -> Unit) {
    var flipped by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Moto Stunt Ramp", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { flipped = true; onFinish(160.0) }, enabled = !flipped, colors = ButtonDefaults.buttonColors(containerColor = NeonGold)) {
            Text("Execute Backflip", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}

// 28. 3D Bus Driving
@Composable
fun BusDriving3DGame(onFinish: (Double) -> Unit) {
    var completed by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D City Bus Transit", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { completed = true; onFinish(105.0) }, enabled = !completed, colors = ButtonDefaults.buttonColors(containerColor = SuccessGreen)) {
            Text("Drop Off Passengers", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}

// 29. 3D Target Challenge
@Composable
fun Target3DGame(onFinish: (Double) -> Unit) {
    var hit by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Sniper Target Range", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { hit = true; onFinish(110.0) }, enabled = !hit, colors = ButtonDefaults.buttonColors(containerColor = ErrorRed)) {
            Text("Fire Shot", color = TextPrimary, fontWeight = FontWeight.Bold)
        }
    }
}

// 30. 3D Cricket
@Composable
fun Cricket3DGame(onFinish: (Double) -> Unit) {
    var runScored by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("3D Stadium Cricket League", color = TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { runScored = true; onFinish(175.0) }, enabled = !runScored, colors = ButtonDefaults.buttonColors(containerColor = NeonGold)) {
            Text("Hit Sixer", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}
