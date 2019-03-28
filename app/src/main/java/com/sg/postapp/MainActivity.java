package com.sg.postapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sg.postapp.model.User;
import com.sg.postapp.service.POSTAppService;
import com.sg.postapp.service.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private TextView result;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=findViewById(R.id.et_email);
        password=findViewById(R.id.et_password);
        result=findViewById(R.id.tv_result);
        submitButton=findViewById(R.id.btn_submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postData();
            }
        });

    }

    private void postData() {
        User user=new User();
        user.setName(email.getText().toString());
        user.setPassword(password.getText().toString());
        POSTAppService postAppService= RetrofitInstance.getService();
        Call<User> call=postAppService.getResutls(user);
        Log.i("responsetest","Before id: "+user.getId());
        email.setText("");
        password.setText("");
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User resultUser=response.body();
                Log.i("responsetest","After id: "+resultUser.getId());
                result.setText("ID: "+resultUser.getId());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
}
