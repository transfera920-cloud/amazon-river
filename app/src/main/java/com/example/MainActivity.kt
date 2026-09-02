package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.SafetyCurriculum
import com.example.model.Chapter
import com.example.ui.screens.*
import com.example.ui.theme.*

sealed class AppScreen {
    data object Home : AppScreen()
    data class ChapterDetail(val chapterId: Int) : AppScreen()
    data object DecisionFlow : AppScreen()
    data object Checklist : AppScreen()
    data object CaseStudies : AppScreen()
}

enum class NavigationTab(val title: String, val icon: ImageVector) {
    HOME("教案首頁", Icons.Default.MenuBook),
    CHECKLIST("溪邊8問", Icons.Default.CheckCircleOutline),
    DECISION("決策流程", Icons.Default.AltRoute),
    CASES("案例演練", Icons.Default.Quiz)
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                RiverCrossingSafetyApp()
            }
        }
    }
}

@Composable
fun RiverCrossingSafetyApp() {
    var currentScreen by remember { mutableStateOf<AppScreen>(AppScreen.Home) }
    var selectedTab by remember { mutableStateOf(NavigationTab.HOME) }
    var readChapterIds by remember { mutableStateOf(setOf<Int>()) }
    var bookmarkedChapterIds by remember { mutableStateOf(setOf<Int>()) }

    // Handle back button smoothly
    BackHandler(enabled = currentScreen !is AppScreen.Home) {
        currentScreen = AppScreen.Home
        selectedTab = NavigationTab.HOME
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = FrostedGlassCanvas,
        bottomBar = {
            NavigationBar(
                containerColor = FrostedGlassNavBg,
                contentColor = TextPrimary,
                tonalElevation = 0.dp,
                modifier = Modifier
                    .border(0.5.dp, GlassBorderSubtle, RoundedCornerShape(topStart = 18.dp, topEnd = 18.dp))
                    .windowInsetsPadding(WindowInsets.navigationBars)
            ) {
                NavigationTab.entries.forEach { tab ->
                    val isSelected = when (currentScreen) {
                        is AppScreen.Home -> tab == NavigationTab.HOME
                        is AppScreen.Checklist -> tab == NavigationTab.CHECKLIST
                        is AppScreen.DecisionFlow -> tab == NavigationTab.DECISION
                        is AppScreen.CaseStudies -> tab == NavigationTab.CASES
                        is AppScreen.ChapterDetail -> false
                    }

                    NavigationBarItem(
                        selected = isSelected,
                        onClick = {
                            selectedTab = tab
                            currentScreen = when (tab) {
                                NavigationTab.HOME -> AppScreen.Home
                                NavigationTab.CHECKLIST -> AppScreen.Checklist
                                NavigationTab.DECISION -> AppScreen.DecisionFlow
                                NavigationTab.CASES -> AppScreen.CaseStudies
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = tab.icon,
                                contentDescription = tab.title
                            )
                        },
                        label = {
                            Text(
                                text = tab.title,
                                fontSize = 11.sp,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = RiverGlacier,
                            selectedTextColor = RiverCyanLight,
                            indicatorColor = RiverCyanDark.copy(alpha = 0.8f),
                            unselectedIconColor = TextMuted,
                            unselectedTextColor = TextMuted
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (val screen = currentScreen) {
                is AppScreen.Home -> {
                    HomeScreen(
                        readChapterIds = readChapterIds,
                        bookmarkedChapterIds = bookmarkedChapterIds,
                        onSelectChapter = { chapter ->
                            currentScreen = AppScreen.ChapterDetail(chapter.id)
                        },
                        onNavigateToDecisionFlow = {
                            currentScreen = AppScreen.DecisionFlow
                            selectedTab = NavigationTab.DECISION
                        },
                        onNavigateToChecklist = {
                            currentScreen = AppScreen.Checklist
                            selectedTab = NavigationTab.CHECKLIST
                        },
                        onNavigateToCaseStudies = {
                            currentScreen = AppScreen.CaseStudies
                            selectedTab = NavigationTab.CASES
                        }
                    )
                }
                is AppScreen.ChapterDetail -> {
                    ChapterDetailScreen(
                        chapterId = screen.chapterId,
                        isRead = readChapterIds.contains(screen.chapterId),
                        isBookmarked = bookmarkedChapterIds.contains(screen.chapterId),
                        onToggleRead = { id ->
                            readChapterIds = if (readChapterIds.contains(id)) {
                                readChapterIds - id
                            } else {
                                readChapterIds + id
                            }
                        },
                        onToggleBookmark = { id ->
                            bookmarkedChapterIds = if (bookmarkedChapterIds.contains(id)) {
                                bookmarkedChapterIds - id
                            } else {
                                bookmarkedChapterIds + id
                            }
                        },
                        onNavigateBack = {
                            currentScreen = AppScreen.Home
                            selectedTab = NavigationTab.HOME
                        },
                        onNavigateToChapter = { nextId ->
                            currentScreen = AppScreen.ChapterDetail(nextId)
                        },
                        onNavigateToCaseStudies = {
                            currentScreen = AppScreen.CaseStudies
                            selectedTab = NavigationTab.CASES
                        }
                    )
                }
                is AppScreen.DecisionFlow -> {
                    DecisionFlowScreen(
                        onNavigateBack = {
                            currentScreen = AppScreen.Home
                            selectedTab = NavigationTab.HOME
                        }
                    )
                }
                is AppScreen.Checklist -> {
                    ChecklistScreen(
                        onNavigateBack = {
                            currentScreen = AppScreen.Home
                            selectedTab = NavigationTab.HOME
                        }
                    )
                }
                is AppScreen.CaseStudies -> {
                    CaseStudiesScreen(
                        onNavigateBack = {
                            currentScreen = AppScreen.Home
                            selectedTab = NavigationTab.HOME
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "亞馬遜國家山岳協會｜登山途中溪水橫渡安全教案", modifier = modifier)
}
