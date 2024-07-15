package com.example.kaspresso

import androidx.test.ext.junit.rules.activityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test

class DecrementButtonTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()
){
    // создаем рулу для запуска MainActivity
    @get:Rule
    val activityRule = activityScenarioRule<MainActivity>()

    // пишем сам тест
    @Test
    fun decrementButtonShouldDecreaseCounterValue() = run {
        step("Increase counter value to -2") {
            MainScreen {
                // повторяем действие дважды
                repeat(2) {
                    decrementButton.click()
                }
            }
        }
        step("Counter value should be -2") {
            MainScreen {
                counter.hasText("Count: -2")
            }
        }
    }
}