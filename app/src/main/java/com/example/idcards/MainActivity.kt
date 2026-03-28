package com.example.idcards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.stringResource
import com.example.idcards.ui.theme.IdCardsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IdCardsTheme {
                UniversityID()
            }
        }
    }
}
private val Maroon = Color(0xFF7B1C27)
private val MaroonDark = Color(0xFF5A1019)
@Composable
fun UniversityID() {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()  // grows to fit all content
            .padding(16.dp),
        shape = RoundedCornerShape(18.dp)
    ) {
        Box {
            // WATERMARK LEFT
            Image(
                painter = painterResource(R.drawable.ndu_logo),
                contentDescription = null,
                modifier = Modifier
                    .size(180.dp)
                    .align(Alignment.CenterStart)
                    .alpha(0.08f)
            )
            // WATERMARK RIGHT
            Image(
                painter = painterResource(R.drawable.ndu_logo),
                contentDescription = null,
                modifier = Modifier
                    .size(180.dp)
                    .align(Alignment.CenterEnd)
                    .alpha(0.08f)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // HEADER
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .background(MaroonDark)
                ) {
                    // NDU LOGO
                    Box(
                        modifier = Modifier
                            .size(90.dp)
                            .aspectRatio(1f)
                            .align(Alignment.BottomStart)
                            .offset(y = 10.dp)
                            .clip(RoundedCornerShape(50))
                            .background(Color.White),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ndu_logo),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxSize(0.75f),
                            contentScale = ContentScale.Fit
                        )
                    }
                    // UGANDA FLAG
                    Image(
                        painter = painterResource(R.drawable.uganda_flag),
                        contentDescription = null,
                        modifier = Modifier
                            .size(110.dp)
                            .align(Alignment.TopEnd)
                            .padding(12.dp)
                    )
                    // STUDENT PHOTO
                    Box(
                        modifier = Modifier
                            .size(120.dp)
                            .aspectRatio(1f)
                            .align(Alignment.BottomCenter)
                            .offset(y = 25.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                            .border(3.dp, Maroon, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {

                        Image(
                            painter = painterResource(R.drawable.cryus),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxSize()
                                .aspectRatio(1f)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
                Spacer(Modifier.height(50.dp))
                Text(
                    text = stringResource(id = R.string.student_name).uppercase(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = stringResource(id = R.string.programme),
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = stringResource(id = R.string.registration_number),
                    fontWeight = FontWeight.ExtraBold,
                     textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(6.dp))
                Row {
                    Text(stringResource(R.string.issue_date))
                    Spacer(Modifier.width(20.dp))
                    Text(stringResource(R.string.expiry_date,))
                }
                Spacer(Modifier.height(8.dp))
                Barcode()
                Spacer(Modifier.height(6.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .background(Maroon)
                )
            }
        }
    }
}

@Composable
fun Barcode() {
    val stripes = listOf(
        2,1,3,1,2,1,1,3,2,1,3,1,2,2,1,3,
        1,2,1,1,3,2,1,2,3,1,1,2,3,1,2,2,
        1,2,3,2,2,3,1,3,2,3,2,1,2,1,3,2,
        2,2,1,3,1,2,1,3,2,1,3,2,2,3,2,1,
        2,3,1,2,3,2,3,1,2,3,1,1,1,2,2,3
    )
    Row(
        modifier = Modifier
            .height(40.dp)
            .fillMaxWidth(0.75f),
        horizontalArrangement = Arrangement.Center
    ) {
        stripes.forEachIndexed { index, width ->
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(width.dp)
                    .background(if (index % 2 == 0) Color.Black else Color.Transparent
                    )
            )
            Spacer(Modifier.width(1.dp))
        }
    }
}
@Preview(
    showBackground = true,
    backgroundColor = 0xFFEFEFEF,
    widthDp = 600,
    heightDp = 360
)
@Composable
fun UniversityIDPreview(){
    MaterialTheme {
        UniversityID(
        )
    }
}