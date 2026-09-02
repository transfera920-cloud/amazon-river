package com.example.ui.components

import android.content.Intent
import android.net.Uri
import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.SafetyCurriculum
import com.example.model.*
import com.example.ui.theme.*

@Composable
fun TopCorePrinciplesCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .border(1.5.dp, WarningAmberLight.copy(alpha = 0.5f), RoundedCornerShape(22.dp)),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(containerColor = FrostedCardBgElevated)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(38.dp)
                        .background(WarningAmberBg.copy(alpha = 0.7f), CircleShape)
                        .border(1.dp, WarningAmberLight.copy(alpha = 0.8f), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Shield,
                        contentDescription = "安全最高原則",
                        tint = WarningAmberLight,
                        modifier = Modifier.size(20.dp)
                    )
                }
                Column {
                    Text(
                        text = "登山隊過溪的最高原則",
                        style = MaterialTheme.typography.labelMedium.copy(
                            color = WarningAmberLight,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.sp
                        )
                    )
                    Text(
                        text = "CORE RETREAT PRINCIPLE",
                        style = MaterialTheme.typography.labelSmall.copy(
                            color = TextMuted,
                            fontSize = 9.sp,
                            letterSpacing = 0.5.sp
                        )
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(FrostedInnerBg, RoundedCornerShape(14.dp))
                    .border(1.dp, GlassBorderSubtle, RoundedCornerShape(14.dp))
                    .padding(16.dp)
            ) {
                Text(
                    text = "不是判斷「現在能不能過」，\n而是判斷「進去之後，是否仍然保有安全撤退的能力」。",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary,
                        lineHeight = 24.sp
                    )
                )
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CoreSubRuleItem(text = "不要進入會困住你的地方。", color = HazardRedLight)
                CoreSubRuleItem(text = "有繩 ≠ 可以過。", color = WarningAmberLight)
                CoreSubRuleItem(text = "繩索是控制系統，不是替代個人脫困能力。", color = RiverCyanLight)
            }
        }
    }
}

@Composable
private fun CoreSubRuleItem(text: String, color: Color) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .background(FrostedInnerBg, RoundedCornerShape(10.dp))
            .border(1.dp, GlassBorderSubtle, RoundedCornerShape(10.dp))
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(6.dp)
                .background(color, CircleShape)
        )
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.SemiBold,
                color = TextPrimary
            )
        )
    }
}

