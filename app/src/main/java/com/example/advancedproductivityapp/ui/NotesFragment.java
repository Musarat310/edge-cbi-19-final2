package com.example.advancedproductivityapp.ui;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.advancedproductivityapp.R;

public class NotesFragment extends Fragment {

    // Method to create a new instance of the NotesFragment with note content
    public static NotesFragment newInstance(String noteContent) {
        NotesFragment fragment = new NotesFragment();
        Bundle args = new Bundle();
        args.putString("note_content", noteContent); // Pass note content as argument
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_notes_fragment, container, false);

        TextView noteTextView = view.findViewById(R.id.noteTextView);

        // Retrieve the note content from the fragment arguments
        String noteContent = getArguments() != null ? getArguments().getString("note_content") : "No content";

        // Display the note content in the TextView
        noteTextView.setText(noteContent);

        return view;
    }
}
