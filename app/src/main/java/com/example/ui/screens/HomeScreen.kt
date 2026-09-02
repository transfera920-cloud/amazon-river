package com.example.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.SafetyCurriculum
import com.example.model.Chapter
import com.example.model.SvgDiagramType
import com.example.ui.components.*
import com.example.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    readChapterIds: Set<Int>,
    bookmarkedChapterIds: Set<Int>,
    onSelectChapter: (Chapter) -> Unit,
    onNavigateToDecisionFlow: () -> Unit,
    onNavigateToChecklist: () -> Unit,
    onNavigateToCaseStudies: () -> Unit,
    modifier: Modifier = Modifier
) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("全部") }

    val categories = listOf("全部", "基礎認知", "觀察與判斷", "隊伍管理", "核心裝備技術", "案例演練")

    val filteredChapters = remember(searchQuery, selectedCategory) {
        SafetyCurriculum.CHAPTERS.filter { chapter ->
            val matchesCategory = selectedCategory == "全部" || chapter.category == selectedCategory
            val matchesQuery = searchQuery.isBlank() ||
                    chapter.title.contains(searchQuery, ignoreCase = true) ||
                    chapter.subtitle.contains(searchQuery, ignoreCase = true) ||
                    chapter.chapterNumber.contains(searchQuery, ignoreCase = true) ||
                    chapter.keyPoints.any { it.contains(searchQuery, ignoreCase = true) }
            matchesCategory && matchesQuery
        }
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = FrostedGlassCanvas
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .testTag("home_screen_scroll"),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            // Hero Brand Header
            item {
                HeroBrandHeader()
            }

            // Top Core Principle Card (Highest Principle)
            item {
                TopCorePrinciplesCard()
            }

            // Quick Access Feature Badges (3 Pillars & Quick Tools)
            item {
                QuickToolsBar(
                    onChecklistClick = onNavigateToChecklist,
                    onDecisionClick = onNavigateToDecisionFlow,
                    onCasesClick = onNavigateToCaseStudies
                )
            }

            // Three Core Pillars (01 先看水 / 02 再選點 / 03 保留退路)
            item {
                CorePillarsSection(
                    onSelectPillar = { index ->
                        // Navigate to related chapter: index 0 -> Ch05/06, index 1 -> Ch04, index 2 -> Ch08
                        when (index) {
                            0 -> SafetyCurriculum.CHAPTERS.find { it.id == 5 }?.let(onSelectChapter)
                            1 -> SafetyCurriculum.CHAPTERS.find { it.id == 4 }?.let(onSelectChapter)
                            2 -> SafetyCurriculum.CHAPTERS.find { it.id == 8 }?.let(onSelectChapter)
                        }
                    }
                )
            }

            // Leader 10-Second Command
            item {
                LeaderCalloutCard()
            }

            // Reading Progress Indicator
            item {
                ReadingProgressCard(
                    totalChapters = SafetyCurriculum.CHAPTERS.size,
                    readCount = readChapterIds.size
                )
            }

            // Search Bar & Filter Chips
            item {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("search_chapter_input"),
                        placeholder = { Text("搜尋安全章節、水文特徵或裝備觀念...", color = TextMuted, fontSize = 13.sp) },
                        leadingIcon = {
                            Icon(Icons.Default.Search, contentDescription = "搜尋", tint = RiverCyanLight)
                        },
                        trailingIcon = {
                            if (searchQuery.isNotEmpty()) {
                                IconButton(onClick = { searchQuery = "" }) {
                                    Icon(Icons.Default.Clear, contentDescription = "清除", tint = TextMuted)
                                }
                            }
                        },
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = RiverCyanLight,
                            unfocusedBorderColor = GlassBorderLight,
                            focusedContainerColor = FrostedCardBgElevated,
                            unfocusedContainerColor = FrostedCardBg,
                            focusedTextColor = TextPrimary,
                            unfocusedTextColor = TextPrimary
                        ),
                        shape = RoundedCornerShape(16.dp)
                    )

                    // Category horizontal row
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        contentPadding = PaddingValues(vertical = 4.dp)
                    ) {
                        items(categories) { cat ->
                            val isSelected = cat == selectedCategory
                            FilterChip(
                                selected = isSelected,
                                onClick = { selectedCategory = cat },
                                label = { Text(cat, fontSize = 12.sp) },
                                shape = RoundedCornerShape(20.dp),
                                colors = FilterChipDefaults.filterChipColors(
                                    selectedContainerColor = RiverCyanDark.copy(alpha = 0.8f),
                                    selectedLabelColor = RiverGlacier,
                                    containerColor = FrostedCardBg,
                                    labelColor = TextSecondary
                                ),
                                border = FilterChipDefaults.filterChipBorder(
                                    enabled = true,
                                    selected = isSelected,
                                    borderColor = if (isSelected) RiverCyanLight else GlassBorderSubtle
                                )
                            )
                        }
                    }
                }
            }

            // Chapter Section Header
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "完整教案章節（共 ${SafetyCurriculum.CHAPTERS.size} 篇）",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = TextPrimary
                        )
                    )
                    Text(
                        text = "共 ${filteredChapters.size} 篇",
                        style = MaterialTheme.typography.labelSmall.copy(color = TextMuted)
                    )
                }
            }

            // Chapter Cards
            items(filteredChapters, key = { it.id }) { chapter ->
                val isRead = readChapterIds.contains(chapter.id)
                val isBookmarked = bookmarkedChapterIds.contains(chapter.id)

                ChapterListCard(
                    chapter = chapter,
                    isRead = isRead,
                    isBookmarked = isBookmarked,
                    onClick = { onSelectChapter(chapter) }
                )
            }

            // One Minute Checklist Embed
            item {
                OneMinuteChecklistView()
            }

            // Decision Flow Summary Card
            item {
                DecisionFlowView()
            }

            // Safety Baseline Bottom
            item {
                SafetyBaselineSection()
            }

            // External Citation Card
            item {
                ExternalCitationCard()
            }
        }
    }
}

