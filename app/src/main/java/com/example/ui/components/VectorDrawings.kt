package com.example.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.*

@Composable
fun OriginalDiagramContainer(
    title: String,
    subtitle: String,
    badgeText: String = "原創教學圖解",
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
            .background(FrostedCardBg, RoundedCornerShape(20.dp))
            .border(1.dp, GlassBorderLight, RoundedCornerShape(20.dp))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )
            )
            Box(
                modifier = Modifier
                    .background(RiverCyanDark.copy(alpha = 0.5f), RoundedCornerShape(8.dp))
                    .border(1.dp, GlassBorderHighlight, RoundedCornerShape(8.dp))
                    .padding(horizontal = 8.dp, vertical = 3.dp)
            ) {
                Text(
                    text = badgeText,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = RiverGlacier
                )
            }
        }
        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodySmall.copy(color = TextSecondary),
            modifier = Modifier.padding(top = 4.dp, bottom = 12.dp)
        )

        content()
    }
}

/**
 * Chapter 14: 人包分離原創教學圖解
 * 左右/上下對照：A 正常狀態 / B 失足拖曳 / C 核心概念（人的脫困能力 > 保住背包）
 */
@Composable
fun BackpackSeparationDiagram(modifier: Modifier = Modifier) {
    OriginalDiagramContainer(
        title = "人包分離物理機制圖解",
        subtitle = "A 正常通過姿態 ➔ B 失足水阻拖曳 ➔ C 解扣脫困生命優先"
    ) {
        Column(
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Panel A
            DiagramSectionCard(
                label = "A｜正常狀態（預先解開扣具）",
                labelColor = SafetyEmeraldLight,
                description = "解開胸扣與腰扣，登山杖輔助支撐，水深及膝以下，維持前傾平衡"
            ) {
                Canvas(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(130.dp)
                ) {
                    drawBackpackNormalState()
                }
            }

            // Panel B
            DiagramSectionCard(
                label = "B｜失足情境（背包水阻拖曳危機）",
                labelColor = HazardRedLight,
                description = "若扣具鎖死，落水時背包如水帆產生強大拖曳阻力，將人體向後下拉入急流"
            ) {
                Canvas(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(130.dp)
                ) {
                    drawBackpackDragHazard()
                }
            }

            // Panel C
            DiagramSectionCard(
                label = "C｜核心概念：人的脫困能力 > 保住裝備",
                labelColor = RiverCyanLight,
                description = "果斷單手解除肩帶拋棄背包，水阻消失，人體迅速浮起恢復自由游動能力"
            ) {
                Canvas(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(130.dp)
                ) {
                    drawBackpackSeparationSuccess()
                }
            }
        }
    }
}

/**
 * Chapter 16: 鐘擺式確保過溪原創教學圖解
 * 包含 8 大標示：①渡溪者 ②確保者 ③主繩 ④固定點 ⑤水流方向 ⑥渡溪方向 ⑦撤退方向 ⑧岸上安全區
 */
@Composable
fun PendulumTraverseDiagram(modifier: Modifier = Modifier) {
    OriginalDiagramContainer(
        title = "鐘擺式確保過溪力學與系統配置",
        subtitle = "繩索系統之目的在於建立可控制的弧形擺動與安全撤退能力",
        badgeText = "專業進階力學圖解"
    ) {
        Column(
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
                    .background(FrostedInnerBg, RoundedCornerShape(12.dp))
                    .border(1.dp, GlassBorderSubtle, RoundedCornerShape(12.dp))
            ) {
                drawPendulumTraverseFullSystem()
            }

            // Legend indicators
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(FrostedInnerBg, RoundedCornerShape(12.dp))
                    .border(1.dp, GlassBorderSubtle, RoundedCornerShape(12.dp))
                    .padding(10.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(
                    text = "【圖例與系統核心元件標示】",
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("① 渡溪者（弧形移動）", fontSize = 11.sp, color = RiverCyanLight)
                    Text("② 確保者（岸上動態放繩）", fontSize = 11.sp, color = SafetyEmeraldLight)
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("③ 主繩（上游錨定）", fontSize = 11.sp, color = AccentGold)
                    Text("④ 固定確保點（上游堅固樹石）", fontSize = 11.sp, color = WarningAmberLight)
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("⑤ ➔ 水流方向（向下游推力）", fontSize = 11.sp, color = RiverCyan)
                    Text("⑥ ➔ 渡溪方向（橫向切過）", fontSize = 11.sp, color = SafetyEmerald)
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("⑦ ➔ 撤退方向（受阻順擺回岸）", fontSize = 11.sp, color = HazardRedLight)
                    Text("⑧ 岸上安全區（出發與接應岸）", fontSize = 11.sp, color = RiverGlacier)
                }
            }
        }
    }
}

