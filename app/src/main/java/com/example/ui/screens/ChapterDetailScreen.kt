package com.example.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.SafetyCurriculum
import com.example.model.Chapter
import com.example.model.SvgDiagramType
import com.example.ui.components.*
import com.example.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChapterDetailScreen(
    chapterId: Int,
    isRead: Boolean,
    isBookmarked: Boolean,
    onToggleRead: (Int) -> Unit,
    onToggleBookmark: (Int) -> Unit,
    onNavigateBack: () -> Unit,
    onNavigateToChapter: (Int) -> Unit,
    onNavigateToCaseStudies: () -> Unit,
    modifier: Modifier = Modifier
) {
    val chapter = remember(chapterId) {
        SafetyCurriculum.CHAPTERS.find { it.id == chapterId } ?: SafetyCurriculum.CHAPTERS.first()
    }

    val context = LocalContext.current
    val prevChapter = SafetyCurriculum.CHAPTERS.find { it.id == chapter.id - 1 }
    val nextChapter = SafetyCurriculum.CHAPTERS.find { it.id == chapter.id + 1 }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = FrostedGlassCanvas,
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = chapter.chapterNumber,
                            style = MaterialTheme.typography.labelSmall.copy(color = RiverCyanLight)
                        )
                        Text(
                            text = chapter.title,
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Bold,
                                color = TextPrimary
                            ),
                            maxLines = 1
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = onNavigateBack,
                        modifier = Modifier.testTag("chapter_detail_back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "返回",
                            tint = TextPrimary
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = { onToggleBookmark(chapter.id) },
                        modifier = Modifier.testTag("bookmark_button")
                    ) {
                        Icon(
                            imageVector = if (isBookmarked) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                            contentDescription = "收藏章節",
                            tint = if (isBookmarked) AccentGold else TextSecondary
                        )
                    }
                    IconButton(
                        onClick = { onToggleRead(chapter.id) },
                        modifier = Modifier.testTag("toggle_read_button")
                    ) {
                        Icon(
                            imageVector = if (isRead) Icons.Default.CheckCircle else Icons.Default.RadioButtonUnchecked,
                            contentDescription = "標記已讀",
                            tint = if (isRead) SafetyEmeraldLight else TextSecondary
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
            // Category & Header Banner
            item {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .background(if (chapter.isAdvanced) WarningAmberBg.copy(alpha = 0.6f) else RiverCyanDark.copy(alpha = 0.5f), RoundedCornerShape(8.dp))
                                .border(1.dp, if (chapter.isAdvanced) AccentGold.copy(alpha = 0.4f) else GlassBorderHighlight, RoundedCornerShape(8.dp))
                                .padding(horizontal = 8.dp, vertical = 3.dp)
                        ) {
                            Text(
                                text = chapter.category,
                                style = MaterialTheme.typography.labelSmall.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = if (chapter.isAdvanced) AccentGold else RiverCyanLight
                                )
                            )
                        }

                        if (chapter.isAdvanced) {
                            Box(
                                modifier = Modifier
                                    .background(HazardRedBg.copy(alpha = 0.6f), RoundedCornerShape(8.dp))
                                    .border(1.dp, HazardRed.copy(alpha = 0.4f), RoundedCornerShape(8.dp))
                                    .padding(horizontal = 8.dp, vertical = 3.dp)
                            ) {
                                Text(
                                    text = "進階技術認識（非照做）",
                                    style = MaterialTheme.typography.labelSmall.copy(
                                        color = HazardRedLight,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                            }
                        }
                    }

                    Text(
                        text = chapter.title,
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight.Bold,
                            color = TextPrimary
                        )
                    )

                    Text(
                        text = chapter.subtitle,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = TextSecondary,
                            lineHeight = 20.sp
                        )
                    )
                }
            }

            // Core Golden Quote
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            if (chapter.isAdvanced) WarningAmberBg.copy(alpha = 0.35f) else FrostedCardBgElevated,
                            RoundedCornerShape(16.dp)
                        )
                        .border(
                            1.dp,
                            if (chapter.isAdvanced) AccentGold.copy(alpha = 0.6f) else GlassBorderHighlight,
                            RoundedCornerShape(16.dp)
                        )
                        .padding(16.dp)
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(
                            text = "【核心安全守則】",
                            style = MaterialTheme.typography.labelSmall.copy(
                                color = if (chapter.isAdvanced) AccentGold else RiverCyanLight,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Text(
                            text = "«${chapter.coreQuote}»",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Bold,
                                color = TextPrimary,
                                lineHeight = 22.sp
                            )
                        )
                    }
                }
            }

            // Summary text
            item {
                Text(
                    text = chapter.summary,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = TextPrimary,
                        lineHeight = 22.sp
                    )
                )
            }

            // Original Diagram Embeds (Canvas)
            when (chapter.diagramType) {
                SvgDiagramType.BACKPACK_SEPARATION -> {
                    item {
                        BackpackSeparationDiagram()
                    }
                }
                SvgDiagramType.PENDULUM_TRAVERSE -> {
                    item {
                        PendulumTraverseDiagram()
                    }
                }
                SvgDiagramType.RIVER_CROSS_SECTION -> {
                    item {
                        RiverCrossSectionDiagram()
                    }
                }
                SvgDiagramType.SANDBANK_ISLAND_TRAP -> {
                    item {
                        SandbankTrapDiagram()
                    }
                }
                SvgDiagramType.NONE -> { /* No diagram */ }
            }

            // Key Points List
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, GlassBorderLight, RoundedCornerShape(18.dp)),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(containerColor = FrostedCardBg)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Text(
                            text = "重點教學解析",
                            style = MaterialTheme.typography.titleSmall.copy(
                                fontWeight = FontWeight.Bold,
                                color = RiverCyanLight
                            )
                        )

                        chapter.keyPoints.forEachIndexed { i, pt ->
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(10.dp),
                                verticalAlignment = Alignment.Top
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(22.dp)
                                        .background(FrostedInnerBg, CircleShape)
                                        .border(1.dp, GlassBorderHighlight, CircleShape),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "${i + 1}",
                                        style = MaterialTheme.typography.labelSmall.copy(
                                            color = RiverCyanLight,
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 10.sp
                                        )
                                    )
                                }
                                Text(
                                    text = pt,
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        color = TextPrimary,
                                        lineHeight = 20.sp
                                    ),
                                    modifier = Modifier.weight(1f)
                                )
                            }
                        }
                    }
                }
            }

            // Process Steps (If present, e.g., Chapter 03, 11)
            if (chapter.processSteps.isNotEmpty()) {
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(1.dp, SafetyEmerald.copy(alpha = 0.4f), RoundedCornerShape(18.dp)),
                        shape = RoundedCornerShape(18.dp),
                        colors = CardDefaults.cardColors(containerColor = FrostedCardBg)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Text(
                                text = "標準操作步驟流程",
                                style = MaterialTheme.typography.titleSmall.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = SafetyEmeraldLight
                                )
                            )

                            chapter.processSteps.forEach { step ->
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(FrostedInnerBg, RoundedCornerShape(10.dp))
                                        .border(1.dp, GlassBorderSubtle, RoundedCornerShape(10.dp))
                                        .padding(10.dp),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Check,
                                        contentDescription = "步驟",
                                        tint = SafetyEmeraldLight,
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Text(
                                        text = step,
                                        style = MaterialTheme.typography.bodyMedium.copy(
                                            color = TextPrimary,
                                            fontWeight = FontWeight.SemiBold
                                        )
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // Deep content paragraphs
            if (chapter.deepContent.isNotEmpty()) {
                item {
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        chapter.deepContent.forEach { p ->
                            Text(
                                text = p,
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    color = TextSecondary,
                                    lineHeight = 22.sp
                                )
                            )
                        }
                    }
                }
            }

            // Warning Box (If present)
            chapter.warningBox?.let { box ->
                item {
                    WarningBoxView(data = box)
                }
            }

            // Comparison Table (If present, e.g., Chapter 04, 17)
            chapter.comparisonTable?.let { table ->
                item {
                    ComparisonTableView(data = table)
                }
            }

            // Interactive Case Study Direct Launch (if Chapter 19)
            if (chapter.id == 19) {
                item {
                    Button(
                        onClick = onNavigateToCaseStudies,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp)
                            .testTag("launch_case_studies_button"),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = AccentGold,
                            contentColor = FrostedGlassCanvas
                        ),
                        shape = RoundedCornerShape(14.dp)
                    ) {
                        Icon(imageVector = Icons.Default.Quiz, contentDescription = "開始演練")
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("開始進行五大情境案例互動演練", fontWeight = FontWeight.Bold)
                    }
                }
            }

            // External Citation for Pendulum Chapters (Chapter 15, 16, 17)
            if (chapter.referenceUrl != null) {
                item {
                    ExternalCitationCard()
                }
            }

            // Mark Read Action Button
            item {
                OutlinedButton(
                    onClick = { onToggleRead(chapter.id) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if (isRead) SafetyEmeraldBg.copy(alpha = 0.4f) else FrostedCardBg,
                        contentColor = if (isRead) SafetyEmeraldLight else TextPrimary
                    ),
                    border = ButtonDefaults.outlinedButtonBorder.copy(
                        brush = Brush.horizontalGradient(
                            listOf(
                                if (isRead) SafetyEmerald else GlassBorderLight,
                                if (isRead) SafetyEmeraldLight else GlassBorderLight
                            )
                        )
                    )
                ) {
                    Icon(
                        imageVector = if (isRead) Icons.Default.CheckCircle else Icons.Default.Done,
                        contentDescription = "已研讀本章",
                        tint = if (isRead) SafetyEmeraldLight else RiverCyanLight
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = if (isRead) "✓ 已完成本章研讀（點擊取消）" else "標記本章為「已研讀」")
                }
            }

            // Prev & Next Chapter Navigation Buttons
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    if (prevChapter != null) {
                        Button(
                            onClick = { onNavigateToChapter(prevChapter.id) },
                            modifier = Modifier
                                .weight(1f)
                                .height(48.dp)
                                .testTag("prev_chapter_button"),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = FrostedCardBgElevated,
                                contentColor = TextPrimary
                            ),
                            shape = RoundedCornerShape(14.dp),
                            border = ButtonDefaults.outlinedButtonBorder.copy(
                                brush = Brush.linearGradient(listOf(GlassBorderLight, GlassBorderLight))
                            )
                        ) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "上一章", modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("上一章", fontSize = 13.sp)
                        }
                    } else {
                        Spacer(modifier = Modifier.weight(1f))
                    }

                    if (nextChapter != null) {
                        Button(
                            onClick = { onNavigateToChapter(nextChapter.id) },
                            modifier = Modifier
                                .weight(1f)
                                .height(48.dp)
                                .testTag("next_chapter_button"),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = RiverCyanDark,
                                contentColor = RiverGlacier
                            ),
                            shape = RoundedCornerShape(14.dp),
                            border = ButtonDefaults.outlinedButtonBorder.copy(
                                brush = Brush.linearGradient(listOf(GlassBorderHighlight, GlassBorderHighlight))
                            )
                        ) {
                            Text("下一章", fontSize = 13.sp)
                            Spacer(modifier = Modifier.width(4.dp))
                            Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "下一章", modifier = Modifier.size(16.dp))
                        }
                    } else {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}
