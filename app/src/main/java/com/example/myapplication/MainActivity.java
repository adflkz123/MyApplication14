////
////
////package com.example.myapplication;
////
////import android.app.Activity;
////import android.app.AlertDialog;
////import android.os.Bundle;
////import android.view.View;
////import android.widget.Button;
////import android.widget.CheckBox;
////import android.widget.EditText;
////import android.widget.RadioButton;
////import android.widget.RadioGroup;
////import android.widget.TimePicker;
////import java.util.HashMap;
////import java.util.Map;
////
////public class MainActivity extends Activity {
////
////    // Declare all the required variables
////    private RadioGroup radioGroupDay;
////
////    // 체크박스들의 ID 배열
////    private int[] emotionCheckboxIds = {
////            R.id.checkBox6, R.id.checkBox7, R.id.checkBox8, R.id.checkBox9, R.id.checkBox10
////    };
////
////    // TimePicker들과 EditText, Button 선언
////    private TimePicker bedtimePicker, wakeupPicker;
////    private EditText diaryEntry;
////    private Button submitButton;
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_main);
////
////        // Initialize all the required variables by finding them in the layout
////        radioGroupDay = findViewById(R.id.radioGroup1);
////        bedtimePicker = findViewById(R.id.timePicker1);
////        wakeupPicker = findViewById(R.id.timePicker2);
////        diaryEntry = findViewById(R.id.editTextText2);
////        submitButton = findViewById(R.id.button);
////
////        // 버튼 클릭 리스너 설정
////        submitButton.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                // 결과를 저장할 HashMap 생성
////                Map<String, String> results = new HashMap<>();
////
////                // Get the selected RadioButton in the RadioGroup
////                int selectedId = radioGroupDay.getCheckedRadioButtonId();
////                RadioButton selectedRadioButton = findViewById(selectedId);
////                results.put("Day", (String) selectedRadioButton.getTag());
////
////                // Get the checked CheckBoxes in the emotion section
////                String emotions = "";
////                for (int id : emotionCheckboxIds) {
////                    CheckBox checkBox = findViewById(id);
////                    if (checkBox.isChecked()) {
////                        emotions += checkBox.getTag() + ", ";
////                    }
////                }
////                // 마지막 쉼표 제거
////                if (!emotions.isEmpty()) {
////                    emotions = emotions.substring(0, emotions.length()-2);
////                }
////                results.put("Emotions", emotions);
////
////                // Get the selected time in the TimePickers
////                String bedtime = bedtimePicker.getHour() + ":" + String.format("%02d", bedtimePicker.getMinute());
////                String wakeupTime = wakeupPicker.getHour() + ":" + String.format("%02d", wakeupPicker.getMinute());
////                results.put("Bedtime", bedtime);
////                results.put("Wakeup time", wakeupTime);
////
////                // Get the diary entry
////                results.put("Diary entry", diaryEntry.getText().toString());
////
////                // Build the AlertDialog message
////                StringBuilder message = new StringBuilder();
////                for (Map.Entry<String, String> entry : results.entrySet()) {
////                    message.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
////                }
////
////                // Display the AlertDialog
////                new AlertDialog.Builder(MainActivity.this)
////                        .setTitle("Your Entries")
////                        .setMessage(message.toString())
////                        .setPositiveButton("OK", null)
////                        .show();
////            }
////        });
////    }
////}
//
////
////package com.example.myapplication;
////
////import android.app.Activity;
////import android.app.AlertDialog;
////import android.os.AsyncTask;
////import android.os.Bundle;
////import android.view.View;
////import android.widget.Button;
////import android.widget.CheckBox;
////import android.widget.EditText;
////import android.widget.RadioButton;
////import android.widget.RadioGroup;
////import android.widget.TimePicker;
////import android.widget.Toast;
////
////import java.io.OutputStream;
////import java.net.HttpURLConnection;
////import java.net.URL;
////import java.util.HashMap;
////import java.util.Map;
////
////public class MainActivity extends Activity {
////
////    // Declare all the required variables
////    private RadioGroup radioGroupDay;
////
////    // 체크박스들의 ID 배열
////    private int[] emotionCheckboxIds = {
////            R.id.checkBox6, R.id.checkBox7, R.id.checkBox8, R.id.checkBox9, R.id.checkBox10
////    };
////
////    // TimePicker들과 EditText, Button 선언
////    private TimePicker bedtimePicker, wakeupPicker;
////    private EditText diaryEntry;
////    private Button submitButton;
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_main);
////
////        // Initialize all the required variables by finding them in the layout
////        radioGroupDay = findViewById(R.id.radioGroup1);
////        bedtimePicker = findViewById(R.id.timePicker1);
////        wakeupPicker = findViewById(R.id.timePicker2);
////        diaryEntry = findViewById(R.id.editTextText2);
////        submitButton = findViewById(R.id.button);
////
////        // 버튼 클릭 리스너 설정
////        submitButton.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                // 결과를 저장할 HashMap 생성
////                Map<String, String> results = new HashMap<>();
////
////                // Get the selected RadioButton in the RadioGroup
////                int selectedId = radioGroupDay.getCheckedRadioButtonId();
////                RadioButton selectedRadioButton = findViewById(selectedId);
////                results.put("Day", (String) selectedRadioButton.getTag());
////
////                // Get the checked CheckBoxes in the emotion section
////                String emotions = "";
////                for (int id : emotionCheckboxIds) {
////                    CheckBox checkBox = findViewById(id);
////                    if (checkBox.isChecked()) {
////                        emotions += checkBox.getTag() + ", ";
////                    }
////                }
////                // 마지막 쉼표 제거
////                if (!emotions.isEmpty()) {
////                    emotions = emotions.substring(0, emotions.length()-2);
////                }
////                results.put("Emotions", emotions);
////
////                // Get the selected time in the TimePickers
////                String bedtime = bedtimePicker.getHour() + ":" + String.format("%02d", bedtimePicker.getMinute());
////                String wakeupTime = wakeupPicker.getHour() + ":" + String.format("%02d", wakeupPicker.getMinute());
////                results.put("Bedtime", bedtime);
////                results.put("Wakeup time", wakeupTime);
////
////                // Get the diary entry
////                results.put("Diary entry", diaryEntry.getText().toString());
////
////                // Build the AlertDialog message
////                StringBuilder message = new StringBuilder();
////                for (Map.Entry<String, String> entry : results.entrySet()) {
////                    message.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
////                }
////
////                // Display the AlertDialog
////                new AlertDialog.Builder(MainActivity.this)
////                        .setTitle("Your Entries")
////                        .setMessage(message.toString())
////                        .setPositiveButton("OK", null)
////                        .show();
////
////                // 버튼이 클릭되면 PostDataTask를 실행합니다.
////                new PostDataTask().execute();
////            }
////        });
////    }
////
////    private class PostDataTask extends AsyncTask<String, Void, Integer> {
////        @Override
////        protected Integer doInBackground(String... strings) {
////            try {
////                // AWS Lambda REST API의 URL을 설정합니다.
////                URL url = new URL("https://92w0fldt7k.execute-api.ap-northeast-2.amazonaws.com/api/hello");
////
////                // HTTP 연결을 엽니다.
////                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
////
////                // POST 방식으로 요청을 보냅니다.
////                conn.setRequestMethod("POST");
////                conn.setRequestProperty("Content-Type", "application/json");
////                conn.setDoOutput(true);
////
////                // 보낼 JSON 데이터입니다.
////                String jsonInputString = "{\"key\": \"123\"}";
////
////                try(OutputStream os = conn.getOutputStream()) {
////                    // JSON 데이터를 byte 배열로 변환한 후, OutputStream을 통해 서버로 보냅니다.
////                    byte[] input = jsonInputString.getBytes("utf-8");
////                    os.write(input, 0, input.length);
////                }
////
////                // 서버로부터 받은 응답 코드를 반환합니다.
////                return conn.getResponseCode();
////            } catch (Exception e) {
////                e.printStackTrace();
////                return null;
////            }
////        }
////
////        @Override
////        protected void onPostExecute(Integer responseCode) {
////            // 네트워크 요청이 완료된 후에 실행되는 코드입니다.
////            // 여기서는 응답 코드를 Toast 메시지로 표시합니다.
////            if (responseCode != null) {
////                String message = "Response code: " + responseCode;
////                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
////            } else {
////                Toast.makeText(MainActivity.this, "Error in network request", Toast.LENGTH_SHORT).show();
////            }
////        }
////    }
////}
//
//
////package com.example.myapplication;
////
////import android.app.Activity;
////import android.app.AlertDialog;
////import android.os.Bundle;
////import android.view.View;
////import android.widget.Button;
////import android.widget.CheckBox;
////import android.widget.EditText;
////import android.widget.RadioButton;
////import android.widget.RadioGroup;
////import android.widget.TimePicker;
////
////import org.json.JSONException;
////import org.json.JSONObject;
////
////import java.util.Iterator;
////
////public class MainActivity extends Activity {
////
////    // Declare all the required variables
////    private RadioGroup radioGroupDay;
////
////    // 체크박스들의 ID 배열
////    private int[] emotionCheckboxIds = {
////            R.id.checkBox6, R.id.checkBox7, R.id.checkBox8, R.id.checkBox9, R.id.checkBox10
////    };
////
////    // TimePicker들과 EditText, Button 선언
////    private TimePicker bedtimePicker, wakeupPicker;
////    private EditText diaryEntry;
////    private Button submitButton;
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_main);
////
////        // Initialize all the required variables by finding them in the layout
////        radioGroupDay = findViewById(R.id.radioGroup1);
////        bedtimePicker = findViewById(R.id.timePicker1);
////        wakeupPicker = findViewById(R.id.timePicker2);
////        diaryEntry = findViewById(R.id.editTextText2);
////        submitButton = findViewById(R.id.button);
////
////        // 버튼 클릭 리스너 설정
////        submitButton.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                // 결과를 저장할 JSONObject 생성
////                JSONObject results = new JSONObject();
////
////                try {
////                    // Get the selected RadioButton in the RadioGroup
////                    int selectedId = radioGroupDay.getCheckedRadioButtonId();
////                    RadioButton selectedRadioButton = findViewById(selectedId);
////                    results.put("Day", selectedRadioButton.getTag());
////
////                    // Get the checked CheckBoxes in the emotion section
////                    String emotions = "";
////                    for (int id : emotionCheckboxIds) {
////                        CheckBox checkBox = findViewById(id);
////                        if (checkBox.isChecked()) {
////                            emotions += checkBox.getTag() + ", ";
////                        }
////                    }
////                    // 마지막 쉼표 제거
////                    if (!emotions.isEmpty()) {
////                        emotions = emotions.substring(0, emotions.length()-2);
////                    }
////                    results.put("Emotions", emotions);
////
////                    // Get the selected time in the TimePickers
////                    String bedtime = bedtimePicker.getHour() + ":" + String.format("%02d", bedtimePicker.getMinute());
////                    String wakeupTime = wakeupPicker.getHour() + ":" + String.format("%02d", wakeupPicker.getMinute());
////                    results.put("Bedtime", bedtime);
////                    results.put("Wakeup time", wakeupTime);
////
////                    // Get the diary entry
////                    results.put("Diary entry", diaryEntry.getText().toString());
////
////                    // Build the AlertDialog message
////                    StringBuilder message = new StringBuilder();
////                    Iterator<String> keys = results.keys();
////                    while (keys.hasNext()) {
////                        String key = keys.next();
////                        message.append(key).append(": ").append(results.getString(key)).append("\n");
////                    }
////
////                    // Display the AlertDialog
////                    new AlertDialog.Builder(MainActivity.this)
////                            .setTitle("Your Entries")
////                            .setMessage(message.toString())
////                            .setPositiveButton("OK", null)
////                            .show();
////                } catch (JSONException e) {
////                    e.printStackTrace();
////                }
////            }
////        });
////    }
////}
//
//package com.example.myapplication;
//
//import android.app.Activity;
//import android.app.AlertDialog;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.CheckBox;
//import android.widget.EditText;
//import android.widget.RadioButton;
//import android.widget.RadioGroup;
//import android.widget.TimePicker;
//import android.widget.Toast;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.io.OutputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.Iterator;
//
//public class MainActivity extends Activity {
//
//    // Declare all the required variables
//    private RadioGroup radioGroupDay;
//
//    // 체크박스들의 ID 배열
//    private int[] emotionCheckboxIds = {
//            R.id.checkBox6, R.id.checkBox7, R.id.checkBox8, R.id.checkBox9, R.id.checkBox10
//    };
//
//    private int[] friendCheckboxIds = {
//            R.id.checkBox11, R.id.checkBox12, R.id.checkBox13, R.id.checkBox14, R.id.checkBox145, R.id.checkBox149, R.id.checkBox15, R.id.checkBox16, R.id.checkBox17, R.id.checkBox18
//    };
//
//    // TimePicker들과 EditText, Button 선언
//    private TimePicker bedtimePicker, wakeupPicker;
//    private EditText diaryEntry;
//    private Button submitButton;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // Initialize all the required variables by finding them in the layout
//        radioGroupDay = findViewById(R.id.radioGroup1);
//        bedtimePicker = findViewById(R.id.timePicker1);
//        wakeupPicker = findViewById(R.id.timePicker2);
//        diaryEntry = findViewById(R.id.editTextText2);
//        submitButton = findViewById(R.id.button);
//
//        // 버튼 클릭 리스너 설정
//        submitButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // 결과를 저장할 JSONObject 생성
//                JSONObject results = new JSONObject();
//
//                try {
//                    // Get the selected RadioButton in the RadioGroup
//                    int selectedId = radioGroupDay.getCheckedRadioButtonId();
//                    RadioButton selectedRadioButton = findViewById(selectedId);
//                    results.put("mood", selectedRadioButton.getTag());
//
//                    // Get the checked CheckBoxes in the emotion section
//                    String emotions = "";
//                    for (int id : emotionCheckboxIds) {
//                        CheckBox checkBox = findViewById(id);
//                        if (checkBox.isChecked()) {
//                            emotions += checkBox.getTag() + ", ";
//                        }
//                    }
//                    // 마지막 쉼표 제거
//                    if (!emotions.isEmpty()) {
//                        emotions = emotions.substring(0, emotions.length()-2);
//                    }
//                    results.put("emotion", emotions);
//                            //
//                    String friend = "";
//                    for (int id : friendCheckboxIds) {
//                        CheckBox checkBox = findViewById(id);
//                        if (checkBox.isChecked()) {
//                            friend += checkBox.getTag() + ", ";
//                        }
//                    }
//                    // 마지막 쉼표 제거
//                    if (!friend.isEmpty()) {
//                        friend = friend.substring(0, friend.length()-2);
//                    }
//                    results.put("friend", friend);
//
//                    // Get the selected time in the TimePickers
//                    String bedtime = bedtimePicker.getHour() + ":" + String.format("%02d", bedtimePicker.getMinute());
//                    String wakeupTime = wakeupPicker.getHour() + ":" + String.format("%02d", wakeupPicker.getMinute());
//                    results.put("sleep", bedtime);
//                    results.put("wake", wakeupTime);
//
//                    // Get the diary entry
//                    results.put("diary", diaryEntry.getText().toString());
//
//                    // Build the AlertDialog message
//                    StringBuilder message = new StringBuilder();
//                    Iterator<String> keys = results.keys();
//                    while (keys.hasNext()) {
//                        String key = keys.next();
//                        message.append(key).append(": ").append(results.getString(key)).append("\n");
//                    }
//
//                    // Display the AlertDialog
//                    new AlertDialog.Builder(MainActivity.this)
//                            .setTitle("Your Entries")
//                            .setMessage(message.toString())
//                            .setPositiveButton("OK", null)
//                            .show();
//
//                    // 버튼이 클릭되면 PostDataTask를 실행합니다.
//                    new PostDataTask().execute(results.toString());
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
//
//    private class PostDataTask extends AsyncTask<String, Void, Integer> {
//        @Override
//        protected Integer doInBackground(String... strings) {
//            try {
//                // AWS Lambda REST API의 URL을 설정합니다.
//                URL url = new URL("https://92w0fldt7k.execute-api.ap-northeast-2.amazonaws.com/api/hello");
//
//                // HTTP 연결을 엽니다.
//                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//
//                // POST 방식으로 요청을 보냅니다.
//                conn.setRequestMethod("POST");
//                conn.setRequestProperty("Content-Type", "application/json");
//                conn.setDoOutput(true);
//
//
//                // 첫 번째 인자를 JSON 데이터로 사용합니다.
//                String jsonInputString = strings[0];
//
//                try(OutputStream os = conn.getOutputStream()) {
//                    // JSON 데이터를 byte 배열로 변환한 후, OutputStream을 통해 서버로 보냅니다.
//                    byte[] input = jsonInputString.getBytes("utf-8");
//                    os.write(input, 0, input.length);
//                }
//
//                // 서버로부터 받은 응답 코드를 반환합니다.
//                return conn.getResponseCode();
//            } catch (Exception e) {
//                e.printStackTrace();
//                return null;
//            }
//        }
//
//        @Override
//        protected void onPostExecute(Integer responseCode) {
//            // 네트워크 요청이 완료된 후에 실행되는 코드입니다.
//            // 여기서는 응답 코드를 Toast 메시지로 표시합니다.
//            if (responseCode != null) {
//                String message = "Response code: " + responseCode;
//                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(MainActivity.this, "Error in network request", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
//}