@Composable
fun CorePillarsSection(
    onSelectPillar: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = "三大核心判斷維度",
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )
        )

        SafetyCurriculum.CORE_PILLARS.forEachIndexed { index, pillar ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onSelectPillar(index) }
                    .border(1.dp, GlassBorderLight, RoundedCornerShape(16.dp)),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = FrostedCardBg)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            text = pillar.first,
                            style = MaterialTheme.typography.titleSmall.copy(
                                fontWeight = FontWeight.Bold,
                                color = if (index == 0) RiverCyanLight else if (index == 1) SafetyEmeraldLight else AccentGold
                            )
                        )
                        Text(
                            text = pillar.second,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontWeight = FontWeight.SemiBold,
                                color = TextPrimary
                            )
                        )
                        Text(
                            text = pillar.third,
                            style = MaterialTheme.typography.bodySmall.copy(
                                color = TextSecondary,
                                fontSize = 12.sp
                            )
                        )
                    }
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = "查看章節",
                        tint = TextMuted,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun WarningBoxView(
    data: WarningBoxData,
    modifier: Modifier = Modifier
) {
    val (bgColor, borderColor, iconTint, titleColor) = when (data.level) {
        WarningLevel.PROHIBITION -> Quad(HazardRedBg, HazardRed.copy(alpha = 0.5f), HazardRedLight, HazardRedLight)
        WarningLevel.WARNING -> Quad(WarningAmberBg, WarningAmber.copy(alpha = 0.5f), WarningAmberLight, WarningAmberLight)
        WarningLevel.CAUTION -> Quad(FrostedCardBgElevated, GlassBorderHighlight, AccentGold, AccentGold)
        WarningLevel.INFO -> Quad(FrostedCardBgElevated, RiverCyanLight.copy(alpha = 0.4f), RiverCyanLight, RiverCyanLight)
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(bgColor.copy(alpha = 0.5f), RoundedCornerShape(16.dp))
            .border(1.dp, borderColor, RoundedCornerShape(16.dp))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                imageVector = when (data.level) {
                    WarningLevel.PROHIBITION -> Icons.Default.Cancel
                    WarningLevel.WARNING -> Icons.Default.Warning
                    WarningLevel.CAUTION -> Icons.Default.Info
                    WarningLevel.INFO -> Icons.Default.Lightbulb
                },
                contentDescription = data.title,
                tint = iconTint,
                modifier = Modifier.size(20.dp)
            )
            Text(
                text = data.title,
                style = MaterialTheme.typography.titleSmall.copy(
                    fontWeight = FontWeight.Bold,
                    color = titleColor
                )
            )
        }

        Text(
            text = data.text,
            style = MaterialTheme.typography.bodyMedium.copy(
                color = TextPrimary,
                lineHeight = 20.sp
            )
        )

        if (data.bulletPoints.isNotEmpty()) {
            Column(
                modifier = Modifier.padding(top = 4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                data.bulletPoints.forEach { pt ->
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalAlignment = Alignment.Top
                    ) {
                        Text("•", color = iconTint, fontWeight = FontWeight.Bold)
                        Text(
                            text = pt,
                            style = MaterialTheme.typography.bodySmall.copy(color = TextPrimary)
                        )
                    }
                }
            }
        }
    }
}

private data class Quad<A, B, C, D>(val first: A, val second: B, val third: C, val fourth: D)

@Composable
fun ComparisonTableView(
    data: ComparisonTableData,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(FrostedInnerBg, RoundedCornerShape(16.dp))
            .border(1.dp, GlassBorderLight, RoundedCornerShape(16.dp))
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Headers
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .background(SafetyEmeraldBg.copy(alpha = 0.6f), RoundedCornerShape(10.dp))
                    .border(1.dp, SafetyEmerald.copy(alpha = 0.4f), RoundedCornerShape(10.dp))
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = data.idealHeader,
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontWeight = FontWeight.Bold,
                        color = SafetyEmeraldLight,
                        textAlign = TextAlign.Center
                    )
                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .background(HazardRedBg.copy(alpha = 0.6f), RoundedCornerShape(10.dp))
                    .border(1.dp, HazardRed.copy(alpha = 0.4f), RoundedCornerShape(10.dp))
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = data.dangerHeader,
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontWeight = FontWeight.Bold,
                        color = HazardRedLight,
                        textAlign = TextAlign.Center
                    )
                )
            }
        }

        // Rows
        data.rows.forEachIndexed { idx, row ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        if (idx % 2 == 0) FrostedCardBg else FrostedCardBgElevated.copy(alpha = 0.5f),
                        RoundedCornerShape(8.dp)
                    )
                    .border(1.dp, GlassBorderSubtle, RoundedCornerShape(8.dp))
                    .padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    Text("✓", color = SafetyEmeraldLight, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                    Text(
                        text = row.idealText,
                        style = MaterialTheme.typography.bodySmall.copy(color = TextPrimary, fontSize = 12.sp)
                    )
                }
                Row(
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    Text("✕", color = HazardRedLight, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                    Text(
                        text = row.dangerText,
                        style = MaterialTheme.typography.bodySmall.copy(color = TextPrimary, fontSize = 12.sp)
                    )
                }
            }
        }
    }
}

