package com.bkacad.edu.nnt.listviewanimald01;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvAnimals;
    // Du lieu
    private List<Animal> data;
    // Adapter
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Bind id
        lvAnimals = findViewById(R.id.lvAnimals);
        // Khoi tao du lieu
        data = new ArrayList<>();
        data.add(new Animal("Tiger 1", "https://pngimg.com/d/tiger_PNG23219.png"));
        data.add(new Animal("Dog 1","https://images.freeimages.com/images/large-previews/ebc/joyful-white-dog-in-nature-0410-5697280.jpg?fmt=webp&w=500"));
        data.add(new Animal("Cat 1","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ8p9_CEgRJn8NaNKZ9jYOBPbQOIFFtdBjj5A&s"));
        data.add(new Animal("Tiger 2", "https://pngimg.com/d/tiger_PNG23219.png"));
        data.add(new Animal("Dog 2","https://images.freeimages.com/images/large-previews/ebc/joyful-white-dog-in-nature-0410-5697280.jpg?fmt=webp&w=500"));
        data.add(new Animal("Cat 2","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ8p9_CEgRJn8NaNKZ9jYOBPbQOIFFtdBjj5A&s"));

        // Chuan bi Adapter
        myAdapter = new MyAdapter(this, data);
        // Setadapter cho listview
        lvAnimals.setAdapter(myAdapter);

        // Click itemview
        lvAnimals.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, data.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}