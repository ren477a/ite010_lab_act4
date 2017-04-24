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
    private Stack<Integer> op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        stack = new Stack<Double>();
        op = new Stack<Integer>();

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
                    if(!hasNewNum) {
                        txt.setText(Integer.toString(x));
                        hasNewNum = true;
                    } else {
                        if(txt.getText().toString().equals("0")) {
                            txt.setText(Integer.toString(x));
                        } else {
                            txt.setText(txt.getText().toString() + x);
                        }
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
    boolean hasNewNum = false;

    @Override
    public void onClick(View v) {
            if(v.equals(btnAdd)) {
                if(stack.empty()) {
                    stack.push(Double.parseDouble(txt.getText().toString()));
                    op.push(ADD);
                    hasNewNum = false;
                } else {
                    if(op.peek()!=ADD) {
                        op.pop();
                        op.push(ADD);
                    } else {
                        if(hasNewNum) {
                            Double d1 = stack.pop();
                            Double d2 = Double.parseDouble(txt.getText().toString());
                            txt.setText(Double.toString(d1+d2));
                            op.clear();
                            stack.push(Double.parseDouble(txt.getText().toString()));
                            op.push(ADD);
                            hasNewNum = false;
                        }
                    }
                }
            } else if(v.equals(btnSubtract)) {
                if(stack.empty()) {
                    stack.push(Double.parseDouble(txt.getText().toString()));
                    op.push(SUBTRACT);
                    hasNewNum = false;
                } else {
                    if(op.peek()!=SUBTRACT) {
                        op.pop();
                        op.push(SUBTRACT);
                    } else {
                        if(hasNewNum) {
                            Double d1 = stack.pop();
                            Double d2 = Double.parseDouble(txt.getText().toString());
                            txt.setText(Double.toString(d1-d2));
                            op.clear();
                            stack.push(Double.parseDouble(txt.getText().toString()));
                            op.push(SUBTRACT);
                            hasNewNum = false;
                        }
                    }
                }
            } else if(v.equals(btnMultiply)) {
                if(stack.empty()) {
                    stack.push(Double.parseDouble(txt.getText().toString()));
                    op.push(MULTIPLY);
                    hasNewNum = false;
                } else {
                    if(op.peek()!=MULTIPLY) {
                        op.pop();
                        op.push(MULTIPLY);
                    } else {
                        if(hasNewNum) {
                            Double d1 = stack.pop();
                            Double d2 = Double.parseDouble(txt.getText().toString());
                            txt.setText(Double.toString(d1*d2));
                            op.clear();
                            stack.push(Double.parseDouble(txt.getText().toString()));
                            op.push(MULTIPLY);
                            hasNewNum = false;
                        }
                    }
                }
            } else if(v.equals(btnDivide)) {
                if(stack.empty()) {
                    stack.push(Double.parseDouble(txt.getText().toString()));
                    op.push(DIVIDE);
                    hasNewNum = false;
                } else {
                    if(op.peek()!=DIVIDE) {
                        op.pop();
                        op.push(DIVIDE);
                    } else {
                        if(hasNewNum) {
                            Double d1 = stack.pop();
                            Double d2 = Double.parseDouble(txt.getText().toString());
                            txt.setText(Double.toString(d1/d2));
                            op.clear();
                            stack.push(Double.parseDouble(txt.getText().toString()));
                            op.push(DIVIDE);
                            hasNewNum = false;
                        }
                    }
                }
            } else if(v.equals(btnEquals)) {
                if(hasNewNum && !op.empty()) {
                    Double d1 = stack.pop();
                    Double d2 = Double.parseDouble(txt.getText().toString());
                    int opr = op.pop();
                    if(opr == ADD)
                        txt.setText(Double.toString(d1+d2));
                    else if(opr == SUBTRACT)
                        txt.setText(Double.toString(d1-d2));
                    else if(opr == MULTIPLY)
                        txt.setText(Double.toString(d1*d2));
                    else if(opr == DIVIDE)
                        txt.setText(Double.toString(d1/d2));
                    stack.clear();
                    op.clear();
                    hasNewNum = false;
                }
            } else if(v.equals(btnPeriod)) {



                display = txt.getText().toString();
                if(!display.contains(".")) {
                    if(!hasNewNum) {
                        txt.setText(".");
                        hasNewNum = true;
                    } else {
                        if(txt.getText().toString().equals("0")) {
                            txt.setText(".");
                        } else {
                            txt.setText(txt.getText().toString() + ".");
                        }
                    }
                }
            } else if(v.equals(btnClear)) {
                clear();
                op.clear();
                stack.clear();
            }


    }


    private void clear() {
        display = "0";
        txt.setText(display);
    }
}
