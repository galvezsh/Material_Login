package com.galvezsh.material_login.ui.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CircleImage( id: Int, size: Dp, modifier: Modifier ) {
    Image(
        painter = painterResource( id = id ),
        contentDescription = "CircleImage",
        modifier = modifier
            .size( size )
            .shadow( elevation = 12.dp, shape = CircleShape )
            .clip( CircleShape )
    )
}

@Composable
fun SquareImage( id: Int, size: Dp, modifier: Modifier ) {
    Image(
        painter = painterResource( id = id ),
        contentDescription = "CircleImage",
        modifier = modifier
            .size( size )
            .shadow( elevation = 16.dp, shape = RoundedCornerShape( 16.dp ), clip = false)
            .clip( RoundedCornerShape( 16.dp ) )
    )
}

@Composable
fun Spacer( dp: Dp ) {
    Spacer(modifier = Modifier.padding( dp ))
}

@Composable
fun CommonField( text: String, placeholder: String, onTextFieldChanged: (String) -> Unit ) {
    TextField(
        value = text,
        enabled = true,
        onValueChange = { onTextFieldChanged( it ) },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape( 12.dp ),
        placeholder = { Text( text = placeholder ) },
        keyboardOptions = KeyboardOptions( keyboardType = KeyboardType.Text ),
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color( 0xFF636262 ),
            unfocusedTextColor = Color( 0xFF636262 ),
            focusedPlaceholderColor = Color( 0xFF636262 ),
            unfocusedPlaceholderColor = Color( 0xFF636262 ),
            focusedContainerColor = Color( 0xFFDEDDDD ),
            unfocusedContainerColor = Color( 0xFFDEDDDD ),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun EmailField( email: String, placeholder: String, onTextFieldChanged: (String) -> Unit ) {
    TextField(
        value = email,
        enabled = true,
        onValueChange = { onTextFieldChanged( it ) },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape( 12.dp ),
        placeholder = { Text( text = placeholder ) },
        keyboardOptions = KeyboardOptions( keyboardType = KeyboardType.Email ),
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color( 0xFF636262 ),
            unfocusedTextColor = Color( 0xFF636262 ),
            focusedPlaceholderColor = Color( 0xFF636262 ),
            unfocusedPlaceholderColor = Color( 0xFF636262 ),
            focusedContainerColor = Color( 0xFFDEDDDD ),
            unfocusedContainerColor = Color( 0xFFDEDDDD ),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun PasswordField( password: String, placeholder: String, onTextFieldChanged: (String) -> Unit ) {
    var visiblePassword by remember { mutableStateOf(false) }

    TextField(
        value = password,
        enabled = true,
        onValueChange = { onTextFieldChanged( it ) },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape( 12.dp ),
        visualTransformation = if (visiblePassword) VisualTransformation.None else PasswordVisualTransformation(),
        placeholder = { Text( text = placeholder ) },
        keyboardOptions = KeyboardOptions( keyboardType = KeyboardType.Password ),
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color( 0xFF636262 ),
            unfocusedTextColor = Color( 0xFF636262 ),
            focusedPlaceholderColor = Color( 0xFF636262 ),
            unfocusedPlaceholderColor = Color( 0xFF636262 ),
            focusedContainerColor = Color( 0xFFDEDDDD ),
            unfocusedContainerColor = Color( 0xFFDEDDDD ),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        trailingIcon = {
            val image = if (visiblePassword) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
            val description = if (visiblePassword) "Hide Password" else "Show Password"

            IconButton(
                onClick = { visiblePassword = !visiblePassword },
                colors = IconButtonDefaults.iconButtonColors( contentColor = Color(0xFF636262) )
            ) {
                Icon( imageVector = image, contentDescription = description )
            }
        }
    )
}

@Composable
fun TextFieldErrorLabel( isValid: Boolean, validText: String, invalidText: String, modifier: Modifier ) {
    if ( isValid ) {
        Text(
            text = validText,
            textAlign = TextAlign.Left,
            color = Color.Green,
            modifier = modifier.padding( top = 12.dp ),
        )
    } else {
        Text(
            text = invalidText,
            textAlign = TextAlign.Left,
            color = Color.Red,
            modifier = modifier.padding( top = 12.dp ),
        )
    }
}

@Composable
fun TextLink( text: String, onPressedLink: () -> Unit, modifier: Modifier ) {
    Text(
        text = text,
        fontSize = 12.sp,
        modifier = modifier.clickable { onPressedLink() },
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary
    )
}

@Composable
fun PrimaryButton( text: String, enabled: Boolean, modifier: Modifier, onPressedButton: () -> Unit ) {
    Button(
        onClick = { onPressedButton() },
        modifier = modifier.fillMaxWidth().height( 48.dp ),
//        shape = RoundedCornerShape( 8.dp ),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            disabledContainerColor = MaterialTheme.colorScheme.secondary,
            contentColor = Color.White,
            disabledContentColor = Color.White
        )
    ) { Text( text = text) }
}

@Composable
fun SecondaryButton( text: String, enabled: Boolean, modifier: Modifier, onPressedButton: () -> Unit ) {
    OutlinedButton(
        onClick = { onPressedButton() },
        modifier = modifier.fillMaxWidth().height( 48.dp ),
//        shape = RoundedCornerShape( 8.dp ),
        enabled = enabled,
        border = BorderStroke( 2.dp, MaterialTheme.colorScheme.primary ),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            contentColor = Color.White,
            disabledContentColor = Color.LightGray
        )
    ) { Text( text = text) }
}