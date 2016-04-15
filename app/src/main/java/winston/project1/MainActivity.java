package winston.project1;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

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

        View view = this.getCurrentFocus();
  /*      if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }*/

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = mEditText.getText().toString();
                if (input.length() > 0) {
                    mStringList.add(input);
                    mAdapter.notifyDataSetChanged();
                    mEditText.setText("");
                }
            }
        });
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
    }*/
}
