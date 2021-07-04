package randyramadhan.ayoboga.ayobogacampus;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    // Reference to the button and other controller on the layout
    Button btn_add, btn_viewAll;
    EditText et_student, et_Date, et_address;
    RadioGroup rg_gender;
    RadioButton rb_gender;
    ListView lv_studentList;
    DatePickerDialog.OnDateSetListener dateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add = findViewById(R.id.btn_add);
        btn_viewAll = findViewById(R.id.btn_view_all);
        et_student = findViewById(R.id.et_student_name);
        et_Date = findViewById(R.id.et_date);
        et_address = findViewById(R.id.et_address);
        rg_gender = findViewById(R.id.rg_gender);
        lv_studentList = findViewById(R.id.lv_studentList);


        et_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity.this,R.style.Theme_AppCompat_Light_Dialog, dateSetListener , year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.BLUE));
                dialog.show();
            }
        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + dayOfMonth + "/" + year);

                String date = month + "/" + dayOfMonth + "/" + year;
                et_Date.setText(date);
            }
        };

        // Listener
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rb_gender = findViewById(rg_gender.getCheckedRadioButtonId());
                StudentModel studentModel = null;

                try {
                    studentModel = new StudentModel(
                            -1,
                            et_student.getText().toString(),
                            rb_gender.getText().toString(),
                            et_Date.getText().toString(),
                            et_address.getText().toString()
                    );
                    Toast.makeText(MainActivity.this,"Sukses Menyimpan Data " + studentModel.toString() , Toast.LENGTH_LONG ).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this,"Gagal Menyimpan Data", Toast.LENGTH_LONG ).show();
                }

                DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);
                boolean success = dataBaseHelper.addOne(studentModel);

                Toast.makeText(MainActivity.this, success ? "sukses!" : "Gagal", Toast.LENGTH_LONG).show();
            }
        });

        btn_viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}