package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.sql.*;

/**
 * Created by EOnegin on 22.08.2017.
 */
public class DbConnectionTest {

  @Test
  public void testDbConnection() {
    Connection conn = null;
    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?user=root&password=&serverTimezone=UTC");

      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("select group_id, group_name, group_header, group_footer from group_list");
      Groups groups = new Groups();
      while (rs.next()) {
        groups.add(new GroupData().withId(rs.getInt("group_id")).withName(rs.getString("group_name"))
                .withHeader(rs.getString("group_header")).withFooter(rs.getString("group_footer")));
      }
      rs.close();
      st.close();

      System.out.println(groups);

      Statement stc = conn.createStatement();
      ResultSet rsc = stc.executeQuery("select id, firstname, middlename, lastname, nickname, title, company from addressbook");
      Contacts contacts = new Contacts();
      while (rsc.next()) {
        contacts.add(new ContactData().withId(rsc.getInt("id")).withFirstname(rsc.getString("firstname"))
                .withMiddlename(rsc.getString("middlename")).withLastname(rsc.getString("lastname")).withNickname(rsc.getString("nickname"))
                .withTitle(rsc.getString("title")).withCompany(rsc.getString("company")));
      }
      rsc.close();
      st.close();

      System.out.println(contacts);

      conn.close();

    } catch (SQLException ex) {
      // handle any errors
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());

    }
  }
}

