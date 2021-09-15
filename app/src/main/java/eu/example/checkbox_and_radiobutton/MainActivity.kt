package eu.example.checkbox_and_radiobutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import eu.example.checkbox_and_radiobutton.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

// Creating class MainActivity which inherent from AppCompatActivity
// So it can use methods from AppCompatActivity class

class MainActivity : AppCompatActivity() {

    // setup the var binding ( object) without assigning it any value yet
    // private = we can only access it inside this class, and classes than inherent from this class
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main) -not used anymore

        // Assigning the binding object a value as the main_activity.xml layout
        // kinda converting the xml file to a kotlin object I think ??
        binding = ActivityMainBinding.inflate(layoutInflater)

        // show the view on the screen
        val view = binding.root
        setContentView(view)

        // Find out wich checkbox and radio buttons is selected, and put them in a text string
        btnOrder.setOnClickListener {
            // Radiobuttons
            // check which radiobutton is currently checked in the RadioGroup rgMeat
            val checkedMeatRadioButtonId = rgMeat.checkedRadioButtonId
            // set variable meat to the currently checked radiobutton.
            val meat = findViewById<RadioButton>(checkedMeatRadioButtonId)

            // Checkboxes
            // find out which checkboxes are checked
            val cheese = cbCheese.isChecked
            val onions = cbOnions.isChecked
            val salad = cbSalad.isChecked
            // insert the string of those boxes that where checked into the order string
            val orderString = "You ordered a burger with:\n" +
                    "${meat.text}" +
                    (if(cheese) "\nCheese" else "") +
                    (if(onions) "\nOnions" else "") +
                    (if(salad) "\nSalad" else "")
            tvOrder.text = orderString

        }
    }
}