@Composable
fun LeaderCalloutCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .border(1.5.dp, AccentGold.copy(alpha = 0.6f), RoundedCornerShape(20.dp)),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = FrostedCardBgElevated)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Campaign,
                    contentDescription = "渡溪前10秒口令",
                    tint = AccentGold,
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "渡溪前 10 秒領隊口令",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = AccentGold
                    )
                )
            }

            Text(
                text = "溪邊現場帶隊時，領隊請直接以堅定、清晰語氣向全員複誦：",
                style = MaterialTheme.typography.bodySmall.copy(color = TextSecondary)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(FrostedInnerBg, RoundedCornerShape(14.dp))
                    .border(1.dp, GlassBorderSubtle, RoundedCornerShape(14.dp))
                    .padding(14.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                SafetyCurriculum.LEADER_COMMANDS_10SEC.forEachIndexed { i, cmd ->
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "0${i + 1}",
                            style = MaterialTheme.typography.labelSmall.copy(
                                color = RiverCyanLight,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Text(
                            text = cmd,
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = FontWeight.Bold,
                                color = TextPrimary
                            )
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun OneMinuteChecklistView(modifier: Modifier = Modifier) {
    var checkedStates by remember { mutableStateOf(setOf<Int>()) }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .border(1.dp, GlassBorderLight, RoundedCornerShape(20.dp)),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = FrostedCardBg)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "一分鐘溪邊檢查表",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = TextPrimary
                        )
                    )
                    Text(
                        text = "溪邊 8 問（現場互動自查）",
                        style = MaterialTheme.typography.labelSmall.copy(color = RiverCyanLight)
                    )
                }
                Box(
                    modifier = Modifier
                        .background(FrostedInnerBg, RoundedCornerShape(20.dp))
                        .border(1.dp, GlassBorderSubtle, RoundedCornerShape(20.dp))
                        .padding(horizontal = 10.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = "已確認 ${checkedStates.size} / 8",
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = if (checkedStates.size == 8) SafetyEmeraldLight else WarningAmberLight
                        )
                    )
                }
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                SafetyCurriculum.CHECKLIST_8_QUESTIONS.forEach { item ->
                    val isChecked = checkedStates.contains(item.id)
                    var isExpanded by remember { mutableStateOf(false) }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                if (isChecked) FrostedCardBgElevated else FrostedInnerBg,
                                RoundedCornerShape(12.dp)
                            )
                            .border(
                                1.dp,
                                if (isChecked) SafetyEmerald.copy(alpha = 0.5f) else GlassBorderSubtle,
                                RoundedCornerShape(12.dp)
                            )
                            .padding(12.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    checkedStates = if (isChecked) {
                                        checkedStates - item.id
                                    } else {
                                        checkedStates + item.id
                                    }
                                },
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Checkbox(
                                checked = isChecked,
                                onCheckedChange = { check ->
                                    checkedStates = if (check) {
                                        checkedStates + item.id
                                    } else {
                                        checkedStates - item.id
                                    }
                                },
                                colors = CheckboxDefaults.colors(
                                    checkedColor = SafetyEmerald,
                                    uncheckedColor = TextMuted
                                )
                            )
                            Text(
                                text = item.question,
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = if (isChecked) SafetyEmeraldLight else TextPrimary
                                ),
                                modifier = Modifier.weight(1f)
                            )
                            IconButton(
                                onClick = { isExpanded = !isExpanded },
                                modifier = Modifier.size(24.dp)
                            ) {
                                Icon(
                                    imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                                    contentDescription = "說明",
                                    tint = TextSecondary,
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        }

                        AnimatedVisibility(visible = isExpanded) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 8.dp, start = 36.dp),
                                verticalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Text(
                                    text = "【觀察引導】${item.observationGuide}",
                                    style = MaterialTheme.typography.bodySmall.copy(color = TextSecondary, fontSize = 12.sp)
                                )
                                Text(
                                    text = "【風險解析】${item.riskExplain}",
                                    style = MaterialTheme.typography.bodySmall.copy(color = WarningAmberLight, fontSize = 12.sp)
                                )
                            }
                        }
                    }
                }
            }

            // Bottom Alert
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(HazardRedBg.copy(alpha = 0.5f), RoundedCornerShape(12.dp))
                    .border(1.dp, HazardRed.copy(alpha = 0.5f), RoundedCornerShape(12.dp))
                    .padding(12.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ErrorOutline,
                        contentDescription = "警示",
                        tint = HazardRedLight,
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        text = "有任何一項無法確認，就不要急著下水。",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = HazardRedLight
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun DecisionFlowView(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .border(1.dp, GlassBorderLight, RoundedCornerShape(20.dp)),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = FrostedCardBg)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Column {
                Text(
                    text = "溪邊決策流程圖",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )
                )
                Text(
                    text = "抵達溪邊 ➔ 觀察 ➔ 關鍵安全門檻 ➔ 渡溪 ➔ 離床清點",
                    style = MaterialTheme.typography.labelSmall.copy(color = RiverCyanLight)
                )
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(0.dp)
            ) {
                SafetyCurriculum.DECISION_FLOW_STEPS.forEachIndexed { index, node ->
                    DecisionNodeRow(
                        node = node,
                        isLast = index == SafetyCurriculum.DECISION_FLOW_STEPS.lastIndex
                    )
                }
            }
        }
    }
}

