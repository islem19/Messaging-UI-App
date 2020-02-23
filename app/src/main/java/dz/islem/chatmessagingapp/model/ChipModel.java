package dz.islem.chatmessagingapp.model;

import java.util.List;

public class ChipModel {
    private List<String> chipMessages;

    public ChipModel(List<String> chipMessages) {
        this.chipMessages = chipMessages;
    }

    public List<String> getChipMessages() {
        return chipMessages;
    }

    public void setChipMessages(List<String> chipMessages) {
        this.chipMessages = chipMessages;
    }
}
