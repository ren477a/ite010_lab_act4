package cs33fc1.ite010.tipqc.com.labactivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    private Button[] btn;
    private Button btnAdd;
    private Button btnSubtract;
    private Button btnMultiply;
    private Button btnDivide;
    private Button btnPeriod;
    private Button btnEquals;
    private Button btnClear;

    private EditText txt;

    private String display;

    private double ans, num1, num2;
    private char op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        clear();

        btn = new Button[10];

        btn[0] = (Button) findViewById(R.id.btn0);
        btn[1] = (Button) findViewById(R.id.btn1);
        btn[2] = (Button) findViewById(R.id.btn2);
        btn[3] = (Button) findViewById(R.id.btn3);
        btn[4] = (Button) findViewById(R.id.btn4);
        btn[5] = (Button) findViewById(R.id.btn5);
        btn[6] = (Button) findViewById(R.id.btn6);
        btn[7] = (Button) findViewById(R.id.btn7);
        btn[8] = (Button) findViewById(R.id.btn8);
        btn[9] = (Button) findViewById(R.id.btn9);
        btnAdd = (Button) findViewById(R.id.btn_add);
        btnSubtract = (Button) findViewById(R.id.btn_subtract);
        btnMultiply = (Button) findViewById(R.id.btn_multiply);
        btnDivide = (Button) findViewById(R.id.btn_divide);
        btnPeriod = (Button) findViewById(R.id.btn_period);
        btnEquals = (Button) findViewById(R.id.btn_equals);
        btnClear = (Button) findViewById(R.id.btn_clear);

        btnAdd.setOnClickListener(this);
        btnSubtract.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnPeriod.setOnClickListener(this);
        btnEquals.setOnClickListener(this);
        btnClear.setOnClickListener(this);

        txt = (EditText) findViewById(R.id.editText);

        for (int i = 0; i < btn.length; i++) {
            final int x = i;
            btn[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(display.equals("0")) {
                        display = Integer.toString(x);
                    } else {
                        display = display + x;
                    }
                    txt.setText(display);
                }
            });
        }

    }

    private boolean asd = true;

    @Override
    public void onClick(View v) {
        if(v.equals(btnAdd)) {
            if(asd)
                num1 = Double.parseDouble(txt.getText().toString());
        } else if(v.equals(btnSubtract)) {
            display = display + "-";
            txt.setText(display);

        } else if(v.equals(btnMultiply)) {
            display = display + "*";
            txt.setText(display);

        } else if(v.equals(btnDivide)) {
            display = display + "/";
            txt.setText(display);
        } else if(v.equals(btnEquals)) {

        } else if(v.equals(btnPeriod)) {
            System.out.println("period");
            if(!display.contains(".")) {
                display = display + ".";
                txt.setText(display);
            }
        } else if(v.equals(btnClear)) {
            display = "";
            txt.setText(display);
        }
    }


    private void clear() {
        display = "0";
        txt.setText(display);
        num1 = 0;
        num2 = 0;
    }
}
