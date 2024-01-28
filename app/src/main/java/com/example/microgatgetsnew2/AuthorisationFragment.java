package com.example.microgatgetsnew2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.microgatgetsnew2.databinding.FragmentAuthorisationBinding;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AuthorisationFragment extends Fragment {

    private FragmentAuthorisationBinding authorisationBinding;
    private String phone;
    private String password;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        authorisationBinding = FragmentAuthorisationBinding.inflate(inflater, container, false);

        authorisationBinding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phone = authorisationBinding.editTextPhone.getText().toString();
                password = authorisationBinding.editTextPassword.getText().toString();
                Log.d("PHONE", phone);
                NetworkTask networkTask = new NetworkTask();
                networkTask.execute();
            }
        });

        authorisationBinding.buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.setReorderingAllowed(true);
                ft.replace(R.id.fragment_container_view_main, RegistrationFragment.class, null);
                ft.commit();
            }
        });

        return authorisationBinding.getRoot();
    }

    private String post(String url, String phone) throws IOException {
        OkHttpClient client = new OkHttpClient();

        url += phone;

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();

        return response.body().string();
    }

    private class NetworkTask extends AsyncTask<Void, Void, String> {

        private User user;

        private void changeFragment() {
            FragmentManager fm = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.setReorderingAllowed(true);
            ft.replace(R.id.fragment_container_view_main, MainFragment.class, null);
            ft.commit();
        }
        @Override
        protected String doInBackground(Void... voids) {
            String result;

            try {
                result = post(GlobalVar.getUrl() + "/api/users/phone/", phone);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            if (!s.equals("Failed")) {
                Toast.makeText(getContext(), "Вы успешно вошли!", Toast.LENGTH_SHORT).show();

                Gson gson = new GsonBuilder().create();
                User user = gson.fromJson(s, User.class);

                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MainSetting", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("id", user.id);
                editor.apply();

                changeFragment();
            } else {
                Toast.makeText(getContext(), "Неверный логин или пароль!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
