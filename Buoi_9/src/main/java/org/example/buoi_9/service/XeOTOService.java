package org.example.buoi_9.service;

import org.example.buoi_9.entity.XeOTO;

import java.util.ArrayList;
import java.util.List;

public class XeOTOService {

    List<XeOTO> xeList = new ArrayList<XeOTO>();

    public XeOTOService() {
        xeList.add(new XeOTO(1, "MayBack1", 1000, "Khong"));
        xeList.add(new XeOTO(2, "MayBack2", 2000, "Khong"));
        xeList.add(new XeOTO(3, "MayBack3", 3000, "Khong"));
    }

    public void addXeOTO(XeOTO xe) {
        xeList.add(xe);
    }

    public void updateXeOTO(XeOTO xe, int id) {
        for (int i = 0; i < xeList.size(); i++) {
            if (xeList.get(i).getId() == id) {
                xeList.set(i, xe);
                return;
            }
        }
    }

    public void deleteXeOTO(int id) {
        xeList.removeIf(xe -> xe.getId() == id);
    }

    public XeOTO searchXeOTO(int id) {
        return xeList.stream().filter(xe -> xe.getId() == id).findFirst().orElse(null);
    }

    public List<XeOTO> getAll() {
        return xeList;
    }
}