@Composable
fun HeroBrandHeader(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .background(FrostedCardBg)
            .border(1.dp, GlassBorderLight, RoundedCornerShape(24.dp))
    ) {
        // Background Hero Artwork
        Image(
            painter = painterResource(id = R.drawable.hero_mountain_river_1788327473126),
            contentDescription = "高山溪流橫渡教學封面",
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp),
            contentScale = ContentScale.Crop
        )

        // Dark frosted gradient overlay for extreme legibility
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            FrostedGlassCanvas.copy(alpha = 0.7f),
                            FrostedGlassCanvas.copy(alpha = 0.95f)
                        )
                    )
                )
        )

        // Header Text & Brand
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            // Brand Pill
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .background(FrostedGlassCanvas.copy(alpha = 0.85f), RoundedCornerShape(20.dp))
                    .border(1.dp, GlassBorderHighlight, RoundedCornerShape(20.dp))
                    .padding(horizontal = 10.dp, vertical = 4.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(SafetyEmeraldLight, CircleShape)
                )
                Text(
                    text = SafetyCurriculum.BRAND_NAME,
                    style = MaterialTheme.typography.labelSmall.copy(
                        color = RiverGlacier,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp
                    )
                )
            }

            Spacer(modifier = Modifier.height(28.dp))

            Text(
                text = "登山途中溪水橫渡安全教案",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary,
                    fontSize = 20.sp
                )
            )

            Text(
                text = "«不要只問能不能過，先問進去之後是否仍保有安全撤退的能力。»",
                style = MaterialTheme.typography.bodySmall.copy(
                    color = RiverCyanLight,
                    fontWeight = FontWeight.Medium
                )
            )
        }
    }
}

@Composable
private fun QuickToolsBar(
    onChecklistClick: () -> Unit,
    onDecisionClick: () -> Unit,
    onCasesClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        QuickToolButton(
            title = "溪邊 8 問",
            subtitle = "一分鐘檢查",
            icon = Icons.Default.CheckCircle,
            color = SafetyEmeraldLight,
            onClick = onChecklistClick,
            modifier = Modifier.weight(1f)
        )
        QuickToolButton(
            title = "決策流程",
            subtitle = "12 步引導",
            icon = Icons.Default.AltRoute,
            color = RiverCyanLight,
            onClick = onDecisionClick,
            modifier = Modifier.weight(1f)
        )
        QuickToolButton(
            title = "案例演練",
            subtitle = "5 大實境",
            icon = Icons.Default.Quiz,
            color = AccentGold,
            onClick = onCasesClick,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun QuickToolButton(
    title: String,
    subtitle: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    color: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = onClick)
            .border(1.dp, GlassBorderLight, RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(containerColor = FrostedCardBg)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(imageVector = icon, contentDescription = title, tint = color, modifier = Modifier.size(20.dp))
            Text(text = title, style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold, color = TextPrimary))
            Text(text = subtitle, style = MaterialTheme.typography.labelSmall.copy(color = TextMuted, fontSize = 10.sp))
        }
    }
}

