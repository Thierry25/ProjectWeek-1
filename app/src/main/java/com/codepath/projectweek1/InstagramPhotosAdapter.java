package com.codepath.projectweek1;

/**
 * Created by install on 11/07/2015.
 */

import android.view.LayoutInflater;



        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;


import com.codepath.projectweek1.R;
import com.squareup.picasso.Picasso;

        import org.w3c.dom.Text;

        import java.util.List;


public class InstagramPhotosAdapter extends ArrayAdapter<InstagramPhoto> {
    //what data do we need from the activity
    // Context, Data Source
    public InstagramPhotosAdapter(Context context, List<InstagramPhoto> objects) {
        super(context, android.R.layout.simple_list_item_1, objects);
    }
    //what our item looks like
    //use the template to display each photo
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //Get the data item for this position
        InstagramPhoto photo = getItem(position);
        //check if we are using a recycled...
        if (convertView == null) {
            //create a new view
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_photo, parent, false);
        }
        //Look up ...
        TextView tvCaption = (TextView) convertView.findViewById(R.id.tvCaption);
        TextView tvUsername = (TextView) convertView.findViewById(R.id.tvUsername);
        TextView tvLikes = (TextView) convertView.findViewById(R.id.tvLikes);
        ImageView ivPhoto = (ImageView) convertView.findViewById(R.id.ivPhoto);
        //Insert ...
        tvCaption.setText(photo.caption);
        tvUsername.setText(photo.username);
        tvLikes.setText(String.valueOf(photo.likesCount));
        // clear out the ...
        ivPhoto.setImageResource(0);
        // Insert the image
        Picasso.with(getContext()).load(photo.imageUrl).into(ivPhoto);

        //return ...
        return convertView;
    }
}
