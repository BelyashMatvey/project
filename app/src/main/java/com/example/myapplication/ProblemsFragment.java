package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProblemsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProblemsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProblemsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProblemsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProblemsFragment newInstance(String param1, String param2) {
        ProblemsFragment fragment = new ProblemsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_problems, container, false);
        Button btn = v.findViewById(R.id.solver);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                EditText edt = (EditText) v.findViewById(R.id.Fgen);
                EditText edt2 = (EditText) v.findViewById(R.id.Sgen);
                TextView game1 = (TextView) v.findViewById(R.id.gam1);
                TextView game2 = (TextView) v.findViewById(R.id.gam2);
                String s = edt.getText().toString();
                String s1 = edt2.getText().toString();
                TreeSet<String> tr = new TreeSet<String>();
                TreeSet<String> tr2 = new TreeSet<String>();
                for (int i = 0; i < s.length(); i++) {
                    String k = Character.toString(s.charAt(i)).toLowerCase();
                    tr.add(k);
                }
                for (int i = 0; i < s1.length(); i++) {
                    String k = Character.toString(s1.charAt(i)).toLowerCase();
                    tr2.add(k);
                }
                if (s.length() != s1.length() || tr.size() != tr2.size() || !Objects.equals(tr.first(), tr2.first())) {
                    edt.setText("Wrong gen");
                    edt2.setText("Wrong gen");
                } else {
                    if (tr.size() == 1) {
                        tr = new TreeSet<String>();
                        tr2 = new TreeSet<String>();
                        for (int i = 0; i < s.length(); i++) {
                            String k = Character.toString(s.charAt(i));
                            tr.add(k);
                        }
                        for (int i = 0; i < s1.length(); i++) {
                            String k = Character.toString(s1.charAt(i));
                            tr2.add(k);
                        }
                        String p_ans = "";
                        String p_ans2 = "";
                        for (String a : tr) {
                            p_ans += a;
                            p_ans += "  ";
                        }
                        for (String a : tr2) {
                            p_ans2 += a;
                            p_ans2 += "  ";
                        }
                        game1.setText(p_ans);
                        game2.setText(p_ans2);
                    } else {
                        tr = new TreeSet<String>();
                        tr2 = new TreeSet<String>();
                        for (int i=0;i<s.length();i++){
                            for (int j=i;j<s.length();j++){
                                String k = Character.toString(s.charAt(i));
                                String k1=Character.toString(s.charAt(j));
                                String n=k+k1;
                                if(n.equals("AB") || n.equals("Ab") || n.equals("aB") || n.equals("ab")){
                                    tr.add(n);
                                }
                            }
                        }
                        for (int i=0;i<s1.length();i++){
                            for (int j=i;j<s1.length();j++){
                                String k = Character.toString(s1.charAt(i));
                                String k1=Character.toString(s1.charAt(j));
                                String n=k+k1;
                                if(n.equals("AB") || n.equals("Ab") || n.equals("aB") || n.equals("ab")){
                                    tr2.add(n);
                                }
                            }
                        }
                        String p_ans="";
                        String p_ans2="";
                        for (String e:tr) {
                            p_ans+=e;
                            p_ans+="  ";
                        }
                        for (String e:tr2) {
                            p_ans2+=e;
                            p_ans2+="  ";
                        }
                        game1.setText(p_ans);
                        game2.setText(p_ans2);
                    }
                    v.invalidate();
                }
            }
        });
        return v;
    }
}