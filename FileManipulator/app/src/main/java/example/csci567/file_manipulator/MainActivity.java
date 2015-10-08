package example.csci567.file_manipulator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;
import java.io.IOException;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Three Buttons

        //First Button:Button to Read Text
        Button readbtn = (Button) findViewById(R.id.button);
        readbtn.setOnClickListener(this);

        //Second Button :Button to Append Text
        Button appendbtn = (Button) findViewById(R.id.button2);
        appendbtn.setOnClickListener(this);

        //Third Button:Button to Replace Text
        Button replacebtn = (Button) findViewById(R.id.button3);
        replacebtn.setOnClickListener(this);

    }

    //create/open a file and write into file --the text from EditText field (Read button functionality)
    private boolean write(String receivedInput) {
        try {
            //try to create or open file
            File new_file;
            new_file = new File((Environment.getExternalStorageDirectory() + "/FileManip.txt"));
            if (!new_file.exists())
            {
                new_file.createNewFile();
            }

            //Go to exact location of the file using Absolute path and use FileWriter to write into the file
            FileWriter fw = new FileWriter(new_file.getAbsolutePath());

            //buffered writer give input to file writer and then file writer writes the buffered data into the file
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(receivedInput);
            bw.close();
            return true;
        } catch (IOException ioe) {
            Toast.makeText(getApplicationContext(), "file not found!", Toast.LENGTH_LONG).show();
            //error while opening file
        }
        return false;
    }


    public void read() {
        File sdcard = Environment.getExternalStorageDirectory();
        File file = new File(sdcard, "/FileManip.txt");
        StringBuilder input_1 = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String input;
            while ((input = br.readLine()) != null) {
                input_1.append(input);
                input_1.append('\n');
            }
        } catch (IOException ioe) {
            Toast.makeText(getApplicationContext(), "File not found!", Toast.LENGTH_LONG).show();
            //error message
        }
        TextView text_1 = (TextView) findViewById(R.id.tv);
        text_1.setText(input_1);
        //set to text view
    }

    private boolean append(String receivedInput) {
        try {
            //try to create or open file
            File new_file;
            new_file = new File((Environment.getExternalStorageDirectory() + "/FileManip.txt"));
            if (!new_file.exists())//
            {
                new_file.createNewFile();
            }
            //Go to exact location of the file using Absolute path and use FileWriter to write into the file
            FileWriter fw = new FileWriter(new_file.getAbsolutePath(), true);
            //buffered writer give input to file writer and then file writer writes the buffered data into the file
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(receivedInput);
            bw.close();
            return true;
        } catch (IOException ioe) {
            Toast.makeText(getApplicationContext(), "file not found!", Toast.LENGTH_LONG).show();
            //error while opening a file
        }
        return false;
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

    @Override
    public void onClick(View v) {
        int r_id = v.getId();

        if (r_id == R.id.button) {
            read();
            //read text from edit view

        } else if (r_id == R.id.button2) {
            EditText text_2 = (EditText) findViewById(R.id.editText);
            append(text_2.getText().toString());
            text_2.setText("");
            //set the text received from file as text view

        } else if (r_id == R.id.button3) {
            EditText text_3 = (EditText) findViewById(R.id.editText);
            write(text_3.getText().toString());
            text_3.setText("");
            //replace
        }
    }
}