import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText display;
    private String currentInput = "";
    private String operator = "";
    private double result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.display);
    }

    public void onButtonClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getTag().toString();

        if (buttonText.equals("C")) {
            clearDisplay();
        } else if (buttonText.equals("=")) {
            calculateResult();
        } else {
            currentInput += buttonText;
            display.setText(currentInput);
        }
    }

    public void clearDisplay() {
        currentInput = "";
        operator = "";
        display.setText("0");
        result = 0;
    }

    public void calculateResult() {
        if (!currentInput.isEmpty() && !operator.isEmpty()) {
            double secondValue = Double.parseDouble(currentInput);
            switch (operator) {
                case "+":
                    result += secondValue;
                    break;
                case "-":
                    result -= secondValue;
                    break;
                case "*":
                    result *= secondValue;
                    break;
                case "/":
                    if (secondValue != 0) {
                        result /= secondValue;
                    } else {
                        display.setText("Error");
                        return;
                    }
                    break;
            }
            display.setText(String.valueOf(result));
            currentInput = "";
            operator = "";
        }
    }
}
