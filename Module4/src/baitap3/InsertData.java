/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap3;



/**
 *
 * @author duong nhung
 */
public class InsertData {
    private DatabaseHelper helper;

    public InsertData() {
        helper = new DatabaseHelper();
    }

    public void insertData_TacGia() {
        String query = "insert into TacGia values\n"
                + "('TG001','Ha Quang Huy','Tu Liem-HN'),"
                + "('TG002','Pham Mi Linh','Hai Ba Trung-HN'),"
                + "('TG003','Tra Minh Truong','Hoang Mai-HN')";
                
        helper.doSQL(query);
    }
    
    public void insertData_Sach() {
        String query = "insert into Sach values\n"
                + "('S001','Giao trinh Photoshop','60',(SELECT MaTG From TacGia Where MaTG='TG001'),2010,'Photoshop','DHCNHN'),"
                + "('S002','Giao trinh Tin Hoc','60',(SELECT MaTG From TacGia Where MaTG='TG002'),2019,'Tin Hoc','DHCNHN'),"
                + "('S003','Giao trinh SQL','60',(SELECT MaTG From TacGia Where MaTG='TG003'),2016,'SQL','DHCNHN')";
 
        helper.doSQL(query);
    }
       public void insertData_ChiTietSach() {
        String query = "insert into ChiTietSach values\n"
                + "((SELECT MaSach From Sach Where MaSach='S001'),'Sach1',9,7),"
                + "((SELECT MaSach From Sach Where MaSach='S002'),'Sach2',7,7),"
                + "((SELECT MaSach From Sach Where MaSach='S003'),'Sach3',5,7)";
 
        helper.doSQL(query);
    }
          public void insertData_SachTG() {
        String query = "insert into SachTG values\n"
                + "('S001',(SELECT MaTG From TacGia Where MaTG='TG001')),"
                + "('S002',(SELECT MaTG From TacGia Where MaTG='TG002')),"
                + "('S003',(SELECT MaTG From TacGia Where MaTG='TG003'))";
 
        helper.doSQL(query);
    }
             public void insertData_DocGia() {
        String query = "insert into SachTG values\n"
                + "('2018604444','Nguyen Quang Dat','DHCNHN'),"
                + "('2018604443','Nguyen Phuong Anh','DHCNHN'),"
                +  "('2018604441','Nguyen Anh Tu','DHCNHN')";
 
        helper.doSQL(query);
    } 
             public void insertData_SachMuon() {
        String query = "insert into SachMuon values\n"
                + "('2018604444','Sach1','12/5/2021','12/7/2021','10/7/2021'),"
                +"('2018604444','Sach2','12/5/2021','12/7/2021','10/7/2021'),"
                + "('2018604443','Sach3','12/5/2021','12/7/2021','10/7/2021'),"
                +"('2018604441','Sach1','12/5/2021','12/7/2021','10/7/2021'),";
        helper.doSQL(query);
    }       
          
}
