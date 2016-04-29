package com.example.junitsimple;

import com.example.junitsimple.entities.Repository;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by evin on 4/28/16.
 */

public class RetrofitMagic {
    private static final String BASE_URL = "https://api.github.com/";

    public static void main(String... args) {
        System.out.println(getRepositories("Evin1-"));
    }

    public static Retrofit buildRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static List<Repository> getRepositories(String username) {
        Retrofit retrofit = buildRetrofit();

        GitHubService gitHubService = retrofit.create(GitHubService.class);

        Call<List<Repository>> callRepositories = gitHubService.callRepositories(username);

        List<Repository> listRepositories = null;

        try {
            listRepositories = callRepositories.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listRepositories;
    }

    //http://stackoverflow.com/questions/32514410/logging-with-retrofit-2
    //https://api.github.com/users/Evin1-/repos

    public interface GitHubService {
        @GET("/users/{username}/repos")
        Call<List<Repository>> callRepositories(@Query("username") String username);
    }
}
