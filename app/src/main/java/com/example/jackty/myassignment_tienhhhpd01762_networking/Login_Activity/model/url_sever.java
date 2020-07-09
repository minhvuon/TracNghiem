package com.example.jackty.myassignment_tienhhhpd01762_networking.Login_Activity.model;

/**
 * Created by jackty on 25/07/2017.
 */

public class url_sever {
    public static final String httpt = "http://192.168.1.18/";
    public static final String Signup_acc = httpt+"Android_networking/Assigntment_/Login/addAcc.php";
    public  static final String GetAll_acc = httpt+"Android_networking/Assigntment_/Login/getallAcc.php";
    public  static final String Get1_acc = httpt+"Android_networking/Assigntment_/Login/get1Acc.php?id=";

    // changepass
    public static final String updatepass = httpt+"Android_networking/Assigntment_/Login/updatepass.php";
    // load question
    public  static final String loadques1 = httpt+"Android_networking/Assigntment_/Question/GetQs1.php";
    public  static final String loadques2 = httpt+"Android_networking/Assigntment_/Question/GetQs2.php";


    // add score to sever
    public static final String addscoretosevr = httpt+"Android_networking/Assigntment_/Top/addtop.php";
    public static final String getalltop = httpt+"Android_networking/Assigntment_/Top/getalltop.php";

    // delete acc

    public static final String deleteacc =httpt+"Android_networking/Assigntment_/Login/deleteacc.php";


}
