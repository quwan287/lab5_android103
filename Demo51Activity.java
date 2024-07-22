package fpl.quangnm.myapplication.demo5;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import fpl.quangnm.myapplication.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Demo51Activity extends AppCompatActivity {
    EditText txt1, txt2, txt3;
    TextView tvKQ;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo51);
        txt1 = findViewById(R.id.demo51_txt1);
        txt2 = findViewById(R.id.demo51_txt2);
        txt3 = findViewById(R.id.demo51_txt3);
        tvKQ = findViewById(R.id.demo51_Tv1);
        btn1 = findViewById(R.id.demo51_btn1);

        btn1.setOnClickListener(view -> {
            insertData(txt1,txt2,txt3,tvKQ);
        });
    }
    public void insertData(EditText txt1, EditText txt2, EditText txt3, TextView tvKQ){
        // b1 tao doi tuong luu tru
        SanPham s = new SanPham(txt1.getText().toString(), txt2.getText().toString(), txt3.getText().toString());
        // tao doi tuong retrolfit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.2.6/2024071/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        // b3 goi ham insert
        InterfaceInsertSP insertSanPham = retrofit.create(InterfaceInsertSP.class);
        Call<SvrResponseSanPham> call =
                insertSanPham.insertSPCall(s.getMaSP(), s.getTenSP(), s.getMoTa());
        call.enqueue(new Callback<SvrResponseSanPham>() {
            @Override
            public void onResponse(Call<SvrResponseSanPham> call, Response<SvrResponseSanPham> response) {
                SvrResponseSanPham res = response.body();
                tvKQ.setText(res.getMessage());
            }

            @Override
            public void onFailure(Call<SvrResponseSanPham> call, Throwable t) {
                tvKQ.setText(t.getMessage());
            }
        });
    }
}