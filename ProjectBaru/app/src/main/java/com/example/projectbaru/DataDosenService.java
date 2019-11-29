package com.example.projectbaru;

import com.example.projectbaru.model.Dosen;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.POST;

public interface DataDosenService {

    @GET("/api/progmob/dosen/{nim_progmob}")
    Call<List<Dosen>> getDosenAll(@Path("nim_progmob") String nimProgmob);

    @FormUrlEncoded
    @POST("/api/progmob/dosen/create")
    Call<DefaultResult> insertDosen(@Field("nama") String nama,
                                  @Field("nidn") String nidn,
                                  @Field("alamat") String alamat,
                                  @Field("email") String email,
                                  @Field("gelar") String gelar,
                                  @Field("foto") String foto,
                                  @Field("nim_progmob") String nim_progmob
                                  );

    @POST("/api/progmob/dosen/update")
    Call<DefaultResult> updateDosen(@Field("id") int id,
                                    @Field("nama") String nama,
                                    @Field("nidn") String nidn,
                                    @Field("alamat") String alamat,
                                    @Field("email") String email,
                                    @Field("gelar") String gelar,
                                    @Field("foto") String foto,
                                    @Field("nim_progmob") String nim_progmob);

    @POST("/api/progmob/dosen/delete")
    Call<DefaultResult> deleteDosen(@Field("id") int id,
                                    @Field("nim_progmob") String nim_progmob);


}
