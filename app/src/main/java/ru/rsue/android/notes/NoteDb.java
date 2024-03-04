package ru.rsue.android.notes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class NoteDb {

    private static List<Note> notes = new ArrayList<>();

    private static NoteDb instance = null;

    public static NoteDb getInstance() {
        if (instance == null) {
            instance = new NoteDb();
        }
        return instance;
    }

    public NoteDb() {

        for(int i =0; i < 20; i++){
            Random random = new Random();
            Note note = new Note(i, "Note " + i, random.nextInt(3));
            notes.add(note);
        }
    }



    public List<Note> getNotes() {
        return notes;
    }

    public static void setNotes(List<Note> notes) {
        NoteDb.notes = notes;
    }

    public void add(Note note) {
        notes.add(note);
    }
    public void removeNote(int id) {
        if (notes != null) {
            int c = 0;
            while (c < notes.size()) {
                Note n = notes.get(c);
                if ( n.getId() == id) {
                    notes.remove(c);
                    c--;
                }
                c++;
            }
        }

    }
}