/**
 * Chapter 04: 河道地形與寬緩淺 vs 窄急深剖面對比圖
 */
@Composable
fun RiverCrossSectionDiagram(modifier: Modifier = Modifier) {
    OriginalDiagramContainer(
        title = "渡溪選點地形對比剖面",
        subtitle = "寬、緩、淺（能量分散） vs 窄、急、深（能量高度集中）"
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .background(FrostedInnerBg, RoundedCornerShape(12.dp))
                .border(1.dp, GlassBorderSubtle, RoundedCornerShape(12.dp))
        ) {
            drawRiverCrossSectionComparison()
        }
    }
}

/**
 * Chapter 07: 沙洲與河中島孤立陷阱圖解
 */
@Composable
fun SandbankTrapDiagram(modifier: Modifier = Modifier) {
    OriginalDiagramContainer(
        title = "沙洲與河中島孤立死局圖解",
        subtitle = "水位突升時兩側水道迅速暴漲，中繼點瞬間變為四面受困孤島",
        badgeText = "陷阱警示"
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(FrostedInnerBg, RoundedCornerShape(12.dp))
                .border(1.dp, GlassBorderSubtle, RoundedCornerShape(12.dp))
        ) {
            drawSandbankTrapScene()
        }
    }
}

@Composable
private fun DiagramSectionCard(
    label: String,
    labelColor: Color,
    description: String,
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(FrostedInnerBg, RoundedCornerShape(12.dp))
            .border(1.dp, GlassBorderSubtle, RoundedCornerShape(12.dp))
            .padding(10.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium.copy(
                fontWeight = FontWeight.Bold,
                color = labelColor
            )
        )
        Text(
            text = description,
            style = MaterialTheme.typography.bodySmall.copy(
                color = TextSecondary,
                fontSize = 11.sp
            ),
            modifier = Modifier.padding(top = 2.dp, bottom = 6.dp)
        )
        content()
    }
}

// -------------------------------------------------------------
// Compose Canvas Drawing Implementation Functions
// -------------------------------------------------------------

