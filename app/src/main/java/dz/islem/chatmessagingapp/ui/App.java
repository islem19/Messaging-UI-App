package dz.islem.chatmessagingapp.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import dz.islem.chatmessagingapp.R;
import dz.islem.chatmessagingapp.ui.fragment.MessageViewFragment;
import dz.islem.chatmessagingapp.util.Utils;

public class App extends AppCompatActivity {

    @BindView(R.id.btnRefresh) public Button mBtnRefresh;
    @BindView(R.id.noInternetLayout) public ConstraintLayout mView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // bind the views with butterknife
        ButterKnife.bind(this);

        //check if the network is available
        if (!Utils.isNetworkAvailable(getApplicationContext())){
            // if not, show "no internet connection" layout
            mView.setVisibility(View.VISIBLE);
            // setup a listener to referesh on click
            mBtnRefresh.setOnClickListener(view -> {
                if (Utils.isNetworkAvailable(getApplicationContext())){
                    // if network is available , commit the fragment
                    mView.setVisibility(View.GONE);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_fragment, MessageViewFragment.newInstance())
                            .commit();
                }
            });
        }
        else
            // if the network is available , commit the new fragment
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_fragment, MessageViewFragment.newInstance())
                    .commit();
    }

}
