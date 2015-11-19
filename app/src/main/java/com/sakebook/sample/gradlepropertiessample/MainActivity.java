package com.sakebook.sample.gradlepropertiessample;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_expandable_list_item_1, getProperties());
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);
    }

    private List<String> getProperties() {
        ArrayList<String> lists = new ArrayList<>();
//        BuildConfig_.IS_DEBUG

//        PackageItemInfo info = new PackageItemInfo();
//        info.metaData.getString("test_key");

//        ApplicationInfo info = getPackageManager().getApplicationInfo("hoge.package.name", PackageManager.GET_META_DATA);
//        Bundle metadata = info.metaData;
        PackageManager packageManager = getPackageManager();
        ApplicationInfo info = null;
        try {
            info = packageManager.getApplicationInfo(BuildConfig.APPLICATION_ID, PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<String> hoge = BuildConfig.HUGA_LIST;
        hoge.add("huga");

        lists.add("resource: hoge_id = " + getString(R.string.hoge_id));
        lists.add("resource: hoge_host = " + getString(R.string.hoge_host));
        lists.add("resource: hoge_meta_id = " + getString(R.string.hoge_meta_id));
        lists.add("resource: hoge_meta_key = " + getString(R.string.hoge_meta_key));
        lists.add("resource: properties_color = " + ContextCompat.getColor(this, R.color.properties_color));
        lists.add("resource: properties_dimen = " + getResources().getDimension(R.dimen.properties_dimen));
        lists.add("meta-data: hoge_key = " + info.metaData.getString("hoge_key"));
        lists.add("meta-data: hoge_id = " + info.metaData.getString("hoge_id"));
        lists.add("meta-data: hoge_value = " + info.metaData.getString("hoge_value"));

        return lists;

    }

}
