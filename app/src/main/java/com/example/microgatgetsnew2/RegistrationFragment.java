package com.example.microgatgetsnew2;

import android.app.DatePickerDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.microgatgetsnew2.databinding.ActivityMainBinding;
import com.example.microgatgetsnew2.databinding.FragmentRegistrationBinding;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RegistrationFragment extends Fragment {

    private class NetworkTask extends AsyncTask<Void, Void, String> {
        private User user;

        public NetworkTask(User user) {
            this.user = user;
        }

        @Override
        protected String doInBackground(Void... voids) {
            Gson gson = new Gson();
            String result;
            try {
                result = post(url + "/users", gson.toJson(user));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            if (s.equals("Success")) {
                Toast.makeText(getContext(), "Регистрация прошла успешно!", Toast.LENGTH_SHORT).show();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.setReorderingAllowed(true);
                ft.replace(R.id.fragment_container_view_main, MainFragment.class, null);
                ft.commit();
            }
        }
    }

    private FragmentRegistrationBinding registrationBinding;
    private ActivityMainBinding mainBinding;

    private String url = "https://cc31-85-140-126-213.ngrok-free.app";

    private String post(String url, String json) throws IOException {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(json, JSON);

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Response response = client.newCall(request).execute();

        return response.body().string();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        registrationBinding = FragmentRegistrationBinding.inflate(inflater, container, false);


        registrationBinding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                user.Name = registrationBinding.editTextName.getText().toString();
                user.Surname = registrationBinding.editTextSurname.getText().toString();
                user.Birthday = registrationBinding.editTextBirthday.getText().toString();
                user.Patronymic = registrationBinding.editTextPatronymic.getText().toString();
                user.Country = registrationBinding.editTextCountry.getText().toString();
                user.City = registrationBinding.editTextCity.getText().toString();

                NetworkTask networkTask = new NetworkTask(user);
                networkTask.execute();
            }
        });

        return registrationBinding.getRoot();
    }
}