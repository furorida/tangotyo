package com.example.shunyatsukada.flashcardplus;

/**
 * Created by shunyatsukada on 16/05/28.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CardAdapter extends ArrayAdapter<Card> {
    List<Card> mCards;

    public CardAdapter(Context context, int layoutResourceId, List<Card> objects){
        super(context, layoutResourceId, objects);

        mCards = objects;
    }

    @Override
    public int getCount() {
        return mCards.size();
    }

    @Override
    public Card getItem(int position) {
        return mCards.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHoler viewHoler;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.card, null);
            viewHoler = new ViewHoler(convertView);
            convertView.setTag(viewHoler);
        }else {
            viewHoler = (ViewHoler) convertView.getTag();
        }
        final Card item = getItem(position);

        if (item != null) {
            //set data
            viewHoler.iconImageView.setBackgroundResource(item.imageId);
            viewHoler.titleTextView.setText(item.title);
            viewHoler.contentTextView.setText(item.content);
            viewHoler.likeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    item.likeNum++;
                    viewHoler.likeTextView.setText(item.likeNum + "Likes");
                }
            });
            viewHoler.iconImageView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(),item.meaning, Toast.LENGTH_SHORT).show();
                }
            });
        }

        return convertView;
    }

    private class ViewHoler{
        ImageView iconImageView;
        TextView titleTextView;
        TextView likeTextView;
        TextView contentTextView;
        ImageView likeButton;

        public ViewHoler(View view) {
            //get instance
            iconImageView = (ImageView) view.findViewById(R.id.icon);
            titleTextView = (TextView)view.findViewById(R.id.title_textview);
            likeTextView = (TextView)view.findViewById(R.id.like_textview);
            contentTextView = (TextView)view.findViewById(R.id.content);
            likeButton = (ImageView) view.findViewById(R.id.like_button);

        }
    }


    //ここまでやった2016/05/28 Step4
}
