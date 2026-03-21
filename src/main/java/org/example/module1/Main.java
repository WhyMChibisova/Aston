package org.example.module1;

import org.example.module1.model.Anime;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> genres = new ArrayList<>(List.of("shonen", "action-adventure", "fantasy"));
        Anime anime = new Anime(
                "Naruto",
                720,
                genres
        );
        genres.add("Test");

        System.out.println("Genres: " + genres);
        System.out.printf(anime.toString());
    }
}
