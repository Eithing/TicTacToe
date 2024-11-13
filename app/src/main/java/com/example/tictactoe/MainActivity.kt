package com.example.tictactoe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tictactoe.ui.theme.TicTacToeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TicTacToeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TicTacToeGame(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun TicTacToeGame(modifier: Modifier = Modifier) {
    var board by remember { mutableStateOf(List(3) { MutableList(3) { "" } }) }
    var currentPlayer by remember { mutableStateOf("X") }
    var winner by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = winner?.let { "$it wins!" } ?: "Player $currentPlayer's turn",
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )

        board.forEachIndexed { rowIndex, row ->
            Row {
                row.forEachIndexed { colIndex, cell ->
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .background(Color.LightGray)
                            .clickable {
                                if (cell.isEmpty() && winner == null) {
                                    board = board.mapIndexed { r, row ->
                                        row.mapIndexed { c, cellValue ->
                                            if (r == rowIndex && c == colIndex) currentPlayer else cellValue
                                        }.toMutableList()
                                    }
                                    winner = checkWinner(board)
                                    if (winner == null) {
                                        currentPlayer = if (currentPlayer == "X") "O" else "X"
                                    }
                                }
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = cell, fontSize = 36.sp)
                    }
                }
            }
        }
    }
}

fun checkWinner(board: List<List<String>>): String? {
    // Check rows, columns, and diagonals
    val lines = listOf(
        // Rows
        listOf(board[0][0], board[0][1], board[0][2]),
        listOf(board[1][0], board[1][1], board[1][2]),
        listOf(board[2][0], board[2][1], board[2][2]),
        // Columns
        listOf(board[0][0], board[1][0], board[2][0]),
        listOf(board[0][1], board[1][1], board[2][1]),
        listOf(board[0][2], board[1][2], board[2][2]),
        // Diagonals
        listOf(board[0][0], board[1][1], board[2][2]),
        listOf(board[0][2], board[1][1], board[2][0])
    )
    for (line in lines) {
        if (line[0].isNotEmpty() && line[0] == line[1] && line[1] == line[2]) {
            return line[0]
        }
    }
    return null
}

@Preview(showBackground = true)
@Composable
fun TicTacToeGamePreview() {
    TicTacToeTheme {
        TicTacToeGame()
    }
}