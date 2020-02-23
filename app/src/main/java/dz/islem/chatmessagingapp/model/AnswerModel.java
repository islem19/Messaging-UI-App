package dz.islem.chatmessagingapp.model;

public class AnswerModel implements MessageModel {
    private String message;
    private long createdAt;
    private ImageCard imageCard;
    private ChipModel chip;

    public AnswerModel(String message, long createdAt, ImageCard imageCard, ChipModel chip) {
        this.message = message;
        this.createdAt = createdAt;
        this.imageCard = imageCard;
        this.chip = chip;
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

    public ImageCard getImageCard() {
        return imageCard;
    }

    public void setImageCard(ImageCard imageCard) {
        this.imageCard = imageCard;
    }

    public ChipModel getChip() {
        return chip;
    }

    public void setChip(ChipModel chip) {
        this.chip = chip;
    }

    @Override
    public int getType() {
        return MessageModel.TYPE_ANSWER;
    }
}
