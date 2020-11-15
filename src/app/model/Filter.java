package app.model;

import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Filter {
    public static final int STEP_DAY = 0;
    public static final int STEP_MONTH = 1;
    public static final int STEP_YEAR = 2;

    private int step;
    private Date from;
    private Date to;

    public Filter() {
        this(STEP_MONTH);
    }

    public Filter(int step) {
        this.step = step;
        setFromTo(new GregorianCalendar());
    }

    public int getStep() {
        return step;
    }

    public Date getFrom() {
        return from;
    }

    public Date getTo() {
        return to;
    }

    public void next() {
        offset(1);
    }

    public void prev() {
        offset(-1);
    }

    public void nextPeriod() {
        step += 1;
        if (step > STEP_YEAR) step = STEP_DAY;
        setFromTo(new GregorianCalendar());
    }

    public void prevPeriod() {
        step -= 1;
        if (step < STEP_DAY) step = STEP_YEAR;
        setFromTo(new GregorianCalendar());
    }

    public boolean checkDate(Date date) {
        return (date.compareTo(from) > 0) && (date.compareTo(to) < 0);
    }

    private void setFromTo(Calendar calendar) {
        switch (step) {
            case STEP_DAY:
                this.from = new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0).getTime();
                this.to = new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59).getTime();
                break;
            case STEP_MONTH:
                YearMonth yearMonth = YearMonth.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1);
                this.from = new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 1, 23, 59, 59).getTime();
                this.to = new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), yearMonth.lengthOfMonth(), 23, 59, 59).getTime();
                break;
            case STEP_YEAR:
                this.from = new GregorianCalendar(calendar.get(Calendar.YEAR), 0, 1, 0, 0, 0).getTime();
                this.to = new GregorianCalendar(calendar.get(Calendar.YEAR), 11, 31, 23, 59, 59).getTime();
                break;
        }
    }

    private void offset(int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(from);
        switch (step) {
            case STEP_DAY:
                calendar.add(Calendar.DAY_OF_MONTH, 1);
                break;
            case STEP_MONTH:
                calendar.add(Calendar.MONTH, 1);
                break;
            case STEP_YEAR:
                calendar.add(Calendar.YEAR, 1);
                break;
        }
        setFromTo(calendar);
    }

}
