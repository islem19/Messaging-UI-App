package dz.islem.chatmessagingapp.model;

public class MessageModel {
    private String message;
    private long createdAt;
    private int messageType;

    public MessageModel(){

    }

    public MessageModel(String message, long createdAt,int messageType) {
        this.message = message;
        this.createdAt = createdAt;
        this.messageType = messageType;
    }

    public MessageModel(String message, long createdAt) {
        this.message = message;
        this.createdAt = createdAt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }
}
