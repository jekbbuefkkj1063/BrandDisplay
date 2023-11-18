package mrzcom.example.simple_login.ruiyang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import mrzcom.example.simple_login.R;
import mrzcom.example.simple_login.ruiyang.mode.Brand;

public class ImageAdapter extends BaseAdapter {
    private Context context;
    private List<Brand> brands;

    public ImageAdapter(Context context, List<Brand> brands) {
        this.context = context;
        this.brands = brands;
    }

    @Override
    public int getCount() {
        // 返回品牌列表的大小
        return brands.size();
    }

    @Override
    public Object getItem(int position) {
        // 返回当前位置的Brand对象
        return brands.get(position);
    }

    @Override
    public long getItemId(int position) {
        // 在这里你可以设置一个唯一的ID，例如Brand对象的数据库ID
        // 目前我们只返回位置值
        return position;
    }

    // 创建一个新的 ImageView 为每个被引用的项
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        ImageView imageView;
//        if (convertView == null) {
//            // 如果它不被重用，初始化一些属性
//            imageView = new ImageView(context);
//            imageView.setLayoutParams(new GridView.LayoutParams(GridView.AUTO_FIT, 300)); // 设置图片的大小
//            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            imageView.setPadding(8, 8, 8, 8);
//        } else {
//            imageView = (ImageView) convertView;
//        }
//
//        Brand brand = brands.get(position);
//        // 使用Glide加载图片
//        Glide.with(context)
//                .load(brand.getImageUrl()) // 使用Brand对象的图片URL
//                .into(imageView);
//
//        return imageView;
//    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.imageView);
        //imageView.setLayoutParams(new GridView.LayoutParams(GridView.AUTO_FIT, 200)); // 宽度自适应，高度固定
        TextView textView = convertView.findViewById(R.id.textView);

        Brand brand = brands.get(position);
        // 设置图片下方的品牌名称
        textView.setText(brand.getName());
        // 使用Glide加载图片
        Glide.with(context)
                .load(brand.getImageUrl())
                .into(imageView);

        return convertView;
    }
}
