package com.example.comicsshowcase;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_AddComic extends Fragment {


    public Fragment_AddComic() {
        // Required empty public constructor
    }

    ComicDB_CRUD comicDB_crud;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_comic, container, false);
        final EditText newName = view.findViewById(R.id.new_name);
        final EditText newUrlCover = view.findViewById(R.id.new_imgsrc);
        final EditText newContent = view.findViewById(R.id.new_content);
        Button addComic = view.findViewById(R.id.btn_add);
        comicDB_crud = ComicDB_CRUD.getInstance(getContext());

        addComic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = newName.getText().toString();
                String Image = newUrlCover.getText().toString();
                String Content = newContent.getText().toString();

                ComicModel comicModel = new ComicModel(Image, Name, Content);
                comicDB_crud.addComic(comicModel);
                Toast.makeText(getContext(), "Add a comic successfully!", Toast.LENGTH_SHORT).show();
            }
        });

        newName.setText("");
        newUrlCover.setText("");
        newContent.setText("");
        return view;
    }

}
