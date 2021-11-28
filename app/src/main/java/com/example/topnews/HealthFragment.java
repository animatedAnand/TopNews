package com.example.topnews;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;

public class HealthFragment extends Fragment {
    String api="b4197873e2b741f7b3cfa66019e6c1f8";
    ArrayList<ModelClass> modelClassArrayList;
    Adapter adapter;
    String country="in";
    String category ="health";
    RecyclerView recyclerViewForHealth;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.healthfragment,null);
        recyclerViewForHealth= v.findViewById(R.id.recyclerviewforhealth);
        modelClassArrayList=new ArrayList<>();
        adapter =new Adapter(getContext(),modelClassArrayList);
        recyclerViewForHealth.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewForHealth.setAdapter(adapter);

        findNews();
        return v;
    }

    private void findNews() {
        ApiUtilities.getApiInterface().getCategoryNews(country,category,100,api).enqueue(new retrofit2.Callback<MainNews>() {
            @Override
            public void onResponse(Call<MainNews> call, Response<MainNews> response) {
                modelClassArrayList.addAll(response.body().getArticles());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<MainNews> call, Throwable t) {

            }
        });
    }
}
