package com.bkacad.edu.nnt.listviewanimald01;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    // Thuoc tinh: du lieu va context
    private Context context;
    private List<Animal> data;

    // Phuong thuc khoi tao
    public MyAdapter(Context context, List<Animal> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_animal, parent, false);
        }
        // Bind Id
        TextView tvAnimal = convertView.findViewById(R.id.tv_item_animal);
        ImageView imgAnimal = convertView.findViewById(R.id.img_item_animal);
        // Đổ dữ liệu
        Animal animal = data.get(position);
        // Do du lieu ra textview
        tvAnimal.setText(animal.getName());
        // Do du lieu ra imageview
        Glide.with(convertView).load(animal.getImage()).into(imgAnimal);

        return convertView;
    }
}
