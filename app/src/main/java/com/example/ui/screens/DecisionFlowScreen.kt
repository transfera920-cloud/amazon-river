package com.example.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ui.components.DecisionFlowView
import com.example.ui.components.LeaderCalloutCard
import com.example.ui.components.TopCorePrinciplesCard
import com.example.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DecisionFlowScreen(
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = FrostedGlassCanvas,
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "安全評估導航",
                            style = MaterialTheme.typography.labelSmall.copy(color = RiverCyanLight)
                        )
                        Text(
                            text = "溪邊決策流程圖",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Bold,
                                color = TextPrimary
                            )
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = onNavigateBack,
                        modifier = Modifier.testTag("decision_flow_back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "返回",
                            tint = TextPrimary
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = FrostedGlassAppBarBg,
                    titleContentColor = TextPrimary
                ),
                modifier = Modifier.border(0.5.dp, GlassBorderSubtle, RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                TopCorePrinciplesCard()
            }

            item {
                LeaderCalloutCard()
            }

            item {
                DecisionFlowView()
            }

            item {
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}