private fun DrawScope.drawBackpackNormalState() {
    val w = size.width
    val h = size.height

    // River bed & water
    drawRect(
        brush = Brush.verticalGradient(
            colors = listOf(Color(0xFF0F2B3B), Color(0xFF0A1E29)),
            startY = h * 0.45f,
            endY = h
        ),
        topLeft = Offset(0f, h * 0.45f),
        size = Size(w, h * 0.55f)
    )

    // River bottom rocks
    drawCircle(Color(0xFF334155), radius = 18f, center = Offset(w * 0.2f, h * 0.9f))
    drawCircle(Color(0xFF475569), radius = 24f, center = Offset(w * 0.5f, h * 0.92f))
    drawCircle(Color(0xFF334155), radius = 20f, center = Offset(w * 0.8f, h * 0.9f))

    // Water level wave line
    val wavePath = Path().apply {
        moveTo(0f, h * 0.5f)
        cubicTo(w * 0.25f, h * 0.46f, w * 0.5f, h * 0.54f, w * 0.75f, h * 0.48f)
        lineTo(w, h * 0.52f)
    }
    drawPath(wavePath, color = RiverCyanLight.copy(alpha = 0.6f), style = Stroke(width = 3f))

    // Water current flow arrows
    drawArrow(
        start = Offset(w * 0.08f, h * 0.65f),
        end = Offset(w * 0.32f, h * 0.65f),
        color = RiverCyanLight.copy(alpha = 0.7f),
        strokeWidth = 3f
    )
    drawArrow(
        start = Offset(w * 0.65f, h * 0.65f),
        end = Offset(w * 0.92f, h * 0.65f),
        color = RiverCyanLight.copy(alpha = 0.7f),
        strokeWidth = 3f
    )

    // Hiker Figure (Normal standing with poles & unbuckled pack)
    val cx = w * 0.48f
    val headY = h * 0.22f

    // Head
    drawCircle(Color(0xFFFDE047), radius = 12f, center = Offset(cx, headY))

    // Torso (slightly leaning forward)
    val shoulderY = headY + 12f
    val hipY = headY + 46f
    drawLine(
        color = SafetyEmeraldLight,
        start = Offset(cx, shoulderY),
        end = Offset(cx - 6f, hipY),
        strokeWidth = 8f
    )

    // Backpack on back (Back is right side of torso)
    drawRoundRect(
        color = Color(0xFF0284C7),
        topLeft = Offset(cx - 24f, shoulderY - 2f),
        size = Size(16f, 32f),
        cornerRadius = CornerRadius(4f, 4f)
    )

    // Unbuckled indicator (open buckle icon)
    drawLine(
        color = WarningAmberLight,
        start = Offset(cx - 6f, shoulderY + 12f),
        end = Offset(cx + 4f, shoulderY + 14f),
        strokeWidth = 3f
    )

    // Legs
    drawLine(
        color = SafetyEmeraldLight,
        start = Offset(cx - 6f, hipY),
        end = Offset(cx - 16f, h * 0.88f),
        strokeWidth = 6f
    )
    drawLine(
        color = SafetyEmeraldLight,
        start = Offset(cx - 6f, hipY),
        end = Offset(cx + 12f, h * 0.88f),
        strokeWidth = 6f
    )

    // Trekking pole
    drawLine(
        color = Color(0xFFCBD5E1),
        start = Offset(cx + 10f, shoulderY + 14f),
        end = Offset(cx + 28f, h * 0.88f),
        strokeWidth = 3.5f
    )
    drawCircle(Color(0xFF94A3B8), radius = 4f, center = Offset(cx + 28f, h * 0.88f))
}

private fun DrawScope.drawBackpackDragHazard() {
    val w = size.width
    val h = size.height

    // Deeper and more aggressive turbulent water
    drawRect(
        brush = Brush.verticalGradient(
            colors = listOf(Color(0xFF1E3A5F), Color(0xFF0C1A2E)),
            startY = h * 0.35f,
            endY = h
        ),
        topLeft = Offset(0f, h * 0.35f),
        size = Size(w, h * 0.65f)
    )

    // Rapid waves
    val wavePath = Path().apply {
        moveTo(0f, h * 0.42f)
        cubicTo(w * 0.2f, h * 0.34f, w * 0.4f, h * 0.48f, w * 0.6f, h * 0.36f)
        cubicTo(w * 0.8f, h * 0.46f, w * 0.9f, h * 0.38f, w, h * 0.42f)
    }
    drawPath(wavePath, color = RiverCyanLight, style = Stroke(width = 4f))

    // Severe flow vectors
    drawArrow(
        start = Offset(w * 0.05f, h * 0.55f),
        end = Offset(w * 0.35f, h * 0.55f),
        color = HazardRedLight,
        strokeWidth = 4f
    )
    drawArrow(
        start = Offset(w * 0.65f, h * 0.55f),
        end = Offset(w * 0.95f, h * 0.55f),
        color = HazardRedLight,
        strokeWidth = 4f
    )

    // Fallen figure tilted backwards
    val cx = w * 0.45f
    val cy = h * 0.58f

    // Head near water
    drawCircle(Color(0xFFFCA5A5), radius = 12f, center = Offset(cx + 25f, cy - 10f))

    // Torso pulled backwards
    drawLine(
        color = HazardRedLight,
        start = Offset(cx + 18f, cy),
        end = Offset(cx - 18f, cy + 18f),
        strokeWidth = 8f
    )

    // Heavy waterlogged backpack submerged & dragging
    drawRoundRect(
        color = Color(0xFF991B1B),
        topLeft = Offset(cx - 40f, cy + 8f),
        size = Size(24f, 38f),
        cornerRadius = CornerRadius(6f, 6f)
    )

    // Downward drag force arrow
    drawArrow(
        start = Offset(cx - 28f, cy + 26f),
        end = Offset(cx - 28f, cy + 62f),
        color = HazardRed,
        strokeWidth = 4f
    )

    // Backward pull arrow
    drawArrow(
        start = Offset(cx - 42f, cy + 20f),
        end = Offset(cx - 75f, cy + 20f),
        color = HazardRed,
        strokeWidth = 4f
    )
}

