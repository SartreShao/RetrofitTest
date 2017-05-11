package shaolizhi.retrofittest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import shaolizhi.retrofittest.api.GitApi;
import shaolizhi.retrofittest.model.GitModel;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;
    EditText editText;
    String API = "https://api.github.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.text_view);
        editText = (EditText) findViewById(R.id.edit_text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editText.getText().toString();
                RestAdapter restAdapter = new RestAdapter
                        .Builder()
                        .setEndpoint(API)
                        .build();
                GitApi gitApi = restAdapter.create(GitApi.class);
                gitApi.getFeed(username, new Callback<GitModel>() {
                    @Override
                    public void success(GitModel gitModel, Response response) {
                        String string = "GitHub Name:" + gitModel.getName();
                        textView.setText(string);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        String string = error.getMessage();
                        textView.setText(string);
                    }
                });
            }
        });

    }
}
