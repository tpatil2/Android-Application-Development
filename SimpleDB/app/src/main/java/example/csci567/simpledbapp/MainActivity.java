package example.csci567.simpledbapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener
{

    //Creating object of the class
    myDBHelper dbObject;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbObject = new myDBHelper(this);
        //Adding set text button
        Button setText = (Button)findViewById(R.id.button);
        setText.setOnClickListener(this);
        //adding get text button
        Button getText = (Button)findViewById(R.id.button2);
        getText.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View src)
    {

         switch (src.getId())
         {
         case R.id.button:
         EditText txt = (EditText) findViewById(R.id.in);
         //writeDB
         String sendToDatabase = txt.getText().toString();
         dbObject.toDatabase(sendToDatabase);
         Log.d("Inserted", sendToDatabase );
         break;
         case R.id.button2:
         TextView txt2 = (TextView) findViewById(R.id.tv);
         //Replace the text in the textView with the following text.
         String test = dbObject.fromDatabase();
         Log.d("From database", test);
         txt2.setText(dbObject.fromDatabase());
         //readDB
         break;
         }
    }
}
