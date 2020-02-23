package dz.islem.chatmessagingapp.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import dz.islem.chatmessagingapp.R;
import dz.islem.chatmessagingapp.model.MessageModel;
import dz.islem.chatmessagingapp.model.QuestionModel;
import dz.islem.chatmessagingapp.util.Utils;

public class QuestionHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.text_message_body) public TextView messageText;
    @BindView(R.id.text_message_time) public TextView timeText;

    public QuestionHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    void bind(QuestionModel question){
        messageText.setText(question.getMessage());
        timeText.setText(Utils.formatTime(question.getCreatedAt()));
    }

}