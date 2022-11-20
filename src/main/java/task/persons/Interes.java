package task.persons;

public interface Interes {
    int getInteres();

    void setInteres(int n);

    public String checkInteres();
    default public void plusInteres(int n){
        setInteres(getInteres()+n);
    }
}

