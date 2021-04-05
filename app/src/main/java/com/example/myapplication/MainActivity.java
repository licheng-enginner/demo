package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout mTabWeixin;
    private LinearLayout mTabFrd;
    private LinearLayout mTabcontact;
    private LinearLayout mTabsetting;

    private ImageButton imageWeixin;
    private ImageButton imageFrd;
    private ImageButton imagecontact;
    private ImageButton imagesetting;


    private Fragment mTab01 =new weixinFragment();
    private Fragment mTab02 =new friendFragment();
    private Fragment mTab03 =new contactFragment();
    private Fragment mTab04 =new settingFragment();
    private FragmentManager fm;

    public void onClick(View v){
        Log.d("onClick","1");
        resetImgs();
        switch (v.getId()){
            case R.id.id_tab_weixin:
                Log.d("onClick","2");
                setSelect(0);
                break;
            case R.id.id_tab_friend:
                setSelect(1);
                break;
            case R.id.id_tab_contact:
                setSelect(2);
                break;
            case R.id.id_tab_setting:
                setSelect(3);
                break;
            default:
                break;
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initFragment();
        initView();
        setSelect(0);
        initEvent();
    }
    private void initEvent(){
        mTabWeixin.setOnClickListener(this);
        mTabFrd.setOnClickListener(this);
        mTabcontact.setOnClickListener(this);
        mTabsetting.setOnClickListener(this);
    }
    private void setSelect(int i){
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);
        switch (i){
            case 0:
                Log.d("setSelect","1");
                transaction.show(mTab01);
                imageWeixin.setImageResource(R.drawable.tab_weixin_pressed);
                break;
            case 1:
                transaction.show(mTab02);
                imageFrd.setImageResource(R.drawable.tab_find_frd_pressed);
                break;
            case 2:
                transaction.show(mTab03);
                imagecontact.setImageResource(R.drawable.tab_address_pressed);
                break;
            case 3:
                transaction.show(mTab04);
                imagesetting.setImageResource(R.drawable.tab_settings_pressed);
                break;
            default:
                break;
        }
        transaction.commit();

    }
    private void hideFragment(FragmentTransaction transaction){
        transaction.hide(mTab01);
        transaction.hide(mTab02);
        transaction.hide(mTab03);
        transaction.hide(mTab04);
    }
    private void resetImgs(){
        imageWeixin.setImageResource(R.drawable.tab_weixin_normal);
        imageFrd.setImageResource(R.drawable.tab_find_frd_normal);
        imagecontact.setImageResource(R.drawable.tab_address_normal);
        imagesetting.setImageResource(R.drawable.tab_settings_normal);
    }


    private void initFragment(){
        fm=getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.id_content,mTab01);
        transaction.add(R.id.id_content,mTab02);
        transaction.add(R.id.id_content,mTab03);
        transaction.add(R.id.id_content,mTab04);
        transaction.commit();
    }
    private void initView(){
        mTabWeixin = (LinearLayout) findViewById(R.id.id_tab_weixin);
        mTabFrd =(LinearLayout) findViewById(R.id.id_tab_friend);
        mTabcontact =(LinearLayout) findViewById(R.id.id_tab_contact);
        mTabsetting =(LinearLayout) findViewById(R.id.id_tab_setting);

        imageWeixin =(ImageButton) findViewById(R.id.id_tab_weixin_img);
        imageFrd =(ImageButton) findViewById(R.id.id_tab_friend_img);
        imagecontact =(ImageButton) findViewById(R.id.id_tab_contact_img);
        imagesetting =(ImageButton) findViewById(R.id.id_tab_setting_img);
    }
}