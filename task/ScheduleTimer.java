package schedule;

import java.util.Timer;

public class ScheduleTimer extends Timer
{
	OrdinaryTask task;
	public ScheduleTimer() {
	}
	@Override
	public void cancel()
	{
		//終了前にもう一度処理を呼ぶ
		task.run();
		super.cancel();
	}

	public void schedule(long delay)
	{
		task=new OrdinaryTask();
		super.schedule(task,delay,delay );
	}
}
