package schedule;
import java.util.TimerTask;

public class OrdinaryTask extends TimerTask{


	int count;
	public OrdinaryTask()
	{
		count=0;
	}

	@Override
	public void run()
	{
		count++;
		System.out.println("Wake Up"+count);
	}
}
