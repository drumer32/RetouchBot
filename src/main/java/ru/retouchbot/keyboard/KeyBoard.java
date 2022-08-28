package ru.retouchbot.keyboard;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class KeyBoard {
    public ReplyKeyboardMarkup initKeyboard() {

        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("Стоимость"));
        row1.add(new KeyboardButton("Сроки"));

        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("Доп.услуги"));
        row2.add(new KeyboardButton("Качество"));

        KeyboardRow row3 = new KeyboardRow();
        row3.add(new KeyboardButton("Тестовое фото"));
        row3.add(new KeyboardButton("Техника"));

        List<KeyboardRow> keyboard = new ArrayList<>();
        keyboard.add(row1);
        keyboard.add(row2);
        keyboard.add(row3);

        final ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(keyboard);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        return replyKeyboardMarkup;
    }
}
