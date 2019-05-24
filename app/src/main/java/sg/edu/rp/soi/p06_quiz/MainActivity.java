package sg.edu.rp.soi.p06_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //Check in by 123
    EditText num;
    EditText numa;
    TextView operation;
    Button btn;
    View result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num = findViewById(R.id.etNum1);
        numa = findViewById(R.id.etNum2);
        operation = findViewById(R.id.tvOperation);
        btn = findViewById(R.id.btnReset);


        registerForContextMenu(operation);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                num.setText("");
                numa.setText("");
            }

        });

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"+");
        menu.add(0,1,1,"-");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId()==0) { //check whether the selected menu item ID is 0
            int num1 = Integer.parseInt(num.getText().toString());
            int num2 = Integer.parseInt(numa.getText().toString());
            int sum = num1 + num2;
            operation.setText(Integer.toString(sum));
            return true; //menu item successfully handled
        }
        else if(item.getItemId()==1) { //check if the selected menu item ID is 1
            int num1 = Integer.parseInt(num.getText().toString());
            int num2 = Integer.parseInt(numa.getText().toString());
            int ans = num1 - num2;
            operation.setText(Integer.toString(ans));
            return true;  //menu item successfully handled
        }

        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }




}
