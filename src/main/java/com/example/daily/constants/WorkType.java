package com.example.daily.constants;

public enum WorkType {

    STATIC("Static"),//
    LIGHT("Light"),//
    HEAVY("Heavy"),//
    ;
    private String type;

    WorkType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static boolean checkType(String inputType){
        for(WorkType item:WorkType.values()){
            if(inputType.equalsIgnoreCase(item.getType())){
                return true;
            }
        }
        return false;
    }
}
