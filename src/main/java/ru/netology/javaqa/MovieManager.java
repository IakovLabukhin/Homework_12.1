package ru.netology.javaqa;

public class MovieManager {
    private String[] movies = new String[0];
    private int numberOfMovies = 5;

    public MovieManager() {
    }

    public MovieManager(int numberOfMovies) {
        this.numberOfMovies = numberOfMovies;
    }

    public void add(String movie) {
        String[] tmp = new String[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    public String[] findAll() {
        return movies;
    }

    public String[] findLast() {
        int resultLength;
        if (movies.length < numberOfMovies) {
            resultLength = movies.length;
        } else {
            resultLength = numberOfMovies;
        }
        String[] result = new String[resultLength];
        for (int i = 0; i < result.length; i++) {
            result[i] = movies[movies.length - 1 - i];
        }
        return result;
    }
}