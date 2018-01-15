package alaric.smith.mytodolist;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by smithal on 15/01/2018.
 */
public class TodoActivity extends Activity implements View.OnClickListener {

    private Button validate ;
    private Button clear ;
    //private TextView textView;
    private EditText editText;
    private ListView lvMyListView;

    public TodoActivity() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_layout);

        Singleton.getInstance();

        validate = (Button) findViewById(R.id.validate);
        validate.setOnClickListener(this) ;
        clear = (Button) findViewById(R.id.empty);
        clear.setOnClickListener(this) ;
        //textView = (TextView) findViewById(R.id.text);
        editText = (EditText) findViewById(R.id.input);
        lvMyListView = (ListView)findViewById(R.id.listView);
        lvMyListView.setAdapter(new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, Singleton.getInstance().getList()));
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.validate) {
            if( editText.getText().toString() != "" ) {
                Singleton.getInstance().addElement(editText.getText().toString());
                //textView.setText(Singleton.getInstance().getList().toString());
                lvMyListView.setAdapter(new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, Singleton.getInstance().getList()));
            }
            else {
                Toast.makeText(getApplicationContext(), "Vide !!", Toast.LENGTH_SHORT).show();
            }
        }
        else if(v.getId() == R.id.empty) {
            Singleton.getInstance().empty();
            //textView.setText(Singleton.getInstance().getList().toString());
            lvMyListView.setAdapter(new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, Singleton.getInstance().getList()));
            Toast.makeText(getApplicationContext(), "Liste vidée", Toast.LENGTH_SHORT).show();
        }
    }

}
