package dz.islem.chatmessagingapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dz.islem.chatmessagingapp.R;
import dz.islem.chatmessagingapp.model.MessageModel;

import static dz.islem.chatmessagingapp.util.Constants.MESSAGE_CHIP;
import static dz.islem.chatmessagingapp.util.Constants.MESSAGE_RECEIVED;
import static dz.islem.chatmessagingapp.util.Constants.MESSAGE_SENT;

public class MessageListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<MessageModel> mListMessages = new ArrayList<>();

    public MessageListAdapter(){ }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = null;

        if ( viewType == MESSAGE_SENT )
            mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message_sent, parent, false);
        else if ( viewType == MESSAGE_RECEIVED )
            mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message_received, parent, false);
        else if (viewType == MESSAGE_CHIP)
            mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message_chip, parent, false);
        return (viewType == MESSAGE_CHIP) ? new ChipHolder(mView) : new MessageHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MessageModel message = mListMessages.get(position);

        if ( holder.getItemViewType() == MESSAGE_SENT || holder.getItemViewType() == MESSAGE_RECEIVED )
            ((MessageHolder) holder).bind(message);
        else if ( holder.getItemViewType() == MESSAGE_CHIP )
            ((ChipHolder) holder).bind(message);
    }

    @Override
    public int getItemCount() {
        return (mListMessages == null ? 0 : mListMessages.size());
    }

    @Override
    public int getItemViewType(int position){
        return mListMessages.get(position).getMessageType();
    }

    public void addData(MessageModel message){
        mListMessages.add(message);
        notifyDataSetChanged();
    }

    public void initData(List<MessageModel> mListMessages){
        this.mListMessages = mListMessages;
        notifyDataSetChanged();
    }


}