@Composable
private fun DecisionNodeRow(node: DecisionNode, isLast: Boolean) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Step line & circle indicator
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.width(28.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(26.dp)
                    .background(
                        if (node.isCriticalGate) WarningAmberBg.copy(alpha = 0.8f) else FrostedCardBgElevated,
                        CircleShape
                    )
                    .border(
                        1.5.dp,
                        if (node.isCriticalGate) AccentGold else RiverCyanLight,
                        CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "${node.id}",
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontWeight = FontWeight.Bold,
                        color = if (node.isCriticalGate) AccentGold else RiverGlacier,
                        fontSize = 11.sp
                    )
                )
            }

            if (!isLast) {
                Box(
                    modifier = Modifier
                        .width(2.dp)
                        .height(64.dp)
                        .background(
                            Brush.verticalGradient(
                                listOf(RiverCyanLight.copy(alpha = 0.6f), GlassBorderSubtle)
                            )
                        )
                )
            }
        }

        // Card Content
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(bottom = if (isLast) 0.dp else 12.dp)
                .background(
                    if (node.isCriticalGate) FrostedInnerBg else FrostedCardBg.copy(alpha = 0.5f),
                    RoundedCornerShape(12.dp)
                )
                .border(
                    1.dp,
                    if (node.isCriticalGate) AccentGold.copy(alpha = 0.5f) else GlassBorderSubtle,
                    RoundedCornerShape(12.dp)
                )
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = node.stepTitle,
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontWeight = FontWeight.Bold,
                        color = if (node.isCriticalGate) AccentGold else TextPrimary
                    )
                )
                if (node.isCriticalGate) {
                    Box(
                        modifier = Modifier
                            .background(WarningAmberBg.copy(alpha = 0.6f), RoundedCornerShape(4.dp))
                            .border(1.dp, AccentGold.copy(alpha = 0.4f), RoundedCornerShape(4.dp))
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = "決策關鍵節點",
                            fontSize = 10.sp,
                            color = WarningAmberLight,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Text(
                text = node.description,
                style = MaterialTheme.typography.bodySmall.copy(color = TextSecondary, fontSize = 12.sp)
            )

            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "✓ 是 ➔ ${node.passCondition}",
                    style = MaterialTheme.typography.labelSmall.copy(color = SafetyEmeraldLight, fontSize = 11.sp)
                )
            }
            Text(
                text = "✕ 否 ➔ ${node.failAction}",
                style = MaterialTheme.typography.labelSmall.copy(color = HazardRedLight, fontSize = 11.sp)
            )
        }
    }
}

