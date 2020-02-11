package org.ftninformatika.termin18_jelovnik;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvItem;
    List<Jelo> jela;
    List<String> imena=new ArrayList<>();
    ProgressDialog pd;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        startAsyncTask(2);
        lvItem=findViewById(R.id.lv1);
        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,imena);

        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(MainActivity.this,my_item.class);
                i.putExtra("position",jela.get(position).getId());
                startActivity(i);
            }
        });

    }



    private void startAsyncTask(int secs){
        new MyAsyncTask().execute(secs);
    }

    private void showProgressDialog(){
        if(pd==null){
            pd=new ProgressDialog(this);
        }
        if(pd.isShowing()){
            pd.dismiss();
        }
        pd.setTitle("Sacekajte");
        pd.setMessage("Ucitavanje jela je u toku");
        pd.show();
    }

    private void closeProgressDialog(){
        if(pd!=null){
            pd.dismiss();
        }
    }

    private void updateProgressDialog(int secs){
        if(pd!=null){
            pd.setMessage("Ucitavanje jela je u toku \nPreostalo " +secs+ " sekundi");
        }
    }

    public class MyAsyncTask extends AsyncTask<Integer, Integer, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // progressBar.setVisibility(View.VISIBLE);
            showProgressDialog();

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            //progressBar.setVisibility(View.INVISIBLE);
            jela=DataProvider.getInstance().getJela();
            for(int i=0;i<jela.size();i++){
                imena.add(jela.get(i).getName());
            }
            closeProgressDialog();
            lvItem.setAdapter(adapter);

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            updateProgressDialog(values[0]);
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            for(int i=0;i<integers[0];i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(integers[0]-i);
            }
            return null;
        }
    }
}
