package me.geeksploit.markmyword;

import android.app.Application;

import me.geeksploit.markmyword.di.AppComponent;
import me.geeksploit.markmyword.di.DaggerAppComponent;
import me.geeksploit.markmyword.di.modules.AppModule;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class App extends Application {

    private static App instance;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static App getInstance() {
        return instance;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
public class PdfReader {
    @SerializedName("items")
    @Expose
    private List<PdfReader> items = new ArrayList<>();

    public List<PdfReader> getItems() {
        return items;
    }

    public void setItems(List<PdfReader> items) {
        this.items = items;
    }
}

public class PdfItemModel {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

