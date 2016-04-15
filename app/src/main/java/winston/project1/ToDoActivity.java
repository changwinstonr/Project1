package winston.project1;

/*import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;*/ //failed implements

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.LinkedList;

public class ToDoActivity extends AppCompatActivity {

    LinkedList<String> mStringList; //declaring these
    ArrayAdapter<String> mAdapter;
    EditText mEditText;
    Button mAddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.barstool);
        setSupportActionBar(barstool);*/ //this feature was drunk

        mEditText = (EditText) findViewById(R.id.editText);
        //textView = (TextView) findViewById(R.id.textView);
        String pos = getIntent().getStringExtra("Previous List"); //supposed to point to previous point. Need to investigate Intents and Extras.
        //textView.setText(String.valueOf(pos));

        mStringList = new LinkedList<>();


        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStringList);
        ListView listView = (ListView) findViewById(R.id.listViewLists);

        listView.setAdapter(mAdapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { //Long press
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                mStringList.remove(position);
                mAdapter.notifyDataSetChanged();
                return true;
            }
        });



        mAddButton = (Button) findViewById(R.id.btnAddToList);
        mAddButton.setOnClickListener(new View.OnClickListener() {  //Short press; "On(Short)Click"
            @Override
            public void onClick(View view) {

                String input = mEditText.getText().toString();

                if (input.length() >0) {
                    mStringList.add(input);
                    mAdapter.notifyDataSetChanged();    //important to tell the list that it is being updated
                    mEditText.setText("");
                }
            }
        });



        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mStringList.remove();
                mAdapter.notifyDataSetChanged();
                return true;
            }
        });*/
    }

}