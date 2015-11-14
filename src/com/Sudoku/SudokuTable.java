package com.Sudoku;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/10/6.
 */
public class SudokuTable {
    //private int row = -1;
    //private int column = -1;
    private Cell[][] cells = new Cell[9][9];

    public void init(String sudokuTable){
        String[] lines = sudokuTable.split("\r\n");
        String[] cell;
        for(int i = 0;i < lines.length;i++){
            cell = lines[i].split(" ");
            for(int j = 0;j < cell.length;j++){
                cells[i][j] = new Cell(cell[j],i,j);
            }
        }
        for(int i = 0;i < 9;i++){
            for(int j = 0;j < 9;j++){
                if(!cells[i][j].getValue().equals("x")) {
                    updateCanSetList(cells[i][j].getValue(), i, j);
                }
            }
        }
    }
    public void updateCanSetListRow(String v,int r){
        for(int i = 0;i < 9;i++){
            cells[r][i].removeFromCanSetList(v);
        }
    }
    public void updateCanSetListCol(String v,int c){
        for(int i = 0;i < 9;i++){
            cells[i][c].removeFromCanSetList(v);
        }
    }
    public void updateCanSetListSeg(String v,int r,int c){
        int baseR = r / 3 * 3;
        int baseC = c / 3 * 3;
        for(int i = 0;i < 3;i++){
            for(int j = 0;j < 3;j++) {
                cells[baseR + i][baseC + j].removeFromCanSetList(v);
            }
        }
    }
    public void updateCanSetList(String v,int r,int c){
        updateCanSetListRow(v,r);
        updateCanSetListCol(v,c);
        updateCanSetListSeg(v,r,c);
        cells[r][c].clearCanSetList();
    }
    public void solve(int t){
        for(int i = 0;i < t;i++){
            if(!solveOneTime()) {
                System.out.println("try " + i + " times");
                show();
                break;
            }
        }
    }
    public Boolean solveOneTime(){
        Boolean canSolve = false;
        for(int i = 0;i < 9;i++){
            for(int j = 0;j < 9;j++){
                if(cells[i][j].getValue().equals("x")){
                    /*if(i == 8 && j == 1) {
                        i = 8;
                    }*/
                    String[] canSetList = cells[i][j].getCanSetList().split("/");
                    if(canSetList.length == 1){
                        cells[i][j].setValue(canSetList[0]);
                        updateCanSetList(canSetList[0],i,j);
                        canSolve = true;
                    }
                    else{
                        for(int k = 0;k < canSetList.length;k++){
                            if(checkCanSetList(canSetList[k],i,j)){
                                cells[i][j].setValue(canSetList[k]);
                                updateCanSetList(canSetList[k],i,j);
                                canSolve = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return canSolve;
    }
    public Boolean isSolved(){
        for(int i = 0;i < 9;i++) {
            for (int j = 0; j < 9; j++) {
                if (cells[i][j].getValue().equals("x")) {
                    return false;
                }
            }
        }
        return true;
    }
    public Boolean checkCanSetList(String v,int r,int c) {
        int baseR = r / 3 * 3;
        int baseC = c / 3 * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(cells[baseR + i][baseC + j].canSet(v) && ((baseR + i) != r || (baseC + j) != c)){
                    return false;
                }
            }
        }
        return true;
    }
    public void show(){
        String result = "";
        for (int i = 0; i < 9; i++) {
            if(i > 0 && i % 3 == 0){
                result += "---------------------\r\n";
            }
            for (int j = 0; j < 9; j++) {
                if(j > 0 && j % 3 == 0){
                    result += "| ";
                }
                result += cells[i][j].getValue() + " ";
            }
            result += "\r\n";
        }
        System.out.println(result);
    }
}
