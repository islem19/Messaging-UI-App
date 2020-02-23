package dz.islem.chatmessagingapp.adapter;

import android.text.SpannableString;
import android.util.Log;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipDrawable;
import com.google.android.material.chip.ChipGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import dz.islem.chatmessagingapp.R;
import dz.islem.chatmessagingapp.model.AnswerModel;
import dz.islem.chatmessagingapp.model.ChipModel;
import dz.islem.chatmessagingapp.model.ImageCard;
import dz.islem.chatmessagingapp.model.MessageModel;
import dz.islem.chatmessagingapp.util.Utils;

public class AnswerHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.text_message_body) TextView messageText;
    @BindView(R.id.text_message_time) TextView timeText;
    @BindView(R.id.card_image) ImageView mTextImage;
    @BindView(R.id.chip_layout) HorizontalScrollView chip_layout;
    @BindView(R.id.text_layout) ConstraintLayout text_layout;
    @BindView(R.id.chipGroup) ChipGroup mChipGroup;
    @BindView(R.id.image_message_profile) ImageView mProfilePic;
    @BindView(R.id.text_message_name) TextView mProfileName;


    public AnswerHolder(@NonNull View itemView) {
        super(itemView);

        ButterKnife.bind(this,itemView);



    }

    void bind(AnswerModel answer){

        if( answer.getChip() != null) {
            // make the chip layout visible
            chip_layout.setVisibility(View.VISIBLE);
            // hide the text layout
            text_layout.setVisibility(View.GONE);
            // generate new chip
            generateChip(answer.getChip());
            // setup a listener when user click on chips
            setupChipListener();
        } else {
            chip_layout.setVisibility(View.GONE);
            // make the text layout visible
            text_layout.setVisibility(View.VISIBLE);
            if ( answer.getImageCard() != null) {
                // make the image card visible
                mTextImage.setVisibility(View.VISIBLE);
                // hide the text box
                messageText.setVisibility(View.VISIBLE);

                messageText.setText(answer.getMessage());
                // load the image with Glide
                Glide.with(itemView.getContext())
                        // get imge url : message.getMsg().getImageUri()
                        .load(answer.getImageCard().getImageUri())
                        // load image into the image card
                        .into(mTextImage);
                // setup a listener when user click on images
                setupImageViewListener(answer.getImageCard());
            } else {
                mTextImage.setVisibility(View.GONE);
                // show the text box
                messageText.setVisibility(View.VISIBLE);
                // set the text : message.getMsg().getText().get(0)
                // message.getMsg().getText() returns an array with only 1 element
                messageText.setText(answer.getMessage());
                // set the time box with the current time of the system
                timeText.setText(Utils.formatTime(System.currentTimeMillis()));
            }
        }
    }


    private void generateChip(ChipModel chip){
        // clear the chip group view
        if (mChipGroup != null) mChipGroup.removeAllViews();
        for ( int i = 0; i < chip.getChipMessages().size() ; i ++) {
            // create a new chip obj
            Chip mChip = new Chip(mChipGroup.getContext());
            // set it as clickable
            mChip.setClickable(true);
            mChip.setCheckable(false);
            // don't show an icon with the chip
            mChip.setCloseIconEnabled(false);
            mChip.setLayoutDirection(View.LAYOUT_DIRECTION_LOCALE);
            // apply the material component chip choice style to the chip
            ChipDrawable mChipDraw = ChipDrawable.createFromAttributes(mChipGroup.getContext(),
                    null,
                    0,
                    R.style.Widget_MaterialComponents_Chip_Choice);
            mChip.setChipDrawable(mChipDraw);
            // set the text with the quick reply from the model
            mChip.setChipText(chip.getChipMessages().get(i));
            // add the chip to the chip group view
            mChipGroup.addView(mChip);
        }
    }


    private void setupChipListener(){
        mChipGroup.setOnCheckedChangeListener((chipGroup, i) -> {
            // get the message inside the chip clicked
            String selectedMessage = new SpannableString(((Chip) mChipGroup.findViewById(mChipGroup.getCheckedChipId())).getChipText()).toString();

            Toast.makeText(mChipGroup.getContext(),selectedMessage,Toast.LENGTH_LONG).show();

            //mChipGroup.setOnCheckedChangeListener(null);
        });
    }


    private void setupImageViewListener(ImageCard img){
        mTextImage.setOnClickListener(view -> {
            // set the image card with the url from the model
            String url = img.getImageUri();
            // open the url in browser
            Utils.openUrl(itemView.getContext(), url);
        });
    }

}