private fun DrawScope.drawBackpackSeparationSuccess() {
    val w = size.width
    val h = size.height

    // River background
    drawRect(
        brush = Brush.verticalGradient(
            colors = listOf(Color(0xFF0F2B3B), Color(0xFF0A1E29)),
            startY = h * 0.4f,
            endY = h
        ),
        topLeft = Offset(0f, h * 0.4f),
        size = Size(w, h * 0.6f)
    )

    // Waterline
    val wavePath = Path().apply {
        moveTo(0f, h * 0.45f)
        cubicTo(w * 0.3f, h * 0.4f, w * 0.6f, h * 0.5f, w, h * 0.45f)
    }
    drawPath(wavePath, color = RiverCyanLight, style = Stroke(width = 3f))

    // Released floating backpack drifting downstream (right)
    val packX = w * 0.75f
    val packY = h * 0.55f
    drawRoundRect(
        color = Color(0xFF475569),
        topLeft = Offset(packX, packY),
        size = Size(26f, 32f),
        cornerRadius = CornerRadius(5f, 5f)
    )
    drawArrow(
        start = Offset(packX + 28f, packY + 16f),
        end = Offset(packX + 58f, packY + 16f),
        color = TextSecondary,
        strokeWidth = 3f
    )

    // Unlocked buckle spark
    drawCircle(Color(0xFFFBBF24), radius = 6f, center = Offset(packX - 6f, packY + 10f))

    // Freed human body floating up towards left shore
    val hx = w * 0.32f
    val hy = h * 0.48f

    // Head high above water
    drawCircle(Color(0xFF6EE7B7), radius = 13f, center = Offset(hx - 15f, hy - 16f))

    // Torso swimming/sculling
    drawLine(
        color = SafetyEmeraldLight,
        start = Offset(hx - 10f, hy - 6f),
        end = Offset(hx + 22f, hy + 4f),
        strokeWidth = 8f
    )

    // Arms reaching for safe shore
    drawLine(
        color = SafetyEmeraldLight,
        start = Offset(hx - 8f, hy - 6f),
        end = Offset(hx - 36f, hy - 18f),
        strokeWidth = 5f
    )

    // Upward buoyancy arrow
    drawArrow(
        start = Offset(hx + 5f, hy + 28f),
        end = Offset(hx + 5f, hy - 5f),
        color = SafetyEmerald,
        strokeWidth = 4f
    )
}

