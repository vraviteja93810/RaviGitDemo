import java.io.IOException;
import java.util.ArrayList;

public class Testsample {
public static void main(String[] args) throws IOException {
	Datadriven data=new Datadriven();
	ArrayList<String> values = data.getData("purchase");
	System.out.println(values.get(0));
	System.out.println(values.get(1));
	System.out.println(values.get(2));
	System.out.println(values.get(3));
}
}
