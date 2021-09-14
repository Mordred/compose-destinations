package com.ramcosta.composedestinations.commons

import org.junit.Test

class DefaultParameterValueReaderTest {

    private val reader = DefaultParameterValueReader()

    private val casesToTest = arrayOf(
        TestCase(
            lineText = "    arg1: String? = \"defaultArg\") {",
            argName = "arg1",
            argType = "String",
            expected = "\"defaultArg\""
        ),
        TestCase(
            lineText = "    arg1: String? = \"defaultArg\"",
            argName = "arg1",
            argType = "String",
            expected = "\"defaultArg\""
        ),
        TestCase(
            lineText = "    arg1: String? = \"defaultArg\",",
            argName = "arg1",
            argType = "String",
            expected = "\"defaultArg\""
        )
    )

    @Test
    fun testCases() {
        casesToTest.forEach {
            val result = reader.readDefaultValue(
                it.lineText,
                it.argName,
                it.argType
            )

            assert(result == it.expected)
        }
    }

    class TestCase(
        val lineText: String,
        val argName: String,
        val argType: String,
        val expected: String?
    )
}