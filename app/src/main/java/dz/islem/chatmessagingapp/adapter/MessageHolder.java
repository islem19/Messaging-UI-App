package dz.islem.chatmessagingapp.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import dz.islem.chatmessagingapp.R;
import dz.islem.chatmessagingapp.model.MessageModel;
import dz.islem.chatmessagingapp.util.Utils;

public class MessageHolder extends RecyclerView.ViewHolder {

    public TextView messageText, timeText;

    public MessageHolder(@NonNull View itemView) {
        super(itemView);

        messageText = itemView.findViewById(R.id.text_message_body);
        timeText = itemView.findViewById(R.id.text_message_time);
    }

    void bind(MessageModel message){
        messageText.setText(message.getMessage());
        timeText.setText(Utils.formatTime(message.getCreatedAt()));
    }

}