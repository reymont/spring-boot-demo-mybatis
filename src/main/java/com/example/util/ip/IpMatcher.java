package com.example.util.ip;

/**
 * Created by Zhangkh on 2018/1/4.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * Created by kolian on 2016. 12. 28..
 */
public class IpMatcher {

    private List<String> requiredIpList;
    private List<IpRange> sortedIpList = new ArrayList<IpRange>();

    public IpMatcher(List<String> requiredIpList) {
        this.requiredIpList = requiredIpList;
        init();
    }

    public void init() {
        if (requiredIpList.isEmpty()) {
            return;
        }

        List<IpRange> tempIpList = new ArrayList<IpRange>();
        for (String requiredIp : requiredIpList) {
            tempIpList.add(new IpRange(requiredIp));
        }

        Collections.sort(tempIpList, new Comparator<IpRange>() {
            public int compare(IpRange o1, IpRange o2) {
                if (o1.getFrom() != o2.getFrom()) {
                    return o1.getFrom() > o2.getFrom() ? 1 : -1;
                }
                if (o1.getTo() != o2.getTo()) {
                    return o1.getTo() > o2.getTo() ? 1 : -1;
                }
                return 0;
            }
        });

        int insertIndex = 0;
        for (IpRange ipRange : tempIpList) {
            if (sortedIpList.isEmpty()) {
                sortedIpList.add(ipRange);
                continue;
            }

            IpRange beforeIpRange = sortedIpList.get(insertIndex);

            if (ipRange.getFrom() <= beforeIpRange.getTo() + 1) {
                beforeIpRange.setTo(ipRange.getTo());
            } else {
                sortedIpList.add(ipRange);
                ++insertIndex;
            }
        }
    }

    /**
     *
     *
     * @param ip
     * @return
     */
    public boolean matches(String ip) {
        IpRange targetIpRange = new IpRange(ip);
        long targetIpLong = targetIpRange.getFrom();

        int start = 0;
        int end = sortedIpList.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            IpRange ipRange = sortedIpList.get(mid);
            if (targetIpLong < ipRange.getFrom()) {
                end = mid - 1;
            } else if (targetIpLong > ipRange.getTo()) {
                start = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}