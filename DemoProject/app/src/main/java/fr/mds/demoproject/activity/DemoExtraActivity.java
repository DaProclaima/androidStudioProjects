package fr.mds.demoproject.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import fr.mds.demoproject.model.Virus;

public class DemoExtraActivity extends Activity {

    private Button bt_demo_extra_ok;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_extra);

        bt_demo_extra_ok = findViewById(R.id.bt_demo_extra_ok);

        Bundle bundle = getIntent().getExtras();

        if( bundle != null) {
            String message = bundle.getString("message");
            ((TextView)findViewById(R.id.tv_demo_extra_message)).setText(message);

            Virus virus = (Virus) bundle.getSerializable("virus");
            Toast.makeText(this, virus.toString(), Toast.LENGTH_SHORT).show();
        }

        bt_demo_extra_ok.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                getIntent().putExtra("response", "This is a response from DemoExtraActivity");
                setResult(10, getIntent());
                finish();
            }
        });
    }
}
