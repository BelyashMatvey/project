package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;
import java.util.TreeMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DnaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DnaFragment extends Fragment  {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DnaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DnaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DnaFragment newInstance(String param1, String param2) {
        DnaFragment fragment = new DnaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_dna, container, false);
        Button btn=v.findViewById(R.id.button);
        TreeMap<String,String> mp=new TreeMap<>();
        ArrayList<String> arr=new ArrayList<>();
        arr.add("u");
        arr.add("a");
        arr.add("g");
        arr.add("c");
        for (int i = 0; i <arr.size() ; i++) {
            for (int j = 0; j < arr.size(); j++) {
                for (int k = 0; k <arr.size() ; k++) {
                    if(arr.get(i).equals("u")){
                        if(arr.get(j).equals("u")){
                            if(arr.get(k).equals("u")||arr.get(k).equals("c")){
                                String key=arr.get(i)+arr.get(j)+arr.get(k);
                                mp.put(key,"Phe");
                            }
                            else {
                                String key=arr.get(i)+arr.get(j)+arr.get(k);
                                mp.put(key,"Ley");
                            }
                        }
                        else if(arr.get(j).equals("a")){
                            if(arr.get(k).equals("u")||arr.get(k).equals("c")){
                                String key=arr.get(i)+arr.get(j)+arr.get(k);
                                mp.put(key,"Tyr");
                            }
                            else{
                                String key=arr.get(i)+arr.get(j)+arr.get(k);
                                mp.put(key,"Term");
                            }
                        }
                        else if(arr.get(j).equals("g")){
                            if(arr.get(k).equals("u")||arr.get(k).equals("c")){
                                String key=arr.get(i)+arr.get(j)+arr.get(k);
                                mp.put(key,"Cys");
                            }
                            else if(arr.get(k).equals("g")){
                                String key=arr.get(i)+arr.get(j)+arr.get(k);
                                mp.put(key,"Thr");
                            }
                            else{
                                String key=arr.get(i)+arr.get(j)+arr.get(k);
                                mp.put(key,"Term");
                            }
                        }
                        else if(arr.get(j).equals("c")){
                            String key=arr.get(i)+arr.get(j)+arr.get(k);
                            mp.put(key,"Ser");
                        }
                    }
                    else if(arr.get(i).equals("a")){
                        if(arr.get(j).equals("u")){
                            if(arr.get(k).equals("u")||arr.get(k).equals("c")||arr.get(k).equals("a")){
                                String key=arr.get(i)+arr.get(j)+arr.get(k);
                                mp.put(key,"Ile");
                            }
                            else{
                                String key=arr.get(i)+arr.get(j)+arr.get(k);
                                mp.put(key,"Met");
                            }
                        }
                        else if(arr.get(j).equals("a")){
                            if(arr.get(k).equals("u")||arr.get(k).equals("c")){
                                String key=arr.get(i)+arr.get(j)+arr.get(k);
                                mp.put(key,"Asn");
                            }
                            else{
                                String key=arr.get(i)+arr.get(j)+arr.get(k);
                                mp.put(key,"Lys");
                            }
                        }
                        else if(arr.get(j).equals("g")){
                            if(arr.get(k).equals("u")||arr.get(k).equals("c")){
                                String key=arr.get(i)+arr.get(j)+arr.get(k);
                                mp.put(key,"Ser");
                            }
                            else{
                                String key=arr.get(i)+arr.get(j)+arr.get(k);
                                mp.put(key,"Arg");
                            }
                        }
                        else if(arr.get(j).equals("c")){
                            String key=arr.get(i)+arr.get(j)+arr.get(k);
                            mp.put(key,"Thr");
                        }
                    }
                    else if(arr.get(i).equals("g")){
                        if(arr.get(j).equals("u")){
                            String key=arr.get(i)+arr.get(j)+arr.get(k);
                            mp.put(key,"Val");
                        }
                        else if(arr.get(j).equals("a")){
                            if(arr.get(k).equals("u")||arr.get(k).equals("c")){
                                String key=arr.get(i)+arr.get(j)+arr.get(k);
                                mp.put(key,"Asp");
                            }
                            else{
                                String key=arr.get(i)+arr.get(j)+arr.get(k);
                                mp.put(key,"Glu");
                            }
                        }
                        else if(arr.get(j).equals("g")){
                            String key=arr.get(i)+arr.get(j)+arr.get(k);
                            mp.put(key,"Gly");
                        }
                        else if(arr.get(j).equals("c")){
                            String key=arr.get(i)+arr.get(j)+arr.get(k);
                            mp.put(key,"Ala");
                        }
                    }
                    else if(arr.get(i).equals("c")){
                        if(arr.get(j).equals("u")){
                            String key=arr.get(i)+arr.get(j)+arr.get(k);
                            mp.put(key,"Leu");
                        }
                        else if(arr.get(j).equals("a")){
                            if(arr.get(k).equals("u")||arr.get(k).equals("c")){
                                String key=arr.get(i)+arr.get(j)+arr.get(k);
                                mp.put(key,"His");
                            }
                            else{
                                String key=arr.get(i)+arr.get(j)+arr.get(k);
                                mp.put(key,"Gln");
                            }
                        }
                        else if(arr.get(j).equals("g")){
                            String key=arr.get(i)+arr.get(j)+arr.get(k);
                            mp.put(key,"Arg");
                        }
                        else if(arr.get(j).equals("c")){
                            String key=arr.get(i)+arr.get(j)+arr.get(k);
                            mp.put(key,"Pro");
                        }
                    }
                }
            }
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v1) {
                EditText edt = (EditText) v.findViewById(R.id.input);
                String s = edt.getText().toString();
                s = s.toLowerCase();
                String output = "";
                String outputDNA = "";
                if (s.length() == 0|| s.equals("Wrong amino acid")) {
                    edt.setText("Wrong amino acid");
                } else {
                    for (int i = 0; i < s.length(); i++) {
                        char k = s.charAt(i);
                        if (k == 'a') {
                            String k1 = "u";
                            outputDNA += "t";
                            output = output + k1;
                        } else if (k == 'g') {
                            String k1 = "c";
                            outputDNA += "c";
                            output = output + k1;
                        } else if (k == 't') {
                            String k1 = "a";
                            outputDNA += "a";
                            output = output + k1;
                        } else if (k == 'c') {
                            String k1 = "g";
                            outputDNA += "g";
                            output = output + k1;
                        }
                    }
                    String outputDNA_s = "";
                    for (int i = 0; i < outputDNA.length(); i++) {
                        if (i != 0 && i % 3 == 0) {
                            String k = Character.toString(outputDNA.charAt(i));
                            k = k.toUpperCase(Locale.ROOT);
                            outputDNA_s = outputDNA_s + "-" + k;
                        } else {
                            String k = Character.toString(outputDNA.charAt(i));
                            k = k.toUpperCase(Locale.ROOT);
                            outputDNA_s = outputDNA_s + k;
                        }
                    }
                    char f= (char)outputDNA_s.indexOf(outputDNA_s.length()-1);
                    if(f=='-')outputDNA_s=outputDNA_s.substring(0,outputDNA_s.length()-2);
                    TextView textView = (TextView) v.findViewById(R.id.protein2);
                    textView.setText(outputDNA_s);
                    int st_ind = -1;
                    for (int i = 0; i < output.length() - 2; i++) {
                        String fi = Character.toString(output.charAt(i));
                        String se = Character.toString(output.charAt(i + 1));
                        String th = Character.toString(output.charAt(i + 2));
                        String p_ans = fi + se + th;
                        if (p_ans.equals("aug")) {
                            st_ind = i;
                            break;
                        }
                    }
                    String output_ans = "";
                    for (int i = 0; i < output.length(); i++) {
                        if (i != 0 && i % 3 == 0) {
                            String k = Character.toString(output.charAt(i));
                            k = k.toUpperCase(Locale.ROOT);
                            output_ans = output_ans + "-" + k;
                        } else {
                            String k = Character.toString(output.charAt(i));
                            k = k.toUpperCase(Locale.ROOT);
                            output_ans = output_ans + k;
                        }
                    }
                    TextView txt = (TextView) v.findViewById(R.id.RNA);
                    txt.setText(output_ans);
                    if (st_ind == -1) {
                        TextView txt1 = (TextView) v.findViewById(R.id.protein);
                        txt1.setText("Wrong amino acid");
                    } else {
                        String ans = "";
                        output = output.substring(st_ind);
                        for (int i = 0; i < output.length(); i += 3) {
                            if (i + 2 < output.length()) {
                                String fi = Character.toString(output.charAt(i));
                                String se = Character.toString(output.charAt(i + 1));
                                String th = Character.toString(output.charAt(i + 2));
                                String p_ans = fi + se + th;
                                String c = mp.get(p_ans);
                                ans = ans + c + "-";
                            }
                        }
                        ans = ans.substring(0, ans.length() - 1);
                        TextView txt1 = (TextView) v.findViewById(R.id.protein);
                        txt1.setText(ans);
                    }
                    v.invalidate();
                }
            }
        });
        return v;
    }
}