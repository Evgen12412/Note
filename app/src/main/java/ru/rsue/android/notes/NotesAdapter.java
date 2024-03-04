package ru.rsue.android.notes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.Holder> {


    private List<Note> notes = new ArrayList<>();

    public List<Note> getNotes() {
        return new ArrayList<>(notes);
    }


    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.note_item, parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        Note note = notes.get(position);
        holder.noteItem.setText(note.getText());

        int idColor;
        switch (note.getPriority()) {
            case 0:
                idColor = android.R.color.holo_green_light;
                break;
            case 1:
                idColor = android.R.color.holo_orange_light;
                break;

            default:
                idColor = android.R.color.holo_red_light;
        }
        int color = ContextCompat.getColor(holder.itemView.getContext(), idColor);
        holder.noteItem.setBackgroundColor(color);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class Holder extends  RecyclerView.ViewHolder{
        private TextView noteItem;


        // сюда попадают все полученные доступы по ид

        public Holder(@NonNull View itemView) {
            super(itemView);
            noteItem = itemView.findViewById(R.id.tv_note_item);

        }
    }
}
