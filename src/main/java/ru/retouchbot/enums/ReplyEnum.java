package ru.retouchbot.enums;
/**
 * Кнопки ответа
 */
public enum ReplyEnum {
    PRICE("TEXT1"),
    TECH("TEXT2"),
    QUALITY("TEXT3"),
    ADDONS("TEXT4"),
    TERMS("TEXT5"),
    TEST("TEXT6");
    private final String message;

    ReplyEnum(String message) {
        this.message = message;
    }

    public String getReplyMessage() {
        return message;
    }

}