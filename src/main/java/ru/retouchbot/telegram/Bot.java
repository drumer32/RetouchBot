package ru.retouchbot.telegram;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.retouchbot.enums.ReplyEnum;
import ru.retouchbot.keyboard.KeyBoard;
import ru.retouchbot.utils.Utils;

@Slf4j
public final class Bot extends TelegramLongPollingBot {

    private final String BOT_NAME = "";
    private final String BOT_TOKEN = "";

    KeyBoard keyBoard = new KeyBoard();
    public Bot() {
       keyBoard.initKeyboard();
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }


    @Override
    public void onUpdateReceived(Update update) {

        try {
            if (update.hasMessage() && update.getMessage().hasText()) {
                Message inMess = update.getMessage();
                String chatId = inMess.getChatId().toString();
                String response = parseMessage(inMess.getText(), Utils.getUserName(inMess));
                SendMessage message = new SendMessage();

                message.setChatId(chatId);
                message.setText(response);
                message.setReplyMarkup(keyBoard.initKeyboard());
                log.info(message.getChatId() + " Имя пользователя: " + Utils.getUserName(inMess));
                execute(message);
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public String parseMessage(String textMsg, String userName) {
        switch (textMsg) {
            case "/start":
                return "Здравствуйте, " + userName + "!";
            case "Стоимость":
                return ReplyEnum.PRICE.getReplyMessage();
            case "Техника":
                return ReplyEnum.TECH.getReplyMessage();
            case "Доп.услуги":
                return ReplyEnum.ADDONS.getReplyMessage();
            case "Качество":
                return ReplyEnum.QUALITY.getReplyMessage();
            case "Тестовое фото":
                return ReplyEnum.TEST.getReplyMessage();
            case "Сроки":
                return ReplyEnum.TERMS.getReplyMessage();
            default:
                return "Сообщение не распознано. Воспользуйтесь спец. кнопками";
        }
    }
}