package cs33fc1.ite010.tipqc.com.labactivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Stack;

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

    private Stack<Double> stack;
    private int op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        stack = new Stack<Double>();
        op = NONE;

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
        clear();

        for (int i = 0; i < btn.length; i++) {
            final int x = i;
            btn[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(txt.getText().toString().equals("0")) {
                        txt.setText(Integer.toString(x));
                    } else {
                        txt.setText(txt.getText().toString() + x);
                    }
                }
            });
        }

    }

    final int ADD = 9827;
    final int SUBTRACT = 522234;
    final int MULTIPLY = 12532;
    final int DIVIDE = 54387513;
    final int NONE = 5315;

    @Override
    public void onClick(View v) {

            if(v.equals(btnAdd)) {
                if(stack.empty()) {
                    stack.push(Double.parseDouble(txt.getText().toString()));
                    op = ADD;
                    clear();
                } else {
                    Double d1 = stack.pop();
                    Double d2 = Double.parseDouble(txt.getText().toString());
                    txt.setText(Double.toString(d1+d2));
                    stack.push(Double.parseDouble(txt.getText().toString()));
                }


            } else if(v.equals(btnSubtract)) {

            } else if(v.equals(btnMultiply)) {

            } else if(v.equals(btnDivide)) {

            } else if(v.equals(btnEquals)) {
                if(!stack.empty()) {
                    double d1 = stack.pop();
                    double d2 = Double.parseDouble(txt.getText().toString());
                    if(op == ADD)
                        txt.setText(Double.toString(d1+d2));
                    op = NONE;
                }
            } else if(v.equals(btnPeriod)) {
                System.out.println("period");
                if(!display.contains(".")) {
                    display = display + ".";
                    txt.setText(display);
                }
            } else if(v.equals(btnClear)) {
                clear();
                op = NONE;
                stack.clear();
            }


    }


    private void clear() {
        display = "0";
        txt.setText(display);
    }
}
