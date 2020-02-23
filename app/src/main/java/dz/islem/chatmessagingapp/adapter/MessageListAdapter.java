package dz.islem.chatmessagingapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dz.islem.chatmessagingapp.R;
import dz.islem.chatmessagingapp.model.AnswerModel;
import dz.islem.chatmessagingapp.model.MessageModel;
import dz.islem.chatmessagingapp.model.QuestionModel;

public class MessageListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<MessageModel> mListMessages = new ArrayList<>();

    public MessageListAdapter(){ }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = null;
        // return a new ViewHolder based on the viewType
        // View Type is : TYPE_QUESTION => return new QuestionHolder
        // View Type is : TYPE_ANSWER => return new AnswerHolder
        switch (viewType){
            case MessageModel.TYPE_QUESTION:
                mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message_sent, parent, false);
                return new QuestionHolder(mView);
            case MessageModel.TYPE_ANSWER:
            default:
                mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message_received, parent, false);
                return new AnswerHolder(mView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        // get the message model from the list
        MessageModel message = mListMessages.get(position);
        // bind the model with the viewholder by ViewType
        switch (holder.getItemViewType()){
            case MessageModel.TYPE_QUESTION:
                ((QuestionHolder) holder).bind((QuestionModel) message);
                break;
            case MessageModel.TYPE_ANSWER:
            default:
                ((AnswerHolder) holder).bind( (AnswerModel) message);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return (mListMessages == null ? 0 : mListMessages.size());
    }

    @Override
    public int getItemViewType(int position){
        return mListMessages.get(position).getType();
    }

    public void addData(MessageModel message){
        mListMessages.add(message);
        notifyDataSetChanged();
    }

    public void initData(List<? extends MessageModel> mListMessages){
        if (this.mListMessages == null){
            this.mListMessages = new ArrayList<>();
        }
        this.mListMessages.addAll(mListMessages);
        notifyDataSetChanged();
    }

}