private fun DrawScope.drawPendulumTraverseFullSystem() {
    val w = size.width
    val h = size.height

    // River Left & Right Banks
    val leftBankWidth = w * 0.28f
    val rightBankWidth = w * 0.22f

    // Left Bank (Starting/Safe Bank)
    drawRect(
        brush = Brush.horizontalGradient(
            colors = listOf(Color(0xFF1E293B), Color(0xFF334155)),
            startX = 0f,
            endX = leftBankWidth
        ),
        topLeft = Offset(0f, 0f),
        size = Size(leftBankWidth, h)
    )

    // Right Bank (Target Landing Shore)
    drawRect(
        brush = Brush.horizontalGradient(
            colors = listOf(Color(0xFF334155), Color(0xFF1E293B)),
            startX = w - rightBankWidth,
            endX = w
        ),
        topLeft = Offset(w - rightBankWidth, 0f),
        size = Size(rightBankWidth, h)
    )

    // River Channel in between
    val riverX = leftBankWidth
    val riverW = w - leftBankWidth - rightBankWidth
    drawRect(
        brush = Brush.verticalGradient(
            colors = listOf(Color(0xFF0369A1), Color(0xFF075985), Color(0xFF0C4A6E)),
            startY = 0f,
            endY = h
        ),
        topLeft = Offset(riverX, 0f),
        size = Size(riverW, h)
    )

    // ⑤ Downstream Flow Direction Arrows (Multiple blue/cyan arrows)
    for (i in 1..4) {
        val arrowY = h * (0.2f + i * 0.16f)
        drawArrow(
            start = Offset(riverX + riverW * 0.35f, arrowY - 24f),
            end = Offset(riverX + riverW * 0.35f, arrowY + 24f),
            color = RiverCyanLight.copy(alpha = 0.6f),
            strokeWidth = 3f
        )
        drawArrow(
            start = Offset(riverX + riverW * 0.7f, arrowY - 20f),
            end = Offset(riverX + riverW * 0.7f, arrowY + 20f),
            color = RiverCyanLight.copy(alpha = 0.6f),
            strokeWidth = 3f
        )
    }

    // ④ Upstream Anchor Point (Fixed Tree / Rock)
    val anchorX = leftBankWidth - 24f
    val anchorY = h * 0.14f
    drawCircle(Color(0xFFD97706), radius = 14f, center = Offset(anchorX, anchorY))
    drawCircle(Color(0xFFFDE68A), radius = 7f, center = Offset(anchorX, anchorY))

    // ② Belayer on Left Bank
    val belayerX = leftBankWidth - 36f
    val belayerY = h * 0.32f
    drawCircle(Color(0xFF34D399), radius = 10f, center = Offset(belayerX, belayerY))
    drawLine(
        color = Color(0xFF34D399),
        start = Offset(belayerX, belayerY + 10f),
        end = Offset(belayerX, belayerY + 34f),
        strokeWidth = 6f
    )

    // ① Crossing Hiker Position in Stream (at arc midpoint)
    val hikerX = riverX + riverW * 0.58f
    val hikerY = h * 0.58f

    // ③ Main Rope Path (From Anchor -> Belayer -> Hiker arc)
    val ropePath = Path().apply {
        moveTo(anchorX, anchorY)
        lineTo(belayerX, belayerY + 12f)
        cubicTo(
            riverX + 20f, h * 0.36f,
            riverX + riverW * 0.3f, h * 0.44f,
            hikerX, hikerY
        )
    }
    drawPath(
        path = ropePath,
        color = AccentGold,
        style = Stroke(width = 4.5f)
    )

    // Pendulum Arc Traverse Track (Dotted Line)
    val arcPath = Path().apply {
        moveTo(leftBankWidth, h * 0.68f)
        cubicTo(
            riverX + riverW * 0.35f, h * 0.64f,
            riverX + riverW * 0.7f, h * 0.56f,
            w - rightBankWidth, h * 0.48f
        )
    }
    drawPath(
        path = arcPath,
        color = TextSecondary.copy(alpha = 0.5f),
        style = Stroke(
            width = 2.5f,
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f))
        )
    )

    // ⑥ Traversal Direction (Green Arrow across river)
    drawArrow(
        start = Offset(hikerX - 30f, hikerY - 18f),
        end = Offset(hikerX + 40f, hikerY - 32f),
        color = SafetyEmeraldLight,
        strokeWidth = 3.5f
    )

    // ⑦ Retreat Direction (Orange/Red curve swinging back to left shore)
    drawArrow(
        start = Offset(hikerX - 10f, hikerY + 15f),
        end = Offset(riverX + 15f, h * 0.72f),
        color = HazardRedLight,
        strokeWidth = 3.5f
    )

    // Draw Hiker Figure
    drawCircle(Color(0xFF38BDF8), radius = 11f, center = Offset(hikerX, hikerY - 14f))
    drawLine(
        color = Color(0xFF38BDF8),
        start = Offset(hikerX, hikerY - 3f),
        end = Offset(hikerX - 6f, hikerY + 22f),
        strokeWidth = 6f
    )
    // Quick Carabiner attachment
    drawCircle(Color(0xFFF59E0B), radius = 5f, center = Offset(hikerX - 2f, hikerY + 4f))

    // ⑧ Safe Shore Label highlight
    drawRoundRect(
        color = SafetyEmeraldBg.copy(alpha = 0.7f),
        topLeft = Offset(8f, h * 0.75f),
        size = Size(leftBankWidth - 16f, 32f),
        cornerRadius = CornerRadius(6f, 6f)
    )
}

