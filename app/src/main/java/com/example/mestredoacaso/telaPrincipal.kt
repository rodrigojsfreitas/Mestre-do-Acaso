package com.example.mestredoacaso
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Definição de cores para fácil reutilização
val backgroundColor = Color(0xFFF8EFF4)
val buttonColor = Color(0xFFC5B8C0)
val primaryTextColor = Color(0xFF333333)
val buttonTextColor = Color.White
val letraColuna = arrayOf("A", "B", "C", "D", "E", "F", "G", "H")
@Composable
fun MinhaTela(padding: PaddingValues = PaddingValues(0.dp)) {
    // Surface é um container que nos permite definir a cor de fundo
    var numerolinha by remember { mutableIntStateOf(0) }
    var numerocoluna by remember { mutableIntStateOf(1) }
    Surface(
        modifier = Modifier.fillMaxSize() .padding(padding),
        color = backgroundColor
    ) {
        Box(Modifier.fillMaxSize()){
        Text(
            text = "Posição:",
            style = TextStyle(
                fontSize = 48.sp,
                fontFamily = FontFamily(Font(R.font.raleway)),
                fontWeight = FontWeight(400),
                color = Color(0xFF4D404E),

                ),
            modifier = Modifier.align(Alignment.TopCenter) .padding(top = 160.dp)
        )
        // Column organiza os elementos filhos na vertical
        Column(
            // Ocupa todo o espaço disponível
            modifier = Modifier.fillMaxSize(),
            // Alinha os filhos no centro vertical da Column
            verticalArrangement = Arrangement.Center,
            // Alinha os filhos no centro horizontal da Column
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Primeiro texto: "Posição:"


            // Espaçamento vertical entre os textos

            // Segundo texto, maior: "C2"
            Text(
                    text = letraColuna[numerolinha] + numerocoluna,
                    style = TextStyle(
                        fontSize = 64.sp,
                        fontFamily = FontFamily(Font(R.font.raleway)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF4D404E),

                        )
            )

            // Espaçamento vertical entre o texto e o botão
            Spacer(modifier = Modifier.height(100.dp))

            // Botão "lançar"
            Button(
                onClick = { numerolinha = (0..7).random(); numerocoluna = (1..8).random() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFA697A7), // Cor de fundo do botão
                    contentColor = buttonTextColor // Cor do texto dentro do botão
                ),
                // Adiciona um padding horizontal para deixar o botão mais largo
                shape = RoundedCornerShape(size = 20.dp),
                modifier = Modifier.padding(horizontal = 32.dp) .shadow(4.dp , shape = RoundedCornerShape(size = 20.dp)),
                contentPadding = PaddingValues(5.dp,5.dp)
            ) {
                    Text(
                        text = "lançar",
                        style = TextStyle(
                            fontSize = 32.sp,
                            fontFamily = FontFamily(Font(R.font.dm_sans)),
                            fontWeight = FontWeight(700),
                            color = Color(0xFFFFEEFF),

                            )
                    )
            }
        }
    }
    }
}

// Anotação para visualizar o Composable no Android Studio
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MinhaTela()
}