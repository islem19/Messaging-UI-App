package dz.islem.chatmessagingapp.adapter;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipDrawable;
import com.google.android.material.chip.ChipGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import dz.islem.chatmessagingapp.R;
import dz.islem.chatmessagingapp.model.MessageModel;

public class ChipHolder extends RecyclerView.ViewHolder {

    public TextView messageText;
    public View mItemView;
    @BindView(R.id.chipGroup) public ChipGroup mChipGroup;


    public ChipHolder(@NonNull View itemView) {
        super(itemView);
        mItemView = itemView;
        ButterKnife.bind(this,mItemView);

        mChipGroup.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(ChipGroup chipGroup, int i) {
                Chip chip = chipGroup.findViewById(i);
                Log.e("tag", "onCheckedChanged: " + chip.getChipText());
            }
        });

    }

    void bind(MessageModel message){
        Chip mChip = new Chip(mChipGroup.getContext());
        mChip.setClickable(true);
        mChip.setCheckable(false);
        mChip.setCloseIconEnabled(false);
        ChipDrawable mChipDraw  = ChipDrawable.createFromAttributes(mChipGroup.getContext(),
                null,
                0,
                R.style.Widget_MaterialComponents_Chip_Choice);

        mChip.setChipDrawable(mChipDraw);
        mChip.setText(message.getMessage());
        mChipGroup.addView(mChip);
    }

}
