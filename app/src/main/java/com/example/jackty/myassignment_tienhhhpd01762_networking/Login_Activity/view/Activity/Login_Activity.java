package com.example.jackty.myassignment_tienhhhpd01762_networking.Login_Activity.view.Activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.jackty.myassignment_tienhhhpd01762_networking.Login_Activity.model.getidbundle;
import com.example.jackty.myassignment_tienhhhpd01762_networking.Login_Activity.presenter.Untils;
import com.example.jackty.myassignment_tienhhhpd01762_networking.Login_Activity.view.fragment.Fragment_login_main;
import com.example.jackty.myassignment_tienhhhpd01762_networking.Main_App.view.Activity.Mainc_Activity;
import com.example.jackty.myassignment_tienhhhpd01762_networking.R;

import java.util.ArrayList;

public class Login_Activity extends AppCompatActivity implements Fragment_login_main.Login {
    private static FragmentManager fragmentManager;
    private static View view;
    public static ArrayList<getidbundle> string_id_sendall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);

        fragmentManager = getSupportFragmentManager();

        // commit fragment login (nếu rỗng thì trả về fragment main login)
        if (savedInstanceState == null) {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frameContainer, new Fragment_login_main(),
                            Untils.Login_Fragment).commit();
        }
    }


    // trạại lại login

    public void replaceLoginFragment() {
        fragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.left_enter, R.anim.right_out)
                .replace(R.id.frameContainer, new Fragment_login_main(),
                        Untils.Login_Fragment).commit();
    }
    // xử lí phím back vật lí


    @Override
    public void onBackPressed() {
        Fragment SignUp_Fragment = fragmentManager
                .findFragmentByTag(Untils.SignUp_Fragment);
        Fragment ForgotPassword_Fragment = fragmentManager
                .findFragmentByTag(Untils.ForgotPassword_Fragment);
        Fragment Login_Fragment = fragmentManager
                .findFragmentByTag(Untils.Login_Fragment);
        if (SignUp_Fragment != null)
            replaceLoginFragment();
        else if (ForgotPassword_Fragment != null)
            replaceLoginFragment();
        else {

            //Khoi tao lai Activity main
            Intent intent = new Intent(getApplicationContext(), Login_Activity.class);
            startActivity(intent);
            // kết thúc app
            Intent startMain = new Intent(Intent.ACTION_MAIN);
            startMain.addCategory(Intent.CATEGORY_HOME);
            startActivity(startMain);
            finish();
        }
    }

    @Override
    public void success(String id) {



     //   startActivity(new Intent(this,Main2Activity.class));
        Toast.makeText(this,"xin chào :" +id, Toast.LENGTH_SHORT).show();



        Intent intent = new Intent(getApplicationContext(), Mainc_Activity.class);
//        intent.putExtra("id", id);
        startActivity(intent);


    }

    @Override
    public void fail(String user, String pass) {
        Toast.makeText(this, "Tài khoản không tồn tại", Toast.LENGTH_SHORT).show();



    }
}
