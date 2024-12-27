package com.example.googlemapsexample.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.googlemapsexample.viewmodel.LocationViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.googlemapsexample.data.LocationData
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ListItem

@Composable
fun LastLocationsScreen(viewModel: LocationViewModel,
                          navHostController: NavHostController
) {
    val listOfLOcationItems by viewModel.listOfLOcationItems.collectAsState()
    Spacer(Modifier.height(2.dp))
   Column { Button(onClick = { navHostController.navigate(Graph.MAIN_SCREEN)})
   {
       Text("BAck")
   } }
    Spacer(Modifier.height(10.dp))
    LazyColumn( modifier = Modifier
    .fillMaxSize()
    .padding(16.dp)){


    items(listOfLOcationItems){
        element->
        LocationDataCard(
        LocationDataItem = element

    ) }

    }
}




@Composable
fun LocationDataCard(
    LocationDataItem: LocationData?,


    ){
    Card(
        modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp),
        border = BorderStroke(2.dp, color = Color.Cyan)
    ) {
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = LocationDataItem?.latitude.toString(),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(Modifier.height(2.dp))
                Text(
                    text = LocationDataItem?.longitude.toString(),
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            }

            Spacer(Modifier.width(16.dp))

        }
    }
}