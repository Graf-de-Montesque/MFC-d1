package pkg3iteration.studentorder.validator;

import pkg3iteration.studentorder.domain.Person;

public class AnswerCityRegisterItem {
 
    public enum CityStatus {
        YES, NO, ERROR;
    }
    //вложенный класс
    public static class CityError {
        private String code;
        private String text;
        
        //конструктор вложенного класса
        public CityError(String code, String text){
            this.code = code;
            this.text = text;
        }
        public String getCode(){
            return code;
        }
        public String getText(){
            return text;
        }
    }
    
    private CityStatus status;
    private Person person;
    private CityError error;

    public AnswerCityRegisterItem(CityStatus status, Person person, CityError error) {
        this.status = status;
        this.person = person;
        this.error = error;
    }

    public CityStatus getStatus() {
        return status;
    }

    public void setStatus(CityStatus status) {
        this.status = status;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public CityError getError() {
        return error;
    }

    public void setError(CityError error) {
        this.error = error;
    }
    
    
    
 
}
