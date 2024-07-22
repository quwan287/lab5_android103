package fpl.quangnm.myapplication.demo5;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface InterfaceInsertSP {
    @FormUrlEncoded
    @POST("insert1.php")
    abstract Call<SvrResponseSanPham> insertSPCall(
            @Field("MaSP") String MaSP,
            @Field("TenSP") String TenSP,
            @Field("MoTa") String MoTa
    );
}