@Composable
fun CaseStudyInteractiveCard(
    caseStudy: CaseStudy,
    modifier: Modifier = Modifier
) {
    var selectedOptionId by remember { mutableStateOf<String?>(null) }
    val selectedOption = caseStudy.options.find { it.id == selectedOptionId }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .border(1.dp, GlassBorderLight, RoundedCornerShape(18.dp)),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = FrostedCardBg)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Header tag
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .background(RiverCyanDark.copy(alpha = 0.7f), RoundedCornerShape(6.dp))
                        .border(1.dp, GlassBorderHighlight, RoundedCornerShape(6.dp))
                        .padding(horizontal = 8.dp, vertical = 3.dp)
                ) {
                    Text(
                        text = caseStudy.tag,
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontWeight = FontWeight.Bold,
                            color = RiverGlacier
                        )
                    )
                }
                Text(
                    text = caseStudy.title,
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )
                )
            }

            // Situation
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(FrostedInnerBg, RoundedCornerShape(12.dp))
                    .border(1.dp, GlassBorderSubtle, RoundedCornerShape(12.dp))
                    .padding(12.dp)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text(
                        text = "【現場情境】",
                        style = MaterialTheme.typography.labelSmall.copy(
                            color = TextMuted,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = caseStudy.situation,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = TextPrimary,
                            lineHeight = 20.sp
                        )
                    )
                }
            }

            // Question
            Text(
                text = "❓ ${caseStudy.question}",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.SemiBold,
                    color = AccentGold
                )
            )

            // Options
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                caseStudy.options.forEach { opt ->
                    val isSelected = opt.id == selectedOptionId
                    val borderColor = if (isSelected) {
                        when (opt.outcomeType) {
                            WarningLevel.INFO -> SafetyEmerald
                            WarningLevel.PROHIBITION -> HazardRed
                            else -> WarningAmber
                        }
                    } else GlassBorderSubtle

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .background(if (isSelected) FrostedCardBgElevated else FrostedInnerBg)
                            .border(1.5.dp, borderColor, RoundedCornerShape(12.dp))
                            .clickable { selectedOptionId = opt.id }
                            .padding(12.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            RadioButton(
                                selected = isSelected,
                                onClick = { selectedOptionId = opt.id },
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = RiverCyanLight,
                                    unselectedColor = TextMuted
                                )
                            )
                            Text(
                                text = opt.label,
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    color = if (isSelected) TextPrimary else TextSecondary,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                                )
                            )
                        }
                    }
                }
            }

            // Feedback and Analysis (Revealed on selection)
            AnimatedVisibility(visible = selectedOption != null) {
                selectedOption?.let { opt ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 4.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        // Option feedback
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(
                                    when (opt.outcomeType) {
                                        WarningLevel.INFO -> SafetyEmeraldBg.copy(alpha = 0.5f)
                                        WarningLevel.PROHIBITION -> HazardRedBg.copy(alpha = 0.5f)
                                        else -> WarningAmberBg.copy(alpha = 0.5f)
                                    },
                                    RoundedCornerShape(12.dp)
                                )
                                .border(
                                    1.dp,
                                    when (opt.outcomeType) {
                                        WarningLevel.INFO -> SafetyEmerald.copy(alpha = 0.5f)
                                        WarningLevel.PROHIBITION -> HazardRed.copy(alpha = 0.5f)
                                        else -> WarningAmber.copy(alpha = 0.5f)
                                    },
                                    RoundedCornerShape(12.dp)
                                )
                                .padding(12.dp)
                        ) {
                            Text(
                                text = opt.safetyFeedback,
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    color = TextPrimary,
                                    fontWeight = FontWeight.Medium
                                )
                            )
                        }

                        // Expert analysis & Core Lesson
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(FrostedInnerBg, RoundedCornerShape(12.dp))
                                .border(1.dp, GlassBorderSubtle, RoundedCornerShape(12.dp))
                                .padding(12.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = "【專業安全剖析】",
                                style = MaterialTheme.typography.labelSmall.copy(
                                    color = RiverCyanLight,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                            Text(
                                text = caseStudy.expertAnalysis,
                                style = MaterialTheme.typography.bodySmall.copy(
                                    color = TextSecondary,
                                    lineHeight = 18.sp
                                )
                            )
                            HorizontalDivider(color = GlassBorderSubtle)
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Text(
                                    text = "核心教訓：",
                                    style = MaterialTheme.typography.labelSmall.copy(
                                        color = AccentGold,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                                Text(
                                    text = caseStudy.coreLesson,
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        color = TextPrimary,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SafetyBaselineSection(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .border(1.5.dp, SafetyEmerald.copy(alpha = 0.5f), RoundedCornerShape(22.dp)),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(containerColor = FrostedCardBgElevated)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Verified,
                    contentDescription = "安全底線",
                    tint = SafetyEmeraldLight,
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "最重要的安全底線",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = SafetyEmeraldLight
                    )
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(FrostedInnerBg, RoundedCornerShape(14.dp))
                    .border(1.dp, GlassBorderSubtle, RoundedCornerShape(14.dp))
                    .padding(14.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(
                    text = "記住：",
                    style = MaterialTheme.typography.labelMedium.copy(
                        color = WarningAmberLight,
                        fontWeight = FontWeight.Bold
                    )
                )
                SafetyCurriculum.SAFETY_BASELINE.forEach { line ->
                    Text(
                        text = "• $line",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = TextPrimary,
                            fontWeight = FontWeight.Medium
                        )
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Brush.horizontalGradient(
                            listOf(SafetyEmeraldBg.copy(alpha = 0.7f), FrostedInnerBg)
                        ),
                        RoundedCornerShape(14.dp)
                    )
                    .border(1.dp, SafetyEmeraldLight.copy(alpha = 0.4f), RoundedCornerShape(14.dp))
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = SafetyCurriculum.FINAL_GOLDEN_RULE,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = SafetyEmeraldLight,
                        textAlign = TextAlign.Center,
                        lineHeight = 24.sp
                    )
                )
            }
        }
    }
}

