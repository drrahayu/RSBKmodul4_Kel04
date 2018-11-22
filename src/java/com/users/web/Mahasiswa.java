package com.users.web;

import com.users.web.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Hayu
 */
@ManagedBean
@RequestScoped
public class Mahasiswa {

    /**
     * Creates a new instance of Mahasiswa
     */
    
    private String NIM;
    public void setNIM(String NIM) {
        this.NIM = NIM;
    }
    public String getNIM() {
        return NIM;
    }

    private String NAMA;
    public void setNAMA(String NAMA) {
        this.NAMA = NAMA;
    }
    public String getNAMA() {
        return NAMA;
    }
    
    private String SEMESTER;
    public void setSEMESTER(String SEMESTER) {
        this.SEMESTER = SEMESTER;
    }
    public String getSEMESTER() {
        return SEMESTER;
    }
    private String ID_MINAT;
    public void setID_MINAT(String ID_MINAT) {
        this.ID_MINAT = ID_MINAT;
    }
    public String getID_MINAT() {
        return ID_MINAT;
    }
    
    private String NAMA_PEMINATAN;
    public void setNAMA_PEMINATAN(String NAMA_PEMINATAN) {
        this.NAMA_PEMINATAN = NAMA_PEMINATAN;
    }
    public String getNAMA_PEMINATAN() {
        return NAMA_PEMINATAN;
    }
    
    private String LAB;
    public void setLAB(String LAB) {
        this.LAB = LAB;
    }
    public String getLAB() {
        return LAB;
    }
   
