package com.example

import com.example.data.SafetyCurriculum
import com.example.model.SvgDiagramType
import com.example.model.WarningLevel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class SafetyCurriculumTest {

    @Test
    fun `curriculum contains all 19 chapters with required fields`() {
        assertEquals("Should have exactly 19 chapters", 19, SafetyCurriculum.CHAPTERS.size)

        SafetyCurriculum.CHAPTERS.forEachIndexed { index, chapter ->
            assertEquals("Chapter ID must be 1-indexed", index + 1, chapter.id)
            assertTrue("Chapter title must not be blank", chapter.title.isNotBlank())
            assertTrue("Chapter coreQuote must not be blank", chapter.coreQuote.isNotBlank())
            assertTrue("Chapter summary must not be blank", chapter.summary.isNotBlank())
            assertTrue("Chapter must have key points", chapter.keyPoints.isNotEmpty())
        }
    }

    @Test
    fun `critical chapters have expected diagram types and references`() {
        val ch04 = SafetyCurriculum.CHAPTERS.find { it.id == 4 }
        assertNotNull(ch04)
        assertEquals(SvgDiagramType.RIVER_CROSS_SECTION, ch04?.diagramType)

        val ch07 = SafetyCurriculum.CHAPTERS.find { it.id == 7 }
        assertNotNull(ch07)
        assertEquals(SvgDiagramType.SANDBANK_ISLAND_TRAP, ch07?.diagramType)

        val ch14 = SafetyCurriculum.CHAPTERS.find { it.id == 14 }
        assertNotNull(ch14)
        assertEquals(SvgDiagramType.BACKPACK_SEPARATION, ch14?.diagramType)

        val ch16 = SafetyCurriculum.CHAPTERS.find { it.id == 16 }
        assertNotNull(ch16)
        assertEquals(SvgDiagramType.PENDULUM_TRAVERSE, ch16?.diagramType)
        assertNotNull(ch16?.referenceUrl)
    }

    @Test
    fun `checklist has 8 questions and decision flow has 12 steps`() {
        assertEquals(8, SafetyCurriculum.CHECKLIST_8_QUESTIONS.size)
        assertEquals(12, SafetyCurriculum.DECISION_FLOW_STEPS.size)
    }

    @Test
    fun `case studies contain all 5 scenarios with options and analysis`() {
        assertEquals(5, SafetyCurriculum.CASE_STUDIES.size)
        SafetyCurriculum.CASE_STUDIES.forEach { caseStudy ->
            assertTrue(caseStudy.options.size >= 3)
            assertTrue(caseStudy.expertAnalysis.isNotBlank())
            assertTrue(caseStudy.coreLesson.isNotBlank())
        }
    }
}
