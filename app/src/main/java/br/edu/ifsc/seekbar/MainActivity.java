package br.edu.ifsc.seekbar;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    TextView  textView;
    NumberFormat formatacaoPercentual = NumberFormat.getPercentInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar =(SeekBar) findViewById(R.id.seekbar);
        textView = (TextView) findViewById(R.id.text);
        seekBar.setOnSeekBarChangeListener(seekBarChangeListener);

    }

    private final SeekBar.OnSeekBarChangeListener seekBarChangeListener=  new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            sincronizaTextView();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };


    public  void sincronizaTextView(){
        int valor= seekBar.getProgress();
        this.textView.setText(formatacaoPercentual.format(valor/100));
    }
}


