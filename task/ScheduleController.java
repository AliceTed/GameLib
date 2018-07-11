package schedule;

public class ScheduleController
{
	private static final ScheduleController INSTANCE = new ScheduleController();
	private ScheduleTimer schedule;

	public static ScheduleController getInstance()
	{
		return INSTANCE;
	}

	private ScheduleController()
	{
	}

	public void start()
	{
		long delay=10000L;
		schedule = new ScheduleTimer();
		schedule.schedule(delay);
	}

	public void remove()
	{
		schedule.cancel();
		schedule = null;
	}

	public boolean isExist()
	{
		return schedule != null;
	}

}
