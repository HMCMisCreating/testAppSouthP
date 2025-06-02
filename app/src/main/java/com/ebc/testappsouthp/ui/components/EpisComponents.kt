package com.ebc.testappsouthp.ui.components

import android.R.style
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ebc.testappsouthp.R
import com.ebc.testappsouthp.models.Epis

@Composable
fun EpisodeCard(epis: Epis, modifier: Modifier = Modifier) {
    Card (
        modifier = modifier,
        shape = RoundedCornerShape(8.dp)

    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = epis.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start
            )

            Text(
                text = "${epis.season} (${epis.episode})",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(10.dp))

            AsyncImage(
                modifier = Modifier.fillMaxWidth(),
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(epis.imgSrc)
                    .crossfade(true)
                    .build(),
                contentDescription = "Episode",
                contentScale = ContentScale.FillWidth,
                error = painterResource(R.drawable.ic_launcher_background),
                placeholder = painterResource(R.drawable.ic_launcher_background)
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = epis.description,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Justify
            )


        }

    }

}
@Preview(showBackground = true)
@Composable
private fun AnfibioCardPreview(){
    val epis: Epis = Epis(
        name =  "Cartman Gets an Anal Probe",
        description = "While the boys are waiting for the school bus, Cartman explains the odd nightmare he had the previous night involving alien visitors.\n",
        imgSrc = "https://developer.android.com/codelabs/basic-android-kotlin-compose-amphibians-app/img/great-basin-spadefoot.png",
        id = 1,
        season = 1,
        episode = 1,
        airDate = "1997-08-13",
        wikiSrc = "https://southpark.fandom.com/wiki/Cartman_Gets_an_Anal_Probe",
        created = "2022-03-10T17:03:22.000000Z",
        updated = "2022-03-10T17:03:22.000000Z",
        characters = listOf( "https://spapi.dev/api/characters/32",
            "https://spapi.dev/api/characters/3"),
        locations = listOf("https://spapi.dev/api/locations/2",
            "https://spapi.dev/api/locations/3",
            "https://spapi.dev/api/locations/6")

    )

    EpisodeCard(epis = epis)

}

@Composable
fun EpisodeListScreen(
    listaEpisodes: List<Epis>,
    modifier: Modifier = Modifier,
    paddingContenido: PaddingValues = PaddingValues(0.dp)
){
    LazyColumn(
        modifier = modifier,
        contentPadding = paddingContenido,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

    }

}