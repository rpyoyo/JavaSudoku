package com.Sudoku;

import java.util.Hashtable;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String sudokuTable = "";
        Scanner scanner = new Scanner(System.in);
        SudokuTable st = new SudokuTable();

        System.out.println("Please input sudoku table:");
        for(int i = 0;i < 9;i++){
            sudokuTable += (i > 0 ? "\r\n" : "") + scanner.nextLine();
        }

        st.init(sudokuTable);
        st.show();

        while(true) {
            st.solve(Integer.parseInt(scanner.nextLine()));
        }
    //    processer(sudokuTable);
    }
    /*public static void processer(String sudokuTable){
        String[] lines = sudokuTable.split("\r\n");
        String[] cells;
        String[][] rows = new String[9][9];
        String[][] cols = new String[9][9];
        String[][] segs = new String[9][9];
        Hashtable ht = new Hashtable();
        Boolean bFind = true;
        Boolean bFind1 = true;
        Boolean bFind2 = true;
        Boolean bFind3 = true;
        Boolean bGot = true;
        Boolean bUpdated = true;
        String value = "";
        int i,j,k,index;

        for(i = 0;i < lines.length;i++){
            cells = lines[i].split(" ");
            for(j = 0;j < cells.length;j++){
                rows[i][j] = cells[j];
                cols[j][i] = cells[j];
                segs[i / 3 * 3 + j / 3][(i % 3) * 3 + j % 3] = cells[j];
            //    System.out.println(i / 3 * 3 + " " + j / 3 + " " + (i % 3) * 3 + " " + j % 3);
            }
        }


        while(bFind) {
            bFind = false;
            bUpdated = false;
            for (i = 0; i < 9; i++) {
                for (j = 0; j < 9; j++) {
                    if (rows[i][j].equals("x")) {
                        bFind = true;
                        bGot = true;
                        value = "";
                        if(i == 3 && j == 3){
                            value = "";
                        }
                        for(k = 1;k < 10;k++){
                            bFind1 = false;
                            bFind2 = false;
                            bFind3 = false;

                            if(k == 4){
                                k = 4;
                            }
                            for(index = 0;index < 9;index++){
                                if(rows[i][index].equals("" + k)){
                                    bFind1 = true;
                                    break;
                                }
                            }
                            if(bFind1){
                                continue;
                            }
                            for(index = 0;index < 9;index++){
                                if(cols[j][index].equals("" + k)){
                                    bFind2 = true;
                                    break;
                                }
                            }
                            if(bFind2){
                                continue;
                            }
                            for(index = 0;index < 9;index++){
                                if(segs[i / 3 * 3 + j / 3][index].equals("" + k)){
                                    bFind3 = true;
                                    break;
                                }
                            }
                            if(bFind3){
                                continue;
                            }

                            if(value.equals("")){
                                value = "" + k;
                                bGot = false;
                            }
                            else {
                                bGot = true;
                                break;
                            }
                        }
                        if(bGot){
                            continue;
                        }
                        else{
                            rows[i][j] = value;
                            cols[j][i] = value;
                            segs[i / 3 * 3 + j / 3][(i % 3) * 3 + j % 3] = value;
                            bUpdated = true;
                        }
                    }
                }
            }
            if(bUpdated) {
                showResults(rows);
            }
        }
        showResults(rows);

    }

    public static void showResults(String[][] results) {
        String result = "";
        for (int i = 0; i < 9; i++) {
            if(i > 0 && i % 3 == 0){
                result += "----------------------\r\n";
            }
            for (int j = 0; j < 9; j++) {
                if(j > 0 && j % 3 == 0){
                    result += "| ";
                }
                result += results[i][j] + " ";
            }
            result += "\r\n";
        }
        System.out.println(result);
    }*/
}
