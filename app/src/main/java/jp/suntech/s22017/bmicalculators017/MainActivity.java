package jp.suntech.s22017.bmicalculators017;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.icu.util.Output;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ボタンオブジェクトの用意
        Button btClick = findViewById(R.id.bt_button1);
        btClick.setOnClickListener(new ButtonClickListener());

        Button btClick3 = findViewById(R.id.bt_button2);
        btClick3.setOnClickListener(new ButtonClickListener2());
    }



    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            EditText input = findViewById(R.id.et_age1);
            EditText input2 = findViewById(R.id.et_height1);
            EditText input3 = findViewById(R.id.et_weight1);
            TextView output = findViewById(R.id.et_result1);
            TextView output2 = findViewById(R.id.et_result2);
            TextView output3 = findViewById(R.id.et_result3);
            TextView output4 = findViewById(R.id.et_result4);


            String inputStr = input.getText().toString();
            String inputStr2 = input2.getText().toString();
            String inputStr3 = input3.getText().toString();

            float fl = Float.parseFloat(inputStr);
            float fl1 = Float.parseFloat(inputStr2);
            float fl2 = Float.parseFloat(inputStr3);

            if(fl < 16) {
                Dialog.OrderConfirmDialogFragment dialogFragment = new Dialog.OrderConfirmDialogFragment();
                dialogFragment.show(getSupportFragmentManager(), "OrderConfirmDialogFragment");
            }

            float BMI = fl2/((fl1/100)*(fl1/100));
            String str = "なし";
            Float weight = ((fl1/100)*(fl1/100)) * 22;
            String str2 = String.format("%.1f",weight);

            if(BMI > 40){
                str = "肥満（4度）";
            } else if (BMI >= 35) {
                str = "肥満（3度）";
            } else if (BMI >= 30) {
                str = "肥満（2度）";
            } else if (BMI >= 25) {
                str = "肥満（1度）";
            } else if (BMI >= 18.5) {
                str = "普通体重";
            }else {
                str = "低体重";
            }

            output.setText("  あなたの肥満度は");
            output2.setText("     " + str);
            output3.setText("あなたの適正体重は");
            output4.setText("        " + str2 + "         kg");
        }
    }

    private class ButtonClickListener2 implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            EditText input = findViewById(R.id.et_age1);
            EditText input2 = findViewById(R.id.et_height1);
            EditText input3 = findViewById(R.id.et_weight1);

            input.setText("");
            input2.setText("");
            input3.setText("");


        }
    }
}