    private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap(); 

public String Edit_Mahasiswa(){
     FacesContext fc = FacesContext.getCurrentInstance();
     Map<String,String > params = fc.getExternalContext().getRequestParameterMap();
     String Field_NIM = params.get("action");
     try {
          Koneksi obj_koneksi = new Koneksi();
          Connection connection = obj_koneksi.get_connection();
          Statement st = connection.createStatement();
          ResultSet rs = st.executeQuery("select * from mahasiswa where NIM="+Field_NIM);
          Mahasiswa obj_Mahasiswa = new Mahasiswa();
          rs.next();
          obj_Mahasiswa.setNIM(rs.getString("NIM"));
          obj_Mahasiswa.setNAMA(rs.getString("Nama"));
          obj_Mahasiswa.setSEMESTER(rs.getString("semester"));
          obj_Mahasiswa.setID_MINAT(rs.getString("id_minat"));
          sessionMap.put("EditMahasiswa", obj_Mahasiswa);  
      } catch (Exception e) {
            System.out.println(e);
      }
     return "/Edit.xhtml?faces-redirect=true";   
}

public String Delete_Mahasiswa(){
      FacesContext fc = FacesContext.getCurrentInstance();
      Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
      String Field_NIM = params.get("action");
      try {
         Koneksi obj_koneksi = new Koneksi();
         Connection connection = obj_koneksi.get_connection();
         PreparedStatement ps = connection.prepareStatement("delete from mahasiswa where NIM=?");
         ps.setString(1, Field_NIM);
         System.out.println(ps);
         ps.executeUpdate();
        } catch (Exception e) {
         System.out.println(e);
        }
       return "/index.xhtml?faces-redirect=true";   
}

public String Update_Mahasiswa(){
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
	String Update_NIM= params.get("Update_NIM");
        try {
            Koneksi obj_koneksi = new Koneksi();
            Connection connection = obj_koneksi.get_connection();
            PreparedStatement ps = connection.prepareStatement("update mahasiswa set NIM=?, Nama=?, Penjurusan=? where NIM=?");
            ps.setString(1, NIM);
            ps.setString(2, NAMA);
            ps.setString(3, SEMESTER);
            ps.setString(4, ID_MINAT);
            ps.setString(5, Update_NIM);
            System.out.println(ps);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
       return "/index.xhtml?faces-redirect=true";   
}
    
    public ArrayList getGet_all_mahasiswa() throws Exception{
        ArrayList list_of_mahasiswa=new ArrayList();
             Connection connection=null;
        try {
            Koneksi obj_koneksi = new Koneksi();
            connection = obj_koneksi.get_connection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("Select * from mahasiswa");
            while(rs.next()){
                Mahasiswa obj_Mahasiswa = new Mahasiswa();
                obj_Mahasiswa.setNIM(rs.getString("NIM"));
                obj_Mahasiswa.setNAMA(rs.getString("Nama"));
                obj_Mahasiswa.setNAMA_PEMINATAN(rs.getString("nama_peminatan"));
                list_of_mahasiswa.add(obj_Mahasiswa);
            }
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            if(connection!=null){
                connection.close();
            }
        }
        return list_of_mahasiswa;
}
    
public ArrayList getGet_all_mahasiswa1() throws Exception{
        ArrayList list_of_mahasiswa=new ArrayList();
             Connection connection=null;
        try {
            Koneksi obj_koneksi = new Koneksi();
            connection = obj_koneksi.get_connection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("Select * from mahasiswa");
            while(rs.next()){
                Mahasiswa obj_Mahasiswa = new Mahasiswa();
                obj_Mahasiswa.setNIM(rs.getString("NIM"));
                obj_Mahasiswa.setNAMA(rs.getString("Nama"));
                obj_Mahasiswa.setSEMESTER(rs.getString("Penjurusan"));
                obj_Mahasiswa.setPEMINATAN(rs.getString("id_minat"));
                list_of_mahasiswa.add(obj_Mahasiswa);
            }
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            if(connection!=null){
                connection.close();
            }
        }
        return list_of_mahasiswa;
}
    
    public ArrayList getGet_all_peminatan() throws Exception{
        ArrayList list_of_mahasiswa=new ArrayList();
             Connection connection=null;
        try {
            Koneksi obj_koneksi = new Koneksi();
            connection = obj_koneksi.get_connection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("Select * from peminatan");
            while(rs.next()){
                Mahasiswa obj_Mahasiswa = new Mahasiswa();
                obj_Mahasiswa.setPEMINATAN(rs.getString("id_minat"));
                obj_Mahasiswa.setNAMA_PEMINATAN(rs.getString("nama_peminatan"));
                obj_Mahasiswa.setLAB(rs.getString("lab"));
                list_of_mahasiswa.add(obj_Mahasiswa);
            }
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            if(connection!=null){
                connection.close();
            }
        }
        return list_of_mahasiswa;
}
    
public String Tambah_Mahasiswa(){
        try {
            Connection connection=null;
            Koneksi obj_koneksi = new Koneksi();
            connection = obj_koneksi.get_connection();
            PreparedStatement ps=connection.prepareStatement("insert into mahasiswa(NIM, Nama, semester, id_minat) "
                    + "value('"+NIM+"','"+NAMA+"','"+SEMESTER+"','"+ID_MINAT+"')");
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return "/index.xhtml?faces-redirect=true";
    }

public String Tambah_Peminatan (){
        try {
            Connection connection=null;
            Koneksi obj_koneksi = new Koneksi();
            connection = obj_koneksi.get_connection();
            PreparedStatement ps=connection.prepareStatement("INSERT INTO `peminatan`(`id_minat`, `nama_peminatan`, `lab`) "
                    + "value('"+ID_MINAT+"','"+NAMA_PEMINATAN+"','"+LAB+"')");
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return "/index.xhtml?faces-redirect=true";
    }

public String Delete_Peminatan(){
      FacesContext fc = FacesContext.getCurrentInstance();
      Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
      String Field_NIM = params.get("action");
      try {
         Koneksi obj_koneksi = new Koneksi();
         Connection connection = obj_koneksi.get_connection();
         PreparedStatement ps = connection.prepareStatement("delete from peminatan where id_minat=?");
         ps.setString(1, Field_NIM);
         System.out.println(ps);
         ps.executeUpdate();
        } catch (Exception e) {
         System.out.println(e);
        }
       return "/index.xhtml?faces-redirect=true";   
}

public String Edit_Peminatan(){
     FacesContext fc = FacesContext.getCurrentInstance();
     Map<String,String > params = fc.getExternalContext().getRequestParameterMap();
     String Field_NIM = params.get("action");
     try {
          Koneksi obj_koneksi = new Koneksi();
          Connection connection = obj_koneksi.get_connection();
          Statement st = connection.createStatement();
          ResultSet rs = st.executeQuery("select * from peminatan where id_minat="+Field_NIM);
          Mahasiswa obj_Mahasiswa = new Mahasiswa();
          rs.next();
          obj_Mahasiswa.setPEMINATAN(rs.getString("id_minat"));
          obj_Mahasiswa.setNAMA_PEMINATAN(rs.getString("nama_peminatan"));
          obj_Mahasiswa.setLAB(rs.getString("lab"));
          sessionMap.put("Editpeminatan", obj_Mahasiswa);  
      } catch (Exception e) {
            System.out.println(e);
      }
     return "/editpeminatan.xhtml?faces-redirect=true";   
}
public String Update_Peminatan(){
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
	String Update_NIM= params.get("Update_NIM");
        try {
            Koneksi obj_koneksi = new Koneksi();
            Connection connection = obj_koneksi.get_connection();
            PreparedStatement ps = connection.prepareStatement("update peminatan set id_minat=?, nama_peminatan=?,lab=? where id_minat=?");
            ps.setString(1, ID_MINAT);
            ps.setString(2, NAMA_PEMINATAN);
            ps.setString(3,LAB);
            ps.setString(4, Update_NIM);
            System.out.println(ps);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
       return "/index.xhtml?faces-redirect=true";   
}
    public Mahasiswa() {
    }

    private void setPEMINATAN(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}