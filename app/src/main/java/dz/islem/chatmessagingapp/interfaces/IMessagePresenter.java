package dz.islem.chatmessagingapp.interfaces;

import dz.islem.chatmessagingapp.model.MessageModel;

public interface IMessagePresenter {

        void initData();

        void addData(MessageModel message);
}
