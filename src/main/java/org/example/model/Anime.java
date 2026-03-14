package org.example.model;

import java.util.ArrayList;
import java.util.List;

public final class Anime {
    private final String name;
    private final int numberOfEpisodes;
    private final List<String> genres;

    public Anime(String name, int numberOfEpisodes, List<String> genres) {
        this.name = name;
        this.numberOfEpisodes = numberOfEpisodes;
        this.genres = new ArrayList<>(genres);
    }

    public String getName() {
        return name;
    }

    public int getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    public List<String> getGenres() {
        return List.copyOf(genres);
    }

    @Override
    public String toString() {
        return String.format("Name: %s%nNumber of episodes: %d%nGenres: %s", name, numberOfEpisodes, genres);
    }
}