@Composable
private fun ReadingProgressCard(totalChapters: Int, readCount: Int) {
    val progress = (readCount.toFloat() / totalChapters.toFloat()).coerceIn(0f, 1f)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, GlassBorderLight, RoundedCornerShape(16.dp)),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = FrostedCardBg)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .background(FrostedGlassCanvas, CircleShape)
                    .border(1.dp, GlassBorderHighlight, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.MenuBook,
                    contentDescription = "閱讀進度",
                    tint = RiverCyanLight,
                    modifier = Modifier.size(22.dp)
                )
            }

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "教案研讀進度",
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = TextPrimary
                        )
                    )
                    Text(
                        text = "$readCount / $totalChapters 章節",
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = RiverCyanLight
                        )
                    )
                }

                LinearProgressIndicator(
                    progress = { progress },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(6.dp)
                        .clip(RoundedCornerShape(3.dp)),
                    color = RiverCyanLight,
                    trackColor = FrostedInnerBg
                )
            }
        }
    }
}

@Composable
fun ChapterListCard(
    chapter: Chapter,
    isRead: Boolean,
    isBookmarked: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .border(
                1.dp,
                if (chapter.isAdvanced) AccentGold.copy(alpha = 0.5f) else GlassBorderLight,
                RoundedCornerShape(16.dp)
            ),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = FrostedCardBg)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Category & Chapter Number Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .background(
                                if (chapter.isAdvanced) WarningAmberBg.copy(alpha = 0.6f) else FrostedCardBgElevated,
                                RoundedCornerShape(6.dp)
                            )
                            .border(1.dp, if (chapter.isAdvanced) AccentGold.copy(alpha = 0.3f) else GlassBorderSubtle, RoundedCornerShape(6.dp))
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = chapter.category,
                            style = MaterialTheme.typography.labelSmall.copy(
                                color = if (chapter.isAdvanced) AccentGold else RiverCyanLight,
                                fontWeight = FontWeight.Bold,
                                fontSize = 10.sp
                            )
                        )
                    }

                    if (chapter.diagramType != SvgDiagramType.NONE) {
                        Box(
                            modifier = Modifier
                                .background(SafetyEmeraldBg.copy(alpha = 0.6f), RoundedCornerShape(6.dp))
                                .border(1.dp, SafetyEmeraldLight.copy(alpha = 0.3f), RoundedCornerShape(6.dp))
                                .padding(horizontal = 6.dp, vertical = 2.dp)
                        ) {
                            Text(
                                text = "原創圖解",
                                style = MaterialTheme.typography.labelSmall.copy(
                                    color = SafetyEmeraldLight,
                                    fontSize = 10.sp
                                )
                            )
                        }
                    }
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    if (isRead) {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = "已讀",
                            tint = SafetyEmeraldLight,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                    if (isBookmarked) {
                        Icon(
                            imageVector = Icons.Default.Bookmark,
                            contentDescription = "已收藏",
                            tint = AccentGold,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                    Text(
                        text = chapter.chapterNumber,
                        style = MaterialTheme.typography.labelSmall.copy(
                            color = TextMuted,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                }
            }

            // Title
            Text(
                text = chapter.title,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )
            )

            // Subtitle
            Text(
                text = chapter.subtitle,
                style = MaterialTheme.typography.bodySmall.copy(
                    color = TextSecondary,
                    fontSize = 12.sp,
                    lineHeight = 16.sp
                )
            )

            // Core Quote highlight
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(FrostedInnerBg, RoundedCornerShape(10.dp))
                    .border(1.dp, GlassBorderSubtle, RoundedCornerShape(10.dp))
                    .padding(horizontal = 10.dp, vertical = 6.dp)
            ) {
                Text(
                    text = "«${chapter.coreQuote.take(55)}${if (chapter.coreQuote.length > 55) "..." else ""}»",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = if (chapter.isAdvanced) AccentGold else RiverGlacier,
                        fontWeight = FontWeight.Medium,
                        fontSize = 11.sp
                    )
                )
            }
        }
    }
}
