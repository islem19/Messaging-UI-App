package dz.islem.chatmessagingapp.repository.local;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dz.islem.chatmessagingapp.model.AnswerModel;
import dz.islem.chatmessagingapp.model.ChipModel;
import dz.islem.chatmessagingapp.model.ImageCard;
import dz.islem.chatmessagingapp.model.MessageModel;
import dz.islem.chatmessagingapp.model.QuestionModel;

public class DataGenerator {
    private String link = "https://github.com/islem19/Messaging-UI-App/blob/develop/screenshots/screenshot1.png";

    private static DataGenerator INSTANCE = null;
    private List<MessageModel> mListMessages = new ArrayList<>();

    private DataGenerator() { }

    public static DataGenerator getInstance() {
        return INSTANCE == null ? new DataGenerator() : INSTANCE;
    }

    public List<MessageModel> generateMessages(){
            MessageModel messageSent = new QuestionModel("Hello, I have a question",System.currentTimeMillis());
            MessageModel messageReceived = new AnswerModel("How may i help you?",System.currentTimeMillis(),null,null);
            MessageModel messageImageCard = new AnswerModel("this is an image",System.currentTimeMillis(),new ImageCard(link),null);
            MessageModel messageChip = new AnswerModel("",System.currentTimeMillis(),null,new ChipModel(Arrays.asList("Choice 1", "Choice 2", "Choice 3")));

            mListMessages.add(messageSent);
            mListMessages.add(messageReceived);
            mListMessages.add(messageImageCard);
            mListMessages.add(messageChip);

            return mListMessages;
    }
}