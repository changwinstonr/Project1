package winston.project1;

/*import android.content.Context;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;*/ //unused: failed implements

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    LinkedList<String> mStringList;
    ArrayAdapter<String> mAdapter;
    EditText mEditText;
    Button mAddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStringList = new LinkedList<>();
        mStringList.add("Read");
        mStringList.add("Learn");
        mStringList.add("Buy");

        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mStringList);

        ListView listName = (ListView) (findViewById(R.id.listView));
        listName.setAdapter(mAdapter);
        mEditText = (EditText) (findViewById(R.id.editText));
        mAddButton = (Button) (findViewById(R.id.addTextButton));



        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String input = mEditText.getText().toString();

                if (input.length() > 0) {
                    mStringList.add(input);
                    mAdapter.notifyDataSetChanged();
                    mEditText.setText("");
                } else{
                    Toast.makeText(getApplicationContext(), "No Entry Found", Toast.LENGTH_LONG).show();    //should created buttered toast when no input detected on Add press
                }
            }
        });

        listName.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                mStringList.remove(position);
                mAdapter.notifyDataSetChanged();
                return true;
            }
        });

        listName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent todolist = new Intent(MainActivity.this, ToDoActivity.class);
                startActivity(todolist);
            }
        });

//supposedly alters the soft-keyboard's 'return' into 'Done'. Aimed to remove the need for an Add button and hide the keyboard after input.
/*        mEditText = (EditText) findViewById(R.id.done);
        mEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    mStringList();
                    handled = true;
                }
                return handled;
            }
    */

    }
}
