package dz.islem.chatmessagingapp.presenter;

import java.util.ArrayList;
import java.util.List;

import dz.islem.chatmessagingapp.interfaces.IMessagePresenter;
import dz.islem.chatmessagingapp.interfaces.IMessageView;
import dz.islem.chatmessagingapp.model.MessageModel;
import dz.islem.chatmessagingapp.repository.local.DataGenerator;

public class MessagePresenter implements IMessagePresenter {

    private IMessageView mIMessageView;
    private List<MessageModel> mListMessages = new ArrayList<>();

    public MessagePresenter(IMessageView mIMessageView){
        this.mIMessageView = mIMessageView;
    }

    @Override
    public void initData() {
        //MessageModel message = new MessageModel("Hello, how can i help you?",8452,2);
        //mIMessageView.notifyData(message);
        mListMessages = DataGenerator.getInstance().generateMessages();
        mIMessageView.populateData(mListMessages);
    }

    @Override
    public void addData(MessageModel message) {
        mIMessageView.notifyData(message);
    }

}
