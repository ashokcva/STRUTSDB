/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
public class NewStrutsAction2 extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        NewStrutsActionForm2 obj = (NewStrutsActionForm2) form;

    String name, password;

    name = obj.getEmail();
    password = obj.getPassword();

    try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3366/employee_db", "root", "");
            Statement st = con.createStatement();
            String s = "SELECT * FROM REGISTER WHERE EMAIL ='"+name+"' AND PASSWORD ='"+password+"'";
            
            ResultSet rs = st.executeQuery(s);
            if(rs.next())
            {
                request.setAttribute("msg", "Welcome "+name);
                return mapping.findForward("welcome");
            }
            else
            {
                request.setAttribute("errormsg", "UNKNOWN USER!");
                return mapping.findForward("wrong");
            }
            
    }

    catch(Exception e)
    {
        request.setAttribute("errormsg", e+"");
        return mapping.findForward("wrong");
    }
        
        //return mapping.findForward(SUCCESS);
    }
}
