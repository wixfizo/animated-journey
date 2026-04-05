package com.example.coptickeyboard

import android.inputmethodservice.InputMethodService
import android.inputmethodservice.Keyboard
import android.inputmethodservice.KeyboardView
import android.view.View
import android.view.KeyEvent

@Suppress("DEPRECATION")
class CopticInputService : InputMethodService(), KeyboardView.OnKeyboardActionListener {

    private lateinit var keyboardView: KeyboardView
    private lateinit var keyboard: Keyboard

    private val replacementMap = mapOf(
        'а' to 'ⲁ', 'б' to 'ϭ', 'в' to 'ⲃ', 'г' to 'ⲅ', 'д' to 'ⲇ',
        'е' to 'ⲉ', 'ё' to 'ⲉ', 'к' to 'ⲕ', 'л' to 'ⲗ', 'м' to 'ⲙ',
        'н' to 'ⲏ', 'о' to 'ⲟ', 'п' to 'ⲡ', 'р' to 'ⲣ', 'с' to 'ⲥ',
        'т' to 'ⲧ', 'у' to 'ⲩ', 'ф' to 'ⲫ', 'х' to 'ⲭ', 'ч' to 'ϥ'
    )

    private val exceptions = setOf('я', 'й', 'и', 'ю', 'з', 'ж', 'э', 'ц', 'ъ', 'ы', 'щ', 'ш')

    override fun onCreateInputView(): View {
        keyboardView = layoutInflater.inflate(R.layout.keyboard_view, null) as KeyboardView
        keyboard = Keyboard(this, R.xml.keys_layout)
        keyboardView.keyboard = keyboard
        keyboardView.setOnKeyboardActionListener(this)
        return keyboardView
    }

    override fun onKey(primaryCode: Int, keyCodes: IntArray?) {
        val ic = currentInputConnection ?: return
        when (primaryCode) {
            Keyboard.KEYCODE_DELETE -> ic.deleteSurroundingText(1, 0)
            Keyboard.KEYCODE_SHIFT -> {
                // Handle shift
            }
            Keyboard.KEYCODE_DONE -> {
                ic.sendKeyEvent(
                    KeyEvent(
                        KeyEvent.ACTION_DOWN,
                        KeyEvent.KEYCODE_ENTER
                    )
                )
            }
            else -> {
                val code = primaryCode.toChar().lowercaseChar()
                val charToType = if (replacementMap.containsKey(code) && !exceptions.contains(code)) {
                    replacementMap[code].toString()
                } else {
                    primaryCode.toChar().toString()
                }
                ic.commitText(charToType, 1)
            }
        }
    }

    override fun onPress(primaryCode: Int) {
        // Not implemented
    }

    override fun onRelease(primaryCode: Int) {
        // Not implemented
    }

    override fun onText(text: CharSequence?) {
        // Not implemented
    }

    override fun swipeLeft() {
        // Not implemented
    }

    override fun swipeRight() {
        // Not implemented
    }

    override fun swipeDown() {
        // Not implemented
    }

    override fun swipeUp() {
        // Not implemented
    }
}
