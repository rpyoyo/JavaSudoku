package com.Sudoku;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by Administrator on 2015/10/6.
 */
public class Cell {
    private String value = "";
    private int row = -1;
    private int column = -1;
    private Hashtable<String,Integer> candidate = new Hashtable<String,Integer>();

    public Cell(String v,int r,int c){
        this.value = v;
        this.row = r;
        this.column = c;
        for(int i = 1;i < 10;i++){
            candidate.put(i + "",i);
        }
    }
    public void setValue(String v,int r,int c){
        this.value = v;
        this.row = r;
        this.column = c;
        for(int i = 1;i < 10;i++){
            candidate.put(i + "",i);
        }
    }
    public void setValue(String v){
        this.value = v;
    }
    public String getValue(){
        return this.value;
    }
    public Boolean canSet(String v){
        return candidate.containsKey(v);
    }
    public int canSetNum(){
        return candidate.size();
    }
    public void removeFromCanSetList(String v){
        candidate.remove(v);
    }
    public void clearCanSetList(){
        candidate.clear();
    }
    public String getCanSetList(){
        String canSetList = "";
        for(int v : candidate.values()){

            canSetList += (canSetList == "" ? "" : "/") + v;
        }
        /*if(canSetList == "") {
            System.out.println("R " + this.row + " C " + this.column);
        }*/
        return canSetList;
    }
}
