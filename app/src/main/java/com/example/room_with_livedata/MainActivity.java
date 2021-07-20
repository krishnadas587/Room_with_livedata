package com.example.room_with_livedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.example.room_with_livedata.Database.Database_models;
import com.example.room_with_livedata.Network.RetroBuild;
import com.example.room_with_livedata.Repositry.user_repo;
import com.example.room_with_livedata.ViewModels.TodoViewModels;
import com.example.room_with_livedata.models.datamodels;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TodoViewModels view_model;
    Database_models r_data;
    List<Database_models> db_model_list = new ArrayList<>();
    TextView dataText;
    int count = db_model_list.size();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataText = findViewById(R.id.data);

        view_model = ViewModelProviders.of(this).get(TodoViewModels.class);
        view_model.fetch_live().observe(this, new Observer<List<Database_models>>() {
            @Override
            public void onChanged(List<Database_models> database_models) {
                System.out.println("jhsjdbsjbjds");
                db_model_list = database_models;
                printit();
//                Collections.shuffle(db_model_list);

            }
        });
        view_model.fetch_live();

//        fetchData();

    }

    private void fetchData() {
        Call<List<datamodels>> data_call = new RetroBuild().API.getdata();
        data_call.enqueue(new Callback<List<datamodels>>() {
            @Override
            public void onResponse(Call<List<datamodels>> call, Response<List<datamodels>> response) {
                if (response.isSuccessful()) {
                    if (response != null) {
                        List<datamodels> datamodels = response.body();
                        for (int i = 0; i < datamodels.size(); i++) {
                            String name = datamodels.get(i).getName();
                            String desig = datamodels.get(i).getDesignation();
                            String date = datamodels.get(i).getDate();
                            view_model.insert(new Database_models(name, desig, date));
                            System.out.println(",snfnsdnf");

                        }

                        printit();
//                        Handler handler=new Handler();
//                        handler.postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//                                takeaction();
//
//                            }
//                        },3000);
                    }

                }
            }

            @Override
            public void onFailure(Call<List<datamodels>> call, Throwable t) {

            }
        });
    }

    void printit() {
        while (count < db_model_list.size()) {
            dataText.setText(dataText.getText() + "\n" + db_model_list.get(count).getId() + "\n" + db_model_list.get(count).getName() + "\n" + db_model_list.get(count).getDesignation() + "\n" + db_model_list.get(count).getDate() + "\n");
            count++;
        }
    }

    public void getit(View view) {
        fetchData();
    }
}