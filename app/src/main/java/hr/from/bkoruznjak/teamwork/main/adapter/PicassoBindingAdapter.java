package hr.from.bkoruznjak.teamwork.main.adapter;

import android.databinding.BindingAdapter;
import android.text.TextUtils;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import hr.from.bkoruznjak.teamwork.R;

import static hr.from.bkoruznjak.teamwork.network.TeamWebApi.PLACEHOLDER_IMAGE_URL;

/**
 * Created by bkoruznjak on 27/09/2017.
 */

public class PicassoBindingAdapter {

    @BindingAdapter({"bind:logo"})
    public static void loadImage(ImageView imageView, String url) {
        if (TextUtils.isEmpty(url)) {
            url = PLACEHOLDER_IMAGE_URL;
        }
        Picasso.with(imageView.getContext()).load(url).placeholder(R.drawable.img_placeholder).into(imageView);
    }
}
