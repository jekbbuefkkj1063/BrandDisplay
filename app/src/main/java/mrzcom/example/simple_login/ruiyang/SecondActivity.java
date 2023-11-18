package mrzcom.example.simple_login.ruiyang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import mrzcom.example.simple_login.R;
import mrzcom.example.simple_login.ruiyang.ImageAdapter;
import mrzcom.example.simple_login.ruiyang.mode.Brand;

public class SecondActivity extends AppCompatActivity {
    TextView textViewTitle;
    //@Override
    //protected void onCreate(Bundle savedInstanceState) {
    //    super.onCreate(savedInstanceState);
    //    setContentView(R.layout.activity_second);
    //}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewTitle = findViewById(R.id.textViewTitle); // 获取左上角的TextView组件
        GridView gridView = findViewById(R.id.gridview);



        ImageButton btnHome = findViewById(R.id.btnHome);
        ImageButton btnSearch = findViewById(R.id.btnSearch);
        ImageButton btnMyAccount = findViewById(R.id.btnMyAccount);

        btnHome.setOnClickListener(view -> {
            // 清除所有的Fragments
            getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            textViewTitle.setText("HOME"); // 设置标题为 HOME
            // TODO: 显示 HOME 页面内容
            List<Brand> brandList = new ArrayList<>();
            // 添加品牌信息
            brandList.add(new Brand("四季沐歌", "https://0.rc.xiniu.com/g3/M00/19/D1/CgAH513zMS2AGKzdAAKs7hhLwwM606.png", "2"));
            brandList.add(new Brand("太阳雨", "https://www.szthekey.com/wp-content/uploads/2020/11/uuuMfi.jpg", "3"));
            brandList.add(new Brand("力诺瑞特", "https://logo800.cn/uploads/logoxinshang/6/logo800_1649156532270512.jpg", "4"));
            brandList.add(new Brand("桑乐", "https://tse2-mm.cn.bing.net/th/id/OIP-C.r6zc2OBQ1TF1P7jMTT3rnAHaEK?pid=ImgDet&rs=1", "5"));
            brandList.add(new Brand("清华阳光", "https://tse2-mm.cn.bing.net/th/id/OIP-C.i1_8w_3z33C8oabp14UNXAHaE8?pid=ImgDet&rs=1", "6"));
            brandList.add(new Brand("天丰", "https://ts1.cn.mm.bing.net/th/id/R-C.ffe6f11683a9b1cbf12bd95d56e49b05?rik=CRmaEQGwMUFALg&riu=http%3a%2f%2fwww.tfee.cn%2ftemplate%2ftaiyangneng%2fimages%2fab_tu03.jpg&ehk=dWingik3%2biMS6ZKBv6u4vpqsXyD%2fjG6JqKyRGLwib3A%3d&risl=&pid=ImgRaw&r=0", "7"));
            brandList.add(new Brand("海尔", "https://ts1.cn.mm.bing.net/th/id/R-C.9e40eb506153a09b7b6bb7abd854e846?rik=bmXC9m6pcW2aqQ&riu=http%3a%2f%2fimage.yjcf360.com%2fu%2fcms%2fwww%2f202012%2f0710135124tt.png&ehk=7tkxpeIh2ynsatotOwy%2f6oMIuUQepWqH%2f11nBDaFlHo%3d&risl=&pid=ImgRaw&r=0", "8"));
            brandList.add(new Brand("盼盼乐", "https://zhengxin-pub.cdn.bcebos.com/logopic/bedfdd1f8014743f0eec349e2d0cc225_fullsize.jpg","9"));
            gridView.setAdapter(new ImageAdapter(this, brandList));
        });

        btnSearch.setOnClickListener(view -> {
            // 清除所有的Fragments
            getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            gridView.setAdapter(new ImageAdapter(this, Collections.emptyList()));
            // TODO: 显示搜索框
            textViewTitle.setText("SEARCH"); // 设置标题为 SEARCH
            // 创建 Layout2 的实例
            Layout2 searchFragment = new Layout2();
            // 获取 FragmentManager 并开始一个事务
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            // 将容器替换为新的 Fragment，并提交事务
            transaction.replace(R.id.fragment_container, searchFragment);
            transaction.addToBackStack(null); // 如果你想让用户可以回到之前的状态
            transaction.commit();
        });

        btnMyAccount.setOnClickListener(view -> {
            // 清除所有的Fragments
            getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            textViewTitle.setText("MY ACCOUNT"); // 设置标题为 MY ACCOUNT
            // TODO: 显示 MY ACCOUNT 页面内容
        });
    }
}
