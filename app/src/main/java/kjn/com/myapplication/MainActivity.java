package kjn.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ScollerView mScollerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mScollerView = (ScollerView) findViewById(R.id.ff);
    }

    public void btn(View view) {
        switch (view.getId()){
            case R.id.zero:
                mScollerView.setMode(0);
                break;
            case R.id.one:
                mScollerView.setMode(1);
                break;
            case R.id.two:
                mScollerView.setMode(2);
                break;
            case R.id.three:
                mScollerView.setMode(3);
                break;
            case R.id.four:
                mScollerView.setMode(4);
                break;
            default:
                break;
        }
    }
}
