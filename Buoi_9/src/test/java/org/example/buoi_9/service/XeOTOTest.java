package org.example.buoi_9.service;

import org.example.buoi_9.entity.XeOTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class XeOTOTest {

    XeOTOService service;

    @BeforeEach
    public void setup() {
        service = new XeOTOService();
    }

    @Test
    public void testAddValid() {
        XeOTO xe = new XeOTO(1, "MayBack", 1000, "Khong");
        service.addXeOTO(xe);
        assertEquals(4, service.getAll().size());
    }

    @Test
    public void updateValid() {
        XeOTO xe = new XeOTO(4, "MayBack" , 1000 , "Khong");
        service.addXeOTO(xe);
        XeOTO xe4 = new XeOTO(4, "MayBack" , 1000000 , "Khong");
        service.updateXeOTO(xe4, 4);
        assertEquals(1000000, service.getAll().get(3).getGia());
    }

    @Test
    public void deleteValid() {
        XeOTO xe = new XeOTO(4, "MayBack" , 1000 , "Khong");
        service.addXeOTO(xe);
        int sizeBefore = service.getAll().size();
        service.deleteXeOTO(4);
        int sizeAfter = service.getAll().size();
        assertEquals(sizeBefore - 1, sizeAfter);
    }

    @Test
    public void deleteInValid() {
        XeOTO xe = new XeOTO(4, "MayBack" , 1000 , "Khong");
        service.addXeOTO(xe);
        int sizeBefore = service.getAll().size();
        service.deleteXeOTO(4);
        int sizeAfter = service.getAll().size();
        assertEquals(3 , sizeAfter);
    }

    @Test
    public void testSearchXeOtoValid() {
        XeOTO xe = new XeOTO(4, "MayBack" , 1000 , "Khong");
        service.addXeOTO(xe);

        XeOTO foundXeOTO = service.searchXeOTO(4);

        assertEquals(4, foundXeOTO.getId());
    }

    @Test
    public void testSearchXeOtoInValid() {
        XeOTO xe = new XeOTO(4, "MayBack" , 1000 , "Khong");
        service.addXeOTO(xe);

        XeOTO foundXeOTO = service.searchXeOTO(5);

        assertNull(foundXeOTO);
    }

}