import java.awt.datatransfer.StringSelection;
import java.sql.*;

public class DBConnect {
         //Veri tabanına bağlantı İkinci yol
    public static final String DB_URL="jdbc:mysql://localhost/university";
    public static final String DB_USER="root";
    public static final String DB_PASSWORD="agabey";

    public static void main(String[] args) {

        Connection connect=null;



        //*******************************************************************
        //---------------------------------------------------------------
               //Veri tabanı tablo kayıt silme
        String stSql="DELETE FROM student WHERE student_id=4 ";
        String prSql="DELETE FROM student WHERE student_id=?";



           //*****************************************************************
        //-----------------------------------------------------------
           /*    //Veri tabanı tablo Güncelleme Yapmak
        String stSql = "Update student SET student_name='Mustafa akin' WHERE student_id=1";
        String prSql = "Update student SET student_name=? WHERE student_id=?";

            */
        //-----------------------------------------------------------
        //*****************************************************************


        //------------------------------------------------------
                         //Veri tabanına bağlantı Birinci yol
       /*
        String sql="SELECT*FROM student";
        String url="jdbc:mysql://localhost/university?user =root&password=agabey";
        */
        //---------------------------------------------------------
        //********************************************************




        //------------------------------------------------------------
                       //Veri tabanı tablo Ekleme İkinci yol
       /*
        //Statement ile insert İşlemi
        String insertSql= "INSERT INTO student(Student_name,student_class) VALUES('Damla',4)";
        String prSql= "INSERT INTO student(Student_name,student_class) VALUES(?,?)";

        */
        //-----------------------------------------------------------------
        //******************************************************************



        try {
            connect= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);


            //***********************************************************
            //------------------------------------------------------------
            Statement st=connect.createStatement();
            st.executeUpdate(stSql);

            PreparedStatement pr=connect.prepareStatement(prSql);
            pr.setInt(1,3);
            pr.executeUpdate();
            st.close();
            pr.close();
            connect.close();



            //***********************************************************
            //------------------------------------------------------------
          /*
          //Veri tabanı tablo Güncelleme Birinci yol

           Statement st=connect.createStatement();
            //Geriye ResultSet döndürmek istemiyoruz.
            st.executeUpdate(stSql);

           */
             /*
            //Veri tabanı tablo Güncelleme İkinci yol
            PreparedStatement pr=connect.prepareStatement(prSql);
            pr.setInt(2,1);
            pr.setString(1,"Mustafa Murat");
            pr.executeUpdate();


              */
            //--------------------------------------------------------
            //***********************************************************





            //****************************************************************

            //--------------------------------------------------------------
                      //Veri tabanı tablo Ekleme İkinci yol
            /*
            //#############################################
           // st=connect.createStatement();
            //Çekme işlem yapmak için executeUpdate kullandık.
           // System.out.println(st.executeUpdate(insertSql));
           //################################################



            //Hazırlanmış Statement . Kendimiz değer atayabiliyoruz.

            PreparedStatement prSt=connect.prepareStatement(prSql);
            prSt.setInt(2,5);
            prSt.setString(1,"Ahmet");
            //İşlemi gerçekleştirmek için execudeUpdate
            prSt.executeUpdate();
            //Arka planda sürekli çalışmasını önlemek için Close yapıyoruz.
            prSt.close();
            */
            //--------------------------------------------------------------------
            //********************************************************************



            //--------------------------------------------------------------------------
                                    //Veri tabanı tablo Ekleme Birinci yol
            /*
            connect= DriverManager.getConnection(url);
            st=connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet data = st.executeQuery(sql);

           while (data.next()){
                System.out.println("ID : "+data.getInt("student_id"));
                System.out.println("AD : "+data.getString("student_name"));
                System.out.println("SINIF : "+data.getInt("student_class"));
                System.out.println("-------------------------");
            }

            data.next();
            data.next();
            data.first();
            System.out.println(data.getString("student_name"));

             */
            //-------------------------------------------------------------------------

            //*************************************************************************

        }catch (SQLException e){
            System.out.println(e.getMessage());

        }
    }
}
