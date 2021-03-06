package Model;

/**
 * Created by roije on 04/07/2016.
 */
public class Day
{
    private int dayId;
    private String dayName;
    private String dayDate;
    private int hoursTotal;
    private int hoursReg;
    private int firstOver;
    private int secondOver;
    private int saturdayHour;
    private int sundayHour;
    private String totalPay;
    private String afterTax;
    private int jobId;

    public Day()
    {

    }

    public int getDayId()
    {
        return dayId;
    }

    public void setDayId(int dayId)
    {
        this.dayId = dayId;
    }

    public String getDayName()
    {
        return dayName;
    }

    public void setDayName(String dayName)
    {
        this.dayName = dayName;
    }

    public String getDayDate()
    {
        return dayDate;
    }

    public void setDayDate(String dayDate)
    {
        this.dayDate = dayDate;
    }

    public int getHoursTotal()
    {
        return hoursTotal;
    }

    public void setHoursTotal(int hoursTotal)
    {
        this.hoursTotal = hoursTotal;
    }

    public int getHoursReg()
    {
        return hoursReg;
    }

    public void setHoursReg(int hoursReg)
    {
        this.hoursReg = hoursReg;
    }

    public int getFirstOver()
    {
        return firstOver;
    }

    public void setFirstOver(int firstOver)
    {
        this.firstOver = firstOver;
    }

    public int getSecondOver()
    {
        return secondOver;
    }

    public void setSecondOver(int secondOver)
    {
        this.secondOver = secondOver;
    }

    public int getSaturdayHour()
    {
        return saturdayHour;
    }

    public void setSaturdayHour(int saturdayHour)
    {
        this.saturdayHour = saturdayHour;
    }

    public int getSundayHour()
    {
        return sundayHour;
    }

    public void setSundayHour(int sundayHour)
    {
        this.sundayHour = sundayHour;
    }

    public String getTotalPay()
    {
        return totalPay;
    }

    public void setTotalPay(String totalPay)
    {
        this.totalPay = totalPay;
    }

    public String getAfterTax()
    {
        return afterTax;
    }

    public String setAfterTax(String afterTax)
    {
        return  this.afterTax = afterTax;
    }

    public int getJobId()
    {
        return jobId;
    }

    public void setJobId(int jobId)
    {
        this.jobId = jobId;
    }
}
