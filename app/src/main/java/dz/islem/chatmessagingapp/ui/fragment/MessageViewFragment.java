package dz.islem.chatmessagingapp.ui.fragment;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnEditorAction;
import dz.islem.chatmessagingapp.R;
import dz.islem.chatmessagingapp.adapter.MessageListAdapter;
import dz.islem.chatmessagingapp.interfaces.IMessageView;
import dz.islem.chatmessagingapp.model.MessageModel;
import dz.islem.chatmessagingapp.presenter.MessagePresenter;

public class MessageViewFragment extends Fragment implements IMessageView {
    private View mView;
    @BindView(R.id.recyclerview_message_list) public RecyclerView mRecyclerView;
    @BindView(R.id.edittext_chatbox) public EditText mEditView;
    private MessageListAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private MessagePresenter mMessagePresenter;
    private boolean sender = true;


    public static MessageViewFragment newInstance() {
        return new MessageViewFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMessagePresenter = new MessagePresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.message_fragment, container, false);
        ButterKnife.bind(this,mView);
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecycler();
        //mEditView.setOnEditorActionListener(this);
    }

    private void setupRecycler(){
        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setStackFromEnd(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MessageListAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mMessagePresenter.initData();
    }

    @Override
    public void notifyData(MessageModel message) {
        mAdapter.addData(message);
    }

    @Override
    public void populateData(List<MessageModel> mListMessages) {
        mAdapter.initData(mListMessages);
    }


    @OnEditorAction(R.id.edittext_chatbox)
    public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
        if(actionId == EditorInfo.IME_ACTION_DONE){
            if ( mEditView.getText().length() > 0 ) {
                MessageModel message = new MessageModel(String.valueOf(mEditView.getText()),System.currentTimeMillis());
                if (sender)
                    message.setMessageType(1);
                else
                    message.setMessageType(2);
                sender=!sender;
                mMessagePresenter.addData(message);
                mEditView.getText().clear();
                mRecyclerView.scrollToPosition(mRecyclerView.getAdapter().getItemCount()-1);
            }
            return true;
        }
        return false;
    }
}
