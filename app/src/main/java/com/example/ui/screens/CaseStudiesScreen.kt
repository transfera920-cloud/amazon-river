package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.SafetyCurriculum
import com.example.ui.components.CaseStudyInteractiveCard
import com.example.ui.components.SafetyBaselineSection
import com.example.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CaseStudiesScreen(
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
                            text = "真實情境互動決策",
                            style = MaterialTheme.typography.labelSmall.copy(color = AccentGold)
                        )
                        Text(
                            text = "案例演練（五大經典情境）",
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
                        modifier = Modifier.testTag("case_studies_back_button")
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
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(FrostedCardBg, RoundedCornerShape(18.dp))
                        .border(1.dp, GlassBorderLight, RoundedCornerShape(18.dp))
                        .padding(16.dp)
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Text(
                            text = "【案例演練說明】",
                            style = MaterialTheme.typography.labelMedium.copy(
                                fontWeight = FontWeight.Bold,
                                color = AccentGold
                            )
                        )
                        Text(
                            text = "本演練為登山安全教育思維訓練，無危險評分，不計算分數。請點選每題選項，深入體會帶隊與過溪時的安全思考邏輯與核心教訓。",
                            style = MaterialTheme.typography.bodySmall.copy(
                                color = TextSecondary,
                                lineHeight = 18.sp
                            )
                        )
                    }
                }
            }

            items(SafetyCurriculum.CASE_STUDIES, key = { it.id }) { caseStudy ->
                CaseStudyInteractiveCard(caseStudy = caseStudy)
            }

            item {
                SafetyBaselineSection()
            }

            item {
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}
