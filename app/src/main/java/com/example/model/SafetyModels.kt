package com.example.model

enum class SvgDiagramType {
    NONE,
    BACKPACK_SEPARATION,
    PENDULUM_TRAVERSE,
    RIVER_CROSS_SECTION,
    SANDBANK_ISLAND_TRAP
}

enum class WarningLevel {
    INFO,
    CAUTION,
    WARNING,
    PROHIBITION
}

data class WarningBoxData(
    val level: WarningLevel,
    val title: String,
    val text: String,
    val bulletPoints: List<String> = emptyList()
)

data class ComparisonRow(
    val idealText: String,
    val dangerText: String
)

data class ComparisonTableData(
    val idealHeader: String = "較理想情境（寬、緩、淺）",
    val dangerHeader: String = "較危險情境（窄、急、深）",
    val rows: List<ComparisonRow>
)

data class Chapter(
    val id: Int,
    val chapterNumber: String,
    val title: String,
    val subtitle: String,
    val category: String,
    val coreQuote: String,
    val summary: String,
    val keyPoints: List<String>,
    val deepContent: List<String> = emptyList(),
    val warningBox: WarningBoxData? = null,
    val comparisonTable: ComparisonTableData? = null,
    val diagramType: SvgDiagramType = SvgDiagramType.NONE,
    val processSteps: List<String> = emptyList(),
    val isAdvanced: Boolean = false,
    val referenceUrl: String? = null,
    val referenceText: String? = null
)

data class CaseOption(
    val id: String,
    val label: String,
    val outcomeType: WarningLevel,
    val safetyFeedback: String
)

data class CaseStudy(
    val id: String,
    val tag: String,
    val title: String,
    val situation: String,
    val question: String,
    val options: List<CaseOption>,
    val expertAnalysis: String,
    val coreLesson: String
)

data class ChecklistItem(
    val id: Int,
    val question: String,
    val observationGuide: String,
    val riskExplain: String
)

data class DecisionNode(
    val id: Int,
    val stepTitle: String,
    val description: String,
    val observationTip: String,
    val passCondition: String,
    val failAction: String,
    val isCriticalGate: Boolean = false
)
