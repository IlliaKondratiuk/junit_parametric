package data;

public enum Course {
    FRONTEND("Front-end"), SMM("SMM"), REACT("React");

    final String name;

    public String getName() {
        return name;
    }

    Course(String name) {
        this.name = name;
    }
}
