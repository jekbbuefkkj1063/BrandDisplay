package mrzcom.example.simple_login.ruiyang;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import mrzcom.example.simple_login.R;
import mrzcom.example.simple_login.ruiyang.mode.Brand;

import android.graphics.drawable.Drawable;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class Layout2 extends Fragment {
    private GridLayout gridLayoutHotSearch;
    private GridLayout gridLayoutLatelySearch;
    private TextView textViewTitle; // 假设您已经在Fragment中有了对标题TextView的引用
    private ImageView imageViewBrand; // 假设您有一个ImageView用来显示品牌的图片
    private List<Brand> brandList = new ArrayList<Brand>();



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 加载布局
        View view = inflater.inflate(R.layout.fragment_layout2, container, false);

        // 初始化组件
        gridLayoutHotSearch = view.findViewById(R.id.gridLayoutHotSearch);
        gridLayoutLatelySearch = view.findViewById(R.id.gridLayoutLatelySearch);

        // 初始化数据
        initializeBrandList();

        // 填充界面
        populateLatelySearch();
        populateHotSearch();


        Button buttonHotItem = view.findViewById(R.id.buttonHotItem);
        buttonHotItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 假设brandList不为空且至少有一个元素
                if (!brandList.isEmpty()) {
                    Brand firstBrand = brandList.get(0); // 获取列表中的第一个品牌
                    Toast.makeText(getContext(), "品牌名: " + firstBrand.getName(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    private void initializeBrandList() {
        brandList = new ArrayList<>();
        // 添加品牌信息
        brandList.add(new Brand("四季沐歌", "https://0.rc.xiniu.com/g3/M00/19/D1/CgAH513zMS2AGKzdAAKs7hhLwwM606.png", "2"));
        brandList.add(new Brand("太阳雨", "https://www.szthekey.com/wp-content/uploads/2020/11/uuuMfi.jpg", "3"));
        brandList.add(new Brand("力诺瑞特", "https://logo800.cn/uploads/logoxinshang/6/logo800_1649156532270512.jpg", "4"));
        brandList.add(new Brand("桑乐", "https://tse2-mm.cn.bing.net/th/id/OIP-C.r6zc2OBQ1TF1P7jMTT3rnAHaEK?pid=ImgDet&rs=1", "5"));
        brandList.add(new Brand("清华阳光", "https://tse2-mm.cn.bing.net/th/id/OIP-C.i1_8w_3z33C8oabp14UNXAHaE8?pid=ImgDet&rs=1", "6"));
        brandList.add(new Brand("天丰", "https://ts1.cn.mm.bing.net/th/id/R-C.ffe6f11683a9b1cbf12bd95d56e49b05?rik=CRmaEQGwMUFALg&riu=http%3a%2f%2fwww.tfee.cn%2ftemplate%2ftaiyangneng%2fimages%2fab_tu03.jpg&ehk=dWingik3%2biMS6ZKBv6u4vpqsXyD%2fjG6JqKyRGLwib3A%3d&risl=&pid=ImgRaw&r=0", "7"));
        brandList.add(new Brand("海尔", "https://ts1.cn.mm.bing.net/th/id/R-C.9e40eb506153a09b7b6bb7abd854e846?rik=bmXC9m6pcW2aqQ&riu=http%3a%2f%2fimage.yjcf360.com%2fu%2fcms%2fwww%2f202012%2f0710135124tt.png&ehk=7tkxpeIh2ynsatotOwy%2f6oMIuUQepWqH%2f11nBDaFlHo%3d&risl=&pid=ImgRaw&r=0", "8"));
        brandList.add(new Brand("盼盼乐", "https://zhengxin-pub.cdn.bcebos.com/logopic/bedfdd1f8014743f0eec349e2d0cc225_fullsize.jpg","9"));
    }

    private void populateLatelySearch() {
        String[] latelySearches = {"lately1", "lately2", "lately3"};
        int index = 0;
        for (String hotSearch : latelySearches) {
            index++;
            TextView textView = new TextView(getContext());
            textView.setText(hotSearch);
            textView.setPadding(8, 8, 8, 8);
            textView.setCompoundDrawablePadding(16);

            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.setMargins(16, 16, 16, 16); // 根据需要调整
            gridLayoutLatelySearch.addView(textView, params);
        }
    }

    private void populateHotSearch() {
        int index = 0;
        for (final Brand brand : brandList) {
            index++;
            TextView textView = new TextView(getContext());
            textView.setText(brand.getName());
            textView.setPadding(8, 8, 8, 8);
            Drawable img = null;
            if (index < 4){
                img = ContextCompat.getDrawable(getContext(), R.drawable.ic_dot);
            }else{
                img = ContextCompat.getDrawable(getContext(), R.drawable.ic_blackdot);
            }

            img.setBounds(0, 0, img.getIntrinsicWidth(), img.getIntrinsicHeight());
            textView.setCompoundDrawables(img, null, null, null);
            textView.setCompoundDrawablePadding(16);

            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.setMargins(16, 16, 16, 16); // 根据需要调整

            // 设置点击事件
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 显示Toast提示
                    Toast.makeText(getContext(), "点击了" + brand.getName(), Toast.LENGTH_SHORT).show();
                }
            });
            gridLayoutHotSearch.addView(textView, params);
        }
    }

}
