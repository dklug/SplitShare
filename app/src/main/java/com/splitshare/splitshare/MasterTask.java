package com.splitshare.splitshare;

import com.google.firebase.database.DatabaseReference;

import java.util.Calendar;
import java.util.List;

/**
 * Created by emmanuel on 10/9/17.
 */

public class MasterTask
{
    private String title;
    private String description;
    private int type;
    private Calendar startDate;
    private Calendar endDate;
    private String groupId;
    private List<User> activeUsers;
    // TODO: List<double> paymentDistribution;
    // and paymentAmount is the sum total
    private double paymentAmount;
    public boolean costDue;
    private Cycle cycle;

    public MasterTask() {
        startDate = Calendar.getInstance();
        endDate = Calendar.getInstance();
    }

    public MasterTask(String title, String description, int type, Calendar startDate,
                      Calendar endDate, String groupId, List<User> activeUsers, boolean costDue, double paymentAmount,
                      Cycle cycle)
    {
        this.title = title;
        this.description = description;
        this.type = type;
        setStartDate(startDate);
        setEndDate(endDate);
        this.groupId = groupId;
        this.activeUsers = activeUsers;
        this.costDue = costDue;
        this.paymentAmount = paymentAmount;
        this.cycle = cycle;
    }


    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }

    public Calendar getStartDate()
    {
        return startDate;
    }

    public void setStartDate(Calendar startDate)
    {
        this.startDate = startDate;

        this.startDate.set(Calendar.HOUR_OF_DAY, 0);
        this.startDate.set(Calendar.MINUTE, 0);
        this.startDate.set(Calendar.SECOND, 0);
        this.startDate.set(Calendar.MILLISECOND, 0);
    }

    public Calendar getEndDate()
    {
        return endDate;
    }

    public void setEndDate(Calendar endDate)
    {
        this.endDate = endDate;

        this.endDate.set(Calendar.HOUR_OF_DAY, 0);
        this.endDate.set(Calendar.MINUTE, 0);
        this.endDate.set(Calendar.SECOND, 0);
        this.endDate.set(Calendar.MILLISECOND, 0);
    }

    public String getGroupId()
    {
        return groupId;
    }

    public void setGroupId(String groupId)
    {
        this.groupId = groupId;
    }

    public List<User> getActiveUsers()
    {
        return activeUsers;
    }

    public void setActiveUsers(List<User> activeUsers)
    {
        this.activeUsers = activeUsers;
    }

    public double getPaymentAmount()
    {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount)
    {
        this.paymentAmount = paymentAmount;
    }

    public Cycle getCycle()
    {
        return cycle;
    }

    public void setCycle(Cycle cycle)
    {
        this.cycle = cycle;
    }

    public StoredMasterTask toStoredMasterTask() {
        SimpleDate sd = new SimpleDate(this.startDate.get(Calendar.MONTH), this.startDate.get(Calendar.DAY_OF_MONTH), this.startDate.get(Calendar.YEAR));
        SimpleDate ed = new SimpleDate(this.endDate.get(Calendar.MONTH), this.endDate.get(Calendar.DAY_OF_MONTH), this.endDate.get(Calendar.YEAR));
        return new StoredMasterTask(title, description, type, sd,
                ed, groupId, activeUsers, costDue, paymentAmount, cycle);
    }
}
