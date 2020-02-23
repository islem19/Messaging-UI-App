package dz.islem.chatmessagingapp.model;

public interface MessageModel {
    int TYPE_QUESTION =1;
    int TYPE_ANSWER =2;

    int getType();
}
