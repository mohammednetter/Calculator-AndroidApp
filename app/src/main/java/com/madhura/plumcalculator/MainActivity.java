package com.madhura.plumcalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    TextView mainDisp, finalAnsDisp;
    Button num1, num2, num3, num4, num5, num6, num7, num8, num9, num0, numAC, numPlus, numMinus, numEqual, numMul, numDiv, numPerc, numPM, numDec;
    float number1, number2, number3, finalAns;
    boolean isNumber1Taken, isAdd, isSub, isMul, isDiv, isMinus, isActive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainDisp = (TextView) findViewById(R.id.resultTV);

        num1 = (Button) findViewById(R.id.num1);
        num2 = (Button) findViewById(R.id.num2);
        num3 = (Button) findViewById(R.id.num3);
        num4 = (Button) findViewById(R.id.num4);
        num5 = (Button) findViewById(R.id.num5);
        num6 = (Button) findViewById(R.id.num6);
        num7 = (Button) findViewById(R.id.num7);
        num8 = (Button) findViewById(R.id.num8);
        num9 = (Button) findViewById(R.id.num9);
        num0 = (Button) findViewById(R.id.num0);
        numAC = (Button) findViewById(R.id.numAC);
        numPlus = (Button) findViewById(R.id.numPlus);
        numMinus = (Button) findViewById(R.id.numminus);
        numEqual = (Button) findViewById(R.id.numEqual);
        numMul = (Button) findViewById(R.id.numMul);
        numDiv = (Button) findViewById(R.id.numDiv);
        numPM = (Button) findViewById(R.id.numPM);
        numPerc = (Button) findViewById(R.id.numPerc);
        numDec = (Button) findViewById(R.id.numDec);

        isAdd = false;
        isDiv = false;
        isMul = false;
        isSub = false;
        isMinus = false;
        isActive = false;

        isNumber1Taken = false;
        number1 = 0;
        number2 = 0;
        finalAns = 0;

        //INITIALIZE
        clearText();

        //SET ON CLICK LISTENER
        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumbers(buttonPressed.NUMBER_0);
            }
        });
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumbers(buttonPressed.NUMBER_1);
            }
        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumbers(buttonPressed.NUMBER_2);
            }
        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumbers(buttonPressed.NUMBER_3);
            }
        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumbers(buttonPressed.NUMBER_4);
            }
        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumbers(buttonPressed.NUMBER_4);
            }
        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumbers(buttonPressed.NUMBER_5);
            }
        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumbers(buttonPressed.NUMBER_6);
            }
        });
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumbers(buttonPressed.NUMBER_7);
            }
        });
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumbers(buttonPressed.NUMBER_8);
            }
        });
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumbers(buttonPressed.NUMBER_9);
            }
        });
        numDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumbers(buttonPressed.DEC);
            }
        });
        numPM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumbers(buttonPressed.PM);
            }
        });

        numAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearText();
            }
        });
        numPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPressed();
            }
        });
        numMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subPressed();
            }
        });
        numEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eqlPressed();
            }
        });
        numMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mulPressed();
            }
        });
        numDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                divPressed();
            }
        });
    }

    public static enum buttonPressed {
        NUMBER_1, NUMBER_2, NUMBER_3, NUMBER_4, NUMBER_5, NUMBER_6, NUMBER_7, NUMBER_8, NUMBER_9, NUMBER_0, AC, PLUS, MINUS, EQUAL, MUL, DIV, PM, PERC, DEC;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void displayNumbers(buttonPressed pressed) {
        String str = mainDisp.getText().toString();
        if (Float.valueOf(str) == finalAns && !str.equals("0.")) {
            mainDisp.setText("");
            str = mainDisp.getText().toString();
        }
        isActive = true;
        switch (pressed) {
            case NUMBER_0:
                if (str.equals("0"))
                    str = "0";
                else
                    str = str + 0;
                break;
            case NUMBER_1:
                if (!str.equals("0"))
                    str = str + 1;
                else
                    str = "1";
                break;
            case NUMBER_2:
                if (!str.equals("0"))
                    str = str + 2;
                else
                    str = "2";
                break;
            case NUMBER_3:
                if (!str.equals("0"))
                    str = str + 3;
                else
                    str = "3";
                break;
            case NUMBER_4:
                if (!str.equals("0"))
                    str = str + 4;
                else
                    str = "4";
                break;
            case NUMBER_5:
                if (!str.equals("0"))
                    str = str + 5;
                else
                    str = "5";
                break;
            case NUMBER_6:
                if (!str.equals("0"))
                    str = str + 6;
                else
                    str = "6";
                break;
            case NUMBER_7:
                if (!str.equals("0"))
                    str = str + 7;
                else
                    str = "7";
                break;
            case NUMBER_8:
                if (!str.equals("0"))
                    str = str + 8;
                else
                    str = "8";
                break;
            case NUMBER_9:
                if (!str.equals("0"))
                    str = str + 9;
                else
                    str = "9";
                break;
            case PM:
                if (!str.contains("-")) {
                    str = "-" + str;
                    isMinus = true;
                    break;
                } else {
                    str.replace("1", "");
                    isMinus = false;
                    break;
                }
            case DEC:
                if (str.equals(""))
                    str = str + "0.";
                else if (!str.contains("."))
                    str = str + ".";
                break;
        }
        mainDisp.setText(str);
    }

    public void deleteNumber() {
        number1 = 0;
        finalAns = 0;
        isAdd = false;
        isMul = false;
        isDiv = false;
        isSub = false;
        isNumber1Taken = false;
    }

    public void clearText() {
        deleteNumber();
        mainDisp.setText("0");
    }

    public void addPressed() {
        if (isActive) {
            if (mainDisp.getText().toString().equals("0")) {
                isAdd = true;
                isActive = false;
            } else {
                isAdd = false;
                number1 = Float.parseFloat(mainDisp.getText().toString());
                finalAns = finalAns + number1;
                dispNumber();
                isNumber1Taken = true;
                isActive = false;
            }
            finalAnsDisp.setText(String.valueOf(finalAns));
        }
    }

    public void subPressed() {
        if (isActive) {
            if (mainDisp.getText().toString().equals("0")) {
                isSub = true;
                isActive = false;
            } else {
                isSub = true;
                number1 = Float.parseFloat(mainDisp.getText().toString());
                if (isNumber1Taken == false) {
                    finalAns = number1;
                    isNumber1Taken = true;
                } else
                    finalAns = finalAns - number1;
                dispNumber();
                isActive = false;
            }
        }
        finalAnsDisp.setText(String.valueOf(finalAns));
    }

    public void eqlPressed() {

        if (isNumber1Taken && !(mainDisp.getText().toString().equals(""))) {
            number1 = Float.parseFloat(mainDisp.getText().toString());
            if (isAdd) {
                finalAns += number1;
                dispNumber();
            } else if (isSub) {
                finalAns -= number1;
                dispNumber();
            } else if (isMul) {
                finalAns *= number1;
                dispNumber();
            } else if (isDiv) {
                try {
                    if (number1 != 0) {
                        finalAns = finalAns / number1;
                        dispNumber();
                    } else {
                        mainDisp.setText("Error");
                    }
                } catch (IllegalArgumentException e) {
                    mainDisp.setText("Error");
                }
            }
            number1 = 0;
        }
    }

    public void mulPressed() {
        if (isActive) {
            {
                isMul = true;
                number1 = Float.parseFloat(mainDisp.getText().toString());
                if (isNumber1Taken == false) {
                    finalAns = number1;
                    isNumber1Taken = true;
                } else
                    finalAns = finalAns * number1;
                dispNumber();
                isActive = false;
            }
        }
    }

    public void divPressed() {
        if (isActive) {
            if (mainDisp.getText().toString().equals("0")) {
                isDiv = true;
                isActive = false;
            } else {
                isDiv = true;
                number1 = Float.parseFloat(mainDisp.getText().toString());
                if (isNumber1Taken == false) {
                    finalAns = number1;
                    isNumber1Taken = true;
                } else {
                    try {
                        if (number1 != 0)
                            finalAns = finalAns / number1;
                        else
                            mainDisp.setText("Error");
                    } catch (IllegalArgumentException e) {
                        mainDisp.setText("Error");
                    }
                }
                dispNumber();
                isActive = false;
            }
        }
    }

    public void dispNumber() {
        if (finalAns == (int) finalAns) {
            mainDisp.setText(String.valueOf((int) finalAns));
        } else {
            mainDisp.setText(String.valueOf(finalAns));
        }
    }
}
