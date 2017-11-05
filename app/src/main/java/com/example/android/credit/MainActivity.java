package com.example.android.credit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    public void verifyCredit(View view){

        EditText editTextCredit = (EditText) findViewById(R.id.editText_credit_view);
        String  str_cc_number  =       editTextCredit.getText().toString();
        char firstNumber = str_cc_number.charAt(0);
        char secondNumber = str_cc_number.charAt(1);
        String firstTwoNumber = String.valueOf(firstNumber);
        firstTwoNumber = firstTwoNumber + String.valueOf(secondNumber);
        int intfirstTwoNumber = (Integer.parseInt(firstTwoNumber));

        Long number =  Long.parseLong(str_cc_number);
        Long number2 = Long.parseLong(str_cc_number);
        int sumOfProducts = 0;
        int sums = 0;
        while(number != 0)
        {
            Long printableNumber;

            number = number/10;
            printableNumber = number%10;
            number = number/10;
            Long product = printableNumber*2;
            if(product%10 == product)
            {
                sumOfProducts+=product;
            }
            else
            {
                Long temp = product/10;
                product = product%10;
                sumOfProducts +=product + temp;
            }
        }
        while(number2 != 0)
        {
            Long printableNumber;
            printableNumber = number2%10;
            number2 = number2/10;
            number2 = number2/10;
            sumOfProducts += printableNumber;
        }


        if(sumOfProducts%10 == 0) {

            TextView set_show_valid_card = (TextView) findViewById(R.id.show_valid_textview);
            set_show_valid_card.setText("VALID Card");

            if (str_cc_number.length() == 15 & (intfirstTwoNumber == 34 || intfirstTwoNumber == 37)) {
                TextView set_show_card_name = (TextView) findViewById(R.id.show_card_textview);
                set_show_card_name.setText("AMEX");
            } else if (str_cc_number.length() == 16 & (intfirstTwoNumber == 51 || intfirstTwoNumber == 52 || intfirstTwoNumber == 53 || intfirstTwoNumber == 54 || intfirstTwoNumber == 55)) {
                TextView set_show_card_name = (TextView) findViewById(R.id.show_card_textview);
                set_show_card_name.setText("Master Card");

            } else if ((str_cc_number.length() == 13 || str_cc_number.length() == 16) & Integer.parseInt(String.valueOf(firstNumber)) == 4) {

                TextView set_show_card_name = (TextView) findViewById(R.id.show_card_textview);
                set_show_card_name.setText("VISA");

            }


        }
        else{

            TextView set_show_valid_card = (TextView)findViewById(R.id.show_valid_textview);
            set_show_valid_card.setText("IN VALID Card");

        }


          TextView  set_checksum = (TextView)findViewById(R.id.show_checksum_textview);
        set_checksum.setText(" CHECKSUM  " + sumOfProducts);





    }

    public void resetAll(){
        TextView set_show_valid_card2 = (TextView) findViewById(R.id.show_valid_textview);
        set_show_valid_card2.setText("CHECK RESULT: ");

        TextView set_show_card_name2 = (TextView) findViewById(R.id.show_card_textview);
        set_show_card_name2.setText("CARD: ");

        TextView  set_checksum2 = (TextView)findViewById(R.id.show_checksum_textview);
        set_checksum2.setText(" CHECKSUM:  ");

    }

}
