package com.example.myapplicationtest;

import androidx.cardview.widget.CardView;

import com.example.myapplicationtest.Models.Notes;

public interface NotesClickListener {
    void onClick(Notes notes);
    void onLongClick(Notes notes, CardView cardView);

}
