package com.example.kaspresso

import android.Manifest
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.rule.GrantPermissionRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test

class IncrementButtonTest : TestCase(
    // подключаем Allure Report
    kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()
){
    // создаем рулу для запуска MainActivity
    @get:Rule
    val activityRule = activityScenarioRule<MainActivity>()

    // создаем рулу для storage permission для Allure Report
    @get:Rule
    val runtimePermission: GrantPermissionRule = GrantPermissionRule.grant(
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE
    )

    // пишем сам тест
    @Test
    fun incrementButtonShouldIncreaseCounterValue() = run {
        step("Increase counter value to 2") {
            MainScreen {
                // повторяем действие дважды
                repeat(2) {
                    incrementButton.click()
                }
            }
        }
        step("Counter value should be 2") {
            MainScreen {
                counter.hasText("Count: 2")
            }
        }
    }
}