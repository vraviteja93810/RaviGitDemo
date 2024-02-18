package programs;

public class Maserati extends Has_A_RelationDemo_Car{
public void MaseratiStartDemo()
{
	Engine MaseratiEngine = new Engine();
	MaseratiEngine.start();
	MaseratiEngine.stop();
}
}
