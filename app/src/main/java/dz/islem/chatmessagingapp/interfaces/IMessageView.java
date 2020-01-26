package dz.islem.chatmessagingapp.interfaces;

import java.util.List;

import dz.islem.chatmessagingapp.model.MessageModel;

public interface IMessageView {

    void notifyData(MessageModel message);

    void populateData(List<MessageModel> mListMessages);
}