package com.example.rajeev.myapp;



import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    ListView myListView;
    ConstraintLayout frontLayout;
    EditText Title, Times;
    int Z = 0;
    ArrayList<String> Name;
    ArrayAdapter<String> nameAdapter;
    ArrayList<String> time;
    long l;
    Calendar c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myListView = (ListView) findViewById(R.id.myListView);
        Title = (EditText) findViewById(R.id.Title);
        Times = (EditText) findViewById(R.id.Time);
        frontLayout = findViewById(R.id.frontLayout);
        Name = new ArrayList<String>();
        nameAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Name);
        myListView.setAdapter(nameAdapter);
        time = new ArrayList<String>();


        final Handler handler = new Handler();
        Runnable run = new Runnable() {
            @Override
            public void run() {
                check();
                handler.postDelayed(this, 60000);
            }
        };
        handler.post(run);


    }

    public void newListCreate(View view)

    {
        frontLayout.setVisibility(View.VISIBLE);
    }

    public void submitList(View view) {
        String string, str;
        frontLayout.setVisibility(View.INVISIBLE);
        string = Title.getText().toString();
        str = Times.getText().toString();
        Name.add(Z, string);
        nameAdapter.notifyDataSetChanged();
        //ading time to arrya
        time.add(Z, str);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, time.get(i), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void check() {

        SimpleDateFormat df;
        c = Calendar.getInstance();
        df = new SimpleDateFormat(" HH");
        String t = df.format(c.getTime());

        int i = c.get(Calendar.AM_PM);
        int hr=c.get(Calendar.HOUR);
         int mm=c.get(Calendar.MINUTE);
         if(i==1)
             hr=hr+12;
         String sr=Integer.toString(hr)+":"+Integer.toString(mm);
         System.out.println("ans is "+checks(time,sr));
         System.out.println("current time is" + sr);

    }


    private static boolean checks(ArrayList<String> time, String t) {

        for (String s : time)
            if (time.contains(t)) {
                return true;
            }
        return false;
    }
}


