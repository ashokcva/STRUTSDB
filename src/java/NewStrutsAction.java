/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
/**
 *
 * @author Ashok
 */
public class NewStrutsAction extends org.apache.struts.action.Action {
 
private static final String SUCCESS = "success";
 
@Override
public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
NewStrutsActionForm obj = (NewStrutsActionForm) form;
//define two variable to get value from jsp through NewStrutsActionForm
String name,email,password;
//Initialize value using object

name = obj.getName();
email = obj.getEmail();
password = obj.getPassword();

    try {
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db", "root", "");
Statement st = con.createStatement();
if (name.length() != 0 && email.length() != 0 && password.length()!=0 ) {
int m = st.executeUpdate("insert into register values('" + name + "','" + email +"','"+password+"')");
if (m > 0) {
// This is send forward message to struts-config.xml for further process
// You can pass any message instead of "okay"
 
request.setAttribute("msg", m+" Record added");
return mapping.findForward("login");
}
} else {
request.setAttribute("errormsg", "Null Value!");
return mapping.findForward("wrong");
}
} catch (Exception e) {
request.setAttribute("errormsg", "" + e.getMessage());
//this message (wrong) will pass to struts-config.xml if any exception will ocuur
return mapping.findForward("wrong");
}
 


return mapping.findForward(SUCCESS);
}

}