package springCore.bean;

public class Thing {
	private OtherThing other;

    public void setOther(OtherThing other) {
        this.other = other;
    }

    public String output() {
       return other.output();
    }
}
