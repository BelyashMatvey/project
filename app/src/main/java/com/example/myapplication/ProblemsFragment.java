package com.example.myapplication;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
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
                TableLayout tableLayout=(TableLayout) v.findViewById(R.id.tablet);
                tableLayout.removeAllViews();
                EditText edt = (EditText) v.findViewById(R.id.Fgen);
                EditText edt2 = (EditText) v.findViewById(R.id.Sgen);
                TextView game1 = (TextView) v.findViewById(R.id.gam1);
                TextView game2 = (TextView) v.findViewById(R.id.gam2);
                String s = edt.getText().toString();
                String s1 = edt2.getText().toString();
                TreeSet<String> tr = new TreeSet<>();
                TreeSet<String> tr2 = new TreeSet<>();
                for (int i = 0; i < s.length(); i++) {
                    String k = Character.toString(s.charAt(i)).toLowerCase();
                    tr.add(k);
                }
                for (int i = 0; i < s1.length(); i++) {
                    String k = Character.toString(s1.charAt(i)).toLowerCase();
                    tr2.add(k);
                }
                if (s.equals("Wrong gen") ||s.length()==0||s1.length()==0||s.length() != s1.length() || tr.size() != tr2.size() || !Objects.equals(tr.first(), tr2.first())) {
                    edt.setText("Wrong gen");
                    edt2.setText("Wrong gen");
                } else {
                    TreeSet<String> table1;
                    TreeSet<String> table2;
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
                        game1.setTextSize(15);
                        game1.setTypeface(null, Typeface.BOLD);
                        game2.setTextSize(15);
                        game2.setTypeface(null, Typeface.BOLD);
                        table1 = tr;
                        table2 = tr2;
                    } else {
                        tr = new TreeSet<String>();
                        tr2 = new TreeSet<String>();
                        for (int i = 0; i < s.length(); i++) {
                            for (int j = i; j < s.length(); j++) {
                                String k = Character.toString(s.charAt(i));
                                String k1 = Character.toString(s.charAt(j));
                                String n = k + k1;
                                if (n.equals("AB") || n.equals("Ab") || n.equals("aB") || n.equals("ab")) {
                                    tr.add(n);
                                }
                            }
                        }
                        for (int i = 0; i < s1.length(); i++) {
                            for (int j = i; j < s1.length(); j++) {
                                String k = Character.toString(s1.charAt(i));
                                String k1 = Character.toString(s1.charAt(j));
                                String n = k + k1;
                                if (n.equals("AB") || n.equals("Ab") || n.equals("aB") || n.equals("ab")) {
                                    tr2.add(n);
                                }
                            }
                        }
                        String p_ans = "";
                        String p_ans2 = "";
                        for (String e : tr) {
                            p_ans += e;
                            p_ans += "  ";
                        }
                        for (String e : tr2) {
                            p_ans2 += e;
                            p_ans2 += "  ";
                        }
                        game1.setTextSize(18);
                        game2.setTypeface(null, Typeface.BOLD);
                        game2.setTextSize(18);
                        game1.setTypeface(null, Typeface.BOLD);
                        game1.setText(p_ans);
                        game2.setText(p_ans2);
                        table1 = tr;
                        table2 = tr2;
                    }
                    List<String> list1 = new ArrayList<String>(table1);
                    List<String> list2 = new ArrayList<String>(table2);
                    int sz1= list1.size();
                    int sz2=list2.size();
                    Map<String,Integer> mp=new TreeMap<>();
                    TableLayout tablet = (TableLayout) v.findViewById(R.id.tablet);
                    for (int i = 0; i <= sz1; i++) {
                        TableRow tableRow = new TableRow(container.getContext());
                        tableRow.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                                LayoutParams.WRAP_CONTENT));
                        for (int j = 0; j <= sz2; j++) {
                            if (j == 0 && i == 0) {
                                ImageView imageView = new ImageView(container.getContext());
                                imageView.setImageResource(R.drawable.ic_baseline_close_24);
                                if(tableRow.getParent() != null) {
                                    ((ViewGroup)tableRow.getParent()).removeView(tableRow); // <- fix
                                }
                                tableRow.addView(imageView, j);
                            } else if (i == 0 && j != 0) {
                                TextView textView = new TextView(container.getContext());
                                String n=list2.get(j-1)+"  ";
                                textView.setText(n);
                                textView.setTextSize(18);
                                textView.setTypeface(null, Typeface.BOLD);
                                if(tableRow.getParent() != null) {
                                    ((ViewGroup)tableRow.getParent()).removeView(tableRow); // <- fix
                                }
                                tableRow.addView(textView, j);

                            } else if (i != 0 && j == 0) {
                                TextView textView = new TextView(container.getContext());
                                String n=list1.get(i-1)+"  ";
                                textView.setText(n);
                                textView.setTextSize(18);
                                textView.setTypeface(null, Typeface.BOLD);
                                if(tableRow.getParent() != null) {
                                    ((ViewGroup)tableRow.getParent()).removeView(tableRow); // <- fix
                                }
                                tableRow.addView(textView, j);
                            } else {
                                TextView textView = new TextView(container.getContext());
                                String n = "", n1 = "";
                                TreeSet<String> treeSet = new TreeSet<>();
                                TreeSet<String> treeSet1 = new TreeSet<>();
                                String k = list1.get(i - 1);
                                String k1 = list2.get(j - 1);
                                String c=k.toLowerCase(Locale.ROOT);
                                String c1=k1.toLowerCase(Locale.ROOT);
                                if (!(c.contains("b")) && !(c1.contains("b"))) {
                                    for (int l = 0; l < k.length(); l++) {
                                        treeSet.add(Character.toString(k.charAt(l)));
                                    }
                                    for (int l = 0; l < k1.length(); l++) {
                                        treeSet.add(Character.toString(k1.charAt(l)));
                                    }
                                    for (String e : treeSet) {
                                        n += e;
                                    }
                                    if (n.length() == 1) n += Character.toString(n.charAt(0));
                                    String n_k=n.toLowerCase(Locale.ROOT);
                                    if(n.equals(n_k)){
                                        int count=mp.getOrDefault("a",0);
                                        mp.put("a",count+1);
                                    }
                                    else{
                                        int count=mp.getOrDefault("A",0);
                                        mp.put("A",count+1);
                                    }
                                    n+="  ";
                                    textView.setTextSize(18);
                                    textView.setText(n);
                                } else {
                                    for (int l = 0; l < k.length(); l++) {
                                        if (Character.toString(k.charAt(l)).equalsIgnoreCase("a")) {
                                            treeSet.add(Character.toString(k.charAt(l)));
                                        } else {
                                            treeSet1.add(Character.toString(k.charAt(l)));
                                        }
                                    }
                                    for (int l = 0; l < k1.length() ; l++) {
                                        if (Character.toString(k1.charAt(l)).equalsIgnoreCase("a")) {
                                            treeSet.add(Character.toString(k1.charAt(l)));
                                        } else {
                                            treeSet1.add(Character.toString(k1.charAt(l)));
                                        }
                                    }
                                    for (String e : treeSet) {
                                        n += e;
                                    }
                                    for (String e : treeSet1) {
                                        n1 += e;
                                    }
                                    if (n.length() == 1) n += Character.toString(n.charAt(0));
                                    if (n1.length() == 1) n1 += Character.toString(n1.charAt(0));
                                    String n_k1=n.toLowerCase(Locale.ROOT);
                                    String n_k2=n1.toLowerCase(Locale.ROOT);
                                    if(!n_k1.equals(n) && !n_k2.equals(n1)){
                                        int count=mp.getOrDefault("AB",0);
                                        mp.put("AB",count+1);
                                    }
                                    else if(n_k1.equals(n) && !n_k2.equals(n1)){
                                        int count=mp.getOrDefault("aB",0);
                                        mp.put("aB",count+1);
                                    }
                                    else if(!n_k1.equals(n) && n_k2.equals(n1)){
                                        int count=mp.getOrDefault("Ab",0);
                                        mp.put("Ab",count+1);
                                    }
                                    else if(n_k1.equals(n) && n_k2.equals(n1)){
                                        int count=mp.getOrDefault("ab",0);
                                        mp.put("ab",count+1);
                                    }
                                    n += n1;
                                    n+="  ";
                                    textView.setText(n);
                                    textView.setTextSize(18);
                                }
                                if(tableRow.getParent() != null) {
                                    ((ViewGroup)tableRow.getParent()).removeView(tableRow); // <- fix
                                }
                                tableRow.addView(textView, j);
                            }
                            tablet.addView(tableRow, i);
                        }
                    }
                    TableLayout tableLayout1=(TableLayout) v.findViewById(R.id.tablet2);
                    tableLayout1.removeAllViews();
                    int sz=mp.size();
                    List<String> lst=new ArrayList<>();
                    for(TreeMap.Entry<String,Integer> entry : mp.entrySet()){
                        lst.add(entry.getKey());
                    }
                    for (int i=0;i<=sz;i++){
                        TableRow tableRow = new TableRow(container.getContext());
                        tableRow.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                                LayoutParams.WRAP_CONTENT));
                        for (int j = 0; j < 2; j++) {
                            if(i==0&&j==0){
                                TextView txt=new TextView(container.getContext());
                                txt.setText("Genotip  ");
                                txt.setTextSize(18);
                                txt.setTypeface(null, Typeface.BOLD);
                                tableRow.addView(txt);
                            }
                            else if(i==0&&j==1){
                                TextView txt=new TextView(container.getContext());
                                txt.setTypeface(null, Typeface.BOLD);
                                txt.setText("Distribution");
                                txt.setTextSize(18);
                                tableRow.addView(txt);
                            }
                            else if(j==0&&i>0){
                                TextView txt=new TextView(container.getContext());
                                String n=lst.get(i-1);
                                n+="  ";
                                txt.setText(n);
                                txt.setTextSize(18);
                                tableRow.addView(txt);
                            }
                            else if(j==1&&i>0){
                                TextView txt=new TextView(container.getContext());
                                String n=mp.get(lst.get(i-1)).toString();
                                txt.setText(n);
                                txt.setTextSize(18);
                                tableRow.addView(txt);
                            }
                        }
                        tableLayout1.addView(tableRow);
                    }
                }
            }
        });
        return v;
    }
}