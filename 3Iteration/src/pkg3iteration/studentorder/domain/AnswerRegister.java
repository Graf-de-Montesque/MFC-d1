package pkg3iteration.studentorder.domain;

import java.util.ArrayList;
import java.util.List;
import pkg3iteration.studentorder.validator.AnswerCityRegisterItem;

public class AnswerRegister {
     private List<AnswerCityRegisterItem> items;
    
    public void addItem(AnswerCityRegisterItem item){
        if (items == null) {
            items = new ArrayList<>(10);
        }
        items.add(item);
    }
    public List<AnswerCityRegisterItem> getItems(){
        return items;
    }
    }
