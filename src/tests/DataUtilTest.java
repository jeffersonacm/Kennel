package tests;

import main.canil.enums.DayType;
import main.canil.utils.DateUtil;
import org.junit.Test;
import org.junit.Assert;

public class DataUtilTest {

    private DateUtil dateUtil = new DateUtil();

    @Test
    public void validDateTest() {
        Boolean aBoolean = dateUtil.isValidFormatDate("23/02/2000");
        Assert.assertEquals(Boolean.TRUE, aBoolean);
    }

    @Test
    public void invalidMaskDateTest() {
        Boolean aBoolean = dateUtil.isValidFormatDate("23-02-2000");
        Assert.assertEquals(Boolean.FALSE, aBoolean);
    }

    @Test
    public void invalidDateTest() {
        Boolean aBoolean = dateUtil.isValidFormatDate("23/22/2000");
        Assert.assertEquals(Boolean.FALSE, aBoolean);
    }

    @Test
    public void getWeekdayTest() {
        String date = "20/03/2020";
        DayType dayType = dateUtil.getWeekdayOrWeekend(dateUtil.toLocaldate(date));

        Assert.assertEquals(DayType.WEEKDAY, dayType);
    }

    @Test
    public void getWeekendTest() {
        String date = "21/03/2020";
        DayType dayType = dateUtil.getWeekdayOrWeekend(dateUtil.toLocaldate(date));

        Assert.assertEquals(DayType.WEEKEND, dayType);
    }

}
