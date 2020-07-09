package com.example.jackty.myassignment_tienhhhpd01762_networking.Login_Activity.view.fragment;


import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jackty.myassignment_tienhhhpd01762_networking.Login_Activity.presenter.CustomToast;
import com.example.jackty.myassignment_tienhhhpd01762_networking.Login_Activity.presenter.Untils;
import com.example.jackty.myassignment_tienhhhpd01762_networking.Login_Activity.view.Activity.Login_Activity;
import com.example.jackty.myassignment_tienhhhpd01762_networking.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_forgotpass extends Fragment implements View.OnClickListener {
    private static View view;
    private static EditText emailId;
    private static TextView submit, back;


    public Fragment_forgotpass() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_forgotpass, container,
                false);
        initViews();
        back.setOnClickListener(this);
        submit.setOnClickListener(this);
        return view;

    }

    private void initViews() {
        emailId = (EditText) view.findViewById(R.id.registered_emailid);
        submit = (TextView) view.findViewById(R.id.forgot_button);
        back = (TextView) view.findViewById(R.id.backToLoginBtn);
        XmlResourceParser xrp = getResources().getXml(R.drawable.text_selector);
        try {
            ColorStateList csl = ColorStateList.createFromXml(getResources(),
                    xrp);

            back.setTextColor(csl);
            submit.setTextColor(csl);

        } catch (Exception e) {
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.backToLoginBtn:
                new Login_Activity().replaceLoginFragment();
                break;
            case R.id.forgot_button:
                submitButtonTask();
                break;

        }
    }

    private void submitButtonTask() {
        String getEmailId = emailId.getText().toString();
        Pattern p = Pattern.compile(Untils.regEx);
        Matcher m = p.matcher(getEmailId);
        if (getEmailId.equals("") || getEmailId.length() == 0)
            new CustomToast().Show_Toast(getActivity(), view,
                    "bạn chưa nhập email	");
        else if (!m.find())
            new CustomToast().Show_Toast(getActivity(), view,
                    "email của bạn không hợp lệ");
        else
            Toast.makeText(getActivity(), "Get Forgot Password.",
                    Toast.LENGTH_SHORT).show();
    }

}