package com.example.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

public class MainActivity extends Activity {

    // Declare all the required variables
    private RadioGroup radioGroupDay;

    // 체크박스들의 ID 배열
    private int[] emotionCheckboxIds = {
            R.id.checkBox6, R.id.checkBox7, R.id.checkBox8, R.id.checkBox9, R.id.checkBox10
    };

    private int[] friendCheckboxIds = {
            R.id.checkBox11, R.id.checkBox12, R.id.checkBox13, R.id.checkBox14, R.id.checkBox145, R.id.checkBox149, R.id.checkBox15, R.id.checkBox16, R.id.checkBox17, R.id.checkBox18
    };

    // TimePicker들과 EditText, Button 선언
    private TimePicker bedtimePicker, wakeupPicker;
    private EditText diaryEntry;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize all the required variables by finding them in the layout
        radioGroupDay = findViewById(R.id.radioGroup1);
        bedtimePicker = findViewById(R.id.timePicker1);
        wakeupPicker = findViewById(R.id.timePicker2);
        diaryEntry = findViewById(R.id.editTextText2);
        submitButton = findViewById(R.id.button);

        // 버튼 클릭 리스너 설정
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String errorMessage = "";

                if (radioGroupDay.getCheckedRadioButtonId() == -1) {
                    errorMessage += "'어떤 하루였나요?' 항목을 선택해주세요.\n";
                }

