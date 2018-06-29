package me.geeksploit.markmyword.model;
import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class WordModel {
    private String word;
    private String translate;
    private String description;
    private String imgUri;

    public WordModel(String word, String translate) {
        this.word = word;
        this.translate = translate;
        this.description = "";
    }

    public WordModel(String word, String translate, String description, String imgUri) {
        this(word, translate);
        this.description = description;
        this.imgUri = imgUri;
}

    public String getWord() {
        return word;
    }

    public String getTranslate() {
        return translate;
    }

    public String getDescription() {
        return description;
    }

    public String getImgUri() {
        return imgUri;
    }
}
/**//*интерфейс  для работы с Retrofit
, в нем прописываем адрес куда будем стучаться и параметры*/


public interface API {

    @GET("search/books")
    Call<PdfItemModel> getSearchedRepos(@Query("q") String q,
                                       @Query("page") int page,
                                       @Query("per_page") int perPage);
}
/**//*клиент для доступа к запросам.*/
public class RestClient {

    public static final String BASE_URL = "https://www.libtxt.ru";

    private final API service;

    @Inject
    public RestClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(API.class);
    }

    public API getService() {
        return service;
    }
}
