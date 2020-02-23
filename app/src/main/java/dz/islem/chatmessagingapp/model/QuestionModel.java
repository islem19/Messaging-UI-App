package dz.islem.chatmessagingapp.model;

public class QuestionModel implements MessageModel {

    private String message;
    private long createdAt;

    public QuestionModel(String message, long createdAt) {
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

    @Override
    public int getType() {
        return MessageModel.TYPE_QUESTION;
    }
}
