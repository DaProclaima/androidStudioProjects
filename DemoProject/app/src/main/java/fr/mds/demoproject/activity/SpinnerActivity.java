package fr.mds.demoproject.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import fr.mds.demoproject.adapter.VirusListAdapter;
import fr.mds.demoproject.model.ProgramingLanguage;
import fr.mds.demoproject.model.Virus;

public class SpinnerActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_main_1, bt_main_2, bt_main_3;
    private Spinner sp_main_select, sp_main_custom_select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        bt_main_1 = findViewById(R.id.bt_main_1);
        bt_main_2 = findViewById(R.id.bt_main_2);
        bt_main_3 = findViewById(R.id.bt_main_3);
        sp_main_select = findViewById(R.id.sp_main_select);
        sp_main_custom_select = findViewById(R.id.sp_main_custom_select);

        bt_main_1.setOnClickListener(this);
        bt_main_2.setOnClickListener(this);
        bt_main_3.setOnClickListener(this);

        ProgramingLanguage[] programingLanguages = {
                new ProgramingLanguage("Java", "Java is life !"),
                new ProgramingLanguage("C++", "Not bad !"),
                new ProgramingLanguage("C", "Mother of languages !"),
                new ProgramingLanguage("C#", "Hmmm... Microsoft ?"),
                new ProgramingLanguage("Node JS", "Waaw, amazing and wild ..."),
                new ProgramingLanguage("Cobol", "Drop that bro...")
        };

        ArrayAdapter arrayAdapter = new ArrayAdapter<ProgramingLanguage>(
                this,
                R.layout.item_spinner,
                programingLanguages
        );

        sp_main_select.setAdapter(arrayAdapter);


        List<Virus> virusList = new ArrayList<>();

        virusList.add(new Virus("Covid-19", "Wuhan", 4));
        virusList.add(new Virus("Spanish flue", "Spain", 4));
        virusList.add(new Virus("WinVista", "USA", 90));
        virusList.add(new Virus("WinXp", "USA", 20));

        VirusListAdapter virusListAdapter = new VirusListAdapter(this,  virusList);
        sp_main_custom_select.setAdapter(virusListAdapter);
    }



    @Override
    public void onClick(View v) {

        if ( v == bt_main_1) {
            Toast.makeText(this, "Button 1 clicked", Toast.LENGTH_SHORT).show();
            return;
        }

        if ( v == bt_main_2) {
            Object object = sp_main_select.getSelectedItem();
            ProgramingLanguage selectedProgramingLanguage = (ProgramingLanguage) object;
            String textToShow  =
                    selectedProgramingLanguage.getName() +
                    "\n" +
                    selectedProgramingLanguage.getDescription();

            Toast.makeText(this, textToShow, Toast.LENGTH_SHORT).show();
            return;
        }

        if ( v == bt_main_3) {
            Toast.makeText(this, "Button 3 clicked", Toast.LENGTH_SHORT).show();
//            return;
        }
    }
}
