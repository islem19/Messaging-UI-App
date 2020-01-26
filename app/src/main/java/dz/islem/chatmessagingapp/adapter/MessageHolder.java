package dz.islem.chatmessagingapp.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import dz.islem.chatmessagingapp.R;
import dz.islem.chatmessagingapp.model.MessageModel;
import dz.islem.chatmessagingapp.util.Utils;

public class MessageHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.text_message_body) public TextView messageText;
    @BindView(R.id.text_message_time) public TextView timeText;

    public MessageHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    void bind(MessageModel message){
        messageText.setText(message.getMessage());
        timeText.setText(Utils.formatTime(message.getCreatedAt()));
    }

}