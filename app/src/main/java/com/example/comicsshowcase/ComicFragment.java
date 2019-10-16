package com.example.comicsshowcase;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * A simple {@linkFragment} subclass.
 */
public class ComicFragment extends Fragment {
    ComicModel comicModel;

    public ComicFragment(ComicModel comicModel) {
        // Required empty public constructor
        this.comicModel = comicModel;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_comic, container, false);

        TextView content = view.findViewById(R.id.comic_content);
        ImageView image = view.findViewById(R.id.comic_image);
        TextView introduction = view.findViewById(R.id.comic_introduction);

        content.setText(comicModel.getComic_name());
        Glide.with(getContext()).load(comicModel.getComic_img()).into(image);
        introduction.setText(comicModel.getComic_introduction());
        return view;
    }
}