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
import com.example.data.SafetyCurriculum
import com.example.model.WarningLevel
import com.example.model.WarningBoxData
import com.example.ui.components.LeaderCalloutCard
import com.example.ui.components.OneMinuteChecklistView
import com.example.ui.components.WarningBoxView
import com.example.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChecklistScreen(
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
                            text = "帶隊現場實戰自查",
                            style = MaterialTheme.typography.labelSmall.copy(color = RiverCyanLight)
                        )
                        Text(
                            text = "一分鐘溪邊檢查表（溪邊 8 問）",
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
                        modifier = Modifier.testTag("checklist_back_button")
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
                LeaderCalloutCard()
            }

            item {
                OneMinuteChecklistView()
            }

            // Red Prohibitions Summary Box
            item {
                val prohibitionChapter = SafetyCurriculum.CHAPTERS.find { it.id == 9 }
                prohibitionChapter?.warningBox?.let { box ->
                    WarningBoxView(
                        data = WarningBoxData(
                            level = WarningLevel.PROHIBITION,
                            title = "🚫 絕對禁止涉水之 12 項情境",
                            text = "只要符合以下任一條件，一律嚴禁下水，堅決撤退或改道：",
                            bulletPoints = prohibitionChapter.keyPoints
                        )
                    )
                }
            }

            item {
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}
