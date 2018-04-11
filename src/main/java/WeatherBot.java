import entity.WeatherInfo;
import entity.WeatherParameters;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeatherBot extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            if(message_text.equals("/start")) {
                Date date = new Date();
                WeatherInfo info = new WeatherInfo();
                String country = "Kazakhstan";
                String city = "Astana";
                WeatherParameters weather = info.weatherInfo(country, city, date);
                String weatherInfo = info.printWeatherInfo(weather);

                SendMessage message = new SendMessage()
                        .setChatId(chat_id)
                        .setText(weatherInfo);
                try {
                    sendMessage(message); // Call method to send the message
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if(message_text.equals("/markup"))
            {
                SendMessage message = new SendMessage()
                        .setChatId(chat_id)
                        .setText("Keyboard");
                ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                List<KeyboardRow> keyboard = new ArrayList<KeyboardRow>();
                KeyboardRow row = new KeyboardRow();
                row.add(new KeyboardButton("Current"));
                row.add("Forecast");
                keyboard.add(row);
                keyboardMarkup.setKeyboard(keyboard);
                message.setReplyMarkup(keyboardMarkup);
                try{
                    sendMessage(message);
                }catch (TelegramApiException e){
                    e.printStackTrace();
                }
            }
            else if (message_text.equals("/Current"))
            {
                SendMessage message = new SendMessage()
                        .setChatId(chat_id)
                        .setText("Current");
                ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();

                // список строк клавиатуры
                List<KeyboardRow> keyboard = new ArrayList<KeyboardRow>();

                // первая строка
                KeyboardRow firstRow = new KeyboardRow();
                firstRow.add(new KeyboardButton("Your city"));
                // вторая строка
                KeyboardRow secondRow = new KeyboardRow();
                secondRow.add(new KeyboardButton("Location"));
                // третья строка
                KeyboardRow thirdRow = new KeyboardRow();
                thirdRow.add(new KeyboardButton("New"));
                // четвертая строка
                KeyboardRow fourthRow = new KeyboardRow();
                fourthRow.add(new KeyboardButton("Cancel"));

                //добавляем все строки в клавиатуру
                keyboard.add(firstRow);
                keyboard.add(secondRow);
                keyboard.add(thirdRow);
                keyboard.add(fourthRow);

                // устанавливаем список клавиатуре
                keyboardMarkup.setKeyboard(keyboard);
                message.setReplyMarkup(keyboardMarkup);
                try{
                    sendMessage(message);
                }catch (TelegramApiException e){
                    e.printStackTrace();
                }
            }
            else
            {
                SendMessage message = new SendMessage()
                        .setChatId(chat_id)
                        .setText("Unknown command");
                try{
                    sendMessage(message);
                } catch (TelegramApiException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public String getBotUsername() {
        return "WeatherBot";
    }

    public String getBotToken() {
        return "586947492:AAHukfKYSOyyFXo9NFxcqBlrmkZXhmZL-Ek";
    }
}
