package com.pro4gao.load;

import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.morgoo.droidplugin.pm.PluginManager;
import com.morgoo.helper.Log;
import com.pro4gao.R;
import com.pro4gao.model.ApkItem;
import com.pro4gao.utils.ApkOperator;

import java.io.File;
import java.util.ArrayList;

public class LoadApkActivity extends AppCompatActivity {

    private Button load_button;
    private ApkOperator apkOperator;
    private String path;
    private Button start_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_apk);
        init();
        apkOperator = new ApkOperator(LoadApkActivity.this, new ApkOperator.RemoveCallback() {
            @Override
            public void removeItem(ApkItem apkItem) {

            }
        });
    }

    private void init() {
        load_button = (Button) findViewById(R.id.load_button);
        start_button = (Button) findViewById(R.id.start_button);
        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                PackageManager pm = getPackageManager();
//                Intent intent = pm.getLaunchIntentForPackage("com.itotem.kangle");
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);
                Intent intent = new Intent();
                //设置Action
                intent.setAction("android.intent.action.MAIN");
                //对于android.intent.category.DEFAULT类型的信息为Android系统默认的信息，省略也可以
                intent.addCategory("android.intent.category.DEFAULT");
                //启动Activity
                startActivity(intent);
            }
        });
        load_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getApkFromDownload();

            }
        });
    }


    private class InstallApkTask extends AsyncTask<Void, Void, String> {
        @Override
        protected void onPostExecute(String v) {
            Toast.makeText(LoadApkActivity.this, v, Toast.LENGTH_LONG).show();
        }

        @Override
        protected String doInBackground(Void... params) {
            try {
                int result = PluginManager.getInstance().installPackage(path, 0);
                boolean isRequestPermission = (result == PluginManager.INSTALL_FAILED_NO_REQUESTEDPERMISSION);
                if (isRequestPermission) {
                    return "权限不足";
                }
            } catch (RemoteException e) {
                e.printStackTrace();
                return "安装失败";
            }


            return "haha";
        }
    }


    // 从下载文件夹获取Apk
    private ArrayList<ApkItem> getApkFromDownload() {
        File files = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        PackageManager pm = getPackageManager();
        ArrayList<ApkItem> apkItems = new ArrayList<>();
        for (File file : files.listFiles()) {
            Log.e(file.getName(), "gaoyiming");
            if (file.exists() && file.getPath().toLowerCase().endsWith(".apk")) {
                final PackageInfo info = pm.getPackageArchiveInfo(file.getPath(), 0);
                path = file.getPath();
                new InstallApkTask().execute();
                //   apkItems.add(new ApkItem(pm, info, file.getPath()));
            }
        }
        return apkItems;
    }
}
