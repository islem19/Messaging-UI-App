package dz.islem.chatmessagingapp.repository.local;

import java.util.ArrayList;
import java.util.List;

import dz.islem.chatmessagingapp.model.MessageModel;

public class DataGenerator {

    private static DataGenerator INSTANCE = null;
    private List<MessageModel> mListMessages = new ArrayList<>();

    private DataGenerator() { }

    public static DataGenerator getInstance() {
        return INSTANCE == null ? new DataGenerator() : INSTANCE;
    }

    public List<MessageModel> generateMessages(){
            MessageModel messageSent = new MessageModel("Hello",System.currentTimeMillis(),1);
            MessageModel messageRecieved = new MessageModel("Hello, How are you?",System.currentTimeMillis(),2);
            mListMessages.add(messageSent);
            mListMessages.add(messageRecieved);
            return mListMessages;
    }
}