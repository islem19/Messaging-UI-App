package dz.islem.chatmessagingapp.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import dz.islem.chatmessagingapp.R;
import dz.islem.chatmessagingapp.ui.fragment.MessageViewFragment;

public class App extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_fragment, MessageViewFragment.newInstance())
                .commit();

    }
}