private fun DrawScope.drawRiverCrossSectionComparison() {
    val w = size.width
    val h = size.height

    val midX = w * 0.5f

    // Left half: 寬、緩、淺 (Wide & Shallow)
    drawRect(
        color = SlateDark800,
        topLeft = Offset(0f, 0f),
        size = Size(midX - 4f, h)
    )
    // River bed curve (shallow & wide)
    val wideBedPath = Path().apply {
        moveTo(10f, h * 0.35f)
        cubicTo(midX * 0.2f, h * 0.7f, midX * 0.8f, h * 0.7f, midX - 10f, h * 0.35f)
        lineTo(midX - 10f, h)
        lineTo(10f, h)
        close()
    }
    drawPath(wideBedPath, color = Color(0xFF1E293B))

    val wideWaterPath = Path().apply {
        moveTo(10f, h * 0.42f)
        cubicTo(midX * 0.2f, h * 0.7f, midX * 0.8f, h * 0.7f, midX - 10f, h * 0.42f)
        lineTo(midX - 10f, h * 0.42f)
        close()
    }
    drawPath(wideWaterPath, color = RiverCyanDark.copy(alpha = 0.6f))
    drawArrow(
        start = Offset(midX * 0.3f, h * 0.52f),
        end = Offset(midX * 0.7f, h * 0.52f),
        color = SafetyEmeraldLight,
        strokeWidth = 3f
    )

    // Divider
    drawLine(
        color = SlateBorder,
        start = Offset(midX, 10f),
        end = Offset(midX, h - 10f),
        strokeWidth = 2f
    )

    // Right half: 窄、急、深 (Narrow, Deep Canyon)
    drawRect(
        color = SlateDark800,
        topLeft = Offset(midX + 4f, 0f),
        size = Size(midX - 4f, h)
    )
    // River bed steep gorge
    val narrowBedPath = Path().apply {
        moveTo(midX + 15f, h * 0.2f)
        lineTo(midX + midX * 0.35f, h * 0.25f)
        lineTo(midX + midX * 0.4f, h * 0.88f)
        lineTo(midX + midX * 0.6f, h * 0.88f)
        lineTo(midX + midX * 0.65f, h * 0.25f)
        lineTo(w - 15f, h * 0.2f)
        lineTo(w - 15f, h)
        lineTo(midX + 15f, h)
        close()
    }
    drawPath(narrowBedPath, color = Color(0xFF1E293B))

    // Deep water rectangle
    drawRect(
        brush = Brush.verticalGradient(
            colors = listOf(RiverCyanLight, Color(0xFF082F49)),
            startY = h * 0.3f,
            endY = h * 0.88f
        ),
        topLeft = Offset(midX + midX * 0.4f, h * 0.3f),
        size = Size(midX * 0.2f, h * 0.58f)
    )

    // Severe flow vectors
    drawArrow(
        start = Offset(midX + midX * 0.5f, h * 0.38f),
        end = Offset(midX + midX * 0.5f, h * 0.78f),
        color = HazardRed,
        strokeWidth = 4f
    )
}

