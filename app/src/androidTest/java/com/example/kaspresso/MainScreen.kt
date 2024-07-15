package com.example.kaspresso

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView

object MainScreen : KScreen<MainScreen>() {
    // делаем обычный маппинг на нужный класс и активити
    // указываем нужный активити
    override val layoutId: Int = R.layout.activity_main
    // указываем нужный класс
    override val viewClass: Class<*> = MainActivity::class.java

    // получаем ID у TextView
    val counter = KTextView { withId(R.id.counter) }

    // получаем ID кнопки
    val incrementButton = KButton { withId(R.id.increment) }
    val decrementButton = KButton { withId(R.id.decrement) }
    val resetButton = KButton { withId(R.id.reset) }
}