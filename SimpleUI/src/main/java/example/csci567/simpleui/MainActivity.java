package example.csci567.simpleui;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            Button b1 =  (Button) rootView.findViewById(R.id.button1);
            Button b2 =  (Button) rootView.findViewById(R.id.button2);
            Button b3 =  (Button) rootView.findViewById(R.id.button3);

            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView t1=(TextView) rootView.findViewById(R.id.textview1);
                    TextView t2=(TextView) rootView.findViewById(R.id.textview2);

                    t1.setText("You have clicked Button 1");
                    t2.setText("You have clicked Button 1");
                }
            });

            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    TextView t1=(TextView) rootView.findViewById(R.id.textview1);
                    TextView t2=(TextView) rootView.findViewById(R.id.textview2);
                    t1.setText("You have pressed Button 2");
                    t2.setText("You have pressed Button 2");
                }
            });

            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView t1=(TextView) rootView.findViewById(R.id.textview1);
                    TextView t2=(TextView) rootView.findViewById(R.id.textview2);
                    t1.setText("You have clicked Button 3");
                    t2.setText("You have clicked Button 3");
                }
            });

            return rootView;
        }
    }
}
