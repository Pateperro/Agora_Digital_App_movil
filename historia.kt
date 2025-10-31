package com.angelcabrera.ramaangel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaHistoria() {
    val topBarColor = Color(0xFF8000FF)
    val menuBgColor = Color(0xFFB2B2B2)
    val menuTextColor = Color.Black
    val infoBackground = Color(0xFFE0DBFE)
    val infoTextColor = Color(0xFF2A2A2A)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(0.dp)
    ) {

        Text(
            text = "HistoriaF Texto",
            modifier = Modifier
                .padding(start = 20.dp, top = 10.dp),
            color = Color.LightGray,
            fontSize = 12.sp
        )


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(topBarColor),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .padding(end = 12.dp)
                    .background(Color(0x33000000), RoundedCornerShape(50))
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                Text(text = "Miguel Pateperro", color = Color.Black, fontSize = 12.sp)
            }

        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(menuBgColor)
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Historia Filosofía", color = menuTextColor, fontSize = 14.sp)
            Spacer(modifier = Modifier.width(10.dp))
            Text("|", color = Color.Gray)
            Spacer(modifier = Modifier.width(10.dp))
            Text("Glosario", color = menuTextColor, fontSize = 14.sp)
            Spacer(modifier = Modifier.width(10.dp))
            Text("|", color = Color.Gray)
            Spacer(modifier = Modifier.width(10.dp))
            Text("Filósofos", color = menuTextColor, fontSize = 14.sp)
        }

        Spacer(modifier = Modifier.height(10.dp))


        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            colors = CardDefaults.cardColors(containerColor = infoBackground),
            shape = RoundedCornerShape(0.dp)
        ) {
            Column(modifier = Modifier.padding(15.dp)) {
                Text(
                    text = "Filosofía Medieval",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = infoTextColor
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sodales libero id massa placerat venenatis. Curabitur a nibh eget mauris efficitur vestibulum.",
                    fontSize = 12.sp,
                    color = infoTextColor,
                    lineHeight = 16.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(infoBackground)
                .padding(horizontal = 10.dp, vertical = 16.dp)
        ) {
            Text(
                text = """
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla velit ante, ultricies id consequat sit amet, consectetur in orci. Proin scelerisque cursus ultricies. Nam id velit sed quam feugiat mattis ornare vel massa. Suspendisse vel libero at sem tempus pellentesque. Quisque facilisis nibh lorem, a varius tellus maximus a. Nullam luctus ultricies ipsum, vel cursus nisl bibendum eget. Quisque sit amet auctor quam.

                    Ut vehicula ex et quam dictum, quis imperdiet purus blandit. Mauris lacinia pellentesque luctus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean rutrum varius ultricies. Integer ac sodales nibh, vitae viverra nibh. Suspendisse ultricies nunc a nulla porttitor consequat. Vestibulum porttitor tempus elit in imperdiet. Mauris quam orci, imperdiet sed ex nec, gravida lacinia magna.

                    Nulla et malesuada risus, quis facilisis odio. Morbi vehicula porta fermentum. Nullam non justo in justo aliquet ullamcorper. Nunc bibendum, neque vehicula imperdiet vestibulum, dui metus suscipit purus, a ultricies dolor risus at tellus. In sit amet tincidunt neque, consequat gravida sem. Fusce vitae est elementum, mattis dui eget, maximus dolor. Curabitur hendrerit finibus orci, eu hendrerit tellus commodo in. Vestibulum congue mi non enim bibendum efficitur. Proin venenatis vitae lectus sit amet dignissim. Sed vel laoreet lorem, vitae sodales mauris. Vestibulum id libero id risus rhoncus sodales eget sit amet lorem. Morbi vestibulum lacinia urna, id aliquet nibh hendrerit vitae.
                """.trimIndent(),
                fontSize = 13.sp,
                color = infoTextColor,
                lineHeight = 18.sp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))


        Text(
            text = "Preguntas",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color.Black,
            modifier = Modifier.padding(start = 10.dp, bottom = 8.dp)
        )


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(infoBackground)
                .padding(16.dp)
                .padding(horizontal = 10.dp)
        ) {
            Text(
                text = "Ut vehicula ex et quam dictum, quis imperdiet purus blandit. Mauris lacinia pellentesque luctus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean rutrum varius ultricies. Integer ac sodales nibh, vitae viverra nibh. Suspendisse ultricies nunc a nulla porttitor consequat. Vestibulum porttitor tempus elit in imperdiet. Mauris quam orci, imperdiet sed ex nec, gravida lacinia magna.",
                fontSize = 13.sp,
                color = infoTextColor,
                lineHeight = 18.sp
            )
        }

        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPantallaHistoria() {
    PantallaHistoria()
}
