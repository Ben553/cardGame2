package com.example.cardgame2;

public class RecordsTable {
    public static final String TAG = "RecordsTable";
    private final int TABLE_SIZE = 5;
    private String[] recordsTable;


    public RecordsTable() {
        this.recordsTable = new String[TABLE_SIZE];
        for(int i = 0; i < TABLE_SIZE; i++)
            recordsTable[i] = "Name: ---, Score: 0";
    }

    public void addToRecordsTable(String name, String score){
        for(int i = 0; i< TABLE_SIZE; i++){
            if(checkScore(recordsTable[i]) < Integer.valueOf(score)){
                recordsTable[TABLE_SIZE -1] = (". Name: "+name+", Score: "+score);
            }
        }
        sortTable();
    }

    public void sortTable(){
        for(int i = 0; i < TABLE_SIZE -1; i++){
            for(int j = 0; j < TABLE_SIZE -i-1; j++){
                if(checkScore(recordsTable[j]) < checkScore(recordsTable[j+1])){
                    String temp = recordsTable[j];
                    recordsTable[j] = recordsTable[j+1];
                    recordsTable[j+1] = temp;
                }
            }
        }
    }

    private int checkScore(String str){
        String temp = str.substring(1);
        for (int i = 0; i < str.length();) {
            if(!(temp.charAt(i) > 47 && temp.charAt(i) < 58))
                temp = temp.substring(i+1);
            else
                break;
        }
        return Integer.valueOf(temp);
    }

    public void setRecordsTable(String str,int i){
        recordsTable[i] = str;
    }

    public String toString(int i){
        return recordsTable[i];
    }
}
