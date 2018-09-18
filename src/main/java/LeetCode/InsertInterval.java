package LeetCode;

import java.util.LinkedList;

public class InsertInterval {
    public static void main(String args[]) {
        InsertInterval obj = new InsertInterval();

        LinkedList<Interval> list = new LinkedList<Interval>();

        list.add(new Interval(1,3));
        list.add(new Interval(6,9));

        LinkedList<Interval> result = new LinkedList<Interval>();


        result = obj.insert(list,new Interval(2,5));

        for(Interval rec : result)
        {
            System.out.println(rec.getStart()+"-----:::"+rec.getEnd());
        }
        System.out.println("-=--=-FINISHED--=-=");
    }

    public LinkedList<Interval> insert(LinkedList<Interval> intervals, Interval newInterval) {

        if (newInterval == null)
            return intervals;

        LinkedList<Interval> list = new LinkedList<Interval>();

        if (intervals == null || intervals.size() == 0) {
            list.add(newInterval);
            return list;
        }

        for (Interval cur : intervals) {
            // insert cur
            if (newInterval.getStart() > cur.getEnd()) {
                list.add(cur);
                // insert interval
            } else if (newInterval.getEnd() < cur.getStart()) {
                list.add(newInterval);
                newInterval = cur;
                // merge interval
            } else {
                newInterval.setStart(Math.min(newInterval.getStart(), cur.getStart()));
                newInterval.setEnd(Math.max(newInterval.getEnd(), cur.getEnd()));
            }
        }
        list.add(newInterval);

        return list;
    }
}
