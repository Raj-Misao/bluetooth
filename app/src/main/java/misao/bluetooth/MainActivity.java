package misao.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_bluetooth;
    BluetoothAdapter bluetoothAdapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_bluetooth = (Button)findViewById(R.id.bluetooth);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        btn_bluetooth.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(bluetoothAdapter == null)
        {
            Toast.makeText(getApplicationContext(),"Bluetooth not found...",Toast.LENGTH_LONG).show();
        }
        else
        {
            if(!bluetoothAdapter.isEnabled())
            {
                bluetoothAdapter.enable();
                Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivity(intent);

                Toast.makeText(getApplicationContext(),"Bluetoothe found..."+bluetoothAdapter,Toast.LENGTH_LONG).show();
            }

            else
            {
                bluetoothAdapter.disable();
            }
        }
    }
}
