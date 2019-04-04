package com.example.tes;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etName, etPhone;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.edName);
        etPhone = (EditText) findViewById(R.id.edPhon);

        dbHandler = new MyDBHandler(this);//initilize bd object to call method
    }

    //Add a record to the database
    public void addButtonClicked(View v){

        String naStr = etName.getText().toString();
        String phStr = etPhone.getText().toString();

        dbHandler.addRecord(naStr,phStr);

        etName.setText("");
        etPhone.setText("");


    }
    //Show the content of the DB using a Toast notification
    public void printDatabaseData(View v){
        String db = dbHandler.dataBaseToString();//initilize bd object to call method
        Toast.makeText(getApplicationContext(),db,Toast.LENGTH_LONG).show();

    }
}