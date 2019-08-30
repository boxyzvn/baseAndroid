package com.example.basemvvm.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;


import com.example.basemvvm.model.UserLogin;
import com.example.basemvvm.R;
import com.example.basemvvm.api.ApiServiceManager;
import com.example.basemvvm.api.callback.CallBackLogin;

import com.example.basemvvm.databinding.ActivityLoginBinding;
import com.example.basemvvm.utils.UIHelper;
import com.example.basemvvm.viewmodel.LoginViewModel;
import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    boolean isCorrect = false;
    private LoginViewModel loginViewModel;
    boolean isChecked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

        binding = DataBindingUtil.setContentView(LoginActivity.this, R.layout.activity_login);

        binding.setLifecycleOwner(this);

        binding.setLoginViewModel(loginViewModel);

        binding.edtUserName.setText("OKOKOKOK");
        binding.edtPass.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    loginViewModel.onEnterPress();
                }
                return false;
            }
        });
        loginViewModel.getUser().observe(this, new Observer<UserLogin>() {
            @Override
            public void onChanged(@Nullable UserLogin loginUser) {

                if (TextUtils.isEmpty(Objects.requireNonNull(loginUser).getUserName())) {
                    binding.edtUserName.setError("Enter an E-Mail Address");
                    binding.edtUserName.requestFocus();
                    isCorrect = false;
                } else if (TextUtils.isEmpty(Objects.requireNonNull(loginUser).getPassWord())) {
                    binding.tvErrorLogin.setText(loginUser.getPassWord());
                    binding.edtPass.setError("Enter a Password");
                    binding.edtPass.requestFocus();
                    isCorrect = false;
                } else if (!loginUser.isPasswordLengthGreaterThan5()) {
                    binding.edtPass.setError("Enter at least 6 Digit password");
                    binding.edtPass.requestFocus();
                    isCorrect = false;
                } else {
                    isCorrect = true;
                }
                loginViewModel.getCheckBox().observe(LoginActivity.this, new Observer<Boolean>() {
                    @Override
                    public void onChanged(Boolean aBoolean) {
                       isChecked = aBoolean;
                    }
                });
                if(isCorrect && isChecked){
                    callAPI(loginUser);
                }
                else binding.tvErrorLogin.setText("Need Check to Checkbox");
            }
        });


        binding.btnTerm.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        binding.btnTerm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, TermActivity.class));

            }
        });
    }

   public void callAPI(UserLogin loginUser){
       UIHelper.showProgress(this);

       ApiServiceManager.getInstance().login(loginUser.getUserName(), loginUser.getPassWord(), "12321", "1.0.5", new CallBackLogin() {
           @Override
           public void onComplete(String userName, String pass) {
               UIHelper.hideProgress();
               startActivity(new Intent(LoginActivity.this, MainActivity.class));
           }

           @Override
           public void onError(String errorCode) {
               UIHelper.hideProgress();
               binding.tvErrorLogin.setVisibility(View.VISIBLE);
               binding.tvErrorLogin.setText("Wrong UserName or Password");
           }
       });
   }
    /*public void sendCheckInToServer() {

        mCheckInExecutorService = Executors.newSingleThreadExecutor();
        final FragmentManager fragmentManager = getSupportFragmentManager();
        if (mCheckInExecutorService == null) {
            return;
        }
        mCheckInExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                //get TAGCAST UUUID

                Login checkIn = new Login();
                checkIn.initialize();
                checkIn.setData("", "");
                int response = checkIn.getData(getApplicationContext(), fragmentManager, 1, false);
                if (response == HttpURLConnection.HTTP_OK) {
                    try {
                        if (checkIn.resultJson.getInt("result") == -1) {
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));

                        } else {
                            binding.tvErrorLogin.setText("fail");
                        }
                    } catch (JSONException e) {
                        MLog.w(e.toString());
                    }
                }
            }
        });
    }*/

    @Override
    public void onBackPressed() {
    }
}