                boolean isEmotionChecked = false;
                for (int id : emotionCheckboxIds) {
                    CheckBox checkBox = findViewById(id);
                    if (checkBox.isChecked()) {
                        isEmotionChecked = true;
                        break;
                    }
                }
                if (!isEmotionChecked) errorMessage += "'감정' 항목을 선택해주세요.\n";

                boolean isFriendChecked = false;
                for (int id : friendCheckboxIds) {
                    CheckBox checkBox = findViewById(id);
                    if (checkBox.isChecked()) {
                        isFriendChecked = true;
                        break;
                    }
                }
                if (!isFriendChecked) errorMessage += "'사람' 항목을 선택해주세요.\n";

                if (diaryEntry.getText().toString().trim().isEmpty()) {
                    errorMessage += "'한줄일기' 항목을 작성해주세요.\n";
                }

                if (errorMessage.isEmpty()) {
                    // 결과를 저장할 JSONObject 생성
                    JSONObject results = new JSONObject();

                    try {
                        // Get the selected RadioButton in the RadioGroup
                        int selectedId = radioGroupDay.getCheckedRadioButtonId();
                        RadioButton selectedRadioButton = findViewById(selectedId);
                        results.put("mood", selectedRadioButton.getTag());

                        // Get the checked CheckBoxes in the emotion section
                        String emotions = "";
                        for (int id : emotionCheckboxIds) {
                            CheckBox checkBox = findViewById(id);
                            if (checkBox.isChecked()) {
                                emotions += checkBox.getTag() + ", ";
                            }
                        }
                        // 마지막 쉼표 제거
                        if (!emotions.isEmpty()) {
                            emotions = emotions.substring(0, emotions.length()-2);
                        }
                        results.put("emotion", emotions);

                        String friend = "";
                        for (int id : friendCheckboxIds) {
                            CheckBox checkBox = findViewById(id);
                            if (checkBox.isChecked()) {
                                friend += checkBox.getTag() + ", ";
                            }
                        }
                        // 마지막 쉼표 제거
                        if (!friend.isEmpty()) {
                            friend = friend.substring(0, friend.length()-2);
                        }
                        results.put("friend", friend);

                        // Get the selected time in the TimePickers
                        String bedtime = bedtimePicker.getHour() + ":" + String.format("%02d", bedtimePicker.getMinute());
                        String wakeupTime = wakeupPicker.getHour() + ":" + String.format("%02d", wakeupPicker.getMinute());
                        results.put("sleep", bedtime);
                        results.put("wake", wakeupTime);

                        // Get the diary entry
                        results.put("diary", diaryEntry.getText().toString());

                        // Build the AlertDialog message
                        StringBuilder message = new StringBuilder();
                        Iterator<String> keys = results.keys();
                        while (keys.hasNext()) {
                            String key = keys.next();
                            message.append(key).append(": ").append(results.getString(key)).append("\n");
                        }

                        // Display the AlertDialog
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("Your Entries")
                                .setMessage(message.toString())
                                .setPositiveButton("OK", null)
                                .show();

                        // 버튼이 클릭되면 PostDataTask를 실행합니다.
                        new PostDataTask().execute(results.toString());

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("경고")
                            .setMessage(errorMessage)
                            .setPositiveButton(android.R.string.yes, null)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }
            }
        });
    }

    private class PostDataTask extends AsyncTask<String, Void, Integer> {
        @Override
        protected Integer doInBackground(String... strings) {
            try {
                // AWS Lambda REST API의 URL을 설정합니다.
                URL url = new URL("https://92w0fldt7k.execute-api.ap-northeast-2.amazonaws.com/api/hello");

                // HTTP 연결을 엽니다.
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                // POST 방식으로 요청을 보냅니다.
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setDoOutput(true);

                // 첫 번째 인자를 JSON 데이터로 사용합니다.
                String jsonInputString = strings[0];

                try(OutputStream os = conn.getOutputStream()) {
                    // JSON 데이터를 byte 배열로 변환한 후, OutputStream을 통해 서버로 보냅니다.
                    byte[] input = jsonInputString.getBytes("utf-8");
                    os.write(input, 0, input.length);
                }

                // 서버로부터 받은 응답 코드를 반환합니다.
                return conn.getResponseCode();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(Integer responseCode) {
            // 네트워크 요청이 완료된 후에 실행되는 코드입니다.
            // 여기서는 응답 코드를 Toast 메시지로 표시합니다.
            if (responseCode != null) {
                String message = "Response code: " + responseCode;
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Error in network request", Toast.LENGTH_SHORT).show();
            }
        }
    }
}