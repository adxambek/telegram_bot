package uz.pdp;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import uz.pdp.container.ComponentContainer;

public class Main {
    public static void main(String[] args) {
//wfefwfwfw
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);

            Noutuz noutuz = new Noutuz();
            ComponentContainer.MY_TELEGRAM_BOT = noutuz;

            telegramBotsApi.registerBot(noutuz);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}
