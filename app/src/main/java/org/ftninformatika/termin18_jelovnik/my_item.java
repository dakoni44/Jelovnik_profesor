package org.ftninformatika.termin18_jelovnik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class my_item extends AppCompatActivity {

    TextView textView1,textView2;
    DataProvider dp=new DataProvider();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_item);

        int id=getIntent().getExtras().getInt("position", 0);
        textView1=findViewById(R.id.tvIme);
        textView2=findViewById(R.id.tvPrezime);
        textView1.setText(dp.getJeloById(id).getName());
        textView2.setText(String.valueOf(dp.getJeloById(id).getCena()));
    }
}
