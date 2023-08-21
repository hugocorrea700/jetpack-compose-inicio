package com.github.hugocorrea700.jetpackcomposeinicio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hugocorrea700.jetpackcomposeinicio.ui.theme.JetpackcomposeinicioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackcomposeinicioTheme {
                // A surface container using the 'background' color from the theme
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}


@Composable
fun Botao(name: String,
descricao: String,
quantia: Int,) {
    val expanded = remember { mutableStateOf(false)}
    val extraPadding = if (expanded.value) 48.dp else 0.dp

    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier =
            Modifier
                .weight(1f)
                .padding(bottom = extraPadding)
            ) {
                Text(text = name)
                Text(if (expanded.value) "Qntd: $quantia" else " ")
                Text(if (expanded.value) "$descricao" else " ")

            }
            Button(
                onClick = { expanded.value = !expanded.value },
            ) {
                Text(if (expanded.value) "Ver menos" else "Ver mais")
            }
        }
    }
}

data class ItemCompra(
    val nome : String,
    val quant : Int,
    val descr : String,
)
@Composable
fun MyApp(
    modifier: Modifier = Modifier,
    listaCompra: List<ItemCompra> = listOf(
        ItemCompra(nome= "Ovo",
         quant= 4,
          descr= "Redondo e branco com leves poros na superficie",),

        ItemCompra(nome= "Melancia",
            quant= 1,
            descr= "Grande, verde, redonda e vermelha por dentro",),
        ItemCompra(nome= "Jaca",
            quant= 2,
            descr= "Grande, amarela, espinhosa e com alto poder letal",),
        ItemCompra(nome= "Mickey objeto misterioso",
            quant= 1,
            descr= "Alguma coisa chegou aqui, nao tenho ideia de o que",),
        ItemCompra(nome= "Papel Higienico",
            quant= 10000,
            descr= "Rolo de 60m de comprimento com papel branco áspero com poder de lixa",),
)
) {
    Column(modifier = modifier.padding(vertical = 4.dp)) {
        for (name in listaCompra) {
            Botao(name = name.nome,
                quantia = name.quant,
                descricao = name.descr)
        }
    }
}



@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    JetpackcomposeinicioTheme {
        MyApp(
        )
    }
}



@Preview
@Composable
fun MyAppPreview() {
    JetpackcomposeinicioTheme {
        MyApp(Modifier.fillMaxSize())
    }
}


