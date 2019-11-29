package com.example.projectbaru;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.projectbaru.model.Dosen;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    DataDosenService dataDosenService;
    DataDosenService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataDosenService = RetrofitClient.getRetrofitInstance()
                .create(DataDosenService.class);
        getAllDataDosen();
        InsertDosen();
        UpdateDosen();
        DeleteDosen();
    }

    private void DeleteDosen() {
        {
            Call<DefaultResult> call = service.deleteDosen(1,"72140048");
            call.enqueue(new Callback<DefaultResult>() {
                @Override
                public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                    System.out.println("Berhasil di dihapus");
                }

                @Override
                public void onFailure(Call<DefaultResult> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "somethig wrong.... ", Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    private void UpdateDosen() {
        Call<DefaultResult> call = service.updateDosen(1,"Yetli Oslan", "2202930", "Klitren", "yetli@gmail.com",
                "S.kom", "", "72140048");
        call.enqueue(new Callback<DefaultResult>() {
            @Override
            public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                System.out.println("OK");
            }

            @Override
            public void onFailure(Call<DefaultResult> call, Throwable t) {
                Toast.makeText(MainActivity.this, "somethig wrong.... ", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void InsertDosen() {
        Call<DefaultResult> call = service.insertDosen("Katon", "2202930", "Klitren", "katon@gmail.com",
                "S.kom", "", "72140048");
        call.enqueue(new Callback<DefaultResult>() {
            @Override
            public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                System.out.println("OK");
            }

            @Override
            public void onFailure(Call<DefaultResult> call, Throwable t) {
                Toast.makeText(MainActivity.this, "somethig wrong.... ", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getAllDataDosen()
    {
        Call<List<Dosen>> call = dataDosenService.getDosenAll("72140048");
        call.enqueue(new Callback<List<Dosen>>() {
            @Override
            public void onResponse(Call<List<Dosen>> call, Response<List<Dosen>> response) {
                for (Dosen dosen : response.body()) {
                    System.out.println("Nama : " + dosen.getNama());
                    System.out.println("NIDN : " + dosen.getNidn());
                }

            }

            @Override
            public void onFailure(Call<List<Dosen>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "somethig wrong.... ", Toast.LENGTH_LONG).show();
            }

        });
    }
}