@Composable
fun ExternalCitationCard(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Card(
        modifier = modifier
            .fillMaxWidth()
            .border(1.dp, GlassBorderLight, RoundedCornerShape(16.dp)),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = FrostedCardBg)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.MenuBook,
                    contentDescription = "技術參考資料",
                    tint = RiverCyanLight,
                    modifier = Modifier.size(18.dp)
                )
                Text(
                    text = "技術參考資料與原創設計宣告",
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )
                )
            }

            Text(
                text = "技術參考資料：${SafetyCurriculum.REFERENCE_TITLE}",
                style = MaterialTheme.typography.bodySmall.copy(color = TextSecondary)
            )

            // Clickable URL
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(FrostedInnerBg)
                    .border(1.dp, GlassBorderHighlight, RoundedCornerShape(10.dp))
                    .clickable {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(SafetyCurriculum.REFERENCE_URL))
                        context.startActivity(intent)
                    }
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = SafetyCurriculum.REFERENCE_URL,
                    style = MaterialTheme.typography.labelSmall.copy(
                        color = RiverCyanLight,
                        fontSize = 11.sp
                    ),
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    imageVector = Icons.Default.OpenInNew,
                    contentDescription = "開啟連結",
                    tint = RiverCyanLight,
                    modifier = Modifier.size(16.dp)
                )
            }

            Text(
                text = SafetyCurriculum.REFERENCE_DISCLAIMER,
                style = MaterialTheme.typography.bodySmall.copy(
                    color = TextMuted,
                    fontSize = 11.sp,
                    lineHeight = 16.sp
                )
            )
        }
    }
}
