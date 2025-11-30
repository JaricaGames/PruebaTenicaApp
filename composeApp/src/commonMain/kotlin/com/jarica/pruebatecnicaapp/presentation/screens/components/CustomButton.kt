package com.jarica.pruebatecnicaapp.presentation.screens.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jarica.pruebatecnicaapp.presentation.Blue
import com.jarica.pruebatecnicaapp.presentation.Grey
import com.jarica.pruebatecnicaapp.presentation.Red

@Composable
fun CustomButton(
    modifier: Modifier,
    text: String,
    onClick: () -> Unit
){
    Button(
        shape = RoundedCornerShape(8.dp),
        colors = ButtonColors(
            containerColor = Grey,
            contentColor = Red,
            disabledContainerColor = Grey,
            disabledContentColor = Red
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .border(
                width = 3.dp,
                color = Red,
                shape = RoundedCornerShape(8.dp)),
        onClick = onClick){

        Text(text = text, color = Blue)
    }
}
