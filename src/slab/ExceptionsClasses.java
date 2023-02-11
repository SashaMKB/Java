package slab;

public class ExceptionsClasses {
}
class maxArrayCountException extends Exception {
    public String toString () { return "You entered less than 5 numbers";}
}
class maxNumber extends Exception{
    public String toString() {return "You entered number bigger than 20";}
}
class MyNumberFormatException extends Exception{
    public String toString(){ return "You entered symbol '0'";}
}