private fun DrawScope.drawSandbankTrapScene() {
    val w = size.width
    val h = size.height

    // Main River Background
    drawRect(
        brush = Brush.verticalGradient(
            colors = listOf(Color(0xFF0369A1), Color(0xFF075985), Color(0xFF0C4A6E)),
            startY = 0f,
            endY = h
        ),
        topLeft = Offset(0f, 0f),
        size = Size(w, h)
    )

    // Left Shore
    drawRect(
        color = Color(0xFF334155),
        topLeft = Offset(0f, 0f),
        size = Size(w * 0.18f, h)
    )

    // Right Shore
    drawRect(
        color = Color(0xFF334155),
        topLeft = Offset(w * 0.82f, 0f),
        size = Size(w * 0.18f, h)
    )

    // Middle Sandbank Island (Dry yellow sand area)
    val sandX = w * 0.36f
    val sandY = h * 0.32f
    val sandW = w * 0.28f
    val sandH = h * 0.36f
    drawRoundRect(
        color = SandDune,
        topLeft = Offset(sandX, sandY),
        size = Size(sandW, sandH),
        cornerRadius = CornerRadius(20f, 20f)
    )
    drawRoundRect(
        color = AccentGold.copy(alpha = 0.8f),
        topLeft = Offset(sandX + 10f, sandY + 8f),
        size = Size(sandW - 20f, sandH - 16f),
        cornerRadius = CornerRadius(14f, 14f)
    )

    // Stranded Figure on Sandbank
    val figX = sandX + sandW * 0.5f
    val figY = sandY + sandH * 0.45f
    drawCircle(Color(0xFFEF4444), radius = 8f, center = Offset(figX, figY - 12f))
    drawLine(
        color = Color(0xFFEF4444),
        start = Offset(figX, figY - 4f),
        end = Offset(figX, figY + 16f),
        strokeWidth = 4.5f
    )

    // Rising Water Arrows cutting off Left Channel & Right Channel
    drawArrow(
        start = Offset(w * 0.26f, h * 0.15f),
        end = Offset(w * 0.26f, h * 0.85f),
        color = HazardRedLight,
        strokeWidth = 4f
    )
    drawArrow(
        start = Offset(w * 0.74f, h * 0.15f),
        end = Offset(w * 0.74f, h * 0.85f),
        color = HazardRedLight,
        strokeWidth = 4f
    )

    // Blocked Retreat X Marks
    drawBlockedX(center = Offset(w * 0.27f, h * 0.5f), size = 16f)
    drawBlockedX(center = Offset(w * 0.73f, h * 0.5f), size = 16f)
}

private fun DrawScope.drawArrow(
    start: Offset,
    end: Offset,
    color: Color,
    strokeWidth: Float
) {
    drawLine(color = color, start = start, end = end, strokeWidth = strokeWidth)
    val dx = end.x - start.x
    val dy = end.y - start.y
    val len = Math.hypot(dx.toDouble(), dy.toDouble()).toFloat()
    if (len > 0f) {
        val uX = dx / len
        val uY = dy / len
        val arrowSize = strokeWidth * 3.5f
        val perpX = -uY
        val perpY = uX

        val p1 = Offset(
            end.x - uX * arrowSize + perpX * (arrowSize * 0.6f),
            end.y - uY * arrowSize + perpY * (arrowSize * 0.6f)
        )
        val p2 = Offset(
            end.x - uX * arrowSize - perpX * (arrowSize * 0.6f),
            end.y - uY * arrowSize - perpY * (arrowSize * 0.6f)
        )

        val path = Path().apply {
            moveTo(end.x, end.y)
            lineTo(p1.x, p1.y)
            lineTo(p2.x, p2.y)
            close()
        }
        drawPath(path, color = color)
    }
}

private fun DrawScope.drawBlockedX(center: Offset, size: Float) {
    val r = size / 2f
    drawLine(
        color = HazardRed,
        start = Offset(center.x - r, center.y - r),
        end = Offset(center.x + r, center.y + r),
        strokeWidth = 4f
    )
    drawLine(
        color = HazardRed,
        start = Offset(center.x - r, center.y + r),
        end = Offset(center.x + r, center.y - r),
        strokeWidth = 4f
    )
}
